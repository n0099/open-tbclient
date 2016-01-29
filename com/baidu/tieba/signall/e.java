package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ai;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ai {
    private String avatar;
    private int dNh;
    private int dNi;
    private int dNj;
    private int dNk;
    private boolean dNl;
    private boolean dNm;
    private boolean dNn;
    private boolean dNo;
    private int dNp;
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

    public int aIT() {
        return this.dNh;
    }

    public int aIU() {
        return this.dNi;
    }

    public int getUserLevel() {
        return this.userLevel;
    }

    public int aIV() {
        return this.dNj;
    }

    public int aIW() {
        return this.dNk;
    }

    public void nO(int i) {
        this.dNh = i;
    }

    public void nP(int i) {
        this.dNi = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean aIX() {
        return this.dNl;
    }

    public void hH(boolean z) {
        this.dNl = z;
        this.dNh = 1;
    }

    public boolean aIY() {
        return this.dNn;
    }

    public void hI(boolean z) {
        this.dNn = z;
        this.dNh = 0;
    }

    public boolean aIZ() {
        return this.dNo;
    }

    public void hJ(boolean z) {
        this.dNo = z;
    }

    public int aJa() {
        return this.dNp;
    }

    public void nQ(int i) {
        this.dNp = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aJb() {
        return this.dNm;
    }

    public void hK(boolean z) {
        this.dNm = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.dNh = jSONObject.optInt("is_sign_in");
            this.dNi = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt("user_level");
            this.dNj = jSONObject.optInt("user_exp");
            this.dNk = jSONObject.optInt("need_exp");
            if (this.dNh != 0) {
                this.dNl = true;
                this.dNn = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
        ArrayList<com.baidu.tbadk.core.util.ah> arrayList = new ArrayList<>();
        com.baidu.tbadk.core.util.ah ahVar = new com.baidu.tbadk.core.util.ah();
        ahVar.imgUrl = this.avatar;
        ahVar.acq = 10;
        arrayList.add(ahVar);
        return arrayList;
    }
}
