package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements as {
    private String avatar;
    private int cdA;
    private int cdB;
    private boolean cdC;
    private boolean cdD;
    private boolean cdE;
    private boolean cdF;
    private int cdG;
    private int cdx;
    private int cdy;
    private int cdz;
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

    public int aix() {
        return this.cdx;
    }

    public int aiy() {
        return this.cdy;
    }

    public int aiz() {
        return this.cdz;
    }

    public int aiA() {
        return this.cdA;
    }

    public int aiB() {
        return this.cdB;
    }

    public void hY(int i) {
        this.cdx = i;
    }

    public void hZ(int i) {
        this.cdy = i;
    }

    public void ia(int i) {
        this.cdz = i;
    }

    public boolean aiC() {
        return this.cdC;
    }

    public void ez(boolean z) {
        this.cdC = z;
        this.cdx = 1;
    }

    public boolean aiD() {
        return this.cdE;
    }

    public void eA(boolean z) {
        this.cdE = z;
        this.cdx = 0;
    }

    public boolean aiE() {
        return this.cdF;
    }

    public void eB(boolean z) {
        this.cdF = z;
    }

    public int aiF() {
        return this.cdG;
    }

    public void ib(int i) {
        this.cdG = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aiG() {
        return this.cdD;
    }

    public void eC(boolean z) {
        this.cdD = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cdx = jSONObject.optInt("is_sign_in");
            this.cdy = jSONObject.optInt("cont_sign_num");
            this.cdz = jSONObject.optInt("user_level");
            this.cdA = jSONObject.optInt("user_exp");
            this.cdB = jSONObject.optInt("need_exp");
            if (this.cdx != 0) {
                this.cdC = true;
                this.cdE = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.as
    public ArrayList<ar> getImages() {
        ArrayList<ar> arrayList = new ArrayList<>();
        ar arVar = new ar();
        arVar.QK = this.avatar;
        arVar.UU = 10;
        arrayList.add(arVar);
        return arrayList;
    }
}
