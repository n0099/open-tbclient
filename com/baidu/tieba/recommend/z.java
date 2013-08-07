package com.baidu.tieba.recommend;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1681a;
    private aa b = null;

    public z(Context context) {
        this.f1681a = context;
    }

    public void a() {
        if (!TiebaApplication.f().ba()) {
            if (this.b != null) {
                this.b.cancel();
            }
            this.b = new aa(this, null);
            this.b.execute(new String[0]);
        }
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
            return false;
        }
        return false;
    }
}
