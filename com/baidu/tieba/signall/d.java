package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bRL;
    private int dkw;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int hfX;
    private int hfY;
    private int hfZ;
    private boolean hga;
    private boolean hgb;
    private boolean hgc;
    private boolean hgd;
    private int hge;

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
        return this.hfX;
    }

    public int bBi() {
        return this.bRL;
    }

    public int bBj() {
        return this.dkw;
    }

    public int bBk() {
        return this.hfY;
    }

    public int bBl() {
        return this.hfZ;
    }

    public void vk(int i) {
        this.hfX = i;
    }

    public void vl(int i) {
        this.bRL = i;
    }

    public void vm(int i) {
        this.dkw = i;
    }

    public boolean abk() {
        return this.hga;
    }

    public void nj(boolean z) {
        this.hga = z;
        this.hfX = 1;
    }

    public boolean bBm() {
        return this.hgc;
    }

    public void nk(boolean z) {
        this.hgc = z;
        this.hfX = 0;
    }

    public boolean bBn() {
        return this.hgd;
    }

    public void nl(boolean z) {
        this.hgd = z;
    }

    public int bBo() {
        return this.hge;
    }

    public void vn(int i) {
        this.hge = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bBp() {
        return this.hgb;
    }

    public void nm(boolean z) {
        this.hgb = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.hfX = jSONObject.optInt("is_sign_in");
            this.bRL = jSONObject.optInt("cont_sign_num");
            this.dkw = jSONObject.optInt("user_level");
            this.hfY = jSONObject.optInt("user_exp");
            this.hfZ = jSONObject.optInt("need_exp");
            if (this.hfX != 0) {
                this.hga = true;
                this.hgc = false;
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
