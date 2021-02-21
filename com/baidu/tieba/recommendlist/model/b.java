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
    public long igz;
    private a nbt;
    public List<AlaRecommendLiveData> nbu;
    public List<AlaRecommendLiveData> nbv;
    private long nbw;
    private HttpMessageListener nbx;

    /* loaded from: classes11.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.nbw = 0L;
        this.duration = 1800000L;
        this.nbx = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                f dVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.nbt != null) {
                            b.this.nbt.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i2 = aVar.aam;
                        i = aVar.nbr;
                    }
                    if (i2 == 0) {
                        b.this.nbu = new ArrayList();
                        b.this.nbv = new ArrayList();
                    } else {
                        if (b.this.nbu == null) {
                            b.this.nbu = new ArrayList();
                        }
                        if (b.this.nbv == null) {
                            b.this.nbv = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.nbz != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nbz.list)) {
                        b.this.nbu.addAll(alaRecommendLiveResponseMessage.nbz.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.nbu != null && !b.this.nbu.isEmpty()) {
                        arrayList.add(new g(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < b.this.nbu.size(); i3++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.nbi = b.this.nbu.get(i3);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.nbA != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nbA.list)) {
                        b.this.nbv.addAll(alaRecommendLiveResponseMessage.nbA.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.nbA.jWr == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.nbv != null && !b.this.nbv.isEmpty()) {
                        g gVar = new g(1);
                        gVar.title = com.baidu.live.ae.a.Qj().Qs();
                        arrayList.add(gVar);
                        for (int i4 = 0; i4 < b.this.nbv.size(); i4 += 2) {
                            if (com.baidu.live.ae.a.Qj().Qu() == 1) {
                                dVar = new f();
                            } else {
                                dVar = new d();
                            }
                            dVar.type = 1;
                            dVar.nbm = b.this.nbv.get(i4);
                            if (i4 + 1 < b.this.nbv.size()) {
                                dVar.nbn = b.this.nbv.get(i4 + 1);
                            }
                            arrayList.add(dVar);
                        }
                    }
                    if (b.this.nbt != null) {
                        b.this.nbt.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.nbx);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.nbr = i;
        if (i == 0) {
            this.igz = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.nbw >= this.duration) {
            this.igz = 0L;
        }
        this.nbw = currentTimeMillis;
        if (this.igz == 0) {
            this.igz = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.igz = this.igz;
        aVar.aam = i;
        aVar.nbq = 1;
        aVar.aQN = i2;
        if (i2 == 1 && i == 1) {
            aVar.nbs = dEZ();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dEZ() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.nbv) && (alaRecommendLiveData = this.nbv.get(this.nbv.size() - 1)) != null) {
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
        this.igz = 0L;
        this.nbu = null;
        this.nbv = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.nbu == null || this.nbu.isEmpty()) && (this.nbv == null || this.nbv.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.nbx);
        cancelMessage();
        this.nbt = null;
    }

    public void a(a aVar) {
        this.nbt = aVar;
    }
}
