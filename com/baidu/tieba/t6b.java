package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.data.AtSelectData;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public interface t6b {
    void A();

    void B();

    void C(wi5 wi5Var);

    void D();

    LinkedList<lb5> E();

    void a(String str);

    void b();

    void d(boolean z);

    void e();

    void f(int i, boolean z);

    void g();

    int h();

    void i();

    boolean j();

    void k(boolean z);

    void m();

    void n(@Nullable ArrayList<AtSelectData> arrayList);

    void o(boolean z);

    void onActivityResult(int i, int i2, Intent intent);

    boolean onBackPressed();

    void onChangeSkinType(int i);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void p(boolean z);

    void r();

    void s();

    @NonNull
    PermissionJudgePolicy t();

    void u();

    void v();

    void w();

    void x(int[] iArr);

    void y(boolean z);

    void z(wi5 wi5Var);
}
