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
    private e dOG;
    private int dOH;
    private int dOI;

    public MessageAggregationListAdapter(Context context) {
        super(context);
        this.dOG = null;
        this.dOH = 0;
        this.dOI = 0;
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
    /* renamed from: mC */
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
                view = LayoutInflater.from(this.mContext).inflate(d.h.reply_and_at_item, viewGroup, false);
                a aVar2 = new a();
                aVar2.dOJ = (LinearLayout) view.findViewById(d.g.reply_and_at_item);
                aVar2.dOK = (TbImageView) view.findViewById(d.g.arrow_view);
                aVar2.dvM = (HeadImageView) view.findViewById(d.g.reply_and_at_head);
                aVar2.dvM.setIsRound(true);
                aVar2.dvM.setDrawBorder(false);
                aVar2.mLine = view.findViewById(d.g.line);
                aVar2.dvQ = (TextView) view.findViewById(d.g.new_message);
                aVar2.dvN = (TextView) view.findViewById(d.g.desc_view);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aj.c(aVar.dvN, d.C0080d.cp_cont_b, 1);
            aj.j(view, d.f.list_selector);
            aj.j(aVar.mLine, d.C0080d.cp_bg_line_b);
            aj.c(aVar.dvQ, d.C0080d.common_color_10225, 1);
            aVar.dOK.setVisibility(8);
            aj.c(aVar.dOK, d.f.icon_message_arrow);
            if (itemViewType == 0) {
                aVar.dOJ.setTag(0);
                a(this.dOH, aVar.dvQ, aVar.dOK);
                aj.c(aVar.dvM, d.f.icon_message_mess);
                aVar.dvN.setText(d.j.reply_me);
            } else {
                aj.c(aVar.dvM, d.f.icon_message_at);
                a(this.dOI, aVar.dvQ, aVar.dOK);
                aVar.dvN.setText(d.j.at_me);
                aVar.dOJ.setTag(1);
            }
            view.setTag(aVar);
        } else {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null && String.valueOf(String.valueOf(2)).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    if (this.dOG != null) {
                        this.dOG.gI(true);
                    }
                } else if (this.dOG != null) {
                    this.dOG.gI(false);
                }
            }
            b.a aVar3 = view != null ? (b.a) view.getTag() : null;
            if (aVar3 == null) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.chat_list_item, viewGroup, false);
                aVar3 = super.aK(view);
                view.setTag(aVar3);
            }
            aj.j(aVar3.mLine, d.C0080d.cp_bg_line_b);
            aVar3.dvL.setVisibility(0);
            aVar3.mLine.setVisibility(0);
            if (item != null) {
                super.a(aVar3, item);
                super.d(aVar3, item);
                super.h(aVar3, item);
                super.e(aVar3, item);
                g(aVar3, item);
                super.f(aVar3, item);
                super.b(aVar3, item);
                if (item.isSelected()) {
                    aj.j(aVar3.dvT, d.f.btn_bgb_choice_s);
                    aj.k(aVar3.dvL, d.C0080d.cp_bg_line_e);
                } else {
                    aj.j(aVar3.dvT, d.f.btn_bgb_choice_n);
                    aj.j(aVar3.dvL, d.f.list_selector);
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
                if (com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zc() == 0) {
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
                aj.j(textView, d.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                aj.j(textView, d.f.icon_news_head_prompt_two);
            } else {
                aj.j(textView, d.f.icon_news_head_prompt_more);
                textView.setText("");
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter
    public void a(e eVar) {
        this.dOG = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.dvM.setIsRound(true);
    }

    /* loaded from: classes2.dex */
    private class a {
        public LinearLayout dOJ;
        public TbImageView dOK;
        public HeadImageView dvM;
        public TextView dvN;
        public TextView dvQ;
        public View mLine;

        private a() {
            this.mLine = null;
        }
    }

    public void nz(int i) {
        this.dOH = i;
    }

    public void nA(int i) {
        this.dOI = i;
    }
}
