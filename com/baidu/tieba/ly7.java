package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public interface ly7 {
    pm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    View b(@NonNull Context context, @NonNull BdUniqueId bdUniqueId);

    pm<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    pm<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    void e(@NonNull View view2);

    void f(@NonNull View view2, @Nullable rha rhaVar, @NonNull BdUniqueId bdUniqueId, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener);

    pm<?, ?> g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str);
}
