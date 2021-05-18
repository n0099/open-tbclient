package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.k0.f1.b.q.a;
/* loaded from: classes4.dex */
public class OfficialNotificationTextItemAdapter extends MsgCommonItemAdapter<a> {
    public TbPageContext t;
    public View.OnClickListener u;

    public OfficialNotificationTextItemAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.t = tbPageContext;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View h0(int i2, View view, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<a> msgViewHolder) {
        super.W(i2, view, viewGroup, chatMessage, msgViewHolder);
        a b2 = msgViewHolder.b();
        b2.b();
        if (b2 != null) {
            b2.c(chatMessage);
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public MsgCommonItemAdapter.MsgViewHolder<a> P(ViewGroup viewGroup) {
        a aVar = new a(this.t, viewGroup, this.u);
        return new MsgCommonItemAdapter.MsgViewHolder<>(aVar.a(), aVar);
    }

    public void s0(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }
}
