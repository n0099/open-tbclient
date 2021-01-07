package com.bytedance.sdk.adnet.core;

import com.baidu.tbadk.TbConfig;
import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes4.dex */
public class g implements com.bytedance.sdk.adnet.e.e {

    /* renamed from: a  reason: collision with root package name */
    private int f6325a;

    /* renamed from: b  reason: collision with root package name */
    private int f6326b;
    private int c;
    private final float d;

    public g() {
        this(TbConfig.NOTIFY_YUN_PUSH, 1, 1.0f);
    }

    public g PT(int i) {
        this.f6325a = i;
        return this;
    }

    public g PU(int i) {
        this.c = i;
        return this;
    }

    public g(int i, int i2, float f) {
        this.f6325a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public int a() {
        return this.f6325a;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public int b() {
        return this.f6326b;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public void b(VAdError vAdError) throws VAdError {
        this.f6326b++;
        this.f6325a += (int) (this.f6325a * this.d);
        if (!c()) {
            throw vAdError;
        }
    }

    protected boolean c() {
        return this.f6326b <= this.c;
    }
}
