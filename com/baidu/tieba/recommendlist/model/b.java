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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BdBaseModel {
    public long duration;
    public boolean hasMore;
    public long lKS;
    private a lKV;
    public List<AlaRecommendLiveData> lKW;
    public List<AlaRecommendLiveData> lKX;
    private long lKY;
    private HttpMessageListener lKZ;

    /* loaded from: classes7.dex */
    public interface a {
        void g(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lKY = 0L;
        this.duration = 1800000L;
        this.lKZ = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.lKV != null) {
                            b.this.lKV.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.XV;
                        int i4 = aVar.lKU;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.lKW = new ArrayList();
                        b.this.lKX = new ArrayList();
                    } else {
                        if (b.this.lKW == null) {
                            b.this.lKW = new ArrayList();
                        }
                        if (b.this.lKX == null) {
                            b.this.lKX = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.lLb != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lLb.list)) {
                        b.this.lKW.addAll(alaRecommendLiveResponseMessage.lLb.list);
                    }
                    if (alaRecommendLiveResponseMessage.lLc != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lLc.list)) {
                        b.this.lKX.addAll(alaRecommendLiveResponseMessage.lLc.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.lLc.iCU == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.lKW != null && !b.this.lKW.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.lKW.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.lKW.size(); i5 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.lKP = b.this.lKW.get(i5);
                            if (i5 + 1 < b.this.lKW.size()) {
                                aVar2.lKQ = b.this.lKW.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.lKX != null && !b.this.lKX.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.lKX.size(); i6 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar3 = new com.baidu.tieba.recommendlist.data.a();
                            aVar3.type = 1;
                            aVar3.lKP = b.this.lKX.get(i6);
                            if (i6 + 1 < b.this.lKX.size()) {
                                aVar3.lKQ = b.this.lKX.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.lKV != null) {
                        b.this.lKV.g(arrayList, ListUtils.getCount(b.this.lKW), i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.lKZ);
    }

    public void m(long j, int i) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.lKU = i;
        if (i == 0) {
            this.lKS = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lKY >= this.duration) {
            this.lKS = 0L;
        }
        this.lKY = currentTimeMillis;
        if (this.lKS == 0) {
            this.lKS = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.lKS = this.lKS;
        aVar.XV = i;
        aVar.lKT = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.lKS = 0L;
        this.lKW = null;
        this.lKX = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean btP() {
        return (this.lKW == null || this.lKW.isEmpty()) && (this.lKX == null || this.lKX.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lKZ);
        cancelMessage();
        this.lKV = null;
    }

    public void a(a aVar) {
        this.lKV = aVar;
    }
}
