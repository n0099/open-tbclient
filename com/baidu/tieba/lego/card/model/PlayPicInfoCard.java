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
        public int kTW;
        public int kTX;
        public int kTY;
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
                d.mx().a(bVar.pic, 17, null, equipmentWidth, i, tbPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public com.baidu.tieba.lego.card.model.b kTU;
        public com.baidu.tieba.lego.card.model.a kTV;
        public String mForumName;
        public String mScheme;

        private a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mForumName = jSONObject.optString("lbText");
                this.mScheme = jSONObject.optString("lbScheme");
                this.kTU = new com.baidu.tieba.lego.card.model.b();
                this.kTU.content = jSONObject.optString("rText");
                this.kTU.type = jSONObject.optInt("rIconType");
                this.kTU.url = jSONObject.optString("rIcon");
                this.kTU.kTK = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    this.kTV = new com.baidu.tieba.lego.card.model.a(optJSONObject);
                    if (!this.kTV.isValid()) {
                        this.kTV = null;
                    }
                }
            }
        }

        public static a ez(JSONObject jSONObject) {
            return new a(jSONObject);
        }

        public boolean isValid() {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String kTZ;
        public int kUa;
        public int kUb;
        public String picUrl;

        private c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.picUrl = jSONObject.optString("pic");
                this.kTZ = jSONObject.optString("picN");
                this.kUa = jSONObject.optInt("xPos");
                this.kUb = jSONObject.optInt("yPos");
            }
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) && TextUtils.isEmpty(this.kTZ) && this.kUa == 0 && this.kUb == 0) ? false : true;
        }

        public static c eA(JSONObject jSONObject) {
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
                bVar.kTW = com.baidu.tieba.lego.card.c.b.rt(optJSONObject.optString("descColor", ""));
                bVar.kTX = com.baidu.tieba.lego.card.c.b.rt(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.kTY = optInt <= 1 ? 1 : optInt;
                this.imageResList.add(bVar);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bInfo");
        if (optJSONObject2 != null) {
            this.mBottomInfo = a.ez(optJSONObject2);
        } else {
            this.mBottomInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wMark");
        if (optJSONObject3 != null) {
            this.mWaterMark = c.eA(optJSONObject3);
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
                if (next != null && next.kTY > i2) {
                    i2 = next.kTY;
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
