package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.a.d {
    private Context d;
    private com.baidu.tieba.data.bb e;

    /* renamed from: a  reason: collision with root package name */
    private String f1921a = null;
    private String b = null;
    private String c = null;
    private bp f = null;
    private bq g = null;

    public void a(Intent intent) {
        this.f1921a = intent.getStringExtra("thread_id");
        this.b = intent.getStringExtra("post_id");
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        this.f1921a = bundle.getString("thread_id");
        this.b = bundle.getString("post_id");
        this.c = bundle.getString("st_type");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.f1921a);
        bundle.putString("post_id", this.b);
        bundle.putString("st_type", this.c);
    }

    public bo(Context context) {
        this.d = null;
        this.e = null;
        this.d = context;
        this.e = new com.baidu.tieba.data.bb();
    }

    public void a(String str) {
        this.f1921a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void b() {
        this.e = new com.baidu.tieba.data.bb();
    }

    public com.baidu.tieba.data.bb c() {
        return this.e;
    }

    public WriteData d() {
        if (this.e == null || this.e.g() == null || this.e.l() == null || this.e.a() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.e.g().getName());
        writeData.setForumId(this.e.g().getId());
        writeData.setFloor(this.e.a().d());
        writeData.setType(2);
        writeData.setThreadId(this.e.l().a());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(bq bqVar) {
        this.g = bqVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f != null) {
            this.f.cancel();
            return true;
        }
        return true;
    }

    public boolean e() {
        cancelLoadData();
        if (this.f1921a == null || this.b == null || this.f != null) {
            return false;
        }
        this.f = new bp(this, 0);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean f() {
        cancelLoadData();
        if (this.f1921a == null || this.b == null || this.e.k() || this.f != null) {
            return false;
        }
        this.f = new bp(this, 2);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }

    public boolean g() {
        cancelLoadData();
        this.f = new bp(this, 1);
        this.f.setPriority(3);
        this.f.execute(new Object[0]);
        return true;
    }
}
