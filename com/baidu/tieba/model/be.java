package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.a.c {
    private Context d;
    private com.baidu.tieba.data.bd e;

    /* renamed from: a  reason: collision with root package name */
    private String f1381a = null;
    private String b = null;
    private String c = null;
    private bf f = null;
    private bg g = null;

    public void a(Intent intent) {
        this.f1381a = intent.getStringExtra("thread_id");
        this.b = intent.getStringExtra("post_id");
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        this.f1381a = bundle.getString("thread_id");
        this.b = bundle.getString("post_id");
        this.c = bundle.getString("st_type");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.f1381a);
        bundle.putString("post_id", this.b);
        bundle.putString("st_type", this.c);
    }

    public be(Context context) {
        this.d = null;
        this.e = null;
        this.d = context;
        this.e = new com.baidu.tieba.data.bd();
    }

    public void a(String str) {
        this.f1381a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void b() {
        this.e = new com.baidu.tieba.data.bd();
    }

    public com.baidu.tieba.data.bd c() {
        return this.e;
    }

    public WriteData d() {
        if (this.e == null || this.e.g() == null || this.e.l() == null || this.e.a() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.e.g().b());
        writeData.setForumId(this.e.g().a());
        writeData.setFloor(this.e.a().d());
        writeData.setType(2);
        writeData.setThreadId(this.e.l().a());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(bg bgVar) {
        this.g = bgVar;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f != null) {
            this.f.cancel();
            return true;
        }
        return true;
    }

    public boolean e() {
        cancelLoadData();
        if (this.f1381a == null || this.b == null || this.f != null) {
            return false;
        }
        this.f = new bf(this, 0);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean f() {
        cancelLoadData();
        if (this.f1381a == null || this.b == null || this.e.k() || this.f != null) {
            return false;
        }
        this.f = new bf(this, 2);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean g() {
        cancelLoadData();
        this.f = new bf(this, 1);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }
}
