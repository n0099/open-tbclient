package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private az f1974a = null;
    private ba b = null;

    public void a() {
        if (this.f1974a == null) {
            this.f1974a = new az(this);
            this.f1974a.execute(new String[0]);
        }
    }

    public void b() {
        if (this.b == null) {
            this.b = new ba(this);
            this.b.execute(new String[0]);
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
}
