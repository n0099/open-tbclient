package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int cdA;
    private int diK;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean gRA;
    private int gRB;
    private int gRu;
    private int gRv;
    private int gRw;
    private boolean gRx;
    private boolean gRy;
    private boolean gRz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int btn() {
        return this.gRu;
    }

    public int bto() {
        return this.cdA;
    }

    public int btp() {
        return this.diK;
    }

    public int btq() {
        return this.gRv;
    }

    public int btr() {
        return this.gRw;
    }

    public void vn(int i) {
        this.gRu = i;
    }

    public void vo(int i) {
        this.cdA = i;
    }

    public void vp(int i) {
        this.diK = i;
    }

    public boolean Xz() {
        return this.gRx;
    }

    public void mu(boolean z) {
        this.gRx = z;
        this.gRu = 1;
    }

    public boolean bts() {
        return this.gRz;
    }

    public void mv(boolean z) {
        this.gRz = z;
        this.gRu = 0;
    }

    public boolean btt() {
        return this.gRA;
    }

    public void mw(boolean z) {
        this.gRA = z;
    }

    public int btu() {
        return this.gRB;
    }

    public void vq(int i) {
        this.gRB = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean btv() {
        return this.gRy;
    }

    public void mx(boolean z) {
        this.gRy = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gRu = jSONObject.optInt("is_sign_in");
            this.cdA = jSONObject.optInt("cont_sign_num");
            this.diK = jSONObject.optInt("user_level");
            this.gRv = jSONObject.optInt("user_exp");
            this.gRw = jSONObject.optInt("need_exp");
            if (this.gRu != 0) {
                this.gRx = true;
                this.gRz = false;
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
