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
    private int nil;
    private int nim;
    private int nin;
    private boolean nio;
    private boolean nip;
    private boolean niq;
    private int nir;
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

    public int dMo() {
        return this.nil;
    }

    public int dMp() {
        return this.gIP;
    }

    public int bNV() {
        return this.userLevel;
    }

    public int dMq() {
        return this.nim;
    }

    public int dMr() {
        return this.nin;
    }

    public void Kw(int i) {
        this.nil = i;
    }

    public void Kx(int i) {
        this.gIP = i;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }

    public boolean bVv() {
        return this.isSigned;
    }

    public void xN(boolean z) {
        this.isSigned = z;
        this.nil = 1;
    }

    public boolean dMs() {
        return this.nip;
    }

    public void xO(boolean z) {
        this.nip = z;
        this.nil = 0;
    }

    public boolean dMt() {
        return this.niq;
    }

    public void xP(boolean z) {
        this.niq = z;
    }

    public int dMu() {
        return this.nir;
    }

    public void Ky(int i) {
        this.nir = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dMv() {
        return this.nio;
    }

    public void xQ(boolean z) {
        this.nio = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.nil = jSONObject.optInt("is_sign_in");
            this.gIP = jSONObject.optInt("cont_sign_num");
            this.userLevel = jSONObject.optInt(IntentConfig.USER_LEVEL);
            this.nim = jSONObject.optInt("user_exp");
            this.nin = jSONObject.optInt("need_exp");
            if (this.nil != 0) {
                this.isSigned = true;
                this.nip = false;
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
