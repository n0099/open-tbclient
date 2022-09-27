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
public interface u49 {
    void A();

    void C();

    void D(h55 h55Var);

    void E();

    LinkedList<iz4> F();

    void a(boolean z);

    void b(int i, boolean z);

    void c();

    void d(String str);

    void e();

    int f();

    void g();

    boolean h();

    void i();

    void j(boolean z);

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

    void z(h55 h55Var);
}
