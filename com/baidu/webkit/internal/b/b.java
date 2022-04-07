package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public final class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new String[]{"market://", "http://market.android.com/search?q=", "https://market.android.com/search?q=", "http://market.android.com/details?id=", "https://market.android.com/details?id=", "http://play.google.com/store/search?q=", "https://play.google.com/store/search?q=", "http://play.google.com/store/apps/details?id=", "https://play.google.com/store/apps/details?id="};
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, str)) != null) {
            return invokeL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0152  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && a(str)) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                        String str2 = parseUri.getPackage();
                        if (str2 != null) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:".concat(String.valueOf(str2))));
                            intent.addCategory("android.intent.category.BROWSABLE");
                            g.a(context, intent);
                            return true;
                        }
                        String substring = str.substring(0, str.indexOf(":"));
                        View inflate = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("sailor_noapp_support_warnings", TtmlNode.TAG_LAYOUT, context.getPackageName()), (ViewGroup) null);
                        ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_header", "id", context.getPackageName()))).setText(context.getResources().getIdentifier("sailor_noapp_support_warning", EMABTest.TYPE_STRING, context.getPackageName()));
                        String str3 = context.getResources().getString(context.getResources().getIdentifier("zeus_popup_not_support_protocol_start", EMABTest.TYPE_STRING, context.getPackageName())) + substring;
                        int identifier = context.getResources().getIdentifier("zeus_popup_not_support_protocol_end", EMABTest.TYPE_STRING, context.getPackageName());
                        ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_text", "id", context.getPackageName()))).setText(str3 + context.getResources().getString(identifier));
                        AlertDialog show = new AlertDialog.Builder(context).setView(inflate).setPositiveButton(context.getResources().getIdentifier("sailor_common_ok", EMABTest.TYPE_STRING, context.getPackageName()), new DialogInterface.OnClickListener(this) { // from class: com.baidu.webkit.internal.b.b.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                                }
                            }
                        }).setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.webkit.internal.b.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // android.content.DialogInterface.OnCancelListener
                            public final void onCancel(DialogInterface dialogInterface) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                }
                            }
                        }).show();
                        show.setCanceledOnTouchOutside(true);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, show) { // from class: com.baidu.webkit.internal.b.b.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AlertDialog a;
                            public final /* synthetic */ b b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, show};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = show;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.a.dismiss();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                        return true;
                    }
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                        if (packageInfo.packageName.equals("com.baidu.appsearch") || packageInfo.packageName.equals(context.getPackageName())) {
                            parseUri.setPackage(packageInfo.packageName);
                            break;
                        }
                        while (r10.hasNext()) {
                        }
                    }
                    parseUri.setComponent(null);
                    try {
                        if (context instanceof Activity) {
                            if (((Activity) context).startActivityIfNeeded(parseUri, -1)) {
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        Log.e(Log.LOG_TAG, e.toString());
                    }
                } catch (URISyntaxException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str == null) {
                return false;
            }
            if (b(context, str)) {
                return true;
            }
            if (a(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                return g.a(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
