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
    private int fiH;
    private int forumId;
    private String forumName;
    private boolean isSigned;
    private int lcK;
    private int lcL;
    private int lcM;
    private int lcN;
    private boolean lcO;
    private boolean lcP;
    private boolean lcQ;
    private int lcR;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int daY() {
        return this.lcK;
    }

    public int daZ() {
        return this.fiH;
    }

    public int dba() {
        return this.lcL;
    }

    public int dbb() {
        return this.lcM;
    }

    public int dbc() {
        return this.lcN;
    }

    public void Dy(int i) {
        this.lcK = i;
    }

    public void Dz(int i) {
        this.fiH = i;
    }

    public void DA(int i) {
        this.lcL = i;
    }

    public boolean brB() {
        return this.isSigned;
    }

    public void ue(boolean z) {
        this.isSigned = z;
        this.lcK = 1;
    }

    public boolean dbd() {
        return this.lcP;
    }

    public void uf(boolean z) {
        this.lcP = z;
        this.lcK = 0;
    }

    public boolean dbe() {
        return this.lcQ;
    }

    public void ug(boolean z) {
        this.lcQ = z;
    }

    public int dbf() {
        return this.lcR;
    }

    public void DB(int i) {
        this.lcR = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean dbg() {
        return this.lcO;
    }

    public void uh(boolean z) {
        this.lcO = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.lcK = jSONObject.optInt("is_sign_in");
            this.fiH = jSONObject.optInt("cont_sign_num");
            this.lcL = jSONObject.optInt("user_level");
            this.lcM = jSONObject.optInt("user_exp");
            this.lcN = jSONObject.optInt("need_exp");
            if (this.lcK != 0) {
                this.isSigned = true;
                this.lcP = false;
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
