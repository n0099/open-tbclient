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
/* loaded from: classes22.dex */
public class MsgReplyCardView extends g {
    private LinearLayout kaH;
    private TextView kaI;
    private TextView kaJ;
    private TextView kaK;
    private TextView kaL;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_reply_card_view);
        init();
    }

    private void init() {
        this.kaH = (LinearLayout) findViewById(R.id.reply_card);
        this.kaI = (TextView) findViewById(R.id.reply_title);
        this.kaJ = (TextView) findViewById(R.id.reply_content);
        this.kaK = (TextView) findViewById(R.id.reply_quote_content);
        this.kaL = (TextView) findViewById(R.id.reply_frs_name);
        this.kaH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.jDj.onItemViewClick(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0742a MF = a.MF(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.kaI.setText(a(MF, valueOf));
            this.kaJ.setText(MF.kaq);
            this.kaK.setText(b(MF, valueOf));
            this.kaL.setText(MF.fName + this.mContext.getString(R.string.forum));
        }
    }

    private String a(a.C0742a c0742a, String str) {
        String string;
        String CW;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = CW(c0742a.kaN);
            CW = this.mContext.getString(R.string.you);
        } else {
            string = this.mContext.getString(R.string.you);
            CW = CW(c0742a.kaN);
        }
        return String.format(this.mContext.getString(R.string.add_friend_card_title), string, CX(c0742a.type), CW);
    }

    private String b(a.C0742a c0742a, String str) {
        String CW;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            CW = this.mContext.getString(R.string.me);
        } else {
            CW = CW(c0742a.kaN);
        }
        if (c0742a.type == 1) {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_comment), CW));
            sb.append(c0742a.kaR);
        } else {
            sb.append(String.format(this.mContext.getString(R.string.add_friend_card_quote_thread), CW));
            sb.append(c0742a.title);
        }
        return sb.toString();
    }

    private String CW(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(R.string.she);
        }
        return this.mContext.getResources().getString(R.string.ta);
    }

    private String CX(int i) {
        return i == 1 ? this.mContext.getResources().getString(R.string.add_friend_card_title_comment) : this.mContext.getResources().getString(R.string.topic_thread);
    }
}
