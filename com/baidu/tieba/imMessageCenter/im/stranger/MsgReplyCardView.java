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
    private LinearLayout djB;
    private TextView djC;
    private TextView djD;
    private TextView djE;
    private TextView djF;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.djB = (LinearLayout) findViewById(w.h.reply_card);
        this.djC = (TextView) findViewById(w.h.reply_title);
        this.djD = (TextView) findViewById(w.h.reply_content);
        this.djE = (TextView) findViewById(w.h.reply_quote_content);
        this.djF = (TextView) findViewById(w.h.reply_frs_name);
        this.djB.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a le = c.le(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.djC.setText(a(le, valueOf));
            this.djD.setText(le.djm);
            this.djE.setText(b(le, valueOf));
            this.djF.setText(String.valueOf(le.djO) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mg;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mg(aVar.djI);
            mg = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            mg = mg(aVar.djI);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), mg);
    }

    private String b(c.a aVar, String str) {
        String mg;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mg = this.mContext.getString(w.l.me);
        } else {
            mg = mg(aVar.djI);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), mg));
            sb.append(aVar.djM);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), mg));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mg(int i) {
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
