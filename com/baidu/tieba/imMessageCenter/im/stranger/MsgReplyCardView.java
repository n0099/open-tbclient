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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout dsX;
    private TextView dsY;
    private TextView dsZ;
    private TextView dta;
    private TextView dtb;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dsX = (LinearLayout) findViewById(r.g.reply_card);
        this.dsY = (TextView) findViewById(r.g.reply_title);
        this.dsZ = (TextView) findViewById(r.g.reply_content);
        this.dta = (TextView) findViewById(r.g.reply_quote_content);
        this.dtb = (TextView) findViewById(r.g.reply_frs_name);
        this.dsX.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a mK = c.mK(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dsY.setText(a(mK, valueOf));
            this.dsZ.setText(mK.dsE);
            this.dta.setText(b(mK, valueOf));
            this.dtb.setText(String.valueOf(mK.dtk) + this.mContext.getString(r.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mr;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mr(aVar.dte);
            mr = this.mContext.getString(r.j.you);
        } else {
            string = this.mContext.getString(r.j.you);
            mr = mr(aVar.dte);
        }
        return String.format(this.mContext.getString(r.j.add_friend_card_title), string, getType(aVar.type), mr);
    }

    private String b(c.a aVar, String str) {
        String mr;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mr = this.mContext.getString(r.j.me);
        } else {
            mr = mr(aVar.dte);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_comment), mr));
            sb.append(aVar.dti);
        } else {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_thread), mr));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mr(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(r.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(r.j.she);
        }
        return this.mContext.getResources().getString(r.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(r.j.add_friend_card_title_comment) : this.mContext.getResources().getString(r.j.add_friend_card_title_thread);
    }
}
