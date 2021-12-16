package com.baidu.wallet.lightapp.multipage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.wallet.lightapp.business.LangbridgeBarParams;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
/* loaded from: classes13.dex */
public interface c {
    View a();

    void a(int i2, int i3, Intent intent);

    void a(int i2, @NonNull String[] strArr, @NonNull int[] iArr);

    void a(d dVar, Bundle bundle, String str);

    void a(String str, b bVar, boolean z);

    LightappBrowserWebView b();

    boolean c();

    void d();

    void e();

    void f();

    void g();

    void h();

    void i();

    void j();

    String k();

    LangbridgeBarParams l();
}
