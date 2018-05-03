package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bnC;
    private int cAx;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gmN;
    private int gmO;
    private int gmP;
    private boolean gmQ;
    private boolean gmR;
    private boolean gmS;
    private boolean gmT;
    private int gmU;

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
        return this.gmN;
    }

    public int boy() {
        return this.bnC;
    }

    public int boz() {
        return this.cAx;
    }

    public int boA() {
        return this.gmO;
    }

    public int boB() {
        return this.gmP;
    }

    public void sP(int i) {
        this.gmN = i;
    }

    public void sQ(int i) {
        this.bnC = i;
    }

    public void sR(int i) {
        this.cAx = i;
    }

    public boolean Qa() {
        return this.gmQ;
    }

    public void ma(boolean z) {
        this.gmQ = z;
        this.gmN = 1;
    }

    public boolean boC() {
        return this.gmS;
    }

    public void mb(boolean z) {
        this.gmS = z;
        this.gmN = 0;
    }

    public boolean boD() {
        return this.gmT;
    }

    public void mc(boolean z) {
        this.gmT = z;
    }

    public int boE() {
        return this.gmU;
    }

    public void sS(int i) {
        this.gmU = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean boF() {
        return this.gmR;
    }

    public void md(boolean z) {
        this.gmR = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gmN = jSONObject.optInt("is_sign_in");
            this.bnC = jSONObject.optInt("cont_sign_num");
            this.cAx = jSONObject.optInt("user_level");
            this.gmO = jSONObject.optInt("user_exp");
            this.gmP = jSONObject.optInt("need_exp");
            if (this.gmN != 0) {
                this.gmQ = true;
                this.gmS = false;
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
