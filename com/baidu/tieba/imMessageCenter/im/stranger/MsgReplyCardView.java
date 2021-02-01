package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends e {
    private TextView jOG;
    private LinearLayout kPQ;
    private TextView kPR;
    private TextView kPS;
    private TextView kPT;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kPQ = (LinearLayout) findViewById(R.id.reply_card);
        this.kPR = (TextView) findViewById(R.id.reply_title);
        this.jOG = (TextView) findViewById(R.id.reply_content);
        this.kPS = (TextView) findViewById(R.id.reply_quote_content);
        this.kPT = (TextView) findViewById(R.id.reply_frs_name);
        this.kPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.kAf.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0768a Nq = a.Nq(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kPR.setText(a(Nq, valueOf));
            this.jOG.setText(Nq.kPA);
            this.kPS.setText(b(Nq, valueOf));
            this.kPT.setText(Nq.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0768a c0768a, String str) {
        String string;
        String Ds;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Ds(c0768a.kPV);
            Ds = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Ds = Ds(c0768a.kPV);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Dt(c0768a.type), Ds);
    }

    private String b(a.C0768a c0768a, String str) {
        String Ds;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Ds = this.mContext.getString(R.string.me);
        } else {
            Ds = Ds(c0768a.kPV);
        }
        if (c0768a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Ds));
            sb.append(c0768a.kPZ);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Ds));
            sb.append(c0768a.title);
        }
        return sb.toString();
    }

    private String Ds(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Dt(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
