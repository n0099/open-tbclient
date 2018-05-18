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
    private LinearLayout emX;
    private TextView emY;
    private TextView emZ;
    private TextView ena;
    private TextView enb;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_reply_card_view);
        init();
    }

    private void init() {
        this.emX = (LinearLayout) findViewById(d.g.reply_card);
        this.emY = (TextView) findViewById(d.g.reply_title);
        this.emZ = (TextView) findViewById(d.g.reply_content);
        this.ena = (TextView) findViewById(d.g.reply_quote_content);
        this.enb = (TextView) findViewById(d.g.reply_frs_name);
        this.emX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MsgReplyCardView.this.dRD.a(view2, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        if (chatMessage != null) {
            a.C0168a oi = a.oi(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.emY.setText(a(oi, valueOf));
            this.emZ.setText(oi.emH);
            this.ena.setText(b(oi, valueOf));
            this.enb.setText(oi.awU + this.mContext.getString(d.k.forum));
        }
    }

    private String a(a.C0168a c0168a, String str) {
        String string;
        String od;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = od(c0168a.ene);
            od = this.mContext.getString(d.k.you);
        } else {
            string = this.mContext.getString(d.k.you);
            od = od(c0168a.ene);
        }
        return String.format(this.mContext.getString(d.k.add_friend_card_title), string, getType(c0168a.type), od);
    }

    private String b(a.C0168a c0168a, String str) {
        String od;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            od = this.mContext.getString(d.k.me);
        } else {
            od = od(c0168a.ene);
        }
        if (c0168a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_comment), od));
            sb.append(c0168a.eni);
        } else {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_thread), od));
            sb.append(c0168a.title);
        }
        return sb.toString();
    }

    private String od(int i) {
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
