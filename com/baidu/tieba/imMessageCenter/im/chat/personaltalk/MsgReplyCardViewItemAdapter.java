package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ap;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView;
/* loaded from: classes.dex */
public class MsgReplyCardViewItemAdapter extends ap<MsgReplyCardView> {
    public MsgReplyCardViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public ap.a<MsgReplyCardView> a(ViewGroup viewGroup) {
        MsgReplyCardView msgReplyCardView = new MsgReplyCardView(this.EA);
        return new a(msgReplyCardView.ac(), msgReplyCardView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.ap
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, ap.a<MsgReplyCardView> aVar) {
        super.a(i, view, viewGroup, chatMessage, (ap.a) aVar);
        MsgReplyCardView alo = aVar.alo();
        alo.a(this.EA, chatMessage, viewGroup);
        alo.a(this.cHE);
        alo.setPosition(i);
        this.EA.getLayoutMode().af(false);
        this.EA.getLayoutMode().w(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ap.a<MsgReplyCardView> {
        public a(View view, MsgReplyCardView msgReplyCardView) {
            super(view, msgReplyCardView);
        }
    }
}
