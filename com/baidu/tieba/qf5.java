package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.y45;
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
    public class a implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                qf5.d(this.a, this.b);
                y45Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.c;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(y45Var.getDialog());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.a;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(y45Var.getDialog());
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
                        return xga.b(context, "com.sina.weibo");
                    }
                    return true;
                }
                return xga.b(context, "com.tencent.mobileqq");
            }
            return xga.b(context, "com.tencent.mm");
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
                        return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f141b));
                    }
                    return null;
                }
                return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f11c1));
            }
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.obfuscated_res_0x7f0f18a8));
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
                            BdToast.makeText(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).show();
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
                    BdToast.makeText(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).show();
                    return;
                } else {
                    intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent);
                }
            } else if (!b(context, i)) {
                BdToast.makeText(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).show();
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
        if ((interceptable != null && interceptable.invokeLLIL(65541, null, shareItem, context, i, onCancelListener) != null) || shareItem == null || TextUtils.isEmpty(shareItem.content) || TextUtils.isEmpty(shareItem.title) || !(context instanceof Activity)) {
            return;
        }
        AndroidUtils.copyToClipboard(shareItem.cmdContent);
        Activity activity = (Activity) context;
        y45 y45Var = new y45(activity);
        y45Var.setTitle(context.getString(R.string.command_share_tips));
        y45Var.setMessage(shareItem.cmdContent);
        y45Var.setAutoNight(false);
        y45Var.setCancelable(true);
        y45Var.setTitleShowCenter(true);
        y45Var.setPositiveButton(c(i, context), new a(i, context, onCancelListener));
        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(onCancelListener)).create(m9.a(activity));
        if (onCancelListener != null) {
            y45Var.setOnCalcelListener(onCancelListener);
        }
        y45Var.show();
    }
}
