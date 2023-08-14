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
import com.baidu.tieba.w45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class r3a extends t3a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a0;
    public static final int b0;
    public static final int c0;
    public transient /* synthetic */ FieldHolder $fh;
    public Context M;
    public LinearLayout N;
    public LinearLayout O;
    public View P;
    public View Q;
    public String R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1155T;
    public w45.e U;
    public w45.e V;
    public w45.e W;
    public w45.e X;
    public w45.e Y;
    public View.OnClickListener Z;

    /* loaded from: classes7.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context l;
        public EMTextView m;
        public LinearLayout.LayoutParams n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r3a r3aVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r3aVar, context};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072073, "Lcom/baidu/tieba/r3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072073, "Lcom/baidu/tieba/r3a;");
                return;
            }
        }
        a0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        b0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        c0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3a(Context context, String str, boolean z, boolean z2, w45.e eVar, w45.e eVar2, w45.e eVar3, w45.e eVar4, w45.e eVar5, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2), eVar, eVar2, eVar3, eVar4, eVar5, onClickListener};
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
        this.M = context;
        this.R = str;
        this.S = z;
        this.f1155T = z2;
        this.U = eVar;
        this.V = eVar2;
        this.W = eVar3;
        this.X = eVar4;
        this.Y = eVar5;
        this.Z = onClickListener;
        this.N = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090b21);
        this.O = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092130);
        B0();
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.clear();
            m(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            m(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            m(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            a aVar = new a(this, this.M);
            aVar.d(R.drawable.icon_share_wechatexpression);
            aVar.setItemName(R.string.share_weixin_emotion_1);
            aVar.e(R.string.share_weixin_emotion_2);
            aVar.setOnClickListener(this);
            List<View> list = this.h;
            aVar.a();
            list.add(aVar);
            m(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            m(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            if (this.R != null) {
                j(R.string.original_img_look, R.drawable.icon_pure_share_original40);
            }
            LinearLayout I = I(R.string.save_to_local, R.drawable.icon_pure_share_download40);
            I.setOnClickListener(this);
            I.setTag(-32039242);
            this.h.add(I);
            if (this.S) {
                j(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
            }
            j(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
            if (this.f1155T) {
                j(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
            }
            this.P = new View(this.M);
            this.Q = new View(this.M);
        }
    }

    @Override // com.baidu.tieba.t3a
    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0439, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t3a
    public void n(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, onClickListener) == null) {
            super.n(view2, i, onClickListener);
        }
    }

    @Override // com.baidu.tieba.t3a, android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.onClick(view2);
            if (view2.getTag() != null) {
                i = ((Integer) view2.getTag()).intValue();
            } else {
                i = -1;
            }
            if (i == R.drawable.icon_pure_share_original40) {
                w45.e eVar = this.W;
                if (eVar != null) {
                    eVar.onClick();
                }
            } else if (i == -32039242) {
                w45.e eVar2 = this.U;
                if (eVar2 != null) {
                    eVar2.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_expression40) {
                w45.e eVar3 = this.V;
                if (eVar3 != null) {
                    eVar3.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_scan40) {
                w45.e eVar4 = this.X;
                if (eVar4 != null) {
                    eVar4.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_qrcode40) {
                w45.e eVar5 = this.Y;
                if (eVar5 != null) {
                    eVar5.onClick();
                }
            } else if (i == R.drawable.icon_share_wechatexpression && (onClickListener = this.Z) != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.t3a
    public boolean v0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.N.removeAllViews();
            this.O.removeAllViews();
            int i2 = 0;
            while (true) {
                if (i2 >= Math.min(6, this.h.size())) {
                    break;
                }
                this.N.addView(this.h.get(i2), new ViewGroup.LayoutParams(a0, b0));
                i2++;
            }
            this.N.addView(this.P, new ViewGroup.LayoutParams(c0, -1));
            for (i = 6; i < this.h.size(); i++) {
                this.O.addView(this.h.get(i), new ViewGroup.LayoutParams(a0, b0));
            }
            this.O.addView(this.Q, new ViewGroup.LayoutParams(c0, -1));
            return true;
        }
        return invokeV.booleanValue;
    }
}
