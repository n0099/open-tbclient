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
    private int fKt;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int lVE;
    private int lVF;
    private int lVG;
    private int lVH;
    private boolean lVI;
    private boolean lVJ;
    private boolean lVK;
    private int lVL;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dtT() {
        return this.lVE;
    }

    public int dtU() {
        return this.fKt;
    }

    public int dtV() {
        return this.lVF;
    }

    public int dtW() {
        return this.lVG;
    }

    public int dtX() {
        return this.lVH;
    }

    public void Ht(int i) {
        this.lVE = i;
    }

    public void Hu(int i) {
        this.fKt = i;
    }

    public void Hv(int i) {
        this.lVF = i;
    }

    public boolean bGG() {
        return this.isSigned;
    }

    public void vM(boolean z) {
        this.isSigned = z;
        this.lVE = 1;
    }

    public boolean dtY() {
        return this.lVJ;
    }

    public void vN(boolean z) {
        this.lVJ = z;
        this.lVE = 0;
    }

    public boolean dtZ() {
        return this.lVK;
    }

    public void vO(boolean z) {
        this.lVK = z;
    }

    public int dua() {
        return this.lVL;
    }

    public void Hw(int i) {
        this.lVL = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dub() {
        return this.lVI;
    }

    public void vP(boolean z) {
        this.lVI = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lVE = jSONObject.optInt("is_sign_in");
            this.fKt = jSONObject.optInt("cont_sign_num");
            this.lVF = jSONObject.optInt("user_level");
            this.lVG = jSONObject.optInt("user_exp");
            this.lVH = jSONObject.optInt("need_exp");
            if (this.lVE != 0) {
                this.isSigned = true;
                this.lVJ = false;
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
