package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int cdM;
    private int diW;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gRJ;
    private int gRK;
    private int gRL;
    private boolean gRM;
    private boolean gRN;
    private boolean gRO;
    private boolean gRP;
    private int gRQ;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bto() {
        return this.gRJ;
    }

    public int btp() {
        return this.cdM;
    }

    public int btq() {
        return this.diW;
    }

    public int btr() {
        return this.gRK;
    }

    public int bts() {
        return this.gRL;
    }

    public void vm(int i) {
        this.gRJ = i;
    }

    public void vn(int i) {
        this.cdM = i;
    }

    public void vo(int i) {
        this.diW = i;
    }

    public boolean XA() {
        return this.gRM;
    }

    public void mu(boolean z) {
        this.gRM = z;
        this.gRJ = 1;
    }

    public boolean btt() {
        return this.gRO;
    }

    public void mv(boolean z) {
        this.gRO = z;
        this.gRJ = 0;
    }

    public boolean btu() {
        return this.gRP;
    }

    public void mw(boolean z) {
        this.gRP = z;
    }

    public int btv() {
        return this.gRQ;
    }

    public void vp(int i) {
        this.gRQ = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean btw() {
        return this.gRN;
    }

    public void mx(boolean z) {
        this.gRN = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gRJ = jSONObject.optInt("is_sign_in");
            this.cdM = jSONObject.optInt("cont_sign_num");
            this.diW = jSONObject.optInt("user_level");
            this.gRK = jSONObject.optInt("user_exp");
            this.gRL = jSONObject.optInt("need_exp");
            if (this.gRJ != 0) {
                this.gRM = true;
                this.gRO = false;
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
