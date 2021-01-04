package com.baidu.tieba.j;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bAi;
    private String bAr;
    private String bAs;
    private String ePq;
    private boolean isSelected;
    private String jUU;
    private b jUV;
    private String jUW;
    private String jUX;
    private String jUY;
    private String jUZ;
    private String jVa;
    private List<C0778a> jVb;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void LT(String str) {
        this.jUU = str;
    }

    public String cQf() {
        return this.bAi;
    }

    public void LU(String str) {
        this.bAi = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void LV(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cQg() {
        return this.jUV;
    }

    public void a(b bVar) {
        this.jUV = bVar;
    }

    public void LW(String str) {
        this.jUW = str;
    }

    public String cQh() {
        return this.jUX;
    }

    public void LX(String str) {
        this.jUX = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LY(String str) {
        this.jUY = str;
    }

    public void LZ(String str) {
        this.jUZ = str;
    }

    public void Ma(String str) {
        this.bAs = str;
    }

    public void Mb(String str) {
        this.bAr = str;
    }

    public void Mc(String str) {
        this.jVa = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cQi() {
        return this.ePq;
    }

    public void Md(String str) {
        this.ePq = str;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public List<C0778a> getImageList() {
        return this.jVb;
    }

    public void dR(List<C0778a> list) {
        this.jVb = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jVc;
        private String jVd;
        private String jVe;

        public void Me(String str) {
            this.jVc = str;
        }

        public String cQj() {
            return this.jVd;
        }

        public void Mf(String str) {
            this.jVd = str;
        }

        public String cQk() {
            return this.jVe;
        }

        public void Mg(String str) {
            this.jVe = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0778a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a er(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.LW(jSONObject.optString("commission"));
        aVar.Ma(jSONObject.optString("coupon"));
        aVar.Md(jSONObject.optString("goodsId"));
        aVar.LY(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0778a c0778a = new C0778a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0778a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0778a);
                }
            }
            aVar.dR(arrayList);
        }
        aVar.Mc(jSONObject.optString("isBindingVideo"));
        aVar.setIsSelected(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString(IntentConfig.NID));
        aVar.LT(jSONObject.optString("originalGoodsId"));
        aVar.LV(jSONObject.optString("originalPrice"));
        aVar.LU(jSONObject.optString("originalTitle"));
        aVar.LX(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Mb(jSONObject.optString("saleNum"));
        aVar.LZ(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Mf(optJSONObject2.optString("Android"));
            bVar.Me(optJSONObject2.optString("IOS"));
            bVar.Mg(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
