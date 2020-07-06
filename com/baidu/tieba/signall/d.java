package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements af {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int ftU;
    private boolean isSigned;
    private int lwH;
    private int lwI;
    private int lwJ;
    private int lwK;
    private boolean lwL;
    private boolean lwM;
    private boolean lwN;
    private int lwO;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dfp() {
        return this.lwH;
    }

    public int dfq() {
        return this.ftU;
    }

    public int dfr() {
        return this.lwI;
    }

    public int dfs() {
        return this.lwJ;
    }

    public int dft() {
        return this.lwK;
    }

    public void EA(int i) {
        this.lwH = i;
    }

    public void EB(int i) {
        this.ftU = i;
    }

    public void EC(int i) {
        this.lwI = i;
    }

    public boolean buy() {
        return this.isSigned;
    }

    public void ut(boolean z) {
        this.isSigned = z;
        this.lwH = 1;
    }

    public boolean dfu() {
        return this.lwM;
    }

    public void uu(boolean z) {
        this.lwM = z;
        this.lwH = 0;
    }

    public boolean dfv() {
        return this.lwN;
    }

    public void uv(boolean z) {
        this.lwN = z;
    }

    public int dfw() {
        return this.lwO;
    }

    public void ED(int i) {
        this.lwO = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dfx() {
        return this.lwL;
    }

    public void uw(boolean z) {
        this.lwL = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lwH = jSONObject.optInt("is_sign_in");
            this.ftU = jSONObject.optInt("cont_sign_num");
            this.lwI = jSONObject.optInt("user_level");
            this.lwJ = jSONObject.optInt("user_exp");
            this.lwK = jSONObject.optInt("need_exp");
            if (this.lwH != 0) {
                this.isSigned = true;
                this.lwM = false;
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
