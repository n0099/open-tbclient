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
    private int iQl;
    private int iQm;
    private int iQn;
    private boolean iQo;
    private boolean iQp;
    private boolean iQq;
    private boolean iQr;
    private int iQs;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int ckc() {
        return this.iQl;
    }

    public int ckd() {
        return this.drH;
    }

    public int cke() {
        return this.eJG;
    }

    public int ckf() {
        return this.iQm;
    }

    public int ckg() {
        return this.iQn;
    }

    public void Ae(int i) {
        this.iQl = i;
    }

    public void Af(int i) {
        this.drH = i;
    }

    public void Ag(int i) {
        this.eJG = i;
    }

    public boolean aIw() {
        return this.iQo;
    }

    public void qz(boolean z) {
        this.iQo = z;
        this.iQl = 1;
    }

    public boolean ckh() {
        return this.iQq;
    }

    public void qA(boolean z) {
        this.iQq = z;
        this.iQl = 0;
    }

    public boolean cki() {
        return this.iQr;
    }

    public void qB(boolean z) {
        this.iQr = z;
    }

    public int ckj() {
        return this.iQs;
    }

    public void Ah(int i) {
        this.iQs = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ckk() {
        return this.iQp;
    }

    public void qC(boolean z) {
        this.iQp = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.iQl = jSONObject.optInt("is_sign_in");
            this.drH = jSONObject.optInt("cont_sign_num");
            this.eJG = jSONObject.optInt("user_level");
            this.iQm = jSONObject.optInt("user_exp");
            this.iQn = jSONObject.optInt("need_exp");
            if (this.iQl != 0) {
                this.iQo = true;
                this.iQq = false;
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
