package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class OfficialNotificationTextItemAdapter extends MsgCommonItemAdapter<a> {
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;

    public OfficialNotificationTextItemAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public MsgCommonItemAdapter.MsgViewHolder<a> e(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, viewGroup, this.mOnClickListener);
        return new MsgCommonItemAdapter.MsgViewHolder<>(aVar.getView(), aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<a> msgViewHolder) {
        super.a(i, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) msgViewHolder);
        a cUM = msgViewHolder.cUM();
        cUM.onChangeSkinType();
        if (cUM != null) {
            cUM.setData(chatMessage);
        }
        return view;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
