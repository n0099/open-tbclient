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
/* loaded from: classes5.dex */
public class nw8 extends ow8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ga8 M;
    public View N;
    public View O;
    public View P;
    public View Q;
    public TbImageView R;
    public LinearLayout S;
    public TbImageView T;
    public TextView U;
    public View V;
    public ImageView W;
    public TextView X;
    public TextView Y;
    public TbImageView Z;
    public View a0;
    public TextView b0;
    public TextView c0;
    public LinearLayout d0;
    public PlayVoiceBntNew e0;

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final int[] G0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw8(Context context, boolean z, int i, ga8 ga8Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), ga8Var};
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
        this.M = ga8Var;
        this.N = this.b.findViewById(R.id.obfuscated_res_0x7f091982);
        this.O = this.b.findViewById(R.id.obfuscated_res_0x7f091980);
        this.P = this.b.findViewById(R.id.obfuscated_res_0x7f09197f);
        this.Q = this.b.findViewById(R.id.obfuscated_res_0x7f091981);
        this.R = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091983);
        this.S = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09198a);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091989);
        this.T = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.T.setConrers(15);
        this.T.setRadius(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.T.setGifIconSupport(false);
        this.T.setLongIconSupport(false);
        this.U = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091864);
        this.V = this.b.findViewById(R.id.obfuscated_res_0x7f091988);
        this.W = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091984);
        this.X = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b6e);
        this.Y = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b6b);
        this.Z = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b6a);
        this.a0 = this.b.findViewById(R.id.obfuscated_res_0x7f091b6d);
        this.b0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b6c);
        this.c0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b68);
        this.d0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091b67);
        this.e0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f091b69);
        A0(context, ga8Var.c().Z());
        F0();
        g0(2);
    }

    public void A0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, tbRichText) == null) && tbRichText != null && tbRichText.I() != null && !tbRichText.I().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.I().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int type = next.getType();
                    if (type != 1) {
                        if (type == 512) {
                            this.e0.setVoiceModel((VoiceData.VoiceModel) next.Y().I());
                            if (this.c0.getVisibility() == 0 || this.d0.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e0.getLayoutParams();
                                if (this.c0.getVisibility() == 0 && this.d0.getVisibility() == 8) {
                                    layoutParams.topMargin = ej.g(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = ej.g(context, R.dimen.tbds42);
                                }
                                this.e0.setLayoutParams(layoutParams);
                            }
                            this.e0.setVisibility(0);
                        }
                    } else if (this.c0.getVisibility() == 8) {
                        SkinManager.setViewTextColor(this.c0, (int) R.color.CAM_X0105);
                        this.c0.setText(next.S());
                        this.c0.setVisibility(0);
                    }
                }
            }
            if (!tbRichText.K().isEmpty()) {
                if (this.c0.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d0.getLayoutParams();
                    layoutParams2.topMargin = ej.g(context, R.dimen.tbds37);
                    this.d0.setLayoutParams(layoutParams2);
                }
                this.d0.setVisibility(0);
                z0(context, tbRichText.K());
            }
        }
    }

    @Override // com.baidu.tieba.ow8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0711, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int f = this.M.f();
            if (f != 0) {
                if (f != 11) {
                    if (f == 40) {
                        this.V.setVisibility(0);
                        this.W.setVisibility(0);
                        this.W.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.V);
                        this.T.K(this.M.e(), 10, false);
                        return;
                    }
                    return;
                }
                this.T.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.T.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (!StringUtils.isNull(this.M.e())) {
                this.T.K(this.M.e(), 10, false);
            } else {
                this.T.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.T.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    @Override // com.baidu.tieba.ow8
    public void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.M == null) {
            return;
        }
        this.N.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.Q, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.S.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0107);
        this.U.setText(this.M.b());
        B0();
        SkinManager.setBackgroundColor(this.a0, R.color.CAM_X0109);
        String name_show = this.M.c().r().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.b0.setText(name_show);
        SkinManager.setViewTextColor(this.b0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.X, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.Y, (int) R.color.CAM_X0105);
        this.Z.setImageBitmap(this.M.d());
        SkinManager.setImageResource(this.R, R.drawable.obfuscated_res_0x7f080ffa);
        i0(false);
        super.n0();
    }

    public final TbImageView C0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] G0 = G0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(G0[0], G0[1]);
            if (!z) {
                layoutParams.setMargins(0, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.O()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            if (z2) {
                i = 17;
            } else {
                i = 18;
            }
            tbImageView.K(str, i, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String D0(TbRichTextImageInfo tbRichTextImageInfo, ts5 ts5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, tbRichTextImageInfo, ts5Var)) == null) {
            if (ts5Var.d()) {
                return tbRichTextImageInfo.G();
            }
            return tbRichTextImageInfo.H();
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ow8
    public ShareItem E(int i) {
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
            shareItem.j(E0(this.O));
            shareItem.h();
            this.z.put(1, shareItem);
            return super.E(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    public final Bitmap E0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
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

    @Override // com.baidu.tieba.ow8
    public void j0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final void z0(Context context, List<TbRichTextImageInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, list) == null) {
            for (int i = 0; i < list.size() && i != 9; i++) {
                LinearLayout linearLayout = this.d0;
                String D0 = D0(list.get(i), this.M.a());
                TbRichTextImageInfo tbRichTextImageInfo = list.get(i);
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                linearLayout.addView(C0(context, D0, tbRichTextImageInfo, z, this.M.a().u));
            }
        }
    }
}
