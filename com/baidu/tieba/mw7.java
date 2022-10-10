package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.tieba.sw7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class mw7<V extends sw7, D extends IBaseDialogData> implements rw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;
    public TbPageContext b;
    public Context c;
    public DialogInterface.OnKeyListener d;
    public DialogInterface.OnCancelListener e;
    public int f;
    public boolean g;
    public V h;

    /* loaded from: classes5.dex */
    public class a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public a(mw7 mw7Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw7Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public mw7(TbPageContext tbPageContext, V v, D d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, v, d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = -1;
        this.g = false;
        this.b = tbPageContext;
        this.c = tbPageContext.getPageActivity();
        this.h = v;
        d(d);
    }

    public void d(D d) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d) == null) || (v = this.h) == null) {
            return;
        }
        v.b(d);
    }

    @Override // com.baidu.tieba.rw7
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.a) == null) {
            return;
        }
        ih.a(alertDialog, this.b.getPageActivity());
    }

    @Override // com.baidu.tieba.rw7
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                ih.i(alertDialog, this.b.getPageActivity());
                return;
            }
            if (this.g) {
                this.a = new AlertDialog.Builder(this.c, R.style.obfuscated_res_0x7f1003ee).create();
            } else {
                this.a = new AlertDialog.Builder(this.c).create();
            }
            this.a.setCanceledOnTouchOutside(c());
            this.a.setCancelable(b());
            this.a.setOnKeyListener(this.d);
            DialogInterface.OnCancelListener onCancelListener = this.e;
            if (onCancelListener != null) {
                this.a.setOnCancelListener(onCancelListener);
            }
            ih.i(this.a, this.b.getPageActivity());
            if (this.a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.a.getWindow();
            if (this.f == -1) {
                this.f = 17;
            }
            window.setGravity(this.f);
            window.setBackgroundDrawableResource(R.drawable.obfuscated_res_0x7f081241);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics r = ej.r(this.b.getPageActivity());
            if (r != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.c) == 2) {
                    attributes.width = r.heightPixels - (a2 * 2);
                } else {
                    attributes.width = r.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.h.getViewGroup(), false, new a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}
