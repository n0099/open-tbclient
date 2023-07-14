package com.baidu.tieba.im.widget.sharecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.im.widget.sharecard.ChatShareCommonCard;
import com.baidu.tieba.ug8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0016\u001a\u00020\u00132\b\b\u0001\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/im/widget/sharecard/ChatShareCommonCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "desc", "Landroid/widget/TextView;", "header", "Lcom/baidu/tbadk/widget/TbImageView;", "scene", "", "getScene", "()I", "setScene", "(I)V", "title", "onBindView", "", "data", "Lcom/baidu/tbadk/data/ImShareCardCommonData;", "onChangeSkinType", "isLeft", "", NotificationCompat.WearableExtender.KEY_BACKGROUND, "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatShareCommonCard extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;
    public int d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatShareCommonCard(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(280659239, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareCommonCard;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(280659239, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareCommonCard;");
                return;
            }
        }
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        f = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        g = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatShareCommonCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.layout_chat_share_chatroom, (ViewGroup) this, true);
        this.a = (TbImageView) findViewById(R.id.iv_chatroom_icon);
        TextView textView = (TextView) findViewById(R.id.tv_chatroom_name);
        this.b = textView;
        if (textView != null) {
            textView.setMaxLines(2);
        }
        this.c = (TextView) findViewById(R.id.tv_chatroom_desc);
    }

    public /* synthetic */ ChatShareCommonCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void c(ImShareCardCommonData it, ChatShareCommonCard this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, it, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(it, "$it");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            UrlManager.getInstance().dealOneLink(it.getSchema());
            int type = it.getType();
            if (type != 1) {
                if (type == 2) {
                    ug8.d("c15286", 4, this$0.d);
                    return;
                }
                return;
            }
            ug8.d("c15286", 3, this$0.d);
        }
    }

    public final void a(final ImShareCardCommonData imShareCardCommonData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, imShareCardCommonData) == null) && imShareCardCommonData != null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.N(imShareCardCommonData.getIcon(), 12, false);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(imShareCardCommonData.getTitle());
            }
            TextView textView2 = this.c;
            if (textView2 != null) {
                textView2.setText(imShareCardCommonData.getContent());
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jh8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ChatShareCommonCard.c(ImShareCardCommonData.this, this, view2);
                    }
                }
            });
        }
    }

    public final void d(@DrawableRes int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                int i2 = f;
                int i3 = g;
                setPadding(e + i2, i3, i2, i3);
            } else {
                int i4 = f;
                int i5 = g;
                setPadding(i4, i5, i4, i5);
            }
            if (i != 0) {
                SkinManager.setBackgroundResource(this, i);
            }
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setConrers(15);
                tbImageView.setRadiusById(R.string.J_X04);
            }
            d85.d(this.b).x(R.color.CAM_X0105);
            d85.d(this.c).x(R.color.CAM_X0109);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            d(0, z);
        }
    }

    public final void setScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
        }
    }

    public final int getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }
}
