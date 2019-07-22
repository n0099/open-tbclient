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
    private LinearLayout gUa;
    private TextView gUb;
    private TextView gUc;
    private TextView gUd;
    private TextView gUe;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gUa = (LinearLayout) findViewById(R.id.reply_card);
        this.gUb = (TextView) findViewById(R.id.reply_title);
        this.gUc = (TextView) findViewById(R.id.reply_content);
        this.gUd = (TextView) findViewById(R.id.reply_quote_content);
        this.gUe = (TextView) findViewById(R.id.reply_frs_name);
        this.gUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gyM.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0342a zI = a.zI(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gUb.setText(a(zI, valueOf));
            this.gUc.setText(zI.gTK);
            this.gUd.setText(b(zI, valueOf));
            this.gUe.setText(zI.ckC + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0342a c0342a, String str) {
        String string;
        String wb;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wb(c0342a.gUg);
            wb = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wb = wb(c0342a.gUg);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, wc(c0342a.type), wb);
    }

    private String b(a.C0342a c0342a, String str) {
        String wb;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wb = this.mContext.getString(R.string.me);
        } else {
            wb = wb(c0342a.gUg);
        }
        if (c0342a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wb));
            sb.append(c0342a.gUk);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wb));
            sb.append(c0342a.title);
        }
        return sb.toString();
    }

    private String wb(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String wc(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
