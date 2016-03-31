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
    private LinearLayout cwE;
    private TextView cwF;
    private TextView cwG;
    private TextView cwH;
    private TextView cwI;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.cwE = (LinearLayout) findViewById(t.g.reply_card);
        this.cwF = (TextView) findViewById(t.g.reply_title);
        this.cwG = (TextView) findViewById(t.g.reply_content);
        this.cwH = (TextView) findViewById(t.g.reply_quote_content);
        this.cwI = (TextView) findViewById(t.g.reply_frs_name);
        this.cwE.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a kj = c.kj(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.cwF.setText(a(kj, valueOf));
            this.cwG.setText(kj.cwp);
            this.cwH.setText(b(kj, valueOf));
            this.cwI.setText(String.valueOf(kj.cwR) + this.mContext.getString(t.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String ku;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = ku(aVar.cwL);
            ku = this.mContext.getString(t.j.you);
        } else {
            string = this.mContext.getString(t.j.you);
            ku = ku(aVar.cwL);
        }
        return String.format(this.mContext.getString(t.j.add_friend_card_title), string, getType(aVar.type), ku);
    }

    private String b(c.a aVar, String str) {
        String ku;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            ku = this.mContext.getString(t.j.me);
        } else {
            ku = ku(aVar.cwL);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_comment), ku));
            sb.append(aVar.cwP);
        } else {
            sb.append(String.format(this.mContext.getString(t.j.add_friend_card_quote_thread), ku));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String ku(int i) {
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
