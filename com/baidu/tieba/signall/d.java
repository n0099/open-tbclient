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
    private int gpU;
    private boolean isSigned;
    private int mNE;
    private int mNF;
    private int mNG;
    private boolean mNH;
    private boolean mNI;
    private boolean mNJ;
    private int mNK;
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

    public int dHm() {
        return this.mNE;
    }

    public int dHn() {
        return this.gpU;
    }

    public int dHo() {
        return this.userLevel;
    }

    public int dHp() {
        return this.mNF;
    }

    public int dHq() {
        return this.mNG;
    }

    public void Ji(int i) {
        this.mNE = i;
    }

    public void Jj(int i) {
        this.gpU = i;
    }

    public void Jk(int i) {
        this.userLevel = i;
    }

    public boolean bPL() {
        return this.isSigned;
    }

    public void xd(boolean z) {
        this.isSigned = z;
        this.mNE = 1;
    }

    public boolean dHr() {
        return this.mNI;
    }

    public void xe(boolean z) {
        this.mNI = z;
        this.mNE = 0;
    }

    public boolean dHs() {
        return this.mNJ;
    }

    public void xf(boolean z) {
        this.mNJ = z;
    }

    public int dHt() {
        return this.mNK;
    }

    public void Jl(int i) {
        this.mNK = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dHu() {
        return this.mNH;
    }

    public void xg(boolean z) {
        this.mNH = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.mNE = jSONObject.optInt("is_sign_in");
            this.gpU = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt("user_level");
            this.mNF = jSONObject.optInt("user_exp");
            this.mNG = jSONObject.optInt("need_exp");
            if (this.mNE != 0) {
                this.isSigned = true;
                this.mNI = false;
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
