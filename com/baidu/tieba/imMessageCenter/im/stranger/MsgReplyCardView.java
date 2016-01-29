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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout cmb;
    private TextView cmc;
    private TextView cme;
    private TextView cmf;
    private TextView cmg;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.cmb = (LinearLayout) findViewById(t.g.reply_card);
        this.cmc = (TextView) findViewById(t.g.reply_title);
        this.cme = (TextView) findViewById(t.g.reply_content);
        this.cmf = (TextView) findViewById(t.g.reply_quote_content);
        this.cmg = (TextView) findViewById(t.g.reply_frs_name);
        this.cmb.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a jA = c.jA(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.cmc.setText(a(jA, valueOf));
            this.cme.setText(jA.clM);
            this.cmf.setText(b(jA, valueOf));
            this.cmg.setText(String.valueOf(jA.cmp) + this.mContext.getString(t.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String jO;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = jO(aVar.cmj);
            jO = this.mContext.getString(t.j.you);
        } else {
            string = this.mContext.getString(t.j.you);
            jO = jO(aVar.cmj);
        }
        return String.format(this.mContext.getString(t.j.add_friend_card_title), string, getType(aVar.type), jO);
    }

    private String b(c.a aVar, String str) {
        String jO;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            jO = this.mContext.getString(t.j.me);
        } else {
            jO = jO(aVar.cmj);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_comment), jO));
            sb.append(aVar.cmn);
        } else {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_thread), jO));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String jO(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(t.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(t.j.she);
        }
        return this.mContext.getResources().getString(t.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(t.j.add_friend_card_title_comment) : this.mContext.getResources().getString(t.j.add_friend_card_title_thread);
    }
}
