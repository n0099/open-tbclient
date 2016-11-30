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
    private LinearLayout dyC;
    private TextView dyD;
    private TextView dyE;
    private TextView dyF;
    private TextView dyG;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dyC = (LinearLayout) findViewById(r.g.reply_card);
        this.dyD = (TextView) findViewById(r.g.reply_title);
        this.dyE = (TextView) findViewById(r.g.reply_content);
        this.dyF = (TextView) findViewById(r.g.reply_quote_content);
        this.dyG = (TextView) findViewById(r.g.reply_frs_name);
        this.dyC.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a mX = c.mX(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dyD.setText(a(mX, valueOf));
            this.dyE.setText(mX.dyj);
            this.dyF.setText(b(mX, valueOf));
            this.dyG.setText(String.valueOf(mX.dyP) + this.mContext.getString(r.j.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mz;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mz(aVar.dyJ);
            mz = this.mContext.getString(r.j.you);
        } else {
            string = this.mContext.getString(r.j.you);
            mz = mz(aVar.dyJ);
        }
        return String.format(this.mContext.getString(r.j.add_friend_card_title), string, getType(aVar.type), mz);
    }

    private String b(c.a aVar, String str) {
        String mz;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mz = this.mContext.getString(r.j.me);
        } else {
            mz = mz(aVar.dyJ);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_comment), mz));
            sb.append(aVar.dyN);
        } else {
            sb.append(String.format(this.mContext.getString(r.j.add_friend_card_quote_thread), mz));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mz(int i) {
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
