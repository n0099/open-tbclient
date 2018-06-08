package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements af {
    private String avatar;
    private int bvX;
    private int cKw;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gzr;
    private int gzs;
    private int gzt;
    private boolean gzu;
    private boolean gzv;
    private boolean gzw;
    private boolean gzx;
    private int gzy;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int btv() {
        return this.gzr;
    }

    public int btw() {
        return this.bvX;
    }

    public int btx() {
        return this.cKw;
    }

    public int bty() {
        return this.gzs;
    }

    public int btz() {
        return this.gzt;
    }

    public void ta(int i) {
        this.gzr = i;
    }

    public void tb(int i) {
        this.bvX = i;
    }

    public void tc(int i) {
        this.cKw = i;
    }

    public boolean Tv() {
        return this.gzu;
    }

    public void mh(boolean z) {
        this.gzu = z;
        this.gzr = 1;
    }

    public boolean btA() {
        return this.gzw;
    }

    public void mi(boolean z) {
        this.gzw = z;
        this.gzr = 0;
    }

    public boolean btB() {
        return this.gzx;
    }

    public void mj(boolean z) {
        this.gzx = z;
    }

    public int btC() {
        return this.gzy;
    }

    public void td(int i) {
        this.gzy = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean btD() {
        return this.gzv;
    }

    public void mk(boolean z) {
        this.gzv = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gzr = jSONObject.optInt("is_sign_in");
            this.bvX = jSONObject.optInt("cont_sign_num");
            this.cKw = jSONObject.optInt("user_level");
            this.gzs = jSONObject.optInt("user_exp");
            this.gzt = jSONObject.optInt("need_exp");
            if (this.gzr != 0) {
                this.gzu = true;
                this.gzw = false;
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
