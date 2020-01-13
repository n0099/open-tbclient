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
    private int jWZ;
    private int jXa;
    private int jXb;
    private int jXc;
    private boolean jXd;
    private boolean jXe;
    private boolean jXf;
    private boolean jXg;
    private int jXh;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cHa() {
        return this.jWZ;
    }

    public int cHb() {
        return this.eno;
    }

    public int cHc() {
        return this.jXa;
    }

    public int cHd() {
        return this.jXb;
    }

    public int cHe() {
        return this.jXc;
    }

    public void BX(int i) {
        this.jWZ = i;
    }

    public void BY(int i) {
        this.eno = i;
    }

    public void BZ(int i) {
        this.jXa = i;
    }

    public boolean baP() {
        return this.jXd;
    }

    public void sv(boolean z) {
        this.jXd = z;
        this.jWZ = 1;
    }

    public boolean cHf() {
        return this.jXf;
    }

    public void sw(boolean z) {
        this.jXf = z;
        this.jWZ = 0;
    }

    public boolean cHg() {
        return this.jXg;
    }

    public void sx(boolean z) {
        this.jXg = z;
    }

    public int cHh() {
        return this.jXh;
    }

    public void Ca(int i) {
        this.jXh = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cHi() {
        return this.jXe;
    }

    public void sy(boolean z) {
        this.jXe = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jWZ = jSONObject.optInt("is_sign_in");
            this.eno = jSONObject.optInt("cont_sign_num");
            this.jXa = jSONObject.optInt("user_level");
            this.jXb = jSONObject.optInt("user_exp");
            this.jXc = jSONObject.optInt("need_exp");
            if (this.jWZ != 0) {
                this.jXd = true;
                this.jXf = false;
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
