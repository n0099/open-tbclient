package com.bytedance.sdk.adnet.c;

import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6006a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6007b = true;
    public Map<String, Integer> c = null;
    public Map<String, String> d = null;
    public int e = 10;
    public int f = 1;
    public int g = 1;
    public int h = 10;
    public int i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;
    public int n = 0;
    public long o = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ").append(this.f6006a);
        sb.append(" probeEnable: ").append(this.f6007b);
        sb.append(" hostFilter: ").append(this.c != null ? this.c.size() : 0);
        sb.append(" hostMap: ").append(this.d != null ? this.d.size() : 0);
        sb.append(" reqTo: ").append(this.e).append("#").append(this.f).append("#").append(this.g);
        sb.append(" reqErr: ").append(this.h).append("#").append(this.i).append("#").append(this.j);
        sb.append(" updateInterval: ").append(this.k);
        sb.append(" updateRandom: ").append(this.l);
        sb.append(" httpBlack: ").append(this.m);
        return sb.toString();
    }
}
