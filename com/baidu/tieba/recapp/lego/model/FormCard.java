package com.baidu.tieba.recapp.lego.model;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert {
    public static final int BG_SIZE_FULL_SCALE = 2;
    public static final int BG_SIZE_WIDTH_SCALE = 1;
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
    private AdvertAppInfo appInfo;
    public final a backgroundInfo;
    public final c commitInfo;
    public final List<b> itemList;
    public final int mHeight;
    private boolean mIsCommitSuccess;
    public final boolean mIsLegal;
    public final int mWidth;
    public String[] result;
    public final f resultInfo;
    public final g titleInfo;

    /* loaded from: classes3.dex */
    public static class a {
        public String color;
        public String img;
        public int mode;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String content;
        public String tag;
        public int type;
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        public String fYi;
        public String postUrl;
    }

    /* loaded from: classes3.dex */
    public static class d extends b {
        public String fYj;
        public h fYk;
    }

    /* loaded from: classes3.dex */
    public static class e extends b {
        public String[] fYl;
    }

    /* loaded from: classes3.dex */
    public static class f {
        public String desc;
        public String title;
    }

    /* loaded from: classes3.dex */
    public static class g extends b {
    }

    /* loaded from: classes3.dex */
    public static class h extends b {
        public String fYm;
    }

    public FormCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONArray jSONArray;
        JSONObject jSONObject2;
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
        this.mWidth = jSONObject.optInt("width", WIDTH_DEFAULT_SIZE);
        this.mHeight = jSONObject.optInt("height", HEIGHT_DEFAULT_SIZE);
        JSONObject optJSONObject = jSONObject.optJSONObject("background");
        if (optJSONObject != null) {
            this.backgroundInfo = new a();
            this.backgroundInfo.img = optJSONObject.optString("img", "");
            this.backgroundInfo.color = optJSONObject.optString("color", "");
            this.backgroundInfo.mode = optJSONObject.optInt("mode", -1);
        } else {
            this.backgroundInfo = null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
        if (optJSONObject2 != null) {
            this.resultInfo = new f();
            this.resultInfo.title = optJSONObject2.optString("title", "");
            this.resultInfo.desc = optJSONObject2.optString(SocialConstants.PARAM_APP_DESC, "");
        } else {
            this.resultInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("commit_info");
        if (optJSONObject3 != null) {
            this.commitInfo = new c();
            this.commitInfo.type = optJSONObject3.optInt("type", -1);
            this.commitInfo.postUrl = optJSONObject3.optString("post_url", "");
            this.commitInfo.content = optJSONObject3.optString("content", "");
            this.commitInfo.fYi = optJSONObject3.optString("check_str", "");
            this.commitInfo.tag = optJSONObject3.optString("tag", "");
        } else {
            this.commitInfo = null;
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("title_info");
        if (optJSONObject4 != null) {
            this.titleInfo = new g();
            this.titleInfo.type = optJSONObject4.optInt("type", -1);
            this.titleInfo.content = optJSONObject4.optString("content", "");
            this.titleInfo.tag = optJSONObject4.optString("tag", "");
        } else {
            this.titleInfo = null;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    if (jSONObject3 != null) {
                        int optInt = jSONObject3.optInt("type", -1);
                        switch (optInt) {
                            case 1:
                                g gVar = new g();
                                gVar.type = optInt;
                                gVar.content = jSONObject3.optString("content", "");
                                gVar.tag = jSONObject3.optString("tag", "");
                                this.itemList.add(gVar);
                                continue;
                            case 2:
                                c cVar = new c();
                                cVar.type = optInt;
                                cVar.content = jSONObject3.optString("content", "");
                                cVar.fYi = jSONObject3.optString("check_str", "");
                                cVar.postUrl = jSONObject3.optString("post_url", "");
                                cVar.tag = jSONObject3.optString("tag", "");
                                this.itemList.add(cVar);
                                continue;
                            case 3:
                            case 4:
                            case 5:
                                d dVar = new d();
                                dVar.type = optInt;
                                dVar.content = jSONObject3.optString("content", "");
                                dVar.tag = jSONObject3.optString("tag", "");
                                dVar.fYj = jSONObject3.optString("reg_str", "");
                                if (jSONObject3.has("veri_code_info") && (jSONObject2 = jSONObject3.getJSONObject("veri_code_info")) != null) {
                                    h hVar = new h();
                                    hVar.content = jSONObject2.optString("content");
                                    hVar.fYm = jSONObject2.optString("btn_title");
                                    hVar.tag = jSONObject2.optString("tag");
                                    dVar.fYk = hVar;
                                }
                                this.itemList.add(dVar);
                                continue;
                            case 6:
                            case 7:
                            case 8:
                                e eVar = new e();
                                eVar.type = optInt;
                                eVar.tag = jSONObject3.optString("tag", "");
                                eVar.content = jSONObject3.optString("content", "");
                                eVar.tag = jSONObject3.optString("tag", "");
                                if (jSONObject3.has("list") && (jSONArray = jSONObject3.getJSONArray("list")) != null && jSONArray.length() > 0) {
                                    String[] strArr = new String[jSONArray.length()];
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        strArr[i2] = jSONArray.getString(i2);
                                    }
                                    eVar.fYl = strArr;
                                }
                                this.itemList.add(eVar);
                                continue;
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        if (this.appInfo == null || this.appInfo.Wb == null) {
            return 0;
        }
        return this.appInfo.Wb.Wn;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void refreshReservation(Object obj) {
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    public boolean isCommitSuccess() {
        return this.mIsCommitSuccess;
    }

    public void setCommitState(boolean z) {
        this.mIsCommitSuccess = z;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.mWidth > 0 ? this.mHeight / this.mWidth : super.getRatio();
    }
}
