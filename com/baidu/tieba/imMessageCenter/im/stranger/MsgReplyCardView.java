package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes22.dex */
public class MsgReplyCardView extends g {
    private LinearLayout ktc;
    private TextView ktd;
    private TextView kte;
    private TextView ktf;
    private TextView ktg;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.ktc = (LinearLayout) findViewById(R.id.reply_card);
        this.ktd = (TextView) findViewById(R.id.reply_title);
        this.kte = (TextView) findViewById(R.id.reply_content);
        this.ktf = (TextView) findViewById(R.id.reply_quote_content);
        this.ktg = (TextView) findViewById(R.id.reply_frs_name);
        this.ktc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jVF.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0772a Nu = a.Nu(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.ktd.setText(a(Nu, valueOf));
            this.kte.setText(Nu.ksM);
            this.ktf.setText(b(Nu, valueOf));
            this.ktg.setText(Nu.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0772a c0772a, String str) {
        String string;
        String DC;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = DC(c0772a.kti);
            DC = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            DC = DC(c0772a.kti);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, DD(c0772a.type), DC);
    }

    private String b(a.C0772a c0772a, String str) {
        String DC;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            DC = this.mContext.getString(R.string.me);
        } else {
            DC = DC(c0772a.kti);
        }
        if (c0772a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), DC));
            sb.append(c0772a.ktm);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), DC));
            sb.append(c0772a.title);
        }
        return sb.toString();
    }

    private String DC(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String DD(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
