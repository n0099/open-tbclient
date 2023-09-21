package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tbclient.ApkDetail;
/* loaded from: classes6.dex */
public final class lf7 {
    public static /* synthetic */ Interceptable $ic;
    public static final lf7 a;
    public static final String b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947941036, "Lcom/baidu/tieba/lf7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947941036, "Lcom/baidu/tieba/lf7;");
                return;
            }
        }
        a = new lf7();
        String string = TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_name);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…apk_unknown_default_name)");
        b = string;
        String string2 = TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_tag);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.st…_apk_unknown_default_tag)");
        c = string2;
        String string3 = TbadkCoreApplication.getInst().getString(R.string.download_apk_unknown_default_content);
        Intrinsics.checkNotNullExpressionValue(string3, "getInst().getString(R.st…_unknown_default_content)");
        d = string3;
    }

    public lf7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final DownloadData a(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadData)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            String filename = s61.e(downloadData.getUrl(), "apk", "application/vnd.android.package-archive");
            if ("apk".equals(s61.c(filename))) {
                Intrinsics.checkNotNullExpressionValue(filename, "filename");
                filename = StringsKt__StringsKt.substringBefore$default(filename, IStringUtil.EXTENSION_SEPARATOR + "apk", (String) null, 2, (Object) null);
            }
            lf7 lf7Var = a;
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            String c2 = lf7Var.c(downloadData, filename);
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            b(downloadData, c2, filename, filename);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final DownloadData b(DownloadData downloadData, String defaultId, String defaultName, String defaultPkgName) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, downloadData, defaultId, defaultName, defaultPkgName)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            Intrinsics.checkNotNullParameter(defaultId, "defaultId");
            Intrinsics.checkNotNullParameter(defaultName, "defaultName");
            Intrinsics.checkNotNullParameter(defaultPkgName, "defaultPkgName");
            String id = downloadData.getId();
            if (id != null && id.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (defaultId.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    downloadData.setId(defaultId);
                }
            }
            String name = downloadData.getName();
            if (name != null && name.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (defaultName.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    downloadData.setName(defaultName);
                }
            }
            String app_icon = downloadData.getApp_icon();
            if (app_icon != null && app_icon.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                downloadData.setApp_icon("https://tieba-ares.cdn.bcebos.com/mis/2023-8/1691390026104/24877895ee7a.png");
            }
            if (downloadData.getApkDownloadData() == null) {
                if (defaultPkgName.length() == 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (!z9) {
                    downloadData.setApkDownloadData(new ApkDownloadData());
                    downloadData.getApkDownloadData().setPackageName(defaultPkgName);
                    if (downloadData.getItemData() != null) {
                        downloadData.setItemData(new ItemData());
                        ItemData itemData = downloadData.getItemData();
                        itemData.mTitle = b;
                        itemData.mIconUrl = "https://tieba-ares.cdn.bcebos.com/mis/2023-8/1691390026104/24877895ee7a.png";
                        itemData.mTags = CollectionsKt__CollectionsKt.arrayListOf(c);
                        ApkDetail.Builder builder = new ApkDetail.Builder();
                        builder.developer = d;
                        itemData.apkDetail = builder.build(true);
                        itemData.fileType = "app";
                        itemData.buttonLinkType = 1;
                    } else {
                        String str = downloadData.getItemData().mTitle;
                        if (str != null && str.length() != 0) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z6) {
                            downloadData.getItemData().mTitle = b;
                        } else {
                            String str2 = downloadData.getItemData().mIconUrl;
                            if (str2 != null && str2.length() != 0) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            if (z7) {
                                downloadData.getItemData().mIconUrl = "https://tieba-ares.cdn.bcebos.com/mis/2023-8/1691390026104/24877895ee7a.png";
                            } else {
                                List<String> list = downloadData.getItemData().mTags;
                                if (list != null && !list.isEmpty()) {
                                    z8 = false;
                                } else {
                                    z8 = true;
                                }
                                if (z8) {
                                    downloadData.getItemData().mTags = CollectionsKt__CollectionsKt.arrayListOf(c);
                                } else if (downloadData.getItemData().apkDetail == null) {
                                    ApkDetail.Builder builder2 = new ApkDetail.Builder();
                                    builder2.developer = d;
                                    downloadData.getItemData().apkDetail = builder2.build(true);
                                }
                            }
                        }
                    }
                    return downloadData;
                }
            }
            String packageName = downloadData.getApkDownloadData().getPackageName();
            if (packageName != null && packageName.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                if (defaultPkgName.length() == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    downloadData.getApkDownloadData().setPackageName(defaultPkgName);
                }
            }
            if (downloadData.getItemData() != null) {
            }
            return downloadData;
        }
        return (DownloadData) invokeLLLL.objValue;
    }

    @JvmStatic
    public static final void d(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            yy6 yy6Var = new yy6();
            yy6Var.a = data.getItemData();
            yy6Var.b = data.getSource();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921819, yy6Var));
        }
    }

    public final String c(DownloadData downloadData, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, downloadData, str)) == null) {
            if (downloadData.getItemData() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(downloadData.getItemData().pkgName);
                sb.append(".v");
                ApkDetail apkDetail = downloadData.getItemData().apkDetail;
                if (apkDetail != null) {
                    str2 = apkDetail.version;
                } else {
                    str2 = null;
                }
                sb.append(str2);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}
