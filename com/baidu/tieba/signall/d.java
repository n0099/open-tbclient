package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d implements ag {
    private String avatar;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gIP;
    private boolean isSigned;
    private int nim;
    private int nin;
    private int nio;
    private boolean nip;
    private boolean niq;
    private boolean nir;
    private int nis;
    private int userLevel;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int dMn() {
        return this.nim;
    }

    public int dMo() {
        return this.gIP;
    }

    public int bNU() {
        return this.userLevel;
    }

    public int dMp() {
        return this.nin;
    }

    public int dMq() {
        return this.nio;
    }

    public void Kw(int i) {
        this.nim = i;
    }

    public void Kx(int i) {
        this.gIP = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bVu() {
        return this.isSigned;
    }

    public void xN(boolean z) {
        this.isSigned = z;
        this.nim = 1;
    }

    public boolean dMr() {
        return this.niq;
    }

    public void xO(boolean z) {
        this.niq = z;
        this.nim = 0;
    }

    public boolean dMs() {
        return this.nir;
    }

    public void xP(boolean z) {
        this.nir = z;
    }

    public int dMt() {
        return this.nis;
    }

    public void Ky(int i) {
        this.nis = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dMu() {
        return this.nip;
    }

    public void xQ(boolean z) {
        this.nip = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.nim = jSONObject.optInt("is_sign_in");
            this.gIP = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.nin = jSONObject.optInt("user_exp");
            this.nio = jSONObject.optInt("need_exp");
            if (this.nim != 0) {
                this.isSigned = true;
                this.niq = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.avatar;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
