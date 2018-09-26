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
/* loaded from: classes2.dex */
public class MsgReplyCardView extends g {
    private LinearLayout eNl;
    private TextView eNm;
    private TextView eNn;
    private TextView eNo;
    private TextView eNp;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eNl = (LinearLayout) findViewById(e.g.reply_card);
        this.eNm = (TextView) findViewById(e.g.reply_title);
        this.eNn = (TextView) findViewById(e.g.reply_content);
        this.eNo = (TextView) findViewById(e.g.reply_quote_content);
        this.eNp = (TextView) findViewById(e.g.reply_frs_name);
        this.eNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.erQ.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0187a pF = a.pF(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eNm.setText(a(pF, valueOf));
            this.eNn.setText(pF.eMV);
            this.eNo.setText(b(pF, valueOf));
            this.eNp.setText(pF.aJo + this.mContext.getString(e.j.forum));
        }
    }

    private String a(a.C0187a c0187a, String str) {
        String string;
        String po;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = po(c0187a.eNr);
            po = this.mContext.getString(e.j.you);
        } else {
            string = this.mContext.getString(e.j.you);
            po = po(c0187a.eNr);
        }
        return String.format(this.mContext.getString(e.j.add_friend_card_title), string, getType(c0187a.type), po);
    }

    private String b(a.C0187a c0187a, String str) {
        String po;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            po = this.mContext.getString(e.j.me);
        } else {
            po = po(c0187a.eNr);
        }
        if (c0187a.type == 1) {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_comment), po));
            sb.append(c0187a.eNv);
        } else {
            sb.append(String.format(this.mContext.getString(e.j.add_friend_card_quote_thread), po));
            sb.append(c0187a.title);
        }
        return sb.toString();
    }

    private String po(int i) {
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
