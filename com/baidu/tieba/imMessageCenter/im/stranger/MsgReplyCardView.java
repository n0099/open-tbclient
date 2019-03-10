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
/* loaded from: classes4.dex */
public class MsgReplyCardView extends g {
    private LinearLayout gwN;
    private TextView gwO;
    private TextView gwP;
    private TextView gwQ;
    private TextView gwR;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gwN = (LinearLayout) findViewById(d.g.reply_card);
        this.gwO = (TextView) findViewById(d.g.reply_title);
        this.gwP = (TextView) findViewById(d.g.reply_content);
        this.gwQ = (TextView) findViewById(d.g.reply_quote_content);
        this.gwR = (TextView) findViewById(d.g.reply_frs_name);
        this.gwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gbv.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0263a xJ = a.xJ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gwO.setText(a(xJ, valueOf));
            this.gwP.setText(xJ.gwx);
            this.gwQ.setText(b(xJ, valueOf));
            this.gwR.setText(xJ.cbs + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0263a c0263a, String str) {
        String string;
        String ux;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = ux(c0263a.gwT);
            ux = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            ux = ux(c0263a.gwT);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0263a.type), ux);
    }

    private String b(a.C0263a c0263a, String str) {
        String ux;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            ux = this.mContext.getString(d.j.me);
        } else {
            ux = ux(c0263a.gwT);
        }
        if (c0263a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), ux));
            sb.append(c0263a.gwX);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), ux));
            sb.append(c0263a.title);
        }
        return sb.toString();
    }

    private String ux(int i) {
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
