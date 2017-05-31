package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ar;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.c;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class MsgReplyCardView extends ar {
    private LinearLayout dls;
    private TextView dlt;
    private TextView dlu;
    private TextView dlv;
    private TextView dlw;

    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_reply_card_view);
        init();
    }

    private void init() {
        this.dls = (LinearLayout) findViewById(w.h.reply_card);
        this.dlt = (TextView) findViewById(w.h.reply_title);
        this.dlu = (TextView) findViewById(w.h.reply_content);
        this.dlv = (TextView) findViewById(w.h.reply_quote_content);
        this.dlw = (TextView) findViewById(w.h.reply_frs_name);
        this.dls.setOnClickListener(new a(this));
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            c.a lt = c.lt(chatMessage.getContent());
            String valueOf = String.valueOf(chatMessage.getUserId());
            this.dlt.setText(a(lt, valueOf));
            this.dlu.setText(lt.dlb);
            this.dlv.setText(b(lt, valueOf));
            this.dlw.setText(String.valueOf(lt.dlF) + this.mContext.getString(w.l.bar));
        }
    }

    private String a(c.a aVar, String str) {
        String string;
        String mt;
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            string = mt(aVar.dlz);
            mt = this.mContext.getString(w.l.you);
        } else {
            string = this.mContext.getString(w.l.you);
            mt = mt(aVar.dlz);
        }
        return String.format(this.mContext.getString(w.l.add_friend_card_title), string, getType(aVar.type), mt);
    }

    private String b(c.a aVar, String str) {
        String mt;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            mt = this.mContext.getString(w.l.me);
        } else {
            mt = mt(aVar.dlz);
        }
        if (aVar.type == 1) {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_comment), mt));
            sb.append(aVar.dlD);
        } else {
            sb.append(String.format(this.mContext.getString(w.l.add_friend_card_quote_thread), mt));
            sb.append(aVar.title);
        }
        return sb.toString();
    }

    private String mt(int i) {
        if (i == 1) {
            return this.mContext.getResources().getString(w.l.he);
        }
        if (i == 2) {
            return this.mContext.getResources().getString(w.l.she);
        }
        return this.mContext.getResources().getString(w.l.ta);
    }

    private String getType(int i) {
        return i == 1 ? this.mContext.getResources().getString(w.l.add_friend_card_title_comment) : this.mContext.getResources().getString(w.l.topic_thread);
    }
}
