package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements ah {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gIQ;
    private boolean isSigned;
    private int npT;
    private int npU;
    private int npV;
    private boolean npW;
    private boolean npX;
    private boolean npY;
    private int npZ;
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

    public int dKX() {
        return this.npT;
    }

    public int dKY() {
        return this.gIQ;
    }

    public int bKG() {
        return this.userLevel;
    }

    public int dKZ() {
        return this.npU;
    }

    public int dLa() {
        return this.npV;
    }

    public void Jn(int i) {
        this.npT = i;
    }

    public void Jo(int i) {
        this.gIQ = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bSt() {
        return this.isSigned;
    }

    public void yc(boolean z) {
        this.isSigned = z;
        this.npT = 1;
    }

    public boolean dLb() {
        return this.npX;
    }

    public void yd(boolean z) {
        this.npX = z;
        this.npT = 0;
    }

    public boolean dLc() {
        return this.npY;
    }

    public void ye(boolean z) {
        this.npY = z;
    }

    public int dLd() {
        return this.npZ;
    }

    public void Jp(int i) {
        this.npZ = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dLe() {
        return this.npW;
    }

    public void yf(boolean z) {
        this.npW = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.npT = jSONObject.optInt("is_sign_in");
            this.gIQ = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.npU = jSONObject.optInt("user_exp");
            this.npV = jSONObject.optInt("need_exp");
            if (this.npT != 0) {
                this.isSigned = true;
                this.npX = false;
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
