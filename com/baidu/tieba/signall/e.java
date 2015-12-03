package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements aj {
    private String avatar;
    private int bqr;
    private int dpQ;
    private int dpR;
    private int dpS;
    private int dpT;
    private boolean dpU;
    private boolean dpV;
    private boolean dpW;
    private boolean dpX;
    private int dpY;
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

    public int azF() {
        return this.dpQ;
    }

    public int azG() {
        return this.dpR;
    }

    public int RI() {
        return this.bqr;
    }

    public int azH() {
        return this.dpS;
    }

    public int azI() {
        return this.dpT;
    }

    public void ma(int i) {
        this.dpQ = i;
    }

    public void mb(int i) {
        this.dpR = i;
    }

    public void gV(int i) {
        this.bqr = i;
    }

    public boolean azJ() {
        return this.dpU;
    }

    public void gY(boolean z) {
        this.dpU = z;
        this.dpQ = 1;
    }

    public boolean azK() {
        return this.dpW;
    }

    public void gZ(boolean z) {
        this.dpW = z;
        this.dpQ = 0;
    }

    public boolean azL() {
        return this.dpX;
    }

    public void ha(boolean z) {
        this.dpX = z;
    }

    public int azM() {
        return this.dpY;
    }

    public void mc(int i) {
        this.dpY = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean azN() {
        return this.dpV;
    }

    public void hb(boolean z) {
        this.dpV = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.dpQ = jSONObject.optInt("is_sign_in");
            this.dpR = jSONObject.optInt("cont_sign_num");
            this.bqr = jSONObject.optInt("user_level");
            this.dpS = jSONObject.optInt("user_exp");
            this.dpT = jSONObject.optInt("need_exp");
            if (this.dpQ != 0) {
                this.dpU = true;
                this.dpW = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<ai> arrayList = new ArrayList<>();
        ai aiVar = new ai();
        aiVar.WN = this.avatar;
        aiVar.abp = 10;
        arrayList.add(aiVar);
        return arrayList;
    }
}
