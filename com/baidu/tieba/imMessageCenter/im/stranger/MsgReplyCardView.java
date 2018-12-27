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
    private LinearLayout ffS;
    private TextView ffT;
    private TextView ffU;
    private TextView ffV;
    private TextView ffW;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.ffS = (LinearLayout) findViewById(e.g.reply_card);
        this.ffT = (TextView) findViewById(e.g.reply_title);
        this.ffU = (TextView) findViewById(e.g.reply_content);
        this.ffV = (TextView) findViewById(e.g.reply_quote_content);
        this.ffW = (TextView) findViewById(e.g.reply_frs_name);
        this.ffS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.eKG.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0258a qN = a.qN(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.ffT.setText(a(qN, valueOf));
            this.ffU.setText(qN.ffC);
            this.ffV.setText(b(qN, valueOf));
            this.ffW.setText(qN.aSh + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0258a c0258a, String str) {
        String string;
        String qM;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qM(c0258a.ffY);
            qM = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            qM = qM(c0258a.ffY);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0258a.type), qM);
    }

    private String b(a.C0258a c0258a, String str) {
        String qM;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qM = this.mContext.getString(e.j.me);
        } else {
            qM = qM(c0258a.ffY);
        }
        if (c0258a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), qM));
            sb.append(c0258a.fgc);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), qM));
            sb.append(c0258a.title);
        }
        return sb.toString();
    }

    private String qM(int i) {
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
