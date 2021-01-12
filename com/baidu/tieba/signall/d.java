package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements ag {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gEj;
    private boolean isSigned;
    private int ndF;
    private int ndG;
    private int ndH;
    private boolean ndI;
    private boolean ndJ;
    private boolean ndK;
    private int ndL;
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

    public int dIw() {
        return this.ndF;
    }

    public int dIx() {
        return this.gEj;
    }

    public int bKd() {
        return this.userLevel;
    }

    public int dIy() {
        return this.ndG;
    }

    public int dIz() {
        return this.ndH;
    }

    public void IP(int i) {
        this.ndF = i;
    }

    public void IQ(int i) {
        this.gEj = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bRD() {
        return this.isSigned;
    }

    public void xJ(boolean z) {
        this.isSigned = z;
        this.ndF = 1;
    }

    public boolean dIA() {
        return this.ndJ;
    }

    public void xK(boolean z) {
        this.ndJ = z;
        this.ndF = 0;
    }

    public boolean dIB() {
        return this.ndK;
    }

    public void xL(boolean z) {
        this.ndK = z;
    }

    public int dIC() {
        return this.ndL;
    }

    public void IR(int i) {
        this.ndL = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dID() {
        return this.ndI;
    }

    public void xM(boolean z) {
        this.ndI = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.ndF = jSONObject.optInt("is_sign_in");
            this.gEj = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.ndG = jSONObject.optInt("user_exp");
            this.ndH = jSONObject.optInt("need_exp");
            if (this.ndF != 0) {
                this.isSigned = true;
                this.ndJ = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
