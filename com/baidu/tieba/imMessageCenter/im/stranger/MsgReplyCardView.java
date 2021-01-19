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
    private LinearLayout kHM;
    private TextView kHN;
    private TextView kHO;
    private TextView kHP;
    private TextView kHQ;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kHM = (LinearLayout) findViewById(R.id.reply_card);
        this.kHN = (TextView) findViewById(R.id.reply_title);
        this.kHO = (TextView) findViewById(R.id.reply_content);
        this.kHP = (TextView) findViewById(R.id.reply_quote_content);
        this.kHQ = (TextView) findViewById(R.id.reply_frs_name);
        this.kHM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.krY.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0766a MC = a.MC(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kHN.setText(a(MC, valueOf));
            this.kHO.setText(MC.kHw);
            this.kHP.setText(b(MC, valueOf));
            this.kHQ.setText(MC.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0766a c0766a, String str) {
        String string;
        String Da;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Da(c0766a.kHS);
            Da = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Da = Da(c0766a.kHS);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Db(c0766a.type), Da);
    }

    private String b(a.C0766a c0766a, String str) {
        String Da;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Da = this.mContext.getString(R.string.me);
        } else {
            Da = Da(c0766a.kHS);
        }
        if (c0766a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Da));
            sb.append(c0766a.kHW);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Da));
            sb.append(c0766a.title);
        }
        return sb.toString();
    }

    private String Da(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Db(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
