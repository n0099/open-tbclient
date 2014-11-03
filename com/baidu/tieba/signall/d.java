package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements at {
    private String avatar;
    private int bKD;
    private int bKE;
    private int bKF;
    private int bKG;
    private int bKH;
    private boolean bKI;
    private boolean bKJ;
    private boolean bKK;
    private boolean bKL;
    private int bKM;
    private String errorMsg;
    private int forumId;
    private String forumName;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int acL() {
        return this.bKD;
    }

    public int acM() {
        return this.bKE;
    }

    public int zB() {
        return this.bKF;
    }

    public int acN() {
        return this.bKG;
    }

    public int acO() {
        return this.bKH;
    }

    public void hk(int i) {
        this.bKD = i;
    }

    public void hl(int i) {
        this.bKE = i;
    }

    public void ed(int i) {
        this.bKF = i;
    }

    public boolean acP() {
        return this.bKI;
    }

    public void eD(boolean z) {
        this.bKI = z;
        this.bKD = 1;
    }

    public boolean acQ() {
        return this.bKK;
    }

    public void eE(boolean z) {
        this.bKK = z;
        this.bKD = 0;
    }

    public boolean acR() {
        return this.bKL;
    }

    public void eF(boolean z) {
        this.bKL = z;
    }

    public int acS() {
        return this.bKM;
    }

    public void hm(int i) {
        this.bKM = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean acT() {
        return this.bKJ;
    }

    public void eG(boolean z) {
        this.bKJ = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.bKD = jSONObject.optInt("is_sign_in");
            this.bKE = jSONObject.optInt("cont_sign_num");
            this.bKF = jSONObject.optInt("user_level");
            this.bKG = jSONObject.optInt("user_exp");
            this.bKH = jSONObject.optInt("need_exp");
            if (this.bKD != 0) {
                this.bKI = true;
                this.bKK = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<as> getImages() {
        ArrayList<as> arrayList = new ArrayList<>();
        as asVar = new as();
        asVar.AI = this.avatar;
        asVar.ES = 10;
        arrayList.add(asVar);
        return arrayList;
    }
}
