package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bd;
import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.imMessageCenter.im.stranger.MsgReplyCardView;
/* loaded from: classes.dex */
public class MsgReplyCardViewItemAdapter extends bd<MsgReplyCardView> {
    public MsgReplyCardViewItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public be<MsgReplyCardView> a(ViewGroup viewGroup) {
        MsgReplyCardView msgReplyCardView = new MsgReplyCardView(this.mPageContext);
        return new b(this, msgReplyCardView.getConvertView(), msgReplyCardView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.bd
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, be<MsgReplyCardView> beVar) {
        super.a(i, view, viewGroup, chatMessage, (be) beVar);
        MsgReplyCardView Pu = beVar.Pu();
        Pu.a(this.mPageContext, chatMessage, viewGroup);
        Pu.a(this.aZY);
        Pu.setPosition(i);
        this.mPageContext.getLayoutMode().ab(false);
        this.mPageContext.getLayoutMode().j(view);
        return view;
    }
}
