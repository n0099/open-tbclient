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
    private LinearLayout dZr;
    private TextView dZs;
    private TextView dZt;
    private TextView dZu;
    private TextView dZv;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dZr = (LinearLayout) findViewById(d.g.reply_card);
        this.dZs = (TextView) findViewById(d.g.reply_title);
        this.dZt = (TextView) findViewById(d.g.reply_content);
        this.dZu = (TextView) findViewById(d.g.reply_quote_content);
        this.dZv = (TextView) findViewById(d.g.reply_frs_name);
        this.dZr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dDF.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0117a nw = a.nw(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dZs.setText(a(nw, valueOf));
            this.dZt.setText(nw.dZa);
            this.dZu.setText(b(nw, valueOf));
            this.dZv.setText(nw.auC + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0117a c0117a, String str) {
        String string;
        String nZ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nZ(c0117a.dZx);
            nZ = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            nZ = nZ(c0117a.dZx);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0117a.type), nZ);
    }

    private String b(a.C0117a c0117a, String str) {
        String nZ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nZ = this.mContext.getString(d.j.me);
        } else {
            nZ = nZ(c0117a.dZx);
        }
        if (c0117a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), nZ));
            sb.append(c0117a.dZB);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), nZ));
            sb.append(c0117a.title);
        }
        return sb.toString();
    }

    private String nZ(int i) {
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
