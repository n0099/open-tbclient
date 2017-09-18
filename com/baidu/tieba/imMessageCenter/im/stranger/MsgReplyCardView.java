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
    private LinearLayout dMC;
    private TextView dMD;
    private TextView dME;
    private TextView dMF;
    private TextView dMG;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dMC = (LinearLayout) findViewById(d.h.reply_card);
        this.dMD = (TextView) findViewById(d.h.reply_title);
        this.dME = (TextView) findViewById(d.h.reply_content);
        this.dMF = (TextView) findViewById(d.h.reply_quote_content);
        this.dMG = (TextView) findViewById(d.h.reply_frs_name);
        this.dMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dqC.a(view, 14, MsgReplyCardView.this.avK, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0103a nn = a.nn(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dMD.setText(a(nn, valueOf));
            this.dME.setText(nn.dMl);
            this.dMF.setText(b(nn, valueOf));
            this.dMG.setText(nn.aux + this.mContext.getString(d.l.forum));
        }
    }

    private String a(a.C0103a c0103a, String str) {
        String string;
        String nr;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nr(c0103a.dMJ);
            nr = this.mContext.getString(d.l.you);
        } else {
            string = this.mContext.getString(d.l.you);
            nr = nr(c0103a.dMJ);
        }
        return String.format(this.mContext.getString(d.l.add_friend_card_title), string, getType(c0103a.type), nr);
    }

    private String b(a.C0103a c0103a, String str) {
        String nr;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nr = this.mContext.getString(d.l.me);
        } else {
            nr = nr(c0103a.dMJ);
        }
        if (c0103a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_comment), nr));
            sb.append(c0103a.dMN);
        } else {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_thread), nr));
            sb.append(c0103a.title);
        }
        return sb.toString();
    }

    private String nr(int i) {
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
