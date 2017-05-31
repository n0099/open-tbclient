package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private com.baidu.tieba.imMessageCenter.mention.l djG;
    private int djH;
    private int djI;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.djG = null;
        this.djH = 0;
        this.djI = 0;
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
    /* renamed from: ls */
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
                view = LayoutInflater.from(this.mContext).inflate(w.j.reply_and_at_item, viewGroup, false);
                a aVar2 = new a(this, null);
                aVar2.djJ = (LinearLayout) view.findViewById(w.h.reply_and_at_item);
                aVar2.djK = (TbImageView) view.findViewById(w.h.arrow_view);
                aVar2.cQC = (HeadImageView) view.findViewById(w.h.reply_and_at_head);
                aVar2.cQC.setIsRound(true);
                aVar2.cQC.setDrawBorder(false);
                aVar2.arA = view.findViewById(w.h.line);
                aVar2.cQG = (TextView) view.findViewById(w.h.new_message);
                aVar2.cQD = (TextView) view.findViewById(w.h.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aq.c(aVar.cQD, w.e.cp_cont_b, 1);
            aq.j(view, w.g.list_selector);
            aq.j(aVar.arA, w.e.cp_bg_line_b);
            aq.c(aVar.cQG, w.e.common_color_10225, 1);
            aVar.djK.setVisibility(8);
            aq.c(aVar.djK, w.g.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.djJ.setTag(0);
                a(this.djH, aVar.cQG, aVar.djK);
                aq.c(aVar.cQC, w.g.icon_message_mess);
                aVar.cQD.setText(w.l.reply_me);
            } else {
                aq.c(aVar.cQC, w.g.icon_message_at);
                a(this.djI, aVar.cQG, aVar.djK);
                aVar.cQD.setText(w.l.at_me);
                aVar.djJ.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.djG != null) {
                        this.djG.gi(true);
                    }
                } else if (this.djG != null) {
                    this.djG.gi(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(w.j.chat_list_item, viewGroup, false);
                aVar3 = super.ax(view);
                view.setTag(aVar3);
            }
            aq.j(aVar3.arA, w.e.cp_bg_line_b);
            aVar3.cQB.setVisibility(0);
            aVar3.arA.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    aq.j(aVar3.cQJ, w.g.btn_bgb_choice_s);
                    aq.k(aVar3.cQB, w.e.cp_bg_line_e);
                } else {
                    aq.j(aVar3.cQJ, w.g.btn_bgb_choice_n);
                    aq.j(aVar3.cQB, w.g.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yN() == 0) {
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
                aq.j(textView, w.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                aq.j(textView, w.g.icon_news_head_prompt_two);
            } else {
                aq.j(textView, w.g.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.djG = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.cQC.setIsRound(true);
    }

    /* loaded from: classes2.dex */
    private class a {
        public View arA;
        public HeadImageView cQC;
        public TextView cQD;
        public TextView cQG;
        public LinearLayout djJ;
        public TbImageView djK;

        private a() {
            this.arA = null;
        }

        /* synthetic */ a(MessageAggregationListAdapter messageAggregationListAdapter, a aVar) {
            this();
        }
    }

    public void mp(int i) {
        this.djH = i;
    }

    public void mq(int i) {
        this.djI = i;
    }
}
