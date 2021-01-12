package com.baidu.tieba.lego;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class h {
    private final BdListView WT;
    private boolean hasMore;
    private String itemId;
    private final com.baidu.tieba.lego.b.a kRr;
    private long kRu;
    private a kRx = null;
    private final List<ICardInfo> mDataList = new LinkedList();
    private int mPn = 1;
    private String kRy = "";
    private boolean mIsLoading = false;
    private boolean jSJ = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bC(int i, String str);

        void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list);

        void eH(List<com.baidu.tieba.lego.c.d> list);

        void onError(int i, String str);

        void onSuccess();

        void q(long j, String str);
    }

    public h(BdListView bdListView, com.baidu.tieba.lego.b.a aVar) {
        this.WT = bdListView;
        this.kRr = aVar;
    }

    public List<ICardInfo> getDataList() {
        return this.mDataList;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void r(long j, String str) {
        this.mPn = 1;
        this.kRu = j;
        this.itemId = str;
        if (this.mDataList.size() == 0 && !this.jSJ) {
            s(j, str);
        } else {
            l(j, str);
        }
    }

    public void bQy() {
        if (!isLoading() && this.kRx != null) {
            this.mPn++;
            setIsLoading(true);
            this.kRx.bC(this.mPn, this.kRy);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.WT.completePullRefresh();
        }
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.kRx != null) {
                    this.kRx.onError(1, str);
                    return;
                }
                return;
            } else if (this.kRx != null) {
                this.kRx.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.kRx != null) {
            this.kRx.onSuccess();
        }
        if (z) {
            b(dataRes);
        }
    }

    private void l(long j, String str) {
        if (this.kRx != null) {
            this.kRx.q(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.jSJ = true;
        if (dataRes != null) {
            if (a(true, dataRes) && this.kRx != null) {
                this.kRx.onSuccess();
            }
            l(this.kRu, this.itemId);
            return;
        }
        l(this.kRu, this.itemId);
    }

    private boolean a(boolean z, DataRes dataRes) {
        String str;
        if (dataRes == null) {
            return false;
        }
        if (z) {
            this.mDataList.clear();
        }
        this.hasMore = dataRes.has_more.intValue() == 1;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(dataRes.page_info);
            JSONArray optJSONArray = jSONObject.optJSONArray("tab");
            JSONObject optJSONObject = jSONObject.optJSONObject("title");
            String str2 = "";
            String str3 = "";
            if (optJSONObject == null) {
                str = "";
            } else {
                str2 = optJSONObject.optString("name");
                str3 = optJSONObject.optString("url");
                str = optJSONObject.optString("urlNight");
            }
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        com.baidu.tieba.lego.c.e eVar = new com.baidu.tieba.lego.c.e();
                        eVar.tag_name = optJSONObject2.optString("title");
                        eVar.kXA = optJSONObject2.optLong("page_id");
                        eVar.kXB = optJSONObject2.optInt("page_type");
                        eVar.rn = optJSONObject2.optInt("rn");
                        eVar.itemId = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.params = optJSONObject2.optString("params");
                        eVar.refresh();
                        arrayList.add(eVar);
                    }
                }
                this.kRx.c(str2, str3, str, arrayList);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        com.baidu.tieba.lego.c.d dVar = new com.baidu.tieba.lego.c.d();
                        dVar.parseFromJson(optJSONObject3);
                        if (dVar.isValid()) {
                            arrayList2.add(dVar);
                        }
                    }
                }
                this.kRx.eH(arrayList2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (dataRes.cards != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= dataRes.cards.size()) {
                    break;
                }
                ICardInfo MN = com.baidu.tieba.lego.card.b.MN(dataRes.cards.get(i4));
                if (MN != null && MN.isValid()) {
                    this.mDataList.add(MN);
                }
                i3 = i4 + 1;
            }
        }
        if (this.mDataList.size() == 0) {
            return false;
        }
        try {
            this.kRy = this.mDataList.get(this.mDataList.size() - 1).getFlipId();
        } catch (Exception e2) {
            this.kRy = "";
        }
        this.kRr.eM(this.mDataList);
        return true;
    }

    private void s(final long j, final String str) {
        final com.baidu.adp.lib.cache.l<byte[]> Aa = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.lego_update");
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.lego.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cZh */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) Aa.get(j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(str) ? "" : str));
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.lego.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                h.this.a(dataRes);
            }
        });
    }

    private void b(DataRes dataRes) {
        if (dataRes != null) {
            com.baidu.tbadk.core.c.a.bpZ().Aa("tb.lego_update").asyncSetForever(this.kRu + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), dataRes.toByteArray());
        }
    }

    public void a(a aVar) {
        this.kRx = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }
}
