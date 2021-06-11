package com.baidu.tieba.recapp.lego.model;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FormCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert {
    public static final int BG_SIZE_FULL_SCALE = 2;
    public static final int BG_SIZE_WIDTH_SCALE = 1;
    public static final int FORM_DEFAULT_TYPE = -1;
    public static final int HEIGHT_DEFAULT_SIZE = 1334;
    public static final int TYPE_COMMIT_INFO = 2;
    public static final int TYPE_EDIT_MULTI_LINE_INFO = 4;
    public static final int TYPE_EDIT_PHONE_INFO = 5;
    public static final int TYPE_EDIT_SINGLE_LINE_INFO = 3;
    public static final int TYPE_PICKER_COMMON_INFO = 6;
    public static final int TYPE_PICKER_DATE_INFO = 7;
    public static final int TYPE_PICKER_TIME_INFO = 8;
    public static final int TYPE_TITLE_INFO = 1;
    public static final int WIDTH_DEFAULT_SIZE = 750;
    public AdvertAppInfo appInfo;
    public final a backgroundInfo;
    public final c commitInfo;
    public final List<b> itemList;
    public final int mHeight;
    public boolean mIsCommitSuccess;
    public final boolean mIsLegal;
    public final int mWidth;
    public String[] result;
    public final f resultInfo;
    public final g titleInfo;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f20221a;

        /* renamed from: b  reason: collision with root package name */
        public String f20222b;

        /* renamed from: c  reason: collision with root package name */
        public int f20223c;
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f20224a;

        /* renamed from: b  reason: collision with root package name */
        public String f20225b;

        /* renamed from: c  reason: collision with root package name */
        public String f20226c;
    }

    /* loaded from: classes5.dex */
    public static class c extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20227d;

        /* renamed from: e  reason: collision with root package name */
        public String f20228e;
    }

    /* loaded from: classes5.dex */
    public static class d extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20229d;

        /* renamed from: e  reason: collision with root package name */
        public h f20230e;
    }

    /* loaded from: classes5.dex */
    public static class e extends b {

        /* renamed from: d  reason: collision with root package name */
        public String[] f20231d;
    }

    /* loaded from: classes5.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f20232a;

        /* renamed from: b  reason: collision with root package name */
        public String f20233b;
    }

    /* loaded from: classes5.dex */
    public static class g extends b {
    }

    /* loaded from: classes5.dex */
    public static class h extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20234d;
    }

    public FormCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONObject jSONObject2;
        JSONArray jSONArray;
        int i2 = 0;
        this.mIsCommitSuccess = false;
        if (jSONObject == null) {
            this.itemList = null;
            this.titleInfo = null;
            this.commitInfo = null;
            this.resultInfo = null;
            this.backgroundInfo = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mIsLegal = false;
            return;
        }
        this.mIsLegal = true;
        this.itemList = new ArrayList();
        this.mWidth = jSONObject.optInt("width", 750);
        this.mHeight = jSONObject.optInt("height", HEIGHT_DEFAULT_SIZE);
        JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.WearableExtender.KEY_BACKGROUND);
        int i3 = -1;
        if (optJSONObject != null) {
            a aVar = new a();
            this.backgroundInfo = aVar;
            aVar.f20221a = optJSONObject.optString("img", "");
            this.backgroundInfo.f20222b = optJSONObject.optString("color", "");
            this.backgroundInfo.f20223c = optJSONObject.optInt("mode", -1);
        } else {
            this.backgroundInfo = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
        if (optJSONObject2 != null) {
            f fVar = new f();
            this.resultInfo = fVar;
            fVar.f20232a = optJSONObject2.optString("title", "");
            this.resultInfo.f20233b = optJSONObject2.optString("desc", "");
        } else {
            this.resultInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("commit_info");
        if (optJSONObject3 != null) {
            c cVar = new c();
            this.commitInfo = cVar;
            cVar.f20224a = optJSONObject3.optInt("type", -1);
            this.commitInfo.f20228e = optJSONObject3.optString("post_url", "");
            this.commitInfo.f20225b = optJSONObject3.optString("content", "");
            this.commitInfo.f20227d = optJSONObject3.optString("check_str", "");
            this.commitInfo.f20226c = optJSONObject3.optString("tag", "");
        } else {
            this.commitInfo = null;
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("title_info");
        if (optJSONObject4 != null) {
            g gVar = new g();
            this.titleInfo = gVar;
            gVar.f20224a = optJSONObject4.optInt("type", -1);
            this.titleInfo.f20225b = optJSONObject4.optString("content", "");
            this.titleInfo.f20226c = optJSONObject4.optString("tag", "");
        } else {
            this.titleInfo = null;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            int i4 = 0;
            while (i4 < optJSONArray.length()) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i4);
                if (jSONObject3 != null) {
                    int optInt = jSONObject3.optInt("type", i3);
                    switch (optInt) {
                        case 1:
                            g gVar2 = new g();
                            gVar2.f20224a = optInt;
                            gVar2.f20225b = jSONObject3.optString("content", "");
                            gVar2.f20226c = jSONObject3.optString("tag", "");
                            d.a.n0.k1.o.k.a.a(this.itemList, gVar2);
                            continue;
                        case 2:
                            c cVar2 = new c();
                            cVar2.f20224a = optInt;
                            cVar2.f20225b = jSONObject3.optString("content", "");
                            cVar2.f20227d = jSONObject3.optString("check_str", "");
                            cVar2.f20228e = jSONObject3.optString("post_url", "");
                            cVar2.f20226c = jSONObject3.optString("tag", "");
                            d.a.n0.k1.o.k.a.a(this.itemList, cVar2);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            d dVar = new d();
                            dVar.f20224a = optInt;
                            dVar.f20225b = jSONObject3.optString("content", "");
                            dVar.f20226c = jSONObject3.optString("tag", "");
                            dVar.f20229d = jSONObject3.optString("reg_str", "");
                            if (jSONObject3.has("veri_code_info") && (jSONObject2 = jSONObject3.getJSONObject("veri_code_info")) != null) {
                                h hVar = new h();
                                hVar.f20225b = jSONObject2.optString("content");
                                hVar.f20234d = jSONObject2.optString("btn_title");
                                hVar.f20226c = jSONObject2.optString("tag");
                                dVar.f20230e = hVar;
                            }
                            d.a.n0.k1.o.k.a.a(this.itemList, dVar);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            e eVar = new e();
                            eVar.f20224a = optInt;
                            eVar.f20226c = jSONObject3.optString("tag", "");
                            eVar.f20225b = jSONObject3.optString("content", "");
                            eVar.f20226c = jSONObject3.optString("tag", "");
                            if (jSONObject3.has("list") && (jSONArray = jSONObject3.getJSONArray("list")) != null && jSONArray.length() > 0) {
                                String[] strArr = new String[jSONArray.length()];
                                while (i2 < jSONArray.length()) {
                                    strArr[i2] = jSONArray.getString(i2);
                                    i2++;
                                }
                                eVar.f20231d = strArr;
                            }
                            d.a.n0.k1.o.k.a.a(this.itemList, eVar);
                            continue;
                        default:
                            continue;
                    }
                }
                i4++;
                i2 = 0;
                i3 = -1;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean checkIsAppAdvert() {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i2) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public d.a.m0.r.q.c getAppInfoModel() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    @NonNull
    public String getDownloadId() {
        return "";
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        AdvertAppInfo advertAppInfo = this.appInfo;
        if (advertAppInfo == null) {
            return null;
        }
        return advertAppInfo.Q3;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        AdvertAppInfo advertAppInfo = this.appInfo;
        if (advertAppInfo != null) {
            return advertAppInfo.L3;
        }
        return 0;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i2 = this.mWidth;
        if (i2 > 0) {
            return this.mHeight / i2;
        }
        return super.getRatio();
    }

    public boolean isCommitSuccess() {
        return this.mIsCommitSuccess;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return false;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
    }

    public void setCommitState(boolean z) {
        this.mIsCommitSuccess = z;
    }
}
