package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.aj;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e {
    public static String ST_TYPE = "st_type";
    private q bIv;
    private com.baidu.tieba.data.l bIw;
    private p bIx;
    private p bIy;
    private boolean bIz;
    private String stType;

    public o(Context context) {
        super(context);
        this.stType = null;
        this.bIw = new com.baidu.tieba.data.l();
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

    public void yj() {
        if (this.bIx != null) {
            this.bIx.cancel(true);
            this.bIx = null;
        }
        this.bIx = new p(this, 0, "");
        this.bIx.execute(new String[0]);
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bIx != null) {
            this.bIx.cancel(true);
            this.bIx = null;
        }
        if (this.bIy != null) {
            this.bIy.cancel(true);
            this.bIy = null;
        }
        return true;
    }

    public void abN() {
        if (this.bIy != null) {
            this.bIy.cancel(true);
            this.bIy = null;
        }
        this.bIy = new p(this, 1, "");
        this.bIy.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(String str) {
        com.baidu.adp.lib.cache.t<String> wQ = aj.wm().wQ();
        if (wQ != null) {
            wQ.a("dailyrecommend", str, 2592000000L);
        }
    }

    public void hm(String str) {
        if (this.bIx != null) {
            this.bIx.cancel(true);
            this.bIx = null;
        }
        this.bIx = new p(this, 2, str);
        this.bIx.execute(new String[0]);
    }

    public void a(q qVar) {
        this.bIv = qVar;
    }
}
