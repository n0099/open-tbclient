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
    private TextView bOA;
    private TextView bOB;
    private LinearLayout bOx;
    private TextView bOy;
    private TextView bOz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_reply_card_view);
        init();
    }

    private void init() {
        this.bOx = (LinearLayout) findViewById(i.f.reply_card);
        this.bOy = (TextView) findViewById(i.f.reply_title);
        this.bOz = (TextView) findViewById(i.f.reply_content);
        this.bOA = (TextView) findViewById(i.f.reply_quote_content);
        this.bOB = (TextView) findViewById(i.f.reply_frs_name);
        this.bOx.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a iO = c.iO(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.bOy.setText(a(iO, valueOf));
            this.bOz.setText(iO.bOi);
            this.bOA.setText(b(iO, valueOf));
            this.bOB.setText(String.valueOf(iO.bOK) + this.mContext.getString(i.h.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String id;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = id(aVar.bOE);
            id = this.mContext.getString(i.h.you);
        } else {
            string = this.mContext.getString(i.h.you);
            id = id(aVar.bOE);
        }
        return String.format(this.mContext.getString(i.h.add_friend_card_title), string, getType(aVar.type), id);
    }

    private String b(c.a aVar, String str) {
        String id;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            id = this.mContext.getString(i.h.me);
        } else {
            id = id(aVar.bOE);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_comment), id));
            sb.append(aVar.bOI);
        } else {
            sb.append(String.format(this.mContext.getString(i.h.add_friend_card_quote_thread), id));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String id(int i) {
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
