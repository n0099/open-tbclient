package com.baidu.tieba.signall;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements ae {
    private String avatar;
    private String errorMsg;
    private int esl;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int jZU;
    private int jZV;
    private int jZW;
    private int jZX;
    private boolean jZY;
    private boolean jZZ;
    private boolean kaa;
    private int kab;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int cJd() {
        return this.jZU;
    }

    public int cJe() {
        return this.esl;
    }

    public int cJf() {
        return this.jZV;
    }

    public int cJg() {
        return this.jZW;
    }

    public int cJh() {
        return this.jZX;
    }

    public void Cm(int i) {
        this.jZU = i;
    }

    public void Cn(int i) {
        this.esl = i;
    }

    public void Co(int i) {
        this.jZV = i;
    }

    public boolean bdm() {
        return this.isSigned;
    }

    public void sF(boolean z) {
        this.isSigned = z;
        this.jZU = 1;
    }

    public boolean cJi() {
        return this.jZZ;
    }

    public void sG(boolean z) {
        this.jZZ = z;
        this.jZU = 0;
    }

    public boolean cJj() {
        return this.kaa;
    }

    public void sH(boolean z) {
        this.kaa = z;
    }

    public int cJk() {
        return this.kab;
    }

    public void Cp(int i) {
        this.kab = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean cJl() {
        return this.jZY;
    }

    public void sI(boolean z) {
        this.jZY = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.jZU = jSONObject.optInt("is_sign_in");
            this.esl = jSONObject.optInt("cont_sign_num");
            this.jZV = jSONObject.optInt("user_level");
            this.jZW = jSONObject.optInt("user_exp");
            this.jZX = jSONObject.optInt("need_exp");
            if (this.jZU != 0) {
                this.isSigned = true;
                this.jZZ = false;
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
