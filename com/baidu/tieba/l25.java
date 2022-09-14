package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.au4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ DialogInterface.OnCancelListener c;

        public a(int i, Context context, DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = context;
            this.c = onCancelListener;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                l25.d(this.a, this.b);
                au4Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.c;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(au4Var.getDialog());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DialogInterface.OnCancelListener a;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onCancelListener;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.a;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(au4Var.getDialog());
                }
            }
        }
    }

    public static boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (i == 3 || i == 2) {
                return zl8.b(context, "com.tencent.mm");
            }
            if (i == 8 || i == 4) {
                return zl8.b(context, "com.tencent.mobileqq");
            }
            if (i == 6) {
                return zl8.b(context, "com.sina.weibo");
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static String c(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, context)) == null) {
            if (i == 3 || i == 2) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f040b), context.getString(R.string.obfuscated_res_0x7f0f15be));
            }
            if (i == 8 || i == 4) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f040b), context.getString(R.string.obfuscated_res_0x7f0f0f7f));
            }
            if (i == 6) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f040b), context.getString(R.string.obfuscated_res_0x7f0f11bd));
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    public static void d(int i, Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, context) == null) {
            if (i == 3 || i == 2) {
                if (!b(context, i)) {
                    BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f1187)).i();
                    return;
                }
                intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setComponent(componentName);
                context.startActivity(intent);
            } else if (i == 8 || i == 4) {
                if (!b(context, i)) {
                    BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f1169)).i();
                    return;
                }
                intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(intent);
            } else if (i != 6) {
                intent = null;
            } else if (!b(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f1178)).i();
                return;
            } else {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("sinaweibo://splash"));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            if (intent != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void e(ShareItem shareItem, Context context, int i, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, shareItem, context, i, onCancelListener) == null) || shareItem == null || TextUtils.isEmpty(shareItem.w) || TextUtils.isEmpty(shareItem.v) || !(context instanceof Activity)) {
            return;
        }
        ui.a(shareItem.C0);
        Activity activity = (Activity) context;
        au4 au4Var = new au4(activity);
        au4Var.setTitle(context.getString(R.string.obfuscated_res_0x7f0f040c));
        au4Var.setMessage(shareItem.C0);
        au4Var.setAutoNight(false);
        au4Var.setCancelable(true);
        au4Var.setTitleShowCenter(true);
        au4Var.setPositiveButton(c(i, context), new a(i, context, onCancelListener));
        au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(onCancelListener)).create(w9.a(activity));
        if (onCancelListener != null) {
            au4Var.setOnCalcelListener(onCancelListener);
        }
        au4Var.show();
    }
}
