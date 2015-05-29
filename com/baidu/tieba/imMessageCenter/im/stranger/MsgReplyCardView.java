package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bk;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgReplyCardView extends bk {
    private LinearLayout bwj;
    private TextView bwk;
    private TextView bwl;
    private TextView bwm;
    private TextView bwn;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.msg_reply_card_view);
        init();
    }

    private void init() {
        this.bwj = (LinearLayout) findViewById(q.reply_card);
        this.bwk = (TextView) findViewById(q.reply_title);
        this.bwl = (TextView) findViewById(q.reply_content);
        this.bwm = (TextView) findViewById(q.reply_quote_content);
        this.bwn = (TextView) findViewById(q.reply_frs_name);
        this.bwj.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            d hU = c.hU(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.bwk.setText(a(hU, valueOf));
            this.bwl.setText(hU.replyContent);
            this.bwm.setText(b(hU, valueOf));
            this.bwn.setText(String.valueOf(hU.bww) + this.mContext.getString(t.bar));
        }
    }

    private String a(d dVar, String str) {
        String string;
        String gW;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = gW(dVar.bwq);
            gW = this.mContext.getString(t.you);
        } else {
            string = this.mContext.getString(t.you);
            gW = gW(dVar.bwq);
        }
        return String.format(this.mContext.getString(t.add_friend_card_title), string, getType(dVar.type), gW);
    }

    private String b(d dVar, String str) {
        String gW;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            gW = this.mContext.getString(t.me);
        } else {
            gW = gW(dVar.bwq);
        }
        if (dVar.type == 1) {
            sb.append(String.format(this.mContext.getString(t.add_friend_card_quote_comment), gW));
            sb.append(dVar.bwu);
        } else {
            sb.append(String.format(this.mContext.getString(t.add_friend_card_quote_thread), gW));
            sb.append(dVar.title);
        }
        return sb.toString();
    }

    private String gW(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(t.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(t.she);
        }
        return this.mContext.getResources().getString(t.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(t.add_friend_card_title_comment) : this.mContext.getResources().getString(t.add_friend_card_title_thread);
    }
}
