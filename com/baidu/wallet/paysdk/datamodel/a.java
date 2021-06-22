package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f25401a;

    /* renamed from: b  reason: collision with root package name */
    public String f25402b;

    public String a() {
        if (TextUtils.isEmpty(this.f25401a)) {
            return this.f25401a;
        }
        return this.f25401a;
    }

    public String b() {
        return this.f25402b;
    }

    public String toString() {
        return "CardInfoDisplayModel [content=" + this.f25401a + ", flag=" + this.f25402b + PreferencesUtil.RIGHT_MOUNT;
    }

    public void b(String str) {
        this.f25402b = str;
    }

    public void a(String str) {
        this.f25401a = str;
    }
}
