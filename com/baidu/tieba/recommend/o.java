package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.aj;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e {
    public static String ST_TYPE = "st_type";
    private q bIh;
    private com.baidu.tieba.data.l bIi;
    private p bIj;
    private p bIk;
    private boolean bIl;
    private String stType;

    public o(Context context) {
        super(context);
        this.stType = null;
        this.bIi = new com.baidu.tieba.data.l();
    }

    public void initWithIntent(Intent intent) {
        this.stType = intent.getStringExtra(ST_TYPE);
    }

    public void initWithBundle(Bundle bundle) {
        this.stType = bundle.getString(ST_TYPE);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return true;
    }

    public void yh() {
        if (this.bIj != null) {
            this.bIj.cancel(true);
            this.bIj = null;
        }
        this.bIj = new p(this, 0, "");
        this.bIj.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bIj != null) {
            this.bIj.cancel(true);
            this.bIj = null;
        }
        if (this.bIk != null) {
            this.bIk.cancel(true);
            this.bIk = null;
        }
        return true;
    }

    public void abK() {
        if (this.bIk != null) {
            this.bIk.cancel(true);
            this.bIk = null;
        }
        this.bIk = new p(this, 1, "");
        this.bIk.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(String str) {
        com.baidu.adp.lib.cache.t<String> wO = aj.wk().wO();
        if (wO != null) {
            wO.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void hm(String str) {
        if (this.bIj != null) {
            this.bIj.cancel(true);
            this.bIj = null;
        }
        this.bIj = new p(this, 2, str);
        this.bIj.execute(new String[0]);
    }

    public void a(q qVar) {
        this.bIh = qVar;
    }
}
