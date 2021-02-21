package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d implements ah {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gHh;
    private boolean isSigned;
    private int nnN;
    private int nnO;
    private int nnP;
    private boolean nnQ;
    private boolean nnR;
    private boolean nnS;
    private int nnT;
    private int userLevel;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dKP() {
        return this.nnN;
    }

    public int dKQ() {
        return this.gHh;
    }

    public int bKC() {
        return this.userLevel;
    }

    public int dKR() {
        return this.nnO;
    }

    public int dKS() {
        return this.nnP;
    }

    public void Jj(int i) {
        this.nnN = i;
    }

    public void Jk(int i) {
        this.gHh = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bSn() {
        return this.isSigned;
    }

    public void yc(boolean z) {
        this.isSigned = z;
        this.nnN = 1;
    }

    public boolean dKT() {
        return this.nnR;
    }

    public void yd(boolean z) {
        this.nnR = z;
        this.nnN = 0;
    }

    public boolean dKU() {
        return this.nnS;
    }

    public void ye(boolean z) {
        this.nnS = z;
    }

    public int dKV() {
        return this.nnT;
    }

    public void Jl(int i) {
        this.nnT = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dKW() {
        return this.nnQ;
    }

    public void yf(boolean z) {
        this.nnQ = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.nnN = jSONObject.optInt("is_sign_in");
            this.gHh = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.nnO = jSONObject.optInt("user_exp");
            this.nnP = jSONObject.optInt("need_exp");
            if (this.nnN != 0) {
                this.isSigned = true;
                this.nnR = false;
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
