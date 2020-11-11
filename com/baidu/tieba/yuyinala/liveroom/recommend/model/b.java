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
    private long hpr;
    private long hps;
    public long mCd;
    public List<AlaRecommendLiveData> mCi;
    public List<AlaRecommendLiveData> mCj;
    private HttpMessageListener mCl;
    private a nYW;
    private Runnable nYX;

    /* loaded from: classes4.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hpr = System.currentTimeMillis();
        this.hps = 0L;
        this.mCl = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.nYW != null) {
                            b.this.nYW.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i4 = aVar.mCf;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.mCi = new ArrayList();
                        b.this.mCj = new ArrayList();
                    } else {
                        if (b.this.mCi == null) {
                            b.this.mCi = new ArrayList();
                        }
                        if (b.this.mCj == null) {
                            b.this.mCj = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.nYZ != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nYZ.list)) {
                        b.this.mCi.addAll(alaRecommendLiveResponseMessage.nYZ.list);
                    }
                    if (alaRecommendLiveResponseMessage.nZa != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nZa.list)) {
                        b.this.mCj.addAll(alaRecommendLiveResponseMessage.nZa.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.nZa.jrF == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mCi != null && !b.this.mCi.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mCi.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.mCi.size(); i5 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.nYU = b.this.mCi.get(i5);
                            if (i5 + 1 < b.this.mCi.size()) {
                                aVar2.nYV = b.this.mCi.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mCj != null && !b.this.mCj.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.mCj.size(); i6 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.nYU = b.this.mCj.get(i6);
                            if (i6 + 1 < b.this.mCj.size()) {
                                aVar3.nYV = b.this.mCj.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.nYW != null) {
                        b.this.nYW.h(arrayList, ListUtils.getCount(b.this.mCi), i);
                    }
                }
            }
        };
        this.nYX = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mCd = 0L;
            }
        };
        dBS();
        MessageManager.getInstance().registerListener(this.mCl);
    }

    private static void dBS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, TbConfig.SERVER_ADDRESS + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void x(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hps >= 1800000) {
            this.hpr = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mCf = i;
        if (i == 0) {
            this.mCd = 0L;
        }
        if (this.mCd == 0) {
            this.mCd = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.nYX, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mCd = this.mCd;
        aVar.hpr = this.hpr;
        aVar.YH = i;
        aVar.mCe = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hps = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.mCd = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mCi = null;
        this.mCj = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bBW() {
        return (this.mCi == null || this.mCi.isEmpty()) && (this.mCj == null || this.mCj.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mCl);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.nYW = null;
    }

    public void a(a aVar) {
        this.nYW = aVar;
    }
}
