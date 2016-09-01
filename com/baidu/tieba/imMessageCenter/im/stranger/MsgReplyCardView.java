package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.as;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout drA;
    private TextView drB;
    private TextView drC;
    private TextView drD;
    private TextView drE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.drA = (LinearLayout) findViewById(t.g.reply_card);
        this.drB = (TextView) findViewById(t.g.reply_title);
        this.drC = (TextView) findViewById(t.g.reply_content);
        this.drD = (TextView) findViewById(t.g.reply_quote_content);
        this.drE = (TextView) findViewById(t.g.reply_frs_name);
        this.drA.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a mx = c.mx(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.drB.setText(a(mx, valueOf));
            this.drC.setText(mx.drh);
            this.drD.setText(b(mx, valueOf));
            this.drE.setText(String.valueOf(mx.drN) + this.mContext.getString(t.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mj;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mj(aVar.drH);
            mj = this.mContext.getString(t.j.you);
        } else {
            string = this.mContext.getString(t.j.you);
            mj = mj(aVar.drH);
        }
        return String.format(this.mContext.getString(t.j.add_friend_card_title), string, getType(aVar.type), mj);
    }

    private String b(c.a aVar, String str) {
        String mj;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mj = this.mContext.getString(t.j.me);
        } else {
            mj = mj(aVar.drH);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_comment), mj));
            sb.append(aVar.drL);
        } else {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_thread), mj));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mj(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(t.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(t.j.she);
        }
        return this.mContext.getResources().getString(t.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(t.j.add_friend_card_title_comment) : this.mContext.getResources().getString(t.j.add_friend_card_title_thread);
    }
}
