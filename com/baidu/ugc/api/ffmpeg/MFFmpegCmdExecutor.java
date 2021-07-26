package com.baidu.ugc.api.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.media.transcoder.FFmpegCmdExecutor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.b;
import d.a.w0.s.a;
import d.a.z.f.c;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MFFmpegCmdExecutor implements d.a.w0.s.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public a.InterfaceC1949a mFFmpegCmdListener;

    /* loaded from: classes5.dex */
    public class a implements FFmpegCmdExecutor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC1949a f23857a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, a.InterfaceC1949a interfaceC1949a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mFFmpegCmdExecutor, interfaceC1949a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23857a = interfaceC1949a;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            a.InterfaceC1949a interfaceC1949a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (interfaceC1949a = this.f23857a) == null) {
                return;
            }
            interfaceC1949a.onCompletion();
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                a.InterfaceC1949a interfaceC1949a = this.f23857a;
                if (interfaceC1949a != null) {
                    return interfaceC1949a.onError(i2, i3, obj);
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
                a.InterfaceC1949a interfaceC1949a = this.f23857a;
                if (interfaceC1949a != null) {
                    return interfaceC1949a.onInfo(i2, i3, obj);
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
            Context b2 = b.d().b() != null ? b.d().b() : null;
            String c2 = !TextUtils.isEmpty(b.d().c()) ? b.d().c() : "quanmin_unknow";
            if (b2 != null) {
                try {
                    c.d(b2, c2);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // d.a.w0.s.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFFmpegCmdExecutor.g();
        }
    }

    @Override // d.a.w0.s.a
    public synchronized void setListener(a.InterfaceC1949a interfaceC1949a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1949a) == null) {
            synchronized (this) {
                this.mFFmpegCmdListener = interfaceC1949a;
                this.mFFmpegCmdExecutor.h(new a(this, interfaceC1949a));
            }
        }
    }

    @Override // d.a.w0.s.a
    public void setSource(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.mFFmpegCmdExecutor.i(arrayList);
        }
    }

    @Override // d.a.w0.s.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a() != null && !TextUtils.isEmpty(c.b())) {
                this.mFFmpegCmdExecutor.j();
                return;
            }
            a.InterfaceC1949a interfaceC1949a = this.mFFmpegCmdListener;
            if (interfaceC1949a != null) {
                interfaceC1949a.onError(-9527, -9527, "TranscoderManager install error");
            }
        }
    }
}
