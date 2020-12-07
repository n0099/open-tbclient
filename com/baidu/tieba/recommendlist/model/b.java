package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import com.baidu.tieba.recommendlist.data.c;
import com.baidu.tieba.recommendlist.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    public long duration;
    public long hTW;
    public boolean hasMore;
    private a mQG;
    public List<AlaRecommendLiveData> mQH;
    public List<AlaRecommendLiveData> mQI;
    private long mQJ;
    private HttpMessageListener mQK;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mQJ = 0L;
        this.duration = 1800000L;
        this.mQK = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mQG != null) {
                            b.this.mQG.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    AlaRecommendLiveResponseMessage alaRecommendLiveResponseMessage = (AlaRecommendLiveResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.tieba.recommendlist.model.a)) {
                        i = 0;
                        i2 = 0;
                    } else {
                        com.baidu.tieba.recommendlist.model.a aVar = (com.baidu.tieba.recommendlist.model.a) httpResponsedMessage.getOrginalMessage();
                        int i3 = aVar.ZJ;
                        i = aVar.mQE;
                        i2 = i3;
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
                    if (alaRecommendLiveResponseMessage.mQM != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mQM.list)) {
                        b.this.mQH.addAll(alaRecommendLiveResponseMessage.mQM.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mQH != null && !b.this.mQH.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mQH.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mQw = b.this.mQH.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mQN != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mQN.list)) {
                        b.this.mQI.addAll(alaRecommendLiveResponseMessage.mQN.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mQN.jFM == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mQI != null && !b.this.mQI.isEmpty()) {
                        e eVar = new e(1);
                        eVar.title = com.baidu.live.ae.a.RB().RJ();
                        arrayList.add(eVar);
                        for (int i5 = 0; i5 < b.this.mQI.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mQA = b.this.mQI.get(i5);
                            if (i5 + 1 < b.this.mQI.size()) {
                                cVar.mQB = b.this.mQI.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mQG != null) {
                        b.this.mQG.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mQK);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mQE = i;
        if (i == 0) {
            this.hTW = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mQJ >= this.duration) {
            this.hTW = 0L;
        }
        this.mQJ = currentTimeMillis;
        if (this.hTW == 0) {
            this.hTW = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.hTW = this.hTW;
        aVar.ZJ = i;
        aVar.mQD = 1;
        aVar.aRK = i2;
        if (i2 == 1 && i == 1) {
            aVar.mQF = dGI();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dGI() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mQI) && (alaRecommendLiveData = this.mQI.get(this.mQI.size() - 1)) != null) {
            return alaRecommendLiveData.live_id;
        }
        return 0L;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.hTW = 0L;
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
        this.mQG = null;
    }

    public void a(a aVar) {
        this.mQG = aVar;
    }
}
