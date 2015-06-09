package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ap {
    private String avatar;
    private int chR;
    private int chS;
    private int chT;
    private int chU;
    private int chV;
    private boolean chW;
    private boolean chX;
    private boolean chY;
    private boolean chZ;
    private int cia;
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

    public int akB() {
        return this.chV;
    }

    public void ix(int i) {
        this.chR = i;
    }

    public void iy(int i) {
        this.chS = i;
    }

    public void iz(int i) {
        this.chT = i;
    }

    public boolean akC() {
        return this.chW;
    }

    public void eR(boolean z) {
        this.chW = z;
        this.chR = 1;
    }

    public boolean akD() {
        return this.chY;
    }

    public void eS(boolean z) {
        this.chY = z;
        this.chR = 0;
    }

    public boolean akE() {
        return this.chZ;
    }

    public void eT(boolean z) {
        this.chZ = z;
    }

    public int akF() {
        return this.cia;
    }

    public void iA(int i) {
        this.cia = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean akG() {
        return this.chX;
    }

    public void eU(boolean z) {
        this.chX = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.chR = jSONObject.optInt("is_sign_in");
            this.chS = jSONObject.optInt("cont_sign_num");
            this.chT = jSONObject.optInt("user_level");
            this.chU = jSONObject.optInt("user_exp");
            this.chV = jSONObject.optInt("need_exp");
            if (this.chR != 0) {
                this.chW = true;
                this.chY = false;
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
