package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private com.baidu.tieba.imMessageCenter.mention.l dhb;
    private int dhc;
    private int dhd;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.dhb = null;
        this.dhc = 0;
        this.dhd = 0;
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
    /* renamed from: lo */
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
                view = LayoutInflater.from(this.mContext).inflate(r.j.reply_and_at_item, viewGroup, false);
                a aVar2 = new a(this, null);
                aVar2.dhe = (LinearLayout) view.findViewById(r.h.reply_and_at_item);
                aVar2.dhf = (TbImageView) view.findViewById(r.h.arrow_view);
                aVar2.Gc = (HeadImageView) view.findViewById(r.h.reply_and_at_head);
                aVar2.Gc.setIsRound(true);
                aVar2.Gc.setDrawBorder(false);
                aVar2.ame = view.findViewById(r.h.line);
                aVar2.cOb = (TextView) view.findViewById(r.h.new_message);
                aVar2.Gd = (TextView) view.findViewById(r.h.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ap.c(aVar.Gd, r.e.cp_cont_b, 1);
            ap.j(view, r.g.list_selector);
            ap.j(aVar.ame, r.e.cp_bg_line_b);
            ap.c(aVar.cOb, r.e.common_color_10225, 1);
            aVar.dhf.setVisibility(8);
            ap.c(aVar.dhf, r.g.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.dhe.setTag(0);
                a(this.dhc, aVar.cOb, aVar.dhf);
                ap.c(aVar.Gc, r.g.icon_message_mess);
                aVar.Gd.setText(r.l.reply_me);
            } else {
                ap.c(aVar.Gc, r.g.icon_message_at);
                a(this.dhd, aVar.cOb, aVar.dhf);
                aVar.Gd.setText(r.l.at_me);
                aVar.dhe.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.dhb != null) {
                        this.dhb.gt(true);
                    }
                } else if (this.dhb != null) {
                    this.dhb.gt(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(r.j.chat_list_item, viewGroup, false);
                aVar3 = super.aG(view);
                view.setTag(aVar3);
            }
            ap.j(aVar3.ame, r.e.cp_bg_line_b);
            aVar3.cNY.setVisibility(0);
            aVar3.ame.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    ap.j(aVar3.cOe, r.g.btn_bgb_choice_s);
                    ap.k(aVar3.cNY, r.e.cp_bg_line_e);
                } else {
                    ap.j(aVar3.cOe, r.g.btn_bgb_choice_n);
                    ap.j(aVar3.cNY, r.g.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yT() == 0) {
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
                ap.j((View) textView, r.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                ap.j((View) textView, r.g.icon_news_head_prompt_two);
            } else {
                ap.j((View) textView, r.g.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.dhb = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.Gc.setIsRound(true);
    }

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView Gc;
        public TextView Gd;
        public View ame;
        public TextView cOb;
        public LinearLayout dhe;
        public TbImageView dhf;

        private a() {
            this.ame = null;
        }

        /* synthetic */ a(MessageAggregationListAdapter messageAggregationListAdapter, a aVar) {
            this();
        }
    }

    public void ml(int i) {
        this.dhc = i;
    }

    public void mm(int i) {
        this.dhd = i;
    }
}
