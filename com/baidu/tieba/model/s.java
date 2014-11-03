package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.e {
    private com.baidu.tieba.data.p ayk;
    private boolean boN;
    private t boO;
    private int boP;
    protected int mErrorCode;
    protected String mErrorString;
    private int status;

    public s(Context context) {
        super(context);
        this.boN = false;
        this.boP = 1;
        this.mErrorCode = 0;
        this.mErrorString = null;
        this.status = 0;
    }

    public boolean Ts() {
        return this.boN;
    }

    public void dF(boolean z) {
        this.boN = z;
    }

    public boolean isIdle() {
        return this.status == 0;
    }

    public boolean Tt() {
        ArrayList<com.baidu.tieba.data.q> yX;
        return (this.ayk == null || (yX = this.ayk.yX()) == null || yX.size() < 300) ? false : true;
    }

    public boolean hasMore() {
        return this.ayk != null && (this.ayk.hasMore() || Ts());
    }

    public boolean Tu() {
        ArrayList<com.baidu.tieba.data.q> yX;
        return (this.ayk == null || (yX = this.ayk.yX()) == null || yX.size() <= 0) ? false : true;
    }

    public boolean tZ() {
        return !Tt() && hasMore();
    }

    public void gD(int i) {
        this.boP = i;
        this.boO = new t(this);
        this.boO.execute(Integer.valueOf((i != 2 || Ts()) ? 1 : KT()));
        this.status = 1;
    }

    public void Tv() {
        if (this.boO == null) {
            this.boO = new t(this);
        }
        this.boO.execute(1, 1);
        this.status = 1;
    }

    public com.baidu.tieba.data.p Tw() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            return null;
        }
        com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_pages");
        String str = bd != null ? bd.get("home_forumfeed_" + currentAccount) : null;
        if (str != null) {
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.parserJson(str);
            this.ayk = pVar;
            return pVar;
        }
        return null;
    }

    public int Tx() {
        return this.boP;
    }

    private int KT() {
        ArrayList<com.baidu.tieba.data.q> yX;
        if (this.ayk == null || (yX = this.ayk.yX()) == null) {
            return 1;
        }
        return (yX.size() / 20) + 1;
    }

    @Override // com.baidu.adp.base.e
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.baidu.adp.base.e
    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    @Override // com.baidu.adp.base.e
    public String getErrorString() {
        return this.mErrorString;
    }

    @Override // com.baidu.adp.base.e
    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public com.baidu.tieba.data.p Ty() {
        return this.ayk;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.boO != null) {
            this.boO.cancel();
            return true;
        }
        return true;
    }
}
