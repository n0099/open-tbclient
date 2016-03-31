package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ak {
    private String avatar;
    private boolean dfO;
    private int efH;
    private int efI;
    private int efJ;
    private int efK;
    private boolean efL;
    private boolean efM;
    private boolean efN;
    private int efO;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int userLevel;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int aPJ() {
        return this.efH;
    }

    public int aPK() {
        return this.efI;
    }

    public int getUserLevel() {
        return this.userLevel;
    }

    public int aPL() {
        return this.efJ;
    }

    public int aPM() {
        return this.efK;
    }

    public void oV(int i) {
        this.efH = i;
    }

    public void oW(int i) {
        this.efI = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean aPN() {
        return this.dfO;
    }

    public void iw(boolean z) {
        this.dfO = z;
        this.efH = 1;
    }

    public boolean aPO() {
        return this.efM;
    }

    public void ix(boolean z) {
        this.efM = z;
        this.efH = 0;
    }

    public boolean aPP() {
        return this.efN;
    }

    public void iy(boolean z) {
        this.efN = z;
    }

    public int aPQ() {
        return this.efO;
    }

    public void oX(int i) {
        this.efO = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aPR() {
        return this.efL;
    }

    public void iz(boolean z) {
        this.efL = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.efH = jSONObject.optInt("is_sign_in");
            this.efI = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt("user_level");
            this.efJ = jSONObject.optInt("user_exp");
            this.efK = jSONObject.optInt("need_exp");
            if (this.efH != 0) {
                this.dfO = true;
                this.efM = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<aj> getImages() {
        ArrayList<aj> arrayList = new ArrayList<>();
        aj ajVar = new aj();
        ajVar.imgUrl = this.avatar;
        ajVar.abD = 10;
        arrayList.add(ajVar);
        return arrayList;
    }
}
