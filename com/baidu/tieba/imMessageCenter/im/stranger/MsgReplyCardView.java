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
    private LinearLayout eUT;
    private TextView eUU;
    private TextView eUV;
    private TextView eUW;
    private TextView eUX;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eUT = (LinearLayout) findViewById(e.g.reply_card);
        this.eUU = (TextView) findViewById(e.g.reply_title);
        this.eUV = (TextView) findViewById(e.g.reply_content);
        this.eUW = (TextView) findViewById(e.g.reply_quote_content);
        this.eUX = (TextView) findViewById(e.g.reply_frs_name);
        this.eUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.ezG.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0221a qh = a.qh(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eUU.setText(a(qh, valueOf));
            this.eUV.setText(qh.eUD);
            this.eUW.setText(b(qh, valueOf));
            this.eUX.setText(qh.aNQ + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0221a c0221a, String str) {
        String string;
        String pM;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = pM(c0221a.eUZ);
            pM = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            pM = pM(c0221a.eUZ);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0221a.type), pM);
    }

    private String b(a.C0221a c0221a, String str) {
        String pM;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            pM = this.mContext.getString(e.j.me);
        } else {
            pM = pM(c0221a.eUZ);
        }
        if (c0221a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), pM));
            sb.append(c0221a.eVd);
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
