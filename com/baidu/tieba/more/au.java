package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.a.d {
    private Context d;
    private av a = null;
    private aw b = null;
    private ax c = null;
    private com.baidu.tieba.i e = null;

    public au(Context context) {
        this.d = null;
        this.d = context;
    }

    public void a() {
        if (this.a == null) {
            this.a = new av(this, null);
            this.a.execute(new String[0]);
        }
    }

    public void b() {
        if (this.b == null) {
            this.b = new aw(this, null);
            this.b.execute(new String[0]);
        }
    }

    public void c() {
        if (this.c == null) {
            this.c = new ax(this, null);
            this.c.execute(new String[0]);
        }
    }

    public void a(boolean z) {
        TiebaApplication.g().s(z);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(com.baidu.tieba.i iVar) {
        this.e = iVar;
    }
}
