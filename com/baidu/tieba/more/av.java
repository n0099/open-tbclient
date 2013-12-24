package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.d {
    private ax a = null;
    private ay b = null;

    public void a() {
        if (this.a == null) {
            this.a = new ax(this);
            this.a.execute(new String[0]);
        }
    }

    public void b() {
        if (this.b == null) {
            this.b = new ay(this);
            this.b.execute(new String[0]);
        }
    }

    public void a(boolean z) {
        TiebaApplication.h().s(z);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
