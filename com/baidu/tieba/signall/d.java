package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d implements ae {
    private String avatar;
    private int eno;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int jXe;
    private int jXf;
    private int jXg;
    private int jXh;
    private boolean jXi;
    private boolean jXj;
    private boolean jXk;
    private boolean jXl;
    private int jXm;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cHc() {
        return this.jXe;
    }

    public int cHd() {
        return this.eno;
    }

    public int cHe() {
        return this.jXf;
    }

    public int cHf() {
        return this.jXg;
    }

    public int cHg() {
        return this.jXh;
    }

    public void BX(int i) {
        this.jXe = i;
    }

    public void BY(int i) {
        this.eno = i;
    }

    public void BZ(int i) {
        this.jXf = i;
    }

    public boolean baP() {
        return this.jXi;
    }

    public void sv(boolean z) {
        this.jXi = z;
        this.jXe = 1;
    }

    public boolean cHh() {
        return this.jXk;
    }

    public void sw(boolean z) {
        this.jXk = z;
        this.jXe = 0;
    }

    public boolean cHi() {
        return this.jXl;
    }

    public void sx(boolean z) {
        this.jXl = z;
    }

    public int cHj() {
        return this.jXm;
    }

    public void Ca(int i) {
        this.jXm = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cHk() {
        return this.jXj;
    }

    public void sy(boolean z) {
        this.jXj = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jXe = jSONObject.optInt("is_sign_in");
            this.eno = jSONObject.optInt("cont_sign_num");
            this.jXf = jSONObject.optInt("user_level");
            this.jXg = jSONObject.optInt("user_exp");
            this.jXh = jSONObject.optInt("need_exp");
            if (this.jXe != 0) {
                this.jXi = true;
                this.jXk = false;
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
