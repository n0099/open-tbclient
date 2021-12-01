package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import c.a.r0.s;
import com.baidu.adp.base.BdBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class AsInstallService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AS_INSTALL_RECEIVING_DURATION_MILLS = 120000;
    public static final String SCHEME_PACKAGE_ADDED = "package";
    public static boolean sIsReceiving;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public b mReceiver;
    public Runnable mStopReceivingRunnable;
    public VersionData mVersionData;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AsInstallService f48882e;

        public a(AsInstallService asInstallService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asInstallService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48882e = asInstallService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48882e.stopSelf();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AsInstallService this$0;

        public b(AsInstallService asInstallService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asInstallService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = asInstallService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart) || !"com.baidu.appsearch".equals(schemeSpecificPart) || this.this$0.mVersionData == null) {
                    return;
                }
                s.b(context, this.this$0.mVersionData);
                TiebaStatic.log(TbadkCoreStatisticKey.INVOKE_AS);
            }
        }

        public /* synthetic */ b(AsInstallService asInstallService, a aVar) {
            this(asInstallService);
        }
    }

    public AsInstallService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mReceiver = new b(this, null);
            this.mHandler = new Handler();
            this.mStopReceivingRunnable = new a(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            unregisterReceiver(this.mReceiver);
            this.mHandler.removeCallbacks(this.mStopReceivingRunnable);
            this.mReceiver = null;
            this.mHandler = null;
            this.mStopReceivingRunnable = null;
            sIsReceiving = false;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, intent, i2) == null) {
            super.onStart(intent, i2);
            if (sIsReceiving) {
                return;
            }
            sIsReceiving = true;
            if (intent != null) {
                this.mVersionData = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
            }
            this.mReceiver = new b(this, null);
            IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme("package");
            registerReceiver(this.mReceiver, intentFilter);
            Handler handler = new Handler();
            this.mHandler = handler;
            handler.postDelayed(this.mStopReceivingRunnable, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
        }
    }
}
