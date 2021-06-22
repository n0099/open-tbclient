package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23464c = "c";

    /* renamed from: d  reason: collision with root package name */
    public int f23465d;

    public c(String str, int i2, long j, int i3) {
        super(str, 0L, i3);
        this.f23465d = i2;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public int a() {
        return this.f23465d;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public int c() {
        return 1;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public String a(Context context) {
        super.b(((Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis() / 1000) - OtpTokenUtils.getmSyncWithServerTime(context)) / this.f23465d);
        return super.a(context);
    }
}
