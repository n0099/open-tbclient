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
    private LinearLayout eRq;
    private TextView eRr;
    private TextView eRs;
    private TextView eRt;
    private TextView eRu;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eRq = (LinearLayout) findViewById(d.g.reply_card);
        this.eRr = (TextView) findViewById(d.g.reply_title);
        this.eRs = (TextView) findViewById(d.g.reply_content);
        this.eRt = (TextView) findViewById(d.g.reply_quote_content);
        this.eRu = (TextView) findViewById(d.g.reply_frs_name);
        this.eRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.evD.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0185a oa = a.oa(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eRr.setText(a(oa, valueOf));
            this.eRs.setText(oa.eQZ);
            this.eRt.setText(b(oa, valueOf));
            this.eRu.setText(oa.blm + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0185a c0185a, String str) {
        String string;
        String qJ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qJ(c0185a.eRw);
            qJ = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            qJ = qJ(c0185a.eRw);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0185a.type), qJ);
    }

    private String b(a.C0185a c0185a, String str) {
        String qJ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qJ = this.mContext.getString(d.j.me);
        } else {
            qJ = qJ(c0185a.eRw);
        }
        if (c0185a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), qJ));
            sb.append(c0185a.eRA);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), qJ));
            sb.append(c0185a.title);
        }
        return sb.toString();
    }

    private String qJ(int i) {
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
