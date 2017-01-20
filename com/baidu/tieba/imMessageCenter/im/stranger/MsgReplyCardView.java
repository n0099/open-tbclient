package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ar;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class MsgReplyCardView extends ar {
    private LinearLayout diJ;
    private TextView diK;
    private TextView diL;
    private TextView diM;
    private TextView diN;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.diJ = (LinearLayout) findViewById(r.h.reply_card);
        this.diK = (TextView) findViewById(r.h.reply_title);
        this.diL = (TextView) findViewById(r.h.reply_content);
        this.diM = (TextView) findViewById(r.h.reply_quote_content);
        this.diN = (TextView) findViewById(r.h.reply_frs_name);
        this.diJ.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lx = c.lx(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.diK.setText(a(lx, valueOf));
            this.diL.setText(lx.div);
            this.diM.setText(b(lx, valueOf));
            this.diN.setText(String.valueOf(lx.diW) + this.mContext.getString(r.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mp;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mp(aVar.diQ);
            mp = this.mContext.getString(r.l.you);
        } else {
            string = this.mContext.getString(r.l.you);
            mp = mp(aVar.diQ);
        }
        return String.format(this.mContext.getString(r.l.add_friend_card_title), string, getType(aVar.type), mp);
    }

    private String b(c.a aVar, String str) {
        String mp;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mp = this.mContext.getString(r.l.me);
        } else {
            mp = mp(aVar.diQ);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(r.l.add_friend_card_quote_comment), mp));
            sb.append(aVar.diU);
        } else {
            sb.append(String.format(this.mContext.getString(r.l.add_friend_card_quote_thread), mp));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mp(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(r.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(r.l.she);
        }
        return this.mContext.getResources().getString(r.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(r.l.add_friend_card_title_comment) : this.mContext.getResources().getString(r.l.topic_thread);
    }
}
