package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.data.an;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.e {
    protected Context e;
    protected an f;
    protected int a = 0;
    protected String b = null;
    protected String c = null;
    protected String d = null;
    protected g g = null;
    protected h h = null;
    protected aa i = null;

    public final void a(Intent intent) {
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getStringExtra("post_id");
        this.d = intent.getStringExtra("st_type");
    }

    public final void a(Bundle bundle) {
        this.b = bundle.getString("thread_id");
        this.c = bundle.getString("post_id");
        this.d = bundle.getString("st_type");
    }

    public final void b(Bundle bundle) {
        bundle.putString("thread_id", this.b);
        bundle.putString("post_id", this.c);
        bundle.putString("st_type", this.d);
    }

    public f(Context context) {
        this.e = null;
        this.f = null;
        this.e = context;
        this.f = new an();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final void d() {
        this.f = new an();
    }

    public final an e() {
        return this.f;
    }

    public final WriteData f() {
        if (this.f == null || this.f.g() == null || this.f.l() == null || this.f.a() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.f.g().getName());
        writeData.setForumId(this.f.g().getId());
        writeData.setFloor(this.f.a().d());
        writeData.setType(2);
        writeData.setThreadId(this.f.l().l());
        writeData.setFloorNum(0);
        return writeData;
    }

    public final void a(h hVar) {
        this.h = hVar;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    public final int g() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.g != null) {
            this.g.cancel();
            return true;
        }
        return true;
    }

    public final boolean h() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.g != null) {
            return false;
        }
        this.a = 0;
        a(0);
        return true;
    }

    public final boolean i() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.f.k() || this.g != null) {
            return false;
        }
        this.a = 2;
        a(2);
        return true;
    }

    public final boolean j() {
        cancelLoadData();
        this.a = 1;
        a(1);
        return true;
    }

    public final boolean k() {
        cancelLoadData();
        this.a = 3;
        a(3);
        return true;
    }

    private void a(int i) {
        this.g = new g(this, i);
        this.g.setPriority(3);
        this.g.execute(new Object[0]);
    }
}
