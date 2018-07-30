package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements af {
    private String avatar;
    private int bxY;
    private int cKY;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gEs;
    private int gEt;
    private int gEu;
    private boolean gEv;
    private boolean gEw;
    private boolean gEx;
    private boolean gEy;
    private int gEz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bsy() {
        return this.gEs;
    }

    public int bsz() {
        return this.bxY;
    }

    public int bsA() {
        return this.cKY;
    }

    public int bsB() {
        return this.gEt;
    }

    public int bsC() {
        return this.gEu;
    }

    public void ti(int i) {
        this.gEs = i;
    }

    public void tj(int i) {
        this.bxY = i;
    }

    public void tk(int i) {
        this.cKY = i;
    }

    public boolean TX() {
        return this.gEv;
    }

    public void md(boolean z) {
        this.gEv = z;
        this.gEs = 1;
    }

    public boolean bsD() {
        return this.gEx;
    }

    public void me(boolean z) {
        this.gEx = z;
        this.gEs = 0;
    }

    public boolean bsE() {
        return this.gEy;
    }

    public void mf(boolean z) {
        this.gEy = z;
    }

    public int bsF() {
        return this.gEz;
    }

    public void tl(int i) {
        this.gEz = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bsG() {
        return this.gEw;
    }

    public void mg(boolean z) {
        this.gEw = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gEs = jSONObject.optInt("is_sign_in");
            this.bxY = jSONObject.optInt("cont_sign_num");
            this.cKY = jSONObject.optInt("user_level");
            this.gEt = jSONObject.optInt("user_exp");
            this.gEu = jSONObject.optInt("need_exp");
            if (this.gEs != 0) {
                this.gEv = true;
                this.gEx = false;
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
