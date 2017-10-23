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
    private LinearLayout dIE;
    private TextView dIF;
    private TextView dIG;
    private TextView dIH;
    private TextView dII;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dIE = (LinearLayout) findViewById(d.h.reply_card);
        this.dIF = (TextView) findViewById(d.h.reply_title);
        this.dIG = (TextView) findViewById(d.h.reply_content);
        this.dIH = (TextView) findViewById(d.h.reply_quote_content);
        this.dII = (TextView) findViewById(d.h.reply_frs_name);
        this.dIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dmE.a(view, 14, MsgReplyCardView.this.auI, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0103a mQ = a.mQ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dIF.setText(a(mQ, valueOf));
            this.dIG.setText(mQ.dIn);
            this.dIH.setText(b(mQ, valueOf));
            this.dII.setText(mQ.att + this.mContext.getString(d.l.forum));
        }
    }

    private String a(a.C0103a c0103a, String str) {
        String string;
        String nm;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nm(c0103a.dIL);
            nm = this.mContext.getString(d.l.you);
        } else {
            string = this.mContext.getString(d.l.you);
            nm = nm(c0103a.dIL);
        }
        return String.format(this.mContext.getString(d.l.add_friend_card_title), string, getType(c0103a.type), nm);
    }

    private String b(a.C0103a c0103a, String str) {
        String nm;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nm = this.mContext.getString(d.l.me);
        } else {
            nm = nm(c0103a.dIL);
        }
        if (c0103a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_comment), nm));
            sb.append(c0103a.dIP);
        } else {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_thread), nm));
            sb.append(c0103a.title);
        }
        return sb.toString();
    }

    private String nm(int i) {
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
