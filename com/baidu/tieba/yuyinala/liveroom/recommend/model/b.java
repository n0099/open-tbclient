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
    private long hMf;
    private long hMg;
    public Handler handler;
    public boolean hasMore;
    public long iii;
    private HttpMessageListener ndB;
    public List<AlaRecommendLiveData> ndy;
    public List<AlaRecommendLiveData> ndz;
    private a oAH;
    private Runnable oAI;

    /* loaded from: classes10.dex */
    public interface a {
        void h(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.handler = new Handler();
        this.duration = 1800000L;
        this.hMf = System.currentTimeMillis();
        this.hMg = 0L;
        this.ndB = new HttpMessageListener(1031053) { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031053 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.oAH != null) {
                            b.this.oAH.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i2 = aVar.abG;
                        i = aVar.ndv;
                    }
                    if (i2 == 0) {
                        b.this.ndy = new ArrayList();
                        b.this.ndz = new ArrayList();
                    } else {
                        if (b.this.ndy == null) {
                            b.this.ndy = new ArrayList();
                        }
                        if (b.this.ndz == null) {
                            b.this.ndz = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.oAK != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oAK.list)) {
                        b.this.ndy.addAll(alaRecommendLiveResponseMessage.oAK.list);
                    }
                    if (alaRecommendLiveResponseMessage.oAL != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.oAL.list)) {
                        b.this.ndz.addAll(alaRecommendLiveResponseMessage.oAL.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.oAL.jYt == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.ndy != null && !b.this.ndy.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.ndy.size();
                        arrayList.add(cVar);
                        for (int i3 = 0; i3 < b.this.ndy.size(); i3 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar2 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar2.type = 0;
                            aVar2.oAF = b.this.ndy.get(i3);
                            if (i3 + 1 < b.this.ndy.size()) {
                                aVar2.oAG = b.this.ndy.get(i3 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.ndz != null && !b.this.ndz.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i4 = 0; i4 < b.this.ndz.size(); i4 += 2) {
                            com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar3 = new com.baidu.tieba.yuyinala.liveroom.recommend.data.a();
                            aVar3.type = 1;
                            aVar3.oAF = b.this.ndz.get(i4);
                            if (i4 + 1 < b.this.ndz.size()) {
                                aVar3.oAG = b.this.ndz.get(i4 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.oAH != null) {
                        b.this.oAH.h(arrayList, ListUtils.getCount(b.this.ndy), i);
                    }
                }
            }
        };
        this.oAI = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.model.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iii = 0L;
            }
        };
        dFg();
        MessageManager.getInstance().registerListener(this.ndB);
    }

    private static void dFg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031053, com.baidu.live.a.axj + "ala/audio/recommend/followedRoom");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void z(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hMg >= 1800000) {
            this.hMf = currentTimeMillis;
        }
        com.baidu.tieba.yuyinala.liveroom.recommend.model.a aVar = new com.baidu.tieba.yuyinala.liveroom.recommend.model.a();
        aVar.ndv = i;
        if (i == 0) {
            this.iii = 0L;
        }
        if (this.iii == 0) {
            this.iii = System.currentTimeMillis();
            i = 0;
            this.handler.removeCallbacksAndMessages(null);
            this.handler.postDelayed(this.oAI, this.duration);
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.iii = this.iii;
        aVar.hMf = this.hMf;
        aVar.abG = i;
        aVar.ndu = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
        this.hMg = currentTimeMillis;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.iii = 0L;
        this.handler.removeCallbacksAndMessages(null);
        this.ndy = null;
        this.ndz = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.ndy == null || this.ndy.isEmpty()) && (this.ndz == null || this.ndz.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ndB);
        cancelMessage();
        this.handler.removeCallbacksAndMessages(null);
        this.oAH = null;
    }

    public void a(a aVar) {
        this.oAH = aVar;
    }
}
