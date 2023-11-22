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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public class uja extends tja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context N;
    public voa O;
    public RoundRelativeLayout P;
    public TbImageView Q;
    public TextView R;
    public TextView S;

    /* renamed from: T  reason: collision with root package name */
    public RoundRelativeLayout f1163T;
    public TbImageView U;
    public TextView V;
    public TextView W;
    public ImageView X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uja(Context context, boolean z, int i, voa voaVar) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), voaVar};
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
        this.N = context;
        this.O = voaVar;
        D0();
        j0(2);
    }

    public final Bitmap C0(View view2) {
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

    @Override // com.baidu.tieba.tja
    public void m0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.P = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092330);
            this.Q = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09232f);
            this.f1163T = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091514);
            this.U = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092333);
            this.R = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092332);
            this.S = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092331);
            this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092800);
            this.W = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0927ff);
            this.X = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09115c);
            F0();
            this.P.setRoundLayoutRadius(r25.B(R.string.J_X06));
            this.f1163T.setRoundLayoutRadius(r25.B(R.string.J_X04));
        }
    }

    public final void E0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        if (this.O.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080cbe);
        } else if (this.O.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080e4b);
        } else if (this.O.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080cbf);
        } else if (this.O.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080cc2);
        } else {
            tbImageView.startLoad(this.O.c(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tja
    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d091f, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int equipmentWidth = (BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (equipmentWidth * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = equipmentWidth;
                layoutParams.height = i;
            }
            this.P.setLayoutParams(layoutParams);
            int i2 = (equipmentWidth * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.Q.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.Q.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.tja
    public ShareItem I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ShareItem shareItem = this.z.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.showLink = false;
            shareItem.showTail = false;
            shareItem.content = "";
            shareItem.shareType = 1;
            shareItem.setImageData(C0(this.P));
            shareItem.saveImageDataIfNecessary();
            this.z.put(1, shareItem);
            return super.I(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.tja
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.O != null) {
                E0(this.Q);
                this.U.setImageBitmap(this.O.a());
                this.R.setText(this.O.d());
            }
            WebPManager.setPureDrawable(this.X, R.drawable.obfuscated_res_0x7f080c05, R.color.CAM_X0101, null);
            EMManager.from(this.V).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.W).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.R).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0102);
            EMManager.from(this.S).setTextColor(R.color.CAM_X0103);
            super.q0();
        }
    }
}
