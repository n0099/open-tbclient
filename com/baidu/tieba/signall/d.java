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
    private int gkh;
    private boolean isSigned;
    private int mHE;
    private int mHF;
    private int mHG;
    private int mHH;
    private boolean mHI;
    private boolean mHJ;
    private boolean mHK;
    private int mHL;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dEK() {
        return this.mHE;
    }

    public int dEL() {
        return this.gkh;
    }

    public int dEM() {
        return this.mHF;
    }

    public int dEN() {
        return this.mHG;
    }

    public int dEO() {
        return this.mHH;
    }

    public void IV(int i) {
        this.mHE = i;
    }

    public void IW(int i) {
        this.gkh = i;
    }

    public void IX(int i) {
        this.mHF = i;
    }

    public boolean bNl() {
        return this.isSigned;
    }

    public void wU(boolean z) {
        this.isSigned = z;
        this.mHE = 1;
    }

    public boolean dEP() {
        return this.mHJ;
    }

    public void wV(boolean z) {
        this.mHJ = z;
        this.mHE = 0;
    }

    public boolean dEQ() {
        return this.mHK;
    }

    public void wW(boolean z) {
        this.mHK = z;
    }

    public int dER() {
        return this.mHL;
    }

    public void IY(int i) {
        this.mHL = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dES() {
        return this.mHI;
    }

    public void wX(boolean z) {
        this.mHI = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.mHE = jSONObject.optInt("is_sign_in");
            this.gkh = jSONObject.optInt("cont_sign_num");
            this.mHF = jSONObject.optInt("user_level");
            this.mHG = jSONObject.optInt("user_exp");
            this.mHH = jSONObject.optInt("need_exp");
            if (this.mHE != 0) {
                this.isSigned = true;
                this.mHJ = false;
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
