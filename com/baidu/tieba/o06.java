package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tieba.ad.download.rectify.DownloadRectifyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Activity b;

        public a(AlertDialog alertDialog, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                o06.a(this.a, this.b);
            }
        }
    }

    public static final boolean a(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !b(activity.getWindow().getDecorView())) {
                return false;
            }
            dialog.dismiss();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean b(View view2) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 != null && (windowToken = view2.getWindowToken()) != null) {
                try {
                    if (windowToken.isBinderAlive()) {
                        if (windowToken.pingBinder()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean c(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing()) {
                return false;
            }
            if (activity.getWindow() != null && !activity.getWindow().isActive()) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (activity.getWindow() != null && b(activity.getWindow().getDecorView())) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Dialog d(@NonNull n06 n06Var, @NonNull View view2, @NonNull Activity activity, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnShowListener onShowListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, n06Var, view2, activity, onDismissListener, onShowListener)) == null) {
            AlertDialog create = new AlertDialog.Builder(activity, R.style.obfuscated_res_0x7f100108).create();
            GreyUtil.grey(create);
            create.setCanceledOnTouchOutside(true);
            create.setOnDismissListener(onDismissListener);
            create.setOnShowListener(onShowListener);
            DownloadRectifyView downloadRectifyView = new DownloadRectifyView(activity);
            downloadRectifyView.a(n06Var);
            downloadRectifyView.setDownloadView(view2);
            downloadRectifyView.setOnCloseClickListener(new a(create, activity));
            c(create, activity);
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(downloadRectifyView);
            }
            return create;
        }
        return (Dialog) invokeLLLLL.objValue;
    }
}
