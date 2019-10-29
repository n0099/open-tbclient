package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dCj;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iZS;
    private int iZT;
    private int iZU;
    private int iZV;
    private boolean iZW;
    private boolean iZX;
    private boolean iZY;
    private boolean iZZ;
    private int jaa;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int clO() {
        return this.iZS;
    }

    public int clP() {
        return this.dCj;
    }

    public int clQ() {
        return this.iZT;
    }

    public int clR() {
        return this.iZU;
    }

    public int clS() {
        return this.iZV;
    }

    public void zx(int i) {
        this.iZS = i;
    }

    public void zy(int i) {
        this.dCj = i;
    }

    public void zz(int i) {
        this.iZT = i;
    }

    public boolean aJX() {
        return this.iZW;
    }

    public void qB(boolean z) {
        this.iZW = z;
        this.iZS = 1;
    }

    public boolean clT() {
        return this.iZY;
    }

    public void qC(boolean z) {
        this.iZY = z;
        this.iZS = 0;
    }

    public boolean clU() {
        return this.iZZ;
    }

    public void qD(boolean z) {
        this.iZZ = z;
    }

    public int clV() {
        return this.jaa;
    }

    public void zA(int i) {
        this.jaa = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean clW() {
        return this.iZX;
    }

    public void qE(boolean z) {
        this.iZX = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.iZS = jSONObject.optInt("is_sign_in");
            this.dCj = jSONObject.optInt("cont_sign_num");
            this.iZT = jSONObject.optInt("user_level");
            this.iZU = jSONObject.optInt("user_exp");
            this.iZV = jSONObject.optInt("need_exp");
            if (this.iZS != 0) {
                this.iZW = true;
                this.iZY = false;
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
