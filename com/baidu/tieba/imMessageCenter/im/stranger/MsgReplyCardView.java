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
    private LinearLayout cxB;
    private TextView cxC;
    private TextView cxD;
    private TextView cxE;
    private TextView cxF;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.cxB = (LinearLayout) findViewById(t.g.reply_card);
        this.cxC = (TextView) findViewById(t.g.reply_title);
        this.cxD = (TextView) findViewById(t.g.reply_content);
        this.cxE = (TextView) findViewById(t.g.reply_quote_content);
        this.cxF = (TextView) findViewById(t.g.reply_frs_name);
        this.cxB.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a km = c.km(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.cxC.setText(a(km, valueOf));
            this.cxD.setText(km.cxm);
            this.cxE.setText(b(km, valueOf));
            this.cxF.setText(String.valueOf(km.cxO) + this.mContext.getString(t.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String jY;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = jY(aVar.cxI);
            jY = this.mContext.getString(t.j.you);
        } else {
            string = this.mContext.getString(t.j.you);
            jY = jY(aVar.cxI);
        }
        return String.format(this.mContext.getString(t.j.add_friend_card_title), string, getType(aVar.type), jY);
    }

    private String b(c.a aVar, String str) {
        String jY;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            jY = this.mContext.getString(t.j.me);
        } else {
            jY = jY(aVar.cxI);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_comment), jY));
            sb.append(aVar.cxM);
        } else {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_thread), jY));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String jY(int i) {
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
