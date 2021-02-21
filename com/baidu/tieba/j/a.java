package com.baidu.tieba.j;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String byY;
    private String bzh;
    private String bzi;
    private String eMR;
    private boolean isSelected;
    private String jYf;
    private b jYg;
    private String jYh;
    private String jYi;
    private String jYj;
    private String jYk;
    private String jYl;
    private List<C0773a> jYm;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Lz(String str) {
        this.jYf = str;
    }

    public String cOs() {
        return this.byY;
    }

    public void LA(String str) {
        this.byY = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void LB(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cOt() {
        return this.jYg;
    }

    public void a(b bVar) {
        this.jYg = bVar;
    }

    public void LC(String str) {
        this.jYh = str;
    }

    public String cOu() {
        return this.jYi;
    }

    public void LD(String str) {
        this.jYi = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LE(String str) {
        this.jYj = str;
    }

    public void LF(String str) {
        this.jYk = str;
    }

    public void LG(String str) {
        this.bzi = str;
    }

    public void LH(String str) {
        this.bzh = str;
    }

    public void LI(String str) {
        this.jYl = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cOv() {
        return this.eMR;
    }

    public void LJ(String str) {
        this.eMR = str;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public List<C0773a> getImageList() {
        return this.jYm;
    }

    public void dO(List<C0773a> list) {
        this.jYm = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jYn;
        private String jYo;
        private String jYp;

        public void LK(String str) {
            this.jYn = str;
        }

        public String cOw() {
            return this.jYo;
        }

        public void LL(String str) {
            this.jYo = str;
        }

        public String cOx() {
            return this.jYp;
        }

        public void LM(String str) {
            this.jYp = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0773a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a es(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.LC(jSONObject.optString("commission"));
        aVar.LG(jSONObject.optString("coupon"));
        aVar.LJ(jSONObject.optString("goodsId"));
        aVar.LE(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0773a c0773a = new C0773a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0773a.setSrc(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c0773a);
                }
            }
            aVar.dO(arrayList);
        }
        aVar.LI(jSONObject.optString("isBindingVideo"));
        aVar.setIsSelected(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString(IntentConfig.NID));
        aVar.Lz(jSONObject.optString("originalGoodsId"));
        aVar.LB(jSONObject.optString("originalPrice"));
        aVar.LA(jSONObject.optString("originalTitle"));
        aVar.LD(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.LH(jSONObject.optString("saleNum"));
        aVar.LF(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.LL(optJSONObject2.optString("Android"));
            bVar.LK(optJSONObject2.optString("IOS"));
            bVar.LM(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
