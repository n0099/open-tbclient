package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.as;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout bKa;
    private TextView bKb;
    private TextView bKc;
    private TextView bKd;
    private TextView bKe;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_reply_card_view);
        init();
    }

    private void init() {
        this.bKa = (LinearLayout) findViewById(i.f.reply_card);
        this.bKb = (TextView) findViewById(i.f.reply_title);
        this.bKc = (TextView) findViewById(i.f.reply_content);
        this.bKd = (TextView) findViewById(i.f.reply_quote_content);
        this.bKe = (TextView) findViewById(i.f.reply_frs_name);
        this.bKa.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a ix = c.ix(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.bKb.setText(a(ix, valueOf));
            this.bKc.setText(ix.replyContent);
            this.bKd.setText(b(ix, valueOf));
            this.bKe.setText(String.valueOf(ix.bKn) + this.mContext.getString(i.C0057i.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String hA;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = hA(aVar.bKh);
            hA = this.mContext.getString(i.C0057i.you);
        } else {
            string = this.mContext.getString(i.C0057i.you);
            hA = hA(aVar.bKh);
        }
        return String.format(this.mContext.getString(i.C0057i.add_friend_card_title), string, getType(aVar.type), hA);
    }

    private String b(c.a aVar, String str) {
        String hA;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            hA = this.mContext.getString(i.C0057i.me);
        } else {
            hA = hA(aVar.bKh);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(i.C0057i.add_friend_card_quote_comment), hA));
            sb.append(aVar.bKl);
        } else {
            sb.append(String.format(this.mContext.getString(i.C0057i.add_friend_card_quote_thread), hA));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String hA(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(i.C0057i.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(i.C0057i.she);
        }
        return this.mContext.getResources().getString(i.C0057i.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(i.C0057i.add_friend_card_title_comment) : this.mContext.getResources().getString(i.C0057i.add_friend_card_title_thread);
    }
}
