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
    public long igl;
    private a naT;
    public List<AlaRecommendLiveData> naU;
    public List<AlaRecommendLiveData> naV;
    private long naW;
    private HttpMessageListener naX;

    /* loaded from: classes11.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.naW = 0L;
        this.duration = 1800000L;
        this.naX = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                f dVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.naT != null) {
                            b.this.naT.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i = aVar.naR;
                    }
                    if (i2 == 0) {
                        b.this.naU = new ArrayList();
                        b.this.naV = new ArrayList();
                    } else {
                        if (b.this.naU == null) {
                            b.this.naU = new ArrayList();
                        }
                        if (b.this.naV == null) {
                            b.this.naV = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.naZ != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.naZ.list)) {
                        b.this.naU.addAll(alaRecommendLiveResponseMessage.naZ.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.naU != null && !b.this.naU.isEmpty()) {
                        arrayList.add(new g(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < b.this.naU.size(); i3++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.naI = b.this.naU.get(i3);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.nba != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.nba.list)) {
                        b.this.naV.addAll(alaRecommendLiveResponseMessage.nba.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.nba.jWd == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.naV != null && !b.this.naV.isEmpty()) {
                        g gVar = new g(1);
                        gVar.title = com.baidu.live.ae.a.Qj().Qs();
                        arrayList.add(gVar);
                        for (int i4 = 0; i4 < b.this.naV.size(); i4 += 2) {
                            if (com.baidu.live.ae.a.Qj().Qu() == 1) {
                                dVar = new f();
                            } else {
                                dVar = new d();
                            }
                            dVar.type = 1;
                            dVar.naM = b.this.naV.get(i4);
                            if (i4 + 1 < b.this.naV.size()) {
                                dVar.naN = b.this.naV.get(i4 + 1);
                            }
                            arrayList.add(dVar);
                        }
                    }
                    if (b.this.naT != null) {
                        b.this.naT.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.naX);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.naR = i;
        if (i == 0) {
            this.igl = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.naW >= this.duration) {
            this.igl = 0L;
        }
        this.naW = currentTimeMillis;
        if (this.igl == 0) {
            this.igl = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.igl = this.igl;
        aVar.aam = i;
        aVar.naQ = 1;
        aVar.aQN = i2;
        if (i2 == 1 && i == 1) {
            aVar.naS = dER();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dER() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.naV) && (alaRecommendLiveData = this.naV.get(this.naV.size() - 1)) != null) {
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
        this.igl = 0L;
        this.naU = null;
        this.naV = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.naU == null || this.naU.isEmpty()) && (this.naV == null || this.naV.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.naX);
        cancelMessage();
        this.naT = null;
    }

    public void a(a aVar) {
        this.naT = aVar;
    }
}
