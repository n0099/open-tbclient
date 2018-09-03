package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.a;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends g {
    private LinearLayout eFV;
    private TextView eFW;
    private TextView eFX;
    private TextView eFY;
    private TextView eFZ;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, f.h.msg_reply_card_view);
        init();
    }

    private void init() {
        this.eFV = (LinearLayout) findViewById(f.g.reply_card);
        this.eFW = (TextView) findViewById(f.g.reply_title);
        this.eFX = (TextView) findViewById(f.g.reply_content);
        this.eFY = (TextView) findViewById(f.g.reply_quote_content);
        this.eFZ = (TextView) findViewById(f.g.reply_frs_name);
        this.eFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgReplyCardView.this.ekw.a(view, 14, MsgReplyCardView.this.mPosition, 0L);
            }
        });
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            a.C0185a pa = a.pa(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.eFW.setText(a(pa, valueOf));
            this.eFX.setText(pa.eFF);
            this.eFY.setText(b(pa, valueOf));
            this.eFZ.setText(pa.aGa + this.mContext.getString(f.j.forum));
        }
    }

    private String a(a.C0185a c0185a, String str) {
        String string;
        String oK;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = oK(c0185a.eGb);
            oK = this.mContext.getString(f.j.you);
        } else {
            string = this.mContext.getString(f.j.you);
            oK = oK(c0185a.eGb);
        }
        return String.format(this.mContext.getString(f.j.add_friend_card_title), string, getType(c0185a.type), oK);
    }

    private String b(a.C0185a c0185a, String str) {
        String oK;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            oK = this.mContext.getString(f.j.me);
        } else {
            oK = oK(c0185a.eGb);
        }
        if (c0185a.type == 1) {
            sb.append(String.format(this.mContext.getString(f.j.add_friend_card_quote_comment), oK));
            sb.append(c0185a.eGf);
        } else {
            sb.append(String.format(this.mContext.getString(f.j.add_friend_card_quote_thread), oK));
            sb.append(c0185a.title);
        }
        return sb.toString();
    }

    private String oK(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(f.j.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(f.j.she);
        }
        return this.mContext.getResources().getString(f.j.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(f.j.add_friend_card_title_comment) : this.mContext.getResources().getString(f.j.topic_thread);
    }
}
