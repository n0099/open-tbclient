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
    private LinearLayout iNQ;
    private TextView iNR;
    private TextView iNS;
    private TextView iNT;
    private TextView iNU;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.iNQ = (LinearLayout) findViewById(R.id.reply_card);
        this.iNR = (TextView) findViewById(R.id.reply_title);
        this.iNS = (TextView) findViewById(R.id.reply_content);
        this.iNT = (TextView) findViewById(R.id.reply_quote_content);
        this.iNU = (TextView) findViewById(R.id.reply_frs_name);
        this.iNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.isD.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0650a He = a.He(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.iNR.setText(a(He, valueOf));
            this.iNS.setText(He.iNA);
            this.iNT.setText(b(He, valueOf));
            this.iNU.setText(He.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0650a c0650a, String str) {
        String string;
        String yl;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = yl(c0650a.iNW);
            yl = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            yl = yl(c0650a.iNW);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, ym(c0650a.type), yl);
    }

    private String b(a.C0650a c0650a, String str) {
        String yl;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            yl = this.mContext.getString(R.string.me);
        } else {
            yl = yl(c0650a.iNW);
        }
        if (c0650a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), yl));
            sb.append(c0650a.iOa);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), yl));
            sb.append(c0650a.title);
        }
        return sb.toString();
    }

    private String yl(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String ym(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
