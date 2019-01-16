package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bRK;
    private int dkv;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int hfW;
    private int hfX;
    private int hfY;
    private boolean hfZ;
    private boolean hga;
    private boolean hgb;
    private boolean hgc;
    private int hgd;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bBh() {
        return this.hfW;
    }

    public int bBi() {
        return this.bRK;
    }

    public int bBj() {
        return this.dkv;
    }

    public int bBk() {
        return this.hfX;
    }

    public int bBl() {
        return this.hfY;
    }

    public void vk(int i) {
        this.hfW = i;
    }

    public void vl(int i) {
        this.bRK = i;
    }

    public void vm(int i) {
        this.dkv = i;
    }

    public boolean abk() {
        return this.hfZ;
    }

    public void nj(boolean z) {
        this.hfZ = z;
        this.hfW = 1;
    }

    public boolean bBm() {
        return this.hgb;
    }

    public void nk(boolean z) {
        this.hgb = z;
        this.hfW = 0;
    }

    public boolean bBn() {
        return this.hgc;
    }

    public void nl(boolean z) {
        this.hgc = z;
    }

    public int bBo() {
        return this.hgd;
    }

    public void vn(int i) {
        this.hgd = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bBp() {
        return this.hga;
    }

    public void nm(boolean z) {
        this.hga = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.hfW = jSONObject.optInt("is_sign_in");
            this.bRK = jSONObject.optInt("cont_sign_num");
            this.dkv = jSONObject.optInt("user_level");
            this.hfX = jSONObject.optInt("user_exp");
            this.hfY = jSONObject.optInt("need_exp");
            if (this.hfW != 0) {
                this.hfZ = true;
                this.hgb = false;
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
