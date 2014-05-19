package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.d {
    private Context d;
    private ak a = null;
    private al b = null;
    private am c = null;
    private BaseActivity.LoadDataCallBack e = null;

    public aj(Context context) {
        this.d = null;
        this.d = context;
    }

    public void a() {
        if (this.a == null) {
            this.a = new ak(this, null);
            this.a.execute(new String[0]);
        }
    }

    public void b() {
        if (this.b == null) {
            this.b = new al(this, null);
            this.b.execute(new String[0]);
        }
    }

    public void c() {
        if (this.c == null) {
            this.c = new am(this, null);
            this.c.execute(new String[0]);
        }
    }

    public void a(boolean z) {
        TbadkApplication.m252getInst().setHeadsetModeOn(z);
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.e = loadDataCallBack;
    }
}
