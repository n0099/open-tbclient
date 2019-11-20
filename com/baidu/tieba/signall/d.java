package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements ae {
    private String avatar;
    private int dBs;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int iZb;
    private int iZc;
    private int iZd;
    private int iZe;
    private boolean iZf;
    private boolean iZg;
    private boolean iZh;
    private boolean iZi;
    private int iZj;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int clM() {
        return this.iZb;
    }

    public int clN() {
        return this.dBs;
    }

    public int clO() {
        return this.iZc;
    }

    public int clP() {
        return this.iZd;
    }

    public int clQ() {
        return this.iZe;
    }

    public void zw(int i) {
        this.iZb = i;
    }

    public void zx(int i) {
        this.dBs = i;
    }

    public void zy(int i) {
        this.iZc = i;
    }

    public boolean aJV() {
        return this.iZf;
    }

    public void qB(boolean z) {
        this.iZf = z;
        this.iZb = 1;
    }

    public boolean clR() {
        return this.iZh;
    }

    public void qC(boolean z) {
        this.iZh = z;
        this.iZb = 0;
    }

    public boolean clS() {
        return this.iZi;
    }

    public void qD(boolean z) {
        this.iZi = z;
    }

    public int clT() {
        return this.iZj;
    }

    public void zz(int i) {
        this.iZj = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean clU() {
        return this.iZg;
    }

    public void qE(boolean z) {
        this.iZg = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.iZb = jSONObject.optInt("is_sign_in");
            this.dBs = jSONObject.optInt("cont_sign_num");
            this.iZc = jSONObject.optInt("user_level");
            this.iZd = jSONObject.optInt("user_exp");
            this.iZe = jSONObject.optInt("need_exp");
            if (this.iZb != 0) {
                this.iZf = true;
                this.iZh = false;
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
