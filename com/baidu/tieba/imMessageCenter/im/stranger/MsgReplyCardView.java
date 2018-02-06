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
    private LinearLayout eRC;
    private TextView eRD;
    private TextView eRE;
    private TextView eRF;
    private TextView eRG;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eRC = (LinearLayout) findViewById(d.g.reply_card);
        this.eRD = (TextView) findViewById(d.g.reply_title);
        this.eRE = (TextView) findViewById(d.g.reply_content);
        this.eRF = (TextView) findViewById(d.g.reply_quote_content);
        this.eRG = (TextView) findViewById(d.g.reply_frs_name);
        this.eRC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.evP.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0184a oa = a.oa(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eRD.setText(a(oa, valueOf));
            this.eRE.setText(oa.eRl);
            this.eRF.setText(b(oa, valueOf));
            this.eRG.setText(oa.blz + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0184a c0184a, String str) {
        String string;
        String qJ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qJ(c0184a.eRI);
            qJ = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            qJ = qJ(c0184a.eRI);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0184a.type), qJ);
    }

    private String b(a.C0184a c0184a, String str) {
        String qJ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qJ = this.mContext.getString(d.j.me);
        } else {
            qJ = qJ(c0184a.eRI);
        }
        if (c0184a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), qJ));
            sb.append(c0184a.eRM);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), qJ));
            sb.append(c0184a.title);
        }
        return sb.toString();
    }

    private String qJ(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.j.she);
        }
        return this.mContext.getResources().getString(d.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.j.add_friend_card_title_comment) : this.mContext.getResources().getString(d.j.topic_thread);
    }
}
