package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.g55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g55.e {
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

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                qf5.d(this.a, this.b);
                g55Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.c;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(g55Var.getDialog());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements g55.e {
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

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                g55Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.a;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(g55Var.getDialog());
                }
            }
        }
    }

    public static void e(int i, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, context) != null) || context == null) {
            return;
        }
        d(i, context);
    }

    public static boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (i != 3 && i != 2) {
                if (i != 8 && i != 4) {
                    if (i == 6) {
                        return r3a.b(context, "com.sina.weibo");
                    }
                    return true;
                }
                return r3a.b(context, "com.tencent.mobileqq");
            }
            return r3a.b(context, "com.tencent.mm");
        }
        return invokeLI.booleanValue;
    }

    public static String c(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, context)) == null) {
            if (i != 3 && i != 2) {
                if (i != 8 && i != 4) {
                    if (i == 6) {
                        return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f13db));
                    }
                    return null;
                }
                return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f1188));
            }
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f1862));
        }
        return (String) invokeIL.objValue;
    }

    public static void d(int i, Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, context) == null) {
            if (i != 3 && i != 2) {
                if (i != 8 && i != 4) {
                    if (i == 6) {
                        if (!b(context, i)) {
                            BdToast.b(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).q();
                            return;
                        }
                        intent = new Intent();
                        intent.setAction(IntentConstants.ACTION_BOX_BROWSER);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse("sinaweibo://splash"));
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    } else {
                        intent = null;
                    }
                } else if (!b(context, i)) {
                    BdToast.b(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).q();
                    return;
                } else {
                    intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent);
                }
            } else if (!b(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).q();
                return;
            } else {
                intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setComponent(componentName);
                context.startActivity(intent);
            }
            if (intent != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void f(ShareItem shareItem, Context context, int i, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65541, null, shareItem, context, i, onCancelListener) != null) || shareItem == null || TextUtils.isEmpty(shareItem.w) || TextUtils.isEmpty(shareItem.v) || !(context instanceof Activity)) {
            return;
        }
        ni.a(shareItem.E0);
        Activity activity = (Activity) context;
        g55 g55Var = new g55(activity);
        g55Var.setTitle(context.getString(R.string.command_share_tips));
        g55Var.setMessage(shareItem.E0);
        g55Var.setAutoNight(false);
        g55Var.setCancelable(true);
        g55Var.setTitleShowCenter(true);
        g55Var.setPositiveButton(c(i, context), new a(i, context, onCancelListener));
        g55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cc, new b(onCancelListener)).create(r9.a(activity));
        if (onCancelListener != null) {
            g55Var.setOnCalcelListener(onCancelListener);
        }
        g55Var.show();
    }
}
