package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.r;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    private com.baidu.tieba.imMessageCenter.mention.o cZM;
    private int cZN;
    private int cZO;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.cZM = null;
        this.cZN = 0;
        this.cZO = 0;
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
    /* renamed from: kB */
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
                view = LayoutInflater.from(this.mContext).inflate(r.h.reply_and_at_item, viewGroup, false);
                a aVar2 = new a(this, null);
                aVar2.cZP = (LinearLayout) view.findViewById(r.g.reply_and_at_item);
                aVar2.cZQ = (TbImageView) view.findViewById(r.g.arrow_view);
                aVar2.GS = (HeadImageView) view.findViewById(r.g.reply_and_at_head);
                aVar2.GS.setIsRound(true);
                aVar2.GS.setDrawBorder(false);
                aVar2.amY = view.findViewById(r.g.line);
                aVar2.cGT = (TextView) view.findViewById(r.g.new_message);
                aVar2.GT = (TextView) view.findViewById(r.g.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ar.c(aVar.GT, r.d.cp_cont_b, 1);
            ar.k(view, r.f.list_selector);
            ar.k(aVar.amY, r.d.cp_bg_line_b);
            ar.c(aVar.cGT, r.d.common_color_10225, 1);
            aVar.cZQ.setVisibility(8);
            ar.c(aVar.cZQ, r.f.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.cZP.setTag(0);
                a(this.cZN, aVar.cGT, aVar.cZQ);
                ar.c(aVar.GS, r.f.icon_message_mess);
                aVar.GT.setText(r.j.reply_me);
            } else {
                ar.c(aVar.GS, r.f.icon_message_at);
                a(this.cZO, aVar.cGT, aVar.cZQ);
                aVar.GT.setText(r.j.at_me);
                aVar.cZP.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.cZM != null) {
                        this.cZM.gq(true);
                    }
                } else if (this.cZM != null) {
                    this.cZM.gq(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(r.h.chat_list_item, viewGroup, false);
                aVar3 = super.aC(view);
                view.setTag(aVar3);
            }
            ar.k(aVar3.amY, r.d.cp_bg_line_b);
            aVar3.cGQ.setVisibility(0);
            aVar3.amY.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    ar.k(aVar3.cGW, r.f.btn_bgb_choice_s);
                    ar.l(aVar3.cGQ, r.d.cp_bg_line_e);
                } else {
                    ar.k(aVar3.cGW, r.f.btn_bgb_choice_n);
                    ar.k(aVar3.cGQ, r.f.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.c.yV().yY() == 0) {
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
                ar.k(textView, r.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                ar.k(textView, r.f.icon_news_head_prompt_two);
            } else {
                ar.k(textView, r.f.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(com.baidu.tieba.imMessageCenter.mention.o oVar) {
        this.cZM = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.GS.setIsRound(true);
    }

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView GS;
        public TextView GT;
        public View amY;
        public TextView cGT;
        public LinearLayout cZP;
        public TbImageView cZQ;

        private a() {
            this.amY = null;
        }

        /* synthetic */ a(MessageAggregationListAdapter messageAggregationListAdapter, a aVar) {
            this();
        }
    }

    public void ly(int i) {
        this.cZN = i;
    }

    public void lz(int i) {
        this.cZO = i;
    }
}
