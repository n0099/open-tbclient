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
    private TextView dQA;
    private TextView dQB;
    private LinearLayout dQx;
    private TextView dQy;
    private TextView dQz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dQx = (LinearLayout) findViewById(d.g.reply_card);
        this.dQy = (TextView) findViewById(d.g.reply_title);
        this.dQz = (TextView) findViewById(d.g.reply_content);
        this.dQA = (TextView) findViewById(d.g.reply_quote_content);
        this.dQB = (TextView) findViewById(d.g.reply_frs_name);
        this.dQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.duO.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0101a nn = a.nn(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dQy.setText(a(nn, valueOf));
            this.dQz.setText(nn.dQg);
            this.dQA.setText(b(nn, valueOf));
            this.dQB.setText(nn.atX + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0101a c0101a, String str) {
        String string;
        String nE;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nE(c0101a.dQD);
            nE = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            nE = nE(c0101a.dQD);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0101a.type), nE);
    }

    private String b(a.C0101a c0101a, String str) {
        String nE;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nE = this.mContext.getString(d.j.me);
        } else {
            nE = nE(c0101a.dQD);
        }
        if (c0101a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), nE));
            sb.append(c0101a.dQH);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), nE));
            sb.append(c0101a.title);
        }
        return sb.toString();
    }

    private String nE(int i) {
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
