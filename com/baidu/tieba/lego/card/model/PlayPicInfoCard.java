package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.tencent.open.SocialConstants;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayPicInfoCard extends BaseCardInfo implements d.a.n0.k1.o.i.a<PlayPicInfoCard> {
    public final int descOnPic;
    public final long duration;
    public final List<b> imageResList;
    public final a mBottomInfo;
    public final c mWaterMark;
    public final double ratio;
    public final int showDot;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17965a;

        /* renamed from: b  reason: collision with root package name */
        public String f17966b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.n0.k1.o.j.b f17967c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.k1.o.j.a f17968d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f17965a = jSONObject.optString("lbText");
                this.f17966b = jSONObject.optString("lbScheme");
                d.a.n0.k1.o.j.b bVar = new d.a.n0.k1.o.j.b();
                this.f17967c = bVar;
                bVar.f60351d = jSONObject.optString("rText");
                this.f17967c.f60350c = jSONObject.optInt("rIconType");
                this.f17967c.f60348a = jSONObject.optString("rIcon");
                this.f17967c.f60349b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    d.a.n0.k1.o.j.a aVar = new d.a.n0.k1.o.j.a(optJSONObject);
                    this.f17968d = aVar;
                    if (aVar.k()) {
                        return;
                    }
                    this.f17968d = null;
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            return new a(jSONObject);
        }

        public boolean b() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f17969a;

        /* renamed from: b  reason: collision with root package name */
        public String f17970b;

        /* renamed from: c  reason: collision with root package name */
        public String f17971c;

        /* renamed from: d  reason: collision with root package name */
        public String f17972d;

        /* renamed from: e  reason: collision with root package name */
        public int f17973e;

        /* renamed from: f  reason: collision with root package name */
        public int f17974f;

        /* renamed from: g  reason: collision with root package name */
        public int f17975g;

        /* renamed from: h  reason: collision with root package name */
        public int f17976h;

        /* renamed from: i  reason: collision with root package name */
        public String f17977i;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f17978a;

        /* renamed from: b  reason: collision with root package name */
        public String f17979b;

        /* renamed from: c  reason: collision with root package name */
        public int f17980c;

        /* renamed from: d  reason: collision with root package name */
        public int f17981d;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f17978a = jSONObject.optString("pic");
                this.f17979b = jSONObject.optString("picN");
                this.f17980c = jSONObject.optInt("xPos");
                this.f17981d = jSONObject.optInt("yPos");
            }
        }

        public static c a(JSONObject jSONObject) {
            c cVar = new c(jSONObject);
            if (cVar.b()) {
                return cVar;
            }
            return null;
        }

        public boolean b() {
            return (TextUtils.isEmpty(this.f17978a) && TextUtils.isEmpty(this.f17979b) && this.f17980c == 0 && this.f17981d == 0) ? false : true;
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
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("pic");
            if (!TextUtils.isEmpty(optString)) {
                b bVar = new b();
                bVar.f17977i = this.statistics;
                bVar.f17975g = this.statTab;
                bVar.f17969a = optJSONObject.optString("picId");
                bVar.f17970b = optString;
                bVar.f17971c = optJSONObject.optString("scheme");
                bVar.f17972d = optJSONObject.optString("desc");
                bVar.f17973e = d.a.n0.k1.o.k.b.b(optJSONObject.optString("descColor", ""));
                bVar.f17974f = d.a.n0.k1.o.k.b.b(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.f17976h = optInt <= 1 ? 1 : optInt;
                this.imageResList.add(bVar);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bInfo");
        if (optJSONObject2 != null) {
            this.mBottomInfo = a.a(optJSONObject2);
        } else {
            this.mBottomInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wMark");
        if (optJSONObject3 != null) {
            this.mWaterMark = c.a(optJSONObject3);
        } else {
            this.mWaterMark = null;
        }
    }

    public a getBottomInfo() {
        return this.mBottomInfo;
    }

    public int getDescOnPic() {
        return this.descOnPic;
    }

    public long getDuration() {
        return this.duration;
    }

    public List<b> getImageResList() {
        return this.imageResList;
    }

    public int getMaxLineForToptitle() {
        int i2;
        int i3 = 1;
        for (b bVar : this.imageResList) {
            if (bVar != null && (i2 = bVar.f17976h) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.ratio;
    }

    public int getShowDot() {
        return this.showDot;
    }

    public c getWaterMark() {
        return this.mWaterMark;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return this.imageResList.size() != 0 && super.isValid();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.k1.o.i.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = (int) (k * playPicInfoCard.ratio);
        for (b bVar : this.imageResList) {
            d.h().k(bVar.f17970b, 17, null, k, i2, tbPageContext.getUniqueId(), new Object[0]);
        }
    }
}
