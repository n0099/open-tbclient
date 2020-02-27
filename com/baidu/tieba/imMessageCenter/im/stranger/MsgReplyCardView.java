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
    private TextView hNA;
    private TextView hNB;
    private TextView hNC;
    private LinearLayout hNy;
    private TextView hNz;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.hNy = (LinearLayout) findViewById(R.id.reply_card);
        this.hNz = (TextView) findViewById(R.id.reply_title);
        this.hNA = (TextView) findViewById(R.id.reply_content);
        this.hNB = (TextView) findViewById(R.id.reply_quote_content);
        this.hNC = (TextView) findViewById(R.id.reply_frs_name);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.hsn.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0541a DJ = a.DJ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.hNz.setText(a(DJ, valueOf));
            this.hNA.setText(DJ.hNi);
            this.hNB.setText(b(DJ, valueOf));
            this.hNC.setText(DJ.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0541a c0541a, String str) {
        String string;
        String wZ;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wZ(c0541a.hNE);
            wZ = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wZ = wZ(c0541a.hNE);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, xa(c0541a.type), wZ);
    }

    private String b(a.C0541a c0541a, String str) {
        String wZ;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wZ = this.mContext.getString(R.string.me);
        } else {
            wZ = wZ(c0541a.hNE);
        }
        if (c0541a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wZ));
            sb.append(c0541a.hNI);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wZ));
            sb.append(c0541a.title);
        }
        return sb.toString();
    }

    private String wZ(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String xa(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
