package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements as {
    private String avatar;
    private int cdM;
    private int cdN;
    private int cdO;
    private int cdP;
    private int cdQ;
    private boolean cdR;
    private boolean cdS;
    private boolean cdT;
    private boolean cdU;
    private int cdV;
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

    public int aiM() {
        return this.cdM;
    }

    public int aiN() {
        return this.cdN;
    }

    public int aiO() {
        return this.cdO;
    }

    public int aiP() {
        return this.cdP;
    }

    public int aiQ() {
        return this.cdQ;
    }

    public void ib(int i) {
        this.cdM = i;
    }

    public void ic(int i) {
        this.cdN = i;
    }

    public void id(int i) {
        this.cdO = i;
    }

    public boolean aiR() {
        return this.cdR;
    }

    public void ex(boolean z) {
        this.cdR = z;
        this.cdM = 1;
    }

    public boolean aiS() {
        return this.cdT;
    }

    public void ey(boolean z) {
        this.cdT = z;
        this.cdM = 0;
    }

    public boolean aiT() {
        return this.cdU;
    }

    public void ez(boolean z) {
        this.cdU = z;
    }

    public int aiU() {
        return this.cdV;
    }

    public void ie(int i) {
        this.cdV = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aiV() {
        return this.cdS;
    }

    public void eA(boolean z) {
        this.cdS = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cdM = jSONObject.optInt("is_sign_in");
            this.cdN = jSONObject.optInt("cont_sign_num");
            this.cdO = jSONObject.optInt("user_level");
            this.cdP = jSONObject.optInt("user_exp");
            this.cdQ = jSONObject.optInt("need_exp");
            if (this.cdM != 0) {
                this.cdR = true;
                this.cdT = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.as
    public ArrayList<ar> getImages() {
        ArrayList<ar> arrayList = new ArrayList<>();
        ar arVar = new ar();
        arVar.QM = this.avatar;
        arVar.UW = 10;
        arrayList.add(arVar);
        return arrayList;
    }
}
