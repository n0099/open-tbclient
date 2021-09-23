package com.bytedance.embed_dr;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.b.a.o0;
import c.b.a.u0;
import c.b.a.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class VivoIdentifier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdentifierListener listener;
    public final Object mLock;
    public volatile boolean mProloading;
    public final AtomicBoolean mSecondCallGetDeviceIds;
    public String oaid;
    public String resultCode;

    public VivoIdentifier() {
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
        this.mSecondCallGetDeviceIds = new AtomicBoolean();
        this.mProloading = false;
        this.mLock = new Object();
        this.listener = new IIdentifierListener(this) { // from class: com.bytedance.embed_dr.VivoIdentifier.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VivoIdentifier this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            public void OnSupport(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, idSupplier) == null) {
                    try {
                        String str = u0.f31448j;
                        o0.e(str, "OaidMiit#OnSupport isSupport=" + z + ", supplier=" + idSupplier);
                        if (z && idSupplier != null) {
                            this.this$0.setupOaid(idSupplier.getOAID());
                            synchronized (this.this$0.mLock) {
                                this.this$0.mProloading = false;
                                this.this$0.mLock.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        };
    }

    private int callFromReflect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) ? MdidSdkHelper.InitSdk(context, true, this.listener) : invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setupOaid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            synchronized (this) {
                String str2 = u0.f31448j;
                o0.e(str2, "OaidMiit#setupOaid id=" + str + ", oaid=" + this.oaid);
                if (!TextUtils.isEmpty(str) && !str.equals(this.oaid)) {
                    this.oaid = str;
                }
            }
        }
    }

    public v0.a getOaid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            synchronized (this.mLock) {
                if (this.mProloading) {
                    this.mLock.wait(10000L);
                }
            }
            v0.a aVar = new v0.a();
            aVar.f31459a = this.oaid;
            return aVar;
        }
        return (v0.a) invokeL.objValue;
    }

    public void preloadOaid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            synchronized (this.mLock) {
                this.mProloading = true;
                int callFromReflect = callFromReflect(context);
                if (callFromReflect == 1008612) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 不支持的设备");
                    this.resultCode = "不支持的设备";
                } else if (callFromReflect == 1008613) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 加载配置文件出错");
                    this.resultCode = "加载配置文件出错";
                } else if (callFromReflect == 1008611) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 不支持的设备厂商");
                    this.resultCode = "不支持的设备厂商";
                } else if (callFromReflect == 1008614) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                    if (this.mSecondCallGetDeviceIds.compareAndSet(false, true)) {
                        preloadOaid(context);
                    } else {
                        this.resultCode = "结果会在回调中返回";
                    }
                } else if (callFromReflect == 1008615) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 反射调用出错");
                    this.resultCode = "反射调用出错";
                } else if (callFromReflect == 0) {
                    o0.e(u0.f31448j, "OaidMiit#getDeviceIds 正确");
                    this.resultCode = "正确";
                } else {
                    this.resultCode = "未知 resultCode=" + callFromReflect;
                    String str = u0.f31448j;
                    o0.e(str, "OaidMiit#getDeviceIds 未知 resultCode=" + callFromReflect);
                }
            }
        }
    }
}
