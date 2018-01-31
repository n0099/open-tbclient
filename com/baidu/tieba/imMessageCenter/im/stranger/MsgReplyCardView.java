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
    private LinearLayout eNt;
    private TextView eNu;
    private TextView eNv;
    private TextView eNw;
    private TextView eNx;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eNt = (LinearLayout) findViewById(d.g.reply_card);
        this.eNu = (TextView) findViewById(d.g.reply_title);
        this.eNv = (TextView) findViewById(d.g.reply_content);
        this.eNw = (TextView) findViewById(d.g.reply_quote_content);
        this.eNx = (TextView) findViewById(d.g.reply_frs_name);
        this.eNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.erF.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0128a nP = a.nP(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eNu.setText(a(nP, valueOf));
            this.eNv.setText(nP.eNc);
            this.eNw.setText(b(nP, valueOf));
            this.eNx.setText(nP.bjk + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0128a c0128a, String str) {
        String string;
        String qK;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = qK(c0128a.eNz);
            qK = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            qK = qK(c0128a.eNz);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0128a.type), qK);
    }

    private String b(a.C0128a c0128a, String str) {
        String qK;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            qK = this.mContext.getString(d.j.me);
        } else {
            qK = qK(c0128a.eNz);
        }
        if (c0128a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), qK));
            sb.append(c0128a.eND);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), qK));
            sb.append(c0128a.title);
        }
        return sb.toString();
    }

    private String qK(int i) {
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
