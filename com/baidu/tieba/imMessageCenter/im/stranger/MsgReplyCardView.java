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
    private LinearLayout dZv;
    private TextView dZw;
    private TextView dZx;
    private TextView dZy;
    private TextView dZz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dZv = (LinearLayout) findViewById(d.g.reply_card);
        this.dZw = (TextView) findViewById(d.g.reply_title);
        this.dZx = (TextView) findViewById(d.g.reply_content);
        this.dZy = (TextView) findViewById(d.g.reply_quote_content);
        this.dZz = (TextView) findViewById(d.g.reply_frs_name);
        this.dZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dDJ.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0116a nw = a.nw(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dZw.setText(a(nw, valueOf));
            this.dZx.setText(nw.dZe);
            this.dZy.setText(b(nw, valueOf));
            this.dZz.setText(nw.auF + this.mContext.getString(d.j.forum));
        }
    }

    private String a(a.C0116a c0116a, String str) {
        String string;
        String nZ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = nZ(c0116a.dZB);
            nZ = this.mContext.getString(d.j.you);
        } else {
            string = this.mContext.getString(d.j.you);
            nZ = nZ(c0116a.dZB);
        }
        return String.format(this.mContext.getString(d.j.add_friend_card_title), string, getType(c0116a.type), nZ);
    }

    private String b(a.C0116a c0116a, String str) {
        String nZ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            nZ = this.mContext.getString(d.j.me);
        } else {
            nZ = nZ(c0116a.dZB);
        }
        if (c0116a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_comment), nZ));
            sb.append(c0116a.dZF);
        } else {
            sb.append(String.format(this.mContext.getString(d.j.add_friend_card_quote_thread), nZ));
            sb.append(c0116a.title);
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
