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
/* loaded from: classes2.dex */
public class MsgReplyCardView extends ar {
    private LinearLayout dto;
    private TextView dtp;
    private TextView dtq;
    private TextView dtr;
    private TextView dts;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dto = (LinearLayout) findViewById(w.h.reply_card);
        this.dtp = (TextView) findViewById(w.h.reply_title);
        this.dtq = (TextView) findViewById(w.h.reply_content);
        this.dtr = (TextView) findViewById(w.h.reply_quote_content);
        this.dts = (TextView) findViewById(w.h.reply_frs_name);
        this.dto.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a mq = c.mq(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dtp.setText(a(mq, valueOf));
            this.dtq.setText(mq.dsX);
            this.dtr.setText(b(mq, valueOf));
            this.dts.setText(String.valueOf(mq.dtB) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mE;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mE(aVar.dtv);
            mE = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            mE = mE(aVar.dtv);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), mE);
    }

    private String b(c.a aVar, String str) {
        String mE;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mE = this.mContext.getString(w.l.me);
        } else {
            mE = mE(aVar.dtv);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), mE));
            sb.append(aVar.dtz);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), mE));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mE(int i) {
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
