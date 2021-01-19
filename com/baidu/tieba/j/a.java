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
    private String bvF;
    private String bvG;
    private String bvw;
    private String eKF;
    private boolean isSelected;
    private String jQp;
    private b jQq;
    private String jQr;
    private String jQs;
    private String jQt;
    private String jQu;
    private String jQv;
    private List<C0770a> jQw;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void KL(String str) {
        this.jQp = str;
    }

    public String cMo() {
        return this.bvw;
    }

    public void KM(String str) {
        this.bvw = str;
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

    public b cMp() {
        return this.jQq;
    }

    public void a(b bVar) {
        this.jQq = bVar;
    }

    public void KO(String str) {
        this.jQr = str;
    }

    public String cMq() {
        return this.jQs;
    }

    public void KP(String str) {
        this.jQs = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void KQ(String str) {
        this.jQt = str;
    }

    public void KR(String str) {
        this.jQu = str;
    }

    public void KS(String str) {
        this.bvG = str;
    }

    public void KT(String str) {
        this.bvF = str;
    }

    public void KU(String str) {
        this.jQv = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cMr() {
        return this.eKF;
    }

    public void KV(String str) {
        this.eKF = str;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public List<C0770a> getImageList() {
        return this.jQw;
    }

    public void dR(List<C0770a> list) {
        this.jQw = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jQx;
        private String jQy;
        private String jQz;

        public void KW(String str) {
            this.jQx = str;
        }

        public String cMs() {
            return this.jQy;
        }

        public void KX(String str) {
            this.jQy = str;
        }

        public String cMt() {
            return this.jQz;
        }

        public void KY(String str) {
            this.jQz = str;
        }
    }

    /* renamed from: com.baidu.tieba.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0770a {
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
        aVar.KO(jSONObject.optString("commission"));
        aVar.KS(jSONObject.optString("coupon"));
        aVar.KV(jSONObject.optString("goodsId"));
        aVar.KQ(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0770a c0770a = new C0770a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0770a.setSrc(optJSONObject.optString(UserAccountActionItem.KEY_SRC));
                    arrayList.add(c0770a);
                }
            }
            aVar.dR(arrayList);
        }
        aVar.KU(jSONObject.optString("isBindingVideo"));
        aVar.setIsSelected(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString(IntentConfig.NID));
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
