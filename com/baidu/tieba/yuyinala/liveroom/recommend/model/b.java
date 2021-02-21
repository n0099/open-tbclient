package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import android.os.Handler;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    public long duration;
    private long hKw;
    private long hKx;
    public Handler handler;
    public boolean hasMore;
    public long igz;
    public List<AlaRecommendLiveData> nbu;
    public List<AlaRecommendLiveData> nbv;
    private HttpMessageListener nbx;
    private a oyC;
    private Runnable oyD;

    /* loaded from: classes11.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hKw = System.currentTimeMillis();
        this.hKx = 0L;
        this.nbx = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.oyC != null) {
                            b.this.oyC.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    AlaRecommendLiveResponseMessage alaRecommendLiveResponseMessage = (AlaRecommendLiveResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.yuyinala.liveroom.recommend.model.a)) {
                        i = 0;
                        i2 = 0;
                    } else {
                        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = (com.baidu.tieba.yuyinala.liveroom.recommend.model.a) httpResponsedMessage.getOrginalMessage();
                        i2 = aVar.aam;
                        i = aVar.nbr;
                    }
                    if (i2 == 0) {
                        b.this.nbu = new ArrayList();
                        b.this.nbv = new ArrayList();
                    } else {
                        if (b.this.nbu == null) {
                            b.this.nbu = new ArrayList();
                        }
                        if (b.this.nbv == null) {
                            b.this.nbv = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.oyF != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oyF.list)) {
                        b.this.nbu.addAll(alaRecommendLiveResponseMessage.oyF.list);
                    }
                    if (alaRecommendLiveResponseMessage.oyG != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oyG.list)) {
                        b.this.nbv.addAll(alaRecommendLiveResponseMessage.oyG.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.oyG.jWr == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.nbu != null && !b.this.nbu.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.nbu.size();
                        arrayList.add(cVar);
                        for (int i3 = 0; i3 < b.this.nbu.size(); i3 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.oyA = b.this.nbu.get(i3);
                            if (i3 + 1 < b.this.nbu.size()) {
                                aVar2.oyB = b.this.nbu.get(i3 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.nbv != null && !b.this.nbv.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i4 = 0; i4 < b.this.nbv.size(); i4 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.oyA = b.this.nbv.get(i4);
                            if (i4 + 1 < b.this.nbv.size()) {
                                aVar3.oyB = b.this.nbv.get(i4 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.oyC != null) {
                        b.this.oyC.h(arrayList, ListUtils.getCount(b.this.nbu), i);
                    }
                }
            }
        };
        this.oyD = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.igz = 0L;
            }
        };
        dEY();
        MessageManager.getInstance().registerListener(this.nbx);
    }

    private static void dEY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, com.baidu.live.a.avJ + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hKx >= 1800000) {
            this.hKw = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.nbr = i;
        if (i == 0) {
            this.igz = 0L;
        }
        if (this.igz == 0) {
            this.igz = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.oyD, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.igz = this.igz;
        aVar.hKw = this.hKw;
        aVar.aam = i;
        aVar.nbq = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hKx = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.igz = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.nbu = null;
        this.nbv = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.nbu == null || this.nbu.isEmpty()) && (this.nbv == null || this.nbv.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nbx);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.oyC = null;
    }

    public void a(a aVar) {
        this.oyC = aVar;
    }
}
