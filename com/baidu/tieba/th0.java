package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nps.utils.Constant;
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
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class th0 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Integer, DownloadTask> a;

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wg0Var) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends DownloadSpeedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public long c;
        public sh0 d;

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void blockEnd(@NonNull DownloadTask downloadTask, int i, BlockInfo blockInfo, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, downloadTask, i, blockInfo, speedCalculator) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.assist.ListenerSpeedAssistExtend.Listener4SpeedCallback
        public void progressBlock(@NonNull DownloadTask downloadTask, int i, long j, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), speedCalculator}) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void taskStart(@NonNull DownloadTask downloadTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) {
            }
        }

        public a(sh0 sh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sh0Var;
        }

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectEnd(@NonNull DownloadTask downloadTask, int i, int i2, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Integer.valueOf(i), Integer.valueOf(i2), map}) == null) {
                String str = "Connect End " + i;
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

        @Override // com.baidu.searchbox.bddownload.core.listener.DownloadListener
        public void connectStart(@NonNull DownloadTask downloadTask, int i, @NonNull Map<String, List<String>> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, i, map) == null) {
                String str = "Connect Start " + i;
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
        public void taskEnd(@NonNull DownloadTask downloadTask, @NonNull EndCause endCause, @Nullable Exception exc, @NonNull SpeedCalculator speedCalculator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, downloadTask, endCause, exc, speedCalculator) == null) {
                downloadTask.removeTag();
                if (endCause == EndCause.COMPLETED) {
                    this.d.onSuccess(downloadTask.getId());
                } else if (endCause == EndCause.CANCELED) {
                    this.d.c(downloadTask.getId(), (int) ((this.c / this.a) * 100.0d));
                } else if (endCause == EndCause.ERROR) {
                    eh0 eh0Var = new eh0();
                    eh0Var.a = exc;
                    eh0Var.c = true;
                    this.d.d(eh0Var);
                } else {
                    eh0 eh0Var2 = new eh0();
                    eh0Var2.a = exc;
                    this.d.d(eh0Var2);
                }
                if (qc0.a && exc != null) {
                    Context b = hf0.b();
                    Toast.makeText(b, "下载失败！原因：" + exc, 0).show();
                }
            }
        }
    }

    public th0() {
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
        AppRuntimeInit.onApplicationattachBaseContext((Application) hf0.b());
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        InterceptResult invokeLL;
        DownloadTask build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wg0Var, sh0Var)) == null) {
            File a2 = ii0.a(hf0.b());
            String e = e(wg0Var);
            if (!TextUtils.isEmpty(e)) {
                build = new DownloadTask.Builder(wg0Var.g, a2).setPassIfAlreadyCompleted(false).setFilename(e + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).build();
            } else {
                build = new DownloadTask.Builder(wg0Var.g, a2).setPassIfAlreadyCompleted(false).build();
            }
            a aVar = new a(sh0Var);
            if (build.getTag() != null) {
                build.cancel();
            }
            build.enqueue(aVar);
            build.setTag("mark-task-started");
            py0.e(this.a, Integer.valueOf(build.getId()), build);
            return build.getId();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wg0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) py0.b(this.a, Integer.valueOf(wg0Var.b));
            if (downloadTask != null && downloadTask.getTag() != null) {
                downloadTask.cancel();
            }
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, wg0Var, sh0Var) == null) {
            DownloadTask downloadTask = (DownloadTask) py0.b(this.a, Integer.valueOf(wg0Var.b));
            if (downloadTask != null && StatusUtil.getStatus(downloadTask) == StatusUtil.Status.IDLE) {
                downloadTask.setTag("mark-task-started");
                downloadTask.enqueue(new a(sh0Var));
                return;
            }
            a(wg0Var, sh0Var);
        }
    }

    public final String e(wg0 wg0Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wg0Var)) == null) {
            if (wg0Var != null && ij0.b().a().a("uad_set_filename_switch", 0) == 1) {
                ah0 ah0Var = wg0Var.p;
                if (ah0Var != null && !TextUtils.isEmpty(ah0Var.h)) {
                    str = wg0Var.p.h;
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(wg0Var.g)) {
                    str = x11.a("MD5", wg0Var.g.getBytes(), false);
                }
                if (str.length() > 250) {
                    return str.substring(0, 250);
                }
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
