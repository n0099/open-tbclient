package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.tencent.open.SocialConstants;
import d.b.c.e.l.d;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayPicInfoCard extends BaseCardInfo implements d.b.i0.j1.o.i.a<PlayPicInfoCard> {
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
        public String f18298a;

        /* renamed from: b  reason: collision with root package name */
        public String f18299b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.i0.j1.o.j.b f18300c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.j1.o.j.a f18301d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18298a = jSONObject.optString("lbText");
                this.f18299b = jSONObject.optString("lbScheme");
                d.b.i0.j1.o.j.b bVar = new d.b.i0.j1.o.j.b();
                this.f18300c = bVar;
                bVar.f57388d = jSONObject.optString("rText");
                this.f18300c.f57387c = jSONObject.optInt("rIconType");
                this.f18300c.f57385a = jSONObject.optString("rIcon");
                this.f18300c.f57386b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    d.b.i0.j1.o.j.a aVar = new d.b.i0.j1.o.j.a(optJSONObject);
                    this.f18301d = aVar;
                    if (aVar.k()) {
                        return;
                    }
                    this.f18301d = null;
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
        public String f18302a;

        /* renamed from: b  reason: collision with root package name */
        public String f18303b;

        /* renamed from: c  reason: collision with root package name */
        public String f18304c;

        /* renamed from: d  reason: collision with root package name */
        public String f18305d;

        /* renamed from: e  reason: collision with root package name */
        public int f18306e;

        /* renamed from: f  reason: collision with root package name */
        public int f18307f;

        /* renamed from: g  reason: collision with root package name */
        public int f18308g;

        /* renamed from: h  reason: collision with root package name */
        public int f18309h;
        public String i;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f18310a;

        /* renamed from: b  reason: collision with root package name */
        public String f18311b;

        /* renamed from: c  reason: collision with root package name */
        public int f18312c;

        /* renamed from: d  reason: collision with root package name */
        public int f18313d;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18310a = jSONObject.optString("pic");
                this.f18311b = jSONObject.optString("picN");
                this.f18312c = jSONObject.optInt("xPos");
                this.f18313d = jSONObject.optInt("yPos");
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
            return (TextUtils.isEmpty(this.f18310a) && TextUtils.isEmpty(this.f18311b) && this.f18312c == 0 && this.f18313d == 0) ? false : true;
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
                bVar.i = this.statistics;
                bVar.f18308g = this.statTab;
                bVar.f18302a = optJSONObject.optString("picId");
                bVar.f18303b = optString;
                bVar.f18304c = optJSONObject.optString("scheme");
                bVar.f18305d = optJSONObject.optString("desc");
                bVar.f18306e = d.b.i0.j1.o.k.b.b(optJSONObject.optString("descColor", ""));
                bVar.f18307f = d.b.i0.j1.o.k.b.b(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.f18309h = optInt <= 1 ? 1 : optInt;
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
        int i;
        int i2 = 1;
        for (b bVar : this.imageResList) {
            if (bVar != null && (i = bVar.f18309h) > i2) {
                i2 = i;
            }
        }
        return i2;
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
    @Override // d.b.i0.j1.o.i.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i = (int) (k * playPicInfoCard.ratio);
        for (b bVar : this.imageResList) {
            d.h().k(bVar.f18303b, 17, null, k, i, tbPageContext.getUniqueId(), new Object[0]);
        }
    }
}
