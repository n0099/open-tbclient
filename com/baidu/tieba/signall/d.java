package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int drH;
    private int eJG;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iQh;
    private int iQi;
    private int iQj;
    private boolean iQk;
    private boolean iQl;
    private boolean iQm;
    private boolean iQn;
    private int iQo;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int ckb() {
        return this.iQh;
    }

    public int ckc() {
        return this.drH;
    }

    public int ckd() {
        return this.eJG;
    }

    public int cke() {
        return this.iQi;
    }

    public int ckf() {
        return this.iQj;
    }

    public void Ae(int i) {
        this.iQh = i;
    }

    public void Af(int i) {
        this.drH = i;
    }

    public void Ag(int i) {
        this.eJG = i;
    }

    public boolean aIw() {
        return this.iQk;
    }

    public void qy(boolean z) {
        this.iQk = z;
        this.iQh = 1;
    }

    public boolean ckg() {
        return this.iQm;
    }

    public void qz(boolean z) {
        this.iQm = z;
        this.iQh = 0;
    }

    public boolean ckh() {
        return this.iQn;
    }

    public void qA(boolean z) {
        this.iQn = z;
    }

    public int cki() {
        return this.iQo;
    }

    public void Ah(int i) {
        this.iQo = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ckj() {
        return this.iQl;
    }

    public void qB(boolean z) {
        this.iQl = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.iQh = jSONObject.optInt("is_sign_in");
            this.drH = jSONObject.optInt("cont_sign_num");
            this.eJG = jSONObject.optInt("user_level");
            this.iQi = jSONObject.optInt("user_exp");
            this.iQj = jSONObject.optInt("need_exp");
            if (this.iQh != 0) {
                this.iQk = true;
                this.iQm = false;
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
