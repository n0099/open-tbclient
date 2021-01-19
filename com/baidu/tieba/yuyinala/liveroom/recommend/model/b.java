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
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    public long duration;
    private long hFW;
    private long hFX;
    public Handler handler;
    public boolean hasMore;
    public long ibN;
    private HttpMessageListener mRA;
    public List<AlaRecommendLiveData> mRx;
    public List<AlaRecommendLiveData> mRy;
    private a oom;
    private Runnable oon;

    /* loaded from: classes10.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hFW = System.currentTimeMillis();
        this.hFX = 0L;
        this.mRA = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.oom != null) {
                            b.this.oom.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i2 = aVar.aaq;
                        i = aVar.mRu;
                    }
                    if (i2 == 0) {
                        b.this.mRx = new ArrayList();
                        b.this.mRy = new ArrayList();
                    } else {
                        if (b.this.mRx == null) {
                            b.this.mRx = new ArrayList();
                        }
                        if (b.this.mRy == null) {
                            b.this.mRy = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.oop != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oop.list)) {
                        b.this.mRx.addAll(alaRecommendLiveResponseMessage.oop.list);
                    }
                    if (alaRecommendLiveResponseMessage.ooq != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.ooq.list)) {
                        b.this.mRy.addAll(alaRecommendLiveResponseMessage.ooq.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.ooq.jOB == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mRx != null && !b.this.mRx.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.mRx.size();
                        arrayList.add(cVar);
                        for (int i3 = 0; i3 < b.this.mRx.size(); i3 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.ook = b.this.mRx.get(i3);
                            if (i3 + 1 < b.this.mRx.size()) {
                                aVar2.ool = b.this.mRx.get(i3 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.mRy != null && !b.this.mRy.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i4 = 0; i4 < b.this.mRy.size(); i4 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.ook = b.this.mRy.get(i4);
                            if (i4 + 1 < b.this.mRy.size()) {
                                aVar3.ool = b.this.mRy.get(i4 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.oom != null) {
                        b.this.oom.h(arrayList, ListUtils.getCount(b.this.mRx), i);
                    }
                }
            }
        };
        this.oon = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ibN = 0L;
            }
        };
        dCG();
        MessageManager.getInstance().registerListener(this.mRA);
    }

    private static void dCG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, com.baidu.live.a.avU + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void B(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hFX >= 1800000) {
            this.hFW = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.mRu = i;
        if (i == 0) {
            this.ibN = 0L;
        }
        if (this.ibN == 0) {
            this.ibN = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.oon, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.ibN = this.ibN;
        aVar.hFW = this.hFW;
        aVar.aaq = i;
        aVar.mRt = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hFX = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.ibN = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.mRx = null;
        this.mRy = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.mRx == null || this.mRx.isEmpty()) && (this.mRy == null || this.mRy.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mRA);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.oom = null;
    }

    public void a(a aVar) {
        this.oom = aVar;
    }
}
