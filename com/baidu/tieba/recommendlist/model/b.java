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
    public long mwg;
    private a mwk;
    public List<AlaRecommendLiveData> mwl;
    public List<AlaRecommendLiveData> mwm;
    private long mwn;
    private HttpMessageListener mwo;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mwn = 0L;
        this.duration = 1800000L;
        this.mwo = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mwk != null) {
                            b.this.mwk.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i = aVar.mwi;
                        i2 = i3;
                    }
                    if (i2 == 0) {
                        b.this.mwl = new ArrayList();
                        b.this.mwm = new ArrayList();
                    } else {
                        if (b.this.mwl == null) {
                            b.this.mwl = new ArrayList();
                        }
                        if (b.this.mwm == null) {
                            b.this.mwm = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.mwq != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mwq.list)) {
                        b.this.mwl.addAll(alaRecommendLiveResponseMessage.mwq.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mwl != null && !b.this.mwl.isEmpty()) {
                        arrayList.add(new e(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < b.this.mwl.size(); i4++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mvZ = b.this.mwl.get(i4);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mwr != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mwr.list)) {
                        b.this.mwm.addAll(alaRecommendLiveResponseMessage.mwr.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mwr.jlH == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mwm != null && !b.this.mwm.isEmpty()) {
                        e eVar = new e(1);
                        eVar.title = com.baidu.live.z.a.Pq().Px();
                        arrayList.add(eVar);
                        for (int i5 = 0; i5 < b.this.mwm.size(); i5 += 2) {
                            c cVar = new c();
                            cVar.type = 1;
                            cVar.mwd = b.this.mwm.get(i5);
                            if (i5 + 1 < b.this.mwm.size()) {
                                cVar.mwe = b.this.mwm.get(i5 + 1);
                            }
                            arrayList.add(cVar);
                        }
                    }
                    if (b.this.mwk != null) {
                        b.this.mwk.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mwo);
    }

    public void d(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mwi = i;
        if (i == 0) {
            this.mwg = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mwn >= this.duration) {
            this.mwg = 0L;
        }
        this.mwn = currentTimeMillis;
        if (this.mwg == 0) {
            this.mwg = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.mwg = this.mwg;
        aVar.YH = i;
        aVar.mwh = 1;
        aVar.aPw = i2;
        if (i2 == 1 && i == 1) {
            aVar.mwj = dzr();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dzr() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mwm) && (alaRecommendLiveData = this.mwm.get(this.mwm.size() - 1)) != null) {
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
        this.mwg = 0L;
        this.mwl = null;
        this.mwm = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean bzx() {
        return (this.mwl == null || this.mwl.isEmpty()) && (this.mwm == null || this.mwm.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mwo);
        cancelMessage();
        this.mwk = null;
    }

    public void a(a aVar) {
        this.mwk = aVar;
    }
}
