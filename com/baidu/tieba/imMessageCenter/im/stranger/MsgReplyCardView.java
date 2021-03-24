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
import d.b.i0.d1.f.e;
import d.b.i0.e1.a.e.a;
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
            MsgReplyCardView.this.f53648b.onItemViewClick(view, 14, MsgReplyCardView.this.f53652f, 0L);
        }
    }

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        O();
    }

    public final String J(a.C1232a c1232a, String str) {
        String M;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            M = this.mContext.getString(R.string.me);
        } else {
            M = M(c1232a.f54351a);
        }
        if (c1232a.f54358h == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), M));
            sb.append(c1232a.f54353c);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), M));
            sb.append(c1232a.f54357g);
        }
        return sb.toString();
    }

    public final String K(a.C1232a c1232a, String str) {
        String string;
        String M;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = M(c1232a.f54351a);
            M = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            M = M(c1232a.f54351a);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, L(c1232a.f54358h), M);
    }

    public final String L(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.add_friend_card_title_comment);
        }
        return this.mContext.getResources().getString(R.string.topic_thread);
    }

    public final String M(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    public final void O() {
        this.t = (LinearLayout) d(R.id.reply_card);
        this.u = (TextView) d(R.id.reply_title);
        this.v = (TextView) d(R.id.reply_content);
        this.w = (TextView) d(R.id.reply_quote_content);
        this.x = (TextView) d(R.id.reply_frs_name);
        this.t.setOnClickListener(new a());
    }

    public void P(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage == null) {
            return;
        }
        a.C1232a a2 = d.b.i0.e1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.u.setText(K(a2, valueOf));
        this.v.setText(a2.f54352b);
        this.w.setText(J(a2, valueOf));
        TextView textView = this.x;
        textView.setText(a2.f54354d + this.mContext.getString(R.string.forum));
    }
}
