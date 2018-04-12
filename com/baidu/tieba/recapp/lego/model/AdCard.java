package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.q;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, com.baidu.tieba.recapp.c.a {
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
    public int agree_num;
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
        public String fXX;
        public String fXY;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String LW;
        public String LX;
        public int fXZ;
        public String scheme;
    }

    /* loaded from: classes3.dex */
    public static class d {
        public String desc;
        public b fYc;
        public String pic;
        public String title;
    }

    /* loaded from: classes3.dex */
    public static class e {
        public String fYd;
        public String fYe;
        public b fYf;
        public String text;
    }

    /* loaded from: classes3.dex */
    public static class g {
        public String Wu;
        public float Wv;
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
        return q.sN(this.scheme) ? Uri.parse(this.scheme).getQueryParameter("wap") : this.scheme;
    }

    @Override // com.baidu.tieba.recapp.c.a
    public AdvertAppInfo getThreadData() {
        return getAdvertAppInfo();
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String Ak;
        public String buttonText;
        public String downloadUrl;
        public String fYa;
        public boolean fYb = false;
        public String scheme;
        public String style;

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.style = jSONObject.optString("style");
                this.fYa = jSONObject.optString("brand_name");
                String str = "jump".equals(this.style) ? "查看详情" : "";
                this.buttonText = jSONObject.optString("button_text", str);
                if (TextUtils.isEmpty(this.buttonText)) {
                    this.buttonText = str;
                }
                this.scheme = jSONObject.optString("scheme");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
                if (optJSONObject != null) {
                    this.Ak = optJSONObject.optString("pkgname");
                    this.downloadUrl = optJSONObject.optString("download_url");
                }
                this.fYb = true;
            }
        }

        public JSONObject aeT() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.style);
                jSONObject.put("brand_name", this.fYa);
                jSONObject.put("scheme", this.scheme);
                jSONObject.put("button_text", this.buttonText);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public String Ak;
        public String buttonText;
        public int count;
        public String downloadUrl;
        public boolean fYb = false;
        public String fYg;
        public String scheme;
        public String style;
        public String userName;

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.style = jSONObject.optString("style");
                this.userName = jSONObject.optString("user_name");
                this.fYg = jSONObject.optString("user_portrait");
                this.scheme = jSONObject.optString("scheme");
                this.buttonText = jSONObject.optString("button_text");
                this.count = jSONObject.optInt("close_time");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
                if (optJSONObject != null) {
                    this.Ak = optJSONObject.optString("pkgname");
                    this.downloadUrl = optJSONObject.optString("download_url");
                }
                this.fYb = true;
            }
        }

        public void rT(String str) {
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
                if (advertAppInfo.VR == 3) {
                    this.style = "apk_download";
                    this.Ak = advertAppInfo.VU;
                    this.downloadUrl = advertAppInfo.VT;
                } else if (advertAppInfo.VR == 1) {
                    this.style = "jump";
                }
                this.buttonText = adCard.buttonText;
                this.userName = adCard.userName;
                this.fYg = adCard.userPortrait;
                this.scheme = adCard.scheme;
            }
        }

        public String toJsonString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.style);
                jSONObject.put("user_name", this.userName);
                jSONObject.put("user_portrait", this.fYg);
                jSONObject.put("scheme", this.scheme);
                jSONObject.put("button_text", this.buttonText);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.Ak);
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
                jSONObject.put("user_portrait", this.fYg);
                jSONObject.put("scheme", this.scheme);
                jSONObject.put("button_text", this.buttonText);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.Ak);
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
        this.chargeInfo.fXX = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_STYLE, "cpc");
        this.chargeInfo.fXY = jSONObject.optString(WebVideoActivityConfig.KEY_CHARGE_URL);
        this.tailFrame = new f();
        this.tailFrame.parseFromJson(jSONObject.optJSONObject(WebVideoActivityConfig.KEY_TAIL_FRAME));
        this.userName = jSONObject.optString("user_name");
        this.userPortrait = jSONObject.optString("user_portrait");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait_click");
        if (optJSONObject2 != null) {
            this.portraitClick = new b();
            this.portraitClick.scheme = optJSONObject2.optString("scheme");
            this.portraitClick.LW = optJSONObject2.optString("als_stat");
            this.portraitClick.LX = optJSONObject2.optString("url_stat");
            this.portraitClick.fXZ = optJSONObject2.optInt("need_login");
        } else {
            this.portraitClick = null;
        }
        this.threadTitle = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        this.threadContent = jSONObject.optString("thread_content");
        this.popWindowText = jSONObject.optString("pop_window_text");
        this.goodsStyle = com.baidu.adp.lib.g.b.g(jSONObject.optString("goods_style"), -1);
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
                        this.threadPicList[i].fYc = new b();
                        this.threadPicList[i].fYc.scheme = optJSONObject3.optString("scheme");
                        getPropertyFromScheme(this.threadPicList[i].fYc.scheme);
                        this.threadPicList[i].fYc.LW = optJSONObject3.optString("als_stat");
                        this.threadPicList[i].fYc.LX = optJSONObject3.optString("url_stat");
                        this.threadPicList[i].fYc.fXZ = optJSONObject3.optInt("need_login");
                    } else {
                        this.threadPicList[i].fYc = null;
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
            this.buttonClick.scheme = optJSONObject4.optString("scheme");
            this.buttonClick.LW = optJSONObject4.optString("als_stat");
            this.buttonClick.LX = optJSONObject4.optString("url_stat");
            this.buttonClick.fXZ = optJSONObject4.optInt("need_login");
        } else {
            this.buttonClick = null;
        }
        this.adSource = jSONObject.optString("ad_source");
        this.tagNameUrl = jSONObject.optString("tag_name_url");
        this.tagName = jSONObject.optString("tag_name");
        String optString = jSONObject.optString("tag_name_wh");
        if (!TextUtils.isEmpty(optString) && optString.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            try {
                String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int g2 = com.baidu.adp.lib.g.b.g(split[0], 1);
                int g3 = com.baidu.adp.lib.g.b.g(split[1], 1);
                if (g3 != 0) {
                    this.tagNameRatio = g2 / g3;
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
        this.sScore = jSONObject.optString("s_score");
        this.activityNum = rS(jSONObject.optString("activity_num"));
        this.buttonStatus = jSONObject.optInt("button_status");
        this.buttonTextDone = jSONObject.optString("button_text_done");
        this.activityId = jSONObject.optInt(GroupActivityActivityConfig.ACTIVITY_ID);
        this.localAdsAddress = jSONObject.optString("address", "");
        this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, System.currentTimeMillis());
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
                    this.subUrlInfos[i2].fYd = optJSONArray2.getJSONObject(i2).optString("t_color");
                    this.subUrlInfos[i2].fYe = optJSONArray2.getJSONObject(i2).optString("t_color_n");
                    JSONObject optJSONObject5 = optJSONArray2.getJSONObject(i2).optJSONObject("sub_click");
                    if (optJSONObject5 != null) {
                        this.subUrlInfos[i2].fYf = new b();
                        this.subUrlInfos[i2].fYf.scheme = optJSONObject5.optString("scheme");
                        getPropertyFromScheme(this.subUrlInfos[i2].fYf.scheme);
                        this.subUrlInfos[i2].fYf.LW = optJSONObject5.optString("als_stat");
                        this.subUrlInfos[i2].fYf.LX = optJSONObject5.optString("url_stat");
                        this.subUrlInfos[i2].fYf.fXZ = optJSONObject5.optInt("need_login");
                    } else {
                        this.subUrlInfos[i2].fYf = null;
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
            this.vrVideoInfo.Wu = jSONObject.optString("brand_icon", "");
            this.vrVideoInfo.videoInfo = this.videoInfo;
            String optString2 = jSONObject.optString("brand_icon_wh", null);
            if (!an.isEmpty(optString2)) {
                try {
                    String[] split2 = optString2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int g4 = com.baidu.adp.lib.g.b.g(split2[0], 1);
                    int g5 = com.baidu.adp.lib.g.b.g(split2[1], 1);
                    if (g5 != 0) {
                        this.vrVideoInfo.Wv = g4 / g5;
                    } else {
                        this.vrVideoInfo.Wv = 1.0f;
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
            this.activityNum = rS(gVar.Dj());
            if (gVar.Di() == 1) {
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
        if (!this.tailFrame.fYb) {
            this.tailFrame.a(this.appInfo, this);
        }
    }

    public void updataThreadData(bd bdVar) {
        if (bdVar != null) {
            bdVar.n(this.time / 1000);
            bdVar.bO(this.reply_num);
            bdVar.bX(this.agree_num);
            bdVar.o(this.share_num);
            bdVar.setAddress(this.localAdsAddress);
            bdVar.setTitle(this.threadTitle);
            bdVar.cO(this.threadContent);
            bdVar.rQ().setName_show(this.userName);
            bdVar.rQ().setPortrait(this.userPortrait);
        }
    }

    private String rS(String str) {
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
                return this.videoInfo != null && !StringUtils.isNull(this.videoInfo.video_url) && this.videoInfo.video_height.intValue() > 0 && this.videoInfo.video_width.intValue() > 0 && this.videoInfo.video_duration.intValue() > 0;
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
