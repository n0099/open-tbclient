package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.loader.LoaderHead;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.pm.PatchInstallInfo;
import com.baidu.titan.sdk.pm.PatchManager;
import com.baidu.titan.sdk.pm.PatchMetaInfo;
import com.baidu.titan.sdk.pm.TitanPaths;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class jn {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements PatchManager.PatchInstallObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn a;
        public final /* synthetic */ PackageInfo b;
        public final /* synthetic */ boolean c;

        public a(fn fnVar, PackageInfo packageInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fnVar, packageInfo, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fnVar;
            this.b = packageInfo;
            this.c = z;
        }

        @Override // com.baidu.titan.sdk.pm.PatchManager.PatchInstallObserver
        public void onPatchInstalled(int i, Bundle bundle) {
            int i2;
            LoaderHead createFromJson;
            PatchMetaInfo createFromPatch;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bundle) == null) {
                if (i != 0 && i != 1) {
                    i2 = -1;
                } else {
                    i2 = 0;
                }
                String str = "install-resut:" + i;
                fn fnVar = this.a;
                if (fnVar != null) {
                    fnVar.onResult(this.b.packageName, i2, str);
                }
                Log.d(TitanDownloadService.TAG, "patch install result code = " + i2);
                if (i2 == 0) {
                    jn.c(this.b);
                }
                if (!this.c) {
                    int loadState = LoaderManager.getInstance().getLoadState();
                    if (loadState == -4 || loadState == -1) {
                        File headFile = TitanPaths.getHeadFile();
                        if (headFile.exists() && (createFromJson = LoaderHead.createFromJson(Files.getFileStringContent(headFile))) != null && (createFromPatch = PatchMetaInfo.createFromPatch(new PatchInstallInfo(TitanPaths.getPatchDir(createFromJson.patchHash)).getPatchFile())) != null && createFromPatch.loadPolicy == 1) {
                            LoaderManager.getInstance().loadInTime();
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308457, "Lcom/baidu/tieba/jn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308457, "Lcom/baidu/tieba/jn;");
                return;
            }
        }
        a = zm.a;
    }

    public static void b(Context context, fn fnVar, PackageInfo packageInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, fnVar, packageInfo, Boolean.valueOf(z)}) == null) {
            if (a) {
                Log.d(TitanDownloadService.TAG, "install file: " + packageInfo.filePath);
            }
            PatchManager.getInstance().installPatch(Uri.fromFile(new File(packageInfo.filePath)), null, new a(fnVar, packageInfo, z));
        }
    }

    public static void c(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, packageInfo) == null) {
            hn d = hn.d();
            if (packageInfo != null) {
                long j = packageInfo.updateVersion;
                if (j != 0) {
                    d.j(j);
                    Context appContext = AppRuntime.getAppContext();
                    if (appContext != null) {
                        try {
                            android.content.pm.PackageInfo packageInfo2 = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
                            if (packageInfo2 != null) {
                                d.h(packageInfo2.versionCode);
                            }
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                int i = packageInfo.errNo;
                if (i == 0 || i == -2) {
                    d.i(System.currentTimeMillis());
                }
            }
            d.l();
        }
    }
}
