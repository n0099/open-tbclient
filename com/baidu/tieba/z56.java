package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class z56 extends b66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean R;

    /* loaded from: classes6.dex */
    public class a implements of {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z56 a;

        /* renamed from: com.baidu.tieba.z56$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0480a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0480a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    try {
                        if (!StringUtils.isNull(this.a)) {
                            if (this.b.a.i.equals("source_from_virtual_image")) {
                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                if (skinType == 4) {
                                    str = "&skin=dart";
                                } else if (skinType == 1) {
                                    str = "&skin=night";
                                } else {
                                    str = "";
                                }
                                UrlManager.getInstance().dealOneLink(this.b.a.c, new String[]{this.a + str});
                            } else if (this.b.a.i.equals("source_from_theme")) {
                                UrlManager.getInstance().dealOneLink(this.b.a.c, new String[]{this.a});
                            }
                        }
                    } catch (Exception e) {
                        BdLog.e("openPageByUrl fail:" + e.toString());
                    }
                }
            }
        }

        public a(z56 z56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z56Var;
        }

        @Override // com.baidu.tieba.of
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.y;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.x;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.r;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.s;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            int dimensionPixelSize;
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0525, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09225c);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092250);
                if (!StringUtils.isNull(this.a.j.get("pop_params_key_img"))) {
                    Glide.with(this.a.c.getContext()).load(this.a.j.get("pop_params_key_img")).into(imageView);
                }
                if (!StringUtils.isNull(this.a.j.get("pop_params_key_link"))) {
                    Drawable drawable2 = this.a.c.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080804);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    textView.setCompoundDrawables(null, null, drawable2, null);
                }
                textView.setText(this.a.f);
                int i = this.a.J;
                if (i != 0) {
                    textView.setGravity(i);
                } else {
                    textView.setGravity(17);
                }
                int i2 = this.a.H;
                int i3 = R.color.CAM_X0101;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(textView, i2);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                }
                z56 z56Var = this.a;
                if (z56Var.I != 0) {
                    dimensionPixelSize = z56Var.c.getResources().getDimensionPixelSize(this.a.I);
                } else {
                    dimensionPixelSize = z56Var.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
                }
                textView.setTextSize(0, dimensionPixelSize);
                textView.setLines(this.a.C);
                if (this.a.G) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                if (StringUtils.isNull(this.a.j.get("pop_params_key_img"))) {
                    z56 z56Var2 = this.a;
                    int i4 = z56Var2.D;
                    if (i4 != 0) {
                        textView.setHeight(i4);
                    } else {
                        textView.setHeight(z56Var2.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                    }
                    int i5 = this.a.E;
                    if (i5 != 0) {
                        z56.N(textView, 0, i5);
                    }
                    int i6 = this.a.F;
                    if (i6 != 0) {
                        textView.setWidth(i6);
                    }
                    z56 z56Var3 = this.a;
                    textView.setPadding(z56Var3.t, z56Var3.u, z56Var3.v, z56Var3.w);
                }
                z56 z56Var4 = this.a;
                int i7 = z56Var4.K;
                if (i7 != 0) {
                    if (z56Var4.L) {
                        int i8 = z56Var4.H;
                        if (i8 != 0) {
                            i3 = i8;
                        }
                        drawable = WebPManager.getPureDrawable(this.a.K, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(i7);
                    }
                    int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g, g);
                    textView.setCompoundDrawablePadding(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, this.a.k);
                z56 z56Var5 = this.a;
                View.OnClickListener onClickListener = z56Var5.z;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                } else {
                    textView.setOnClickListener(new View$OnClickListenerC0480a(this, z56Var5.j.get("pop_params_key_link")));
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z56(TbPageContext tbPageContext, View view2, String str, HashMap<String, String> hashMap) {
        super(tbPageContext, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, str, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R = false;
        this.c = tbPageContext;
        this.d = view2;
        this.i = str;
        this.j = hashMap;
    }

    public static void N(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public of W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (of) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b66
    public void k() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qf qfVar = new qf();
            qfVar.k(this.d);
            qfVar.c(0);
            qfVar.j(true);
            qfVar.i(true);
            qfVar.a(W());
            qfVar.d(this.M);
            pf b = qfVar.b();
            this.b = b;
            b.k(false);
            this.b.l(this.B);
            this.b.n(this.c.getPageActivity(), this.q);
            this.e = true;
            j();
            this.h = true;
            if (!this.R && (handler = this.a) != null) {
                handler.postDelayed(this.Q, this.p);
            }
        }
    }
}
