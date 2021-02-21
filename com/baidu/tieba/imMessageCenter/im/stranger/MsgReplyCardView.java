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
    private TextView jOU;
    private LinearLayout kQe;
    private TextView kQf;
    private TextView kQg;
    private TextView kQh;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kQe = (LinearLayout) findViewById(R.id.reply_card);
        this.kQf = (TextView) findViewById(R.id.reply_title);
        this.jOU = (TextView) findViewById(R.id.reply_content);
        this.kQg = (TextView) findViewById(R.id.reply_quote_content);
        this.kQh = (TextView) findViewById(R.id.reply_frs_name);
        this.kQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.kAt.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0769a Nr = a.Nr(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kQf.setText(a(Nr, valueOf));
            this.jOU.setText(Nr.kPO);
            this.kQg.setText(b(Nr, valueOf));
            this.kQh.setText(Nr.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0769a c0769a, String str) {
        String string;
        String Ds;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Ds(c0769a.kQj);
            Ds = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Ds = Ds(c0769a.kQj);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Dt(c0769a.type), Ds);
    }

    private String b(a.C0769a c0769a, String str) {
        String Ds;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Ds = this.mContext.getString(R.string.me);
        } else {
            Ds = Ds(c0769a.kQj);
        }
        if (c0769a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Ds));
            sb.append(c0769a.kQn);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Ds));
            sb.append(c0769a.title);
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
