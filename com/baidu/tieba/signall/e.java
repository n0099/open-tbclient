package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ae {
    private String avatar;
    private int cPA;
    private int cPB;
    private int cPC;
    private boolean cPD;
    private boolean cPE;
    private boolean cPF;
    private boolean cPG;
    private int cPH;
    private int cPy;
    private int cPz;
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

    public int atv() {
        return this.cPy;
    }

    public int atw() {
        return this.cPz;
    }

    public int atx() {
        return this.cPA;
    }

    public int aty() {
        return this.cPB;
    }

    public int atz() {
        return this.cPC;
    }

    public void kB(int i) {
        this.cPy = i;
    }

    public void kC(int i) {
        this.cPz = i;
    }

    public void kD(int i) {
        this.cPA = i;
    }

    public boolean atA() {
        return this.cPD;
    }

    public void gg(boolean z) {
        this.cPD = z;
        this.cPy = 1;
    }

    public boolean atB() {
        return this.cPF;
    }

    public void gh(boolean z) {
        this.cPF = z;
        this.cPy = 0;
    }

    public boolean atC() {
        return this.cPG;
    }

    public void gi(boolean z) {
        this.cPG = z;
    }

    public int atD() {
        return this.cPH;
    }

    public void kE(int i) {
        this.cPH = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean atE() {
        return this.cPE;
    }

    public void gj(boolean z) {
        this.cPE = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cPy = jSONObject.optInt("is_sign_in");
            this.cPz = jSONObject.optInt("cont_sign_num");
            this.cPA = jSONObject.optInt("user_level");
            this.cPB = jSONObject.optInt("user_exp");
            this.cPC = jSONObject.optInt("need_exp");
            if (this.cPy != 0) {
                this.cPD = true;
                this.cPF = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<ad> arrayList = new ArrayList<>();
        ad adVar = new ad();
        adVar.VY = this.avatar;
        adVar.aax = 10;
        arrayList.add(adVar);
        return arrayList;
    }
}
