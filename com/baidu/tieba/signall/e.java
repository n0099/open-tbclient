package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ad {
    private String avatar;
    private int cID;
    private int cIE;
    private int cIF;
    private int cIG;
    private int cIH;
    private boolean cII;
    private boolean cIJ;
    private boolean cIK;
    private boolean cIL;
    private int cIM;
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

    public int arh() {
        return this.cID;
    }

    public int ari() {
        return this.cIE;
    }

    public int arj() {
        return this.cIF;
    }

    public int ark() {
        return this.cIG;
    }

    public int arl() {
        return this.cIH;
    }

    public void kc(int i) {
        this.cID = i;
    }

    public void kd(int i) {
        this.cIE = i;
    }

    public void ke(int i) {
        this.cIF = i;
    }

    public boolean arm() {
        return this.cII;
    }

    public void fV(boolean z) {
        this.cII = z;
        this.cID = 1;
    }

    public boolean arn() {
        return this.cIK;
    }

    public void fW(boolean z) {
        this.cIK = z;
        this.cID = 0;
    }

    public boolean aro() {
        return this.cIL;
    }

    public void fX(boolean z) {
        this.cIL = z;
    }

    public int arp() {
        return this.cIM;
    }

    public void kf(int i) {
        this.cIM = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean arq() {
        return this.cIJ;
    }

    public void fY(boolean z) {
        this.cIJ = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cID = jSONObject.optInt("is_sign_in");
            this.cIE = jSONObject.optInt("cont_sign_num");
            this.cIF = jSONObject.optInt("user_level");
            this.cIG = jSONObject.optInt("user_exp");
            this.cIH = jSONObject.optInt("need_exp");
            if (this.cID != 0) {
                this.cII = true;
                this.cIK = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<ac> getImages() {
        ArrayList<ac> arrayList = new ArrayList<>();
        ac acVar = new ac();
        acVar.Wg = this.avatar;
        acVar.aaD = 10;
        arrayList.add(acVar);
        return arrayList;
    }
}
