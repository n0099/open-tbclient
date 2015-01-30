package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements au {
    private String avatar;
    private int bQD;
    private int bQE;
    private int bQF;
    private int bQG;
    private int bQH;
    private boolean bQI;
    private boolean bQJ;
    private boolean bQK;
    private boolean bQL;
    private int bQM;
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

    public int adK() {
        return this.bQD;
    }

    public int adL() {
        return this.bQE;
    }

    public int adM() {
        return this.bQF;
    }

    public int adN() {
        return this.bQG;
    }

    public int adO() {
        return this.bQH;
    }

    public void hC(int i) {
        this.bQD = i;
    }

    public void hD(int i) {
        this.bQE = i;
    }

    public void hE(int i) {
        this.bQF = i;
    }

    public boolean adP() {
        return this.bQI;
    }

    public void er(boolean z) {
        this.bQI = z;
        this.bQD = 1;
    }

    public boolean adQ() {
        return this.bQK;
    }

    public void es(boolean z) {
        this.bQK = z;
        this.bQD = 0;
    }

    public boolean adR() {
        return this.bQL;
    }

    public void et(boolean z) {
        this.bQL = z;
    }

    public int adS() {
        return this.bQM;
    }

    public void hF(int i) {
        this.bQM = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean adT() {
        return this.bQJ;
    }

    public void eu(boolean z) {
        this.bQJ = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.bQD = jSONObject.optInt("is_sign_in");
            this.bQE = jSONObject.optInt("cont_sign_num");
            this.bQF = jSONObject.optInt("user_level");
            this.bQG = jSONObject.optInt("user_exp");
            this.bQH = jSONObject.optInt("need_exp");
            if (this.bQD != 0) {
                this.bQI = true;
                this.bQK = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<at> arrayList = new ArrayList<>();
        at atVar = new at();
        atVar.Fa = this.avatar;
        atVar.Jn = 10;
        arrayList.add(atVar);
        return arrayList;
    }
}
