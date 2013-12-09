package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private av f2082a = null;
    private aw b = null;

    public void a() {
        if (this.f2082a == null) {
            this.f2082a = new av(this);
            this.f2082a.execute(new String[0]);
        }
    }

    public void b() {
        if (this.b == null) {
            this.b = new aw(this);
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
