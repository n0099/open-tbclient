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
    public long hTY;
    public boolean hasMore;
    private a mQI;
    public List<AlaRecommendLiveData> mQJ;
    public List<AlaRecommendLiveData> mQK;
    private long mQL;
    private HttpMessageListener mQM;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mQL = 0L;
        this.duration = 1800000L;
        this.mQM = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mQI != null) {
                            b.this.mQI.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i = aVar.mQG;
                        i2 = i3;
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
                    if (alaRecommendLiveResponseMessage.mQO != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mQO.list)) {
                        b.this.mQJ.addAll(alaRecommendLiveResponseMessage.mQO.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mQJ != null && !b.this.mQJ.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mQJ.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mQy = b.this.mQJ.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mQP != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mQP.list)) {
                        b.this.mQK.addAll(alaRecommendLiveResponseMessage.mQP.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mQP.jFO == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mQK != null && !b.this.mQK.isEmpty()) {
                        e eVar = new e(1);
                        eVar.title = com.baidu.live.ae.a.RB().RJ();
                        arrayList.add(eVar);
                        for (int i5 = 0; i5 < b.this.mQK.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mQC = b.this.mQK.get(i5);
                            if (i5 + 1 < b.this.mQK.size()) {
                                cVar.mQD = b.this.mQK.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mQI != null) {
                        b.this.mQI.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mQM);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mQG = i;
        if (i == 0) {
            this.hTY = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mQL >= this.duration) {
            this.hTY = 0L;
        }
        this.mQL = currentTimeMillis;
        if (this.hTY == 0) {
            this.hTY = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.hTY = this.hTY;
        aVar.ZJ = i;
        aVar.mQF = 1;
        aVar.aRK = i2;
        if (i2 == 1 && i == 1) {
            aVar.mQH = dGJ();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dGJ() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mQK) && (alaRecommendLiveData = this.mQK.get(this.mQK.size() - 1)) != null) {
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
        this.hTY = 0L;
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
        this.mQI = null;
    }

    public void a(a aVar) {
        this.mQI = aVar;
    }
}
