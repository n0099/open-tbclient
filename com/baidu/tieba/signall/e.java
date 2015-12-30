package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements aj {
    private String avatar;
    private int bui;
    private int dxd;
    private int dxe;
    private int dxf;
    private int dxg;
    private boolean dxh;
    private boolean dxi;
    private boolean dxj;
    private boolean dxk;
    private int dxl;
    private String errorMsg;
    private int forumId;
    private String forumName;

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int aBM() {
        return this.dxd;
    }

    public int aBN() {
        return this.dxe;
    }

    public int Sa() {
        return this.bui;
    }

    public int aBO() {
        return this.dxf;
    }

    public int aBP() {
        return this.dxg;
    }

    public void mC(int i) {
        this.dxd = i;
    }

    public void mD(int i) {
        this.dxe = i;
    }

    public void gO(int i) {
        this.bui = i;
    }

    public boolean aBQ() {
        return this.dxh;
    }

    public void hh(boolean z) {
        this.dxh = z;
        this.dxd = 1;
    }

    public boolean aBR() {
        return this.dxj;
    }

    public void hi(boolean z) {
        this.dxj = z;
        this.dxd = 0;
    }

    public boolean aBS() {
        return this.dxk;
    }

    public void hj(boolean z) {
        this.dxk = z;
    }

    public int aBT() {
        return this.dxl;
    }

    public void mE(int i) {
        this.dxl = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean aBU() {
        return this.dxi;
    }

    public void hk(boolean z) {
        this.dxi = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.dxd = jSONObject.optInt("is_sign_in");
            this.dxe = jSONObject.optInt("cont_sign_num");
            this.bui = jSONObject.optInt("user_level");
            this.dxf = jSONObject.optInt("user_exp");
            this.dxg = jSONObject.optInt("need_exp");
            if (this.dxd != 0) {
                this.dxh = true;
                this.dxj = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<ai> arrayList = new ArrayList<>();
        ai aiVar = new ai();
        aiVar.Xp = this.avatar;
        aiVar.abU = 10;
        arrayList.add(aiVar);
        return arrayList;
    }
}
