package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes6.dex */
public class OfficialNotificationTextItemAdapter extends e<a> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public OfficialNotificationTextItemAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public e.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, viewGroup, this.mOnClickListener);
        return new e.a<>(aVar.getView(), aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.e, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, e.a<a> aVar) {
        super.a(i, view, viewGroup, chatMessage, (e.a) aVar);
        a bPA = aVar.bPA();
        bPA.onChangeSkinType();
        if (bPA != null) {
            bPA.setData(chatMessage);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
