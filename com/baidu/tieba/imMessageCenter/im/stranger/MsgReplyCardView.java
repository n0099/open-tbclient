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
    private LinearLayout izd;
    private TextView ize;
    private TextView izf;
    private TextView izg;
    private TextView izh;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.izd = (LinearLayout) findViewById(R.id.reply_card);
        this.ize = (TextView) findViewById(R.id.reply_title);
        this.izf = (TextView) findViewById(R.id.reply_content);
        this.izg = (TextView) findViewById(R.id.reply_quote_content);
        this.izh = (TextView) findViewById(R.id.reply_frs_name);
        this.izd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.idO.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0579a Fs = a.Fs(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.ize.setText(a(Fs, valueOf));
            this.izf.setText(Fs.iyN);
            this.izg.setText(b(Fs, valueOf));
            this.izh.setText(Fs.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0579a c0579a, String str) {
        String string;
        String xF;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = xF(c0579a.izj);
            xF = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            xF = xF(c0579a.izj);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, xG(c0579a.type), xF);
    }

    private String b(a.C0579a c0579a, String str) {
        String xF;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            xF = this.mContext.getString(R.string.me);
        } else {
            xF = xF(c0579a.izj);
        }
        if (c0579a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), xF));
            sb.append(c0579a.izn);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), xF));
            sb.append(c0579a.title);
        }
        return sb.toString();
    }

    private String xF(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String xG(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
