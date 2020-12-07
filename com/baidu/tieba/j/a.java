package com.baidu.tieba.j;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bvG;
    private String bvH;
    private String bvx;
    private String eFA;
    private boolean isSelected;
    private String jHA;
    private b jHB;
    private String jHC;
    private String jHD;
    private String jHE;
    private String jHF;
    private String jHG;
    private List<C0794a> jHH;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void LS(String str) {
        this.jHA = str;
    }

    public String cMR() {
        return this.bvx;
    }

    public void LT(String str) {
        this.bvx = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void LU(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cMS() {
        return this.jHB;
    }

    public void a(b bVar) {
        this.jHB = bVar;
    }

    public void LV(String str) {
        this.jHC = str;
    }

    public String cMT() {
        return this.jHD;
    }

    public void LW(String str) {
        this.jHD = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LX(String str) {
        this.jHE = str;
    }

    public void LY(String str) {
        this.jHF = str;
    }

    public void LZ(String str) {
        this.bvH = str;
    }

    public void Ma(String str) {
        this.bvG = str;
    }

    public void Mb(String str) {
        this.jHG = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cMU() {
        return this.eFA;
    }

    public void Mc(String str) {
        this.eFA = str;
    }

    public void rn(boolean z) {
        this.isSelected = z;
    }

    public List<C0794a> getImageList() {
        return this.jHH;
    }

    public void dJ(List<C0794a> list) {
        this.jHH = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jHI;
        private String jHJ;
        private String jHK;

        public void Md(String str) {
            this.jHI = str;
        }

        public String cMV() {
            return this.jHJ;
        }

        public void Me(String str) {
            this.jHJ = str;
        }

        public String cMW() {
            return this.jHK;
        }

        public void Mf(String str) {
            this.jHK = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0794a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a ed(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.LV(jSONObject.optString("commission"));
        aVar.LZ(jSONObject.optString("coupon"));
        aVar.Mc(jSONObject.optString("goodsId"));
        aVar.LX(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0794a c0794a = new C0794a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0794a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0794a);
                }
            }
            aVar.dJ(arrayList);
        }
        aVar.Mb(jSONObject.optString("isBindingVideo"));
        aVar.rn(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.LS(jSONObject.optString("originalGoodsId"));
        aVar.LU(jSONObject.optString("originalPrice"));
        aVar.LT(jSONObject.optString("originalTitle"));
        aVar.LW(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Ma(jSONObject.optString("saleNum"));
        aVar.LY(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Me(optJSONObject2.optString("Android"));
            bVar.Md(optJSONObject2.optString("IOS"));
            bVar.Mf(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
