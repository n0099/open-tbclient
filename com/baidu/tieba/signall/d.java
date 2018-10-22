package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bMu;
    private int cZc;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean gTA;
    private boolean gTB;
    private boolean gTC;
    private int gTD;
    private int gTw;
    private int gTx;
    private int gTy;
    private boolean gTz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int byt() {
        return this.gTw;
    }

    public int byu() {
        return this.bMu;
    }

    public int byv() {
        return this.cZc;
    }

    public int byw() {
        return this.gTx;
    }

    public int byx() {
        return this.gTy;
    }

    public void uf(int i) {
        this.gTw = i;
    }

    public void ug(int i) {
        this.bMu = i;
    }

    public void uh(int i) {
        this.cZc = i;
    }

    public boolean Zv() {
        return this.gTz;
    }

    public void mS(boolean z) {
        this.gTz = z;
        this.gTw = 1;
    }

    public boolean byy() {
        return this.gTB;
    }

    public void mT(boolean z) {
        this.gTB = z;
        this.gTw = 0;
    }

    public boolean byz() {
        return this.gTC;
    }

    public void mU(boolean z) {
        this.gTC = z;
    }

    public int byA() {
        return this.gTD;
    }

    public void ui(int i) {
        this.gTD = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean byB() {
        return this.gTA;
    }

    public void mV(boolean z) {
        this.gTA = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gTw = jSONObject.optInt("is_sign_in");
            this.bMu = jSONObject.optInt("cont_sign_num");
            this.cZc = jSONObject.optInt("user_level");
            this.gTx = jSONObject.optInt("user_exp");
            this.gTy = jSONObject.optInt("need_exp");
            if (this.gTw != 0) {
                this.gTz = true;
                this.gTB = false;
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
