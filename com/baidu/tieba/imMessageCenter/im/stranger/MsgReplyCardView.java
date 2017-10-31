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
    private LinearLayout dQs;
    private TextView dQt;
    private TextView dQu;
    private TextView dQv;
    private TextView dQw;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dQs = (LinearLayout) findViewById(d.g.reply_card);
        this.dQt = (TextView) findViewById(d.g.reply_title);
        this.dQu = (TextView) findViewById(d.g.reply_content);
        this.dQv = (TextView) findViewById(d.g.reply_quote_content);
        this.dQw = (TextView) findViewById(d.g.reply_frs_name);
        this.dQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.duu.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0101a nl = a.nl(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dQt.setText(a(nl, valueOf));
            this.dQu.setText(nl.dQb);
            this.dQv.setText(b(nl, valueOf));
            this.dQw.setText(nl.atP + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0101a c0101a, String str) {
        String string;
        String nD;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nD(c0101a.dQy);
            nD = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            nD = nD(c0101a.dQy);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0101a.type), nD);
    }

    private String b(a.C0101a c0101a, String str) {
        String nD;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nD = this.mContext.getString(d.j.me);
        } else {
            nD = nD(c0101a.dQy);
        }
        if (c0101a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), nD));
            sb.append(c0101a.dQC);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), nD));
            sb.append(c0101a.title);
        }
        return sb.toString();
    }

    private String nD(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.j.she);
        }
        return this.mContext.getResources().getString(d.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.j.add_friend_card_title_comment) : this.mContext.getResources().getString(d.j.topic_thread);
    }
}
