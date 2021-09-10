package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.k1.f.e;
import c.a.r0.l1.a.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MsgReplyCardView extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgReplyCardView f53480e;

        public a(MsgReplyCardView msgReplyCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReplyCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53480e = msgReplyCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53480e.f21198b.onItemViewClick(view, 14, this.f53480e.f21202f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        L();
    }

    public final String B(a.C1027a c1027a, String str) {
        InterceptResult invokeLL;
        String K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c1027a, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                K = this.mContext.getString(R.string.me);
            } else {
                K = K(c1027a.f21875a);
            }
            if (c1027a.f21882h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), K));
                sb.append(c1027a.f21877c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), K));
                sb.append(c1027a.f21881g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String D(a.C1027a c1027a, String str) {
        InterceptResult invokeLL;
        String string;
        String K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1027a, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = K(c1027a.f21875a);
                K = this.mContext.getString(R.string.you);
            } else {
                string = this.mContext.getString(R.string.you);
                K = K(c1027a.f21875a);
            }
            return String.format(this.mContext.getString(R.string.add_friend_card_title), string, J(c1027a.f21882h), K);
        }
        return (String) invokeLL.objValue;
    }

    public final String J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == 1) {
                return this.mContext.getResources().getString(R.string.add_friend_card_title_comment);
            }
            return this.mContext.getResources().getString(R.string.topic_thread);
        }
        return (String) invokeI.objValue;
    }

    public final String K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 1) {
                return this.mContext.getResources().getString(R.string.he);
            }
            if (i2 == 2) {
                return this.mContext.getResources().getString(R.string.she);
            }
            return this.mContext.getResources().getString(R.string.ta);
        }
        return (String) invokeI.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = (LinearLayout) c(R.id.reply_card);
            this.u = (TextView) c(R.id.reply_title);
            this.v = (TextView) c(R.id.reply_content);
            this.w = (TextView) c(R.id.reply_quote_content);
            this.x = (TextView) c(R.id.reply_frs_name);
            this.t.setOnClickListener(new a(this));
        }
    }

    public void N(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1027a a2 = c.a.r0.l1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.u.setText(D(a2, valueOf));
        this.v.setText(a2.f21876b);
        this.w.setText(B(a2, valueOf));
        TextView textView = this.x;
        textView.setText(a2.f21878d + this.mContext.getString(R.string.forum));
    }
}
