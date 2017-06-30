package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private com.baidu.tieba.imMessageCenter.mention.l drC;
    private int drD;
    private int drE;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.drC = null;
        this.drD = 0;
        this.drE = 0;
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
    /* renamed from: lD */
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
                aVar2.drF = (LinearLayout) view.findViewById(w.h.reply_and_at_item);
                aVar2.drG = (TbImageView) view.findViewById(w.h.arrow_view);
                aVar2.cYy = (HeadImageView) view.findViewById(w.h.reply_and_at_head);
                aVar2.cYy.setIsRound(true);
                aVar2.cYy.setDrawBorder(false);
                aVar2.asD = view.findViewById(w.h.line);
                aVar2.cYC = (TextView) view.findViewById(w.h.new_message);
                aVar2.cYz = (TextView) view.findViewById(w.h.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            as.c(aVar.cYz, w.e.cp_cont_b, 1);
            as.j(view, w.g.list_selector);
            as.j(aVar.asD, w.e.cp_bg_line_b);
            as.c(aVar.cYC, w.e.common_color_10225, 1);
            aVar.drG.setVisibility(8);
            as.c(aVar.drG, w.g.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.drF.setTag(0);
                a(this.drD, aVar.cYC, aVar.drG);
                as.c(aVar.cYy, w.g.icon_message_mess);
                aVar.cYz.setText(w.l.reply_me);
            } else {
                as.c(aVar.cYy, w.g.icon_message_at);
                a(this.drE, aVar.cYC, aVar.drG);
                aVar.cYz.setText(w.l.at_me);
                aVar.drF.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.drC != null) {
                        this.drC.gA(true);
                    }
                } else if (this.drC != null) {
                    this.drC.gA(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(w.j.chat_list_item, viewGroup, false);
                aVar3 = super.az(view);
                view.setTag(aVar3);
            }
            as.j(aVar3.asD, w.e.cp_bg_line_b);
            aVar3.cYx.setVisibility(0);
            aVar3.asD.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    as.j(aVar3.cYF, w.g.btn_bgb_choice_s);
                    as.k(aVar3.cYx, w.e.cp_bg_line_e);
                } else {
                    as.j(aVar3.cYF, w.g.btn_bgb_choice_n);
                    as.j(aVar3.cYx, w.g.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zd().zg() == 0) {
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
                as.j(textView, w.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                as.j(textView, w.g.icon_news_head_prompt_two);
            } else {
                as.j(textView, w.g.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.drC = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.cYy.setIsRound(true);
    }

    /* loaded from: classes2.dex */
    private class a {
        public View asD;
        public TextView cYC;
        public HeadImageView cYy;
        public TextView cYz;
        public LinearLayout drF;
        public TbImageView drG;

        private a() {
            this.asD = null;
        }

        /* synthetic */ a(MessageAggregationListAdapter messageAggregationListAdapter, a aVar) {
            this();
        }
    }

    public void mA(int i) {
        this.drD = i;
    }

    public void mB(int i) {
        this.drE = i;
    }
}
