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
    public long ibN;
    private HttpMessageListener mRA;
    private a mRw;
    public List<AlaRecommendLiveData> mRx;
    public List<AlaRecommendLiveData> mRy;
    private long mRz;

    /* loaded from: classes10.dex */
    public interface a {
        void onFail(int i, String str);

        void t(List<IAdapterData> list, int i);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRz = 0L;
        this.duration = 1800000L;
        this.mRA = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                f dVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.mRw != null) {
                            b.this.mRw.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        i2 = aVar.aaq;
                        i = aVar.mRu;
                    }
                    if (i2 == 0) {
                        b.this.mRx = new ArrayList();
                        b.this.mRy = new ArrayList();
                    } else {
                        if (b.this.mRx == null) {
                            b.this.mRx = new ArrayList();
                        }
                        if (b.this.mRy == null) {
                            b.this.mRy = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.mRC != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mRC.list)) {
                        b.this.mRx.addAll(alaRecommendLiveResponseMessage.mRC.list);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.mRx != null && !b.this.mRx.isEmpty()) {
                        arrayList.add(new g(0));
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < b.this.mRx.size(); i3++) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.mRl = b.this.mRx.get(i3);
                            arrayList2.add(aVar2);
                        }
                        arrayList.add(new com.baidu.tieba.recommendlist.data.b(arrayList2));
                    }
                    if (alaRecommendLiveResponseMessage.mRD != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.mRD.list)) {
                        b.this.mRy.addAll(alaRecommendLiveResponseMessage.mRD.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.mRD.jOB == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    if (b.this.mRy != null && !b.this.mRy.isEmpty()) {
                        g gVar = new g(1);
                        gVar.title = com.baidu.live.af.a.OJ().OR();
                        arrayList.add(gVar);
                        for (int i4 = 0; i4 < b.this.mRy.size(); i4 += 2) {
                            if (com.baidu.live.af.a.OJ().OT() == 1) {
                                dVar = new f();
                            } else {
                                dVar = new d();
                            }
                            dVar.type = 1;
                            dVar.mRp = b.this.mRy.get(i4);
                            if (i4 + 1 < b.this.mRy.size()) {
                                dVar.mRq = b.this.mRy.get(i4 + 1);
                            }
                            arrayList.add(dVar);
                        }
                    }
                    if (b.this.mRw != null) {
                        b.this.mRw.t(arrayList, i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.mRA);
    }

    public void g(long j, int i, int i2) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.mRu = i;
        if (i == 0) {
            this.ibN = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mRz >= this.duration) {
            this.ibN = 0L;
        }
        this.mRz = currentTimeMillis;
        if (this.ibN == 0) {
            this.ibN = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.ibN = this.ibN;
        aVar.aaq = i;
        aVar.mRt = 1;
        aVar.aNM = i2;
        if (i2 == 1 && i == 1) {
            aVar.mRv = dCH();
        }
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    private long dCH() {
        AlaRecommendLiveData alaRecommendLiveData;
        if (!ListUtils.isEmpty(this.mRy) && (alaRecommendLiveData = this.mRy.get(this.mRy.size() - 1)) != null) {
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
        this.ibN = 0L;
        this.mRx = null;
        this.mRy = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean isDataEmpty() {
        return (this.mRx == null || this.mRx.isEmpty()) && (this.mRy == null || this.mRy.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mRA);
        cancelMessage();
        this.mRw = null;
    }

    public void a(a aVar) {
        this.mRw = aVar;
    }
}
