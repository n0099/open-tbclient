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
/* loaded from: classes6.dex */
public class MsgReplyCardView extends g {
    private LinearLayout hHX;
    private TextView hHY;
    private TextView hHZ;
    private TextView hIa;
    private TextView hIb;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.hHX = (LinearLayout) findViewById(R.id.reply_card);
        this.hHY = (TextView) findViewById(R.id.reply_title);
        this.hHZ = (TextView) findViewById(R.id.reply_content);
        this.hIa = (TextView) findViewById(R.id.reply_quote_content);
        this.hIb = (TextView) findViewById(R.id.reply_frs_name);
        this.hHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.hmL.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0529a Dj = a.Dj(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.hHY.setText(a(Dj, valueOf));
            this.hHZ.setText(Dj.hHH);
            this.hIa.setText(b(Dj, valueOf));
            this.hIb.setText(Dj.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0529a c0529a, String str) {
        String string;
        String wO;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wO(c0529a.hId);
            wO = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wO = wO(c0529a.hId);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, wP(c0529a.type), wO);
    }

    private String b(a.C0529a c0529a, String str) {
        String wO;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wO = this.mContext.getString(R.string.me);
        } else {
            wO = wO(c0529a.hId);
        }
        if (c0529a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wO));
            sb.append(c0529a.hIh);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wO));
            sb.append(c0529a.title);
        }
        return sb.toString();
    }

    private String wO(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String wP(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
