package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.tencent.open.SocialConstants;
import d.b.b.e.l.d;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PlayPicInfoCard extends BaseCardInfo implements d.b.i0.i1.o.i.a<PlayPicInfoCard> {
    public final int descOnPic;
    public final long duration;
    public final List<b> imageResList;
    public final a mBottomInfo;
    public final c mWaterMark;
    public final double ratio;
    public final int showDot;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18621a;

        /* renamed from: b  reason: collision with root package name */
        public String f18622b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.i0.i1.o.j.b f18623c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.i1.o.j.a f18624d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18621a = jSONObject.optString("lbText");
                this.f18622b = jSONObject.optString("lbScheme");
                d.b.i0.i1.o.j.b bVar = new d.b.i0.i1.o.j.b();
                this.f18623c = bVar;
                bVar.f55941d = jSONObject.optString("rText");
                this.f18623c.f55940c = jSONObject.optInt("rIconType");
                this.f18623c.f55938a = jSONObject.optString("rIcon");
                this.f18623c.f55939b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    d.b.i0.i1.o.j.a aVar = new d.b.i0.i1.o.j.a(optJSONObject);
                    this.f18624d = aVar;
                    if (aVar.k()) {
                        return;
                    }
                    this.f18624d = null;
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

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f18625a;

        /* renamed from: b  reason: collision with root package name */
        public String f18626b;

        /* renamed from: c  reason: collision with root package name */
        public String f18627c;

        /* renamed from: d  reason: collision with root package name */
        public String f18628d;

        /* renamed from: e  reason: collision with root package name */
        public int f18629e;

        /* renamed from: f  reason: collision with root package name */
        public int f18630f;

        /* renamed from: g  reason: collision with root package name */
        public int f18631g;

        /* renamed from: h  reason: collision with root package name */
        public int f18632h;
        public String i;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f18633a;

        /* renamed from: b  reason: collision with root package name */
        public String f18634b;

        /* renamed from: c  reason: collision with root package name */
        public int f18635c;

        /* renamed from: d  reason: collision with root package name */
        public int f18636d;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18633a = jSONObject.optString("pic");
                this.f18634b = jSONObject.optString("picN");
                this.f18635c = jSONObject.optInt("xPos");
                this.f18636d = jSONObject.optInt("yPos");
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
            return (TextUtils.isEmpty(this.f18633a) && TextUtils.isEmpty(this.f18634b) && this.f18635c == 0 && this.f18636d == 0) ? false : true;
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
                bVar.f18631g = this.statTab;
                bVar.f18625a = optJSONObject.optString("picId");
                bVar.f18626b = optString;
                bVar.f18627c = optJSONObject.optString("scheme");
                bVar.f18628d = optJSONObject.optString("desc");
                bVar.f18629e = d.b.i0.i1.o.k.b.b(optJSONObject.optString("descColor", ""));
                bVar.f18630f = d.b.i0.i1.o.k.b.b(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.f18632h = optInt <= 1 ? 1 : optInt;
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
            if (bVar != null && (i = bVar.f18632h) > i2) {
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
    @Override // d.b.i0.i1.o.i.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i = (int) (k * playPicInfoCard.ratio);
        for (b bVar : this.imageResList) {
            d.h().k(bVar.f18626b, 17, null, k, i, tbPageContext.getUniqueId(), new Object[0]);
        }
    }
}
