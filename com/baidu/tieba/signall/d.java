package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dvI;
    private int eQr;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int jab;
    private int jac;
    private int jad;
    private boolean jae;
    private boolean jaf;
    private boolean jag;
    private boolean jah;
    private int jai;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cnY() {
        return this.jab;
    }

    public int cnZ() {
        return this.dvI;
    }

    public int coa() {
        return this.eQr;
    }

    public int cob() {
        return this.jac;
    }

    public int coc() {
        return this.jad;
    }

    public void AP(int i) {
        this.jab = i;
    }

    public void AQ(int i) {
        this.dvI = i;
    }

    public void AR(int i) {
        this.eQr = i;
    }

    public boolean aKD() {
        return this.jae;
    }

    public void qS(boolean z) {
        this.jae = z;
        this.jab = 1;
    }

    public boolean cod() {
        return this.jag;
    }

    public void qT(boolean z) {
        this.jag = z;
        this.jab = 0;
    }

    public boolean coe() {
        return this.jah;
    }

    public void qU(boolean z) {
        this.jah = z;
    }

    public int cof() {
        return this.jai;
    }

    public void AS(int i) {
        this.jai = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cog() {
        return this.jaf;
    }

    public void qV(boolean z) {
        this.jaf = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.jab = jSONObject.optInt("is_sign_in");
            this.dvI = jSONObject.optInt("cont_sign_num");
            this.eQr = jSONObject.optInt("user_level");
            this.jac = jSONObject.optInt("user_exp");
            this.jad = jSONObject.optInt("need_exp");
            if (this.jab != 0) {
                this.jae = true;
                this.jag = false;
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
