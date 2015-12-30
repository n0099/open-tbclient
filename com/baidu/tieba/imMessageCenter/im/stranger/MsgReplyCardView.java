package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.as;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout chA;
    private TextView chB;
    private TextView chC;
    private TextView chD;
    private TextView chE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.chA = (LinearLayout) findViewById(n.g.reply_card);
        this.chB = (TextView) findViewById(n.g.reply_title);
        this.chC = (TextView) findViewById(n.g.reply_content);
        this.chD = (TextView) findViewById(n.g.reply_quote_content);
        this.chE = (TextView) findViewById(n.g.reply_frs_name);
        this.chA.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a jv = c.jv(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.chB.setText(a(jv, valueOf));
            this.chC.setText(jv.chl);
            this.chD.setText(b(jv, valueOf));
            this.chE.setText(String.valueOf(jv.chN) + this.mContext.getString(n.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String jq;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = jq(aVar.chH);
            jq = this.mContext.getString(n.j.you);
        } else {
            string = this.mContext.getString(n.j.you);
            jq = jq(aVar.chH);
        }
        return String.format(this.mContext.getString(n.j.add_friend_card_title), string, getType(aVar.type), jq);
    }

    private String b(c.a aVar, String str) {
        String jq;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            jq = this.mContext.getString(n.j.me);
        } else {
            jq = jq(aVar.chH);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(n.j.add_friend_card_quote_comment), jq));
            sb.append(aVar.chL);
        } else {
            sb.append(String.format(this.mContext.getString(n.j.add_friend_card_quote_thread), jq));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String jq(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(n.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(n.j.she);
        }
        return this.mContext.getResources().getString(n.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(n.j.add_friend_card_title_comment) : this.mContext.getResources().getString(n.j.add_friend_card_title_thread);
    }
}
