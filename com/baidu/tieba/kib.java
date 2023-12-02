package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public LinearLayout b;
    public TBAlertBuilder c;
    public f d;
    public boolean e;

    /* loaded from: classes7.dex */
    public interface f {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ kib b;

        public a(kib kibVar, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kibVar, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kibVar;
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ kib b;

        public b(kib kibVar, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kibVar, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kibVar;
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public c(kib kibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kib a;

        public d(kib kibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kibVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d != null) {
                    this.a.d.a(false);
                }
                this.a.i();
                this.a.c.dismiss();
                jib.a(1, this.a.e ? 1 : 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kib a;

        public e(kib kibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kibVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d != null) {
                    this.a.d.a(true);
                }
                this.a.i();
                this.a.c.dismiss();
                jib.a(2, this.a.e ? 1 : 0);
            }
        }
    }

    public kib(Activity activity, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.a = activity;
        this.d = fVar;
        g();
        h();
    }

    public final void f(ImageView imageView) {
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageView) == null) {
            boolean z = !this.e;
            this.e = z;
            if (z) {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(maskDrawable);
        }
    }

    public final void g() {
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.b = linearLayout;
            linearLayout.setOrientation(0);
            this.b.setGravity(16);
            this.b.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), 0);
            ImageView imageView = new ImageView(this.a);
            if (this.e) {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(maskDrawable);
            this.b.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds39), UtilHelper.getDimenPixelSize(R.dimen.tbds39)));
            TextView textView = new TextView(this.a);
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0438));
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, 0);
            EMManager.from(textView).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            this.b.addView(textView);
            textView.setOnClickListener(new a(this, imageView));
            imageView.setOnClickListener(new b(this, imageView));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new TBAlertBuilder(this.a).setTitleStr(this.a.getString(R.string.obfuscated_res_0x7f0f043a)).setDescStr(this.a.getString(R.string.obfuscated_res_0x7f0f0437)).setDescGravity(3).setDescLightStyle(true).setCancelable(false).setCustomContentView(this.b).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.obfuscated_res_0x7f0f0436), TBAlertConfig.OperateBtnStyle.SECONDARY, new d(this)), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.obfuscated_res_0x7f0f0439), TBAlertConfig.OperateBtnStyle.MAIN, new e(this))).setOnDismissListener(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.e) {
            SharedPrefHelper.getInstance().putLong("key_check_is_question_thread_time", System.currentTimeMillis());
        }
    }

    public void j() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tBAlertBuilder = this.c) != null) {
            tBAlertBuilder.show();
            jib.b();
        }
    }
}
