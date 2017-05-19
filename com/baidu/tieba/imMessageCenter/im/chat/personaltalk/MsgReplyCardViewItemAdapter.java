package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ao;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView;
/* loaded from: classes2.dex */
public class MsgReplyCardViewItemAdapter extends ao<MsgReplyCardView> {
    public MsgReplyCardViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public ao.a<MsgReplyCardView> onCreateViewHolder(ViewGroup viewGroup) {
        MsgReplyCardView msgReplyCardView = new MsgReplyCardView(this.ajr);
        return new a(msgReplyCardView.cf(), msgReplyCardView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ao
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ao.a<MsgReplyCardView> aVar) {
        super.onFillViewHolder(i, view, viewGroup, chatMessage, aVar);
        MsgReplyCardView alq = aVar.alq();
        alq.a(this.ajr, chatMessage, viewGroup);
        alq.a(this.cJM);
        alq.setPosition(i);
        this.ajr.getLayoutMode().ai(false);
        this.ajr.getLayoutMode().t(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends ao.a<MsgReplyCardView> {
        public a(View view, MsgReplyCardView msgReplyCardView) {
            super(view, msgReplyCardView);
        }
    }
}
