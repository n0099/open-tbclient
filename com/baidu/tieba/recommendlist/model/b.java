package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import com.baidu.tieba.recommendlist.data.d;
import com.baidu.tieba.recommendlist.data.f;
import com.baidu.tieba.recommendlist.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    public long duration;
    public boolean hasMore;
    public long igy;
    private a mWi;
    public List<AlaRecommendLiveData> mWj;
    public List<AlaRecommendLiveData> mWk;
    private long mWl;
    private HttpMessageListener mWm;

    /* loaded from: classes11.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mWl = 0L;
        this.duration = 1800000L;
        this.mWm = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                f dVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mWi != null) {
                            b.this.mWi.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i2 = aVar.aas;
                        i = aVar.mWg;
                    }
                    if (i2 == 0) {
                        b.this.mWj = new ArrayList();
                        b.this.mWk = new ArrayList();
                    } else {
                        if (b.this.mWj == null) {
                            b.this.mWj = new ArrayList();
                        }
                        if (b.this.mWk == null) {
                            b.this.mWk = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.mWo != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mWo.list)) {
                        b.this.mWj.addAll(alaRecommendLiveResponseMessage.mWo.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mWj != null && !b.this.mWj.isEmpty()) {
                        arrayList.add(new g(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < b.this.mWj.size(); i3++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mVX = b.this.mWj.get(i3);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mWp != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mWp.list)) {
                        b.this.mWk.addAll(alaRecommendLiveResponseMessage.mWp.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mWp.jTg == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mWk != null && !b.this.mWk.isEmpty()) {
                        g gVar = new g(1);
                        gVar.title = com.baidu.live.af.a.SE().SM();
                        arrayList.add(gVar);
                        for (int i4 = 0; i4 < b.this.mWk.size(); i4 += 2) {
                            if (com.baidu.live.af.a.SE().SO() == 1) {
                                dVar = new f();
                            } else {
                                dVar = new d();
                            }
                            dVar.type = 1;
                            dVar.mWb = b.this.mWk.get(i4);
                            if (i4 + 1 < b.this.mWk.size()) {
                                dVar.mWc = b.this.mWk.get(i4 + 1);
                            }
                            arrayList.add(dVar);
                        }
                    }
                    if (b.this.mWi != null) {
                        b.this.mWi.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mWm);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mWg = i;
        if (i == 0) {
            this.igy = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mWl >= this.duration) {
            this.igy = 0L;
        }
        this.mWl = currentTimeMillis;
        if (this.igy == 0) {
            this.igy = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.igy = this.igy;
        aVar.aas = i;
        aVar.mWf = 1;
        aVar.aSz = i2;
        if (i2 == 1 && i == 1) {
            aVar.mWh = dGy();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dGy() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mWk) && (alaRecommendLiveData = this.mWk.get(this.mWk.size() - 1)) != null) {
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
        this.igy = 0L;
        this.mWj = null;
        this.mWk = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.mWj == null || this.mWj.isEmpty()) && (this.mWk == null || this.mWk.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mWm);
        cancelMessage();
        this.mWi = null;
    }

    public void a(a aVar) {
        this.mWi = aVar;
    }
}
