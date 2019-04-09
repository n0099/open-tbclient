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
/* loaded from: classes4.dex */
public class MsgReplyCardView extends g {
    private LinearLayout gwA;
    private TextView gwB;
    private TextView gwC;
    private TextView gwD;
    private TextView gwE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gwA = (LinearLayout) findViewById(d.g.reply_card);
        this.gwB = (TextView) findViewById(d.g.reply_title);
        this.gwC = (TextView) findViewById(d.g.reply_content);
        this.gwD = (TextView) findViewById(d.g.reply_quote_content);
        this.gwE = (TextView) findViewById(d.g.reply_frs_name);
        this.gwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gbi.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0326a xG = a.xG(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gwB.setText(a(xG, valueOf));
            this.gwC.setText(xG.gwk);
            this.gwD.setText(b(xG, valueOf));
            this.gwE.setText(xG.cbv + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0326a c0326a, String str) {
        String string;
        String ut;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = ut(c0326a.gwG);
            ut = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            ut = ut(c0326a.gwG);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0326a.type), ut);
    }

    private String b(a.C0326a c0326a, String str) {
        String ut;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            ut = this.mContext.getString(d.j.me);
        } else {
            ut = ut(c0326a.gwG);
        }
        if (c0326a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), ut));
            sb.append(c0326a.gwK);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), ut));
            sb.append(c0326a.title);
        }
        return sb.toString();
    }

    private String ut(int i) {
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
