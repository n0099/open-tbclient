package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class xl0 implements yl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<sl0> a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-285542096, "Lcom/baidu/tieba/xl0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-285542096, "Lcom/baidu/tieba/xl0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public xl0(@NonNull sl0 sl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sl0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(sl0Var);
    }

    @Override // com.baidu.tieba.yl0
    public void a(AdDownloadStatus adDownloadStatus) {
        sl0 sl0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, adDownloadStatus) != null) || (sl0Var = this.a.get()) == null) {
            return;
        }
        hl0 s = sl0Var.s();
        String str = "";
        switch (a.a[adDownloadStatus.ordinal()]) {
            case 1:
                sl0Var.x("0", String.valueOf(s.i), "", s.e());
                return;
            case 2:
                String valueOf = String.valueOf(s.i);
                Uri uri = s.k;
                if (uri != null) {
                    str = uri.toString();
                }
                sl0Var.x("2", valueOf, str, s.e());
                return;
            case 3:
                String valueOf2 = String.valueOf(s.i);
                Uri uri2 = s.k;
                if (uri2 != null) {
                    str = uri2.toString();
                }
                sl0Var.x("1", valueOf2, str, s.e());
                return;
            case 4:
                Uri uri3 = s.k;
                if (uri3 != null) {
                    str = uri3.toString();
                }
                sl0Var.x("3", "1", str, s.e());
                return;
            case 5:
                Uri uri4 = s.k;
                if (uri4 != null) {
                    str = uri4.toString();
                }
                sl0Var.x("6", "1", str, s.e());
                return;
            case 6:
                sl0Var.x("4", "0", "", s.e());
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.yl0
    public void b(AdDownloadCode adDownloadCode) {
        sl0 sl0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) != null) || (sl0Var = this.a.get()) == null || adDownloadCode == AdDownloadCode.ERROR_FAST_CLICK) {
            return;
        }
        sl0Var.x("4", "0", "", sl0Var.s().e());
    }
}
