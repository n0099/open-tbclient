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
import com.baidu.tieba.j05;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class qja extends sja {
    public static /* synthetic */ Interceptable $ic;
    public static final int b0;
    public static final int c0;
    public static final int d0;
    public transient /* synthetic */ FieldHolder $fh;
    public Context N;
    public LinearLayout O;
    public LinearLayout P;
    public View Q;
    public View R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1153T;
    public boolean U;
    public j05.e V;
    public j05.e W;
    public j05.e X;
    public j05.e Y;
    public j05.e Z;
    public View.OnClickListener a0;

    /* loaded from: classes7.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context l;
        public EMTextView m;
        public LinearLayout.LayoutParams n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qja qjaVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qjaVar, context};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095137, "Lcom/baidu/tieba/qja;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095137, "Lcom/baidu/tieba/qja;");
                return;
            }
        }
        b0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        c0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        d0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qja(Context context, String str, boolean z, boolean z2, j05.e eVar, j05.e eVar2, j05.e eVar3, j05.e eVar4, j05.e eVar5, View.OnClickListener onClickListener) {
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
        this.N = context;
        this.S = str;
        this.f1153T = z;
        this.U = z2;
        this.V = eVar;
        this.W = eVar2;
        this.X = eVar3;
        this.Y = eVar4;
        this.Z = eVar5;
        this.a0 = onClickListener;
        this.O = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090b59);
        this.P = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0921b3);
        C0();
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.clear();
            o(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            o(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            o(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            a aVar = new a(this, this.N);
            aVar.d(R.drawable.icon_share_wechatexpression);
            aVar.setItemName(R.string.share_weixin_emotion_1);
            aVar.e(R.string.share_weixin_emotion_2);
            aVar.setOnClickListener(this);
            List<View> list = this.h;
            aVar.a();
            list.add(aVar);
            o(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            o(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            if (this.S != null) {
                l(R.string.original_img_look, R.drawable.icon_pure_share_original40);
            }
            LinearLayout K = K(R.string.save_to_local, R.drawable.icon_pure_share_download40);
            K.setOnClickListener(this);
            K.setTag(-32039117);
            this.h.add(K);
            if (this.f1153T) {
                l(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
            }
            l(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
            if (this.U) {
                l(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
            }
            this.Q = new View(this.N);
            this.R = new View(this.N);
        }
    }

    @Override // com.baidu.tieba.sja
    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0456, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sja, android.view.View.OnClickListener
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
            if (i == R.drawable.icon_pure_share_original40) {
                j05.e eVar = this.X;
                if (eVar != null) {
                    eVar.onClick();
                }
            } else if (i == -32039117) {
                j05.e eVar2 = this.V;
                if (eVar2 != null) {
                    eVar2.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_expression40) {
                j05.e eVar3 = this.W;
                if (eVar3 != null) {
                    eVar3.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_scan40) {
                j05.e eVar4 = this.Y;
                if (eVar4 != null) {
                    eVar4.onClick();
                }
            } else if (i == R.drawable.icon_share_homepage_qrcode40) {
                j05.e eVar5 = this.Z;
                if (eVar5 != null) {
                    eVar5.onClick();
                }
            } else if (i == R.drawable.icon_share_wechatexpression && (onClickListener = this.a0) != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.sja
    public void p(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, onClickListener) == null) {
            super.p(view2, i, onClickListener);
        }
    }

    @Override // com.baidu.tieba.sja
    public boolean w0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.O.removeAllViews();
            this.P.removeAllViews();
            int i2 = 0;
            while (true) {
                if (i2 >= Math.min(6, this.h.size())) {
                    break;
                }
                this.O.addView(this.h.get(i2), new ViewGroup.LayoutParams(b0, c0));
                i2++;
            }
            this.O.addView(this.Q, new ViewGroup.LayoutParams(d0, -1));
            for (i = 6; i < this.h.size(); i++) {
                this.P.addView(this.h.get(i), new ViewGroup.LayoutParams(b0, c0));
            }
            this.P.addView(this.R, new ViewGroup.LayoutParams(d0, -1));
            return true;
        }
        return invokeV.booleanValue;
    }
}
