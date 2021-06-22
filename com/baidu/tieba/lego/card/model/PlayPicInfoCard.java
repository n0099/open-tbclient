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
public class PlayPicInfoCard extends BaseCardInfo implements d.a.o0.k1.o.i.a<PlayPicInfoCard> {
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
        public String f18047a;

        /* renamed from: b  reason: collision with root package name */
        public String f18048b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.o0.k1.o.j.b f18049c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.o0.k1.o.j.a f18050d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18047a = jSONObject.optString("lbText");
                this.f18048b = jSONObject.optString("lbScheme");
                d.a.o0.k1.o.j.b bVar = new d.a.o0.k1.o.j.b();
                this.f18049c = bVar;
                bVar.f60476d = jSONObject.optString("rText");
                this.f18049c.f60475c = jSONObject.optInt("rIconType");
                this.f18049c.f60473a = jSONObject.optString("rIcon");
                this.f18049c.f60474b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    d.a.o0.k1.o.j.a aVar = new d.a.o0.k1.o.j.a(optJSONObject);
                    this.f18050d = aVar;
                    if (aVar.k()) {
                        return;
                    }
                    this.f18050d = null;
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
        public String f18051a;

        /* renamed from: b  reason: collision with root package name */
        public String f18052b;

        /* renamed from: c  reason: collision with root package name */
        public String f18053c;

        /* renamed from: d  reason: collision with root package name */
        public String f18054d;

        /* renamed from: e  reason: collision with root package name */
        public int f18055e;

        /* renamed from: f  reason: collision with root package name */
        public int f18056f;

        /* renamed from: g  reason: collision with root package name */
        public int f18057g;

        /* renamed from: h  reason: collision with root package name */
        public int f18058h;

        /* renamed from: i  reason: collision with root package name */
        public String f18059i;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f18060a;

        /* renamed from: b  reason: collision with root package name */
        public String f18061b;

        /* renamed from: c  reason: collision with root package name */
        public int f18062c;

        /* renamed from: d  reason: collision with root package name */
        public int f18063d;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18060a = jSONObject.optString("pic");
                this.f18061b = jSONObject.optString("picN");
                this.f18062c = jSONObject.optInt("xPos");
                this.f18063d = jSONObject.optInt("yPos");
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
            return (TextUtils.isEmpty(this.f18060a) && TextUtils.isEmpty(this.f18061b) && this.f18062c == 0 && this.f18063d == 0) ? false : true;
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
                bVar.f18059i = this.statistics;
                bVar.f18057g = this.statTab;
                bVar.f18051a = optJSONObject.optString("picId");
                bVar.f18052b = optString;
                bVar.f18053c = optJSONObject.optString("scheme");
                bVar.f18054d = optJSONObject.optString("desc");
                bVar.f18055e = d.a.o0.k1.o.k.b.b(optJSONObject.optString("descColor", ""));
                bVar.f18056f = d.a.o0.k1.o.k.b.b(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.f18058h = optInt <= 1 ? 1 : optInt;
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
            if (bVar != null && (i2 = bVar.f18058h) > i3) {
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
    @Override // d.a.o0.k1.o.i.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = (int) (k * playPicInfoCard.ratio);
        for (b bVar : this.imageResList) {
            d.h().k(bVar.f18052b, 17, null, k, i2, tbPageContext.getUniqueId(), new Object[0]);
        }
    }
}
