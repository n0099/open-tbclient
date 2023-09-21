package com.baidu.tieba.im.widget.sharecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.widget.sharecard.ChatShareCommonCard;
import com.baidu.tieba.to8;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\fJ\u0018\u0010\u001d\u001a\u00020\u001a2\b\b\u0001\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/baidu/tieba/im/widget/sharecard/ChatShareCommonCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activeContent", "Lcom/baidu/tieba/im/widget/sharecard/ChatShareActiveView;", "commonContent", "Lcom/baidu/tieba/im/widget/sharecard/ChatShareCommonView;", "isActive", "", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "scene", "", "getScene", "()I", "setScene", "(I)V", "onBindView", "", "data", "Lcom/baidu/tbadk/data/ImShareCardCommonData;", "onChangeSkinType", "isLeft", NotificationCompat.WearableExtender.KEY_BACKGROUND, "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatShareCommonCard extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatShareCommonView a;
    public final ChatShareActiveView b;
    public int c;
    public boolean d;
    public long e;

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
        f = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        g = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
        h = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
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
        LayoutInflater.from(context).inflate(R.layout.layout_chat_share_chatroom_card, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.chat_share_chatroom_common);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.chat_share_chatroom_common)");
        this.a = (ChatShareCommonView) findViewById;
        View findViewById2 = findViewById(R.id.chat_share_chatroom_active);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.chat_share_chatroom_active)");
        this.b = (ChatShareActiveView) findViewById2;
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
                if (type != 2) {
                    if (type == 3) {
                        to8.d("c15286", 6, this$0.c, 0L, "", this$0.e);
                        return;
                    }
                    return;
                }
                to8.d("c15286", 4, this$0.c, 0L, "", this$0.e);
                return;
            }
            to8.d("c15286", 3, this$0.c, 0L, "", this$0.e);
        }
    }

    public final void a(final ImShareCardCommonData imShareCardCommonData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, imShareCardCommonData) == null) && imShareCardCommonData != null) {
            if (imShareCardCommonData.getType() == 3) {
                this.a.setVisibility(8);
                this.b.setVisibility(0);
                this.b.setData(imShareCardCommonData);
                this.d = true;
            } else {
                this.a.setVisibility(0);
                this.b.setVisibility(8);
                this.a.setData(imShareCardCommonData);
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kp8
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
            if (z && !this.d) {
                int i2 = g;
                int i3 = h;
                setPadding(f + i2, i3, i2, i3);
            } else {
                int i4 = g;
                int i5 = h;
                setPadding(i4, i5, i4, i5);
            }
            if (i != 0) {
                SkinManager.setBackgroundResource(this, i);
            }
            this.a.a();
            this.b.a();
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            d(0, z);
        }
    }

    public final void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.e = j;
        }
    }

    public final void setScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
        }
    }

    public final long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public final int getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }
}
