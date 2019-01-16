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
    private LinearLayout fgF;
    private TextView fgG;
    private TextView fgH;
    private TextView fgI;
    private TextView fgJ;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.fgF = (LinearLayout) findViewById(e.g.reply_card);
        this.fgG = (TextView) findViewById(e.g.reply_title);
        this.fgH = (TextView) findViewById(e.g.reply_content);
        this.fgI = (TextView) findViewById(e.g.reply_quote_content);
        this.fgJ = (TextView) findViewById(e.g.reply_frs_name);
        this.fgF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.eLs.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0258a rd = a.rd(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.fgG.setText(a(rd, valueOf));
            this.fgH.setText(rd.fgp);
            this.fgI.setText(b(rd, valueOf));
            this.fgJ.setText(rd.aSL + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0258a c0258a, String str) {
        String string;
        String qN;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qN(c0258a.fgL);
            qN = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            qN = qN(c0258a.fgL);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0258a.type), qN);
    }

    private String b(a.C0258a c0258a, String str) {
        String qN;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qN = this.mContext.getString(e.j.me);
        } else {
            qN = qN(c0258a.fgL);
        }
        if (c0258a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), qN));
            sb.append(c0258a.fgP);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), qN));
            sb.append(c0258a.title);
        }
        return sb.toString();
    }

    private String qN(int i) {
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
