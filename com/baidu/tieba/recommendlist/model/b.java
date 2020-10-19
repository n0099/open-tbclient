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
    public boolean hasMore;
    public long mjG;
    private a mjJ;
    public List<AlaRecommendLiveData> mjK;
    public List<AlaRecommendLiveData> mjL;
    private long mjM;
    private HttpMessageListener mjN;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void s(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mjM = 0L;
        this.duration = 1800000L;
        this.mjN = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mjJ != null) {
                            b.this.mjJ.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.YG;
                        i = aVar.mjI;
                        i2 = i3;
                    }
                    if (i2 == 0) {
                        b.this.mjK = new ArrayList();
                        b.this.mjL = new ArrayList();
                    } else {
                        if (b.this.mjK == null) {
                            b.this.mjK = new ArrayList();
                        }
                        if (b.this.mjL == null) {
                            b.this.mjL = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.mjP != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mjP.list)) {
                        b.this.mjK.addAll(alaRecommendLiveResponseMessage.mjP.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mjK != null && !b.this.mjK.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mjK.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mjz = b.this.mjK.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mjQ != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mjQ.list)) {
                        b.this.mjL.addAll(alaRecommendLiveResponseMessage.mjQ.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mjQ.iZn == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mjL != null && !b.this.mjL.isEmpty()) {
                        arrayList.add(new e(1));
                        for (int i5 = 0; i5 < b.this.mjL.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mjD = b.this.mjL.get(i5);
                            if (i5 + 1 < b.this.mjL.size()) {
                                cVar.mjE = b.this.mjL.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mjJ != null) {
                        b.this.mjJ.s(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mjN);
    }

    public void t(long j, int i) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mjI = i;
        if (i == 0) {
            this.mjG = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mjM >= this.duration) {
            this.mjG = 0L;
        }
        this.mjM = currentTimeMillis;
        if (this.mjG == 0) {
            this.mjG = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mjG = this.mjG;
        aVar.YG = i;
        aVar.mjH = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.mjG = 0L;
        this.mjK = null;
        this.mjL = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bxE() {
        return (this.mjK == null || this.mjK.isEmpty()) && (this.mjL == null || this.mjL.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mjN);
        cancelMessage();
        this.mjJ = null;
    }

    public void a(a aVar) {
        this.mjJ = aVar;
    }
}
