package com.baidu.tieba.kn.shake;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f1252a;
    private String b;
    private String c;
    private int d;
    private long e;
    private int f;
    private boolean g;
    private boolean h = false;

    public i(Bundle bundle) {
        this.f1252a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.e = 10000L;
        this.f = 0;
        this.g = false;
        if (bundle != null) {
            this.e = bundle.getLong("key_left_time", 10000L);
            this.f = bundle.getInt("key_shake_time", 0);
            this.g = bundle.getBoolean("key_is_shaking", false);
            b(bundle.getBoolean("key_is_finished", false));
            this.f1252a = bundle.getString("key_pk_id");
            this.b = bundle.getString("key_player_id");
            this.c = bundle.getString("key_player_name");
            this.d = bundle.getInt("key_mode", 1);
        }
    }

    public i(Intent intent) {
        this.f1252a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.e = 10000L;
        this.f = 0;
        this.g = false;
        if (intent != null) {
            this.e = intent.getLongExtra("key_left_time", 10000L);
            this.f = intent.getIntExtra("key_shake_time", 0);
            this.g = intent.getBooleanExtra("key_is_shaking", false);
            b(intent.getBooleanExtra("key_is_finished", false));
            this.f1252a = intent.getStringExtra("key_pk_id");
            this.b = intent.getStringExtra("key_player_id");
            this.d = intent.getIntExtra("key_mode", 1);
            this.c = intent.getStringExtra("key_player_name");
        }
    }

    public void a(Bundle bundle) {
        bundle.putLong("key_left_time", this.e);
        bundle.putInt("key_shake_time", this.f);
        bundle.putBoolean("key_is_shaking", this.g);
        bundle.putString("key_pk_id", this.f1252a);
        bundle.putString("key_player_id", this.b);
        bundle.putInt("key_mode", this.d);
        bundle.putString("key_player_name", this.c);
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public boolean b() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.h;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.f1252a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }
}
