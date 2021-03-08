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
    private String bAH;
    private String bAI;
    private String bAy;
    private String eOs;
    private boolean isSelected;
    private String kah;
    private b kai;
    private String kaj;
    private String kak;
    private String kal;
    private String kam;
    private String kan;
    private List<C0779a> kao;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void LF(String str) {
        this.kah = str;
    }

    public String cOz() {
        return this.bAy;
    }

    public void LG(String str) {
        this.bAy = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void LH(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cOA() {
        return this.kai;
    }

    public void a(b bVar) {
        this.kai = bVar;
    }

    public void LI(String str) {
        this.kaj = str;
    }

    public String cOB() {
        return this.kak;
    }

    public void LJ(String str) {
        this.kak = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void LK(String str) {
        this.kal = str;
    }

    public void LL(String str) {
        this.kam = str;
    }

    public void LM(String str) {
        this.bAI = str;
    }

    public void LN(String str) {
        this.bAH = str;
    }

    public void LO(String str) {
        this.kan = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cOC() {
        return this.eOs;
    }

    public void LP(String str) {
        this.eOs = str;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public List<C0779a> getImageList() {
        return this.kao;
    }

    public void dO(List<C0779a> list) {
        this.kao = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String kap;
        private String kaq;
        private String kar;

        public void LQ(String str) {
            this.kap = str;
        }

        public String cOD() {
            return this.kaq;
        }

        public void LR(String str) {
            this.kaq = str;
        }

        public String cOE() {
            return this.kar;
        }

        public void LS(String str) {
            this.kar = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0779a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a eu(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.LI(jSONObject.optString("commission"));
        aVar.LM(jSONObject.optString("coupon"));
        aVar.LP(jSONObject.optString("goodsId"));
        aVar.LK(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0779a c0779a = new C0779a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0779a.setSrc(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c0779a);
                }
            }
            aVar.dO(arrayList);
        }
        aVar.LO(jSONObject.optString("isBindingVideo"));
        aVar.setIsSelected(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString(IntentConfig.NID));
        aVar.LF(jSONObject.optString("originalGoodsId"));
        aVar.LH(jSONObject.optString("originalPrice"));
        aVar.LG(jSONObject.optString("originalTitle"));
        aVar.LJ(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.LN(jSONObject.optString("saleNum"));
        aVar.LL(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.LR(optJSONObject2.optString("Android"));
            bVar.LQ(optJSONObject2.optString("IOS"));
            bVar.LS(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
