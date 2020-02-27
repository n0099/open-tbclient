package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private int erB;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int jYe;
    private int jYf;
    private int jYg;
    private int jYh;
    private boolean jYi;
    private boolean jYj;
    private boolean jYk;
    private int jYl;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cIG() {
        return this.jYe;
    }

    public int cIH() {
        return this.erB;
    }

    public int cII() {
        return this.jYf;
    }

    public int cIJ() {
        return this.jYg;
    }

    public int cIK() {
        return this.jYh;
    }

    public void Ce(int i) {
        this.jYe = i;
    }

    public void Cf(int i) {
        this.erB = i;
    }

    public void Cg(int i) {
        this.jYf = i;
    }

    public boolean bde() {
        return this.isSigned;
    }

    public void sz(boolean z) {
        this.isSigned = z;
        this.jYe = 1;
    }

    public boolean cIL() {
        return this.jYj;
    }

    public void sA(boolean z) {
        this.jYj = z;
        this.jYe = 0;
    }

    public boolean cIM() {
        return this.jYk;
    }

    public void sB(boolean z) {
        this.jYk = z;
    }

    public int cIN() {
        return this.jYl;
    }

    public void Ch(int i) {
        this.jYl = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cIO() {
        return this.jYi;
    }

    public void sC(boolean z) {
        this.jYi = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jYe = jSONObject.optInt("is_sign_in");
            this.erB = jSONObject.optInt("cont_sign_num");
            this.jYf = jSONObject.optInt("user_level");
            this.jYg = jSONObject.optInt("user_exp");
            this.jYh = jSONObject.optInt("need_exp");
            if (this.jYe != 0) {
                this.isSigned = true;
                this.jYj = false;
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
