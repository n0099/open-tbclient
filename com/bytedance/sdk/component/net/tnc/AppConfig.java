package com.bytedance.sdk.component.net.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetClient;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.GetExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.utils.Logger;
import com.bytedance.sdk.component.net.utils.NetworkUtils;
import com.bytedance.sdk.component.net.utils.ProcessUtils;
import com.bytedance.sdk.component.net.utils.WeakHandler;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AppConfig implements WeakHandler.IHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LAST_REFRESH_TIME = "last_refresh_time";
    public static final int MSG_CONFIG_ERROR = 102;
    public static final int MSG_CONFIG_OK = 101;
    public static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "AppConfig";
    public static AppConfig mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAid;
    public AtomicBoolean mConfigUpdating;
    public final Context mContext;
    public boolean mForceChanged;
    public volatile boolean mForceSwitch;
    public final WeakHandler mHandler;
    public final boolean mIsMainProcess;
    public long mLastRefreshTime;
    public long mLastTryRefreshTime;
    public boolean mLoading;
    public volatile boolean mLocalLoaded;
    public NetClient mNetClient;
    public ThreadPoolExecutor threadPoolExecutor;

    public AppConfig(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mForceSwitch = false;
        this.mForceChanged = true;
        this.mLoading = false;
        this.mLastRefreshTime = 0L;
        this.mLastTryRefreshTime = 0L;
        this.threadPoolExecutor = null;
        this.mConfigUpdating = new AtomicBoolean(false);
        this.mLocalLoaded = false;
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mContext = context;
        this.mIsMainProcess = z;
    }

    private void addTncExecutorParams(GetExecutor getExecutor) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, getExecutor) == null) || getExecutor == null) {
            return;
        }
        Address locationAdress = TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend() != null ? TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getLocationAdress(this.mContext) : null;
        if (locationAdress != null && locationAdress.hasLatitude() && locationAdress.hasLongitude()) {
            getExecutor.addParams("latitude", locationAdress.getLatitude() + "");
            getExecutor.addParams("longitude", locationAdress.getLongitude() + "");
            String locality = locationAdress.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                getExecutor.addParams("city", Uri.encode(locality));
            }
        }
        if (this.mForceSwitch) {
            getExecutor.addParams("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            getExecutor.addParams("abi", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend() != null) {
            getExecutor.addParams("aid", TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getAid() + "");
            getExecutor.addParams("device_platform", TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getPlatform());
            getExecutor.addParams("channel", TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getChannel());
            getExecutor.addParams("version_code", TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getVersionCode() + "");
            getExecutor.addParams("custom_info_1", TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getDid());
        }
    }

    private String buildUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "https://" + str + "/get_domains/v4/";
        }
        return (String) invokeL.objValue;
    }

    private boolean getDomainInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String[] configServers = getConfigServers();
            if (configServers != null && configServers.length != 0) {
                getDomainInternalNext(0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDomainInternalNext(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            String[] configServers = getConfigServers();
            if (configServers != null && configServers.length > i2) {
                String str = configServers[i2];
                if (TextUtils.isEmpty(str)) {
                    sendConfigUpdateMsg(102);
                    return;
                }
                try {
                    String buildUrl = buildUrl(str);
                    if (TextUtils.isEmpty(buildUrl)) {
                        sendConfigUpdateMsg(102);
                        return;
                    }
                    GetExecutor getExecutor = getNetClient().getGetExecutor();
                    getExecutor.setUrl(buildUrl);
                    addTncExecutorParams(getExecutor);
                    getExecutor.enqueue(new NetCallback(this, i2) { // from class: com.bytedance.sdk.component.net.tnc.AppConfig.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AppConfig this$0;
                        public final /* synthetic */ int val$index;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$index = i2;
                        }

                        @Override // com.bytedance.sdk.component.net.callback.NetCallback
                        public void onFailure(NetExecutor netExecutor, IOException iOException) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                                this.this$0.getDomainInternalNext(this.val$index + 1);
                            }
                        }

                        @Override // com.bytedance.sdk.component.net.callback.NetCallback
                        public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                            JSONObject jSONObject;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                                if (netResponse == null || !netResponse.isSuccess()) {
                                    this.this$0.getDomainInternalNext(this.val$index + 1);
                                    return;
                                }
                                String str2 = null;
                                try {
                                    jSONObject = new JSONObject(netResponse.getBody());
                                } catch (Exception unused) {
                                    jSONObject = null;
                                }
                                if (jSONObject == null) {
                                    this.this$0.getDomainInternalNext(this.val$index + 1);
                                    return;
                                }
                                try {
                                    str2 = jSONObject.getString("message");
                                } catch (Exception unused2) {
                                }
                                if (!"success".equals(str2)) {
                                    this.this$0.getDomainInternalNext(this.val$index + 1);
                                    return;
                                }
                                try {
                                    if (this.this$0.handleResponse(jSONObject)) {
                                        this.this$0.sendConfigUpdateMsg(101);
                                    } else {
                                        this.this$0.getDomainInternalNext(this.val$index + 1);
                                    }
                                } catch (Exception unused3) {
                                }
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    Logger.debug(TAG, "try app config exception: " + th);
                    return;
                }
            }
            sendConfigUpdateMsg(102);
        }
    }

    public static AppConfig getInstance(Context context) {
        InterceptResult invokeL;
        AppConfig appConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (AppConfig.class) {
                if (mInstance == null) {
                    mInstance = new AppConfig(context.getApplicationContext(), ProcessUtils.isMainProcess(context));
                }
                appConfig = mInstance;
            }
            return appConfig;
        }
        return (AppConfig) invokeL.objValue;
    }

    private NetClient getNetClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mNetClient == null) {
                this.mNetClient = new NetClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
            }
            return this.mNetClient;
        }
        return (NetClient) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleResponse(Object obj) throws Exception {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, obj)) == null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                jSONObject = new JSONObject(str);
                if (!"success".equals(jSONObject.getString("message"))) {
                    return false;
                }
            } else {
                jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
            }
            if (jSONObject == null) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            synchronized (this) {
                SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).edit();
                edit.putLong(KEY_LAST_REFRESH_TIME, System.currentTimeMillis());
                edit.apply();
            }
            if (TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler() != null) {
                TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler().handleConfigChanged(jSONObject2);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void onActivityResume(Context context) {
        AppConfig appConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, context) == null) || (appConfig = mInstance) == null) {
            return;
        }
        if (ProcessUtils.isMainProcess(context)) {
            appConfig.tryRefreshConfig(true);
        } else {
            appConfig.tryRefreshConfig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfigUpdateMsg(int i2) {
        WeakHandler weakHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65549, this, i2) == null) || (weakHandler = this.mHandler) == null) {
            return;
        }
        weakHandler.sendEmptyMessage(i2);
    }

    private void tryRefreshDomainConfig(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65550, this, z) == null) || this.mLoading) {
            return;
        }
        if (this.mForceChanged) {
            this.mForceChanged = false;
            this.mLastRefreshTime = 0L;
            this.mLastTryRefreshTime = 0L;
        }
        long j = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastRefreshTime <= j || currentTimeMillis - this.mLastTryRefreshTime <= com.baidu.searchbox.config.AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return;
        }
        boolean checkWifiAndGPRS = NetworkUtils.checkWifiAndGPRS(this.mContext);
        if (!this.mLocalLoaded || checkWifiAndGPRS) {
            doRefresh(checkWifiAndGPRS);
        }
    }

    public boolean doRefresh(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            Logger.debug(TNCManager.TAG, "doRefresh: updating state " + this.mConfigUpdating.get());
            if (!this.mConfigUpdating.compareAndSet(false, true)) {
                Logger.debug(TNCManager.TAG, "doRefresh, already running");
                return false;
            }
            if (z) {
                this.mLastTryRefreshTime = System.currentTimeMillis();
            }
            getThreadPoolExecutor().execute(new Runnable(this, z) { // from class: com.bytedance.sdk.component.net.tnc.AppConfig.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppConfig this$0;
                public final /* synthetic */ boolean val$hasNetwork;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$hasNetwork = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.updateConfig(this.val$hasNetwork);
                    }
                }
            });
            return true;
        }
        return invokeZ.booleanValue;
    }

    public String[] getConfigServers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] configServers = TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend() != null ? TncInstanceManager.getInstance().getTNCManager(this.mAid).getITTAdNetDepend().getConfigServers() : null;
            return (configServers == null || configServers.length <= 0) ? new String[0] : configServers;
        }
        return (String[]) invokeV.objValue;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.threadPoolExecutor == null) {
                synchronized (AppConfig.class) {
                    if (this.threadPoolExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        this.threadPoolExecutor = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return this.threadPoolExecutor;
        }
        return (ThreadPoolExecutor) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.utils.WeakHandler.IHandler
    public void handleMsg(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            int i2 = message.what;
            if (i2 == 101) {
                this.mLoading = false;
                this.mLastRefreshTime = System.currentTimeMillis();
                Logger.debug(TNCManager.TAG, "doRefresh, succ");
                if (this.mForceChanged) {
                    tryRefreshConfig();
                }
                this.mConfigUpdating.set(false);
            } else if (i2 != 102) {
            } else {
                this.mLoading = false;
                if (this.mForceChanged) {
                    tryRefreshConfig();
                }
                Logger.debug(TNCManager.TAG, "doRefresh, error");
                this.mConfigUpdating.set(false);
            }
        }
    }

    public void setForceSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z == this.mForceSwitch) {
            return;
        }
        this.mForceSwitch = z;
        this.mForceChanged = true;
        tryRefreshConfig();
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadPoolExecutor) == null) {
            this.threadPoolExecutor = threadPoolExecutor;
        }
    }

    public synchronized void tryLoadDomainConfig4OtherProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.mLastRefreshTime > 3600000) {
                    this.mLastRefreshTime = System.currentTimeMillis();
                    try {
                        if (TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler() != null) {
                            TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler().loadLocalConfigForOtherProcess();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public synchronized void tryLoadLocalConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.mLocalLoaded) {
                    return;
                }
                this.mLocalLoaded = true;
                long j = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getLong(KEY_LAST_REFRESH_TIME, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j > currentTimeMillis) {
                    j = currentTimeMillis;
                }
                this.mLastRefreshTime = j;
                if (TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler() != null) {
                    TncInstanceManager.getInstance().getTNCManager(this.mAid).getTNCConfigHandler().loadLocalConfig();
                }
            }
        }
    }

    public void tryLodeConfigInSubThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.mIsMainProcess) {
                tryLoadLocalConfig();
            } else {
                tryLoadDomainConfig4OtherProcess();
            }
        } catch (Throwable unused) {
        }
    }

    public void tryRefreshConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            tryRefreshConfig(false);
        }
    }

    public void updateConfig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            Logger.debug(TNCManager.TAG, "doRefresh, actual request");
            tryLoadLocalConfig();
            this.mLoading = true;
            if (!z) {
                this.mHandler.sendEmptyMessage(102);
                return;
            }
            try {
                getDomainInternal();
            } catch (Exception unused) {
                this.mConfigUpdating.set(false);
            }
        }
    }

    public synchronized void tryRefreshConfig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.mIsMainProcess) {
                    tryRefreshDomainConfig(z);
                } else if (this.mLastRefreshTime <= 0) {
                    try {
                        getThreadPoolExecutor().execute(new Runnable(this) { // from class: com.bytedance.sdk.component.net.tnc.AppConfig.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AppConfig this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.tryLoadDomainConfig4OtherProcess();
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public AppConfig(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mForceSwitch = false;
        this.mForceChanged = true;
        this.mLoading = false;
        this.mLastRefreshTime = 0L;
        this.mLastTryRefreshTime = 0L;
        this.threadPoolExecutor = null;
        this.mConfigUpdating = new AtomicBoolean(false);
        this.mLocalLoaded = false;
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mContext = context;
        this.mIsMainProcess = ProcessUtils.isMainProcess(context);
        this.mAid = i2;
    }
}
