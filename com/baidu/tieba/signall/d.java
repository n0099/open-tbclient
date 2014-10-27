package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements at {
    private String avatar;
    private int bKo;
    private int bKp;
    private int bKq;
    private int bKr;
    private int bKs;
    private boolean bKt;
    private boolean bKu;
    private boolean bKv;
    private boolean bKw;
    private int bKx;
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

    public int acI() {
        return this.bKo;
    }

    public int acJ() {
        return this.bKp;
    }

    public int zz() {
        return this.bKq;
    }

    public int acK() {
        return this.bKr;
    }

    public int acL() {
        return this.bKs;
    }

    public void hk(int i) {
        this.bKo = i;
    }

    public void hl(int i) {
        this.bKp = i;
    }

    public void ed(int i) {
        this.bKq = i;
    }

    public boolean acM() {
        return this.bKt;
    }

    public void eD(boolean z) {
        this.bKt = z;
        this.bKo = 1;
    }

    public boolean acN() {
        return this.bKv;
    }

    public void eE(boolean z) {
        this.bKv = z;
        this.bKo = 0;
    }

    public boolean acO() {
        return this.bKw;
    }

    public void eF(boolean z) {
        this.bKw = z;
    }

    public int acP() {
        return this.bKx;
    }

    public void hm(int i) {
        this.bKx = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean acQ() {
        return this.bKu;
    }

    public void eG(boolean z) {
        this.bKu = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.bKo = jSONObject.optInt("is_sign_in");
            this.bKp = jSONObject.optInt("cont_sign_num");
            this.bKq = jSONObject.optInt("user_level");
            this.bKr = jSONObject.optInt("user_exp");
            this.bKs = jSONObject.optInt("need_exp");
            if (this.bKo != 0) {
                this.bKt = true;
                this.bKv = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<as> getImages() {
        ArrayList<as> arrayList = new ArrayList<>();
        as asVar = new as();
        asVar.AI = this.avatar;
        asVar.ER = 10;
        arrayList.add(asVar);
        return arrayList;
    }
}
