package com.bytedance.sdk.adnet.core;

import com.baidu.tbadk.TbConfig;
import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes6.dex */
public class g implements com.bytedance.sdk.adnet.e.e {

    /* renamed from: a  reason: collision with root package name */
    private int f6027a;

    /* renamed from: b  reason: collision with root package name */
    private int f6028b;
    private int c;
    private final float d;

    public g() {
        this(TbConfig.NOTIFY_YUN_PUSH, 1, 1.0f);
    }

    public g OI(int i) {
        this.f6027a = i;
        return this;
    }

    public g OJ(int i) {
        this.c = i;
        return this;
    }

    public g(int i, int i2, float f) {
        this.f6027a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public int a() {
        return this.f6027a;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public int b() {
        return this.f6028b;
    }

    @Override // com.bytedance.sdk.adnet.e.e
    public void b(VAdError vAdError) throws VAdError {
        this.f6028b++;
        this.f6027a += (int) (this.f6027a * this.d);
        if (!c()) {
            throw vAdError;
        }
    }

    protected boolean c() {
        return this.f6028b <= this.c;
    }
}
