package com.baidu.tieba.im.widget.sharecard;

import android.content.Context;
import android.text.TextPaint;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.k58;
import com.baidu.tieba.lk5;
import com.baidu.tieba.p45;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u001d2\b\b\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/baidu/tieba/im/widget/sharecard/ChatShareChatroomCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentRoomId", "", "getCurrentRoomId", "()J", "setCurrentRoomId", "(J)V", "desc", "Landroid/widget/TextView;", "head", "Lcom/baidu/tbadk/widget/TbImageView;", "name", "scene", "", "getScene", "()I", "setScene", "(I)V", "assembleDescription", "", "forum", "count", "bind", "", "data", "Lcom/baidu/tieba/im/data/ShareChatroomMsgData;", "fitDescription", "onChangeSkin", NotificationCompat.WearableExtender.KEY_BACKGROUND, "isLeft", "", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatShareChatroomCard extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final String j;
    public static final String k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;
    public int d;
    public long e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatShareChatroomCard(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1749023201, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareChatroomCard;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1749023201, "Lcom/baidu/tieba/im/widget/sharecard/ChatShareChatroomCard;");
                return;
            }
        }
        f = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        g = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X006);
        h = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        i = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds395);
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0730);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.forum)");
        j = string;
        String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05ee);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.string.ellipsis)");
        k = string2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatShareChatroomCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.b = (TextView) findViewById(R.id.tv_chatroom_name);
        this.c = (TextView) findViewById(R.id.tv_chatroom_desc);
    }

    public final String a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j2)) == null) {
            if (j2 <= 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getContext().getString(R.string.im_group_chat_share_card_desc_reveal);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…t_share_card_desc_reveal)");
                String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.im_group_chat_share_card_desc);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…oup_chat_share_card_desc)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{str, StringHelper.numFormatOverWan(j2)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return (String) invokeLJ.objValue;
    }

    public /* synthetic */ ChatShareChatroomCard(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void d(ShareChatroomMsgData it, ChatShareChatroomCard this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, it, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(it, "$it");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (it.getId() != this$0.e) {
                lk5.a().b(this$0.getContext(), it.getId());
                k58.d("c15286", 5, this$0.d);
            }
        }
    }

    public final void c(final ShareChatroomMsgData shareChatroomMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareChatroomMsgData) == null) && shareChatroomMsgData != null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.N(shareChatroomMsgData.getIcon(), 12, false);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(shareChatroomMsgData.getName());
            }
            e(shareChatroomMsgData);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a68
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ChatShareChatroomCard.d(ShareChatroomMsgData.this, this, view2);
                    }
                }
            });
        }
    }

    public final void e(ShareChatroomMsgData shareChatroomMsgData) {
        TextView textView;
        TextPaint paint;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareChatroomMsgData) == null) && (textView = this.c) != null) {
            String forumName = shareChatroomMsgData.getForumName();
            TextPaint paint2 = textView.getPaint();
            if (paint2.measureText(a(forumName + j, shareChatroomMsgData.getChatCount())) > i) {
                do {
                    forumName = forumName.substring(0, forumName.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(forumName, "this as java.lang.String…ing(startIndex, endIndex)");
                    paint = textView.getPaint();
                } while (paint.measureText(a(forumName + k + j, shareChatroomMsgData.getChatCount())) > i);
                textView.setText(a(forumName + k + j, shareChatroomMsgData.getChatCount()));
                return;
            }
            textView.setText(a(forumName + j, shareChatroomMsgData.getChatCount()));
        }
    }

    public final long getCurrentRoomId() {
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
            return this.d;
        }
        return invokeV.intValue;
    }

    public final void h(@DrawableRes int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                int i3 = g;
                int i4 = h;
                setPadding(f + i3, i4, i3, i4);
            } else {
                int i5 = g;
                int i6 = h;
                setPadding(i5, i6, i5, i6);
            }
            SkinManager.setBackgroundResource(this, i2);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setConrers(15);
                tbImageView.setRadiusById(R.string.J_X04);
            }
            p45.d(this.b).w(R.color.CAM_X0105);
            p45.d(this.c).w(R.color.CAM_X0109);
        }
    }

    public final void setCurrentRoomId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.e = j2;
        }
    }

    public final void setScene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.d = i2;
        }
    }
}
