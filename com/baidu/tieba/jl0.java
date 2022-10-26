package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.SpeedCalculator;
import com.baidu.searchbox.bddownload.StatusUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadSpeedListener;
import com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class jl0 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk0Var) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends DownloadSpeedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public long c;
        public il0 d;

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo, SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, downloadTask, i, blockInfo, speedCalculator) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progressBlock(DownloadTask downloadTask, int i, long j, SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), speedCalculator}) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) {
            }
        }

        public a(il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = il0Var;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(DownloadTask downloadTask, int i, int i2, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
                String str = "Connect End " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, ListenerSpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4SpeedModel}) == null) {
                long totalLength = breakpointInfo.getTotalLength();
                this.a = totalLength;
                this.b = Util.humanReadableBytes(totalLength, true);
                this.d.b(this.a, downloadTask.getFile());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(DownloadTask downloadTask, int i, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, map) == null) {
                String str = "Connect Start " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progress(DownloadTask downloadTask, long j, SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadTask, Long.valueOf(j), speedCalculator}) == null) {
                String str = (Util.humanReadableBytes(j, true) + "/" + this.b) + "(" + speedCalculator.speed() + SmallTailInfo.EMOTION_SUFFIX;
                this.c = j;
                this.d.a(downloadTask.getId(), j, this.a);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, downloadTask, endCause, exc, speedCalculator) == null) {
                downloadTask.removeTag();
                if (endCause == EndCause.COMPLETED) {
                    this.d.onSuccess(downloadTask.getId());
                } else if (endCause == EndCause.CANCELED) {
                    this.d.c(downloadTask.getId(), (int) ((this.c / this.a) * 100.0d));
                } else if (endCause == EndCause.ERROR) {
                    uk0 uk0Var = new uk0();
                    uk0Var.a = exc;
                    this.d.d(uk0Var);
                } else {
                    uk0 uk0Var2 = new uk0();
                    uk0Var2.a = exc;
                    this.d.d(uk0Var2);
                }
                if (og0.a && exc != null) {
                    Context b = aj0.b();
                    Toast.makeText(b, "下载失败！原因：" + exc, 0).show();
                }
            }
        }
    }

    public jl0() {
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
        this.a = new HashMap();
        AppRuntimeInit.onApplicationattachBaseContext((Application) aj0.b());
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(mk0 mk0Var, il0 il0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mk0Var, il0Var)) == null) {
            DownloadTask build = new DownloadTask.Builder(mk0Var.g, sl0.a(aj0.b())).setPassIfAlreadyCompleted(false).build();
            a aVar = new a(il0Var);
            if (build.getTag() != null) {
                build.cancel();
            }
            build.enqueue(aVar);
            build.setTag("mark-task-started");
            zz0.e(this.a, Integer.valueOf(build.getId()), build);
            return build.getId();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mk0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) zz0.b(this.a, Integer.valueOf(mk0Var.b));
            if (downloadTask != null && downloadTask.getTag() != null) {
                downloadTask.cancel();
            }
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(mk0 mk0Var, il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, mk0Var, il0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) zz0.b(this.a, Integer.valueOf(mk0Var.b));
            if (downloadTask != null && StatusUtil.getStatus(downloadTask) == StatusUtil.Status.IDLE) {
                downloadTask.setTag("mark-task-started");
                downloadTask.enqueue(new a(il0Var));
                return;
            }
            a(mk0Var, il0Var);
        }
    }
}
