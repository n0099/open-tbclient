package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private int erP;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int jYs;
    private int jYt;
    private int jYu;
    private int jYv;
    private boolean jYw;
    private boolean jYx;
    private boolean jYy;
    private int jYz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cIJ() {
        return this.jYs;
    }

    public int cIK() {
        return this.erP;
    }

    public int cIL() {
        return this.jYt;
    }

    public int cIM() {
        return this.jYu;
    }

    public int cIN() {
        return this.jYv;
    }

    public void Ce(int i) {
        this.jYs = i;
    }

    public void Cf(int i) {
        this.erP = i;
    }

    public void Cg(int i) {
        this.jYt = i;
    }

    public boolean bdh() {
        return this.isSigned;
    }

    public void sz(boolean z) {
        this.isSigned = z;
        this.jYs = 1;
    }

    public boolean cIO() {
        return this.jYx;
    }

    public void sA(boolean z) {
        this.jYx = z;
        this.jYs = 0;
    }

    public boolean cIP() {
        return this.jYy;
    }

    public void sB(boolean z) {
        this.jYy = z;
    }

    public int cIQ() {
        return this.jYz;
    }

    public void Ch(int i) {
        this.jYz = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cIR() {
        return this.jYw;
    }

    public void sC(boolean z) {
        this.jYw = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jYs = jSONObject.optInt("is_sign_in");
            this.erP = jSONObject.optInt("cont_sign_num");
            this.jYt = jSONObject.optInt("user_level");
            this.jYu = jSONObject.optInt("user_exp");
            this.jYv = jSONObject.optInt("need_exp");
            if (this.jYs != 0) {
                this.isSigned = true;
                this.jYx = false;
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
