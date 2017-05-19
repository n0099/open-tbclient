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
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends ar {
    private LinearLayout dfW;
    private TextView dfX;
    private TextView dfY;
    private TextView dfZ;
    private TextView dga;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dfW = (LinearLayout) findViewById(w.h.reply_card);
        this.dfX = (TextView) findViewById(w.h.reply_title);
        this.dfY = (TextView) findViewById(w.h.reply_content);
        this.dfZ = (TextView) findViewById(w.h.reply_quote_content);
        this.dga = (TextView) findViewById(w.h.reply_frs_name);
        this.dfW.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lj = c.lj(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dfX.setText(a(lj, valueOf));
            this.dfY.setText(lj.dfH);
            this.dfZ.setText(b(lj, valueOf));
            this.dga.setText(String.valueOf(lj.dgj) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String lZ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = lZ(aVar.dgd);
            lZ = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            lZ = lZ(aVar.dgd);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), lZ);
    }

    private String b(c.a aVar, String str) {
        String lZ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            lZ = this.mContext.getString(w.l.me);
        } else {
            lZ = lZ(aVar.dgd);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), lZ));
            sb.append(aVar.dgh);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), lZ));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String lZ(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(w.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(w.l.she);
        }
        return this.mContext.getResources().getString(w.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(w.l.add_friend_card_title_comment) : this.mContext.getResources().getString(w.l.topic_thread);
    }
}
