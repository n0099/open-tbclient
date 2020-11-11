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
    public long mCd;
    private a mCh;
    public List<AlaRecommendLiveData> mCi;
    public List<AlaRecommendLiveData> mCj;
    private long mCk;
    private HttpMessageListener mCl;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mCk = 0L;
        this.duration = 1800000L;
        this.mCl = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mCh != null) {
                            b.this.mCh.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.YH;
                        i = aVar.mCf;
                        i2 = i3;
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
                    if (alaRecommendLiveResponseMessage.mCn != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mCn.list)) {
                        b.this.mCi.addAll(alaRecommendLiveResponseMessage.mCn.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mCi != null && !b.this.mCi.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mCi.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mBW = b.this.mCi.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mCo != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mCo.list)) {
                        b.this.mCj.addAll(alaRecommendLiveResponseMessage.mCo.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mCo.jrF == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mCj != null && !b.this.mCj.isEmpty()) {
                        e eVar = new e(1);
                        eVar.title = com.baidu.live.aa.a.PQ().PY();
                        arrayList.add(eVar);
                        for (int i5 = 0; i5 < b.this.mCj.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mCa = b.this.mCj.get(i5);
                            if (i5 + 1 < b.this.mCj.size()) {
                                cVar.mCb = b.this.mCj.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mCh != null) {
                        b.this.mCh.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mCl);
    }

    public void f(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mCf = i;
        if (i == 0) {
            this.mCd = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mCk >= this.duration) {
            this.mCd = 0L;
        }
        this.mCk = currentTimeMillis;
        if (this.mCd == 0) {
            this.mCd = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mCd = this.mCd;
        aVar.YH = i;
        aVar.mCe = 1;
        aVar.aQt = i2;
        if (i2 == 1 && i == 1) {
            aVar.mCg = dBT();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dBT() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mCj) && (alaRecommendLiveData = this.mCj.get(this.mCj.size() - 1)) != null) {
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
        this.mCd = 0L;
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
        this.mCh = null;
    }

    public void a(a aVar) {
        this.mCh = aVar;
    }
}
