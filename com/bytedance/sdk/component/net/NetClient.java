package com.bytedance.sdk.component.net;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.d.c;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.component.net.tnc.ITTAdNetDepend;
import com.bytedance.sdk.component.net.tnc.TncHostInterceptor;
import com.bytedance.sdk.component.net.tnc.TncInstanceManager;
import com.bytedance.sdk.component.net.utils.ProcessUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class NetClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAid;
    public w okHttpClient;
    public TncHostInterceptor tncHostInterceptor;

    /* renamed from: com.bytedance.sdk.component.net.NetClient$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int connectTimeout;
        public boolean enableTNC;
        public final List<u> interceptors;
        public int readTimeout;
        public int writeTimeout;

        public Builder() {
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
            this.enableTNC = true;
            this.interceptors = new ArrayList();
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        public static int checkDuration(String str, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j2), timeUnit})) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException(str + " < 0");
                } else if (timeUnit != null) {
                    long millis = timeUnit.toMillis(j2);
                    if (millis > 2147483647L) {
                        throw new IllegalArgumentException(str + " too large.");
                    } else if (millis != 0 || i2 <= 0) {
                        return (int) millis;
                    } else {
                        throw new IllegalArgumentException(str + " too small.");
                    }
                } else {
                    throw new NullPointerException("unit == null");
                }
            }
            return invokeCommon.intValue;
        }

        public NetClient build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NetClient(this, null) : (NetClient) invokeV.objValue;
        }

        public Builder connectTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit)) == null) {
                this.connectTimeout = checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder enableTNC(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.enableTNC = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder readTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, timeUnit)) == null) {
                this.readTimeout = checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder writeTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j2, timeUnit)) == null) {
                this.writeTimeout = checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }
    }

    public /* synthetic */ NetClient(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static void openDeubg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a(c.a.f64370a);
        }
    }

    public DownloadExecutor getDownloadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new DownloadExecutor(this.okHttpClient) : (DownloadExecutor) invokeV.objValue;
    }

    public GetExecutor getGetExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new GetExecutor(this.okHttpClient) : (GetExecutor) invokeV.objValue;
    }

    public PostExecutor getPostExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new PostExecutor(this.okHttpClient) : (PostExecutor) invokeV.objValue;
    }

    public void tryInitTTAdNet(Context context, boolean z, boolean z2, ITTAdNetDepend iTTAdNetDepend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), iTTAdNetDepend}) == null) {
            if (context == null) {
                throw new IllegalArgumentException("tryInitAdTTNet context is null");
            }
            if (iTTAdNetDepend != null) {
                int aid = iTTAdNetDepend.getAid();
                this.mAid = aid;
                TncHostInterceptor tncHostInterceptor = this.tncHostInterceptor;
                if (tncHostInterceptor != null) {
                    tncHostInterceptor.setAid(aid);
                }
                TncInstanceManager.getInstance().getTNCManager(this.mAid).setURLDispatchEnabled(z2);
                TncInstanceManager.getInstance().getTNCManager(this.mAid).setITTAdNetDepend(iTTAdNetDepend);
                TncInstanceManager.getInstance().getTNCManager(this.mAid).initTnc(context, ProcessUtils.isMainProcess(context));
                if (ProcessUtils.isMessageProcess(context) || (!ProcessUtils.isMainProcess(context) && z)) {
                    TncInstanceManager.getInstance().getAppConfig(this.mAid, context).tryLoadLocalConfig();
                    TncInstanceManager.getInstance().getAppConfig(this.mAid, context).tryRefreshConfig();
                }
                if (ProcessUtils.isMainProcess(context)) {
                    TncInstanceManager.getInstance().getAppConfig(this.mAid, context).tryLoadLocalConfig();
                    TncInstanceManager.getInstance().getAppConfig(this.mAid, context).tryRefreshConfig();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
    }

    public NetClient(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        w.a b2 = new w.a().a(builder.connectTimeout, TimeUnit.MILLISECONDS).c(builder.writeTimeout, TimeUnit.MILLISECONDS).b(builder.readTimeout, TimeUnit.MILLISECONDS);
        if (builder.enableTNC) {
            TncHostInterceptor tncHostInterceptor = new TncHostInterceptor();
            this.tncHostInterceptor = tncHostInterceptor;
            b2.a(tncHostInterceptor);
        }
        this.okHttpClient = b2.a();
    }
}
