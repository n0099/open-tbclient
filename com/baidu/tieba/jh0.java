package com.baidu.tieba;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class jh0 extends gh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ph0<?>> e;
    @Nullable
    public DecimalFormat f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690044294, "Lcom/baidu/tieba/jh0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-690044294, "Lcom/baidu/tieba/jh0$a;");
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
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh0(@NonNull wg0 wg0Var, @NonNull ph0<?> ph0Var) {
        super(wg0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wg0Var, ph0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wg0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        s(ph0Var);
    }

    @Override // com.baidu.tieba.gh0, com.baidu.tieba.oh0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, wg0Var) == null) {
            super.a(adDownloadAction, wg0Var);
            t();
        }
    }

    public void s(ph0<?> ph0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ph0Var) == null) {
            this.e = new WeakReference<>(ph0Var);
            t();
        }
    }

    public void t() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e == null) {
            return;
        }
        Resources resources = hf0.b().getResources();
        String string = resources.getString(R.string.nad_download_start);
        switch (a.a[this.a.c.ordinal()]) {
            case 1:
                if (TextUtils.isEmpty(this.a.p.d)) {
                    str = resources.getString(R.string.nad_download_start);
                } else {
                    str = this.a.p.d;
                }
                string = str;
                break;
            case 2:
                DecimalFormat decimalFormat = this.f;
                if (decimalFormat == null) {
                    decimalFormat = new DecimalFormat("#.#%");
                }
                string = decimalFormat.format(this.a.i);
                break;
            case 3:
                string = resources.getString(R.string.nad_download_continue);
                break;
            case 4:
                string = resources.getString(R.string.nad_download_install);
                break;
            case 5:
                string = resources.getString(R.string.nad_download_open);
                break;
            case 6:
                string = resources.getString(R.string.nad_download_failed_retry);
                break;
        }
        ph0<?> ph0Var = this.e.get();
        if (ph0Var == null) {
            return;
        }
        ph0Var.b(string, this.a);
    }
}
