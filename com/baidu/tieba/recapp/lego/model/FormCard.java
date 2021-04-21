package com.baidu.tieba.recapp.lego.model;

import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f20420a;

        /* renamed from: b  reason: collision with root package name */
        public String f20421b;

        /* renamed from: c  reason: collision with root package name */
        public int f20422c;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f20423a;

        /* renamed from: b  reason: collision with root package name */
        public String f20424b;

        /* renamed from: c  reason: collision with root package name */
        public String f20425c;
    }

    /* loaded from: classes4.dex */
    public static class c extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20426d;

        /* renamed from: e  reason: collision with root package name */
        public String f20427e;
    }

    /* loaded from: classes4.dex */
    public static class d extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20428d;

        /* renamed from: e  reason: collision with root package name */
        public h f20429e;
    }

    /* loaded from: classes4.dex */
    public static class e extends b {

        /* renamed from: d  reason: collision with root package name */
        public String[] f20430d;
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f20431a;

        /* renamed from: b  reason: collision with root package name */
        public String f20432b;
    }

    /* loaded from: classes4.dex */
    public static class g extends b {
    }

    /* loaded from: classes4.dex */
    public static class h extends b {

        /* renamed from: d  reason: collision with root package name */
        public String f20433d;
    }

    public FormCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONObject jSONObject2;
        JSONArray jSONArray;
        int i = 0;
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
        int i2 = -1;
        if (optJSONObject != null) {
            a aVar = new a();
            this.backgroundInfo = aVar;
            aVar.f20420a = optJSONObject.optString("img", "");
            this.backgroundInfo.f20421b = optJSONObject.optString("color", "");
            this.backgroundInfo.f20422c = optJSONObject.optInt("mode", -1);
        } else {
            this.backgroundInfo = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
        if (optJSONObject2 != null) {
            f fVar = new f();
            this.resultInfo = fVar;
            fVar.f20431a = optJSONObject2.optString("title", "");
            this.resultInfo.f20432b = optJSONObject2.optString("desc", "");
        } else {
            this.resultInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("commit_info");
        if (optJSONObject3 != null) {
            c cVar = new c();
            this.commitInfo = cVar;
            cVar.f20423a = optJSONObject3.optInt("type", -1);
            this.commitInfo.f20427e = optJSONObject3.optString("post_url", "");
            this.commitInfo.f20424b = optJSONObject3.optString("content", "");
            this.commitInfo.f20426d = optJSONObject3.optString("check_str", "");
            this.commitInfo.f20425c = optJSONObject3.optString("tag", "");
        } else {
            this.commitInfo = null;
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("title_info");
        if (optJSONObject4 != null) {
            g gVar = new g();
            this.titleInfo = gVar;
            gVar.f20423a = optJSONObject4.optInt("type", -1);
            this.titleInfo.f20424b = optJSONObject4.optString("content", "");
            this.titleInfo.f20425c = optJSONObject4.optString("tag", "");
        } else {
            this.titleInfo = null;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            int i3 = 0;
            while (i3 < optJSONArray.length()) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
                if (jSONObject3 != null) {
                    int optInt = jSONObject3.optInt("type", i2);
                    switch (optInt) {
                        case 1:
                            g gVar2 = new g();
                            gVar2.f20423a = optInt;
                            gVar2.f20424b = jSONObject3.optString("content", "");
                            gVar2.f20425c = jSONObject3.optString("tag", "");
                            d.b.j0.j1.o.k.a.a(this.itemList, gVar2);
                            continue;
                        case 2:
                            c cVar2 = new c();
                            cVar2.f20423a = optInt;
                            cVar2.f20424b = jSONObject3.optString("content", "");
                            cVar2.f20426d = jSONObject3.optString("check_str", "");
                            cVar2.f20427e = jSONObject3.optString("post_url", "");
                            cVar2.f20425c = jSONObject3.optString("tag", "");
                            d.b.j0.j1.o.k.a.a(this.itemList, cVar2);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            d dVar = new d();
                            dVar.f20423a = optInt;
                            dVar.f20424b = jSONObject3.optString("content", "");
                            dVar.f20425c = jSONObject3.optString("tag", "");
                            dVar.f20428d = jSONObject3.optString("reg_str", "");
                            if (jSONObject3.has("veri_code_info") && (jSONObject2 = jSONObject3.getJSONObject("veri_code_info")) != null) {
                                h hVar = new h();
                                hVar.f20424b = jSONObject2.optString("content");
                                hVar.f20433d = jSONObject2.optString("btn_title");
                                hVar.f20425c = jSONObject2.optString("tag");
                                dVar.f20429e = hVar;
                            }
                            d.b.j0.j1.o.k.a.a(this.itemList, dVar);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            e eVar = new e();
                            eVar.f20423a = optInt;
                            eVar.f20425c = jSONObject3.optString("tag", "");
                            eVar.f20424b = jSONObject3.optString("content", "");
                            eVar.f20425c = jSONObject3.optString("tag", "");
                            if (jSONObject3.has("list") && (jSONArray = jSONObject3.getJSONArray("list")) != null && jSONArray.length() > 0) {
                                String[] strArr = new String[jSONArray.length()];
                                while (i < jSONArray.length()) {
                                    strArr[i] = jSONArray.getString(i);
                                    i++;
                                }
                                eVar.f20430d = strArr;
                            }
                            d.b.j0.j1.o.k.a.a(this.itemList, eVar);
                            continue;
                        default:
                            continue;
                    }
                }
                i3++;
                i = 0;
                i2 = -1;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
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
    public d.b.i0.r.q.c getAppInfoModel() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        AdvertAppInfo.a aVar;
        AdvertAppInfo advertAppInfo = this.appInfo;
        if (advertAppInfo == null || (aVar = advertAppInfo.U3) == null) {
            return 0;
        }
        return aVar.f12879h;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i = this.mWidth;
        if (i > 0) {
            return this.mHeight / i;
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
