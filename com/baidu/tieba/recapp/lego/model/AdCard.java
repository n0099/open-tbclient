package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.OpenLocationModel;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, com.baidu.tieba.lego.card.b.b, com.baidu.tieba.recapp.c.a {
    public static final int BUTTON_DISABLED = 0;
    public static final int BUTTON_ENABLED = 1;
    public static final String CHARGE_STYLE_CPC = "cpc";
    public static final String CHARGE_STYLE_CPV = "cpv";
    public static final String DEAL_URL_AFTER_LOGIN = "deal_url_after_login";
    public static final int INVALID_NUM = -999;
    static final int MASK_ANIMATION = 2;
    static final int MASK_IMMERSIVE = 1;
    static final int MASK_LANDING_PAGE = 4;
    public static final int SUB_URL_BELOW = 2;
    public final int activityId;
    public String activityNum;
    public final String adSource;
    public long agree_num;
    private AdvertAppInfo appInfo;
    public final b buttonClick;
    public int buttonStatus;
    public final String buttonText;
    public final String buttonTextDone;
    public final a chargeInfo;
    public boolean goLandingPage;
    public final int goodsStyle;
    public final int height;
    public boolean isAnimation;
    public boolean isImmersiveStyle;
    public final int labelMeasure;
    public String localAdsAddress;
    public boolean needResize;
    public final String nextPageData;
    public b.a parallelChargeInfo;
    public final String popWindowText;
    public final b portraitClick;
    public final int posSubUrl;
    public String preLoadInfo;
    public final int reply_num;
    public final String sScore;
    public final int share_num;
    public final e[] subUrlInfos;
    public final String tagName;
    public float tagNameRatio;
    public final String tagNameUrl;
    public f tailFrame;
    public final String threadContent;
    public final d[] threadPicList;
    public final String threadTitle;
    public final long time;
    public final String userName;
    public final String userPortrait;
    public final VideoInfo videoInfo;
    public final g vrVideoInfo;
    public final int width;

    /* loaded from: classes3.dex */
    public static class a {
        public String gQB;
        public String gQC;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String abo;
        public String abp;
        public int gQD;
        public String scheme;
    }

    /* loaded from: classes3.dex */
    public static class d {
        public String desc;
        public b gQF;
        public String pic;
        public String title;
    }

    /* loaded from: classes3.dex */
    public static class e {
        public String gQG;
        public String gQH;
        public b gQI;
        public String text;
    }

    /* loaded from: classes3.dex */
    public static class g {
        public String aqx;
        public float aqy;
        public VideoInfo videoInfo;
    }

    public String getNextPageData() {
        return this.nextPageData;
    }

    public String getPreLoadData() {
        return this.preLoadInfo;
    }

    public boolean isImmersiveStyle() {
        return this.isImmersiveStyle;
    }

    public boolean isGoLandingPage() {
        return this.goLandingPage;
    }

    public boolean hasAnimation() {
        return this.isAnimation;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getTitle() {
        return this.threadTitle;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getAbstract() {
        return this.threadContent;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getImageUrl() {
        return this.userPortrait;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public String getShareLink() {
        return q.vQ(this.scheme) ? Uri.parse(this.scheme).getQueryParameter("wap") : this.scheme;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public AdvertAppInfo getThreadData() {
        return getAdvertAppInfo();
    }

    @Override // com.baidu.tieba.lego.card.b.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String Js;
        public String buttonText;
        public String downloadUrl;
        public String gQE;
        public boolean init = false;
        public String scheme;
        public String style;

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.style = jSONObject.optString("style");
                this.gQE = jSONObject.optString("brand_name");
                String str = "jump".equals(this.style) ? "查看详情" : "";
                this.buttonText = jSONObject.optString("button_text", str);
                if (TextUtils.isEmpty(this.buttonText)) {
                    this.buttonText = str;
                }
                this.scheme = jSONObject.optString(GetSwanHistoryAction.KEY_SCHEME);
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
                if (optJSONObject != null) {
                    this.Js = optJSONObject.optString("pkgname");
                    this.downloadUrl = optJSONObject.optString("download_url");
                }
                this.init = true;
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.style);
                jSONObject.put("brand_name", this.gQE);
                jSONObject.put(GetSwanHistoryAction.KEY_SCHEME, this.scheme);
                jSONObject.put("button_text", this.buttonText);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public String Js;
        public String buttonText;
        public int count;
        public String downloadUrl;
        public String gQJ;
        public boolean init = false;
        public String scheme;
        public String style;
        public String userName;

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.style = jSONObject.optString("style");
                this.userName = jSONObject.optString("user_name");
                this.gQJ = jSONObject.optString("user_portrait");
                this.scheme = jSONObject.optString(GetSwanHistoryAction.KEY_SCHEME);
                this.buttonText = jSONObject.optString("button_text");
                this.count = jSONObject.optInt("close_time");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
                if (optJSONObject != null) {
                    this.Js = optJSONObject.optString("pkgname");
                    this.downloadUrl = optJSONObject.optString("download_url");
                }
                this.init = true;
            }
        }

        public void uU(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    parseFromJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
            if (advertAppInfo != null) {
                if (advertAppInfo.apU == 3) {
                    this.style = "apk_download";
                    this.Js = advertAppInfo.apX;
                    this.downloadUrl = advertAppInfo.apW;
                } else if (advertAppInfo.apU == 1) {
                    this.style = "jump";
                }
                this.buttonText = adCard.buttonText;
                this.userName = adCard.userName;
                this.gQJ = adCard.userPortrait;
                this.scheme = adCard.scheme;
            }
        }

        public String toJsonString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.style);
                jSONObject.put("user_name", this.userName);
                jSONObject.put("user_portrait", this.gQJ);
                jSONObject.put(GetSwanHistoryAction.KEY_SCHEME, this.scheme);
                jSONObject.put("button_text", this.buttonText);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.Js);
                jSONObject2.put("download_url", this.downloadUrl);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.style);
                jSONObject.put("user_name", this.userName);
                jSONObject.put("user_portrait", this.gQJ);
                jSONObject.put(GetSwanHistoryAction.KEY_SCHEME, this.scheme);
                jSONObject.put("button_text", this.buttonText);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.Js);
                jSONObject2.put("download_url", this.downloadUrl);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public AdCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        getPropertyFromScheme(this.scheme);
        JSONObject optJSONObject = jSONObject.optJSONObject(LegoListActivityConfig.PRE_LOAD);
        if (optJSONObject != null) {
            this.preLoadInfo = optJSONObject.toString();
        }
        this.nextPageData = jSONObject.optString(LegoListActivityConfig.NEXT_PAGE);
        this.chargeInfo = new a();
        this.chargeInfo.gQB = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_STYLE, "cpc");
        this.chargeInfo.gQC = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_URL);
        this.tailFrame = new f();
        this.tailFrame.parseFromJson(jSONObject.optJSONObject(WebVideoActivityConfig.KEY_TAIL_FRAME));
        this.parallelChargeInfo = new b.a();
        this.parallelChargeInfo.parseFromJson(jSONObject);
        this.userName = jSONObject.optString("user_name");
        this.userPortrait = jSONObject.optString("user_portrait");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait_click");
        if (optJSONObject2 != null) {
            this.portraitClick = new b();
            this.portraitClick.scheme = optJSONObject2.optString(GetSwanHistoryAction.KEY_SCHEME);
            this.portraitClick.abo = optJSONObject2.optString("als_stat");
            this.portraitClick.abp = optJSONObject2.optString("url_stat");
            this.portraitClick.gQD = optJSONObject2.optInt("need_login");
        } else {
            this.portraitClick = null;
        }
        this.threadTitle = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        this.threadContent = jSONObject.optString("thread_content");
        this.popWindowText = jSONObject.optString("pop_window_text");
        this.goodsStyle = com.baidu.adp.lib.g.b.l(jSONObject.optString("goods_style"), -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.threadPicList = new d[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.threadPicList[i] = new d();
                try {
                    this.threadPicList[i].pic = optJSONArray.getJSONObject(i).optString("pic");
                    this.threadPicList[i].desc = optJSONArray.getJSONObject(i).optString("b_desc");
                    this.threadPicList[i].title = optJSONArray.getJSONObject(i).optString("title");
                    JSONObject optJSONObject3 = optJSONArray.getJSONObject(i).optJSONObject("pic_click");
                    if (optJSONObject3 != null) {
                        this.threadPicList[i].gQF = new b();
                        this.threadPicList[i].gQF.scheme = optJSONObject3.optString(GetSwanHistoryAction.KEY_SCHEME);
                        getPropertyFromScheme(this.threadPicList[i].gQF.scheme);
                        this.threadPicList[i].gQF.abo = optJSONObject3.optString("als_stat");
                        this.threadPicList[i].gQF.abp = optJSONObject3.optString("url_stat");
                        this.threadPicList[i].gQF.gQD = optJSONObject3.optInt("need_login");
                    } else {
                        this.threadPicList[i].gQF = null;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.threadPicList = null;
        }
        this.buttonText = jSONObject.optString("button_text");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
        this.labelMeasure = jSONObject.optInt("label_measure");
        this.needResize = this.labelMeasure == 2;
        JSONObject optJSONObject4 = jSONObject.optJSONObject("button_click");
        if (optJSONObject4 != null) {
            this.buttonClick = new b();
            this.buttonClick.scheme = optJSONObject4.optString(GetSwanHistoryAction.KEY_SCHEME);
            this.buttonClick.abo = optJSONObject4.optString("als_stat");
            this.buttonClick.abp = optJSONObject4.optString("url_stat");
            this.buttonClick.gQD = optJSONObject4.optInt("need_login");
        } else {
            this.buttonClick = null;
        }
        this.adSource = jSONObject.optString("ad_source");
        this.tagNameUrl = jSONObject.optString("tag_name_url");
        this.tagName = jSONObject.optString("tag_name");
        String optString = jSONObject.optString("tag_name_wh");
        if (!TextUtils.isEmpty(optString) && optString.contains(",")) {
            try {
                String[] split = optString.split(",");
                int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                if (l2 != 0) {
                    this.tagNameRatio = l / l2;
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
        this.sScore = jSONObject.optString("s_score");
        this.activityNum = uT(jSONObject.optString("activity_num"));
        this.buttonStatus = jSONObject.optInt("button_status");
        this.buttonTextDone = jSONObject.optString("button_text_done");
        this.activityId = jSONObject.optInt("activity_id");
        this.localAdsAddress = jSONObject.optString(OpenLocationModel.ADDRESS, "");
        this.time = jSONObject.optLong("time", System.currentTimeMillis());
        this.reply_num = jSONObject.optInt("reply_num", INVALID_NUM);
        this.agree_num = jSONObject.optInt("agree_num", INVALID_NUM);
        this.share_num = jSONObject.optInt("share_num", INVALID_NUM);
        this.posSubUrl = jSONObject.optInt("pos_sub_url");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sub_url_info");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.subUrlInfos = new e[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                this.subUrlInfos[i2] = new e();
                try {
                    this.subUrlInfos[i2].text = optJSONArray2.getJSONObject(i2).optString("text");
                    this.subUrlInfos[i2].gQG = optJSONArray2.getJSONObject(i2).optString("t_color");
                    this.subUrlInfos[i2].gQH = optJSONArray2.getJSONObject(i2).optString("t_color_n");
                    JSONObject optJSONObject5 = optJSONArray2.getJSONObject(i2).optJSONObject("sub_click");
                    if (optJSONObject5 != null) {
                        this.subUrlInfos[i2].gQI = new b();
                        this.subUrlInfos[i2].gQI.scheme = optJSONObject5.optString(GetSwanHistoryAction.KEY_SCHEME);
                        getPropertyFromScheme(this.subUrlInfos[i2].gQI.scheme);
                        this.subUrlInfos[i2].gQI.abo = optJSONObject5.optString("als_stat");
                        this.subUrlInfos[i2].gQI.abp = optJSONObject5.optString("url_stat");
                        this.subUrlInfos[i2].gQI.gQD = optJSONObject5.optInt("need_login");
                    } else {
                        this.subUrlInfos[i2].gQI = null;
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        } else {
            this.subUrlInfos = null;
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null && optJSONObject6.length() > 0) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = optJSONObject6.optString("video_md5", "");
            builder.video_url = optJSONObject6.optString(WebVideoActivityConfig.KEY_VIDEO_URL, "");
            builder.video_duration = Integer.valueOf(optJSONObject6.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
            builder.video_width = Integer.valueOf(optJSONObject6.optInt("video_width", 0));
            builder.video_height = Integer.valueOf(optJSONObject6.optInt("video_height", 0));
            builder.thumbnail_url = optJSONObject6.optString("thumbnail_url", "");
            builder.thumbnail_width = Integer.valueOf(optJSONObject6.optInt("thumbnail_width", 0));
            builder.thumbnail_height = Integer.valueOf(optJSONObject6.optInt("thumbnail_height", 0));
            builder.video_length = Integer.valueOf(optJSONObject6.optInt("video_length", 0));
            builder.play_count = Integer.valueOf(optJSONObject6.optInt("play_count", -1));
            builder.media_subtitle = optJSONObject6.optString("media_subtitle", "");
            this.videoInfo = builder.build(true);
        } else {
            this.videoInfo = null;
        }
        if (this.videoInfo != null) {
            this.vrVideoInfo = new g();
            this.vrVideoInfo.aqx = jSONObject.optString("brand_icon", "");
            this.vrVideoInfo.videoInfo = this.videoInfo;
            String optString2 = jSONObject.optString("brand_icon_wh", null);
            if (!ao.isEmpty(optString2)) {
                try {
                    String[] split2 = optString2.split(",");
                    int l3 = com.baidu.adp.lib.g.b.l(split2[0], 1);
                    int l4 = com.baidu.adp.lib.g.b.l(split2[1], 1);
                    if (l4 != 0) {
                        this.vrVideoInfo.aqy = l3 / l4;
                    } else {
                        this.vrVideoInfo.aqy = 1.0f;
                    }
                    return;
                } catch (Exception e5) {
                    BdLog.e(e5.getMessage());
                    return;
                }
            }
            return;
        }
        this.vrVideoInfo = null;
    }

    protected void getPropertyFromScheme(String str) {
        int indexOf;
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if ((str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) && (indexOf = str.indexOf("?", 0)) > -1) {
                String queryParameter = Uri.parse("tieba://lego?" + str.substring(indexOf + 1)).getQueryParameter("page_prop");
                if (!TextUtils.isEmpty(queryParameter)) {
                    Integer valueOf = Integer.valueOf(queryParameter);
                    this.isAnimation = this.isAnimation || getPageProperty(valueOf.intValue(), 2);
                    this.goLandingPage = this.goLandingPage || getPageProperty(valueOf.intValue(), 4);
                    if (this.isImmersiveStyle || getPageProperty(valueOf.intValue(), 1)) {
                        z = true;
                    }
                    this.isImmersiveStyle = z;
                }
            }
        }
    }

    protected boolean getPageProperty(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void refreshReservation(Object obj) {
        com.baidu.tbadk.data.g gVar;
        if ((obj instanceof com.baidu.tbadk.data.g) && (gVar = (com.baidu.tbadk.data.g) obj) != null && gVar.getActivityId() == this.activityId) {
            this.activityNum = uT(gVar.LT());
            if (gVar.LS() == 1) {
                this.buttonStatus = 0;
            } else {
                this.buttonStatus = 1;
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
        updataThreadData(this.appInfo);
        if (!this.tailFrame.init) {
            this.tailFrame.a(this.appInfo, this);
        }
    }

    public void updataThreadData(bb bbVar) {
        if (bbVar != null) {
            bbVar.B(this.time / 1000);
            bbVar.cP(this.reply_num);
            bbVar.C(this.agree_num);
            bbVar.E(this.share_num);
            bbVar.setAddress(this.localAdsAddress);
            bbVar.setTitle(this.threadTitle);
            bbVar.ew(this.threadContent);
            bbVar.zT().setName_show(this.userName);
            bbVar.zT().setPortrait(this.userPortrait);
        }
    }

    private String uT(String str) {
        if (str != null && str.contains("{") && str.contains("}")) {
            String substring = str.substring(0, str.indexOf("{"));
            return substring + str.substring(str.indexOf("{") + 1, str.indexOf("}"));
        }
        return str;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        switch (this.goodsStyle) {
            case 7:
                return (this.videoInfo == null || StringUtils.isNull(this.videoInfo.video_url)) ? false : true;
            case 8:
                return false;
            case 9:
                return MessageManager.getInstance().findTask(2016481) != null && this.vrVideoInfo != null && !StringUtils.isNull(this.videoInfo.video_url) && this.videoInfo.video_height.intValue() > 0 && this.videoInfo.video_width.intValue() > 0 && this.videoInfo.video_duration.intValue() > 0;
            case 10:
                return MessageManager.getInstance().findTask(2016481) != null;
            default:
                return super.isValid();
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return this.goodsStyle;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        switch (this.goodsStyle) {
            case 2:
            case 6:
            case 8:
                return this.threadPicList == null || this.threadPicList.length == 0;
            default:
                return false;
        }
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

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            return getCardType() == adCard.getCardType() && getGoodsStyle() == adCard.getGoodsStyle();
        }
        return false;
    }
}
