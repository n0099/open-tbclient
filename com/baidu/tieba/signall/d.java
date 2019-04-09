package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dhd;
    private String errorMsg;
    private int eub;
    private int forumId;
    private String forumName;
    private int ixs;
    private int ixt;
    private int ixu;
    private boolean ixv;
    private boolean ixw;
    private boolean ixx;
    private boolean ixy;
    private int ixz;

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
        return this.ixs;
    }

    public int cbV() {
        return this.dhd;
    }

    public int cbW() {
        return this.eub;
    }

    public int cbX() {
        return this.ixt;
    }

    public int cbY() {
        return this.ixu;
    }

    public void yW(int i) {
        this.ixs = i;
    }

    public void yX(int i) {
        this.dhd = i;
    }

    public void yY(int i) {
        this.eub = i;
    }

    public boolean aCg() {
        return this.ixv;
    }

    public void pJ(boolean z) {
        this.ixv = z;
        this.ixs = 1;
    }

    public boolean cbZ() {
        return this.ixx;
    }

    public void pK(boolean z) {
        this.ixx = z;
        this.ixs = 0;
    }

    public boolean cca() {
        return this.ixy;
    }

    public void pL(boolean z) {
        this.ixy = z;
    }

    public int ccb() {
        return this.ixz;
    }

    public void yZ(int i) {
        this.ixz = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ccc() {
        return this.ixw;
    }

    public void pM(boolean z) {
        this.ixw = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.ixs = jSONObject.optInt("is_sign_in");
            this.dhd = jSONObject.optInt("cont_sign_num");
            this.eub = jSONObject.optInt("user_level");
            this.ixt = jSONObject.optInt("user_exp");
            this.ixu = jSONObject.optInt("need_exp");
            if (this.ixs != 0) {
                this.ixv = true;
                this.ixx = false;
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
