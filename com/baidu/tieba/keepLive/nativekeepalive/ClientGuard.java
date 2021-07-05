package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import android.os.Process;
import com.baidu.tieba.keepLive.nativekeepalive.IGuard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ClientGuard implements IGuardClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String DAEMON_PERMITTING_SP_FILENAME;
    public final String DAEMON_PERMITTING_SP_KEY;
    public BufferedReader mBufferedReader;
    public GuardConfigurations mConfigurations;
    public Context mContext;

    public ClientGuard(GuardConfigurations guardConfigurations) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {guardConfigurations};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DAEMON_PERMITTING_SP_FILENAME = "d_permit";
        this.DAEMON_PERMITTING_SP_KEY = "permitted";
        this.mConfigurations = guardConfigurations;
    }

    private String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
                this.mBufferedReader = bufferedReader;
                return bufferedReader.readLine();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private void initDaemon(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || this.mConfigurations == null) {
            return;
        }
        String processName = getProcessName();
        String packageName = context.getPackageName();
        if (processName.startsWith(this.mConfigurations.PERSISTENT_CONFIG.PROCESS_NAME)) {
            IGuard.Fetcher.fetchGuard().onPersistentCreate(context, this.mConfigurations);
        } else if (processName.startsWith(this.mConfigurations.DAEMON_ASSISTANT_CONFIG.PROCESS_NAME)) {
            IGuard.Fetcher.fetchGuard().onDaemonAssistantCreate(context, this.mConfigurations);
        } else {
            if (processName.startsWith(packageName + ":remote")) {
                IGuard.Fetcher.fetchGuard().onInitialization(context);
            }
        }
        releaseIO();
    }

    private void releaseIO() {
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (bufferedReader = this.mBufferedReader) == null) {
            return;
        }
        try {
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.mBufferedReader = null;
    }

    @Override // com.baidu.tieba.keepLive.nativekeepalive.IGuardClient
    public void onAttachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.mContext = context;
            initDaemon(context);
        }
    }
}
