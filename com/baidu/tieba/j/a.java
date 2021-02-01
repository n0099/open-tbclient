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
    private String jXR;
    private b jXS;
    private String jXT;
    private String jXU;
    private String jXV;
    private String jXW;
    private String jXX;
    private List<C0772a> jXY;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Ly(String str) {
        this.jXR = str;
    }

    public String cOl() {
        return this.byY;
    }

    public void Lz(String str) {
        this.byY = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void LA(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cOm() {
        return this.jXS;
    }

    public void a(b bVar) {
        this.jXS = bVar;
    }

    public void LB(String str) {
        this.jXT = str;
    }

    public String cOn() {
        return this.jXU;
    }

    public void LC(String str) {
        this.jXU = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LD(String str) {
        this.jXV = str;
    }

    public void LE(String str) {
        this.jXW = str;
    }

    public void LF(String str) {
        this.bzi = str;
    }

    public void LG(String str) {
        this.bzh = str;
    }

    public void LH(String str) {
        this.jXX = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cOo() {
        return this.eMR;
    }

    public void LI(String str) {
        this.eMR = str;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public List<C0772a> getImageList() {
        return this.jXY;
    }

    public void dO(List<C0772a> list) {
        this.jXY = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jXZ;
        private String jYa;
        private String jYb;

        public void LJ(String str) {
            this.jXZ = str;
        }

        public String cOp() {
            return this.jYa;
        }

        public void LK(String str) {
            this.jYa = str;
        }

        public String cOq() {
            return this.jYb;
        }

        public void LL(String str) {
            this.jYb = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0772a {
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
        aVar.LB(jSONObject.optString("commission"));
        aVar.LF(jSONObject.optString("coupon"));
        aVar.LI(jSONObject.optString("goodsId"));
        aVar.LD(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0772a c0772a = new C0772a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0772a.setSrc(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c0772a);
                }
            }
            aVar.dO(arrayList);
        }
        aVar.LH(jSONObject.optString("isBindingVideo"));
        aVar.setIsSelected(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString(IntentConfig.NID));
        aVar.Ly(jSONObject.optString("originalGoodsId"));
        aVar.LA(jSONObject.optString("originalPrice"));
        aVar.Lz(jSONObject.optString("originalTitle"));
        aVar.LC(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.LG(jSONObject.optString("saleNum"));
        aVar.LE(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.LK(optJSONObject2.optString("Android"));
            bVar.LJ(optJSONObject2.optString("IOS"));
            bVar.LL(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
