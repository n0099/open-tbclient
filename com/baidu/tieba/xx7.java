package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes8.dex */
public interface xx7 {
    ln<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    View b(@NonNull Context context, @NonNull BdUniqueId bdUniqueId);

    ln<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    ln<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    void e(@NonNull View view2);

    void f(@NonNull View view2, @Nullable wca wcaVar, @NonNull BdUniqueId bdUniqueId, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener);

    ln<?, ?> g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str);
}
