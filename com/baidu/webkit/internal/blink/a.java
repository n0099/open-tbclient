package com.baidu.webkit.internal.blink;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZipUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebKitFactory.WebkitInstallListener f27563a;

    /* renamed from: b  reason: collision with root package name */
    public EngineManager f27564b;

    /* renamed from: c  reason: collision with root package name */
    public int f27565c;

    public a(EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {engineManager, webkitInstallListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27564b = engineManager;
        this.f27563a = webkitInstallListener;
        this.f27565c = 13;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String d2 = d();
            if (d2 == null) {
                return false;
            }
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            for (String str : GlobalConstants.LIB_ZEUS_SO) {
                String str2 = downloadLibPath + str;
                if (new File(str2).exists() && !com.baidu.webkit.internal.utils.a.a(str2)) {
                    return false;
                }
            }
            if (!UtilsBlink.createDownloadLibPath(WebKitFactory.getContext())) {
                Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install create path failed");
                return false;
            }
            boolean unZip = ZipUtils.getInstance().unZip(WebKitFactory.getContext(), d2, downloadLibPath, false);
            if (!unZip) {
                Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install unzip failed");
                this.f27565c = 6;
            }
            return unZip;
        }
        return invokeV.booleanValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            if (!new File(d2).exists()) {
                Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installSync file not exist");
                return false;
            }
            EngineManager engineManager = this.f27564b;
            if (engineManager != null) {
                engineManager.onInstallStart(d2);
            }
            WebKitFactory.WebkitInstallListener webkitInstallListener = this.f27563a;
            if (webkitInstallListener != null) {
                webkitInstallListener.onInstallStart();
            }
            if (!c()) {
                Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install init failed");
            }
            boolean e2 = e();
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.install result=".concat(String.valueOf(e2)));
            if (e2) {
                this.f27565c = 0;
                ZeusWebViewPreloadClass.getInstance().deleteSavingClassesFile();
            }
            WebKitFactory.WebkitInstallListener webkitInstallListener2 = this.f27563a;
            if (webkitInstallListener2 != null) {
                int i2 = this.f27565c;
                if (i2 == 0) {
                    this.f27563a.onInstallFinish(this.f27565c, UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()));
                } else {
                    webkitInstallListener2.onInstallFinish(i2, null);
                }
            }
            EngineManager engineManager2 = this.f27564b;
            if (engineManager2 != null) {
                engineManager2.onInstallFinish(this.f27565c == 0);
            }
            return e2;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync");
            if (this.f27564b == null || WebKitFactory.getContext() == null) {
                WebKitFactory.WebkitInstallListener webkitInstallListener = this.f27563a;
                if (webkitInstallListener != null) {
                    webkitInstallListener.onInstallFinish(13, null);
                    return;
                }
                return;
            }
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            if (!new File(d2).exists()) {
                Log.i(EngineManager.LOG_TAG, "BlinkEngineInstaller.installAsync file not exist");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("T7@ZeusInstaller");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable(this, handlerThread) { // from class: com.baidu.webkit.internal.blink.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HandlerThread f27566a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f27567b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, handlerThread};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27567b = this;
                    this.f27566a = handlerThread;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27567b.a();
                        this.f27566a.quit();
                    }
                }
            });
        }
    }

    public abstract boolean c();

    public abstract String d();
}
