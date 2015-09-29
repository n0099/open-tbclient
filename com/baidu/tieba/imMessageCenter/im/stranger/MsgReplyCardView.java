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
    private LinearLayout bNR;
    private TextView bNS;
    private TextView bNT;
    private TextView bNU;
    private TextView bNV;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_reply_card_view);
        init();
    }

    private void init() {
        this.bNR = (LinearLayout) findViewById(i.f.reply_card);
        this.bNS = (TextView) findViewById(i.f.reply_title);
        this.bNT = (TextView) findViewById(i.f.reply_content);
        this.bNU = (TextView) findViewById(i.f.reply_quote_content);
        this.bNV = (TextView) findViewById(i.f.reply_frs_name);
        this.bNR.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a iM = c.iM(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.bNS.setText(a(iM, valueOf));
            this.bNT.setText(iM.bNC);
            this.bNU.setText(b(iM, valueOf));
            this.bNV.setText(String.valueOf(iM.bOe) + this.mContext.getString(i.h.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String hQ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = hQ(aVar.bNY);
            hQ = this.mContext.getString(i.h.you);
        } else {
            string = this.mContext.getString(i.h.you);
            hQ = hQ(aVar.bNY);
        }
        return String.format(this.mContext.getString(i.h.add_friend_card_title), string, getType(aVar.type), hQ);
    }

    private String b(c.a aVar, String str) {
        String hQ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            hQ = this.mContext.getString(i.h.me);
        } else {
            hQ = hQ(aVar.bNY);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_comment), hQ));
            sb.append(aVar.bOc);
        } else {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_thread), hQ));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String hQ(int i) {
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
