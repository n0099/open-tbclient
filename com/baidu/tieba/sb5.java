package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface sb5 extends xb5 {
    @NonNull
    public static final ServiceReference a = new ServiceReference("ImMessageCenter", "ChatBoxDialogService");

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
