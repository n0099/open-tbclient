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
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class MsgReplyCardView extends bk {
    private LinearLayout btA;
    private TextView btB;
    private TextView btC;
    private TextView btD;
    private TextView btE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.msg_reply_card_view);
        init();
    }

    private void init() {
        this.btA = (LinearLayout) findViewById(v.reply_card);
        this.btB = (TextView) findViewById(v.reply_title);
        this.btC = (TextView) findViewById(v.reply_content);
        this.btD = (TextView) findViewById(v.reply_quote_content);
        this.btE = (TextView) findViewById(v.reply_frs_name);
        this.btA.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            d hr = c.hr(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.btB.setText(a(hr, valueOf));
            this.btC.setText(hr.replyContent);
            this.btD.setText(b(hr, valueOf));
            this.btE.setText(String.valueOf(hr.btN) + this.mContext.getString(y.bar));
        }
    }

    private String a(d dVar, String str) {
        String string;
        String gF;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = gF(dVar.btH);
            gF = this.mContext.getString(y.you);
        } else {
            string = this.mContext.getString(y.you);
            gF = gF(dVar.btH);
        }
        return String.format(this.mContext.getString(y.add_friend_card_title), string, getType(dVar.type), gF);
    }

    private String b(d dVar, String str) {
        String gF;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            gF = this.mContext.getString(y.me);
        } else {
            gF = gF(dVar.btH);
        }
        if (dVar.type == 1) {
            sb.append(String.format(this.mContext.getString(y.add_friend_card_quote_comment), gF));
            sb.append(dVar.btL);
        } else {
            sb.append(String.format(this.mContext.getString(y.add_friend_card_quote_thread), gF));
            sb.append(dVar.title);
        }
        return sb.toString();
    }

    private String gF(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(y.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(y.she);
        }
        return this.mContext.getResources().getString(y.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(y.add_friend_card_title_comment) : this.mContext.getResources().getString(y.add_friend_card_title_thread);
    }
}
