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
    private long hoY;
    private long hoZ;
    public long mCB;
    public List<AlaRecommendLiveData> mCG;
    public List<AlaRecommendLiveData> mCH;
    private HttpMessageListener mCJ;
    private Runnable oaA;
    private a oaz;

    /* loaded from: classes4.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hoY = System.currentTimeMillis();
        this.hoZ = 0L;
        this.mCJ = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.oaz != null) {
                            b.this.oaz.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.YM;
                        int i4 = aVar.mCD;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.mCG = new ArrayList();
                        b.this.mCH = new ArrayList();
                    } else {
                        if (b.this.mCG == null) {
                            b.this.mCG = new ArrayList();
                        }
                        if (b.this.mCH == null) {
                            b.this.mCH = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.oaC != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oaC.list)) {
                        b.this.mCG.addAll(alaRecommendLiveResponseMessage.oaC.list);
                    }
                    if (alaRecommendLiveResponseMessage.oaD != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oaD.list)) {
                        b.this.mCH.addAll(alaRecommendLiveResponseMessage.oaD.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.oaD.jsm == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mCG != null && !b.this.mCG.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mCG.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.mCG.size(); i5 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.oax = b.this.mCG.get(i5);
                            if (i5 + 1 < b.this.mCG.size()) {
                                aVar2.oay = b.this.mCG.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mCH != null && !b.this.mCH.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.mCH.size(); i6 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.oax = b.this.mCH.get(i6);
                            if (i6 + 1 < b.this.mCH.size()) {
                                aVar3.oay = b.this.mCH.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.oaz != null) {
                        b.this.oaz.h(arrayList, ListUtils.getCount(b.this.mCG), i);
                    }
                }
            }
        };
        this.oaA = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mCB = 0L;
            }
        };
        dBw();
        MessageManager.getInstance().registerListener(this.mCJ);
    }

    private static void dBw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void x(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hoZ >= 1800000) {
            this.hoY = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mCD = i;
        if (i == 0) {
            this.mCB = 0L;
        }
        if (this.mCB == 0) {
            this.mCB = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.oaA, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mCB = this.mCB;
        aVar.hoY = this.hoY;
        aVar.YM = i;
        aVar.mCC = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hoZ = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.mCB = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mCG = null;
        this.mCH = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bBm() {
        return (this.mCG == null || this.mCG.isEmpty()) && (this.mCH == null || this.mCH.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mCJ);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.oaz = null;
    }

    public void a(a aVar) {
        this.oaz = aVar;
    }
}
