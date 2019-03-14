package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dgZ;
    private String errorMsg;
    private int eup;
    private int forumId;
    private String forumName;
    private int ixH;
    private int ixI;
    private int ixJ;
    private boolean ixK;
    private boolean ixL;
    private boolean ixM;
    private boolean ixN;
    private int ixO;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cbY() {
        return this.ixH;
    }

    public int cbZ() {
        return this.dgZ;
    }

    public int cca() {
        return this.eup;
    }

    public int ccb() {
        return this.ixI;
    }

    public int ccc() {
        return this.ixJ;
    }

    public void za(int i) {
        this.ixH = i;
    }

    public void zb(int i) {
        this.dgZ = i;
    }

    public void zc(int i) {
        this.eup = i;
    }

    public boolean aCj() {
        return this.ixK;
    }

    public void pJ(boolean z) {
        this.ixK = z;
        this.ixH = 1;
    }

    public boolean ccd() {
        return this.ixM;
    }

    public void pK(boolean z) {
        this.ixM = z;
        this.ixH = 0;
    }

    public boolean cce() {
        return this.ixN;
    }

    public void pL(boolean z) {
        this.ixN = z;
    }

    public int ccf() {
        return this.ixO;
    }

    public void zd(int i) {
        this.ixO = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ccg() {
        return this.ixL;
    }

    public void pM(boolean z) {
        this.ixL = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.ixH = jSONObject.optInt("is_sign_in");
            this.dgZ = jSONObject.optInt("cont_sign_num");
            this.eup = jSONObject.optInt("user_level");
            this.ixI = jSONObject.optInt("user_exp");
            this.ixJ = jSONObject.optInt("need_exp");
            if (this.ixH != 0) {
                this.ixK = true;
                this.ixM = false;
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
