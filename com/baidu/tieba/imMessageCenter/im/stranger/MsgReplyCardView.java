package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.as;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout bKH;
    private TextView bKI;
    private TextView bKJ;
    private TextView bKK;
    private TextView bKL;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_reply_card_view);
        init();
    }

    private void init() {
        this.bKH = (LinearLayout) findViewById(i.f.reply_card);
        this.bKI = (TextView) findViewById(i.f.reply_title);
        this.bKJ = (TextView) findViewById(i.f.reply_content);
        this.bKK = (TextView) findViewById(i.f.reply_quote_content);
        this.bKL = (TextView) findViewById(i.f.reply_frs_name);
        this.bKH.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a iG = c.iG(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.bKI.setText(a(iG, valueOf));
            this.bKJ.setText(iG.replyContent);
            this.bKK.setText(b(iG, valueOf));
            this.bKL.setText(String.valueOf(iG.bKU) + this.mContext.getString(i.h.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String hK;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = hK(aVar.bKO);
            hK = this.mContext.getString(i.h.you);
        } else {
            string = this.mContext.getString(i.h.you);
            hK = hK(aVar.bKO);
        }
        return String.format(this.mContext.getString(i.h.add_friend_card_title), string, getType(aVar.type), hK);
    }

    private String b(c.a aVar, String str) {
        String hK;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            hK = this.mContext.getString(i.h.me);
        } else {
            hK = hK(aVar.bKO);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_comment), hK));
            sb.append(aVar.bKS);
        } else {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_thread), hK));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String hK(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(i.h.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(i.h.she);
        }
        return this.mContext.getResources().getString(i.h.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(i.h.add_friend_card_title_comment) : this.mContext.getResources().getString(i.h.add_friend_card_title_thread);
    }
}
