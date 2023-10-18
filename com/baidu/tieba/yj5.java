package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes9.dex */
public interface yj5 extends dk5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatBoxDialogService");

    boolean isEnable();

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
