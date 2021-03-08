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
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    public long duration;
    public boolean hasMore;
    public long iii;
    private long ndA;
    private HttpMessageListener ndB;
    private a ndx;
    public List<AlaRecommendLiveData> ndy;
    public List<AlaRecommendLiveData> ndz;

    /* loaded from: classes10.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ndA = 0L;
        this.duration = 1800000L;
        this.ndB = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                f dVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.ndx != null) {
                            b.this.ndx.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                    if (alaRecommendLiveResponseMessage.ndD != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.ndD.list)) {
                        b.this.ndy.addAll(alaRecommendLiveResponseMessage.ndD.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.ndy != null && !b.this.ndy.isEmpty()) {
                        arrayList.add(new g(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < b.this.ndy.size(); i3++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.ndm = b.this.ndy.get(i3);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.ndE != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.ndE.list)) {
                        b.this.ndz.addAll(alaRecommendLiveResponseMessage.ndE.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.ndE.jYt == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.ndz != null && !b.this.ndz.isEmpty()) {
                        g gVar = new g(1);
                        gVar.title = com.baidu.live.ae.a.Qm().Qv();
                        arrayList.add(gVar);
                        for (int i4 = 0; i4 < b.this.ndz.size(); i4 += 2) {
                            if (com.baidu.live.ae.a.Qm().Qx() == 1) {
                                dVar = new f();
                            } else {
                                dVar = new d();
                            }
                            dVar.type = 1;
                            dVar.ndq = b.this.ndz.get(i4);
                            if (i4 + 1 < b.this.ndz.size()) {
                                dVar.ndr = b.this.ndz.get(i4 + 1);
                            }
                            arrayList.add(dVar);
                        }
                    }
                    if (b.this.ndx != null) {
                        b.this.ndx.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ndB);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.ndv = i;
        if (i == 0) {
            this.iii = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ndA >= this.duration) {
            this.iii = 0L;
        }
        this.ndA = currentTimeMillis;
        if (this.iii == 0) {
            this.iii = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.iii = this.iii;
        aVar.abG = i;
        aVar.ndu = 1;
        aVar.aSn = i2;
        if (i2 == 1 && i == 1) {
            aVar.ndw = dFh();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dFh() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.ndz) && (alaRecommendLiveData = this.ndz.get(this.ndz.size() - 1)) != null) {
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
        this.iii = 0L;
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
        this.ndx = null;
    }

    public void a(a aVar) {
        this.ndx = aVar;
    }
}
