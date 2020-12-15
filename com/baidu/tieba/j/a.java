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
    private String jHC;
    private b jHD;
    private String jHE;
    private String jHF;
    private String jHG;
    private String jHH;
    private String jHI;
    private List<C0794a> jHJ;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void LS(String str) {
        this.jHC = str;
    }

    public String cMS() {
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

    public b cMT() {
        return this.jHD;
    }

    public void a(b bVar) {
        this.jHD = bVar;
    }

    public void LV(String str) {
        this.jHE = str;
    }

    public String cMU() {
        return this.jHF;
    }

    public void LW(String str) {
        this.jHF = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LX(String str) {
        this.jHG = str;
    }

    public void LY(String str) {
        this.jHH = str;
    }

    public void LZ(String str) {
        this.bvH = str;
    }

    public void Ma(String str) {
        this.bvG = str;
    }

    public void Mb(String str) {
        this.jHI = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cMV() {
        return this.eFA;
    }

    public void Mc(String str) {
        this.eFA = str;
    }

    public void rn(boolean z) {
        this.isSelected = z;
    }

    public List<C0794a> getImageList() {
        return this.jHJ;
    }

    public void dJ(List<C0794a> list) {
        this.jHJ = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jHK;
        private String jHL;
        private String jHM;

        public void Md(String str) {
            this.jHK = str;
        }

        public String cMW() {
            return this.jHL;
        }

        public void Me(String str) {
            this.jHL = str;
        }

        public String cMX() {
            return this.jHM;
        }

        public void Mf(String str) {
            this.jHM = str;
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
