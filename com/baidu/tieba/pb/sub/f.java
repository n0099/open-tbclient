package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.data.at;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e {
    protected Context e;
    protected at f;
    protected int a = 0;
    protected String b = null;
    protected String c = null;
    protected String d = null;
    protected g g = null;
    protected h h = null;
    protected aa i = null;
    private com.baidu.tieba.b.a j = null;

    public void a(Intent intent) {
        this.b = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    public void a(Bundle bundle) {
        this.b = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.d = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    public void b(Bundle bundle) {
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.b);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_ID, this.c);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.d);
    }

    public f(Context context) {
        this.e = null;
        this.f = null;
        this.e = context;
        this.f = new at();
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void d() {
        this.f = new at();
    }

    public at e() {
        return this.f;
    }

    public WriteData f() {
        if (this.f == null || this.f.h() == null || this.f.m() == null || this.f.a() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.f.h().getName());
        writeData.setForumId(this.f.h().getId());
        writeData.setFloor(this.f.a().l());
        writeData.setType(2);
        writeData.setThreadId(this.f.m().p());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(h hVar) {
        this.h = hVar;
    }

    public void g() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.j != null) {
            this.j.b();
            this.j = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int h() {
        return this.a;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.g != null) {
            this.g.cancel();
            return true;
        }
        return true;
    }

    public boolean i() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.g != null) {
            return false;
        }
        this.a = 0;
        a(0);
        return true;
    }

    public boolean j() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.f.l() || this.g != null) {
            return false;
        }
        this.a = 2;
        a(2);
        return true;
    }

    public boolean k() {
        cancelLoadData();
        this.a = 1;
        a(1);
        return true;
    }

    public boolean l() {
        cancelLoadData();
        this.a = 3;
        a(3);
        return true;
    }

    protected void a(int i) {
        if (this.j == null) {
            this.j = new com.baidu.tieba.b.a("pbfloorStat");
            this.j.a();
        }
        this.g = new g(this, i);
        this.g.setPriority(3);
        this.g.execute(new Object[0]);
    }
}
