package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.e {
    private com.baidu.tieba.data.p ayb;
    private t boA;
    private int boB;
    private boolean boz;
    protected int mErrorCode;
    protected String mErrorString;
    private int status;

    public s(Context context) {
        super(context);
        this.boz = false;
        this.boB = 1;
        this.mErrorCode = 0;
        this.mErrorString = null;
        this.status = 0;
    }

    public boolean Tp() {
        return this.boz;
    }

    public void dF(boolean z) {
        this.boz = z;
    }

    public boolean isIdle() {
        return this.status == 0;
    }

    public boolean Tq() {
        ArrayList<com.baidu.tieba.data.q> yV;
        return (this.ayb == null || (yV = this.ayb.yV()) == null || yV.size() < 300) ? false : true;
    }

    public boolean hasMore() {
        return this.ayb != null && (this.ayb.hasMore() || Tp());
    }

    public boolean Tr() {
        ArrayList<com.baidu.tieba.data.q> yV;
        return (this.ayb == null || (yV = this.ayb.yV()) == null || yV.size() <= 0) ? false : true;
    }

    public boolean tX() {
        return !Tq() && hasMore();
    }

    public void gD(int i) {
        this.boB = i;
        this.boA = new t(this);
        this.boA.execute(Integer.valueOf((i != 2 || Tp()) ? 1 : KP()));
        this.status = 1;
    }

    public void Ts() {
        if (this.boA == null) {
            this.boA = new t(this);
        }
        this.boA.execute(1, 1);
        this.status = 1;
    }

    public com.baidu.tieba.data.p Tt() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            return null;
        }
        com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_pages");
        String str = bd != null ? bd.get("home_forumfeed_" + currentAccount) : null;
        if (str != null) {
            com.baidu.tieba.data.p pVar = new com.baidu.tieba.data.p();
            pVar.parserJson(str);
            this.ayb = pVar;
            return pVar;
        }
        return null;
    }

    public int Tu() {
        return this.boB;
    }

    private int KP() {
        ArrayList<com.baidu.tieba.data.q> yV;
        if (this.ayb == null || (yV = this.ayb.yV()) == null) {
            return 1;
        }
        return (yV.size() / 20) + 1;
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

    public com.baidu.tieba.data.p Tv() {
        return this.ayb;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.boA != null) {
            this.boA.cancel();
            return true;
        }
        return true;
    }
}
