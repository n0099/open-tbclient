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
    private j pmS;
    private k pmT;
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

    public String enF() {
        return this.j;
    }

    public boolean enG() {
        return this.h;
    }

    public String uB() {
        return this.f5831a;
    }

    public String getChannel() {
        return this.f5832b;
    }

    public String enH() {
        return this.c;
    }

    public String getLanguage() {
        return this.d;
    }

    public String enI() {
        return this.e;
    }

    public String enJ() {
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

    public j enK() {
        return this.pmS;
    }

    public l Or(int i) {
        aa.a(i);
        return this;
    }

    public String getAppName() {
        return this.k;
    }

    public String getVersion() {
        return this.l;
    }

    public String enL() {
        return this.m;
    }

    public int getVersionCode() {
        return this.n;
    }

    public int enM() {
        return this.o;
    }

    public int enN() {
        return this.p;
    }

    public String enO() {
        return this.r;
    }

    public String enP() {
        return this.s;
    }

    public String enQ() {
        return this.t;
    }

    public String enR() {
        return this.u;
    }

    public String enS() {
        return this.v;
    }

    public String enT() {
        return this.w;
    }

    public void AY(boolean z) {
        this.x = z;
    }

    public boolean enU() {
        return this.y;
    }

    public void AZ(boolean z) {
        this.y = z;
    }

    public String enV() {
        return this.z;
    }

    public void YH(String str) {
        this.z = str;
    }

    public k enW() {
        return this.pmT;
    }

    public void a(k kVar) {
        this.pmT = kVar;
    }
}
