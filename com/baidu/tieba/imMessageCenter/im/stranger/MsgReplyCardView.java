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
    private TextView jQD;
    private LinearLayout kSg;
    private TextView kSh;
    private TextView kSi;
    private TextView kSj;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kSg = (LinearLayout) findViewById(R.id.reply_card);
        this.kSh = (TextView) findViewById(R.id.reply_title);
        this.jQD = (TextView) findViewById(R.id.reply_content);
        this.kSi = (TextView) findViewById(R.id.reply_quote_content);
        this.kSj = (TextView) findViewById(R.id.reply_frs_name);
        this.kSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.kCv.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0775a Nx = a.Nx(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kSh.setText(a(Nx, valueOf));
            this.jQD.setText(Nx.kRQ);
            this.kSi.setText(b(Nx, valueOf));
            this.kSj.setText(Nx.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0775a c0775a, String str) {
        String string;
        String Dv;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Dv(c0775a.kSl);
            Dv = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Dv = Dv(c0775a.kSl);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Dw(c0775a.type), Dv);
    }

    private String b(a.C0775a c0775a, String str) {
        String Dv;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Dv = this.mContext.getString(R.string.me);
        } else {
            Dv = Dv(c0775a.kSl);
        }
        if (c0775a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Dv));
            sb.append(c0775a.kSp);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Dv));
            sb.append(c0775a.title);
        }
        return sb.toString();
    }

    private String Dv(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Dw(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
