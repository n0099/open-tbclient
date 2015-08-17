package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements ad {
    private String avatar;
    private int cAf;
    private int cAg;
    private int cAh;
    private int cAi;
    private int cAj;
    private boolean cAk;
    private boolean cAl;
    private boolean cAm;
    private boolean cAn;
    private int cAo;
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

    public int amY() {
        return this.cAf;
    }

    public int amZ() {
        return this.cAg;
    }

    public int ana() {
        return this.cAh;
    }

    public int anb() {
        return this.cAi;
    }

    public int anc() {
        return this.cAj;
    }

    public void js(int i) {
        this.cAf = i;
    }

    public void jt(int i) {
        this.cAg = i;
    }

    public void ju(int i) {
        this.cAh = i;
    }

    public boolean and() {
        return this.cAk;
    }

    public void fk(boolean z) {
        this.cAk = z;
        this.cAf = 1;
    }

    public boolean ane() {
        return this.cAm;
    }

    public void fl(boolean z) {
        this.cAm = z;
        this.cAf = 0;
    }

    public boolean anf() {
        return this.cAn;
    }

    public void fm(boolean z) {
        this.cAn = z;
    }

    public int ang() {
        return this.cAo;
    }

    public void jv(int i) {
        this.cAo = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public boolean anh() {
        return this.cAl;
    }

    public void fn(boolean z) {
        this.cAl = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = jSONObject.optInt("forum_id");
            this.forumName = jSONObject.optString("forum_name");
            this.avatar = jSONObject.optString("avatar");
            this.cAf = jSONObject.optInt("is_sign_in");
            this.cAg = jSONObject.optInt("cont_sign_num");
            this.cAh = jSONObject.optInt("user_level");
            this.cAi = jSONObject.optInt("user_exp");
            this.cAj = jSONObject.optInt("need_exp");
            if (this.cAf != 0) {
                this.cAk = true;
                this.cAm = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<ac> getImages() {
        ArrayList<ac> arrayList = new ArrayList<>();
        ac acVar = new ac();
        acVar.VY = this.avatar;
        acVar.aau = 10;
        arrayList.add(acVar);
        return arrayList;
    }
}
