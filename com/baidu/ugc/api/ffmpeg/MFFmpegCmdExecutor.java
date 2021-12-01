package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import c.a.x0.b;
import c.a.x0.s.a;
import c.a.z.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class MFFmpegCmdExecutor implements c.a.x0.s.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public a.InterfaceC1545a mFFmpegCmdListener;

    /* loaded from: classes11.dex */
    public class a implements FFmpegCmdExecutor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC1545a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, a.InterfaceC1545a interfaceC1545a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mFFmpegCmdExecutor, interfaceC1545a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC1545a;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            a.InterfaceC1545a interfaceC1545a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC1545a = this.a) == null) {
                return;
            }
            interfaceC1545a.onCompletion();
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    return interfaceC1545a.onError(i2, i3, obj);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                a.InterfaceC1545a interfaceC1545a = this.a;
                if (interfaceC1545a != null) {
                    return interfaceC1545a.onInfo(i2, i3, obj);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public MFFmpegCmdExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (c.a() == null || TextUtils.isEmpty(c.b())) {
            Context context = b.c().getContext() != null ? b.c().getContext() : null;
            String b2 = !TextUtils.isEmpty(b.c().b()) ? b.c().b() : "quanmin_unknow";
            if (context != null) {
                try {
                    c.d(context, b2);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // c.a.x0.s.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFFmpegCmdExecutor.g();
        }
    }

    @Override // c.a.x0.s.a
    public synchronized void setListener(a.InterfaceC1545a interfaceC1545a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1545a) == null) {
            synchronized (this) {
                this.mFFmpegCmdListener = interfaceC1545a;
                this.mFFmpegCmdExecutor.h(new a(this, interfaceC1545a));
            }
        }
    }

    @Override // c.a.x0.s.a
    public void setSource(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.mFFmpegCmdExecutor.i(arrayList);
        }
    }

    @Override // c.a.x0.s.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a() != null && !TextUtils.isEmpty(c.b())) {
                this.mFFmpegCmdExecutor.j();
                return;
            }
            a.InterfaceC1545a interfaceC1545a = this.mFFmpegCmdListener;
            if (interfaceC1545a != null) {
                interfaceC1545a.onError(-9527, -9527, "TranscoderManager install error");
            }
        }
    }
}
