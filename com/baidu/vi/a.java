package com.baidu.vi;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.vi.AudioRecorder;
/* loaded from: classes9.dex */
public final class a extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            AudioRecorder audioRecorder = ((AudioRecorder.a) message.obj).a;
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                z2 = audioRecorder.h;
                if (z2) {
                    audioRecorder.onReadError();
                    return;
                }
                return;
            }
            z = audioRecorder.h;
            if (z) {
                Object obj = message.obj;
                audioRecorder.onReadData(((AudioRecorder.a) obj).b, ((AudioRecorder.a) obj).c);
            }
        }
    }
}
