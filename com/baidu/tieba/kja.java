package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.data.AtSelectData;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public interface kja {
    void A();

    void B();

    void D(yh5 yh5Var);

    void E();

    LinkedList<gb5> F();

    void b(boolean z);

    void c(String str);

    void d(int i, boolean z);

    void e();

    void f();

    int g();

    void h();

    boolean i();

    void j();

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

    void z(yh5 yh5Var);
}
