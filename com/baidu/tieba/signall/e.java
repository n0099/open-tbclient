package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ae {
    private String avatar;
    private boolean cRA;
    private boolean cRB;
    private int cRC;
    private int cRt;
    private int cRu;
    private int cRv;
    private int cRw;
    private int cRx;
    private boolean cRy;
    private boolean cRz;
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

    public int aud() {
        return this.cRt;
    }

    public int aue() {
        return this.cRu;
    }

    public int auf() {
        return this.cRv;
    }

    public int aug() {
        return this.cRw;
    }

    public int auh() {
        return this.cRx;
    }

    public void kR(int i) {
        this.cRt = i;
    }

    public void kS(int i) {
        this.cRu = i;
    }

    public void kT(int i) {
        this.cRv = i;
    }

    public boolean aui() {
        return this.cRy;
    }

    public void gj(boolean z) {
        this.cRy = z;
        this.cRt = 1;
    }

    public boolean auj() {
        return this.cRA;
    }

    public void gk(boolean z) {
        this.cRA = z;
        this.cRt = 0;
    }

    public boolean auk() {
        return this.cRB;
    }

    public void gl(boolean z) {
        this.cRB = z;
    }

    public int aul() {
        return this.cRC;
    }

    public void kU(int i) {
        this.cRC = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aum() {
        return this.cRz;
    }

    public void gm(boolean z) {
        this.cRz = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cRt = jSONObject.optInt("is_sign_in");
            this.cRu = jSONObject.optInt("cont_sign_num");
            this.cRv = jSONObject.optInt("user_level");
            this.cRw = jSONObject.optInt("user_exp");
            this.cRx = jSONObject.optInt("need_exp");
            if (this.cRt != 0) {
                this.cRy = true;
                this.cRA = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<ad> arrayList = new ArrayList<>();
        ad adVar = new ad();
        adVar.Wd = this.avatar;
        adVar.aaD = 10;
        arrayList.add(adVar);
        return arrayList;
    }
}
