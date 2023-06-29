package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yw9 extends xw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context M;
    public p1a N;
    public RoundRelativeLayout O;
    public TbImageView P;
    public TextView Q;
    public TextView R;
    public RoundRelativeLayout S;

    /* renamed from: T  reason: collision with root package name */
    public TbImageView f1187T;
    public TextView U;
    public TextView V;
    public ImageView W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw9(Context context, boolean z, int i, p1a p1aVar) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), p1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M = context;
        this.N = p1aVar;
        C0();
        i0(2);
    }

    public final Bitmap B0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xw9
    public void l0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.O = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09224e);
            this.P = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09224d);
            this.S = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09148b);
            this.f1187T = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092251);
            this.Q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092250);
            this.R = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09224f);
            this.U = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092728);
            this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092727);
            this.W = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0910dd);
            E0();
            this.O.setRoundLayoutRadius(q75.B(R.string.J_X06));
            this.S.setRoundLayoutRadius(q75.B(R.string.J_X04));
        }
    }

    @Override // com.baidu.tieba.xw9
    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d08d7, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void D0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        if (this.N.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080c75);
        } else if (this.N.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080dfe);
        } else if (this.N.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080c76);
        } else if (this.N.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080c79);
        } else {
            tbImageView.N(this.N.c(), 10, false);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int l = (xi.l(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (l * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.O.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = l;
                layoutParams.height = i;
            }
            this.O.setLayoutParams(layoutParams);
            int i2 = (l * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.P.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.P.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.xw9
    public ShareItem G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ShareItem shareItem = this.z.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.r0 = false;
            shareItem.q0 = false;
            shareItem.w = "";
            shareItem.k0 = 1;
            shareItem.o(B0(this.O));
            shareItem.m();
            this.z.put(1, shareItem);
            return super.G(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.xw9
    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.N != null) {
                D0(this.P);
                this.f1187T.setImageBitmap(this.N.a());
                this.Q.setText(this.N.d());
            }
            WebPManager.setPureDrawable(this.W, R.drawable.obfuscated_res_0x7f080bc4, R.color.CAM_X0101, null);
            s75.d(this.U).x(R.color.CAM_X0101);
            s75.d(this.V).x(R.color.CAM_X0101);
            s75 d = s75.d(this.Q);
            d.D(R.string.F_X02);
            d.x(R.color.CAM_X0102);
            s75.d(this.R).x(R.color.CAM_X0103);
            super.p0();
        }
    }
}
