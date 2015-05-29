package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ap {
    private String avatar;
    private int chQ;
    private int chR;
    private int chS;
    private int chT;
    private int chU;
    private boolean chV;
    private boolean chW;
    private boolean chX;
    private boolean chY;
    private int chZ;
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

    public int akw() {
        return this.chQ;
    }

    public int akx() {
        return this.chR;
    }

    public int aky() {
        return this.chS;
    }

    public int akz() {
        return this.chT;
    }

    public int akA() {
        return this.chU;
    }

    public void ix(int i) {
        this.chQ = i;
    }

    public void iy(int i) {
        this.chR = i;
    }

    public void iz(int i) {
        this.chS = i;
    }

    public boolean akB() {
        return this.chV;
    }

    public void eR(boolean z) {
        this.chV = z;
        this.chQ = 1;
    }

    public boolean akC() {
        return this.chX;
    }

    public void eS(boolean z) {
        this.chX = z;
        this.chQ = 0;
    }

    public boolean akD() {
        return this.chY;
    }

    public void eT(boolean z) {
        this.chY = z;
    }

    public int akE() {
        return this.chZ;
    }

    public void iA(int i) {
        this.chZ = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean akF() {
        return this.chW;
    }

    public void eU(boolean z) {
        this.chW = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.chQ = jSONObject.optInt("is_sign_in");
            this.chR = jSONObject.optInt("cont_sign_num");
            this.chS = jSONObject.optInt("user_level");
            this.chT = jSONObject.optInt("user_exp");
            this.chU = jSONObject.optInt("need_exp");
            if (this.chQ != 0) {
                this.chV = true;
                this.chX = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ap
    public ArrayList<ao> getImages() {
        ArrayList<ao> arrayList = new ArrayList<>();
        ao aoVar = new ao();
        aoVar.Ri = this.avatar;
        aoVar.Vx = 10;
        arrayList.add(aoVar);
        return arrayList;
    }
}
