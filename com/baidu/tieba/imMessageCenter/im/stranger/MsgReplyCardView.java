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
/* loaded from: classes9.dex */
public class MsgReplyCardView extends g {
    private LinearLayout hPm;
    private TextView hPn;
    private TextView hPo;
    private TextView hPp;
    private TextView hPq;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.hPm = (LinearLayout) findViewById(R.id.reply_card);
        this.hPn = (TextView) findViewById(R.id.reply_title);
        this.hPo = (TextView) findViewById(R.id.reply_content);
        this.hPp = (TextView) findViewById(R.id.reply_quote_content);
        this.hPq = (TextView) findViewById(R.id.reply_frs_name);
        this.hPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.hub.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0542a DK = a.DK(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.hPn.setText(a(DK, valueOf));
            this.hPo.setText(DK.hOW);
            this.hPp.setText(b(DK, valueOf));
            this.hPq.setText(DK.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0542a c0542a, String str) {
        String string;
        String xh;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = xh(c0542a.hPs);
            xh = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            xh = xh(c0542a.hPs);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, xi(c0542a.type), xh);
    }

    private String b(a.C0542a c0542a, String str) {
        String xh;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            xh = this.mContext.getString(R.string.me);
        } else {
            xh = xh(c0542a.hPs);
        }
        if (c0542a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), xh));
            sb.append(c0542a.hPw);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), xh));
            sb.append(c0542a.title);
        }
        return sb.toString();
    }

    private String xh(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String xi(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
