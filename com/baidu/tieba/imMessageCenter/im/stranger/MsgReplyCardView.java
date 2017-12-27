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
    private TextView eLA;
    private TextView eLB;
    private TextView eLC;
    private LinearLayout eLy;
    private TextView eLz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eLy = (LinearLayout) findViewById(d.g.reply_card);
        this.eLz = (TextView) findViewById(d.g.reply_title);
        this.eLA = (TextView) findViewById(d.g.reply_content);
        this.eLB = (TextView) findViewById(d.g.reply_quote_content);
        this.eLC = (TextView) findViewById(d.g.reply_frs_name);
        this.eLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.epM.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0128a nF = a.nF(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eLz.setText(a(nF, valueOf));
            this.eLA.setText(nF.eLh);
            this.eLB.setText(b(nF, valueOf));
            this.eLC.setText(nF.biL + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0128a c0128a, String str) {
        String string;
        String qR;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qR(c0128a.eLE);
            qR = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            qR = qR(c0128a.eLE);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0128a.type), qR);
    }

    private String b(a.C0128a c0128a, String str) {
        String qR;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qR = this.mContext.getString(d.j.me);
        } else {
            qR = qR(c0128a.eLE);
        }
        if (c0128a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), qR));
            sb.append(c0128a.eLI);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), qR));
            sb.append(c0128a.title);
        }
        return sb.toString();
    }

    private String qR(int i) {
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
