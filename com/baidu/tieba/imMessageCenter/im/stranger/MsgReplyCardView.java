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
    private LinearLayout kHg;
    private TextView kHh;
    private TextView kHi;
    private TextView kHj;
    private TextView kHk;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kHg = (LinearLayout) findViewById(R.id.reply_card);
        this.kHh = (TextView) findViewById(R.id.reply_title);
        this.kHi = (TextView) findViewById(R.id.reply_content);
        this.kHj = (TextView) findViewById(R.id.reply_quote_content);
        this.kHk = (TextView) findViewById(R.id.reply_frs_name);
        this.kHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.kjV.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0790a Od = a.Od(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kHh.setText(a(Od, valueOf));
            this.kHi.setText(Od.kGQ);
            this.kHj.setText(b(Od, valueOf));
            this.kHk.setText(Od.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0790a c0790a, String str) {
        String string;
        String EP;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = EP(c0790a.kHm);
            EP = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            EP = EP(c0790a.kHm);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, EQ(c0790a.type), EP);
    }

    private String b(a.C0790a c0790a, String str) {
        String EP;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            EP = this.mContext.getString(R.string.me);
        } else {
            EP = EP(c0790a.kHm);
        }
        if (c0790a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), EP));
            sb.append(c0790a.kHq);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), EP));
            sb.append(c0790a.title);
        }
        return sb.toString();
    }

    private String EP(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String EQ(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
