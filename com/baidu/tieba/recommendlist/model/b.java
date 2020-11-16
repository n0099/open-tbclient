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
    public long mCB;
    private a mCF;
    public List<AlaRecommendLiveData> mCG;
    public List<AlaRecommendLiveData> mCH;
    private long mCI;
    private HttpMessageListener mCJ;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mCI = 0L;
        this.duration = 1800000L;
        this.mCJ = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mCF != null) {
                            b.this.mCF.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.YM;
                        i = aVar.mCD;
                        i2 = i3;
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
                    if (alaRecommendLiveResponseMessage.mCL != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mCL.list)) {
                        b.this.mCG.addAll(alaRecommendLiveResponseMessage.mCL.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mCG != null && !b.this.mCG.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mCG.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mCt = b.this.mCG.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mCM != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mCM.list)) {
                        b.this.mCH.addAll(alaRecommendLiveResponseMessage.mCM.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mCM.jsm == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mCH != null && !b.this.mCH.isEmpty()) {
                        e eVar = new e(1);
                        eVar.title = com.baidu.live.aa.a.Ph().Pp();
                        arrayList.add(eVar);
                        for (int i5 = 0; i5 < b.this.mCH.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mCy = b.this.mCH.get(i5);
                            if (i5 + 1 < b.this.mCH.size()) {
                                cVar.mCz = b.this.mCH.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mCF != null) {
                        b.this.mCF.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mCJ);
    }

    public void f(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mCD = i;
        if (i == 0) {
            this.mCB = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mCI >= this.duration) {
            this.mCB = 0L;
        }
        this.mCI = currentTimeMillis;
        if (this.mCB == 0) {
            this.mCB = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mCB = this.mCB;
        aVar.YM = i;
        aVar.mCC = 1;
        aVar.aOI = i2;
        if (i2 == 1 && i == 1) {
            aVar.mCE = dBx();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dBx() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mCH) && (alaRecommendLiveData = this.mCH.get(this.mCH.size() - 1)) != null) {
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
        this.mCB = 0L;
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
        this.mCF = null;
    }

    public void a(a aVar) {
        this.mCF = aVar;
    }
}
