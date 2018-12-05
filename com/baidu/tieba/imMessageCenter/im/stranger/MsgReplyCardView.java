package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes4.dex */
public class MsgReplyCardView extends g {
    private LinearLayout fdb;
    private TextView fdc;
    private TextView fdd;
    private TextView fde;
    private TextView fdf;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.fdb = (LinearLayout) findViewById(e.g.reply_card);
        this.fdc = (TextView) findViewById(e.g.reply_title);
        this.fdd = (TextView) findViewById(e.g.reply_content);
        this.fde = (TextView) findViewById(e.g.reply_quote_content);
        this.fdf = (TextView) findViewById(e.g.reply_frs_name);
        this.fdb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.eHP.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0258a qK = a.qK(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.fdc.setText(a(qK, valueOf));
            this.fdd.setText(qK.fcL);
            this.fde.setText(b(qK, valueOf));
            this.fdf.setText(qK.aSf + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0258a c0258a, String str) {
        String string;
        String qz;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qz(c0258a.fdh);
            qz = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            qz = qz(c0258a.fdh);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0258a.type), qz);
    }

    private String b(a.C0258a c0258a, String str) {
        String qz;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qz = this.mContext.getString(e.j.me);
        } else {
            qz = qz(c0258a.fdh);
        }
        if (c0258a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), qz));
            sb.append(c0258a.fdl);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), qz));
            sb.append(c0258a.title);
        }
        return sb.toString();
    }

    private String qz(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(e.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(e.j.she);
        }
        return this.mContext.getResources().getString(e.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(e.j.add_friend_card_title_comment) : this.mContext.getResources().getString(e.j.topic_thread);
    }
}
