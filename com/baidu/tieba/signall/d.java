package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private int erC;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int jYg;
    private int jYh;
    private int jYi;
    private int jYj;
    private boolean jYk;
    private boolean jYl;
    private boolean jYm;
    private int jYn;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cII() {
        return this.jYg;
    }

    public int cIJ() {
        return this.erC;
    }

    public int cIK() {
        return this.jYh;
    }

    public int cIL() {
        return this.jYi;
    }

    public int cIM() {
        return this.jYj;
    }

    public void Ce(int i) {
        this.jYg = i;
    }

    public void Cf(int i) {
        this.erC = i;
    }

    public void Cg(int i) {
        this.jYh = i;
    }

    public boolean bdg() {
        return this.isSigned;
    }

    public void sz(boolean z) {
        this.isSigned = z;
        this.jYg = 1;
    }

    public boolean cIN() {
        return this.jYl;
    }

    public void sA(boolean z) {
        this.jYl = z;
        this.jYg = 0;
    }

    public boolean cIO() {
        return this.jYm;
    }

    public void sB(boolean z) {
        this.jYm = z;
    }

    public int cIP() {
        return this.jYn;
    }

    public void Ch(int i) {
        this.jYn = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cIQ() {
        return this.jYk;
    }

    public void sC(boolean z) {
        this.jYk = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jYg = jSONObject.optInt("is_sign_in");
            this.erC = jSONObject.optInt("cont_sign_num");
            this.jYh = jSONObject.optInt("user_level");
            this.jYi = jSONObject.optInt("user_exp");
            this.jYj = jSONObject.optInt("need_exp");
            if (this.jYg != 0) {
                this.isSigned = true;
                this.jYl = false;
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
