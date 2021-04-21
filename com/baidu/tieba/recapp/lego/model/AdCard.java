package com.baidu.tieba.recapp.lego.model;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.downloader.OAdSqlLiteHelper;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import d.b.c.e.p.k;
import d.b.i0.r.q.a2;
import d.b.j0.d3.v;
import d.b.j0.j1.o.h.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AdCard extends BaseLegoCardInfo implements AdvertAppInfo.ILegoAdvert, d.b.j0.s2.b0.a, d.b.j0.j1.o.h.b {
    public static final int BUTTON_DISABLED = 0;
    public static final int BUTTON_ENABLED = 1;
    public static final String CHARGE_STYLE_CPC = "cpc";
    public static final String CHARGE_STYLE_CPV = "cpv";
    public static final String DEAL_URL_AFTER_LOGIN = "deal_url_after_login";
    public static final int INVALID_NUM = -999;
    public static final int MASK_ANIMATION = 2;
    public static final int MASK_IMMERSIVE = 1;
    public static final int MASK_LANDING_PAGE = 4;
    public static final int RESIZE_PICTURE = 2;
    public static final int SUB_URL_BELOW = 2;
    public int activityId;
    public String activityNum;
    public String adId;
    public String adSource;
    public long agree_num;
    public AdvertAppInfo appInfo;
    public d.b.i0.r.q.c appInfoModel;
    public b buttonClick;
    public int buttonStatus;
    public String buttonText;
    public String buttonTextDone;
    public int cardType;
    public a chargeInfo;
    public AdCloseInfo closeInfo;
    public boolean directDownload;
    public d.b.j0.s2.c0.b.b downloadInfo;
    public String downloadKey;
    public String ext;
    public String floor;
    public boolean goLandingPage;
    public int goodsStyle;
    public int height;
    public boolean isAnimation;
    public boolean isImmersiveStyle;
    public boolean isPBBanner;
    public int labelMeasure;
    public String localAdsAddress;
    public int maxTitleLine;
    public boolean needResize;
    public String nextPageData;
    public d.b.j0.s2.c0.b.a operate;
    public b.a parallelChargeInfo;
    public d.b.j0.s2.c0.b.c picInfo;
    public String popWindowText;
    public b portraitClick;
    public int posSubUrl;
    public String preLoadInfo;
    public String recommendReason;
    public int reply_num;
    public String sScore;
    public int share_num;
    public double showWidthScale;
    public e[] subUrlInfos;
    public String tagName;
    public float tagNameRatio;
    public String tagNameUrl;
    public d.b.j0.s2.c0.b.e tailFrame;
    public String threadContent;
    public d.b.j0.s2.c0.b.d threadInfo;
    public d[] threadPicList;
    public String threadTitle;
    public long time;
    public int titleLines;
    public int urlType;
    public String userImage;
    public String userName;
    public String userPortrait;
    public f verticalVideoStyle;
    public VideoInfo videoInfo;
    public g vrVideoInfo;
    public int width;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f20397a;

        /* renamed from: b  reason: collision with root package name */
        public String f20398b;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f20399a;

        /* renamed from: b  reason: collision with root package name */
        public String f20400b;

        /* renamed from: c  reason: collision with root package name */
        public String f20401c;

        /* renamed from: d  reason: collision with root package name */
        public int f20402d;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f20403a;

        /* renamed from: b  reason: collision with root package name */
        public String f20404b;

        /* renamed from: c  reason: collision with root package name */
        public String f20405c;

        /* renamed from: d  reason: collision with root package name */
        public String f20406d;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f20403a = jSONObject.optString("style");
            this.f20404b = jSONObject.optString("brand_name");
            String str = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(this.f20403a) ? "查看详情" : "";
            String optString = jSONObject.optString("button_text", str);
            this.f20406d = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f20406d = str;
            }
            this.f20405c = jSONObject.optString("scheme");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
            if (optJSONObject != null) {
                optJSONObject.optString("pkgname");
                optJSONObject.optString("download_url");
            }
        }

        public JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.f20403a);
                jSONObject.put("brand_name", this.f20404b);
                jSONObject.put("scheme", this.f20405c);
                jSONObject.put("button_text", this.f20406d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f20407a;

        /* renamed from: b  reason: collision with root package name */
        public String f20408b;

        /* renamed from: c  reason: collision with root package name */
        public b f20409c;

        /* renamed from: d  reason: collision with root package name */
        public String f20410d;
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f20411a;

        /* renamed from: b  reason: collision with root package name */
        public String f20412b;

        /* renamed from: c  reason: collision with root package name */
        public String f20413c;

        /* renamed from: d  reason: collision with root package name */
        public b f20414d;
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f20415a;

        /* renamed from: b  reason: collision with root package name */
        public double f20416b;

        /* renamed from: c  reason: collision with root package name */
        public double f20417c;

        public static f b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            f fVar = new f();
            fVar.f20415a = jSONObject.optString("bottom_picture", "");
            jSONObject.optInt("cover_shadow_switch", 0);
            fVar.f20416b = jSONObject.optDouble("player_width_ratio", 0.0d);
            fVar.f20417c = jSONObject.optDouble("right_margin_ratio", 0.0d);
            jSONObject.optDouble("player_height_clipping_ratio", 0.0d);
            return fVar;
        }

        public boolean a() {
            return !TextUtils.isEmpty(this.f20415a);
        }
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public VideoInfo f20418a;

        /* renamed from: b  reason: collision with root package name */
        public float f20419b;
    }

    public AdCard(JSONObject jSONObject, boolean z) {
        super(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
        if (optJSONObject != null) {
            this.adId = optJSONObject.optString("id");
            this.urlType = optJSONObject.optInt("url_type");
            this.scheme = optJSONObject.optString("scheme");
            this.floor = optJSONObject.optString(IAdRequestParam.POS);
            this.ext = optJSONObject.optString("ext_info");
            this.userName = optJSONObject.optString("user_name");
            this.userImage = optJSONObject.optString("user_portrait");
            this.threadTitle = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            this.goodsStyle = optJSONObject.optInt("goods_style");
            this.cardType = optJSONObject.optInt("card_type");
            this.maxTitleLine = optJSONObject.optInt("title_lines");
            this.recommendReason = optJSONObject.optString("recommend_reason");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("close_info");
        if (optJSONObject2 != null) {
            this.closeInfo = AdCloseInfo.parseFromJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("operate");
        if (optJSONObject3 != null) {
            this.operate = d.b.j0.s2.c0.b.a.a(optJSONObject3);
        }
        d.b.j0.s2.c0.b.e eVar = new d.b.j0.s2.c0.b.e();
        this.tailFrame = eVar;
        eVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        JSONObject optJSONObject4 = jSONObject.optJSONObject("app_info");
        if (optJSONObject4 != null) {
            this.appInfoModel = d.b.i0.r.q.c.b(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pic_info");
        if (optJSONObject5 != null) {
            this.picInfo = d.b.j0.s2.c0.b.c.a(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null) {
            this.videoInfo = VideoInfo.parseFromJson(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("thread_info");
        if (optJSONObject7 != null) {
            this.threadInfo = d.b.j0.s2.c0.b.d.a(optJSONObject7);
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject(OAdSqlLiteHelper.TABLE_NAME);
        if (optJSONObject8 != null) {
            this.downloadInfo = d.b.j0.s2.c0.b.b.a(optJSONObject8);
        }
        b.a aVar = new b.a();
        this.parallelChargeInfo = aVar;
        aVar.a(jSONObject);
    }

    private String parseActivityNum(String str) {
        if (str != null && str.contains(StringUtil.ARRAY_START) && str.contains("}")) {
            String substring = str.substring(0, str.indexOf(StringUtil.ARRAY_START));
            String substring2 = str.substring(str.indexOf(StringUtil.ARRAY_START) + 1, str.indexOf("}"));
            return substring + substring2;
        }
        return str;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int checkLegal(int i) {
        return 0;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean forFree() {
        return false;
    }

    @Override // d.b.j0.s2.b0.a
    public String getAbstract() {
        return this.threadContent;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public AdvertAppInfo getAdvertAppInfo() {
        return this.appInfo;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public d.b.i0.r.q.c getAppInfoModel() {
        return this.appInfoModel;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getDownloadKey() {
        return this.downloadKey;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public String getExtInfo() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public int getGoodsStyle() {
        return this.goodsStyle;
    }

    @Override // d.b.j0.s2.b0.a
    public String getImageUrl() {
        return this.userPortrait;
    }

    public String getNextPageData() {
        return this.nextPageData;
    }

    public boolean getPageProperty(int i, int i2) {
        return (i & i2) == i2;
    }

    @Override // d.b.j0.j1.o.h.b
    public b.a getParallelCharge() {
        return this.parallelChargeInfo;
    }

    public int getPosition() {
        return this.appInfo.position;
    }

    public String getPreLoadData() {
        return this.preLoadInfo;
    }

    public void getPropertyFromScheme(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) && (indexOf = str.indexOf("?")) > -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_LEGO);
            boolean z = true;
            sb.append(str.substring(indexOf + 1));
            String queryParameter = Uri.parse(sb.toString()).getQueryParameter("page_prop");
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            Integer valueOf = Integer.valueOf(queryParameter);
            this.isAnimation = this.isAnimation || getPageProperty(valueOf.intValue(), 2);
            this.goLandingPage = this.goLandingPage || getPageProperty(valueOf.intValue(), 4);
            if (!this.isImmersiveStyle && !getPageProperty(valueOf.intValue(), 1)) {
                z = false;
            }
            this.isImmersiveStyle = z;
        }
    }

    @Override // d.b.j0.s2.b0.a
    public String getShareLink() {
        if (v.h(this.scheme)) {
            return Uri.parse(this.scheme).getQueryParameter("wap");
        }
        return this.scheme;
    }

    @Override // d.b.j0.s2.b0.a
    public AdvertAppInfo getThreadData() {
        return getAdvertAppInfo();
    }

    @Override // d.b.j0.s2.b0.a
    public String getTitle() {
        return this.threadTitle;
    }

    public boolean hasAnimation() {
        return this.isAnimation;
    }

    public boolean isGoLandingPage() {
        return this.goLandingPage;
    }

    public boolean isImmersiveStyle() {
        return this.isImmersiveStyle;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public boolean isNoPicAd() {
        int i = this.goodsStyle;
        if (i == 2 || i == 6 || i == 8) {
            d[] dVarArr = this.threadPicList;
            return dVarArr == null || dVarArr.length == 0;
        }
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

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        int i = this.goodsStyle;
        if (i != 7) {
            if (i == 8) {
                return false;
            }
            if (i != 14) {
                return super.isValid();
            }
        }
        VideoInfo videoInfo = this.videoInfo;
        if (videoInfo == null) {
            return false;
        }
        return !StringUtils.isNull(videoInfo.video_url);
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tbadk.core.data.AdvertAppInfo.ILegoAdvert
    public void setAdvertAppInfo(AdvertAppInfo advertAppInfo) {
        this.appInfo = advertAppInfo;
        updataThreadData(advertAppInfo);
        d.b.j0.s2.c0.b.e eVar = this.tailFrame;
        if (eVar.i) {
            return;
        }
        eVar.a(this.appInfo, this);
    }

    public void updataThreadData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        a2Var.Q3(this.time / 1000);
        a2Var.Z3(this.reply_num);
        a2Var.m3(this.agree_num);
        a2Var.e4(this.share_num);
        a2Var.k3(this.localAdsAddress);
        a2Var.n4(this.threadTitle);
        a2Var.i3(this.threadContent);
        a2Var.T().setName_show(this.userName);
        a2Var.T().setPortrait(this.userPortrait);
    }

    public AdCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        getPropertyFromScheme(this.scheme);
        JSONObject optJSONObject = jSONObject.optJSONObject(LegoListActivityConfig.PRE_LOAD);
        if (optJSONObject != null) {
            this.preLoadInfo = optJSONObject.toString();
        }
        this.nextPageData = jSONObject.optString(LegoListActivityConfig.NEXT_PAGE);
        a aVar = new a();
        this.chargeInfo = aVar;
        aVar.f20397a = jSONObject.optString("charge_style", CHARGE_STYLE_CPC);
        this.chargeInfo.f20398b = jSONObject.optString("charge_url");
        d.b.j0.s2.c0.b.e eVar = new d.b.j0.s2.c0.b.e();
        this.tailFrame = eVar;
        eVar.b(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        b.a aVar2 = new b.a();
        this.parallelChargeInfo = aVar2;
        aVar2.a(jSONObject);
        this.userName = jSONObject.optString("user_name");
        this.userPortrait = jSONObject.optString("user_portrait");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait_click");
        if (optJSONObject2 != null) {
            b bVar = new b();
            this.portraitClick = bVar;
            bVar.f20399a = optJSONObject2.optString("scheme");
            this.portraitClick.f20400b = optJSONObject2.optString("als_stat");
            this.portraitClick.f20401c = optJSONObject2.optString("url_stat");
            this.portraitClick.f20402d = optJSONObject2.optInt("need_login");
        } else {
            this.portraitClick = null;
        }
        this.threadTitle = jSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        this.threadContent = jSONObject.optString("thread_content");
        this.popWindowText = jSONObject.optString("pop_window_text");
        this.goodsStyle = d.b.c.e.m.b.d(jSONObject.optString("goods_style"), -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.threadPicList = new d[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.threadPicList[i] = new d();
                try {
                    this.threadPicList[i].f20407a = optJSONArray.getJSONObject(i).optString("pic");
                    this.threadPicList[i].f20408b = optJSONArray.getJSONObject(i).optString("b_desc");
                    this.threadPicList[i].f20410d = optJSONArray.getJSONObject(i).optString("title");
                    JSONObject optJSONObject3 = optJSONArray.getJSONObject(i).optJSONObject("pic_click");
                    if (optJSONObject3 != null) {
                        this.threadPicList[i].f20409c = new b();
                        this.threadPicList[i].f20409c.f20399a = optJSONObject3.optString("scheme");
                        getPropertyFromScheme(this.threadPicList[i].f20409c.f20399a);
                        this.threadPicList[i].f20409c.f20400b = optJSONObject3.optString("als_stat");
                        this.threadPicList[i].f20409c.f20401c = optJSONObject3.optString("url_stat");
                        this.threadPicList[i].f20409c.f20402d = optJSONObject3.optInt("need_login");
                    } else {
                        this.threadPicList[i].f20409c = null;
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
        int optInt = jSONObject.optInt("label_measure");
        this.labelMeasure = optInt;
        this.needResize = optInt == 2;
        JSONObject optJSONObject4 = jSONObject.optJSONObject("button_click");
        if (optJSONObject4 != null) {
            b bVar2 = new b();
            this.buttonClick = bVar2;
            bVar2.f20399a = optJSONObject4.optString("scheme");
            this.buttonClick.f20400b = optJSONObject4.optString("als_stat");
            this.buttonClick.f20401c = optJSONObject4.optString("url_stat");
            this.buttonClick.f20402d = optJSONObject4.optInt("need_login");
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
                int d2 = d.b.c.e.m.b.d(split[0], 1);
                int d3 = d.b.c.e.m.b.d(split[1], 1);
                if (d3 != 0) {
                    this.tagNameRatio = d2 / d3;
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
        this.sScore = jSONObject.optString("s_score");
        this.activityNum = parseActivityNum(jSONObject.optString("activity_num"));
        this.buttonStatus = jSONObject.optInt("button_status");
        this.buttonTextDone = jSONObject.optString("button_text_done");
        this.activityId = jSONObject.optInt("activity_id");
        this.localAdsAddress = jSONObject.optString("address", "");
        this.time = jSONObject.optLong("time", System.currentTimeMillis());
        this.reply_num = jSONObject.optInt("reply_num", -999);
        this.agree_num = jSONObject.optInt("agree_num", -999);
        this.share_num = jSONObject.optInt("share_num", -999);
        this.posSubUrl = jSONObject.optInt("pos_sub_url");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sub_url_info");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.subUrlInfos = new e[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                this.subUrlInfos[i2] = new e();
                try {
                    this.subUrlInfos[i2].f20411a = optJSONArray2.getJSONObject(i2).optString("text");
                    this.subUrlInfos[i2].f20412b = optJSONArray2.getJSONObject(i2).optString("t_color");
                    this.subUrlInfos[i2].f20413c = optJSONArray2.getJSONObject(i2).optString("t_color_n");
                    JSONObject optJSONObject5 = optJSONArray2.getJSONObject(i2).optJSONObject("sub_click");
                    if (optJSONObject5 != null) {
                        this.subUrlInfos[i2].f20414d = new b();
                        this.subUrlInfos[i2].f20414d.f20399a = optJSONObject5.optString("scheme");
                        getPropertyFromScheme(this.subUrlInfos[i2].f20414d.f20399a);
                        this.subUrlInfos[i2].f20414d.f20400b = optJSONObject5.optString("als_stat");
                        this.subUrlInfos[i2].f20414d.f20401c = optJSONObject5.optString("url_stat");
                        this.subUrlInfos[i2].f20414d.f20402d = optJSONObject5.optInt("need_login");
                    } else {
                        this.subUrlInfos[i2].f20414d = null;
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        } else {
            this.subUrlInfos = null;
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
        if (optJSONObject6 != null && optJSONObject6.length() > 0) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = optJSONObject6.optString(VideoFinishResult.KEY_VIDEO_MD5, "");
            builder.video_url = optJSONObject6.optString("video_url", "");
            builder.video_duration = Integer.valueOf(optJSONObject6.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
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
            jSONObject.optString("brand_icon", "");
            this.vrVideoInfo.f20418a = this.videoInfo;
            String optString2 = jSONObject.optString("brand_icon_wh", null);
            if (!k.isEmpty(optString2)) {
                try {
                    String[] split2 = optString2.split(",");
                    int d4 = d.b.c.e.m.b.d(split2[0], 1);
                    int d5 = d.b.c.e.m.b.d(split2[1], 1);
                    if (d5 != 0) {
                        this.vrVideoInfo.f20419b = d4 / d5;
                    } else {
                        this.vrVideoInfo.f20419b = 1.0f;
                    }
                } catch (Exception e5) {
                    BdLog.e(e5.getMessage());
                }
            }
        } else {
            this.vrVideoInfo = null;
        }
        this.directDownload = jSONObject.optInt("direct_download_switch", 1) == 1;
        this.showWidthScale = jSONObject.optDouble("show_width_scale", 1.0d);
        this.titleLines = jSONObject.optInt("title_lines", 4);
        this.recommendReason = jSONObject.optString("recommend_reason", "");
        this.appInfoModel = d.b.i0.r.q.c.b(jSONObject.optJSONObject("app_info"));
        this.downloadKey = jSONObject.optString("download_key");
        this.verticalVideoStyle = f.b(jSONObject.optJSONObject("vertical_video_style"));
    }
}
