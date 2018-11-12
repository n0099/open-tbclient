package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bNf;
    private int dah;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gUW;
    private int gUX;
    private int gUY;
    private boolean gUZ;
    private boolean gVa;
    private boolean gVb;
    private boolean gVc;
    private int gVd;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bxP() {
        return this.gUW;
    }

    public int bxQ() {
        return this.bNf;
    }

    public int bxR() {
        return this.dah;
    }

    public int bxS() {
        return this.gUX;
    }

    public int bxT() {
        return this.gUY;
    }

    public void uy(int i) {
        this.gUW = i;
    }

    public void uz(int i) {
        this.bNf = i;
    }

    public void uA(int i) {
        this.dah = i;
    }

    public boolean ZF() {
        return this.gUZ;
    }

    public void nd(boolean z) {
        this.gUZ = z;
        this.gUW = 1;
    }

    public boolean bxU() {
        return this.gVb;
    }

    public void ne(boolean z) {
        this.gVb = z;
        this.gUW = 0;
    }

    public boolean bxV() {
        return this.gVc;
    }

    public void nf(boolean z) {
        this.gVc = z;
    }

    public int bxW() {
        return this.gVd;
    }

    public void uB(int i) {
        this.gVd = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bxX() {
        return this.gVa;
    }

    public void ng(boolean z) {
        this.gVa = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gUW = jSONObject.optInt("is_sign_in");
            this.bNf = jSONObject.optInt("cont_sign_num");
            this.dah = jSONObject.optInt("user_level");
            this.gUX = jSONObject.optInt("user_exp");
            this.gUY = jSONObject.optInt("need_exp");
            if (this.gUW != 0) {
                this.gUZ = true;
                this.gVb = false;
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
