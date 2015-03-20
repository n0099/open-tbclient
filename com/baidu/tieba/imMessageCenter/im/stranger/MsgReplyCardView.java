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
    private LinearLayout btj;
    private TextView btk;
    private TextView btl;
    private TextView btm;
    private TextView bto;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.msg_reply_card_view);
        init();
    }

    private void init() {
        this.btj = (LinearLayout) findViewById(v.reply_card);
        this.btk = (TextView) findViewById(v.reply_title);
        this.btl = (TextView) findViewById(v.reply_content);
        this.btm = (TextView) findViewById(v.reply_quote_content);
        this.bto = (TextView) findViewById(v.reply_frs_name);
        this.btj.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            d ho = c.ho(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.btk.setText(a(ho, valueOf));
            this.btl.setText(ho.replyContent);
            this.btm.setText(b(ho, valueOf));
            this.bto.setText(String.valueOf(ho.btx) + this.mContext.getString(y.bar));
        }
    }

    private String a(d dVar, String str) {
        String string;
        String gD;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = gD(dVar.btr);
            gD = this.mContext.getString(y.you);
        } else {
            string = this.mContext.getString(y.you);
            gD = gD(dVar.btr);
        }
        return String.format(this.mContext.getString(y.add_friend_card_title), string, getType(dVar.type), gD);
    }

    private String b(d dVar, String str) {
        String gD;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            gD = this.mContext.getString(y.me);
        } else {
            gD = gD(dVar.btr);
        }
        if (dVar.type == 1) {
            sb.append(String.format(this.mContext.getString(y.add_friend_card_quote_comment), gD));
            sb.append(dVar.btv);
        } else {
            sb.append(String.format(this.mContext.getString(y.add_friend_card_quote_thread), gD));
            sb.append(dVar.title);
        }
        return sb.toString();
    }

    private String gD(int i) {
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
