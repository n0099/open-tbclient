package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int drG;
    private int eJF;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iQf;
    private int iQg;
    private int iQh;
    private boolean iQi;
    private boolean iQj;
    private boolean iQk;
    private boolean iQl;
    private int iQm;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cjZ() {
        return this.iQf;
    }

    public int cka() {
        return this.drG;
    }

    public int ckb() {
        return this.eJF;
    }

    public int ckc() {
        return this.iQg;
    }

    public int ckd() {
        return this.iQh;
    }

    public void Ae(int i) {
        this.iQf = i;
    }

    public void Af(int i) {
        this.drG = i;
    }

    public void Ag(int i) {
        this.eJF = i;
    }

    public boolean aIt() {
        return this.iQi;
    }

    public void qy(boolean z) {
        this.iQi = z;
        this.iQf = 1;
    }

    public boolean cke() {
        return this.iQk;
    }

    public void qz(boolean z) {
        this.iQk = z;
        this.iQf = 0;
    }

    public boolean ckf() {
        return this.iQl;
    }

    public void qA(boolean z) {
        this.iQl = z;
    }

    public int ckg() {
        return this.iQm;
    }

    public void Ah(int i) {
        this.iQm = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean ckh() {
        return this.iQj;
    }

    public void qB(boolean z) {
        this.iQj = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.iQf = jSONObject.optInt("is_sign_in");
            this.drG = jSONObject.optInt("cont_sign_num");
            this.eJF = jSONObject.optInt("user_level");
            this.iQg = jSONObject.optInt("user_exp");
            this.iQh = jSONObject.optInt("need_exp");
            if (this.iQf != 0) {
                this.iQi = true;
                this.iQk = false;
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
