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
    private LinearLayout dYm;
    private TextView dYn;
    private TextView dYo;
    private TextView dYp;
    private TextView dYq;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dYm = (LinearLayout) findViewById(d.g.reply_card);
        this.dYn = (TextView) findViewById(d.g.reply_title);
        this.dYo = (TextView) findViewById(d.g.reply_content);
        this.dYp = (TextView) findViewById(d.g.reply_quote_content);
        this.dYq = (TextView) findViewById(d.g.reply_frs_name);
        this.dYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dCB.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0102a nw = a.nw(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dYn.setText(a(nw, valueOf));
            this.dYo.setText(nw.dXV);
            this.dYp.setText(b(nw, valueOf));
            this.dYq.setText(nw.aux + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0102a c0102a, String str) {
        String string;
        String nS;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nS(c0102a.dYs);
            nS = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            nS = nS(c0102a.dYs);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0102a.type), nS);
    }

    private String b(a.C0102a c0102a, String str) {
        String nS;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nS = this.mContext.getString(d.j.me);
        } else {
            nS = nS(c0102a.dYs);
        }
        if (c0102a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), nS));
            sb.append(c0102a.dYw);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), nS));
            sb.append(c0102a.title);
        }
        return sb.toString();
    }

    private String nS(int i) {
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
