package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements au {
    private String avatar;
    private int bOT;
    private int bOU;
    private int bOV;
    private int bOW;
    private int bOX;
    private boolean bOY;
    private boolean bOZ;
    private boolean bPa;
    private boolean bPb;
    private int bPc;
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

    public int adg() {
        return this.bOT;
    }

    public int adh() {
        return this.bOU;
    }

    public int adi() {
        return this.bOV;
    }

    public int adj() {
        return this.bOW;
    }

    public int adk() {
        return this.bOX;
    }

    public void ht(int i) {
        this.bOT = i;
    }

    public void hu(int i) {
        this.bOU = i;
    }

    public void hv(int i) {
        this.bOV = i;
    }

    public boolean adl() {
        return this.bOY;
    }

    public void ek(boolean z) {
        this.bOY = z;
        this.bOT = 1;
    }

    public boolean adm() {
        return this.bPa;
    }

    public void el(boolean z) {
        this.bPa = z;
        this.bOT = 0;
    }

    public boolean adn() {
        return this.bPb;
    }

    public void em(boolean z) {
        this.bPb = z;
    }

    public int ado() {
        return this.bPc;
    }

    public void hw(int i) {
        this.bPc = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean adp() {
        return this.bOZ;
    }

    public void en(boolean z) {
        this.bOZ = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.bOT = jSONObject.optInt("is_sign_in");
            this.bOU = jSONObject.optInt("cont_sign_num");
            this.bOV = jSONObject.optInt("user_level");
            this.bOW = jSONObject.optInt("user_exp");
            this.bOX = jSONObject.optInt("need_exp");
            if (this.bOT != 0) {
                this.bOY = true;
                this.bPa = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<at> arrayList = new ArrayList<>();
        at atVar = new at();
        atVar.imgUrl = this.avatar;
        atVar.Jd = 10;
        arrayList.add(atVar);
        return arrayList;
    }
}
