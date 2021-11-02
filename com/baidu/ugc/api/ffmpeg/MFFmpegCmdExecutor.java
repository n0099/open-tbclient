package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import b.a.x0.b;
import b.a.x0.s.a;
import b.a.z.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class MFFmpegCmdExecutor implements b.a.x0.s.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public a.InterfaceC1439a mFFmpegCmdListener;

    /* loaded from: classes10.dex */
    public class a implements FFmpegCmdExecutor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1439a f57058a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, a.InterfaceC1439a interfaceC1439a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mFFmpegCmdExecutor, interfaceC1439a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57058a = interfaceC1439a;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            a.InterfaceC1439a interfaceC1439a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC1439a = this.f57058a) == null) {
                return;
            }
            interfaceC1439a.onCompletion();
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                a.InterfaceC1439a interfaceC1439a = this.f57058a;
                if (interfaceC1439a != null) {
                    return interfaceC1439a.onError(i2, i3, obj);
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
                a.InterfaceC1439a interfaceC1439a = this.f57058a;
                if (interfaceC1439a != null) {
                    return interfaceC1439a.onInfo(i2, i3, obj);
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

    @Override // b.a.x0.s.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFFmpegCmdExecutor.g();
        }
    }

    @Override // b.a.x0.s.a
    public synchronized void setListener(a.InterfaceC1439a interfaceC1439a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1439a) == null) {
            synchronized (this) {
                this.mFFmpegCmdListener = interfaceC1439a;
                this.mFFmpegCmdExecutor.h(new a(this, interfaceC1439a));
            }
        }
    }

    @Override // b.a.x0.s.a
    public void setSource(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.mFFmpegCmdExecutor.i(arrayList);
        }
    }

    @Override // b.a.x0.s.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a() != null && !TextUtils.isEmpty(c.b())) {
                this.mFFmpegCmdExecutor.j();
                return;
            }
            a.InterfaceC1439a interfaceC1439a = this.mFFmpegCmdListener;
            if (interfaceC1439a != null) {
                interfaceC1439a.onError(-9527, -9527, "TranscoderManager install error");
            }
        }
    }
}
