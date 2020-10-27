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
    private LinearLayout kng;
    private TextView knh;
    private TextView kni;
    private TextView knj;
    private TextView knk;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kng = (LinearLayout) findViewById(R.id.reply_card);
        this.knh = (TextView) findViewById(R.id.reply_title);
        this.kni = (TextView) findViewById(R.id.reply_content);
        this.knj = (TextView) findViewById(R.id.reply_quote_content);
        this.knk = (TextView) findViewById(R.id.reply_frs_name);
        this.kng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jPI.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0758a Nd = a.Nd(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.knh.setText(a(Nd, valueOf));
            this.kni.setText(Nd.kmQ);
            this.knj.setText(b(Nd, valueOf));
            this.knk.setText(Nd.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0758a c0758a, String str) {
        String string;
        String Dp;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Dp(c0758a.knm);
            Dp = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Dp = Dp(c0758a.knm);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Dq(c0758a.type), Dp);
    }

    private String b(a.C0758a c0758a, String str) {
        String Dp;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Dp = this.mContext.getString(R.string.me);
        } else {
            Dp = Dp(c0758a.knm);
        }
        if (c0758a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Dp));
            sb.append(c0758a.knq);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Dp));
            sb.append(c0758a.title);
        }
        return sb.toString();
    }

    private String Dp(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Dq(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
