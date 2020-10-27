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
    public Handler handler;
    public boolean hasMore;
    private long hjA;
    private long hjB;
    public long mwg;
    public List<AlaRecommendLiveData> mwl;
    public List<AlaRecommendLiveData> mwm;
    private HttpMessageListener mwo;
    private a nRJ;
    private Runnable nRK;

    /* loaded from: classes4.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hjA = System.currentTimeMillis();
        this.hjB = 0L;
        this.mwo = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.nRJ != null) {
                            b.this.nRJ.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.YH;
                        int i4 = aVar.mwi;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.mwl = new ArrayList();
                        b.this.mwm = new ArrayList();
                    } else {
                        if (b.this.mwl == null) {
                            b.this.mwl = new ArrayList();
                        }
                        if (b.this.mwm == null) {
                            b.this.mwm = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.nRM != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nRM.list)) {
                        b.this.mwl.addAll(alaRecommendLiveResponseMessage.nRM.list);
                    }
                    if (alaRecommendLiveResponseMessage.nRN != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nRN.list)) {
                        b.this.mwm.addAll(alaRecommendLiveResponseMessage.nRN.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.nRN.jlH == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mwl != null && !b.this.mwl.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mwl.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.mwl.size(); i5 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.nRH = b.this.mwl.get(i5);
                            if (i5 + 1 < b.this.mwl.size()) {
                                aVar2.nRI = b.this.mwl.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mwm != null && !b.this.mwm.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.mwm.size(); i6 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.nRH = b.this.mwm.get(i6);
                            if (i6 + 1 < b.this.mwm.size()) {
                                aVar3.nRI = b.this.mwm.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.nRJ != null) {
                        b.this.nRJ.h(arrayList, ListUtils.getCount(b.this.mwl), i);
                    }
                }
            }
        };
        this.nRK = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mwg = 0L;
            }
        };
        dzq();
        MessageManager.getInstance().registerListener(this.mwo);
    }

    private static void dzq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hjB >= 1800000) {
            this.hjA = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mwi = i;
        if (i == 0) {
            this.mwg = 0L;
        }
        if (this.mwg == 0) {
            this.mwg = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.nRK, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mwg = this.mwg;
        aVar.hjA = this.hjA;
        aVar.YH = i;
        aVar.mwh = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hjB = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.mwg = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mwl = null;
        this.mwm = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bzx() {
        return (this.mwl == null || this.mwl.isEmpty()) && (this.mwm == null || this.mwm.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mwo);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.nRJ = null;
    }

    public void a(a aVar) {
        this.nRJ = aVar;
    }
}
