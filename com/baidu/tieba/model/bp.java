package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.a.d {
    protected Context e;
    protected com.baidu.tieba.data.av f;
    protected int a = 0;
    protected String b = null;
    protected String c = null;
    protected String d = null;
    protected bq g = null;
    protected br h = null;

    public void a(Intent intent) {
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getStringExtra("post_id");
        this.d = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        this.b = bundle.getString("thread_id");
        this.c = bundle.getString("post_id");
        this.d = bundle.getString("st_type");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.b);
        bundle.putString("post_id", this.c);
        bundle.putString("st_type", this.d);
    }

    public bp(Context context) {
        this.e = null;
        this.f = null;
        this.e = context;
        this.f = new com.baidu.tieba.data.av();
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
        this.f = new com.baidu.tieba.data.av();
    }

    public com.baidu.tieba.data.av e() {
        return this.f;
    }

    public WriteData f() {
        if (this.f == null || this.f.h() == null || this.f.m() == null || this.f.a() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.f.h().getName());
        writeData.setForumId(this.f.h().getId());
        writeData.setFloor(this.f.a().d());
        writeData.setType(2);
        writeData.setThreadId(this.f.m().a());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(br brVar) {
        this.h = brVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    public int g() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.g != null) {
            this.g.cancel();
            return true;
        }
        return true;
    }

    public boolean h() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.g != null) {
            return false;
        }
        this.a = 0;
        a(0);
        return true;
    }

    public boolean i() {
        cancelLoadData();
        if (this.b == null || this.c == null || this.f.l() || this.g != null) {
            return false;
        }
        this.a = 2;
        a(2);
        return true;
    }

    public boolean j() {
        cancelLoadData();
        this.a = 1;
        a(1);
        return true;
    }

    public boolean k() {
        cancelLoadData();
        this.a = 3;
        a(3);
        return true;
    }

    protected void a(int i) {
        this.g = new bq(this, i);
        this.g.setPriority(3);
        this.g.execute(new Object[0]);
    }
}
