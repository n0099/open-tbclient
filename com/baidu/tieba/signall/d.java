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
    private int gxK;
    private boolean isSigned;
    private int ncD;
    private int ncE;
    private int ncF;
    private boolean ncG;
    private boolean ncH;
    private boolean ncI;
    private int ncJ;
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

    public int dMu() {
        return this.ncD;
    }

    public int dMv() {
        return this.gxK;
    }

    public int bLB() {
        return this.userLevel;
    }

    public int dMw() {
        return this.ncE;
    }

    public int dMx() {
        return this.ncF;
    }

    public void KB(int i) {
        this.ncD = i;
    }

    public void KC(int i) {
        this.gxK = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bSP() {
        return this.isSigned;
    }

    public void xL(boolean z) {
        this.isSigned = z;
        this.ncD = 1;
    }

    public boolean dMy() {
        return this.ncH;
    }

    public void xM(boolean z) {
        this.ncH = z;
        this.ncD = 0;
    }

    public boolean dMz() {
        return this.ncI;
    }

    public void xN(boolean z) {
        this.ncI = z;
    }

    public int dMA() {
        return this.ncJ;
    }

    public void KD(int i) {
        this.ncJ = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dMB() {
        return this.ncG;
    }

    public void xO(boolean z) {
        this.ncG = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.ncD = jSONObject.optInt("is_sign_in");
            this.gxK = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.ncE = jSONObject.optInt("user_exp");
            this.ncF = jSONObject.optInt("need_exp");
            if (this.ncD != 0) {
                this.isSigned = true;
                this.ncH = false;
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
