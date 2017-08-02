package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private e dAe;
    private int dAf;
    private int dAg;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.dAe = null;
        this.dAf = 0;
        this.dAg = 0;
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size() + 2;
        }
        return 2;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        if (this.mList == null) {
            this.mList = new LinkedList();
        }
        this.mList = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    /* renamed from: lN */
    public ImMessageCenterShowItemData getItem(int i) {
        int i2;
        if (this.mList == null || this.mList.size() == 0 || i - 2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.mList.get(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i != 1 ? 3 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0 || itemViewType == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                view = LayoutInflater.from(this.mContext).inflate(d.j.reply_and_at_item, viewGroup, false);
                a aVar2 = new a();
                aVar2.dAh = (LinearLayout) view.findViewById(d.h.reply_and_at_item);
                aVar2.dAi = (TbImageView) view.findViewById(d.h.arrow_view);
                aVar2.dhg = (HeadImageView) view.findViewById(d.h.reply_and_at_head);
                aVar2.dhg.setIsRound(true);
                aVar2.dhg.setDrawBorder(false);
                aVar2.atu = view.findViewById(d.h.line);
                aVar2.dhk = (TextView) view.findViewById(d.h.new_message);
                aVar2.dhh = (TextView) view.findViewById(d.h.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ai.c(aVar.dhh, d.e.cp_cont_b, 1);
            ai.j(view, d.g.list_selector);
            ai.j(aVar.atu, d.e.cp_bg_line_b);
            ai.c(aVar.dhk, d.e.common_color_10225, 1);
            aVar.dAi.setVisibility(8);
            ai.c(aVar.dAi, d.g.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.dAh.setTag(0);
                a(this.dAf, aVar.dhk, aVar.dAi);
                ai.c(aVar.dhg, d.g.icon_message_mess);
                aVar.dhh.setText(d.l.reply_me);
            } else {
                ai.c(aVar.dhg, d.g.icon_message_at);
                a(this.dAg, aVar.dhk, aVar.dAi);
                aVar.dhh.setText(d.l.at_me);
                aVar.dAh.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.dAe != null) {
                        this.dAe.gO(true);
                    }
                } else if (this.dAe != null) {
                    this.dAe.gO(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(d.j.chat_list_item, viewGroup, false);
                aVar3 = super.aE(view);
                view.setTag(aVar3);
            }
            ai.j(aVar3.atu, d.e.cp_bg_line_b);
            aVar3.dhf.setVisibility(0);
            aVar3.atu.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    ai.j(aVar3.dhn, d.g.btn_bgb_choice_s);
                    ai.k(aVar3.dhf, d.e.cp_bg_line_e);
                } else {
                    ai.j(aVar3.dhn, d.g.btn_bgb_choice_n);
                    ai.j(aVar3.dhf, d.g.list_selector);
                }
            }
        }
        return view;
    }

    private void a(int i, TextView textView, TbImageView tbImageView) {
        String valueOf;
        if (textView != null && tbImageView != null) {
            if (i > 0) {
                textView.setVisibility(0);
                if (i <= 99) {
                    String.valueOf(i);
                }
                if (com.baidu.tbadk.coreExtra.messageCenter.b.zo().zr() == 0) {
                    valueOf = "";
                    i = 0;
                } else {
                    valueOf = String.valueOf(i);
                }
                textView.setText(valueOf);
            } else {
                textView.setVisibility(8);
            }
            if (i < 10) {
                if (i == 0) {
                    textView.setVisibility(8);
                    tbImageView.setVisibility(0);
                    return;
                }
                ai.j(textView, d.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                ai.j(textView, d.g.icon_news_head_prompt_two);
            } else {
                ai.j(textView, d.g.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(e eVar) {
        this.dAe = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.dhg.setIsRound(true);
    }

    /* loaded from: classes2.dex */
    private class a {
        public View atu;
        public LinearLayout dAh;
        public TbImageView dAi;
        public HeadImageView dhg;
        public TextView dhh;
        public TextView dhk;

        private a() {
            this.atu = null;
        }
    }

    public void mJ(int i) {
        this.dAf = i;
    }

    public void mK(int i) {
        this.dAg = i;
    }
}
