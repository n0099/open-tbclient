package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private int eVH;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int kJh;
    private int kJi;
    private int kJj;
    private int kJk;
    private boolean kJl;
    private boolean kJm;
    private boolean kJn;
    private int kJo;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cTG() {
        return this.kJh;
    }

    public int cTH() {
        return this.eVH;
    }

    public int cTI() {
        return this.kJi;
    }

    public int cTJ() {
        return this.kJj;
    }

    public int cTK() {
        return this.kJk;
    }

    public void CM(int i) {
        this.kJh = i;
    }

    public void CN(int i) {
        this.eVH = i;
    }

    public void CO(int i) {
        this.kJi = i;
    }

    public boolean bmd() {
        return this.isSigned;
    }

    public void tG(boolean z) {
        this.isSigned = z;
        this.kJh = 1;
    }

    public boolean cTL() {
        return this.kJm;
    }

    public void tH(boolean z) {
        this.kJm = z;
        this.kJh = 0;
    }

    public boolean cTM() {
        return this.kJn;
    }

    public void tI(boolean z) {
        this.kJn = z;
    }

    public int cTN() {
        return this.kJo;
    }

    public void CP(int i) {
        this.kJo = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cTO() {
        return this.kJl;
    }

    public void tJ(boolean z) {
        this.kJl = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.kJh = jSONObject.optInt("is_sign_in");
            this.eVH = jSONObject.optInt("cont_sign_num");
            this.kJi = jSONObject.optInt("user_level");
            this.kJj = jSONObject.optInt("user_exp");
            this.kJk = jSONObject.optInt("need_exp");
            if (this.kJh != 0) {
                this.isSigned = true;
                this.kJm = false;
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
