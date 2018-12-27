package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bQZ;
    private int djJ;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int heS;
    private int heT;
    private int heU;
    private boolean heV;
    private boolean heW;
    private boolean heX;
    private boolean heY;
    private int heZ;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bAy() {
        return this.heS;
    }

    public int bAz() {
        return this.bQZ;
    }

    public int bAA() {
        return this.djJ;
    }

    public int bAB() {
        return this.heT;
    }

    public int bAC() {
        return this.heU;
    }

    public void vh(int i) {
        this.heS = i;
    }

    public void vi(int i) {
        this.bQZ = i;
    }

    public void vj(int i) {
        this.djJ = i;
    }

    public boolean aaN() {
        return this.heV;
    }

    public void ni(boolean z) {
        this.heV = z;
        this.heS = 1;
    }

    public boolean bAD() {
        return this.heX;
    }

    public void nj(boolean z) {
        this.heX = z;
        this.heS = 0;
    }

    public boolean bAE() {
        return this.heY;
    }

    public void nk(boolean z) {
        this.heY = z;
    }

    public int bAF() {
        return this.heZ;
    }

    public void vk(int i) {
        this.heZ = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bAG() {
        return this.heW;
    }

    public void nl(boolean z) {
        this.heW = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.heS = jSONObject.optInt("is_sign_in");
            this.bQZ = jSONObject.optInt("cont_sign_num");
            this.djJ = jSONObject.optInt("user_level");
            this.heT = jSONObject.optInt("user_exp");
            this.heU = jSONObject.optInt("need_exp");
            if (this.heS != 0) {
                this.heV = true;
                this.heX = false;
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
