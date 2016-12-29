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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private TextView dbA;
    private TextView dbB;
    private LinearLayout dbx;
    private TextView dby;
    private TextView dbz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dbx = (LinearLayout) findViewById(r.g.reply_card);
        this.dby = (TextView) findViewById(r.g.reply_title);
        this.dbz = (TextView) findViewById(r.g.reply_content);
        this.dbA = (TextView) findViewById(r.g.reply_quote_content);
        this.dbB = (TextView) findViewById(r.g.reply_frs_name);
        this.dbx.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lk = c.lk(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dby.setText(a(lk, valueOf));
            this.dbz.setText(lk.dbi);
            this.dbA.setText(b(lk, valueOf));
            this.dbB.setText(String.valueOf(lk.dbK) + this.mContext.getString(r.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String lC;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = lC(aVar.dbE);
            lC = this.mContext.getString(r.j.you);
        } else {
            string = this.mContext.getString(r.j.you);
            lC = lC(aVar.dbE);
        }
        return String.format(this.mContext.getString(r.j.add_friend_card_title), string, getType(aVar.type), lC);
    }

    private String b(c.a aVar, String str) {
        String lC;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            lC = this.mContext.getString(r.j.me);
        } else {
            lC = lC(aVar.dbE);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_comment), lC));
            sb.append(aVar.dbI);
        } else {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_thread), lC));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String lC(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(r.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(r.j.she);
        }
        return this.mContext.getResources().getString(r.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(r.j.add_friend_card_title_comment) : this.mContext.getResources().getString(r.j.topic_thread);
    }
}
