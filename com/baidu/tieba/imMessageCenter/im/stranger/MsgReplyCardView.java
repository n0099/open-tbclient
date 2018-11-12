package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes4.dex */
public class MsgReplyCardView extends g {
    private LinearLayout eWm;
    private TextView eWn;
    private TextView eWo;
    private TextView eWp;
    private TextView eWq;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eWm = (LinearLayout) findViewById(e.g.reply_card);
        this.eWn = (TextView) findViewById(e.g.reply_title);
        this.eWo = (TextView) findViewById(e.g.reply_content);
        this.eWp = (TextView) findViewById(e.g.reply_quote_content);
        this.eWq = (TextView) findViewById(e.g.reply_frs_name);
        this.eWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.eBa.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0247a qi = a.qi(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eWn.setText(a(qi, valueOf));
            this.eWo.setText(qi.eVW);
            this.eWp.setText(b(qi, valueOf));
            this.eWq.setText(qi.aOG + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0247a c0247a, String str) {
        String string;
        String qf;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qf(c0247a.eWs);
            qf = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            qf = qf(c0247a.eWs);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0247a.type), qf);
    }

    private String b(a.C0247a c0247a, String str) {
        String qf;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qf = this.mContext.getString(e.j.me);
        } else {
            qf = qf(c0247a.eWs);
        }
        if (c0247a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), qf));
            sb.append(c0247a.eWw);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), qf));
            sb.append(c0247a.title);
        }
        return sb.toString();
    }

    private String qf(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(e.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(e.j.she);
        }
        return this.mContext.getResources().getString(e.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(e.j.add_friend_card_title_comment) : this.mContext.getResources().getString(e.j.topic_thread);
    }
}
