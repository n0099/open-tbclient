package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lt3 implements ut3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final rt3 b;

    @Override // com.baidu.tieba.ut3
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lt3 lt3Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt3Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                DownloadInfo downloadInfo = (DownloadInfo) message.obj;
                int status = downloadInfo.getStatus();
                if (downloadInfo.getDownloadListener() == null) {
                    return;
                }
                switch (b.a[DownloadState.convert(status).ordinal()]) {
                    case 1:
                        downloadInfo.getDownloadListener().e(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 2:
                        downloadInfo.getDownloadListener().onStart();
                        return;
                    case 3:
                        downloadInfo.getDownloadListener().d();
                        return;
                    case 4:
                        downloadInfo.getDownloadListener().f(downloadInfo.getProgress(), downloadInfo.getSize());
                        return;
                    case 5:
                        downloadInfo.getDownloadListener().a();
                        return;
                    case 6:
                        downloadInfo.getDownloadListener().b(downloadInfo.getException());
                        return;
                    case 7:
                        downloadInfo.getDownloadListener().c();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621614336, "Lcom/baidu/tieba/lt3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-621614336, "Lcom/baidu/tieba/lt3$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[DownloadState.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public lt3(rt3 rt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = rt3Var;
        this.a = new a(this, Looper.getMainLooper());
    }

    @Override // com.baidu.tieba.ut3
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            if (downloadInfo.getStatus() != DownloadState.DELETED.value()) {
                this.b.a(downloadInfo);
            }
            Message obtainMessage = this.a.obtainMessage(downloadInfo.getId().hashCode());
            obtainMessage.obj = downloadInfo;
            obtainMessage.sendToTarget();
        }
    }
}
