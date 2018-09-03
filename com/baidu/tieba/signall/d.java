package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements af {
    private String avatar;
    private int bya;
    private int cKV;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean gEA;
    private boolean gEB;
    private int gEC;
    private int gEv;
    private int gEw;
    private int gEx;
    private boolean gEy;
    private boolean gEz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bsz() {
        return this.gEv;
    }

    public int bsA() {
        return this.bya;
    }

    public int bsB() {
        return this.cKV;
    }

    public int bsC() {
        return this.gEw;
    }

    public int bsD() {
        return this.gEx;
    }

    public void ti(int i) {
        this.gEv = i;
    }

    public void tj(int i) {
        this.bya = i;
    }

    public void tk(int i) {
        this.cKV = i;
    }

    public boolean Ua() {
        return this.gEy;
    }

    public void md(boolean z) {
        this.gEy = z;
        this.gEv = 1;
    }

    public boolean bsE() {
        return this.gEA;
    }

    public void me(boolean z) {
        this.gEA = z;
        this.gEv = 0;
    }

    public boolean bsF() {
        return this.gEB;
    }

    public void mf(boolean z) {
        this.gEB = z;
    }

    public int bsG() {
        return this.gEC;
    }

    public void tl(int i) {
        this.gEC = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bsH() {
        return this.gEz;
    }

    public void mg(boolean z) {
        this.gEz = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gEv = jSONObject.optInt("is_sign_in");
            this.bya = jSONObject.optInt("cont_sign_num");
            this.cKV = jSONObject.optInt("user_level");
            this.gEw = jSONObject.optInt("user_exp");
            this.gEx = jSONObject.optInt("need_exp");
            if (this.gEv != 0) {
                this.gEy = true;
                this.gEA = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
