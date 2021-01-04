package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private String f6128a;

    /* renamed from: b  reason: collision with root package name */
    private String f6129b;
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
        this.f6128a = str;
        this.f6129b = str2;
    }

    public String eoZ() {
        return this.j;
    }

    public boolean epa() {
        return this.h;
    }

    public String yz() {
        return this.f6128a;
    }

    public String getChannel() {
        return this.f6129b;
    }

    public String epb() {
        return this.c;
    }

    public String getLanguage() {
        return this.d;
    }

    public String epc() {
        return this.e;
    }

    public String epd() {
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

    public j epe() {
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

    public String epf() {
        return this.m;
    }

    public int getVersionCode() {
        return this.n;
    }

    public int epg() {
        return this.o;
    }

    public int eph() {
        return this.p;
    }

    public String epi() {
        return this.r;
    }

    public String epj() {
        return this.s;
    }

    public String epk() {
        return this.t;
    }

    public String epl() {
        return this.u;
    }

    public String epm() {
        return this.v;
    }

    public String epn() {
        return this.w;
    }

    public void AJ(boolean z) {
        this.x = z;
    }

    public boolean epo() {
        return this.y;
    }

    public void AK(boolean z) {
        this.y = z;
    }

    public String epp() {
        return this.z;
    }

    public void YC(String str) {
        this.z = str;
    }

    public k epq() {
        return this.pgG;
    }

    public void a(k kVar) {
        this.pgG = kVar;
    }
}
