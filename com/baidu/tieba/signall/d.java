package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dtQ;
    private int eOD;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iWC;
    private int iWD;
    private int iWE;
    private boolean iWF;
    private boolean iWG;
    private boolean iWH;
    private boolean iWI;
    private int iWJ;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cmT() {
        return this.iWC;
    }

    public int cmU() {
        return this.dtQ;
    }

    public int cmV() {
        return this.eOD;
    }

    public int cmW() {
        return this.iWD;
    }

    public int cmX() {
        return this.iWE;
    }

    public void AK(int i) {
        this.iWC = i;
    }

    public void AL(int i) {
        this.dtQ = i;
    }

    public void AM(int i) {
        this.eOD = i;
    }

    public boolean aJX() {
        return this.iWF;
    }

    public void qO(boolean z) {
        this.iWF = z;
        this.iWC = 1;
    }

    public boolean cmY() {
        return this.iWH;
    }

    public void qP(boolean z) {
        this.iWH = z;
        this.iWC = 0;
    }

    public boolean cmZ() {
        return this.iWI;
    }

    public void qQ(boolean z) {
        this.iWI = z;
    }

    public int cna() {
        return this.iWJ;
    }

    public void AN(int i) {
        this.iWJ = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cnb() {
        return this.iWG;
    }

    public void qR(boolean z) {
        this.iWG = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.iWC = jSONObject.optInt("is_sign_in");
            this.dtQ = jSONObject.optInt("cont_sign_num");
            this.eOD = jSONObject.optInt("user_level");
            this.iWD = jSONObject.optInt("user_exp");
            this.iWE = jSONObject.optInt("need_exp");
            if (this.iWC != 0) {
                this.iWF = true;
                this.iWH = false;
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
