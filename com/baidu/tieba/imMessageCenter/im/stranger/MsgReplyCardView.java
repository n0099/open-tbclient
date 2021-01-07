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
    private LinearLayout kMr;
    private TextView kMs;
    private TextView kMt;
    private TextView kMu;
    private TextView kMv;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kMr = (LinearLayout) findViewById(R.id.reply_card);
        this.kMs = (TextView) findViewById(R.id.reply_title);
        this.kMt = (TextView) findViewById(R.id.reply_content);
        this.kMu = (TextView) findViewById(R.id.reply_quote_content);
        this.kMv = (TextView) findViewById(R.id.reply_frs_name);
        this.kMr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.kwD.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0783a NJ = a.NJ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kMs.setText(a(NJ, valueOf));
            this.kMt.setText(NJ.kMb);
            this.kMu.setText(b(NJ, valueOf));
            this.kMv.setText(NJ.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0783a c0783a, String str) {
        String string;
        String EH;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = EH(c0783a.kMx);
            EH = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            EH = EH(c0783a.kMx);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, EI(c0783a.type), EH);
    }

    private String b(a.C0783a c0783a, String str) {
        String EH;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            EH = this.mContext.getString(R.string.me);
        } else {
            EH = EH(c0783a.kMx);
        }
        if (c0783a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), EH));
            sb.append(c0783a.kMB);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), EH));
            sb.append(c0783a.title);
        }
        return sb.toString();
    }

    private String EH(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String EI(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
