package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e {
    private w boH;
    private y boI;
    private aa boJ;

    public v(Context context) {
        super(context);
        this.boH = null;
        this.boI = null;
        this.boJ = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        Tw();
        return false;
    }

    public void Tw() {
        if (this.boH != null) {
            this.boH.cancel();
            this.boH = null;
        }
        if (this.boI != null) {
            this.boI.cancel();
            this.boI = null;
        }
        if (this.boJ != null) {
            this.boJ.cancel();
            this.boJ = null;
        }
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        if (this.boH != null) {
            this.boH.cancel();
            this.boH = null;
        }
        this.mLoadDataMode = 0;
        this.boH = new w(this, str, str2, str3, str4, i, i2, z);
        this.boH.setPriority(2);
        this.boH.execute(new String[0]);
    }

    public boolean Tx() {
        return (this.boH == null && this.boI == null && this.boJ == null) ? false : true;
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        String str5;
        if (this.boJ != null) {
            this.boJ.cancel();
            this.boJ = null;
        }
        this.mLoadDataMode = i;
        this.boJ = new aa(this, str, str2, str3, i, str4);
        this.boJ.setPriority(2);
        String str6 = TbConfig.SERVER_ADDRESS;
        if (i == 6) {
            str5 = String.valueOf(str6) + "c/c/bawu/goodlist";
        } else if (i == 2 || i == 3) {
            str5 = String.valueOf(str6) + "c/c/bawu/commitgood";
        } else {
            str5 = String.valueOf(str6) + "c/c/bawu/committop";
        }
        this.boJ.execute(str5);
    }
}
