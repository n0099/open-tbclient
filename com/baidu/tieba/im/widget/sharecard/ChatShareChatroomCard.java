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
import com.baidu.tieba.eh5;
import com.baidu.tieba.hi;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.n15;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/im/widget/sharecard/ChatShareChatroomCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "desc", "Landroid/widget/TextView;", "head", "Lcom/baidu/tbadk/widget/TbImageView;", "name", "assembleDescription", "", "forum", "count", "", "bind", "", "data", "Lcom/baidu/tieba/im/data/ShareChatroomMsgData;", "fitDescription", "onChangeSkin", NotificationCompat.WearableExtender.KEY_BACKGROUND, "", "isLeft", "", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChatShareChatroomCard extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final String h;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public TextView c;

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
        d = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        e = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X006);
        f = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds395);
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bd);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.forum)");
        h = string;
        String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f057f);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.string.ellipsis)");
        i = string2;
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

    public final String a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            if (j <= 0) {
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
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{str, StringHelper.numFormatOverWan(j)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return (String) invokeLJ.objValue;
    }

    public /* synthetic */ ChatShareChatroomCard(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final void c(ChatShareChatroomCard this$0, ShareChatroomMsgData it, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, it, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            eh5.a().b(this$0.getContext(), it.getId());
        }
    }

    public final void b(final ShareChatroomMsgData shareChatroomMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareChatroomMsgData) == null) && shareChatroomMsgData != null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.M(shareChatroomMsgData.getIcon(), 12, false);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(shareChatroomMsgData.getName());
            }
            d(shareChatroomMsgData);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.os7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ChatShareChatroomCard.c(ChatShareChatroomCard.this, shareChatroomMsgData, view2);
                    }
                }
            });
        }
    }

    public final void d(ShareChatroomMsgData shareChatroomMsgData) {
        TextView textView;
        TextPaint paint;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareChatroomMsgData) == null) && (textView = this.c) != null) {
            String forumName = shareChatroomMsgData.getForumName();
            TextPaint paint2 = textView.getPaint();
            if (paint2.measureText(a(forumName + h, shareChatroomMsgData.getChatCount())) > g) {
                do {
                    forumName = forumName.substring(0, forumName.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(forumName, "this as java.lang.String…ing(startIndex, endIndex)");
                    paint = textView.getPaint();
                } while (paint.measureText(a(forumName + i + h, shareChatroomMsgData.getChatCount())) > g);
                textView.setText(a(forumName + i + h, shareChatroomMsgData.getChatCount()));
                return;
            }
            textView.setText(a(forumName + h, shareChatroomMsgData.getChatCount()));
        }
    }

    public final void e(@DrawableRes int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                int i3 = e;
                int i4 = f;
                setPadding(d + i3, i4, i3, i4);
            } else {
                int i5 = e;
                int i6 = f;
                setPadding(i5, i6, i5, i6);
            }
            SkinManager.setBackgroundResource(this, i2);
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setConrers(15);
                tbImageView.setRadiusById(R.string.J_X04);
            }
            n15.d(this.b).w(R.color.CAM_X0105);
            n15.d(this.c).w(R.color.CAM_X0109);
        }
    }
}
