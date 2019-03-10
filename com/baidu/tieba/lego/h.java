package com.baidu.tieba.lego;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes2.dex */
public class h {
    private final BdListView Pi;
    private final com.baidu.tieba.lego.b.a gED;
    private long gEG;
    private boolean hasMore;
    private String itemId;
    private a gEJ = null;
    private final List<ICardInfo> mDataList = new LinkedList();
    private int mPn = 1;
    private String gEK = "";
    private boolean mIsLoading = false;
    private boolean fGr = false;

    /* loaded from: classes2.dex */
    public interface a {
        void ao(int i, String str);

        void c(String str, String str2, String str3, List<com.baidu.tieba.lego.c.e> list);

        void de(List<com.baidu.tieba.lego.c.d> list);

        void k(long j, String str);

        void onError(int i, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, com.baidu.tieba.lego.b.a aVar) {
        this.Pi = bdListView;
        this.gED = aVar;
    }

    public List<ICardInfo> getDataList() {
        return this.mDataList;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void l(long j, String str) {
        this.mPn = 1;
        this.gEG = j;
        this.itemId = str;
        if (this.mDataList.size() == 0 && !this.fGr) {
            m(j, str);
        } else {
            f(j, str);
        }
    }

    public void aBd() {
        if (!qz() && this.gEJ != null) {
            this.mPn++;
            setIsLoading(true);
            this.gEJ.ao(this.mPn, this.gEK);
        }
    }

    public void a(boolean z, DataRes dataRes, int i, String str) {
        setIsLoading(false);
        if (z) {
            this.Pi.completePullRefresh();
        }
        if (i != 0 || dataRes == null || !a(z, dataRes)) {
            if (this.mDataList.size() > 0) {
                if (this.gEJ != null) {
                    this.gEJ.onError(1, str);
                    return;
                }
                return;
            } else if (this.gEJ != null) {
                this.gEJ.onError(2, str);
                return;
            } else {
                return;
            }
        }
        if (this.gEJ != null) {
            this.gEJ.onSuccess();
        }
        if (z) {
            b(dataRes);
        }
    }

    private void f(long j, String str) {
        if (this.gEJ != null) {
            this.gEJ.k(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        this.fGr = true;
        if (dataRes != null) {
            if (a(true, dataRes) && this.gEJ != null) {
                this.gEJ.onSuccess();
            }
            f(this.gEG, this.itemId);
            return;
        }
        f(this.gEG, this.itemId);
    }

    private boolean a(boolean z, DataRes dataRes) {
        String str;
        String str2;
        String str3;
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
            if (optJSONObject == null) {
                str = "";
                str2 = "";
                str3 = "";
            } else {
                String optString = optJSONObject.optString("name");
                String optString2 = optJSONObject.optString("url");
                String optString3 = optJSONObject.optString("urlNight");
                str = optString;
                str2 = optString2;
                str3 = optString3;
            }
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        com.baidu.tieba.lego.c.e eVar = new com.baidu.tieba.lego.c.e();
                        eVar.tag_name = optJSONObject2.optString("title");
                        eVar.gKW = optJSONObject2.optLong("page_id");
                        eVar.gKX = optJSONObject2.optInt("page_type");
                        eVar.rn = optJSONObject2.optInt(LegoListActivityConfig.RN);
                        eVar.itemId = optJSONObject2.optString(LegoListActivityConfig.ITEM_ID);
                        eVar.params = optJSONObject2.optString(LegoListActivityConfig.PARAMS);
                        eVar.refresh();
                        arrayList.add(eVar);
                    }
                }
                this.gEJ.c(str, str2, str3, arrayList);
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
                this.gEJ.de(arrayList2);
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
                ICardInfo xX = com.baidu.tieba.lego.card.b.xX(dataRes.cards.get(i4));
                if (xX != null && xX.isValid()) {
                    this.mDataList.add(xX);
                }
                i3 = i4 + 1;
            }
        }
        if (this.mDataList.size() == 0) {
            return false;
        }
        try {
            this.gEK = this.mDataList.get(this.mDataList.size() - 1).getFlipId();
        } catch (Exception e2) {
            this.gEK = "";
        }
        this.gED.dj(this.mDataList);
        return true;
    }

    private void m(final long j, final String str) {
        final com.baidu.adp.lib.cache.l<byte[]> lu = com.baidu.tbadk.core.c.a.aaW().lu("tb.lego_update");
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.lego.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bzv */
            public DataRes doInBackground() {
                byte[] bArr = (byte[]) lu.get(j + "_" + (TextUtils.isEmpty(str) ? "" : str));
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
        }, new com.baidu.tbadk.util.k<DataRes>() { // from class: com.baidu.tieba.lego.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                h.this.a(dataRes);
            }
        });
    }

    private void b(DataRes dataRes) {
        if (dataRes != null) {
            com.baidu.tbadk.core.c.a.aaW().lu("tb.lego_update").f(this.gEG + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), dataRes.toByteArray());
        }
    }

    public void a(a aVar) {
        this.gEJ = aVar;
    }

    private boolean qz() {
        return this.mIsLoading;
    }

    private void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }
}
