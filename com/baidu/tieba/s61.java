package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes8.dex */
public final class s61 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AbsNadBrowserView a;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public s61(AbsNadBrowserView absNadBrowserView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absNadBrowserView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = absNadBrowserView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i != 1) {
                if (i == 2) {
                    this.a.T(msg.arg1);
                    return;
                }
                return;
            }
            this.a.l();
            this.a.k();
        }
    }
}
