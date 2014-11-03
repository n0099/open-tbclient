package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e {
    private w boV;
    private y boW;
    private aa boX;

    public v(Context context) {
        super(context);
        this.boV = null;
        this.boW = null;
        this.boX = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        Tz();
        return false;
    }

    public void Tz() {
        if (this.boV != null) {
            this.boV.cancel();
            this.boV = null;
        }
        if (this.boW != null) {
            this.boW.cancel();
            this.boW = null;
        }
        if (this.boX != null) {
            this.boX.cancel();
            this.boX = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.boV != null) {
            this.boV.cancel();
            this.boV = null;
        }
        this.mLoadDataMode = 0;
        this.boV = new w(this, str, str2, str3, str4, i, i2, z);
        this.boV.setPriority(2);
        this.boV.execute(new String[0]);
    }

    public boolean TA() {
        return (this.boV == null && this.boW == null && this.boX == null) ? false : true;
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.boX != null) {
            this.boX.cancel();
            this.boX = null;
        }
        this.mLoadDataMode = i;
        this.boX = new aa(this, str, str2, str3, i, str4);
        this.boX.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + "c/c/bawu/goodlist";
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + "c/c/bawu/commitgood";
        } else {
            str5 = String.valueOf(str6) + "c/c/bawu/committop";
        }
        this.boX.execute(str5);
    }
}
