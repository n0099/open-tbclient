package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class xh8 extends yh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv7 R;
    public View S;
    public View T;
    public View U;
    public View V;
    public TbImageView W;
    public LinearLayout X;
    public TbImageView Y;
    public TextView Z;
    public View a0;
    public ImageView b0;
    public TextView c0;
    public TextView d0;
    public TbImageView e0;
    public View f0;
    public TextView g0;
    public TextView h0;
    public LinearLayout i0;
    public PlayVoiceBntNew j0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh8(Context context, boolean z, int i, uv7 uv7Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), uv7Var};
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
        this.R = uv7Var;
        this.S = this.b.findViewById(R.id.obfuscated_res_0x7f091874);
        this.T = this.b.findViewById(R.id.obfuscated_res_0x7f091872);
        this.U = this.b.findViewById(R.id.obfuscated_res_0x7f091871);
        this.V = this.b.findViewById(R.id.obfuscated_res_0x7f091873);
        this.W = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091875);
        this.X = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09187c);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09187b);
        this.Y = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.Y.setConrers(15);
        this.Y.setRadius(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.Y.setGifIconSupport(false);
        this.Y.setLongIconSupport(false);
        this.Z = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091758);
        this.a0 = this.b.findViewById(R.id.obfuscated_res_0x7f09187a);
        this.b0 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091876);
        this.c0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a56);
        this.d0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a53);
        this.e0 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091a52);
        this.f0 = this.b.findViewById(R.id.obfuscated_res_0x7f091a55);
        this.g0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a54);
        this.h0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a50);
        this.i0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091a4f);
        this.j0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f091a51);
        z0(context, uv7Var.c().W());
        E0();
        h0(2);
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f = this.R.f();
            if (f == 0) {
                if (!StringUtils.isNull(this.R.e())) {
                    this.Y.K(this.R.e(), 10, false);
                    return;
                }
                this.Y.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808ca));
                this.Y.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f == 11) {
                this.Y.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808cb));
                this.Y.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (f != 40) {
            } else {
                this.a0.setVisibility(0);
                this.b0.setVisibility(0);
                this.b0.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808cc));
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.a0);
                this.Y.K(this.R.e(), 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.yh8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d06de, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final TbImageView B0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] F0 = F0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(F0[0], F0[1]);
            if (!z) {
                layoutParams.setMargins(0, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.I()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            tbImageView.K(str, z2 ? 17 : 18, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String C0(TbRichTextImageInfo tbRichTextImageInfo, dl5 dl5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tbRichTextImageInfo, dl5Var)) == null) ? dl5Var.c() ? tbRichTextImageInfo.z() : tbRichTextImageInfo.B() : (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yh8
    public ShareItem D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ShareItem shareItem = this.B.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.o0 = false;
            shareItem.n0 = false;
            shareItem.w = "";
            shareItem.h0 = 1;
            shareItem.i(D0(this.T));
            shareItem.g();
            this.B.put(1, shareItem);
            return super.D(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    public final Bitmap D0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            createBitmap.eraseColor(SkinManager.getColor(R.color.CAM_X0206));
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final int[] F0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    @Override // com.baidu.tieba.yh8
    public void k0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // com.baidu.tieba.yh8
    public void m0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.R == null) {
            return;
        }
        this.S.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.V, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.X.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.Z, (int) R.color.CAM_X0107);
        this.Z.setText(this.R.b());
        A0();
        SkinManager.setBackgroundColor(this.f0, R.color.CAM_X0109);
        String name_show = this.R.c().s().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.g0.setText(name_show);
        SkinManager.setViewTextColor(this.g0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.c0, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.d0, (int) R.color.CAM_X0105);
        this.e0.setImageBitmap(this.R.d());
        SkinManager.setImageResource(this.W, R.drawable.obfuscated_res_0x7f080f76);
        j0(false);
        super.m0();
    }

    public final void y0(Context context, List<TbRichTextImageInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, list) == null) {
            int i = 0;
            while (i < list.size() && i != 9) {
                this.i0.addView(B0(context, C0(list.get(i), this.R.a()), list.get(i), i == 0, this.R.a().s));
                i++;
            }
        }
    }

    public void z0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, context, tbRichText) == null) || tbRichText == null || tbRichText.B() == null || tbRichText.B().isEmpty()) {
            return;
        }
        Iterator<TbRichTextData> it = tbRichText.B().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                int type = next.getType();
                if (type != 1) {
                    if (type == 512) {
                        this.j0.setVoiceModel((VoiceData.VoiceModel) next.P().B());
                        if (this.h0.getVisibility() == 0 || this.i0.getVisibility() == 0) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j0.getLayoutParams();
                            if (this.h0.getVisibility() == 0 && this.i0.getVisibility() == 8) {
                                layoutParams.topMargin = ej.f(context, R.dimen.tbds39);
                            } else {
                                layoutParams.topMargin = ej.f(context, R.dimen.tbds42);
                            }
                            this.j0.setLayoutParams(layoutParams);
                        }
                        this.j0.setVisibility(0);
                    }
                } else if (this.h0.getVisibility() == 8) {
                    SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0105);
                    this.h0.setText(next.J());
                    this.h0.setVisibility(0);
                }
            }
        }
        if (tbRichText.D().isEmpty()) {
            return;
        }
        if (this.h0.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i0.getLayoutParams();
            layoutParams2.topMargin = ej.f(context, R.dimen.tbds37);
            this.i0.setLayoutParams(layoutParams2);
        }
        this.i0.setVisibility(0);
        y0(context, tbRichText.D());
    }
}
