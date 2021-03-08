package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PlayPicInfoCard extends BaseCardInfo implements com.baidu.tieba.lego.card.b.a<PlayPicInfoCard> {
    final int descOnPic;
    final long duration;
    final List<b> imageResList;
    final a mBottomInfo;
    final c mWaterMark;
    final double ratio;
    final int showDot;

    /* loaded from: classes8.dex */
    public static class b {
        public String desc;
        public int ler;
        public int les;
        public int let;
        public String pic;
        public String picId;
        public String scheme;
        public int statTab;
        public String statistics;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.b.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard != null && tbPageContext != null) {
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int i = (int) (equipmentWidth * playPicInfoCard.ratio);
            for (b bVar : this.imageResList) {
                d.mw().a(bVar.pic, 17, null, equipmentWidth, i, tbPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public com.baidu.tieba.lego.card.model.b lep;
        public com.baidu.tieba.lego.card.model.a leq;
        public String mForumName;
        public String mScheme;

        private a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mForumName = jSONObject.optString("lbText");
                this.mScheme = jSONObject.optString("lbScheme");
                this.lep = new com.baidu.tieba.lego.card.model.b();
                this.lep.content = jSONObject.optString("rText");
                this.lep.type = jSONObject.optInt("rIconType");
                this.lep.url = jSONObject.optString("rIcon");
                this.lep.lee = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    this.leq = new com.baidu.tieba.lego.card.model.a(optJSONObject);
                    if (!this.leq.isValid()) {
                        this.leq = null;
                    }
                }
            }
        }

        public static a eC(JSONObject jSONObject) {
            return new a(jSONObject);
        }

        public boolean isValid() {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String leu;
        public int lev;
        public int lew;
        public String picUrl;

        private c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.picUrl = jSONObject.optString("pic");
                this.leu = jSONObject.optString("picN");
                this.lev = jSONObject.optInt("xPos");
                this.lew = jSONObject.optInt("yPos");
            }
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) && TextUtils.isEmpty(this.leu) && this.lev == 0 && this.lew == 0) ? false : true;
        }

        public static c eD(JSONObject jSONObject) {
            c cVar = new c(jSONObject);
            if (!cVar.isValid()) {
                return null;
            }
            return cVar;
        }
    }

    public PlayPicInfoCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        this.ratio = jSONObject.optDouble("ratio", -1.0d);
        this.duration = jSONObject.optLong("duration", 5000L);
        this.descOnPic = jSONObject.optInt("descOnPic", 1);
        this.showDot = jSONObject.optInt("show_dot", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE);
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.imageResList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("pic");
            if (!TextUtils.isEmpty(optString)) {
                b bVar = new b();
                bVar.statistics = this.statistics;
                bVar.statTab = this.statTab;
                bVar.picId = optJSONObject.optString("picId");
                bVar.pic = optString;
                bVar.scheme = optJSONObject.optString("scheme");
                bVar.desc = optJSONObject.optString("desc");
                bVar.ler = com.baidu.tieba.lego.card.c.b.rT(optJSONObject.optString("descColor", ""));
                bVar.les = com.baidu.tieba.lego.card.c.b.rT(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.let = optInt <= 1 ? 1 : optInt;
                this.imageResList.add(bVar);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bInfo");
        if (optJSONObject2 != null) {
            this.mBottomInfo = a.eC(optJSONObject2);
        } else {
            this.mBottomInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wMark");
        if (optJSONObject3 != null) {
            this.mWaterMark = c.eD(optJSONObject3);
        } else {
            this.mWaterMark = null;
        }
    }

    public int getMaxLineForToptitle() {
        int i = 1;
        Iterator<b> it = this.imageResList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                b next = it.next();
                if (next != null && next.let > i2) {
                    i2 = next.let;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    public c getWaterMark() {
        return this.mWaterMark;
    }

    public a getBottomInfo() {
        return this.mBottomInfo;
    }

    public List<b> getImageResList() {
        return this.imageResList;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getDescOnPic() {
        return this.descOnPic;
    }

    public int getShowDot() {
        return this.showDot;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return this.imageResList.size() != 0 && super.isValid();
    }
}
