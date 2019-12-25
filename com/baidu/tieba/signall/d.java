package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d implements ae {
    private String avatar;
    private int emq;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int jTA;
    private boolean jTB;
    private boolean jTC;
    private boolean jTD;
    private boolean jTE;
    private int jTF;
    private int jTx;
    private int jTy;
    private int jTz;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cFW() {
        return this.jTx;
    }

    public int cFX() {
        return this.emq;
    }

    public int cFY() {
        return this.jTy;
    }

    public int cFZ() {
        return this.jTz;
    }

    public int cGa() {
        return this.jTA;
    }

    public void BS(int i) {
        this.jTx = i;
    }

    public void BT(int i) {
        this.emq = i;
    }

    public void BU(int i) {
        this.jTy = i;
    }

    public boolean bau() {
        return this.jTB;
    }

    public void sj(boolean z) {
        this.jTB = z;
        this.jTx = 1;
    }

    public boolean cGb() {
        return this.jTD;
    }

    public void sk(boolean z) {
        this.jTD = z;
        this.jTx = 0;
    }

    public boolean cGc() {
        return this.jTE;
    }

    public void sl(boolean z) {
        this.jTE = z;
    }

    public int cGd() {
        return this.jTF;
    }

    public void BV(int i) {
        this.jTF = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cGe() {
        return this.jTC;
    }

    public void sm(boolean z) {
        this.jTC = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jTx = jSONObject.optInt("is_sign_in");
            this.emq = jSONObject.optInt("cont_sign_num");
            this.jTy = jSONObject.optInt("user_level");
            this.jTz = jSONObject.optInt("user_exp");
            this.jTA = jSONObject.optInt("need_exp");
            if (this.jTx != 0) {
                this.jTB = true;
                this.jTD = false;
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
