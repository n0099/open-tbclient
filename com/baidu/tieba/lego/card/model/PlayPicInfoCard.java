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
public class PlayPicInfoCard extends BaseCardInfo implements d.a.j0.j1.o.i.a<PlayPicInfoCard> {
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
        public String f18664a;

        /* renamed from: b  reason: collision with root package name */
        public String f18665b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.j0.j1.o.j.b f18666c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.j0.j1.o.j.a f18667d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18664a = jSONObject.optString("lbText");
                this.f18665b = jSONObject.optString("lbScheme");
                d.a.j0.j1.o.j.b bVar = new d.a.j0.j1.o.j.b();
                this.f18666c = bVar;
                bVar.f55775d = jSONObject.optString("rText");
                this.f18666c.f55774c = jSONObject.optInt("rIconType");
                this.f18666c.f55772a = jSONObject.optString("rIcon");
                this.f18666c.f55773b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    d.a.j0.j1.o.j.a aVar = new d.a.j0.j1.o.j.a(optJSONObject);
                    this.f18667d = aVar;
                    if (aVar.k()) {
                        return;
                    }
                    this.f18667d = null;
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
        public String f18668a;

        /* renamed from: b  reason: collision with root package name */
        public String f18669b;

        /* renamed from: c  reason: collision with root package name */
        public String f18670c;

        /* renamed from: d  reason: collision with root package name */
        public String f18671d;

        /* renamed from: e  reason: collision with root package name */
        public int f18672e;

        /* renamed from: f  reason: collision with root package name */
        public int f18673f;

        /* renamed from: g  reason: collision with root package name */
        public int f18674g;

        /* renamed from: h  reason: collision with root package name */
        public int f18675h;

        /* renamed from: i  reason: collision with root package name */
        public String f18676i;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f18677a;

        /* renamed from: b  reason: collision with root package name */
        public String f18678b;

        /* renamed from: c  reason: collision with root package name */
        public int f18679c;

        /* renamed from: d  reason: collision with root package name */
        public int f18680d;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18677a = jSONObject.optString("pic");
                this.f18678b = jSONObject.optString("picN");
                this.f18679c = jSONObject.optInt("xPos");
                this.f18680d = jSONObject.optInt("yPos");
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
            return (TextUtils.isEmpty(this.f18677a) && TextUtils.isEmpty(this.f18678b) && this.f18679c == 0 && this.f18680d == 0) ? false : true;
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
                bVar.f18676i = this.statistics;
                bVar.f18674g = this.statTab;
                bVar.f18668a = optJSONObject.optString("picId");
                bVar.f18669b = optString;
                bVar.f18670c = optJSONObject.optString("scheme");
                bVar.f18671d = optJSONObject.optString("desc");
                bVar.f18672e = d.a.j0.j1.o.k.b.b(optJSONObject.optString("descColor", ""));
                bVar.f18673f = d.a.j0.j1.o.k.b.b(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.f18675h = optInt <= 1 ? 1 : optInt;
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
            if (bVar != null && (i2 = bVar.f18675h) > i3) {
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
    @Override // d.a.j0.j1.o.i.a
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        if (playPicInfoCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = (int) (k * playPicInfoCard.ratio);
        for (b bVar : this.imageResList) {
            d.h().k(bVar.f18669b, 17, null, k, i2, tbPageContext.getUniqueId(), new Object[0]);
        }
    }
}
