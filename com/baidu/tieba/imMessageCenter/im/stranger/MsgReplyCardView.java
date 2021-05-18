package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.k0.e1.f.e;
import d.a.k0.f1.a.e.a;
/* loaded from: classes4.dex */
public class MsgReplyCardView extends e {
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MsgReplyCardView.this.f54148b.onItemViewClick(view, 14, MsgReplyCardView.this.f54152f, 0L);
        }
    }

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        K();
    }

    public final String G(a.C1326a c1326a, String str) {
        String J;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            J = this.mContext.getString(R.string.me);
        } else {
            J = J(c1326a.f54800a);
        }
        if (c1326a.f54807h == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), J));
            sb.append(c1326a.f54802c);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), J));
            sb.append(c1326a.f54806g);
        }
        return sb.toString();
    }

    public final String H(a.C1326a c1326a, String str) {
        String string;
        String J;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = J(c1326a.f54800a);
            J = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            J = J(c1326a.f54800a);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, I(c1326a.f54807h), J);
    }

    public final String I(int i2) {
        if (i2 == 1) {
            return this.mContext.getResources().getString(R.string.add_friend_card_title_comment);
        }
        return this.mContext.getResources().getString(R.string.topic_thread);
    }

    public final String J(int i2) {
        if (i2 == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i2 == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    public final void K() {
        this.t = (LinearLayout) d(R.id.reply_card);
        this.u = (TextView) d(R.id.reply_title);
        this.v = (TextView) d(R.id.reply_content);
        this.w = (TextView) d(R.id.reply_quote_content);
        this.x = (TextView) d(R.id.reply_frs_name);
        this.t.setOnClickListener(new a());
    }

    public void L(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage == null) {
            return;
        }
        a.C1326a a2 = d.a.k0.f1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.u.setText(H(a2, valueOf));
        this.v.setText(a2.f54801b);
        this.w.setText(G(a2, valueOf));
        TextView textView = this.x;
        textView.setText(a2.f54803d + this.mContext.getString(R.string.forum));
    }
}
