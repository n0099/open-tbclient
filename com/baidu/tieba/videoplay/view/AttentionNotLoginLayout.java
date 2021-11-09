package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.b4.c;
import b.a.r0.b4.d;
import b.a.r0.b4.e;
import b.a.r0.b4.f;
import b.a.r0.b4.g;
import b.a.r0.b4.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b \u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b \u0010#B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010$\u001a\u00020\b¢\u0006\u0004\b \u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout;", "android/view/View$OnClickListener", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "emotionPic", "Landroid/widget/ImageView;", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "loginButton", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "Landroid/widget/TextView;", "notLoginTextView", "Landroid/widget/TextView;", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "onAttentionLogin", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "getOnAttentionLogin", "()Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "setOnAttentionLogin", "(Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;)V", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnAttentionLogin", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class AttentionNotLoginLayout extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55179e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55180f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f55181g;

    /* renamed from: h  reason: collision with root package name */
    public a f55182h;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionNotLoginLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.attention_not_login_layout, (ViewGroup) this, true);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…login_layout, this, true)");
            View findViewById = inflate.findViewById(f.attention_emotion_pic);
            if (findViewById != null) {
                this.f55180f = (ImageView) findViewById;
                View findViewById2 = inflate.findViewById(f.attention_not_login_text);
                if (findViewById2 != null) {
                    this.f55179e = (TextView) findViewById2;
                    View findViewById3 = inflate.findViewById(f.attention_login_btn);
                    if (findViewById3 != null) {
                        this.f55181g = (TBSpecificationBtn) findViewById3;
                        b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
                        TBSpecificationBtn tBSpecificationBtn = this.f55181g;
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(context.getString(i.click_here_to_login));
                        }
                        TBSpecificationBtn tBSpecificationBtn2 = this.f55181g;
                        if (tBSpecificationBtn2 != null) {
                            tBSpecificationBtn2.setTextSize(d.T_X06);
                        }
                        TBSpecificationBtn tBSpecificationBtn3 = this.f55181g;
                        if (tBSpecificationBtn3 != null) {
                            tBSpecificationBtn3.setTextHorizontalCenter(true);
                        }
                        TBSpecificationBtn tBSpecificationBtn4 = this.f55181g;
                        if (tBSpecificationBtn4 != null) {
                            tBSpecificationBtn4.setConfig(aVar);
                        }
                        TBSpecificationBtn tBSpecificationBtn5 = this.f55181g;
                        if (tBSpecificationBtn5 != null) {
                            tBSpecificationBtn5.setOnClickListener(this);
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    public final a getOnAttentionLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55182h : (a) invokeV.objValue;
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setImageResource(this.f55180f, e.new_pic_emotion_09, 4);
            SkinManager.setViewTextColor(this.f55179e, c.CAM_X0107, 1, 4);
            TBSpecificationBtn tBSpecificationBtn = this.f55181g;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType(4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == f.attention_login_btn) {
            boolean checkUpIsLogin = ViewHelper.checkUpIsLogin(getContext());
            if (!checkUpIsLogin) {
                TbSingleton.loginFrom = 1;
            }
            a aVar = this.f55182h;
            if (aVar != null) {
                aVar.a(checkUpIsLogin);
            }
        }
    }

    public final void setOnAttentionLogin(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f55182h = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionNotLoginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionNotLoginLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
