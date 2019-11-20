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
    private LinearLayout gTU;
    private TextView gTV;
    private TextView gTW;
    private TextView gTX;
    private TextView gTY;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gTU = (LinearLayout) findViewById(R.id.reply_card);
        this.gTV = (TextView) findViewById(R.id.reply_title);
        this.gTW = (TextView) findViewById(R.id.reply_content);
        this.gTX = (TextView) findViewById(R.id.reply_quote_content);
        this.gTY = (TextView) findViewById(R.id.reply_frs_name);
        this.gTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gyD.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0448a yA = a.yA(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gTV.setText(a(yA, valueOf));
            this.gTW.setText(yA.gTE);
            this.gTX.setText(b(yA, valueOf));
            this.gTY.setText(yA.cxN + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0448a c0448a, String str) {
        String string;
        String uM;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = uM(c0448a.gUa);
            uM = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            uM = uM(c0448a.gUa);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, uN(c0448a.type), uM);
    }

    private String b(a.C0448a c0448a, String str) {
        String uM;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            uM = this.mContext.getString(R.string.me);
        } else {
            uM = uM(c0448a.gUa);
        }
        if (c0448a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), uM));
            sb.append(c0448a.gUe);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), uM));
            sb.append(c0448a.title);
        }
        return sb.toString();
    }

    private String uM(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String uN(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
