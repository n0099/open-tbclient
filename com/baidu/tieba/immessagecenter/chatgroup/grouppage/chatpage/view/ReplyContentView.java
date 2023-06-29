package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.s75;
import com.baidu.tieba.v17;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/view/ReplyContentView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgColor", "", "defaultLineSpace", "", "defaultMaxLine", "defaultTextColor", "emotionSize", "paddingHorizontal", "paddingVertical", "bind", "", "msg", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/ReMsgInfo;", "bindLeft", "bindRight", "onChangeSkin", "setFixedWidth", "needFixed", "", "paramsWidth", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReplyContentView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final int e;
    public int f;
    public int g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReplyContentView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReplyContentView(Context context, AttributeSet attributeSet) {
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
        this.a = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.b = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.c = UtilHelper.getDimenPixelSize(R.dimen.T_X05);
        this.d = 1.2f;
        this.e = 2;
        this.f = R.color.CAM_X0206;
        this.g = R.color.CAM_X0108;
        setMaxLines(2);
        setEllipsize(TextUtils.TruncateAt.END);
        int i3 = this.a;
        int i4 = this.b;
        setPadding(i3, i4, i3, i4);
        setLineSpacing(0.0f, this.d);
        b();
        setVisibility(8);
    }

    public /* synthetic */ ReplyContentView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void c(ReplyContentView this$0, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, spannableStringBuilder) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setText(spannableStringBuilder);
            this$0.setVisibility(0);
        }
    }

    public static /* synthetic */ void setFixedWidth$default(ReplyContentView replyContentView, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        replyContentView.setFixedWidth(z, i);
    }

    public final void a(ReMsgInfo reMsgInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, reMsgInfo) == null) {
            v17.e(getContext(), reMsgInfo.getContent(), this.c, new v17.i() { // from class: com.baidu.tieba.jh8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.v17.i
                public final void a(SpannableStringBuilder spannableStringBuilder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                        ReplyContentView.c(ReplyContentView.this, spannableStringBuilder);
                    }
                }
            });
            b();
        }
    }

    public final void d(ReMsgInfo msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f = R.color.CAM_X0206;
            this.g = R.color.CAM_X0108;
            a(msg);
        }
    }

    public final void e(ReMsgInfo msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f = R.color.CAM_X0617;
            this.g = R.color.CAM_X0606;
            a(msg);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s75 d = s75.d(this);
            d.x(this.g);
            d.C(R.dimen.T_X07);
            d.o(R.string.J_X05);
            d.f(this.f);
        }
    }

    public final void setFixedWidth(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                getLayoutParams().width = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds608);
            } else {
                getLayoutParams().width = i;
            }
        }
    }
}
