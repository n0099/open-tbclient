package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class d implements ag {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int fzb;
    private boolean isSigned;
    private int lDY;
    private int lDZ;
    private int lEa;
    private int lEb;
    private boolean lEc;
    private boolean lEd;
    private boolean lEe;
    private int lEf;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int diy() {
        return this.lDY;
    }

    public int diz() {
        return this.fzb;
    }

    public int diA() {
        return this.lDZ;
    }

    public int diB() {
        return this.lEa;
    }

    public int diC() {
        return this.lEb;
    }

    public void EW(int i) {
        this.lDY = i;
    }

    public void EX(int i) {
        this.fzb = i;
    }

    public void EY(int i) {
        this.lDZ = i;
    }

    public boolean bxH() {
        return this.isSigned;
    }

    public void uX(boolean z) {
        this.isSigned = z;
        this.lDY = 1;
    }

    public boolean diD() {
        return this.lEd;
    }

    public void uY(boolean z) {
        this.lEd = z;
        this.lDY = 0;
    }

    public boolean diE() {
        return this.lEe;
    }

    public void uZ(boolean z) {
        this.lEe = z;
    }

    public int diF() {
        return this.lEf;
    }

    public void EZ(int i) {
        this.lEf = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean diG() {
        return this.lEc;
    }

    public void va(boolean z) {
        this.lEc = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lDY = jSONObject.optInt("is_sign_in");
            this.fzb = jSONObject.optInt("cont_sign_num");
            this.lDZ = jSONObject.optInt("user_level");
            this.lEa = jSONObject.optInt("user_exp");
            this.lEb = jSONObject.optInt("need_exp");
            if (this.lDY != 0) {
                this.isSigned = true;
                this.lEd = false;
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
