package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements au {
    private String avatar;
    private int bQC;
    private int bQD;
    private int bQE;
    private int bQF;
    private int bQG;
    private boolean bQH;
    private boolean bQI;
    private boolean bQJ;
    private boolean bQK;
    private int bQL;
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

    public int adF() {
        return this.bQC;
    }

    public int adG() {
        return this.bQD;
    }

    public int adH() {
        return this.bQE;
    }

    public int adI() {
        return this.bQF;
    }

    public int adJ() {
        return this.bQG;
    }

    public void hC(int i) {
        this.bQC = i;
    }

    public void hD(int i) {
        this.bQD = i;
    }

    public void hE(int i) {
        this.bQE = i;
    }

    public boolean adK() {
        return this.bQH;
    }

    public void er(boolean z) {
        this.bQH = z;
        this.bQC = 1;
    }

    public boolean adL() {
        return this.bQJ;
    }

    public void es(boolean z) {
        this.bQJ = z;
        this.bQC = 0;
    }

    public boolean adM() {
        return this.bQK;
    }

    public void et(boolean z) {
        this.bQK = z;
    }

    public int adN() {
        return this.bQL;
    }

    public void hF(int i) {
        this.bQL = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean adO() {
        return this.bQI;
    }

    public void eu(boolean z) {
        this.bQI = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.bQC = jSONObject.optInt("is_sign_in");
            this.bQD = jSONObject.optInt("cont_sign_num");
            this.bQE = jSONObject.optInt("user_level");
            this.bQF = jSONObject.optInt("user_exp");
            this.bQG = jSONObject.optInt("need_exp");
            if (this.bQC != 0) {
                this.bQH = true;
                this.bQJ = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<at> arrayList = new ArrayList<>();
        at atVar = new at();
        atVar.EX = this.avatar;
        atVar.Jk = 10;
        arrayList.add(atVar);
        return arrayList;
    }
}
