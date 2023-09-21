package com.baidu.tieba.util;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.dz4;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.filedownloader.logs.DownloaderLog;
import com.baidu.tieba.filedownloader.utils.PermissionUtil;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rm0;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.tieba.vfa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/tieba/util/AdApkInstallHelper;", "", "()V", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AdApkInstallHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1959202220, "Lcom/baidu/tieba/util/AdApkInstallHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1959202220, "Lcom/baidu/tieba/util/AdApkInstallHelper;");
                return;
            }
        }
        a = new Companion(null);
    }

    @JvmStatic
    public static final void a(String str, DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, downloadData) == null) {
            a.c(str, downloadData);
        }
    }

    @JvmStatic
    public static final void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, intent) == null) {
            a.d(intent);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/util/AdApkInstallHelper$Companion;", "", "()V", "TAG", "", "adApkStatistic", "", "statisticKey", "downloadDataId", "pkgName", "installApp", "path", "downloadData", "Lcom/baidu/tbadk/download/DownloadData;", "installSuccess", "intent", "Landroid/content/Intent;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* loaded from: classes8.dex */
        public static final class a extends BdAsyncTask<String, Integer, Long> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public a(String str, String str2, String str3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, str2, str3};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Long doInBackground(String... params) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                    Intrinsics.checkNotNullParameter(params, "params");
                    vfa h = new TbDownloadManager().m().h(this.a, this.b);
                    ItemData itemData = new ItemData();
                    itemData.parseJson(h.c());
                    dz4.b().a(this.c, String.valueOf(h.p()), itemData.mTitle, h.d(), itemData.mTbFileDownloaderType);
                    return 0L;
                }
                return (Long) invokeL.objValue;
            }
        }

        public Companion() {
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

        public final void b(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                a aVar = new a(str2, str3, str);
                aVar.setPriority(3);
                aVar.execute(new String[0]);
            }
        }

        @JvmStatic
        public final void c(final String str, final DownloadData downloadData) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, downloadData) == null) {
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("AdApkInstallHelper", "下载器：函数 installApp，path is：" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + downloadData);
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return;
                }
                PermissionUtil.a.b(new Function0<Unit>(str, downloadData) { // from class: com.baidu.tieba.util.AdApkInstallHelper$Companion$installApp$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ DownloadData $downloadData;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $path;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, downloadData};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$path = str;
                        this.$downloadData = downloadData;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        boolean z2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            if (!new File(this.$path).exists()) {
                                DownloaderLog.getInstance().i("AdApkInstallHelper", "下载器：函数 installApp，文件不存在");
                                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                                Intrinsics.checkNotNullExpressionValue(string, "getInst().app.getString(R.string.file_not_exist)");
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), string);
                                return;
                            }
                            DownloaderLog.getInstance().i("AdApkInstallHelper", "下载器：函数 installApp，开始安装");
                            rm0.d(new File(this.$path));
                            DownloadData downloadData2 = this.$downloadData;
                            if (downloadData2 != null) {
                                String id = downloadData2.getId();
                                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    AdApkInstallHelper.Companion companion = AdApkInstallHelper.a;
                                    String id2 = downloadData2.getId();
                                    Intrinsics.checkNotNullExpressionValue(id2, "it.id");
                                    companion.b(TbadkCoreStatisticKey.KEY_H5_INSTALL_APK, id2, "");
                                }
                            }
                        }
                    }
                });
            }
        }

        @JvmStatic
        public final void d(Intent intent) {
            String str;
            Uri data;
            String schemeSpecificPart;
            Uri data2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
                TbLog downloaderLog = DownloaderLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("下载器：函数 installSuccess，安装完成 schemeSpecificPart is: ");
                if (intent != null && (data2 = intent.getData()) != null) {
                    str = data2.getSchemeSpecificPart();
                } else {
                    str = null;
                }
                sb.append(str);
                downloaderLog.i("AdApkInstallHelper", sb.toString());
                if (intent != null && (data = intent.getData()) != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null && (!StringsKt__StringsJVMKt.isBlank(schemeSpecificPart))) {
                    AdApkInstallHelper.a.b(TbadkCoreStatisticKey.INSTALL_APK_COMPLETION, "", schemeSpecificPart);
                }
            }
        }
    }
}
