package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.tv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class qj8 extends sj8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g0;
    public static final int h0;
    public static final int i0;
    public transient /* synthetic */ FieldHolder $fh;
    public Context S;
    public LinearLayout T;
    public LinearLayout U;
    public View V;
    public View W;
    public String X;
    public boolean Y;
    public boolean Z;
    public tv4.d a0;
    public tv4.d b0;
    public tv4.d c0;
    public tv4.d d0;
    public tv4.d e0;
    public View.OnClickListener f0;

    /* loaded from: classes5.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context l;
        public EMTextView m;
        public LinearLayout.LayoutParams n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj8 qj8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = context;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                super.a();
                addView(this.m, this.n);
                return this;
            }
            return (ShareDialogItemView) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.c = new ImageView(this.l);
                setTag(Integer.valueOf(i));
                this.c.setScaleType(ImageView.ScaleType.FIT_XY);
                WebPManager.setMaskDrawable(this.c, i, null);
                b();
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                EMTextView eMTextView = new EMTextView(this.l);
                this.m = eMTextView;
                eMTextView.setTextSize(0, ShareDialogItemView.j);
                this.m.setText(i);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                this.n = layoutParams;
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
                this.n.gravity = 1;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948093866, "Lcom/baidu/tieba/qj8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948093866, "Lcom/baidu/tieba/qj8;");
                return;
            }
        }
        g0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        h0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        i0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj8(Context context, String str, boolean z, boolean z2, tv4.d dVar, tv4.d dVar2, tv4.d dVar3, tv4.d dVar4, tv4.d dVar5, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2), dVar, dVar2, dVar3, dVar4, dVar5, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.S = context;
        this.X = str;
        this.Y = z;
        this.Z = z2;
        this.a0 = dVar;
        this.b0 = dVar2;
        this.c0 = dVar3;
        this.d0 = dVar4;
        this.e0 = dVar5;
        this.f0 = onClickListener;
        this.T = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0909e4);
        this.U = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e6c);
        y0();
    }

    @Override // com.baidu.tieba.sj8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d03d2, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sj8
    public void m(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, onClickListener) == null) {
            super.m(view2, i, onClickListener);
        }
    }

    @Override // com.baidu.tieba.sj8, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2.getTag() != null) {
                i = ((Integer) view2.getTag()).intValue();
            } else {
                i = -1;
            }
            if (i == R.drawable.obfuscated_res_0x7f080a07) {
                tv4.d dVar = this.c0;
                if (dVar != null) {
                    dVar.onClick();
                }
            } else if (i == -32040225) {
                tv4.d dVar2 = this.a0;
                if (dVar2 != null) {
                    dVar2.onClick();
                }
            } else if (i == R.drawable.obfuscated_res_0x7f080aa6) {
                tv4.d dVar3 = this.b0;
                if (dVar3 != null) {
                    dVar3.onClick();
                }
            } else if (i == R.drawable.obfuscated_res_0x7f080aa8) {
                tv4.d dVar4 = this.d0;
                if (dVar4 != null) {
                    dVar4.onClick();
                }
            } else if (i == R.drawable.obfuscated_res_0x7f080aa7) {
                tv4.d dVar5 = this.e0;
                if (dVar5 != null) {
                    dVar5.onClick();
                }
            } else if (i == R.drawable.obfuscated_res_0x7f080ab4 && (onClickListener = this.f0) != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.sj8
    public boolean s0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.T.removeAllViews();
            this.U.removeAllViews();
            int i2 = 0;
            while (true) {
                if (i2 >= Math.min(6, this.h.size())) {
                    break;
                }
                this.T.addView(this.h.get(i2), new ViewGroup.LayoutParams(g0, h0));
                i2++;
            }
            this.T.addView(this.V, new ViewGroup.LayoutParams(i0, -1));
            for (i = 6; i < this.h.size(); i++) {
                this.U.addView(this.h.get(i), new ViewGroup.LayoutParams(g0, h0));
            }
            this.U.addView(this.W, new ViewGroup.LayoutParams(i0, -1));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.clear();
            l(R.string.obfuscated_res_0x7f0f119b, new SvgMaskType(R.drawable.obfuscated_res_0x7f08083b));
            l(R.string.obfuscated_res_0x7f0f119f, new SvgMaskType(R.drawable.obfuscated_res_0x7f08083c));
            l(R.string.obfuscated_res_0x7f0f11bd, new SvgMaskType(R.drawable.obfuscated_res_0x7f08083e));
            a aVar = new a(this, this.S);
            aVar.d(R.drawable.obfuscated_res_0x7f080ab4);
            aVar.setItemName(R.string.obfuscated_res_0x7f0f11be);
            aVar.e(R.string.obfuscated_res_0x7f0f11bf);
            aVar.setOnClickListener(this);
            List<View> list = this.h;
            aVar.a();
            list.add(aVar);
            l(R.string.obfuscated_res_0x7f0f11c4, new SvgMaskType(R.drawable.obfuscated_res_0x7f08083a));
            l(R.string.obfuscated_res_0x7f0f11aa, new SvgMaskType(R.drawable.obfuscated_res_0x7f08083f));
            if (this.X != null) {
                i(R.string.obfuscated_res_0x7f0f0d56, R.drawable.obfuscated_res_0x7f080a07);
            }
            LinearLayout G = G(R.string.obfuscated_res_0x7f0f10dd, R.drawable.obfuscated_res_0x7f080a02);
            G.setOnClickListener(this);
            G.setTag(-32040225);
            this.h.add(G);
            if (this.Y) {
                i(R.string.obfuscated_res_0x7f0f10dc, R.drawable.obfuscated_res_0x7f080aa6);
            }
            i(R.string.obfuscated_res_0x7f0f08da, R.drawable.obfuscated_res_0x7f080aa8);
            if (this.Z) {
                i(R.string.obfuscated_res_0x7f0f0901, R.drawable.obfuscated_res_0x7f080aa7);
            }
            this.V = new View(this.S);
            this.W = new View(this.S);
        }
    }
}
