package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bnC;
    private int cAA;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gmQ;
    private int gmR;
    private int gmS;
    private boolean gmT;
    private boolean gmU;
    private boolean gmV;
    private boolean gmW;
    private int gmX;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int box() {
        return this.gmQ;
    }

    public int boy() {
        return this.bnC;
    }

    public int boz() {
        return this.cAA;
    }

    public int boA() {
        return this.gmR;
    }

    public int boB() {
        return this.gmS;
    }

    public void sP(int i) {
        this.gmQ = i;
    }

    public void sQ(int i) {
        this.bnC = i;
    }

    public void sR(int i) {
        this.cAA = i;
    }

    public boolean Qa() {
        return this.gmT;
    }

    public void ma(boolean z) {
        this.gmT = z;
        this.gmQ = 1;
    }

    public boolean boC() {
        return this.gmV;
    }

    public void mb(boolean z) {
        this.gmV = z;
        this.gmQ = 0;
    }

    public boolean boD() {
        return this.gmW;
    }

    public void mc(boolean z) {
        this.gmW = z;
    }

    public int boE() {
        return this.gmX;
    }

    public void sS(int i) {
        this.gmX = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean boF() {
        return this.gmU;
    }

    public void md(boolean z) {
        this.gmU = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gmQ = jSONObject.optInt("is_sign_in");
            this.bnC = jSONObject.optInt("cont_sign_num");
            this.cAA = jSONObject.optInt("user_level");
            this.gmR = jSONObject.optInt("user_exp");
            this.gmS = jSONObject.optInt("need_exp");
            if (this.gmQ != 0) {
                this.gmT = true;
                this.gmV = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
