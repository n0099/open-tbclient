package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private int eVM;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int kJl;
    private int kJm;
    private int kJn;
    private int kJo;
    private boolean kJp;
    private boolean kJq;
    private boolean kJr;
    private int kJs;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cTE() {
        return this.kJl;
    }

    public int cTF() {
        return this.eVM;
    }

    public int cTG() {
        return this.kJm;
    }

    public int cTH() {
        return this.kJn;
    }

    public int cTI() {
        return this.kJo;
    }

    public void CM(int i) {
        this.kJl = i;
    }

    public void CN(int i) {
        this.eVM = i;
    }

    public void CO(int i) {
        this.kJm = i;
    }

    public boolean bmb() {
        return this.isSigned;
    }

    public void tG(boolean z) {
        this.isSigned = z;
        this.kJl = 1;
    }

    public boolean cTJ() {
        return this.kJq;
    }

    public void tH(boolean z) {
        this.kJq = z;
        this.kJl = 0;
    }

    public boolean cTK() {
        return this.kJr;
    }

    public void tI(boolean z) {
        this.kJr = z;
    }

    public int cTL() {
        return this.kJs;
    }

    public void CP(int i) {
        this.kJs = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cTM() {
        return this.kJp;
    }

    public void tJ(boolean z) {
        this.kJp = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.kJl = jSONObject.optInt("is_sign_in");
            this.eVM = jSONObject.optInt("cont_sign_num");
            this.kJm = jSONObject.optInt("user_level");
            this.kJn = jSONObject.optInt("user_exp");
            this.kJo = jSONObject.optInt("need_exp");
            if (this.kJl != 0) {
                this.isSigned = true;
                this.kJq = false;
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
