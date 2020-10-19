package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class d implements ah {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gac;
    private boolean isSigned;
    private int muY;
    private int muZ;
    private int mva;
    private int mvb;
    private boolean mvc;
    private boolean mvd;
    private boolean mve;
    private int mvf;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dBC() {
        return this.muY;
    }

    public int dBD() {
        return this.gac;
    }

    public int dBE() {
        return this.muZ;
    }

    public int dBF() {
        return this.mva;
    }

    public int dBG() {
        return this.mvb;
    }

    public void IC(int i) {
        this.muY = i;
    }

    public void ID(int i) {
        this.gac = i;
    }

    public void IE(int i) {
        this.muZ = i;
    }

    public boolean bKJ() {
        return this.isSigned;
    }

    public void wD(boolean z) {
        this.isSigned = z;
        this.muY = 1;
    }

    public boolean dBH() {
        return this.mvd;
    }

    public void wE(boolean z) {
        this.mvd = z;
        this.muY = 0;
    }

    public boolean dBI() {
        return this.mve;
    }

    public void wF(boolean z) {
        this.mve = z;
    }

    public int dBJ() {
        return this.mvf;
    }

    public void IF(int i) {
        this.mvf = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dBK() {
        return this.mvc;
    }

    public void wG(boolean z) {
        this.mvc = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.muY = jSONObject.optInt("is_sign_in");
            this.gac = jSONObject.optInt("cont_sign_num");
            this.muZ = jSONObject.optInt("user_level");
            this.mva = jSONObject.optInt("user_exp");
            this.mvb = jSONObject.optInt("need_exp");
            if (this.muY != 0) {
                this.isSigned = true;
                this.mvd = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
