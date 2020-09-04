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
/* loaded from: classes7.dex */
public class b extends BdBaseModel {
    public long duration;
    public boolean hasMore;
    public long lLf;
    private a lLi;
    public List<AlaRecommendLiveData> lLj;
    public List<AlaRecommendLiveData> lLk;
    private long lLl;
    private HttpMessageListener lLm;

    /* loaded from: classes7.dex */
    public interface a {
        void g(List<IAdapterData> list, int i, int i2);

        void onFail(int i, String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lLl = 0L;
        this.duration = 1800000L;
        this.lLm = new HttpMessageListener(1021193) { // from class: com.baidu.tieba.recommendlist.model.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                int i;
                int i2;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021193 && (httpResponsedMessage instanceof AlaRecommendLiveResponseMessage)) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (b.this.lLi != null) {
                            b.this.lLi.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
                        int i3 = aVar.XX;
                        int i4 = aVar.lLh;
                        i2 = i3;
                        i = i4;
                    }
                    if (i2 == 0) {
                        b.this.lLj = new ArrayList();
                        b.this.lLk = new ArrayList();
                    } else {
                        if (b.this.lLj == null) {
                            b.this.lLj = new ArrayList();
                        }
                        if (b.this.lLk == null) {
                            b.this.lLk = new ArrayList();
                        }
                    }
                    if (alaRecommendLiveResponseMessage.lLo != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lLo.list)) {
                        b.this.lLj.addAll(alaRecommendLiveResponseMessage.lLo.list);
                    }
                    if (alaRecommendLiveResponseMessage.lLp != null && !ListUtils.isEmpty(alaRecommendLiveResponseMessage.lLp.list)) {
                        b.this.lLk.addAll(alaRecommendLiveResponseMessage.lLp.list);
                        b.this.hasMore = alaRecommendLiveResponseMessage.lLp.iDa == 1;
                    } else {
                        b.this.hasMore = false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (b.this.lLj != null && !b.this.lLj.isEmpty()) {
                        c cVar = new c(0);
                        cVar.count = b.this.lLj.size();
                        arrayList.add(cVar);
                        for (int i5 = 0; i5 < b.this.lLj.size(); i5 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar2 = new com.baidu.tieba.recommendlist.data.a();
                            aVar2.type = 0;
                            aVar2.lLc = b.this.lLj.get(i5);
                            if (i5 + 1 < b.this.lLj.size()) {
                                aVar2.lLd = b.this.lLj.get(i5 + 1);
                            }
                            arrayList.add(aVar2);
                        }
                    }
                    if (b.this.lLk != null && !b.this.lLk.isEmpty()) {
                        arrayList.add(new c(1));
                        for (int i6 = 0; i6 < b.this.lLk.size(); i6 += 2) {
                            com.baidu.tieba.recommendlist.data.a aVar3 = new com.baidu.tieba.recommendlist.data.a();
                            aVar3.type = 1;
                            aVar3.lLc = b.this.lLk.get(i6);
                            if (i6 + 1 < b.this.lLk.size()) {
                                aVar3.lLd = b.this.lLk.get(i6 + 1);
                            }
                            arrayList.add(aVar3);
                        }
                    }
                    if (b.this.lLi != null) {
                        b.this.lLi.g(arrayList, ListUtils.getCount(b.this.lLj), i);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.lLm);
    }

    public void m(long j, int i) {
        com.baidu.tieba.recommendlist.model.a aVar = new com.baidu.tieba.recommendlist.model.a();
        aVar.lLh = i;
        if (i == 0) {
            this.lLf = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lLl >= this.duration) {
            this.lLf = 0L;
        }
        this.lLl = currentTimeMillis;
        if (this.lLf == 0) {
            this.lLf = System.currentTimeMillis();
            i = 0;
        }
        aVar.setTag(getUniqueId());
        aVar.liveId = j;
        aVar.lLf = this.lLf;
        aVar.XX = i;
        aVar.lLg = 1;
        aVar.setParams();
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean loadData() {
        return false;
    }

    public void reset() {
        cancelMessage();
        this.lLf = 0L;
        this.lLj = null;
        this.lLk = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean btQ() {
        return (this.lLj == null || this.lLj.isEmpty()) && (this.lLk == null || this.lLk.isEmpty());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lLm);
        cancelMessage();
        this.lLi = null;
    }

    public void a(a aVar) {
        this.lLi = aVar;
    }
}
