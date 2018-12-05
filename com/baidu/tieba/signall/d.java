package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bQW;
    private int dgT;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int hbO;
    private int hbP;
    private int hbQ;
    private boolean hbR;
    private boolean hbS;
    private boolean hbT;
    private boolean hbU;
    private int hbV;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bzJ() {
        return this.hbO;
    }

    public int bzK() {
        return this.bQW;
    }

    public int bzL() {
        return this.dgT;
    }

    public int bzM() {
        return this.hbP;
    }

    public int bzN() {
        return this.hbQ;
    }

    public void uU(int i) {
        this.hbO = i;
    }

    public void uV(int i) {
        this.bQW = i;
    }

    public void uW(int i) {
        this.dgT = i;
    }

    public boolean aaL() {
        return this.hbR;
    }

    public void nf(boolean z) {
        this.hbR = z;
        this.hbO = 1;
    }

    public boolean bzO() {
        return this.hbT;
    }

    public void ng(boolean z) {
        this.hbT = z;
        this.hbO = 0;
    }

    public boolean bzP() {
        return this.hbU;
    }

    public void nh(boolean z) {
        this.hbU = z;
    }

    public int bzQ() {
        return this.hbV;
    }

    public void uX(int i) {
        this.hbV = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bzR() {
        return this.hbS;
    }

    public void ni(boolean z) {
        this.hbS = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.hbO = jSONObject.optInt("is_sign_in");
            this.bQW = jSONObject.optInt("cont_sign_num");
            this.dgT = jSONObject.optInt("user_level");
            this.hbP = jSONObject.optInt("user_exp");
            this.hbQ = jSONObject.optInt("need_exp");
            if (this.hbO != 0) {
                this.hbR = true;
                this.hbT = false;
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
