package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes7.dex */
public interface op5 extends tp5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatBoxDialogService");

    boolean isEnable();

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
