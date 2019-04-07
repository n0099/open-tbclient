package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dhc;
    private String errorMsg;
    private int eua;
    private int forumId;
    private String forumName;
    private int ixr;
    private int ixs;
    private int ixt;
    private boolean ixu;
    private boolean ixv;
    private boolean ixw;
    private boolean ixx;
    private int ixy;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cbU() {
        return this.ixr;
    }

    public int cbV() {
        return this.dhc;
    }

    public int cbW() {
        return this.eua;
    }

    public int cbX() {
        return this.ixs;
    }

    public int cbY() {
        return this.ixt;
    }

    public void yW(int i) {
        this.ixr = i;
    }

    public void yX(int i) {
        this.dhc = i;
    }

    public void yY(int i) {
        this.eua = i;
    }

    public boolean aCg() {
        return this.ixu;
    }

    public void pJ(boolean z) {
        this.ixu = z;
        this.ixr = 1;
    }

    public boolean cbZ() {
        return this.ixw;
    }

    public void pK(boolean z) {
        this.ixw = z;
        this.ixr = 0;
    }

    public boolean cca() {
        return this.ixx;
    }

    public void pL(boolean z) {
        this.ixx = z;
    }

    public int ccb() {
        return this.ixy;
    }

    public void yZ(int i) {
        this.ixy = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ccc() {
        return this.ixv;
    }

    public void pM(boolean z) {
        this.ixv = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.ixr = jSONObject.optInt("is_sign_in");
            this.dhc = jSONObject.optInt("cont_sign_num");
            this.eua = jSONObject.optInt("user_level");
            this.ixs = jSONObject.optInt("user_exp");
            this.ixt = jSONObject.optInt("need_exp");
            if (this.ixr != 0) {
                this.ixu = true;
                this.ixw = false;
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
