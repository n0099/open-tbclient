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
/* loaded from: classes21.dex */
public class MsgReplyCardView extends g {
    private LinearLayout jLJ;
    private TextView jLK;
    private TextView jLL;
    private TextView jLM;
    private TextView jLN;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.jLJ = (LinearLayout) findViewById(R.id.reply_card);
        this.jLK = (TextView) findViewById(R.id.reply_title);
        this.jLL = (TextView) findViewById(R.id.reply_content);
        this.jLM = (TextView) findViewById(R.id.reply_quote_content);
        this.jLN = (TextView) findViewById(R.id.reply_frs_name);
        this.jLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jom.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0724a LQ = a.LQ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.jLK.setText(a(LQ, valueOf));
            this.jLL.setText(LQ.jLt);
            this.jLM.setText(b(LQ, valueOf));
            this.jLN.setText(LQ.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0724a c0724a, String str) {
        String string;
        String Cq;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Cq(c0724a.jLP);
            Cq = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Cq = Cq(c0724a.jLP);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Cr(c0724a.type), Cq);
    }

    private String b(a.C0724a c0724a, String str) {
        String Cq;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Cq = this.mContext.getString(R.string.me);
        } else {
            Cq = Cq(c0724a.jLP);
        }
        if (c0724a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Cq));
            sb.append(c0724a.jLT);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Cq));
            sb.append(c0724a.title);
        }
        return sb.toString();
    }

    private String Cq(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Cr(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
