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
/* loaded from: classes21.dex */
public class MsgReplyCardView extends g {
    private LinearLayout ktM;
    private TextView ktN;
    private TextView ktO;
    private TextView ktP;
    private TextView ktQ;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.ktM = (LinearLayout) findViewById(R.id.reply_card);
        this.ktN = (TextView) findViewById(R.id.reply_title);
        this.ktO = (TextView) findViewById(R.id.reply_content);
        this.ktP = (TextView) findViewById(R.id.reply_quote_content);
        this.ktQ = (TextView) findViewById(R.id.reply_frs_name);
        this.ktM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jWp.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0774a MV = a.MV(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.ktN.setText(a(MV, valueOf));
            this.ktO.setText(MV.ktw);
            this.ktP.setText(b(MV, valueOf));
            this.ktQ.setText(MV.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0774a c0774a, String str) {
        String string;
        String Ea;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = Ea(c0774a.ktS);
            Ea = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            Ea = Ea(c0774a.ktS);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, Eb(c0774a.type), Ea);
    }

    private String b(a.C0774a c0774a, String str) {
        String Ea;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            Ea = this.mContext.getString(R.string.me);
        } else {
            Ea = Ea(c0774a.ktS);
        }
        if (c0774a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), Ea));
            sb.append(c0774a.ktW);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), Ea));
            sb.append(c0774a.title);
        }
        return sb.toString();
    }

    private String Ea(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String Eb(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
