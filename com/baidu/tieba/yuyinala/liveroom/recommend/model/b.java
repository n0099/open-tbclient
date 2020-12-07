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
    public long hTW;
    public Handler handler;
    public boolean hasMore;
    private long hyC;
    private long hyD;
    public List<AlaRecommendLiveData> mQH;
    public List<AlaRecommendLiveData> mQI;
    private HttpMessageListener mQK;
    private a opA;
    private Runnable opB;

    /* loaded from: classes4.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hyC = System.currentTimeMillis();
        this.hyD = 0L;
        this.mQK = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.opA != null) {
                            b.this.opA.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i4 = aVar.mQE;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.mQH = new ArrayList();
                        b.this.mQI = new ArrayList();
                    } else {
                        if (b.this.mQH == null) {
                            b.this.mQH = new ArrayList();
                        }
                        if (b.this.mQI == null) {
                            b.this.mQI = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.opD != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.opD.list)) {
                        b.this.mQH.addAll(alaRecommendLiveResponseMessage.opD.list);
                    }
                    if (alaRecommendLiveResponseMessage.opE != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.opE.list)) {
                        b.this.mQI.addAll(alaRecommendLiveResponseMessage.opE.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.opE.jFM == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mQH != null && !b.this.mQH.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mQH.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.mQH.size(); i5 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.opy = b.this.mQH.get(i5);
                            if (i5 + 1 < b.this.mQH.size()) {
                                aVar2.opz = b.this.mQH.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mQI != null && !b.this.mQI.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.mQI.size(); i6 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.opy = b.this.mQI.get(i6);
                            if (i6 + 1 < b.this.mQI.size()) {
                                aVar3.opz = b.this.mQI.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.opA != null) {
                        b.this.opA.h(arrayList, ListUtils.getCount(b.this.mQH), i);
                    }
                }
            }
        };
        this.opB = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.hTW = 0L;
            }
        };
        dGH();
        MessageManager.getInstance().registerListener(this.mQK);
    }

    private static void dGH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hyD >= 1800000) {
            this.hyC = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mQE = i;
        if (i == 0) {
            this.hTW = 0L;
        }
        if (this.hTW == 0) {
            this.hTW = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.opB, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.hTW = this.hTW;
        aVar.hyC = this.hyC;
        aVar.ZJ = i;
        aVar.mQD = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hyD = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.hTW = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mQH = null;
        this.mQI = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bEO() {
        return (this.mQH == null || this.mQH.isEmpty()) && (this.mQI == null || this.mQI.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mQK);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.opA = null;
    }

    public void a(a aVar) {
        this.opA = aVar;
    }
}
