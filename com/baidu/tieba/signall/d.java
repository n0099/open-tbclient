package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int cdD;
    private int diN;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gRK;
    private int gRL;
    private int gRM;
    private boolean gRN;
    private boolean gRO;
    private boolean gRP;
    private boolean gRQ;
    private int gRR;

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
        return this.gRK;
    }

    public int btp() {
        return this.cdD;
    }

    public int btq() {
        return this.diN;
    }

    public int btr() {
        return this.gRL;
    }

    public int bts() {
        return this.gRM;
    }

    public void vn(int i) {
        this.gRK = i;
    }

    public void vo(int i) {
        this.cdD = i;
    }

    public void vp(int i) {
        this.diN = i;
    }

    public boolean XA() {
        return this.gRN;
    }

    public void mz(boolean z) {
        this.gRN = z;
        this.gRK = 1;
    }

    public boolean btt() {
        return this.gRP;
    }

    public void mA(boolean z) {
        this.gRP = z;
        this.gRK = 0;
    }

    public boolean btu() {
        return this.gRQ;
    }

    public void mB(boolean z) {
        this.gRQ = z;
    }

    public int btv() {
        return this.gRR;
    }

    public void vq(int i) {
        this.gRR = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean btw() {
        return this.gRO;
    }

    public void mC(boolean z) {
        this.gRO = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gRK = jSONObject.optInt("is_sign_in");
            this.cdD = jSONObject.optInt("cont_sign_num");
            this.diN = jSONObject.optInt("user_level");
            this.gRL = jSONObject.optInt("user_exp");
            this.gRM = jSONObject.optInt("need_exp");
            if (this.gRK != 0) {
                this.gRN = true;
                this.gRP = false;
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
