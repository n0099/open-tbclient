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
    private int fNL;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private boolean mfA;
    private boolean mfB;
    private int mfC;
    private int mfv;
    private int mfw;
    private int mfx;
    private int mfy;
    private boolean mfz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dxR() {
        return this.mfv;
    }

    public int dxS() {
        return this.fNL;
    }

    public int dxT() {
        return this.mfw;
    }

    public int dxU() {
        return this.mfx;
    }

    public int dxV() {
        return this.mfy;
    }

    public void HW(int i) {
        this.mfv = i;
    }

    public void HX(int i) {
        this.fNL = i;
    }

    public void HY(int i) {
        this.mfw = i;
    }

    public boolean bHX() {
        return this.isSigned;
    }

    public void vW(boolean z) {
        this.isSigned = z;
        this.mfv = 1;
    }

    public boolean dxW() {
        return this.mfA;
    }

    public void vX(boolean z) {
        this.mfA = z;
        this.mfv = 0;
    }

    public boolean dxX() {
        return this.mfB;
    }

    public void vY(boolean z) {
        this.mfB = z;
    }

    public int dxY() {
        return this.mfC;
    }

    public void HZ(int i) {
        this.mfC = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dxZ() {
        return this.mfz;
    }

    public void vZ(boolean z) {
        this.mfz = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.mfv = jSONObject.optInt("is_sign_in");
            this.fNL = jSONObject.optInt("cont_sign_num");
            this.mfw = jSONObject.optInt("user_level");
            this.mfx = jSONObject.optInt("user_exp");
            this.mfy = jSONObject.optInt("need_exp");
            if (this.mfv != 0) {
                this.isSigned = true;
                this.mfA = false;
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
