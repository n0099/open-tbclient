package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dtX;
    private int eOK;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iXG;
    private int iXH;
    private int iXI;
    private boolean iXJ;
    private boolean iXK;
    private boolean iXL;
    private boolean iXM;
    private int iXN;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cnl() {
        return this.iXG;
    }

    public int cnm() {
        return this.dtX;
    }

    public int cnn() {
        return this.eOK;
    }

    public int cno() {
        return this.iXH;
    }

    public int cnp() {
        return this.iXI;
    }

    public void AM(int i) {
        this.iXG = i;
    }

    public void AN(int i) {
        this.dtX = i;
    }

    public void AO(int i) {
        this.eOK = i;
    }

    public boolean aJZ() {
        return this.iXJ;
    }

    public void qP(boolean z) {
        this.iXJ = z;
        this.iXG = 1;
    }

    public boolean cnq() {
        return this.iXL;
    }

    public void qQ(boolean z) {
        this.iXL = z;
        this.iXG = 0;
    }

    public boolean cnr() {
        return this.iXM;
    }

    public void qR(boolean z) {
        this.iXM = z;
    }

    public int cns() {
        return this.iXN;
    }

    public void AP(int i) {
        this.iXN = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cnt() {
        return this.iXK;
    }

    public void qS(boolean z) {
        this.iXK = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.iXG = jSONObject.optInt("is_sign_in");
            this.dtX = jSONObject.optInt("cont_sign_num");
            this.eOK = jSONObject.optInt("user_level");
            this.iXH = jSONObject.optInt("user_exp");
            this.iXI = jSONObject.optInt("need_exp");
            if (this.iXG != 0) {
                this.iXJ = true;
                this.iXL = false;
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
