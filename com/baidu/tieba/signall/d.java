package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ae {
    private String avatar;
    private int bDP;
    private int cQM;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gLY;
    private int gLZ;
    private int gMa;
    private boolean gMb;
    private boolean gMc;
    private boolean gMd;
    private boolean gMe;
    private int gMf;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bve() {
        return this.gLY;
    }

    public int bvf() {
        return this.bDP;
    }

    public int bvg() {
        return this.cQM;
    }

    public int bvh() {
        return this.gLZ;
    }

    public int bvi() {
        return this.gMa;
    }

    public void tI(int i) {
        this.gLY = i;
    }

    public void tJ(int i) {
        this.bDP = i;
    }

    public void tK(int i) {
        this.cQM = i;
    }

    public boolean VN() {
        return this.gMb;
    }

    public void mA(boolean z) {
        this.gMb = z;
        this.gLY = 1;
    }

    public boolean bvj() {
        return this.gMd;
    }

    public void mB(boolean z) {
        this.gMd = z;
        this.gLY = 0;
    }

    public boolean bvk() {
        return this.gMe;
    }

    public void mC(boolean z) {
        this.gMe = z;
    }

    public int bvl() {
        return this.gMf;
    }

    public void tL(int i) {
        this.gMf = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bvm() {
        return this.gMc;
    }

    public void mD(boolean z) {
        this.gMc = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gLY = jSONObject.optInt("is_sign_in");
            this.bDP = jSONObject.optInt("cont_sign_num");
            this.cQM = jSONObject.optInt("user_level");
            this.gLZ = jSONObject.optInt("user_exp");
            this.gMa = jSONObject.optInt("need_exp");
            if (this.gLY != 0) {
                this.gMb = true;
                this.gMd = false;
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
