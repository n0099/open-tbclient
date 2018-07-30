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
    private LinearLayout eFZ;
    private TextView eGa;
    private TextView eGb;
    private TextView eGc;
    private TextView eGd;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eFZ = (LinearLayout) findViewById(d.g.reply_card);
        this.eGa = (TextView) findViewById(d.g.reply_title);
        this.eGb = (TextView) findViewById(d.g.reply_content);
        this.eGc = (TextView) findViewById(d.g.reply_quote_content);
        this.eGd = (TextView) findViewById(d.g.reply_frs_name);
        this.eFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.ekA.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0185a oY = a.oY(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eGa.setText(a(oY, valueOf));
            this.eGb.setText(oY.eFJ);
            this.eGc.setText(b(oY, valueOf));
            this.eGd.setText(oY.aGb + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0185a c0185a, String str) {
        String string;
        String oK;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = oK(c0185a.eGf);
            oK = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            oK = oK(c0185a.eGf);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0185a.type), oK);
    }

    private String b(a.C0185a c0185a, String str) {
        String oK;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            oK = this.mContext.getString(d.j.me);
        } else {
            oK = oK(c0185a.eGf);
        }
        if (c0185a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), oK));
            sb.append(c0185a.eGj);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), oK));
            sb.append(c0185a.title);
        }
        return sb.toString();
    }

    private String oK(int i) {
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
