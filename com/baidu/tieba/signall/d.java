package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class d implements ah {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gpB;
    private boolean isSigned;
    private boolean mOA;
    private boolean mOB;
    private boolean mOC;
    private int mOD;
    private int mOx;
    private int mOy;
    private int mOz;
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

    public int dHd() {
        return this.mOx;
    }

    public int dHe() {
        return this.gpB;
    }

    public int dHf() {
        return this.userLevel;
    }

    public int dHg() {
        return this.mOy;
    }

    public int dHh() {
        return this.mOz;
    }

    public void JK(int i) {
        this.mOx = i;
    }

    public void JL(int i) {
        this.gpB = i;
    }

    public void JM(int i) {
        this.userLevel = i;
    }

    public boolean bPe() {
        return this.isSigned;
    }

    public void xh(boolean z) {
        this.isSigned = z;
        this.mOx = 1;
    }

    public boolean dHi() {
        return this.mOB;
    }

    public void xi(boolean z) {
        this.mOB = z;
        this.mOx = 0;
    }

    public boolean dHj() {
        return this.mOC;
    }

    public void xj(boolean z) {
        this.mOC = z;
    }

    public int dHk() {
        return this.mOD;
    }

    public void JN(int i) {
        this.mOD = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dHl() {
        return this.mOA;
    }

    public void xk(boolean z) {
        this.mOA = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.mOx = jSONObject.optInt("is_sign_in");
            this.gpB = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt("user_level");
            this.mOy = jSONObject.optInt("user_exp");
            this.mOz = jSONObject.optInt("need_exp");
            if (this.mOx != 0) {
                this.isSigned = true;
                this.mOB = false;
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
