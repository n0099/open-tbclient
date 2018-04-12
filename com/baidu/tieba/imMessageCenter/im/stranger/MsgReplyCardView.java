package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends g {
    private LinearLayout elT;
    private TextView elU;
    private TextView elV;
    private TextView elW;
    private TextView elX;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_reply_card_view);
        init();
    }

    private void init() {
        this.elT = (LinearLayout) findViewById(d.g.reply_card);
        this.elU = (TextView) findViewById(d.g.reply_title);
        this.elV = (TextView) findViewById(d.g.reply_content);
        this.elW = (TextView) findViewById(d.g.reply_quote_content);
        this.elX = (TextView) findViewById(d.g.reply_frs_name);
        this.elT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MsgReplyCardView.this.dQz.a(view2, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        if (chatMessage != null) {
            a.C0168a oe = a.oe(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.elU.setText(a(oe, valueOf));
            this.elV.setText(oe.elD);
            this.elW.setText(b(oe, valueOf));
            this.elX.setText(oe.awT + this.mContext.getString(d.k.forum));
        }
    }

    private String a(a.C0168a c0168a, String str) {
        String string;
        String of;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = of(c0168a.elZ);
            of = this.mContext.getString(d.k.you);
        } else {
            string = this.mContext.getString(d.k.you);
            of = of(c0168a.elZ);
        }
        return String.format(this.mContext.getString(d.k.add_friend_card_title), string, getType(c0168a.type), of);
    }

    private String b(a.C0168a c0168a, String str) {
        String of;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            of = this.mContext.getString(d.k.me);
        } else {
            of = of(c0168a.elZ);
        }
        if (c0168a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_comment), of));
            sb.append(c0168a.emd);
        } else {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_thread), of));
            sb.append(c0168a.title);
        }
        return sb.toString();
    }

    private String of(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(d.k.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(d.k.she);
        }
        return this.mContext.getResources().getString(d.k.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(d.k.add_friend_card_title_comment) : this.mContext.getResources().getString(d.k.topic_thread);
    }
}
