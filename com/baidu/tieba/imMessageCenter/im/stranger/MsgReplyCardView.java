package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import d.a.q0.i1.f.e;
import d.a.q0.j1.a.e.a;
/* loaded from: classes4.dex */
public class MsgReplyCardView extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsgReplyCardView f17913e;

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
            this.f17913e = msgReplyCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17913e.f58874b.onItemViewClick(view, 14, this.f17913e.f58878f, 0L);
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
        K();
    }

    public final String G(a.C1498a c1498a, String str) {
        InterceptResult invokeLL;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c1498a, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                J = this.mContext.getString(R.string.me);
            } else {
                J = J(c1498a.f59549a);
            }
            if (c1498a.f59556h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), J));
                sb.append(c1498a.f59551c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), J));
                sb.append(c1498a.f59555g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String H(a.C1498a c1498a, String str) {
        InterceptResult invokeLL;
        String string;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1498a, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = J(c1498a.f59549a);
                J = this.mContext.getString(R.string.you);
            } else {
                string = this.mContext.getString(R.string.you);
                J = J(c1498a.f59549a);
            }
            return String.format(this.mContext.getString(R.string.add_friend_card_title), string, I(c1498a.f59556h), J);
        }
        return (String) invokeLL.objValue;
    }

    public final String I(int i2) {
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

    public final String J(int i2) {
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

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = (LinearLayout) d(R.id.reply_card);
            this.u = (TextView) d(R.id.reply_title);
            this.v = (TextView) d(R.id.reply_content);
            this.w = (TextView) d(R.id.reply_quote_content);
            this.x = (TextView) d(R.id.reply_frs_name);
            this.t.setOnClickListener(new a(this));
        }
    }

    public void L(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1498a a2 = d.a.q0.j1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.u.setText(H(a2, valueOf));
        this.v.setText(a2.f59550b);
        this.w.setText(G(a2, valueOf));
        TextView textView = this.x;
        textView.setText(a2.f59552d + this.mContext.getString(R.string.forum));
    }
}
