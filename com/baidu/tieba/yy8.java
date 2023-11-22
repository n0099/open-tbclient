package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.TbImageAutoSwitch;
/* loaded from: classes9.dex */
public interface yy8 {
    void a(int i);

    @NonNull
    View b();

    @NonNull
    LinearLayout c();

    void d(@NonNull String str, long j);

    @NonNull
    TextView e();

    @NonNull
    TextView f();

    int g();

    @NonNull
    HeadImageView h();

    @NonNull
    int i();

    @NonNull
    int j();

    LinearLayout k();

    @NonNull
    LinearLayout l();

    @Nullable
    RelativeLayout m();

    @Nullable
    RecyclerView n();

    int o();

    void onChangeSkinType(int i);

    @NonNull
    RelativeLayout p();

    TextView q();

    @Nullable
    RelativeLayout r();

    @NonNull
    TbImageAutoSwitch s();

    void t(int i);

    LinearLayout u();
}
