package com.baidu.tieba.j;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bqm;
    private String bqv;
    private String bqw;
    private String eyB;
    private boolean isSelected;
    private String jua;
    private b jub;
    private String juc;
    private String jud;
    private String jue;
    private String juf;
    private String jug;
    private List<C0778a> juh;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void KL(String str) {
        this.jua = str;
    }

    public String cHD() {
        return this.bqm;
    }

    public void KM(String str) {
        this.bqm = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void KN(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cHE() {
        return this.jub;
    }

    public void a(b bVar) {
        this.jub = bVar;
    }

    public void KO(String str) {
        this.juc = str;
    }

    public String cHF() {
        return this.jud;
    }

    public void KP(String str) {
        this.jud = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void KQ(String str) {
        this.jue = str;
    }

    public void KR(String str) {
        this.juf = str;
    }

    public void KS(String str) {
        this.bqw = str;
    }

    public void KT(String str) {
        this.bqv = str;
    }

    public void KU(String str) {
        this.jug = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cHG() {
        return this.eyB;
    }

    public void KV(String str) {
        this.eyB = str;
    }

    public void qM(boolean z) {
        this.isSelected = z;
    }

    public List<C0778a> getImageList() {
        return this.juh;
    }

    public void dA(List<C0778a> list) {
        this.juh = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jui;
        private String juj;
        private String juk;

        public void KW(String str) {
            this.jui = str;
        }

        public String cHH() {
            return this.juj;
        }

        public void KX(String str) {
            this.juj = str;
        }

        public String cHI() {
            return this.juk;
        }

        public void KY(String str) {
            this.juk = str;
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

    public static a eb(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.KO(jSONObject.optString("commission"));
        aVar.KS(jSONObject.optString("coupon"));
        aVar.KV(jSONObject.optString("goodsId"));
        aVar.KQ(jSONObject.optString("goodsStatus"));
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
            aVar.dA(arrayList);
        }
        aVar.KU(jSONObject.optString("isBindingVideo"));
        aVar.qM(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.KL(jSONObject.optString("originalGoodsId"));
        aVar.KN(jSONObject.optString("originalPrice"));
        aVar.KM(jSONObject.optString("originalTitle"));
        aVar.KP(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.KT(jSONObject.optString("saleNum"));
        aVar.KR(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.KX(optJSONObject2.optString("Android"));
            bVar.KW(optJSONObject2.optString("IOS"));
            bVar.KY(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
