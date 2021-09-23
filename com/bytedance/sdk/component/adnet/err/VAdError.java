package com.bytedance.sdk.component.adnet.err;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.i;
/* loaded from: classes9.dex */
public class VAdError extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHE_DISPATCH_FAIL_CODE = 607;
    public static final int CONNECT_FAIL_CODE = 601;
    public static final int CONNECT_TIMEOUT_CODE = 602;
    public static final int DOWNLOAD_FILE_CANCEL_FAIL_CODE = 611;
    public static final int DOWNLOAD_FILE_INVALID_FAIL_CODE = 610;
    public static final int IMAGE_OOM_FAIL_CODE = 612;
    public static final int NETWORK_DISPATCH_FAIL_CODE = 608;
    public static final int NETWORK_FAIL_CODE = 603;
    public static final int PARSE_RESPONSE_CONTENT_FAIL_CODE = 606;
    public static final int PARSE_RESPONSE_FAIL_CODE = 605;
    public static final int RENAME_DOWNLOAD_FILE_FAIL_CODE = 609;
    public static final int UNSUPPORT_ENCODE_FAIL_CODE = 604;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64691a;

    /* renamed from: b  reason: collision with root package name */
    public long f64692b;
    public final i networkResponse;

    public VAdError(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.networkResponse = iVar;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64691a : invokeV.intValue;
    }

    public long getNetworkTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64692b : invokeV.longValue;
    }

    public void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f64691a = i2;
        }
    }

    public void setNetworkTimeMs(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f64692b = j2;
        }
    }

    public VAdError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.networkResponse = null;
        this.f64691a = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VAdError(String str, int i2) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.networkResponse = null;
        this.f64691a = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VAdError(String str, Throwable th, int i2) {
        super(str, th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, th, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.networkResponse = null;
        this.f64691a = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VAdError(Throwable th, int i2) {
        super(th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {th, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Throwable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.networkResponse = null;
        this.f64691a = i2;
    }
}
