package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
    private int gxM;
    private boolean isSigned;
    private int ncF;
    private int ncG;
    private int ncH;
    private boolean ncI;
    private boolean ncJ;
    private boolean ncK;
    private int ncL;
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

    public int dMv() {
        return this.ncF;
    }

    public int dMw() {
        return this.gxM;
    }

    public int bLC() {
        return this.userLevel;
    }

    public int dMx() {
        return this.ncG;
    }

    public int dMy() {
        return this.ncH;
    }

    public void KB(int i) {
        this.ncF = i;
    }

    public void KC(int i) {
        this.gxM = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bSQ() {
        return this.isSigned;
    }

    public void xL(boolean z) {
        this.isSigned = z;
        this.ncF = 1;
    }

    public boolean dMz() {
        return this.ncJ;
    }

    public void xM(boolean z) {
        this.ncJ = z;
        this.ncF = 0;
    }

    public boolean dMA() {
        return this.ncK;
    }

    public void xN(boolean z) {
        this.ncK = z;
    }

    public int dMB() {
        return this.ncL;
    }

    public void KD(int i) {
        this.ncL = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dMC() {
        return this.ncI;
    }

    public void xO(boolean z) {
        this.ncI = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.ncF = jSONObject.optInt("is_sign_in");
            this.gxM = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.ncG = jSONObject.optInt("user_exp");
            this.ncH = jSONObject.optInt("need_exp");
            if (this.ncF != 0) {
                this.isSigned = true;
                this.ncJ = false;
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
