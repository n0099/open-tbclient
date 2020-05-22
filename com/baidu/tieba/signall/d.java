package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private String errorMsg;
    private int fiv;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int lbB;
    private int lbC;
    private int lbD;
    private int lbE;
    private boolean lbF;
    private boolean lbG;
    private boolean lbH;
    private int lbI;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int daI() {
        return this.lbB;
    }

    public int daJ() {
        return this.fiv;
    }

    public int daK() {
        return this.lbC;
    }

    public int daL() {
        return this.lbD;
    }

    public int daM() {
        return this.lbE;
    }

    public void Dw(int i) {
        this.lbB = i;
    }

    public void Dx(int i) {
        this.fiv = i;
    }

    public void Dy(int i) {
        this.lbC = i;
    }

    public boolean brz() {
        return this.isSigned;
    }

    public void ue(boolean z) {
        this.isSigned = z;
        this.lbB = 1;
    }

    public boolean daN() {
        return this.lbG;
    }

    public void uf(boolean z) {
        this.lbG = z;
        this.lbB = 0;
    }

    public boolean daO() {
        return this.lbH;
    }

    public void ug(boolean z) {
        this.lbH = z;
    }

    public int daP() {
        return this.lbI;
    }

    public void Dz(int i) {
        this.lbI = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean daQ() {
        return this.lbF;
    }

    public void uh(boolean z) {
        this.lbF = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lbB = jSONObject.optInt("is_sign_in");
            this.fiv = jSONObject.optInt("cont_sign_num");
            this.lbC = jSONObject.optInt("user_level");
            this.lbD = jSONObject.optInt("user_exp");
            this.lbE = jSONObject.optInt("need_exp");
            if (this.lbB != 0) {
                this.isSigned = true;
                this.lbG = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
