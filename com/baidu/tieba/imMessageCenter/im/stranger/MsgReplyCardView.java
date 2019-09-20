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
/* loaded from: classes4.dex */
public class MsgReplyCardView extends g {
    private LinearLayout gWL;
    private TextView gWM;
    private TextView gWN;
    private TextView gWO;
    private TextView gWP;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gWL = (LinearLayout) findViewById(R.id.reply_card);
        this.gWM = (TextView) findViewById(R.id.reply_title);
        this.gWN = (TextView) findViewById(R.id.reply_content);
        this.gWO = (TextView) findViewById(R.id.reply_quote_content);
        this.gWP = (TextView) findViewById(R.id.reply_frs_name);
        this.gWL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gBv.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0359a Ai = a.Ai(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gWM.setText(a(Ai, valueOf));
            this.gWN.setText(Ai.gWv);
            this.gWO.setText(b(Ai, valueOf));
            this.gWP.setText(Ai.clE + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0359a c0359a, String str) {
        String string;
        String wh;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wh(c0359a.gWR);
            wh = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wh = wh(c0359a.gWR);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, wi(c0359a.type), wh);
    }

    private String b(a.C0359a c0359a, String str) {
        String wh;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wh = this.mContext.getString(R.string.me);
        } else {
            wh = wh(c0359a.gWR);
        }
        if (c0359a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wh));
            sb.append(c0359a.gWV);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wh));
            sb.append(c0359a.title);
        }
        return sb.toString();
    }

    private String wh(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String wi(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
