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
    private LinearLayout gNN;
    private TextView gNO;
    private TextView gNP;
    private TextView gNQ;
    private TextView gNR;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gNN = (LinearLayout) findViewById(R.id.reply_card);
        this.gNO = (TextView) findViewById(R.id.reply_title);
        this.gNP = (TextView) findViewById(R.id.reply_content);
        this.gNQ = (TextView) findViewById(R.id.reply_quote_content);
        this.gNR = (TextView) findViewById(R.id.reply_frs_name);
        this.gNN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gsy.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0343a yV = a.yV(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gNO.setText(a(yV, valueOf));
            this.gNP.setText(yV.gNx);
            this.gNQ.setText(b(yV, valueOf));
            this.gNR.setText(yV.cjw + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0343a c0343a, String str) {
        String string;
        String vA;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = vA(c0343a.gNT);
            vA = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            vA = vA(c0343a.gNT);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, getType(c0343a.type), vA);
    }

    private String b(a.C0343a c0343a, String str) {
        String vA;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            vA = this.mContext.getString(R.string.me);
        } else {
            vA = vA(c0343a.gNT);
        }
        if (c0343a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), vA));
            sb.append(c0343a.gNX);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), vA));
            sb.append(c0343a.title);
        }
        return sb.toString();
    }

    private String vA(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
