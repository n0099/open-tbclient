package com.baidu.tieba.lego;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes9.dex */
public class h {
    private final BdListView WO;
    private boolean hasMore;
    private String itemId;
    private final com.baidu.tieba.lego.b.a kZH;
    private long kZK;
    private a kZN = null;
    private final List<ICardInfo> mDataList = new LinkedList();
    private int mPn = 1;
    private String kZO = "";
    private boolean mIsLoading = false;
    private boolean kay = false;

    /* loaded from: classes9.dex */
    public interface a {
        void bI(int i, String str);

        void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list);

        void eF(List<com.baidu.tieba.lego.c.d> list);

        void onError(int i, String str);

        void onSuccess();

        void r(long j, String str);
    }

    public h(BdListView bdListView, com.baidu.tieba.lego.b.a aVar) {
        this.WO = bdListView;
        this.kZH = aVar;
    }

    public List<ICardInfo> getDataList() {
        return this.mDataList;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void s(long j, String str) {
        this.mPn = 1;
        this.kZK = j;
        this.itemId = str;
        if (this.mDataList.size() == 0 && !this.kay) {
            t(j, str);
        } else {
            m(j, str);
        }
    }

    public void bRj() {
        if (!isLoading() && this.kZN != null) {
            this.mPn++;
            setIsLoading(true);
            this.kZN.bI(this.mPn, this.kZO);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.WO.completePullRefresh();
        }
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.kZN != null) {
                    this.kZN.onError(1, str);
                    return;
                }
                return;
            } else if (this.kZN != null) {
                this.kZN.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.kZN != null) {
            this.kZN.onSuccess();
        }
        if (z) {
            b(dataRes);
        }
    }

    private void m(long j, String str) {
        if (this.kZN != null) {
            this.kZN.r(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.kay = true;
        if (dataRes != null) {
            if (a(true, dataRes) && this.kZN != null) {
                this.kZN.onSuccess();
            }
            m(this.kZK, this.itemId);
            return;
        }
        m(this.kZK, this.itemId);
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
                        eVar.lfS = optJSONObject2.optLong("page_id");
                        eVar.lfT = optJSONObject2.optInt("page_type");
                        eVar.rn = optJSONObject2.optInt("rn");
                        eVar.itemId = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.params = optJSONObject2.optString("params");
                        eVar.refresh();
                        arrayList.add(eVar);
                    }
                }
                this.kZN.c(str2, str3, str, arrayList);
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
                this.kZN.eF(arrayList2);
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
                ICardInfo ND = com.baidu.tieba.lego.card.b.ND(dataRes.cards.get(i4));
                if (ND != null && ND.isValid()) {
                    this.mDataList.add(ND);
                }
                i3 = i4 + 1;
            }
        }
        if (this.mDataList.size() == 0) {
            return false;
        }
        try {
            this.kZO = this.mDataList.get(this.mDataList.size() - 1).getFlipId();
        } catch (Exception e2) {
            this.kZO = "";
        }
        this.kZH.eK(this.mDataList);
        return true;
    }

    private void t(final long j, final String str) {
        final com.baidu.adp.lib.cache.l<byte[]> Ar = com.baidu.tbadk.core.c.a.bqr().Ar("tb.lego_update");
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.lego.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: dbm */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) Ar.get(j + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(str) ? "" : str));
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
        }, new m<DataRes>() { // from class: com.baidu.tieba.lego.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                h.this.a(dataRes);
            }
        });
    }

    private void b(DataRes dataRes) {
        if (dataRes != null) {
            com.baidu.tbadk.core.c.a.bqr().Ar("tb.lego_update").asyncSetForever(this.kZK + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), dataRes.toByteArray());
        }
    }

    public void a(a aVar) {
        this.kZN = aVar;
    }

    private boolean isLoading() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }
}
