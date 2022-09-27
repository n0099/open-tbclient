package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ux4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public Context b;
    public View c;
    public TextView d;
    public ImageView e;
    public Toast f;
    public Handler g;
    public Runnable h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux4 a;

        public a(ux4 ux4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.cancel();
                }
                if (this.a.c == null || !(this.a.c.getParent() instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) this.a.c.getParent()).removeView(this.a.c);
            }
        }
    }

    public ux4() {
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
        this.a = 3000L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = new a(this);
        this.b = TbadkCoreApplication.getInst().getContext();
        this.g = new Handler();
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d03c7, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092210);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092203);
            this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(this.b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            this.d.setText(charSequence);
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080aca);
            e(this.c);
        }
    }

    public void d(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d03c7, (ViewGroup) null);
            this.c = inflate;
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092210);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092203);
            this.c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(this.b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            this.d.setText(charSequence);
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080acb);
            e(this.c);
        }
    }

    public void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.g.removeCallbacks(this.h);
            if (this.f == null) {
                this.f = new Toast(this.b);
            }
            this.g.postDelayed(this.h, this.a);
            this.f.setView(view2);
            this.f.setDuration(1);
            this.f.setGravity(17, 0, 0);
            this.f.show();
        }
    }
}
