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
    private LinearLayout jfF;
    private TextView jfG;
    private TextView jfH;
    private TextView jfI;
    private TextView jfJ;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.jfF = (LinearLayout) findViewById(R.id.reply_card);
        this.jfG = (TextView) findViewById(R.id.reply_title);
        this.jfH = (TextView) findViewById(R.id.reply_content);
        this.jfI = (TextView) findViewById(R.id.reply_quote_content);
        this.jfJ = (TextView) findViewById(R.id.reply_frs_name);
        this.jfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.iKw.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0663a HG = a.HG(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.jfG.setText(a(HG, valueOf));
            this.jfH.setText(HG.jfp);
            this.jfI.setText(b(HG, valueOf));
            this.jfJ.setText(HG.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0663a c0663a, String str) {
        String string;
        String yX;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = yX(c0663a.jfL);
            yX = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            yX = yX(c0663a.jfL);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, yY(c0663a.type), yX);
    }

    private String b(a.C0663a c0663a, String str) {
        String yX;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            yX = this.mContext.getString(R.string.me);
        } else {
            yX = yX(c0663a.jfL);
        }
        if (c0663a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), yX));
            sb.append(c0663a.jfP);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), yX));
            sb.append(c0663a.title);
        }
        return sb.toString();
    }

    private String yX(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String yY(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
