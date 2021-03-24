package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23689c = "c";

    /* renamed from: d  reason: collision with root package name */
    public int f23690d;

    public c(String str, int i, long j, int i2) {
        super(str, 0L, i2);
        this.f23690d = i;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public int a() {
        return this.f23690d;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public int c() {
        return 1;
    }

    @Override // com.baidu.wallet.base.nopassauth.a, com.baidu.wallet.base.nopassauth.b
    public String a(Context context) {
        super.b(((Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis() / 1000) - OtpTokenUtils.getmSyncWithServerTime(context)) / this.f23690d);
        return super.a(context);
    }
}
