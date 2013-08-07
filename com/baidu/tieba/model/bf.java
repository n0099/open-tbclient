package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.c {
    private Context d;
    private com.baidu.tieba.data.bh e;

    /* renamed from: a  reason: collision with root package name */
    private String f1347a = null;
    private String b = null;
    private String c = null;
    private bg f = null;
    private bh g = null;

    public void a(Intent intent) {
        this.f1347a = intent.getStringExtra("thread_id");
        this.b = intent.getStringExtra("post_id");
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        this.f1347a = bundle.getString("thread_id");
        this.b = bundle.getString("post_id");
        this.c = bundle.getString("st_type");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.f1347a);
        bundle.putString("post_id", this.b);
        bundle.putString("st_type", this.c);
    }

    public bf(Context context) {
        this.d = null;
        this.e = null;
        this.d = context;
        this.e = new com.baidu.tieba.data.bh();
    }

    public void a(String str) {
        this.f1347a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void b() {
        this.e = new com.baidu.tieba.data.bh();
    }

    public com.baidu.tieba.data.bh c() {
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

    public void a(bh bhVar) {
        this.g = bhVar;
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
        if (this.f1347a == null || this.b == null || this.f != null) {
            return false;
        }
        this.f = new bg(this, 0);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean f() {
        cancelLoadData();
        if (this.f1347a == null || this.b == null || this.e.k() || this.f != null) {
            return false;
        }
        this.f = new bg(this, 2);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean g() {
        cancelLoadData();
        this.f = new bg(this, 1);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }
}
