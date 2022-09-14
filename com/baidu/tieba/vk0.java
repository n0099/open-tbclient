package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class vk0 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Integer, DownloadTask> a;

    /* loaded from: classes6.dex */
    public static class a extends DownloadSpeedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public long c;
        public uk0 d;

        public a(uk0 uk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uk0Var;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void blockEnd(@NonNull DownloadTask downloadTask, int i, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, downloadTask, i, blockInfo, speedCalculator) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull DownloadTask downloadTask, int i, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
                String str = "Connect End " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull DownloadTask downloadTask, int i, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, map) == null) {
                String str = "Connect Start " + i;
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void infoReady(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, boolean z, @NonNull ListenerSpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{downloadTask, breakpointInfo, Boolean.valueOf(z), listener4SpeedModel}) == null) {
                long totalLength = breakpointInfo.getTotalLength();
                this.a = totalLength;
                this.b = Util.humanReadableBytes(totalLength, true);
                this.d.b(this.a, downloadTask.getFile());
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progress(@NonNull DownloadTask downloadTask, long j, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadTask, Long.valueOf(j), speedCalculator}) == null) {
                String str = (Util.humanReadableBytes(j, true) + "/" + this.b) + "(" + speedCalculator.speed() + SmallTailInfo.EMOTION_SUFFIX;
                this.c = j;
                this.d.a(downloadTask.getId(), j, this.a);
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progressBlock(@NonNull DownloadTask downloadTask, int i, long j, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), speedCalculator}) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, downloadTask, endCause, exc, speedCalculator) == null) {
                downloadTask.removeTag();
                if (endCause == EndCause.COMPLETED) {
                    this.d.onSuccess(downloadTask.getId());
                } else if (endCause == EndCause.CANCELED) {
                    this.d.c(downloadTask.getId(), (int) ((this.c / this.a) * 100.0d));
                } else if (endCause == EndCause.ERROR) {
                    gk0 gk0Var = new gk0();
                    gk0Var.a = exc;
                    this.d.d(gk0Var);
                } else {
                    gk0 gk0Var2 = new gk0();
                    gk0Var2.a = exc;
                    this.d.d(gk0Var2);
                }
                if (!ag0.a || exc == null) {
                    return;
                }
                Context b = mi0.b();
                Toast.makeText(b, "下载失败！原因：" + exc, 0).show();
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) {
            }
        }
    }

    public vk0() {
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
        this.a = new HashMap<>();
        AppRuntimeInit.onApplicationattachBaseContext((Application) mi0.b());
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(@NonNull yj0 yj0Var, @NonNull uk0 uk0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yj0Var, uk0Var)) == null) {
            DownloadTask build = new DownloadTask.Builder(yj0Var.g, el0.a(mi0.b())).setPassIfAlreadyCompleted(false).build();
            a aVar = new a(uk0Var);
            if (build.getTag() != null) {
                build.cancel();
            }
            build.enqueue(aVar);
            build.setTag("mark-task-started");
            lz0.e(this.a, Integer.valueOf(build.getId()), build);
            return build.getId();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yj0Var) == null) {
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yj0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) lz0.b(this.a, Integer.valueOf(yj0Var.b));
            if (downloadTask == null || downloadTask.getTag() == null) {
                return;
            }
            downloadTask.cancel();
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull yj0 yj0Var, @NonNull uk0 uk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, yj0Var, uk0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) lz0.b(this.a, Integer.valueOf(yj0Var.b));
            if (downloadTask != null && StatusUtil.getStatus(downloadTask) == StatusUtil.Status.IDLE) {
                downloadTask.setTag("mark-task-started");
                downloadTask.enqueue(new a(uk0Var));
                return;
            }
            a(yj0Var, uk0Var);
        }
    }
}
