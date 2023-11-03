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
public class rja extends sja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qs9 N;
    public View O;
    public View P;
    public View Q;
    public View R;
    public TbImageView S;

    /* renamed from: T  reason: collision with root package name */
    public LinearLayout f1159T;
    public TbImageView U;
    public TextView V;
    public View W;
    public ImageView X;
    public TextView Y;
    public TextView Z;
    public TbImageView a0;
    public View b0;
    public TextView c0;
    public TextView d0;
    public LinearLayout e0;
    public PlayVoiceBntNew f0;

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final int[] J0(int i, int i2, int i3) {
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
    public rja(Context context, boolean z, int i, qs9 qs9Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), qs9Var};
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
        this.N = qs9Var;
        this.O = this.b.findViewById(R.id.obfuscated_res_0x7f091bb3);
        this.P = this.b.findViewById(R.id.obfuscated_res_0x7f091bb1);
        this.Q = this.b.findViewById(R.id.obfuscated_res_0x7f091bb0);
        this.R = this.b.findViewById(R.id.obfuscated_res_0x7f091bb2);
        this.S = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091bb4);
        this.f1159T = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091bbb);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091bba);
        this.U = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.U.setConrers(15);
        this.U.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.U.setGifIconSupport(false);
        this.U.setLongIconSupport(false);
        this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a8d);
        this.W = this.b.findViewById(R.id.obfuscated_res_0x7f091bb9);
        this.X = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091bb5);
        this.Y = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d8b);
        this.Z = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d88);
        this.a0 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d87);
        this.b0 = this.b.findViewById(R.id.obfuscated_res_0x7f091d8a);
        this.c0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d89);
        this.d0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d85);
        this.e0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d84);
        this.f0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f091d86);
        D0(context, qs9Var.c().e0());
        I0();
        j0(2);
    }

    public final void C0(Context context, List<TbRichTextImageInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, list) == null) {
            for (int i = 0; i < list.size() && i != 9; i++) {
                LinearLayout linearLayout = this.e0;
                String G0 = G0(list.get(i), this.N.a());
                TbRichTextImageInfo tbRichTextImageInfo = list.get(i);
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                linearLayout.addView(F0(context, G0, tbRichTextImageInfo, z, this.N.a().u));
            }
        }
    }

    public void D0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tbRichText) == null) && tbRichText != null && tbRichText.Q() != null && !tbRichText.Q().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.Q().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int type = next.getType();
                    if (type != 1) {
                        if (type == 512) {
                            this.f0.setVoiceModel((VoiceData.VoiceModel) next.g0().Q());
                            if (this.d0.getVisibility() == 0 || this.e0.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f0.getLayoutParams();
                                if (this.d0.getVisibility() == 0 && this.e0.getVisibility() == 8) {
                                    layoutParams.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds42);
                                }
                                this.f0.setLayoutParams(layoutParams);
                            }
                            this.f0.setVisibility(0);
                        }
                    } else if (this.d0.getVisibility() == 8) {
                        SkinManager.setViewTextColor(this.d0, (int) R.color.CAM_X0105);
                        this.d0.setText(next.a0());
                        this.d0.setVisibility(0);
                    }
                }
            }
            if (!tbRichText.S().isEmpty()) {
                if (this.d0.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = BdUtilHelper.getDimens(context, R.dimen.tbds37);
                    this.e0.setLayoutParams(layoutParams2);
                }
                this.e0.setVisibility(0);
                C0(context, tbRichText.S());
            }
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int f = this.N.f();
            if (f != 0) {
                if (f != 11) {
                    if (f == 40) {
                        this.W.setVisibility(0);
                        this.X.setVisibility(0);
                        this.X.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voide_thread_play));
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.W);
                        this.U.startLoad(this.N.e(), 10, false);
                        return;
                    }
                    return;
                }
                this.U.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_voice_thread));
                this.U.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (!StringUtils.isNull(this.N.e())) {
                this.U.startLoad(this.N.e(), 10, false);
            } else {
                this.U.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_pb_post_share_article_thread));
                this.U.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    @Override // com.baidu.tieba.sja
    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.N == null) {
            return;
        }
        this.O.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.R, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.f1159T.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0107);
        this.V.setText(this.N.b());
        E0();
        SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0109);
        String name_show = this.N.c().t().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + "...";
        }
        this.c0.setText(name_show);
        SkinManager.setViewTextColor(this.c0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.Y, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.Z, (int) R.color.CAM_X0105);
        this.a0.setImageBitmap(this.N.d());
        SkinManager.setImageResource(this.S, R.drawable.obfuscated_res_0x7f08124c);
        l0(false);
        super.q0();
    }

    @Override // com.baidu.tieba.sja
    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d07c9, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final TbImageView F0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] J0 = J0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(J0[0], J0[1]);
            if (!z) {
                layoutParams.setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.X()) {
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

    public final String G0(TbRichTextImageInfo tbRichTextImageInfo, dy5 dy5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, tbRichTextImageInfo, dy5Var)) == null) {
            if (dy5Var.d()) {
                return tbRichTextImageInfo.O();
            }
            return tbRichTextImageInfo.Q();
        }
        return (String) invokeLL.objValue;
    }

    public final Bitmap H0(View view2) {
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

    @Override // com.baidu.tieba.sja
    public ShareItem I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ShareItem shareItem = this.z.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.showLink = false;
            shareItem.showTail = false;
            shareItem.content = "";
            shareItem.shareType = 1;
            shareItem.setImageData(H0(this.P));
            shareItem.saveImageDataIfNecessary();
            this.z.put(1, shareItem);
            return super.I(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.sja
    public void m0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }
}
