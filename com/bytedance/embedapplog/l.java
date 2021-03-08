package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private String f3934a;
    private String b;
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
    private j ppa;
    private k ppb;
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
        this.f3934a = str;
        this.b = str2;
    }

    public String enP() {
        return this.j;
    }

    public boolean enQ() {
        return this.h;
    }

    public String uE() {
        return this.f3934a;
    }

    public String getChannel() {
        return this.b;
    }

    public String enR() {
        return this.c;
    }

    public String getLanguage() {
        return this.d;
    }

    public String enS() {
        return this.e;
    }

    public String enT() {
        return this.f;
    }

    @NonNull
    public l AW(boolean z) {
        this.i = z ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.i;
    }

    public j enU() {
        return this.ppa;
    }

    public l Ov(int i) {
        aa.a(i);
        return this;
    }

    public String getAppName() {
        return this.k;
    }

    public String getVersion() {
        return this.l;
    }

    public String enV() {
        return this.m;
    }

    public int getVersionCode() {
        return this.n;
    }

    public int enW() {
        return this.o;
    }

    public int enX() {
        return this.p;
    }

    public String enY() {
        return this.r;
    }

    public String enZ() {
        return this.s;
    }

    public String eoa() {
        return this.t;
    }

    public String eob() {
        return this.u;
    }

    public String eoc() {
        return this.v;
    }

    public String eod() {
        return this.w;
    }

    public void AX(boolean z) {
        this.x = z;
    }

    public boolean eoe() {
        return this.y;
    }

    public void AY(boolean z) {
        this.y = z;
    }

    public String eog() {
        return this.z;
    }

    public void YO(String str) {
        this.z = str;
    }

    public k eoh() {
        return this.ppb;
    }

    public void a(k kVar) {
        this.ppb = kVar;
    }
}
