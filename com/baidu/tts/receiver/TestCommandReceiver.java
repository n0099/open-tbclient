package com.baidu.tts.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.k2;
import com.baidu.tts.w0;
/* loaded from: classes9.dex */
public class TestCommandReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int b = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final TestCommandReceiver a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-950233813, "Lcom/baidu/tts/receiver/TestCommandReceiver$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-950233813, "Lcom/baidu/tts/receiver/TestCommandReceiver$b;");
                    return;
                }
            }
            a = new TestCommandReceiver(null);
        }
    }

    public TestCommandReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public /* synthetic */ TestCommandReceiver(a aVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            LoggerProxy.d("TestCommandReceiver", "action = " + action);
            if (TextUtils.equals(action, "baidu.tts.action.log.SAVE_AUDIO")) {
                this.a = intent.getBooleanExtra("isNeedSave", false);
            } else if (TextUtils.equals(action, "baidu.tts.action.log.SAVE_OFFLINE")) {
                int intExtra = intent.getIntExtra("ettsLogLevel", 0);
                boolean booleanExtra = intent.getBooleanExtra("isSaveToFile", false);
                LoggerProxy.setNativeLogLevel(6);
                w0.a("/sdcard/bds-tts/");
                StringBuilder sb = new StringBuilder();
                if (booleanExtra) {
                    sb.append("FPRINTF:");
                    sb.append(intExtra);
                    sb.append(":");
                    sb.append("/sdcard/bds-tts/");
                    sb.append("bdtts_engine.log");
                } else {
                    sb.append("PRINTF:");
                    sb.append(intExtra);
                }
                LoggerProxy.d("TestCommandReceiver", "path: " + sb.toString());
                LoggerProxy.saveNativeLogFile(sb.toString());
                String engineInfo = SynthesizerTool.getEngineInfo();
                LoggerProxy.d("TestCommandReceiver", "offline-engineInfo: " + engineInfo);
            } else if (TextUtils.equals(action, "baidu.tts.action.log.SAVE_SDK")) {
                if (intent.getBooleanExtra("isNeedSave", false)) {
                    LoggerProxy.setModeDevelop();
                } else {
                    LoggerProxy.setModeRelease();
                }
            } else if (TextUtils.equals(action, "baidu.tts.action.test.PACKAGE_NAME")) {
                String stringExtra = intent.getStringExtra("packageName");
                LoggerProxy.d("TestCommandReceiver", "packageName = " + stringExtra);
                k2.d = stringExtra;
            }
        }
    }
}
