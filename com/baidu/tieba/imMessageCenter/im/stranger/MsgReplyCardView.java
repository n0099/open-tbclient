package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends g {
    private LinearLayout dLI;
    private TextView dLJ;
    private TextView dLK;
    private TextView dLL;
    private TextView dLM;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dLI = (LinearLayout) findViewById(d.h.reply_card);
        this.dLJ = (TextView) findViewById(d.h.reply_title);
        this.dLK = (TextView) findViewById(d.h.reply_content);
        this.dLL = (TextView) findViewById(d.h.reply_quote_content);
        this.dLM = (TextView) findViewById(d.h.reply_frs_name);
        this.dLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dpH.a(view, 14, MsgReplyCardView.this.avN, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0104a nl = a.nl(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dLJ.setText(a(nl, valueOf));
            this.dLK.setText(nl.dLr);
            this.dLL.setText(b(nl, valueOf));
            this.dLM.setText(nl.auA + this.mContext.getString(d.l.forum));
        }
    }

    private String a(a.C0104a c0104a, String str) {
        String string;
        String np;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = np(c0104a.dLP);
            np = this.mContext.getString(d.l.you);
        } else {
            string = this.mContext.getString(d.l.you);
            np = np(c0104a.dLP);
        }
        return String.format(this.mContext.getString(d.l.add_friend_card_title), string, getType(c0104a.type), np);
    }

    private String b(a.C0104a c0104a, String str) {
        String np;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            np = this.mContext.getString(d.l.me);
        } else {
            np = np(c0104a.dLP);
        }
        if (c0104a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_comment), np));
            sb.append(c0104a.dLT);
        } else {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_thread), np));
            sb.append(c0104a.title);
        }
        return sb.toString();
    }

    private String np(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.l.she);
        }
        return this.mContext.getResources().getString(d.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.l.add_friend_card_title_comment) : this.mContext.getResources().getString(d.l.topic_thread);
    }
}
