package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bnR;
    private int cBG;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gnT;
    private int gnU;
    private int gnV;
    private boolean gnW;
    private boolean gnX;
    private boolean gnY;
    private boolean gnZ;
    private int goa;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bov() {
        return this.gnT;
    }

    public int bow() {
        return this.bnR;
    }

    public int box() {
        return this.cBG;
    }

    public int boy() {
        return this.gnU;
    }

    public int boz() {
        return this.gnV;
    }

    public void sO(int i) {
        this.gnT = i;
    }

    public void sP(int i) {
        this.bnR = i;
    }

    public void sQ(int i) {
        this.cBG = i;
    }

    public boolean PX() {
        return this.gnW;
    }

    public void mb(boolean z) {
        this.gnW = z;
        this.gnT = 1;
    }

    public boolean boA() {
        return this.gnY;
    }

    public void mc(boolean z) {
        this.gnY = z;
        this.gnT = 0;
    }

    public boolean boB() {
        return this.gnZ;
    }

    public void md(boolean z) {
        this.gnZ = z;
    }

    public int boC() {
        return this.goa;
    }

    public void sR(int i) {
        this.goa = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean boD() {
        return this.gnX;
    }

    public void me(boolean z) {
        this.gnX = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gnT = jSONObject.optInt("is_sign_in");
            this.bnR = jSONObject.optInt("cont_sign_num");
            this.cBG = jSONObject.optInt("user_level");
            this.gnU = jSONObject.optInt("user_exp");
            this.gnV = jSONObject.optInt("need_exp");
            if (this.gnT != 0) {
                this.gnW = true;
                this.gnY = false;
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
