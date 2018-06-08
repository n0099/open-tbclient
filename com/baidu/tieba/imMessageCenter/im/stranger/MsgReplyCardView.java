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
    private LinearLayout eyq;
    private TextView eyr;
    private TextView eys;
    private TextView eyt;
    private TextView eyu;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eyq = (LinearLayout) findViewById(d.g.reply_card);
        this.eyr = (TextView) findViewById(d.g.reply_title);
        this.eys = (TextView) findViewById(d.g.reply_content);
        this.eyt = (TextView) findViewById(d.g.reply_quote_content);
        this.eyu = (TextView) findViewById(d.g.reply_frs_name);
        this.eyq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.ecQ.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0184a oV = a.oV(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eyr.setText(a(oV, valueOf));
            this.eys.setText(oV.exZ);
            this.eyt.setText(b(oV, valueOf));
            this.eyu.setText(oV.aFh + this.mContext.getString(d.k.forum));
        }
    }

    private String a(a.C0184a c0184a, String str) {
        String string;
        String op;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = op(c0184a.eyw);
            op = this.mContext.getString(d.k.you);
        } else {
            string = this.mContext.getString(d.k.you);
            op = op(c0184a.eyw);
        }
        return String.format(this.mContext.getString(d.k.add_friend_card_title), string, getType(c0184a.type), op);
    }

    private String b(a.C0184a c0184a, String str) {
        String op;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            op = this.mContext.getString(d.k.me);
        } else {
            op = op(c0184a.eyw);
        }
        if (c0184a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_comment), op));
            sb.append(c0184a.eyA);
        } else {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_thread), op));
            sb.append(c0184a.title);
        }
        return sb.toString();
    }

    private String op(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.k.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.k.she);
        }
        return this.mContext.getResources().getString(d.k.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.k.add_friend_card_title_comment) : this.mContext.getResources().getString(d.k.topic_thread);
    }
}
