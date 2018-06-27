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
    private LinearLayout eCf;
    private TextView eCg;
    private TextView eCh;
    private TextView eCi;
    private TextView eCj;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eCf = (LinearLayout) findViewById(d.g.reply_card);
        this.eCg = (TextView) findViewById(d.g.reply_title);
        this.eCh = (TextView) findViewById(d.g.reply_content);
        this.eCi = (TextView) findViewById(d.g.reply_quote_content);
        this.eCj = (TextView) findViewById(d.g.reply_frs_name);
        this.eCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.egK.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0186a oW = a.oW(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eCg.setText(a(oW, valueOf));
            this.eCh.setText(oW.eBP);
            this.eCi.setText(b(oW, valueOf));
            this.eCj.setText(oW.aGb + this.mContext.getString(d.k.forum));
        }
    }

    private String a(a.C0186a c0186a, String str) {
        String string;
        String ow;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = ow(c0186a.eCl);
            ow = this.mContext.getString(d.k.you);
        } else {
            string = this.mContext.getString(d.k.you);
            ow = ow(c0186a.eCl);
        }
        return String.format(this.mContext.getString(d.k.add_friend_card_title), string, getType(c0186a.type), ow);
    }

    private String b(a.C0186a c0186a, String str) {
        String ow;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            ow = this.mContext.getString(d.k.me);
        } else {
            ow = ow(c0186a.eCl);
        }
        if (c0186a.type == 1) {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_comment), ow));
            sb.append(c0186a.eCp);
        } else {
            sb.append(String.format(this.mContext.getString(d.k.add_friend_card_quote_thread), ow));
            sb.append(c0186a.title);
        }
        return sb.toString();
    }

    private String ow(int i) {
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
