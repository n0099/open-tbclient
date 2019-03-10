package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.ubc.UBC;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PlayPicInfoCard extends BaseCardInfo implements com.baidu.tieba.lego.card.c.a<PlayPicInfoCard> {
    final int descOnPic;
    final long duration;
    final List<b> imageResList;
    final a mBottomInfo;
    final c mWaterMark;
    final double ratio;
    final int showDot;

    /* loaded from: classes2.dex */
    public static class b {
        public String desc;
        public int gHo;
        public int gHp;
        public int lines;
        public String pic;
        public String picId;
        public String scheme;
        public int statTab;
        public String statistics;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.c.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard != null && tbPageContext != null) {
            int aO = l.aO(TbadkCoreApplication.getInst());
            int i = (int) (aO * playPicInfoCard.ratio);
            for (b bVar : this.imageResList) {
                com.baidu.adp.lib.f.c.jB().a(bVar.pic, 17, null, aO, i, tbPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public String aSu;
        public com.baidu.tieba.lego.card.model.b gHm;
        public com.baidu.tieba.lego.card.model.a gHn;
        public String mForumName;

        private a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.mForumName = jSONObject.optString("lbText");
                this.aSu = jSONObject.optString("lbScheme");
                this.gHm = new com.baidu.tieba.lego.card.model.b();
                this.gHm.content = jSONObject.optString("rText");
                this.gHm.type = jSONObject.optInt("rIconType");
                this.gHm.url = jSONObject.optString("rIcon");
                this.gHm.gHc = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    this.gHn = new com.baidu.tieba.lego.card.model.a(optJSONObject);
                    if (!this.gHn.isValid()) {
                        this.gHn = null;
                    }
                }
            }
        }

        public static a bv(JSONObject jSONObject) {
            return new a(jSONObject);
        }

        public boolean isValid() {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public String gHq;
        public int gHr;
        public int gHs;
        public String picUrl;

        private c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.picUrl = jSONObject.optString("pic");
                this.gHq = jSONObject.optString("picN");
                this.gHr = jSONObject.optInt("xPos");
                this.gHs = jSONObject.optInt("yPos");
            }
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.picUrl) && TextUtils.isEmpty(this.gHq) && this.gHr == 0 && this.gHs == 0) ? false : true;
        }

        public static c bw(JSONObject jSONObject) {
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
        this.duration = jSONObject.optLong(UBC.CONTENT_KEY_DURATION, TbConfig.NOTIFY_SOUND_INTERVAL);
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
                bVar.gHo = com.baidu.tieba.lego.card.d.a.parseColor(optJSONObject.optString("descColor", ""));
                bVar.gHp = com.baidu.tieba.lego.card.d.a.parseColor(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.lines = optInt <= 1 ? 1 : optInt;
                this.imageResList.add(bVar);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bInfo");
        if (optJSONObject2 != null) {
            this.mBottomInfo = a.bv(optJSONObject2);
        } else {
            this.mBottomInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wMark");
        if (optJSONObject3 != null) {
            this.mWaterMark = c.bw(optJSONObject3);
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
                if (next != null && next.lines > i2) {
                    i2 = next.lines;
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
