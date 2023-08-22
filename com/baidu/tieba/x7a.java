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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
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
/* loaded from: classes8.dex */
public class x7a extends y7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public li9 M;
    public View N;
    public View O;
    public View P;
    public View Q;
    public TbImageView R;
    public LinearLayout S;

    /* renamed from: T  reason: collision with root package name */
    public TbImageView f1188T;
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

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final int[] I0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x7a(Context context, boolean z, int i, li9 li9Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), li9Var};
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
        this.M = li9Var;
        this.N = this.b.findViewById(R.id.obfuscated_res_0x7f091b3e);
        this.O = this.b.findViewById(R.id.obfuscated_res_0x7f091b3c);
        this.P = this.b.findViewById(R.id.obfuscated_res_0x7f091b3b);
        this.Q = this.b.findViewById(R.id.obfuscated_res_0x7f091b3d);
        this.R = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b3f);
        this.S = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091b46);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b45);
        this.f1188T = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.f1188T.setConrers(15);
        this.f1188T.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.f1188T.setGifIconSupport(false);
        this.f1188T.setLongIconSupport(false);
        this.U = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a17);
        this.V = this.b.findViewById(R.id.obfuscated_res_0x7f091b44);
        this.W = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b40);
        this.X = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d2e);
        this.Y = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d2b);
        this.Z = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d2a);
        this.a0 = this.b.findViewById(R.id.obfuscated_res_0x7f091d2d);
        this.b0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d2c);
        this.c0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d28);
        this.d0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d27);
        this.e0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f091d29);
        C0(context, li9Var.c().e0());
        H0();
        i0(2);
    }

    public final void B0(Context context, List<TbRichTextImageInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, list) == null) {
            for (int i = 0; i < list.size() && i != 9; i++) {
                LinearLayout linearLayout = this.d0;
                String F0 = F0(list.get(i), this.M.a());
                TbRichTextImageInfo tbRichTextImageInfo = list.get(i);
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                linearLayout.addView(E0(context, F0, tbRichTextImageInfo, z, this.M.a().u));
            }
        }
    }

    public void C0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tbRichText) == null) && tbRichText != null && tbRichText.P() != null && !tbRichText.P().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.P().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int type = next.getType();
                    if (type != 1) {
                        if (type == 512) {
                            this.e0.setVoiceModel((VoiceData.VoiceModel) next.f0().P());
                            if (this.c0.getVisibility() == 0 || this.d0.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e0.getLayoutParams();
                                if (this.c0.getVisibility() == 0 && this.d0.getVisibility() == 8) {
                                    layoutParams.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds42);
                                }
                                this.e0.setLayoutParams(layoutParams);
                            }
                            this.e0.setVisibility(0);
                        }
                    } else if (this.c0.getVisibility() == 8) {
                        SkinManager.setViewTextColor(this.c0, (int) R.color.CAM_X0105);
                        this.c0.setText(next.Z());
                        this.c0.setVisibility(0);
                    }
                }
            }
            if (!tbRichText.R().isEmpty()) {
                if (this.c0.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d0.getLayoutParams();
                    layoutParams2.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds37);
                    this.d0.setLayoutParams(layoutParams2);
                }
                this.d0.setVisibility(0);
                B0(context, tbRichText.R());
            }
        }
    }

    @Override // com.baidu.tieba.y7a
    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d07af, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int f = this.M.f();
            if (f != 0) {
                if (f != 11) {
                    if (f == 40) {
                        this.V.setVisibility(0);
                        this.W.setVisibility(0);
                        this.W.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.V);
                        this.f1188T.startLoad(this.M.e(), 10, false);
                        return;
                    }
                    return;
                }
                this.f1188T.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.f1188T.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (!StringUtils.isNull(this.M.e())) {
                this.f1188T.startLoad(this.M.e(), 10, false);
            } else {
                this.f1188T.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.f1188T.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    @Override // com.baidu.tieba.y7a
    public void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.M == null) {
            return;
        }
        this.N.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.Q, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.S.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0107);
        this.U.setText(this.M.b());
        D0();
        SkinManager.setBackgroundColor(this.a0, R.color.CAM_X0109);
        String name_show = this.M.c().r().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + "...";
        }
        this.b0.setText(name_show);
        SkinManager.setViewTextColor(this.b0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.X, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.Y, (int) R.color.CAM_X0105);
        this.Z.setImageBitmap(this.M.d());
        SkinManager.setImageResource(this.R, R.drawable.obfuscated_res_0x7f08121a);
        k0(false);
        super.p0();
    }

    public final TbImageView E0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] I0 = I0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(I0[0], I0[1]);
            if (!z) {
                layoutParams.setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.U()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            if (z2) {
                i = 17;
            } else {
                i = 18;
            }
            tbImageView.startLoad(str, i, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String F0(TbRichTextImageInfo tbRichTextImageInfo, c16 c16Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, tbRichTextImageInfo, c16Var)) == null) {
            if (c16Var.d()) {
                return tbRichTextImageInfo.N();
            }
            return tbRichTextImageInfo.O();
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.y7a
    public ShareItem G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            ShareItem shareItem = this.z.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.showLink = false;
            shareItem.showTail = false;
            shareItem.content = "";
            shareItem.shareType = 1;
            shareItem.setImageData(G0(this.O));
            shareItem.saveImageDataIfNecessary();
            this.z.put(1, shareItem);
            return super.G(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    public final Bitmap G0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
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

    @Override // com.baidu.tieba.y7a
    public void l0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }
}
