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
/* loaded from: classes7.dex */
public class MsgReplyCardView extends g {
    private LinearLayout hLA;
    private TextView hLB;
    private TextView hLC;
    private TextView hLD;
    private TextView hLE;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.hLA = (LinearLayout) findViewById(R.id.reply_card);
        this.hLB = (TextView) findViewById(R.id.reply_title);
        this.hLC = (TextView) findViewById(R.id.reply_content);
        this.hLD = (TextView) findViewById(R.id.reply_quote_content);
        this.hLE = (TextView) findViewById(R.id.reply_frs_name);
        this.hLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.hqo.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0534a Dt = a.Dt(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.hLB.setText(a(Dt, valueOf));
            this.hLC.setText(Dt.hLk);
            this.hLD.setText(b(Dt, valueOf));
            this.hLE.setText(Dt.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0534a c0534a, String str) {
        String string;
        String wT;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wT(c0534a.hLG);
            wT = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wT = wT(c0534a.hLG);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, wU(c0534a.type), wT);
    }

    private String b(a.C0534a c0534a, String str) {
        String wT;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wT = this.mContext.getString(R.string.me);
        } else {
            wT = wT(c0534a.hLG);
        }
        if (c0534a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wT));
            sb.append(c0534a.hLK);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wT));
            sb.append(c0534a.title);
        }
        return sb.toString();
    }

    private String wT(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String wU(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
