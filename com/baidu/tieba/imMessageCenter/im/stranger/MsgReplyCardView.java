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
import d.a.o0.f1.f.e;
import d.a.o0.g1.a.e.a;
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
            MsgReplyCardView.this.f58152b.onItemViewClick(view, 14, MsgReplyCardView.this.f58156f, 0L);
        }
    }

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        L();
    }

    public final String H(a.C1404a c1404a, String str) {
        String K;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            K = this.mContext.getString(R.string.me);
        } else {
            K = K(c1404a.f58802a);
        }
        if (c1404a.f58809h == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), K));
            sb.append(c1404a.f58804c);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), K));
            sb.append(c1404a.f58808g);
        }
        return sb.toString();
    }

    public final String I(a.C1404a c1404a, String str) {
        String string;
        String K;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = K(c1404a.f58802a);
            K = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            K = K(c1404a.f58802a);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, J(c1404a.f58809h), K);
    }

    public final String J(int i2) {
        if (i2 == 1) {
            return this.mContext.getResources().getString(R.string.add_friend_card_title_comment);
        }
        return this.mContext.getResources().getString(R.string.topic_thread);
    }

    public final String K(int i2) {
        if (i2 == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i2 == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    public final void L() {
        this.t = (LinearLayout) d(R.id.reply_card);
        this.u = (TextView) d(R.id.reply_title);
        this.v = (TextView) d(R.id.reply_content);
        this.w = (TextView) d(R.id.reply_quote_content);
        this.x = (TextView) d(R.id.reply_frs_name);
        this.t.setOnClickListener(new a());
    }

    public void M(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage == null) {
            return;
        }
        a.C1404a a2 = d.a.o0.g1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.u.setText(I(a2, valueOf));
        this.v.setText(a2.f58803b);
        this.w.setText(H(a2, valueOf));
        TextView textView = this.x;
        textView.setText(a2.f58805d + this.mContext.getString(R.string.forum));
    }
}
