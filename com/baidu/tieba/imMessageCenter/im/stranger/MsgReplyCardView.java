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
    private LinearLayout eUU;
    private TextView eUV;
    private TextView eUW;
    private TextView eUX;
    private TextView eUY;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eUU = (LinearLayout) findViewById(e.g.reply_card);
        this.eUV = (TextView) findViewById(e.g.reply_title);
        this.eUW = (TextView) findViewById(e.g.reply_content);
        this.eUX = (TextView) findViewById(e.g.reply_quote_content);
        this.eUY = (TextView) findViewById(e.g.reply_frs_name);
        this.eUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.ezH.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0221a qh = a.qh(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eUV.setText(a(qh, valueOf));
            this.eUW.setText(qh.eUE);
            this.eUX.setText(b(qh, valueOf));
            this.eUY.setText(qh.aNQ + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0221a c0221a, String str) {
        String string;
        String pM;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = pM(c0221a.eVa);
            pM = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            pM = pM(c0221a.eVa);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0221a.type), pM);
    }

    private String b(a.C0221a c0221a, String str) {
        String pM;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            pM = this.mContext.getString(e.j.me);
        } else {
            pM = pM(c0221a.eVa);
        }
        if (c0221a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), pM));
            sb.append(c0221a.eVe);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), pM));
            sb.append(c0221a.title);
        }
        return sb.toString();
    }

    private String pM(int i) {
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
