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
/* loaded from: classes16.dex */
public class MsgReplyCardView extends g {
    private LinearLayout jDh;
    private TextView jDi;
    private TextView jDj;
    private TextView jDk;
    private TextView jDl;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.jDh = (LinearLayout) findViewById(R.id.reply_card);
        this.jDi = (TextView) findViewById(R.id.reply_title);
        this.jDj = (TextView) findViewById(R.id.reply_content);
        this.jDk = (TextView) findViewById(R.id.reply_quote_content);
        this.jDl = (TextView) findViewById(R.id.reply_frs_name);
        this.jDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jfG.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0727a Lo = a.Lo(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.jDi.setText(a(Lo, valueOf));
            this.jDj.setText(Lo.jCR);
            this.jDk.setText(b(Lo, valueOf));
            this.jDl.setText(Lo.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0727a c0727a, String str) {
        String string;
        String BP;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = BP(c0727a.jDn);
            BP = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            BP = BP(c0727a.jDn);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, BQ(c0727a.type), BP);
    }

    private String b(a.C0727a c0727a, String str) {
        String BP;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            BP = this.mContext.getString(R.string.me);
        } else {
            BP = BP(c0727a.jDn);
        }
        if (c0727a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), BP));
            sb.append(c0727a.jDr);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), BP));
            sb.append(c0727a.title);
        }
        return sb.toString();
    }

    private String BP(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String BQ(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
