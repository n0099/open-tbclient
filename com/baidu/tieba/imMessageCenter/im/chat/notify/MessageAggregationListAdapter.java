package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private e dKR;
    private int dKS;
    private int dKT;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.dKR = null;
        this.dKS = 0;
        this.dKT = 0;
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
    /* renamed from: mq */
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
                aVar2.dKU = (LinearLayout) view.findViewById(d.h.reply_and_at_item);
                aVar2.dKV = (TbImageView) view.findViewById(d.h.arrow_view);
                aVar2.drU = (HeadImageView) view.findViewById(d.h.reply_and_at_head);
                aVar2.drU.setIsRound(true);
                aVar2.drU.setDrawBorder(false);
                aVar2.aWX = view.findViewById(d.h.line);
                aVar2.drY = (TextView) view.findViewById(d.h.new_message);
                aVar2.drV = (TextView) view.findViewById(d.h.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aj.c(aVar.drV, d.e.cp_cont_b, 1);
            aj.j(view, d.g.list_selector);
            aj.j(aVar.aWX, d.e.cp_bg_line_b);
            aj.c(aVar.drY, d.e.common_color_10225, 1);
            aVar.dKV.setVisibility(8);
            aj.c(aVar.dKV, d.g.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.dKU.setTag(0);
                a(this.dKS, aVar.drY, aVar.dKV);
                aj.c(aVar.drU, d.g.icon_message_mess);
                aVar.drV.setText(d.l.reply_me);
            } else {
                aj.c(aVar.drU, d.g.icon_message_at);
                a(this.dKT, aVar.drY, aVar.dKV);
                aVar.drV.setText(d.l.at_me);
                aVar.dKU.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.dKR != null) {
                        this.dKR.ha(true);
                    }
                } else if (this.dKR != null) {
                    this.dKR.ha(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(d.j.chat_list_item, viewGroup, false);
                aVar3 = super.aN(view);
                view.setTag(aVar3);
            }
            aj.j(aVar3.aWX, d.e.cp_bg_line_b);
            aVar3.drT.setVisibility(0);
            aVar3.aWX.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    aj.j(aVar3.dsb, d.g.btn_bgb_choice_s);
                    aj.k(aVar3.drT, d.e.cp_bg_line_e);
                } else {
                    aj.j(aVar3.dsb, d.g.btn_bgb_choice_n);
                    aj.j(aVar3.drT, d.g.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.b.zA().zD() == 0) {
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
                aj.j(textView, d.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                aj.j(textView, d.g.icon_news_head_prompt_two);
            } else {
                aj.j(textView, d.g.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(e eVar) {
        this.dKR = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.drU.setIsRound(true);
    }

    /* loaded from: classes2.dex */
    private class a {
        public View aWX;
        public LinearLayout dKU;
        public TbImageView dKV;
        public HeadImageView drU;
        public TextView drV;
        public TextView drY;

        private a() {
            this.aWX = null;
        }
    }

    public void nn(int i) {
        this.dKS = i;
    }

    public void no(int i) {
        this.dKT = i;
    }
}
