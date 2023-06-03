package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Activity a;
    public AlertDialog b;
    public boolean c;
    public boolean d;
    public String e;

    public t95(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = true;
        this.a = activity;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.a).create();
            this.b = create;
            GreyUtil.grey(create);
            yg.i(this.b, this.a);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.small_blue_progress_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!TextUtils.isEmpty(this.e)) {
                textView.setText(this.e);
            }
            this.b.setCancelable(this.d);
            this.b.setCanceledOnTouchOutside(this.d);
            Window window = this.b.getWindow();
            window.setContentView(inflate);
            if (!this.c) {
                window.setDimAmount(0.0f);
            }
        }
    }

    public void b() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.b) != null) {
            alertDialog.dismiss();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b == null) {
                a();
            }
            this.b.show();
        }
    }

    public t95 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.c = z;
            return this;
        }
        return (t95) invokeZ.objValue;
    }

    public t95 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (t95) invokeL.objValue;
    }
}
