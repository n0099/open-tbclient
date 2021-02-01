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
    private int gGT;
    private boolean isSigned;
    private int nnn;
    private int nno;
    private int nnp;
    private boolean nnq;
    private boolean nnr;
    private boolean nns;
    private int nnt;
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

    public int dKH() {
        return this.nnn;
    }

    public int dKI() {
        return this.gGT;
    }

    public int bKx() {
        return this.userLevel;
    }

    public int dKJ() {
        return this.nno;
    }

    public int dKK() {
        return this.nnp;
    }

    public void Jj(int i) {
        this.nnn = i;
    }

    public void Jk(int i) {
        this.gGT = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bSg() {
        return this.isSigned;
    }

    public void yc(boolean z) {
        this.isSigned = z;
        this.nnn = 1;
    }

    public boolean dKL() {
        return this.nnr;
    }

    public void yd(boolean z) {
        this.nnr = z;
        this.nnn = 0;
    }

    public boolean dKM() {
        return this.nns;
    }

    public void ye(boolean z) {
        this.nns = z;
    }

    public int dKN() {
        return this.nnt;
    }

    public void Jl(int i) {
        this.nnt = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dKO() {
        return this.nnq;
    }

    public void yf(boolean z) {
        this.nnq = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.nnn = jSONObject.optInt("is_sign_in");
            this.gGT = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.nno = jSONObject.optInt("user_exp");
            this.nnp = jSONObject.optInt("need_exp");
            if (this.nnn != 0) {
                this.isSigned = true;
                this.nnr = false;
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
