package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ak {
    private String avatar;
    private boolean dtq;
    private int eiS;
    private int eiT;
    private int eiU;
    private int eiV;
    private boolean eiW;
    private boolean eiX;
    private boolean eiY;
    private int eiZ;
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

    public int aPZ() {
        return this.eiS;
    }

    public int aQa() {
        return this.eiT;
    }

    public int getUserLevel() {
        return this.userLevel;
    }

    public int aQb() {
        return this.eiU;
    }

    public int aQc() {
        return this.eiV;
    }

    public void oP(int i) {
        this.eiS = i;
    }

    public void oQ(int i) {
        this.eiT = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean aQd() {
        return this.dtq;
    }

    public void jk(boolean z) {
        this.dtq = z;
        this.eiS = 1;
    }

    public boolean aQe() {
        return this.eiX;
    }

    public void jl(boolean z) {
        this.eiX = z;
        this.eiS = 0;
    }

    public boolean aQf() {
        return this.eiY;
    }

    public void jm(boolean z) {
        this.eiY = z;
    }

    public int aQg() {
        return this.eiZ;
    }

    public void oR(int i) {
        this.eiZ = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aQh() {
        return this.eiW;
    }

    public void jn(boolean z) {
        this.eiW = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.eiS = jSONObject.optInt("is_sign_in");
            this.eiT = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt("user_level");
            this.eiU = jSONObject.optInt("user_exp");
            this.eiV = jSONObject.optInt("need_exp");
            if (this.eiS != 0) {
                this.dtq = true;
                this.eiX = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<aj> getImages() {
        ArrayList<aj> arrayList = new ArrayList<>();
        aj ajVar = new aj();
        ajVar.imgUrl = this.avatar;
        ajVar.Xc = 10;
        arrayList.add(ajVar);
        return arrayList;
    }
}
