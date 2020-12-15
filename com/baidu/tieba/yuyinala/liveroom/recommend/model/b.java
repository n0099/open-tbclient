package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import android.os.Handler;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    public long duration;
    public long hTY;
    public Handler handler;
    public boolean hasMore;
    private long hyE;
    private long hyF;
    public List<AlaRecommendLiveData> mQJ;
    public List<AlaRecommendLiveData> mQK;
    private HttpMessageListener mQM;
    private a opC;
    private Runnable opD;

    /* loaded from: classes4.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hyE = System.currentTimeMillis();
        this.hyF = 0L;
        this.mQM = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.opC != null) {
                            b.this.opC.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.ZJ;
                        int i4 = aVar.mQG;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.mQJ = new ArrayList();
                        b.this.mQK = new ArrayList();
                    } else {
                        if (b.this.mQJ == null) {
                            b.this.mQJ = new ArrayList();
                        }
                        if (b.this.mQK == null) {
                            b.this.mQK = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.opF != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.opF.list)) {
                        b.this.mQJ.addAll(alaRecommendLiveResponseMessage.opF.list);
                    }
                    if (alaRecommendLiveResponseMessage.opG != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.opG.list)) {
                        b.this.mQK.addAll(alaRecommendLiveResponseMessage.opG.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.opG.jFO == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mQJ != null && !b.this.mQJ.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mQJ.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.mQJ.size(); i5 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.opA = b.this.mQJ.get(i5);
                            if (i5 + 1 < b.this.mQJ.size()) {
                                aVar2.opB = b.this.mQJ.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mQK != null && !b.this.mQK.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.mQK.size(); i6 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.opA = b.this.mQK.get(i6);
                            if (i6 + 1 < b.this.mQK.size()) {
                                aVar3.opB = b.this.mQK.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.opC != null) {
                        b.this.opC.h(arrayList, ListUtils.getCount(b.this.mQJ), i);
                    }
                }
            }
        };
        this.opD = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.hTY = 0L;
            }
        };
        dGI();
        MessageManager.getInstance().registerListener(this.mQM);
    }

    private static void dGI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hyF >= 1800000) {
            this.hyE = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mQG = i;
        if (i == 0) {
            this.hTY = 0L;
        }
        if (this.hTY == 0) {
            this.hTY = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.opD, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.hTY = this.hTY;
        aVar.hyE = this.hyE;
        aVar.ZJ = i;
        aVar.mQF = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hyF = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.hTY = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mQJ = null;
        this.mQK = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bEO() {
        return (this.mQJ == null || this.mQJ.isEmpty()) && (this.mQK == null || this.mQK.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mQM);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.opC = null;
    }

    public void a(a aVar) {
        this.opC = aVar;
    }
}
