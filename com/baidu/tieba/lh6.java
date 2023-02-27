package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
/* loaded from: classes5.dex */
public class lh6 extends nh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;

    /* loaded from: classes5.dex */
    public class a implements uf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh6 a;

        /* renamed from: com.baidu.tieba.lh6$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0325a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0325a(a aVar, String str) {
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
                            if (this.b.a.h.equals("source_from_virtual_image")) {
                                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    str = "&skin=dark";
                                } else {
                                    str = "";
                                }
                                UrlManager.getInstance().dealOneLink(this.b.a.b, new String[]{this.a + str});
                            } else if (this.b.a.h.equals("source_from_theme")) {
                                UrlManager.getInstance().dealOneLink(this.b.a.b, new String[]{this.a});
                            }
                        }
                    } catch (Exception e) {
                        BdLog.e("openPageByUrl fail:" + e.toString());
                    }
                }
            }
        }

        public a(lh6 lh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh6Var;
        }

        @Override // com.baidu.tieba.uf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.y;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.x;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.r;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.s;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            int dimensionPixelSize;
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.layout_virtual_image_tip, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tip_text_view);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.tip_image_view);
                if (!StringUtils.isNull(this.a.i.get("pop_params_key_source")) && this.a.i.get("pop_params_key_source").equals("source_from_theme")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    lh6 lh6Var = this.a;
                    int i = lh6Var.S;
                    layoutParams.width = i;
                    layoutParams.height = i;
                    layoutParams.leftMargin = lh6Var.T;
                    imageView.setLayoutParams(layoutParams);
                    lh6 lh6Var2 = this.a;
                    textView.setPadding(lh6Var2.U, lh6Var2.W, lh6Var2.V, lh6Var2.X);
                }
                if (!StringUtils.isNull(this.a.i.get("pop_params_key_img"))) {
                    Glide.with(this.a.b.getContext()).load(this.a.i.get("pop_params_key_img")).into(imageView);
                }
                if (!StringUtils.isNull(this.a.i.get("pop_params_key_link"))) {
                    Drawable drawable2 = this.a.b.getResources().getDrawable(R.drawable.icon_mask_home_virtualimage_guidecircle14);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    textView.setCompoundDrawables(null, null, drawable2, null);
                }
                textView.setText(this.a.e);
                int i2 = this.a.J;
                if (i2 != 0) {
                    textView.setGravity(i2);
                } else {
                    textView.setGravity(17);
                }
                int i3 = this.a.H;
                int i4 = R.color.CAM_X0101;
                if (i3 != 0) {
                    SkinManager.setViewTextColor(textView, i3);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                }
                lh6 lh6Var3 = this.a;
                if (lh6Var3.I != 0) {
                    dimensionPixelSize = lh6Var3.b.getResources().getDimensionPixelSize(this.a.I);
                } else {
                    dimensionPixelSize = lh6Var3.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
                }
                textView.setTextSize(0, dimensionPixelSize);
                textView.setLines(this.a.C);
                if (this.a.G) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                if (StringUtils.isNull(this.a.i.get("pop_params_key_img"))) {
                    lh6 lh6Var4 = this.a;
                    int i5 = lh6Var4.D;
                    if (i5 != 0) {
                        textView.setHeight(i5);
                    } else {
                        textView.setHeight(lh6Var4.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                    }
                    int i6 = this.a.E;
                    if (i6 != 0) {
                        lh6.O(textView, 0, i6);
                    }
                    int i7 = this.a.F;
                    if (i7 != 0) {
                        textView.setWidth(i7);
                    }
                    lh6 lh6Var5 = this.a;
                    textView.setPadding(lh6Var5.t, lh6Var5.u, lh6Var5.v, lh6Var5.w);
                }
                lh6 lh6Var6 = this.a;
                int i8 = lh6Var6.K;
                if (i8 != 0) {
                    if (lh6Var6.L) {
                        int i9 = lh6Var6.H;
                        if (i9 != 0) {
                            i4 = i9;
                        }
                        drawable = WebPManager.getPureDrawable(this.a.K, SkinManager.getColor(i4), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(i8);
                    }
                    int g = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g, g);
                    textView.setCompoundDrawablePadding(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, this.a.j);
                lh6 lh6Var7 = this.a;
                View.OnClickListener onClickListener = lh6Var7.z;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                } else {
                    textView.setOnClickListener(new View$OnClickListenerC0325a(this, lh6Var7.i.get("pop_params_key_link")));
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lh6(TbPageContext tbPageContext, View view2, String str, HashMap<String, String> hashMap) {
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
        this.S = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        this.T = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        this.U = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.V = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds18);
        this.W = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        this.X = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        this.b = tbPageContext;
        this.c = view2;
        this.h = str;
        this.i = hashMap;
    }

    public static void O(@NonNull View view2, int i, int i2) {
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

    public uf X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (uf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nh6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            wf wfVar = new wf();
            wfVar.k(this.c);
            wfVar.c(0);
            wfVar.j(true);
            wfVar.i(true);
            wfVar.a(X());
            wfVar.d(this.M);
            vf b = wfVar.b();
            this.a = b;
            b.k(false);
            this.a.l(this.B);
            this.a.n(this.b.getPageActivity(), this.q);
            this.d = true;
            j();
            this.g = true;
            if (!this.R) {
                gh.a().postDelayed(this.Q, this.p);
            }
        }
    }
}
