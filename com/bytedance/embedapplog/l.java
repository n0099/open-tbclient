package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private String f6129a;

    /* renamed from: b  reason: collision with root package name */
    private String f6130b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean h;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private j pgF;
    private k pgG;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String z;
    private int i = 0;
    private boolean x = true;
    private boolean y = true;

    public l(@NonNull String str, @NonNull String str2) {
        this.f6129a = str;
        this.f6130b = str2;
    }

    public String epa() {
        return this.j;
    }

    public boolean epb() {
        return this.h;
    }

    public String yz() {
        return this.f6129a;
    }

    public String getChannel() {
        return this.f6130b;
    }

    public String epc() {
        return this.c;
    }

    public String getLanguage() {
        return this.d;
    }

    public String epd() {
        return this.e;
    }

    public String epe() {
        return this.f;
    }

    @NonNull
    public l AI(boolean z) {
        this.i = z ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.i;
    }

    public j epf() {
        return this.pgF;
    }

    public l PC(int i) {
        aa.a(i);
        return this;
    }

    public String getAppName() {
        return this.k;
    }

    public String getVersion() {
        return this.l;
    }

    public String epg() {
        return this.m;
    }

    public int getVersionCode() {
        return this.n;
    }

    public int eph() {
        return this.o;
    }

    public int epi() {
        return this.p;
    }

    public String epj() {
        return this.r;
    }

    public String epk() {
        return this.s;
    }

    public String epl() {
        return this.t;
    }

    public String epm() {
        return this.u;
    }

    public String epn() {
        return this.v;
    }

    public String epo() {
        return this.w;
    }

    public void AJ(boolean z) {
        this.x = z;
    }

    public boolean epp() {
        return this.y;
    }

    public void AK(boolean z) {
        this.y = z;
    }

    public String epq() {
        return this.z;
    }

    public void YB(String str) {
        this.z = str;
    }

    public k epr() {
        return this.pgG;
    }

    public void a(k kVar) {
        this.pgG = kVar;
    }
}
