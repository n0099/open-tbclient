package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.s0.l4.c;
import c.a.s0.l4.d;
import c.a.s0.l4.e;
import c.a.s0.l4.f;
import c.a.s0.l4.g;
import c.a.s0.l4.i;
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
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emotionPic", "Landroid/widget/ImageView;", "loginButton", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "notLoginTextView", "Landroid/widget/TextView;", "onAttentionLogin", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "getOnAttentionLogin", "()Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "setOnAttentionLogin", "(Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;)V", "init", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onClick", "v", "Landroid/view/View;", "OnAttentionLogin", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AttentionNotLoginLayout extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50667e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50668f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f50669g;

    /* renamed from: h  reason: collision with root package name */
    public a f50670h;

    /* loaded from: classes12.dex */
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
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(g.attention_not_login_layout, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…login_layout, this, true)");
            View findViewById = inflate.findViewById(f.attention_emotion_pic);
            if (findViewById != null) {
                this.f50668f = (ImageView) findViewById;
                View findViewById2 = inflate.findViewById(f.attention_not_login_text);
                if (findViewById2 != null) {
                    this.f50667e = (TextView) findViewById2;
                    View findViewById3 = inflate.findViewById(f.attention_login_btn);
                    if (findViewById3 != null) {
                        this.f50669g = (TBSpecificationBtn) findViewById3;
                        c.a.r0.s.i0.n.a aVar = new c.a.r0.s.i0.n.a();
                        TBSpecificationBtn tBSpecificationBtn = this.f50669g;
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(context.getString(i.click_here_to_login));
                        }
                        TBSpecificationBtn tBSpecificationBtn2 = this.f50669g;
                        if (tBSpecificationBtn2 != null) {
                            tBSpecificationBtn2.setTextSize(d.T_X06);
                        }
                        TBSpecificationBtn tBSpecificationBtn3 = this.f50669g;
                        if (tBSpecificationBtn3 != null) {
                            tBSpecificationBtn3.setTextHorizontalCenter(true);
                        }
                        TBSpecificationBtn tBSpecificationBtn4 = this.f50669g;
                        if (tBSpecificationBtn4 != null) {
                            tBSpecificationBtn4.setConfig(aVar);
                        }
                        TBSpecificationBtn tBSpecificationBtn5 = this.f50669g;
                        if (tBSpecificationBtn5 == null) {
                            return;
                        }
                        tBSpecificationBtn5.setOnClickListener(this);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    public final a getOnAttentionLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50670h : (a) invokeV.objValue;
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setImageResource(this.f50668f, e.new_pic_emotion_09, 4);
            SkinManager.setViewTextColor(this.f50667e, c.CAM_X0107, 1, 4);
            TBSpecificationBtn tBSpecificationBtn = this.f50669g;
            if (tBSpecificationBtn == null) {
                return;
            }
            tBSpecificationBtn.changeSkinType(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (v.getId() == f.attention_login_btn) {
                boolean checkUpIsLogin = ViewHelper.checkUpIsLogin(getContext());
                if (!checkUpIsLogin) {
                    TbSingleton.loginFrom = 1;
                }
                a aVar = this.f50670h;
                if (aVar == null) {
                    return;
                }
                aVar.a(checkUpIsLogin);
            }
        }
    }

    public final void setOnAttentionLogin(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f50670h = aVar;
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
        Intrinsics.checkNotNullParameter(context, "context");
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
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }
}
