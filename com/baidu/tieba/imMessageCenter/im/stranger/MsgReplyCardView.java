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
    private LinearLayout gUS;
    private TextView gUT;
    private TextView gUU;
    private TextView gUV;
    private TextView gUW;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.gUS = (LinearLayout) findViewById(R.id.reply_card);
        this.gUT = (TextView) findViewById(R.id.reply_title);
        this.gUU = (TextView) findViewById(R.id.reply_content);
        this.gUV = (TextView) findViewById(R.id.reply_quote_content);
        this.gUW = (TextView) findViewById(R.id.reply_frs_name);
        this.gUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.gzE.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0348a zJ = a.zJ(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.gUT.setText(a(zJ, valueOf));
            this.gUU.setText(zJ.gUC);
            this.gUV.setText(b(zJ, valueOf));
            this.gUW.setText(zJ.ckJ + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0348a c0348a, String str) {
        String string;
        String wd;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = wd(c0348a.gUY);
            wd = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            wd = wd(c0348a.gUY);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, we(c0348a.type), wd);
    }

    private String b(a.C0348a c0348a, String str) {
        String wd;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            wd = this.mContext.getString(R.string.me);
        } else {
            wd = wd(c0348a.gUY);
        }
        if (c0348a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), wd));
            sb.append(c0348a.gVc);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), wd));
            sb.append(c0348a.title);
        }
        return sb.toString();
    }

    private String wd(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String we(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
