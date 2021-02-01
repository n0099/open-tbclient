package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private String f5831a;

    /* renamed from: b  reason: collision with root package name */
    private String f5832b;
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
    private j pms;
    private k pmt;
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
        this.f5831a = str;
        this.f5832b = str2;
    }

    public String enx() {
        return this.j;
    }

    public boolean eny() {
        return this.h;
    }

    public String uB() {
        return this.f5831a;
    }

    public String getChannel() {
        return this.f5832b;
    }

    public String enz() {
        return this.c;
    }

    public String getLanguage() {
        return this.d;
    }

    public String enA() {
        return this.e;
    }

    public String enB() {
        return this.f;
    }

    @NonNull
    public l AX(boolean z) {
        this.i = z ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.i;
    }

    public j enC() {
        return this.pms;
    }

    public l Oq(int i) {
        aa.a(i);
        return this;
    }

    public String getAppName() {
        return this.k;
    }

    public String getVersion() {
        return this.l;
    }

    public String enD() {
        return this.m;
    }

    public int getVersionCode() {
        return this.n;
    }

    public int enE() {
        return this.o;
    }

    public int enF() {
        return this.p;
    }

    public String enG() {
        return this.r;
    }

    public String enH() {
        return this.s;
    }

    public String enI() {
        return this.t;
    }

    public String enJ() {
        return this.u;
    }

    public String enK() {
        return this.v;
    }

    public String enL() {
        return this.w;
    }

    public void AY(boolean z) {
        this.x = z;
    }

    public boolean enM() {
        return this.y;
    }

    public void AZ(boolean z) {
        this.y = z;
    }

    public String enN() {
        return this.z;
    }

    public void Yv(String str) {
        this.z = str;
    }

    public k enO() {
        return this.pmt;
    }

    public void a(k kVar) {
        this.pmt = kVar;
    }
}
