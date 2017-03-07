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
    private LinearLayout dlc;
    private TextView dld;
    private TextView dle;
    private TextView dlf;
    private TextView dlg;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dlc = (LinearLayout) findViewById(w.h.reply_card);
        this.dld = (TextView) findViewById(w.h.reply_title);
        this.dle = (TextView) findViewById(w.h.reply_content);
        this.dlf = (TextView) findViewById(w.h.reply_quote_content);
        this.dlg = (TextView) findViewById(w.h.reply_frs_name);
        this.dlc.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a kY = c.kY(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dld.setText(a(kY, valueOf));
            this.dle.setText(kY.dkN);
            this.dlf.setText(b(kY, valueOf));
            this.dlg.setText(String.valueOf(kY.dlp) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mf;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mf(aVar.dlj);
            mf = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            mf = mf(aVar.dlj);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), mf);
    }

    private String b(c.a aVar, String str) {
        String mf;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mf = this.mContext.getString(w.l.me);
        } else {
            mf = mf(aVar.dlj);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), mf));
            sb.append(aVar.dln);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), mf));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mf(int i) {
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
