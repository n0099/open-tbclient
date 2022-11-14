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
public interface z69 {
    void A();

    void C();

    void D(k65 k65Var);

    void E();

    LinkedList<i05> F();

    void b(boolean z);

    void c();

    void d(String str);

    void e(int i, boolean z);

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

    void z(k65 k65Var);
}
