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
import com.repackage.lc0;
import com.repackage.m79;
import com.repackage.s39;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MFFmpegCmdExecutor implements m79 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MFFmpegCmdExecutor_tag";
    public transient /* synthetic */ FieldHolder $fh;
    public FFmpegCmdExecutor mFFmpegCmdExecutor;
    public m79.a mFFmpegCmdListener;

    /* loaded from: classes4.dex */
    public class a implements FFmpegCmdExecutor.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m79.a a;

        public a(MFFmpegCmdExecutor mFFmpegCmdExecutor, m79.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mFFmpegCmdExecutor, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public void onCompletion() {
            m79.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.onCompletion();
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                m79.a aVar = this.a;
                if (aVar != null) {
                    return aVar.onError(i, i2, obj);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.media.transcoder.FFmpegCmdExecutor.b
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                m79.a aVar = this.a;
                if (aVar != null) {
                    return aVar.onInfo(i, i2, obj);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (lc0.a() == null || TextUtils.isEmpty(lc0.b())) {
            Context context = s39.c().getContext() != null ? s39.c().getContext() : null;
            String b = !TextUtils.isEmpty(s39.c().b()) ? s39.c().b() : "quanmin_unknow";
            if (context != null) {
                try {
                    lc0.d(context, b);
                } catch (Exception unused) {
                }
            }
        }
        this.mFFmpegCmdExecutor = new FFmpegCmdExecutor();
    }

    @Override // com.repackage.m79
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFFmpegCmdExecutor.g();
        }
    }

    @Override // com.repackage.m79
    public synchronized void setListener(m79.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                this.mFFmpegCmdListener = aVar;
                this.mFFmpegCmdExecutor.h(new a(this, aVar));
            }
        }
    }

    @Override // com.repackage.m79
    public void setSource(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.mFFmpegCmdExecutor.i(arrayList);
        }
    }

    @Override // com.repackage.m79
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (lc0.a() != null && !TextUtils.isEmpty(lc0.b())) {
                this.mFFmpegCmdExecutor.j();
                return;
            }
            m79.a aVar = this.mFFmpegCmdListener;
            if (aVar != null) {
                aVar.onError(-9527, -9527, "TranscoderManager install error");
            }
        }
    }
}
