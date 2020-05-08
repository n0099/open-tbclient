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
    private LinearLayout izj;
    private TextView izk;
    private TextView izl;
    private TextView izm;
    private TextView izn;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.izj = (LinearLayout) findViewById(R.id.reply_card);
        this.izk = (TextView) findViewById(R.id.reply_title);
        this.izl = (TextView) findViewById(R.id.reply_content);
        this.izm = (TextView) findViewById(R.id.reply_quote_content);
        this.izn = (TextView) findViewById(R.id.reply_frs_name);
        this.izj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.idU.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0600a Fv = a.Fv(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.izk.setText(a(Fv, valueOf));
            this.izl.setText(Fv.iyT);
            this.izm.setText(b(Fv, valueOf));
            this.izn.setText(Fv.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0600a c0600a, String str) {
        String string;
        String xF;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = xF(c0600a.izp);
            xF = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            xF = xF(c0600a.izp);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, xG(c0600a.type), xF);
    }

    private String b(a.C0600a c0600a, String str) {
        String xF;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            xF = this.mContext.getString(R.string.me);
        } else {
            xF = xF(c0600a.izp);
        }
        if (c0600a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), xF));
            sb.append(c0600a.izt);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), xF));
            sb.append(c0600a.title);
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
