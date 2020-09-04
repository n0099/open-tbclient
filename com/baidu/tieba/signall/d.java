package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class d implements ah {
    private String avatar;
    private String errorMsg;
    private int fKx;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int lVT;
    private int lVU;
    private int lVV;
    private int lVW;
    private boolean lVX;
    private boolean lVY;
    private boolean lVZ;
    private int lWa;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dtY() {
        return this.lVT;
    }

    public int dtZ() {
        return this.fKx;
    }

    public int dua() {
        return this.lVU;
    }

    public int dub() {
        return this.lVV;
    }

    public int duc() {
        return this.lVW;
    }

    public void Ht(int i) {
        this.lVT = i;
    }

    public void Hu(int i) {
        this.fKx = i;
    }

    public void Hv(int i) {
        this.lVU = i;
    }

    public boolean bGH() {
        return this.isSigned;
    }

    public void vO(boolean z) {
        this.isSigned = z;
        this.lVT = 1;
    }

    public boolean dud() {
        return this.lVY;
    }

    public void vP(boolean z) {
        this.lVY = z;
        this.lVT = 0;
    }

    public boolean due() {
        return this.lVZ;
    }

    public void vQ(boolean z) {
        this.lVZ = z;
    }

    public int duf() {
        return this.lWa;
    }

    public void Hw(int i) {
        this.lWa = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dug() {
        return this.lVX;
    }

    public void vR(boolean z) {
        this.lVX = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lVT = jSONObject.optInt("is_sign_in");
            this.fKx = jSONObject.optInt("cont_sign_num");
            this.lVU = jSONObject.optInt("user_level");
            this.lVV = jSONObject.optInt("user_exp");
            this.lVW = jSONObject.optInt("need_exp");
            if (this.lVT != 0) {
                this.isSigned = true;
                this.lVY = false;
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
