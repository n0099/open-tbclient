package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements af {
    private String avatar;
    private int bxt;
    private int cIq;
    private String errorMsg;
    private int forumId;
    private String forumName;
    private int gDk;
    private int gDl;
    private int gDm;
    private boolean gDn;
    private boolean gDo;
    private boolean gDp;
    private boolean gDq;
    private int gDr;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int btV() {
        return this.gDk;
    }

    public int btW() {
        return this.bxt;
    }

    public int btX() {
        return this.cIq;
    }

    public int btY() {
        return this.gDl;
    }

    public int btZ() {
        return this.gDm;
    }

    public void tk(int i) {
        this.gDk = i;
    }

    public void tl(int i) {
        this.bxt = i;
    }

    public void tm(int i) {
        this.cIq = i;
    }

    public boolean TP() {
        return this.gDn;
    }

    public void ms(boolean z) {
        this.gDn = z;
        this.gDk = 1;
    }

    public boolean bua() {
        return this.gDp;
    }

    public void mt(boolean z) {
        this.gDp = z;
        this.gDk = 0;
    }

    public boolean bub() {
        return this.gDq;
    }

    public void mu(boolean z) {
        this.gDq = z;
    }

    public int buc() {
        return this.gDr;
    }

    public void tn(int i) {
        this.gDr = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean bud() {
        return this.gDo;
    }

    public void mv(boolean z) {
        this.gDo = z;
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.gDk = jSONObject.optInt("is_sign_in");
            this.bxt = jSONObject.optInt("cont_sign_num");
            this.cIq = jSONObject.optInt("user_level");
            this.gDl = jSONObject.optInt("user_exp");
            this.gDm = jSONObject.optInt("need_exp");
            if (this.gDk != 0) {
                this.gDn = true;
                this.gDp = false;
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
