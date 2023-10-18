package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.List;
/* loaded from: classes7.dex */
public interface m1b<D> {
    void a(WriteData writeData);

    void b();

    void c(@NonNull WriteData writeData);

    void e(@NonNull WriteData writeData);

    boolean g();

    void h(@Nullable String str, @NonNull WriteData writeData);

    void j(@NonNull o1b o1bVar);

    void m(Bundle bundle, Intent intent, @NonNull WriteData writeData);

    boolean o();

    void onActivityResult(int i, int i2, Intent intent);

    void onChangeSkinType(int i);

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void q(@NonNull List<m1b<?>> list);

    void r(cd5 cd5Var);

    View s(@NonNull ViewGroup viewGroup);

    boolean t();
}
