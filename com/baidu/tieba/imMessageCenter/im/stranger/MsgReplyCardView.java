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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout cdA;
    private TextView cdB;
    private TextView cdC;
    private TextView cdD;
    private TextView cdE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.g.msg_reply_card_view);
        init();
    }

    private void init() {
        this.cdA = (LinearLayout) findViewById(n.f.reply_card);
        this.cdB = (TextView) findViewById(n.f.reply_title);
        this.cdC = (TextView) findViewById(n.f.reply_content);
        this.cdD = (TextView) findViewById(n.f.reply_quote_content);
        this.cdE = (TextView) findViewById(n.f.reply_frs_name);
        this.cdA.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a ji = c.ji(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.cdB.setText(a(ji, valueOf));
            this.cdC.setText(ji.cdl);
            this.cdD.setText(b(ji, valueOf));
            this.cdE.setText(String.valueOf(ji.cdN) + this.mContext.getString(n.i.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String iR;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = iR(aVar.cdH);
            iR = this.mContext.getString(n.i.you);
        } else {
            string = this.mContext.getString(n.i.you);
            iR = iR(aVar.cdH);
        }
        return String.format(this.mContext.getString(n.i.add_friend_card_title), string, getType(aVar.type), iR);
    }

    private String b(c.a aVar, String str) {
        String iR;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            iR = this.mContext.getString(n.i.me);
        } else {
            iR = iR(aVar.cdH);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(n.i.add_friend_card_quote_comment), iR));
            sb.append(aVar.cdL);
        } else {
            sb.append(String.format(this.mContext.getString(n.i.add_friend_card_quote_thread), iR));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String iR(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(n.i.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(n.i.she);
        }
        return this.mContext.getResources().getString(n.i.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(n.i.add_friend_card_title_comment) : this.mContext.getResources().getString(n.i.add_friend_card_title_thread);
    }
}
