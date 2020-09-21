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
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    public long duration;
    public boolean hasMore;
    public long lTZ;
    private a lUc;
    public List<AlaRecommendLiveData> lUd;
    public List<AlaRecommendLiveData> lUe;
    private long lUf;
    private HttpMessageListener lUg;

    /* loaded from: classes4.dex */
    public interface a {
        void g(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lUf = 0L;
        this.duration = 1800000L;
        this.lUg = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.lUc != null) {
                            b.this.lUc.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.Yq;
                        int i4 = aVar.lUb;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.lUd = new ArrayList();
                        b.this.lUe = new ArrayList();
                    } else {
                        if (b.this.lUd == null) {
                            b.this.lUd = new ArrayList();
                        }
                        if (b.this.lUe == null) {
                            b.this.lUe = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.lUi != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lUi.list)) {
                        b.this.lUd.addAll(alaRecommendLiveResponseMessage.lUi.list);
                    }
                    if (alaRecommendLiveResponseMessage.lUj != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lUj.list)) {
                        b.this.lUe.addAll(alaRecommendLiveResponseMessage.lUj.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.lUj.iKv == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.lUd != null && !b.this.lUd.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.lUd.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.lUd.size(); i5 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.lTW = b.this.lUd.get(i5);
                            if (i5 + 1 < b.this.lUd.size()) {
                                aVar2.lTX = b.this.lUd.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.lUe != null && !b.this.lUe.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.lUe.size(); i6 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar3 = new com.baidu.tieba.recommendlist.data.a();
                            aVar3.type = 1;
                            aVar3.lTW = b.this.lUe.get(i6);
                            if (i6 + 1 < b.this.lUe.size()) {
                                aVar3.lTX = b.this.lUe.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.lUc != null) {
                        b.this.lUc.g(arrayList, ListUtils.getCount(b.this.lUd), i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.lUg);
    }

    public void p(long j, int i) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.lUb = i;
        if (i == 0) {
            this.lTZ = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lUf >= this.duration) {
            this.lTZ = 0L;
        }
        this.lUf = currentTimeMillis;
        if (this.lTZ == 0) {
            this.lTZ = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.lTZ = this.lTZ;
        aVar.Yq = i;
        aVar.lUa = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.lTZ = 0L;
        this.lUd = null;
        this.lUe = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean buU() {
        return (this.lUd == null || this.lUd.isEmpty()) && (this.lUe == null || this.lUe.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lUg);
        cancelMessage();
        this.lUc = null;
    }

    public void a(a aVar) {
        this.lUc = aVar;
    }
}
