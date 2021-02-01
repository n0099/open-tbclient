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
    private long hKi;
    private long hKj;
    public Handler handler;
    public boolean hasMore;
    public long igl;
    public List<AlaRecommendLiveData> naU;
    public List<AlaRecommendLiveData> naV;
    private HttpMessageListener naX;
    private a oyc;
    private Runnable oyd;

    /* loaded from: classes11.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hKi = System.currentTimeMillis();
        this.hKj = 0L;
        this.naX = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.oyc != null) {
                            b.this.oyc.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i = aVar.naR;
                    }
                    if (i2 == 0) {
                        b.this.naU = new ArrayList();
                        b.this.naV = new ArrayList();
                    } else {
                        if (b.this.naU == null) {
                            b.this.naU = new ArrayList();
                        }
                        if (b.this.naV == null) {
                            b.this.naV = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.oyf != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oyf.list)) {
                        b.this.naU.addAll(alaRecommendLiveResponseMessage.oyf.list);
                    }
                    if (alaRecommendLiveResponseMessage.oyg != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oyg.list)) {
                        b.this.naV.addAll(alaRecommendLiveResponseMessage.oyg.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.oyg.jWd == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.naU != null && !b.this.naU.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.naU.size();
                        arrayList.add(cVar);
                        for (int i3 = 0; i3 < b.this.naU.size(); i3 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.oya = b.this.naU.get(i3);
                            if (i3 + 1 < b.this.naU.size()) {
                                aVar2.oyb = b.this.naU.get(i3 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.naV != null && !b.this.naV.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i4 = 0; i4 < b.this.naV.size(); i4 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.oya = b.this.naV.get(i4);
                            if (i4 + 1 < b.this.naV.size()) {
                                aVar3.oyb = b.this.naV.get(i4 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.oyc != null) {
                        b.this.oyc.h(arrayList, ListUtils.getCount(b.this.naU), i);
                    }
                }
            }
        };
        this.oyd = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.igl = 0L;
            }
        };
        dEQ();
        MessageManager.getInstance().registerListener(this.naX);
    }

    private static void dEQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, com.baidu.live.a.avJ + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hKj >= 1800000) {
            this.hKi = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.naR = i;
        if (i == 0) {
            this.igl = 0L;
        }
        if (this.igl == 0) {
            this.igl = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.oyd, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.igl = this.igl;
        aVar.hKi = this.hKi;
        aVar.aam = i;
        aVar.naQ = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hKj = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.igl = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.naU = null;
        this.naV = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.naU == null || this.naU.isEmpty()) && (this.naV == null || this.naV.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.naX);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.oyc = null;
    }

    public void a(a aVar) {
        this.oyc = aVar;
    }
}
