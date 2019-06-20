package com.baidu.tieba.recapp.lego.model.postad;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PostAdBaseData implements ICardInfo {
    public static final String STYLE_MULTI_IMAGE = "multi_image";
    public static final String STYLE_ONE_IMAGE = "one_image";
    protected AdvertAppInfo appInfo;
    protected final int cardType;
    private BdUniqueId mBdUniqueId;
    protected final String showExtra;
    protected final String showKey;

    public PostAdBaseData(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.cardType = 0;
            this.showKey = "";
            this.showExtra = "";
            return;
        }
        this.cardType = jSONObject.optInt("card_type");
        this.showKey = jSONObject.optString("showKey");
        this.showExtra = jSONObject.optString("showExtra");
    }

    public String getShowKey() {
        return this.showKey;
    }

    public String getShowExtra() {
        return this.showExtra;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mBdUniqueId;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setGroupId(String str) {
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.cardType;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public String getFlipId() {
        return null;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public ICardInfo getAdapterItem(int i) {
        return getViewItem(i, 0);
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public ICardInfo getViewItem(int i, int i2) {
        return this;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getAdapterType() {
        return getCardType();
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public ICardInfo getUpdateCard() {
        return this;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return true;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getAdapterCount() {
        return getViewCount();
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        return 1;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean responseAttention(Object obj) {
        return false;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return 0.0d;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        return getCardType() == iCardInfo.getCardType();
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public String content;
        public int erb;
        public String forum_name;
        public int goodsStyle;
        private List<String> iAU;
        public String portrait;
        public AdCard.b portraitClick;
        public int reply_num;
        public String scheme;
        public String style;
        public String tag_name;
        public AdCard.d[] threadPicList;
        public long time;
        public String title;
        public String username;

        public List<String> cfe() {
            return this.iAU;
        }

        public static b bP(JSONObject jSONObject) {
            AdCard.d[] dVarArr;
            b bVar = new b();
            if (jSONObject == null) {
                return bVar;
            }
            bVar.style = jSONObject.optString(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            bVar.scheme = jSONObject.optString("scheme");
            bVar.goodsStyle = com.baidu.adp.lib.g.b.f(jSONObject.optString("goods_style"), -1);
            bVar.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
            JSONObject optJSONObject = jSONObject.optJSONObject("portrait_click");
            if (optJSONObject != null) {
                bVar.portraitClick = new AdCard.b();
                bVar.portraitClick.scheme = optJSONObject.optString("scheme");
                bVar.portraitClick.abk = optJSONObject.optString("alsStat");
                bVar.portraitClick.abl = optJSONObject.optString("urlStat");
                bVar.portraitClick.iAF = optJSONObject.optInt("need_login");
            } else {
                bVar.portraitClick = null;
            }
            bVar.content = jSONObject.optString("content");
            bVar.title = jSONObject.optString("title");
            bVar.username = jSONObject.optString("name");
            bVar.time = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            bVar.forum_name = jSONObject.optString("forum_name");
            bVar.reply_num = jSONObject.optInt("reply_num", 0);
            bVar.erb = jSONObject.optInt("agree_num", 0);
            bVar.tag_name = jSONObject.optString("tag_name", "广告");
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                bVar.threadPicList = new AdCard.d[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    bVar.threadPicList[i] = new AdCard.d();
                    try {
                        bVar.threadPicList[i].pic = optJSONArray.getJSONObject(i).optString("pic");
                        JSONObject optJSONObject2 = optJSONArray.getJSONObject(i).optJSONObject("pic_click");
                        if (optJSONObject2 != null) {
                            bVar.threadPicList[i].iAH = new AdCard.b();
                            bVar.threadPicList[i].iAH.scheme = optJSONObject2.optString("scheme");
                            bVar.threadPicList[i].iAH.abk = optJSONObject2.optString("alsStat");
                            bVar.threadPicList[i].iAH.abl = optJSONObject2.optString("urlStat");
                        } else {
                            bVar.threadPicList[i].iAH = null;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                bVar.threadPicList = null;
            }
            bVar.iAU = new ArrayList();
            if (bVar.threadPicList != null) {
                for (AdCard.d dVar : bVar.threadPicList) {
                    if (!TextUtils.isEmpty(dVar.pic)) {
                        bVar.iAU.add(dVar.pic);
                    }
                }
            }
            return bVar;
        }

        public void updataThreadData(bg bgVar) {
            if (bgVar != null) {
                bgVar.mp(this.content);
                bgVar.setTitle(this.title);
                bgVar.aq(this.time);
                bgVar.mo(this.forum_name);
                bgVar.hc(this.reply_num);
                bgVar.hk(this.erb);
                bgVar.adv().setName_show(this.username);
                bgVar.adv().setPortrait(this.portrait);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public String RE;
        public b buttonClick;
        public String buttonText;
        public c extraData;
        public String iAS;
        public String scheme;
        public String style;
        public String tagName;
        public int type;

        /* renamed from: com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0398a {
            public String downloadUrl;
            public String packageName;
        }

        /* loaded from: classes3.dex */
        public static class b {
            public String abk;
            public String abl;
            public String scheme;
        }

        /* loaded from: classes3.dex */
        public static final class c {
            public C0398a iAT;
        }

        public int yV(int i) {
            if (!"jump".equals(this.style) && i != 1 && !"apk_download".equals(this.style) && i != 3) {
                return 37;
            }
            if (TextUtils.isEmpty(this.scheme)) {
                return 27;
            }
            return 0;
        }

        public void i(AdvertAppInfo advertAppInfo) {
            if (advertAppInfo != null && this.extraData != null && this.extraData.iAT != null) {
                advertAppInfo.bDW = this.extraData.iAT.downloadUrl;
                advertAppInfo.bDX = this.extraData.iAT.packageName;
                if ("apk_download".equals(this.style)) {
                    advertAppInfo.Sj = 3;
                }
            }
        }

        public static a bO(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject == null) {
                aVar.type = 1;
            } else {
                aVar.type = 2;
                aVar.style = jSONObject.optString(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
                aVar.scheme = jSONObject.optString("scheme");
                aVar.buttonText = jSONObject.optString("button_text");
                aVar.tagName = jSONObject.optString("tag_name");
                aVar.RE = jSONObject.optString("ad_title");
                aVar.iAS = jSONObject.optString("ad_content");
                JSONObject optJSONObject = jSONObject.optJSONObject("button_click");
                if (optJSONObject != null) {
                    aVar.buttonClick = new b();
                    aVar.buttonClick.scheme = optJSONObject.optString("scheme");
                    aVar.buttonClick.abk = optJSONObject.optString("als_stat");
                    aVar.buttonClick.abl = optJSONObject.optString("url_stat");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ext_data");
                if (optJSONObject2 != null) {
                    aVar.extraData = new c();
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ad_download");
                    if (optJSONObject3 != null) {
                        aVar.extraData.iAT = new C0398a();
                        aVar.extraData.iAT.packageName = optJSONObject3.optString("pkgname");
                        aVar.extraData.iAT.downloadUrl = optJSONObject3.optString("download_url");
                    }
                }
            }
            return aVar;
        }
    }
}
