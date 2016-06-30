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
    private LinearLayout dcW;
    private TextView dcX;
    private TextView dcY;
    private TextView dcZ;
    private TextView dda;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dcW = (LinearLayout) findViewById(u.g.reply_card);
        this.dcX = (TextView) findViewById(u.g.reply_title);
        this.dcY = (TextView) findViewById(u.g.reply_content);
        this.dcZ = (TextView) findViewById(u.g.reply_quote_content);
        this.dda = (TextView) findViewById(u.g.reply_frs_name);
        this.dcW.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lH = c.lH(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dcX.setText(a(lH, valueOf));
            this.dcY.setText(lH.dcD);
            this.dcZ.setText(b(lH, valueOf));
            this.dda.setText(String.valueOf(lH.ddj) + this.mContext.getString(u.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String lA;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = lA(aVar.ddd);
            lA = this.mContext.getString(u.j.you);
        } else {
            string = this.mContext.getString(u.j.you);
            lA = lA(aVar.ddd);
        }
        return String.format(this.mContext.getString(u.j.add_friend_card_title), string, getType(aVar.type), lA);
    }

    private String b(c.a aVar, String str) {
        String lA;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            lA = this.mContext.getString(u.j.me);
        } else {
            lA = lA(aVar.ddd);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(u.j.add_friend_card_quote_comment), lA));
            sb.append(aVar.ddh);
        } else {
            sb.append(String.format(this.mContext.getString(u.j.add_friend_card_quote_thread), lA));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String lA(int i) {
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
