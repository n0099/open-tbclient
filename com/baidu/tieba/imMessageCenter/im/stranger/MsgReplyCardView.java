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
/* loaded from: classes2.dex */
public class MsgReplyCardView extends g {
    private LinearLayout dFe;
    private TextView dFf;
    private TextView dFg;
    private TextView dFh;
    private TextView dFi;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dFe = (LinearLayout) findViewById(d.h.reply_card);
        this.dFf = (TextView) findViewById(d.h.reply_title);
        this.dFg = (TextView) findViewById(d.h.reply_content);
        this.dFh = (TextView) findViewById(d.h.reply_quote_content);
        this.dFi = (TextView) findViewById(d.h.reply_frs_name);
        this.dFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.djd.a(view, 14, MsgReplyCardView.this.awB, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0102a mT = a.mT(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dFf.setText(a(mT, valueOf));
            this.dFg.setText(mT.dEN);
            this.dFh.setText(b(mT, valueOf));
            this.dFi.setText(mT.dFr + this.mContext.getString(d.l.bar));
        }
    }

    private String a(a.C0102a c0102a, String str) {
        String string;
        String mW;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mW(c0102a.dFl);
            mW = this.mContext.getString(d.l.you);
        } else {
            string = this.mContext.getString(d.l.you);
            mW = mW(c0102a.dFl);
        }
        return String.format(this.mContext.getString(d.l.add_friend_card_title), string, getType(c0102a.type), mW);
    }

    private String b(a.C0102a c0102a, String str) {
        String mW;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mW = this.mContext.getString(d.l.me);
        } else {
            mW = mW(c0102a.dFl);
        }
        if (c0102a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_comment), mW));
            sb.append(c0102a.dFp);
        } else {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_thread), mW));
            sb.append(c0102a.title);
        }
        return sb.toString();
    }

    private String mW(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.l.she);
        }
        return this.mContext.getResources().getString(d.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.l.add_friend_card_title_comment) : this.mContext.getResources().getString(d.l.topic_thread);
    }
}
