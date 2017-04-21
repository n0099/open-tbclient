package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ar;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class MsgReplyCardView extends ar {
    private LinearLayout dlS;
    private TextView dlT;
    private TextView dlU;
    private TextView dlV;
    private TextView dlW;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dlS = (LinearLayout) findViewById(w.h.reply_card);
        this.dlT = (TextView) findViewById(w.h.reply_title);
        this.dlU = (TextView) findViewById(w.h.reply_content);
        this.dlV = (TextView) findViewById(w.h.reply_quote_content);
        this.dlW = (TextView) findViewById(w.h.reply_frs_name);
        this.dlS.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lf = c.lf(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dlT.setText(a(lf, valueOf));
            this.dlU.setText(lf.dlD);
            this.dlV.setText(b(lf, valueOf));
            this.dlW.setText(String.valueOf(lf.dmf) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mm;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mm(aVar.dlZ);
            mm = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            mm = mm(aVar.dlZ);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), mm);
    }

    private String b(c.a aVar, String str) {
        String mm;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mm = this.mContext.getString(w.l.me);
        } else {
            mm = mm(aVar.dlZ);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), mm));
            sb.append(aVar.dmd);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), mm));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mm(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(w.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(w.l.she);
        }
        return this.mContext.getResources().getString(w.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(w.l.add_friend_card_title_comment) : this.mContext.getResources().getString(w.l.topic_thread);
    }
}
