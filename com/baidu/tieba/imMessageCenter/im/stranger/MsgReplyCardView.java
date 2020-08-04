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
    private LinearLayout jod;
    private TextView joe;
    private TextView jof;
    private TextView jog;
    private TextView joh;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.jod = (LinearLayout) findViewById(R.id.reply_card);
        this.joe = (TextView) findViewById(R.id.reply_title);
        this.jof = (TextView) findViewById(R.id.reply_content);
        this.jog = (TextView) findViewById(R.id.reply_quote_content);
        this.joh = (TextView) findViewById(R.id.reply_frs_name);
        this.jod.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.iQD.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0675a Iv = a.Iv(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.joe.setText(a(Iv, valueOf));
            this.jof.setText(Iv.jnN);
            this.jog.setText(b(Iv, valueOf));
            this.joh.setText(Iv.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0675a c0675a, String str) {
        String string;
        String zw;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = zw(c0675a.joj);
            zw = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            zw = zw(c0675a.joj);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, zx(c0675a.type), zw);
    }

    private String b(a.C0675a c0675a, String str) {
        String zw;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            zw = this.mContext.getString(R.string.me);
        } else {
            zw = zw(c0675a.joj);
        }
        if (c0675a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), zw));
            sb.append(c0675a.jon);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), zw));
            sb.append(c0675a.title);
        }
        return sb.toString();
    }

    private String zw(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String zx(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
