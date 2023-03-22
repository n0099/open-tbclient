package com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.tieba.au7;
import com.baidu.tieba.bu7;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.ResponsesPanelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ResponsesPanelControllerImpl implements ResponsesPanelController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bu7 a;
    public final au7 b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, this) == null) {
            this.a.onDestroy();
            this.b.onDestroy();
        }
    }
}
