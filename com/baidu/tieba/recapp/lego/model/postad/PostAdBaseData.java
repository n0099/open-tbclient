package com.baidu.tieba.recapp.lego.model.postad;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.ar.load.util.DownloadConstants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bc;
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

    @Override // com.baidu.adp.widget.ListView.h
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
        public int agree_num;
        public String content;
        public String forum_name;
        private List<String> goB;
        public int goodsStyle;
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

        public List<String> bpb() {
            return this.goB;
        }

        public static b Z(JSONObject jSONObject) {
            AdCard.d[] dVarArr;
            b bVar = new b();
            if (jSONObject == null) {
                return bVar;
            }
            bVar.style = jSONObject.optString("style");
            bVar.scheme = jSONObject.optString("scheme");
            bVar.goodsStyle = com.baidu.adp.lib.g.b.g(jSONObject.optString("goods_style"), -1);
            bVar.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
            JSONObject optJSONObject = jSONObject.optJSONObject("portrait_click");
            if (optJSONObject != null) {
                bVar.portraitClick = new AdCard.b();
                bVar.portraitClick.scheme = optJSONObject.optString("scheme");
                bVar.portraitClick.Ue = optJSONObject.optString("alsStat");
                bVar.portraitClick.Uf = optJSONObject.optString("urlStat");
                bVar.portraitClick.gol = optJSONObject.optInt("need_login");
            } else {
                bVar.portraitClick = null;
            }
            bVar.content = jSONObject.optString("content");
            bVar.title = jSONObject.optString("title");
            bVar.username = jSONObject.optString("name");
            bVar.time = jSONObject.optInt("time");
            bVar.forum_name = jSONObject.optString("forum_name");
            bVar.reply_num = jSONObject.optInt("reply_num", 0);
            bVar.agree_num = jSONObject.optInt("agree_num", 0);
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
                            bVar.threadPicList[i].gon = new AdCard.b();
                            bVar.threadPicList[i].gon.scheme = optJSONObject2.optString("scheme");
                            bVar.threadPicList[i].gon.Ue = optJSONObject2.optString("alsStat");
                            bVar.threadPicList[i].gon.Uf = optJSONObject2.optString("urlStat");
                        } else {
                            bVar.threadPicList[i].gon = null;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                bVar.threadPicList = null;
            }
            bVar.goB = new ArrayList();
            if (bVar.threadPicList != null) {
                for (AdCard.d dVar : bVar.threadPicList) {
                    if (!TextUtils.isEmpty(dVar.pic)) {
                        bVar.goB.add(dVar.pic);
                    }
                }
            }
            return bVar;
        }

        public void updataThreadData(bc bcVar) {
            if (bcVar != null) {
                bcVar.dq(this.content);
                bcVar.setTitle(this.title);
                bcVar.q(this.time);
                bcVar.dp(this.forum_name);
                bcVar.bR(this.reply_num);
                bcVar.ca(this.agree_num);
                bcVar.vw().setName_show(this.username);
                bcVar.vw().setPortrait(this.portrait);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public b buttonClick;
        public String buttonText;
        public c extraData;
        public String goy;
        public String goz;
        public String scheme;
        public String style;
        public String tagName;
        public int type;

        /* renamed from: com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0228a {
            public String downloadUrl;
            public String packageName;
        }

        /* loaded from: classes3.dex */
        public static class b {
            public String Ue;
            public String Uf;
            public String scheme;
        }

        /* loaded from: classes3.dex */
        public static final class c {
            public C0228a goA;
        }

        public int sj(int i) {
            if (!"jump".equals(this.style) && i != 1 && !"apk_download".equals(this.style) && i != 3) {
                return 37;
            }
            if (TextUtils.isEmpty(this.scheme)) {
                return 27;
            }
            return 0;
        }

        public void i(AdvertAppInfo advertAppInfo) {
            if (advertAppInfo != null && this.extraData != null && this.extraData.goA != null) {
                advertAppInfo.aee = this.extraData.goA.downloadUrl;
                advertAppInfo.aef = this.extraData.goA.packageName;
                if ("apk_download".equals(this.style)) {
                    advertAppInfo.aec = 3;
                }
            }
        }

        public static a Y(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject == null) {
                aVar.type = 1;
            } else {
                aVar.type = 2;
                aVar.style = jSONObject.optString("style");
                aVar.scheme = jSONObject.optString("scheme");
                aVar.buttonText = jSONObject.optString("button_text");
                aVar.tagName = jSONObject.optString("tag_name");
                aVar.goy = jSONObject.optString("ad_title");
                aVar.goz = jSONObject.optString("ad_content");
                JSONObject optJSONObject = jSONObject.optJSONObject("button_click");
                if (optJSONObject != null) {
                    aVar.buttonClick = new b();
                    aVar.buttonClick.scheme = optJSONObject.optString("scheme");
                    aVar.buttonClick.Ue = optJSONObject.optString("als_stat");
                    aVar.buttonClick.Uf = optJSONObject.optString("url_stat");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ext_data");
                if (optJSONObject2 != null) {
                    aVar.extraData = new c();
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ad_download");
                    if (optJSONObject3 != null) {
                        aVar.extraData.goA = new C0228a();
                        aVar.extraData.goA.packageName = optJSONObject3.optString("pkgname");
                        aVar.extraData.goA.downloadUrl = optJSONObject3.optString(DownloadConstants.DOWNLOAD_URL);
                    }
                }
            }
            return aVar;
        }
    }
}
