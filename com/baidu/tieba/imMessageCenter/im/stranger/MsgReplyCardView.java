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
    private LinearLayout gUL;
    private TextView gUM;
    private TextView gUN;
    private TextView gUO;
    private TextView gUP;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gUL = (LinearLayout) findViewById(R.id.reply_card);
        this.gUM = (TextView) findViewById(R.id.reply_title);
        this.gUN = (TextView) findViewById(R.id.reply_content);
        this.gUO = (TextView) findViewById(R.id.reply_quote_content);
        this.gUP = (TextView) findViewById(R.id.reply_frs_name);
        this.gUL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gzu.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0448a yA = a.yA(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gUM.setText(a(yA, valueOf));
            this.gUN.setText(yA.gUv);
            this.gUO.setText(b(yA, valueOf));
            this.gUP.setText(yA.cyE + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0448a c0448a, String str) {
        String string;
        String uN;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = uN(c0448a.gUR);
            uN = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            uN = uN(c0448a.gUR);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, uO(c0448a.type), uN);
    }

    private String b(a.C0448a c0448a, String str) {
        String uN;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            uN = this.mContext.getString(R.string.me);
        } else {
            uN = uN(c0448a.gUR);
        }
        if (c0448a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), uN));
            sb.append(c0448a.gUV);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), uN));
            sb.append(c0448a.title);
        }
        return sb.toString();
    }

    private String uN(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String uO(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
