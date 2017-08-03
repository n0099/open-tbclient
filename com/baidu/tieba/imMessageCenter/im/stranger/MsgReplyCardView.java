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
    private LinearLayout dBQ;
    private TextView dBR;
    private TextView dBS;
    private TextView dBT;
    private TextView dBU;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dBQ = (LinearLayout) findViewById(d.h.reply_card);
        this.dBR = (TextView) findViewById(d.h.reply_title);
        this.dBS = (TextView) findViewById(d.h.reply_content);
        this.dBT = (TextView) findViewById(d.h.reply_quote_content);
        this.dBU = (TextView) findViewById(d.h.reply_frs_name);
        this.dBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.dfO.a(view, 14, MsgReplyCardView.this.avi, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0102a mG = a.mG(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dBR.setText(a(mG, valueOf));
            this.dBS.setText(mG.dBz);
            this.dBT.setText(b(mG, valueOf));
            this.dBU.setText(mG.dCd + this.mContext.getString(d.l.bar));
        }
    }

    private String a(a.C0102a c0102a, String str) {
        String string;
        String mM;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mM(c0102a.dBX);
            mM = this.mContext.getString(d.l.you);
        } else {
            string = this.mContext.getString(d.l.you);
            mM = mM(c0102a.dBX);
        }
        return String.format(this.mContext.getString(d.l.add_friend_card_title), string, getType(c0102a.type), mM);
    }

    private String b(a.C0102a c0102a, String str) {
        String mM;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mM = this.mContext.getString(d.l.me);
        } else {
            mM = mM(c0102a.dBX);
        }
        if (c0102a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_comment), mM));
            sb.append(c0102a.dCb);
        } else {
            sb.append(String.format(this.mContext.getString(d.l.add_friend_card_quote_thread), mM));
            sb.append(c0102a.title);
        }
        return sb.toString();
    }

    private String mM(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.l.she);
        }
        return this.mContext.getResources().getString(d.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.l.add_friend_card_title_comment) : this.mContext.getResources().getString(d.l.topic_thread);
    }
}
