package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xu4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emotionPic", "Landroid/widget/ImageView;", "loginButton", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "notLoginTextView", "Landroid/widget/TextView;", "onAttentionLogin", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "getOnAttentionLogin", "()Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;", "setOnAttentionLogin", "(Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout$OnAttentionLogin;)V", "init", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onClick", "v", "Landroid/view/View;", "OnAttentionLogin", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AttentionNotLoginLayout extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public TBSpecificationBtn c;
    public a d;

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0125, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…login_layout, this, true)");
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0902bf);
            if (findViewById != null) {
                this.b = (ImageView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f0902c5);
                if (findViewById2 != null) {
                    this.a = (TextView) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.obfuscated_res_0x7f0902c3);
                    if (findViewById3 != null) {
                        this.c = (TBSpecificationBtn) findViewById3;
                        xu4 xu4Var = new xu4();
                        TBSpecificationBtn tBSpecificationBtn = this.c;
                        if (tBSpecificationBtn != null) {
                            tBSpecificationBtn.setText(context.getString(R.string.obfuscated_res_0x7f0f03e0));
                        }
                        TBSpecificationBtn tBSpecificationBtn2 = this.c;
                        if (tBSpecificationBtn2 != null) {
                            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
                        }
                        TBSpecificationBtn tBSpecificationBtn3 = this.c;
                        if (tBSpecificationBtn3 != null) {
                            tBSpecificationBtn3.setTextHorizontalCenter(true);
                        }
                        TBSpecificationBtn tBSpecificationBtn4 = this.c;
                        if (tBSpecificationBtn4 != null) {
                            tBSpecificationBtn4.setConfig(xu4Var);
                        }
                        TBSpecificationBtn tBSpecificationBtn5 = this.c;
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

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setImageResource(this.b, R.drawable.new_pic_emotion_09, 4);
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0107, 1, 4);
            TBSpecificationBtn tBSpecificationBtn = this.c;
            if (tBSpecificationBtn == null) {
                return;
            }
            tBSpecificationBtn.l(4);
        }
    }

    public final a getOnAttentionLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (a) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (v.getId() == R.id.obfuscated_res_0x7f0902c3) {
                boolean checkUpIsLogin = ViewHelper.checkUpIsLogin(getContext());
                if (!checkUpIsLogin) {
                    TbSingleton.loginFrom = 1;
                }
                a aVar = this.d;
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
            this.d = aVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public AttentionNotLoginLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
