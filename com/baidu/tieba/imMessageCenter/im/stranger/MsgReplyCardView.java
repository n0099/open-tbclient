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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MsgReplyCardView extends as {
    private LinearLayout dfT;
    private TextView dfU;
    private TextView dfV;
    private TextView dfW;
    private TextView dfX;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dfT = (LinearLayout) findViewById(u.g.reply_card);
        this.dfU = (TextView) findViewById(u.g.reply_title);
        this.dfV = (TextView) findViewById(u.g.reply_content);
        this.dfW = (TextView) findViewById(u.g.reply_quote_content);
        this.dfX = (TextView) findViewById(u.g.reply_frs_name);
        this.dfT.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lO = c.lO(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dfU.setText(a(lO, valueOf));
            this.dfV.setText(lO.dfA);
            this.dfW.setText(b(lO, valueOf));
            this.dfX.setText(String.valueOf(lO.dgg) + this.mContext.getString(u.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String lG;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = lG(aVar.dga);
            lG = this.mContext.getString(u.j.you);
        } else {
            string = this.mContext.getString(u.j.you);
            lG = lG(aVar.dga);
        }
        return String.format(this.mContext.getString(u.j.add_friend_card_title), string, getType(aVar.type), lG);
    }

    private String b(c.a aVar, String str) {
        String lG;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            lG = this.mContext.getString(u.j.me);
        } else {
            lG = lG(aVar.dga);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(u.j.add_friend_card_quote_comment), lG));
            sb.append(aVar.dge);
        } else {
            sb.append(String.format(this.mContext.getString(u.j.add_friend_card_quote_thread), lG));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String lG(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(u.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(u.j.she);
        }
        return this.mContext.getResources().getString(u.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(u.j.add_friend_card_title_comment) : this.mContext.getResources().getString(u.j.add_friend_card_title_thread);
    }
}
