package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ae {
    private String avatar;
    private int cPX;
    private int cPY;
    private int cPZ;
    private int cQa;
    private int cQb;
    private boolean cQc;
    private boolean cQd;
    private boolean cQe;
    private boolean cQf;
    private int cQg;
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

    public int atB() {
        return this.cPX;
    }

    public int atC() {
        return this.cPY;
    }

    public int atD() {
        return this.cPZ;
    }

    public int atE() {
        return this.cQa;
    }

    public int atF() {
        return this.cQb;
    }

    public void kD(int i) {
        this.cPX = i;
    }

    public void kE(int i) {
        this.cPY = i;
    }

    public void kF(int i) {
        this.cPZ = i;
    }

    public boolean atG() {
        return this.cQc;
    }

    public void gg(boolean z) {
        this.cQc = z;
        this.cPX = 1;
    }

    public boolean atH() {
        return this.cQe;
    }

    public void gh(boolean z) {
        this.cQe = z;
        this.cPX = 0;
    }

    public boolean atI() {
        return this.cQf;
    }

    public void gi(boolean z) {
        this.cQf = z;
    }

    public int atJ() {
        return this.cQg;
    }

    public void kG(int i) {
        this.cQg = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean atK() {
        return this.cQd;
    }

    public void gj(boolean z) {
        this.cQd = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cPX = jSONObject.optInt("is_sign_in");
            this.cPY = jSONObject.optInt("cont_sign_num");
            this.cPZ = jSONObject.optInt("user_level");
            this.cQa = jSONObject.optInt("user_exp");
            this.cQb = jSONObject.optInt("need_exp");
            if (this.cPX != 0) {
                this.cQc = true;
                this.cQe = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<ad> arrayList = new ArrayList<>();
        ad adVar = new ad();
        adVar.Wa = this.avatar;
        adVar.aaz = 10;
        arrayList.add(adVar);
        return arrayList;
    }
}
