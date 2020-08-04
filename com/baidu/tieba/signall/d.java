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
    private int lEa;
    private int lEb;
    private int lEc;
    private int lEd;
    private boolean lEe;
    private boolean lEf;
    private boolean lEg;
    private int lEh;

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
        return this.lEa;
    }

    public int diz() {
        return this.fzb;
    }

    public int diA() {
        return this.lEb;
    }

    public int diB() {
        return this.lEc;
    }

    public int diC() {
        return this.lEd;
    }

    public void EW(int i) {
        this.lEa = i;
    }

    public void EX(int i) {
        this.fzb = i;
    }

    public void EY(int i) {
        this.lEb = i;
    }

    public boolean bxH() {
        return this.isSigned;
    }

    public void uX(boolean z) {
        this.isSigned = z;
        this.lEa = 1;
    }

    public boolean diD() {
        return this.lEf;
    }

    public void uY(boolean z) {
        this.lEf = z;
        this.lEa = 0;
    }

    public boolean diE() {
        return this.lEg;
    }

    public void uZ(boolean z) {
        this.lEg = z;
    }

    public int diF() {
        return this.lEh;
    }

    public void EZ(int i) {
        this.lEh = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean diG() {
        return this.lEe;
    }

    public void va(boolean z) {
        this.lEe = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lEa = jSONObject.optInt("is_sign_in");
            this.fzb = jSONObject.optInt("cont_sign_num");
            this.lEb = jSONObject.optInt("user_level");
            this.lEc = jSONObject.optInt("user_exp");
            this.lEd = jSONObject.optInt("need_exp");
            if (this.lEa != 0) {
                this.isSigned = true;
                this.lEf = false;
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
