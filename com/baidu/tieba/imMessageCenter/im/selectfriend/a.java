package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aZA;
    private int aZD = d.e.cp_cont_b;
    private int aZE = d.e.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aZA = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZA == null) {
            return 0;
        }
        return this.aZA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fR */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aZA == null || i < 0 || i >= this.aZA.size()) {
            return null;
        }
        return this.aZA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (item == null) {
            return 2;
        }
        if (!TextUtils.isEmpty(item.AP()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.AO())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0100a c0100a;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(d.j.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.aZM = (TextView) view.findViewById(d.h.addresslist_group_item_key);
                bVar2.acJ = view.findViewById(d.h.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.AP() != null) {
                bVar.aZM.setText(item.AP());
            }
            ai.c(bVar.aZM, this.aZE, 1);
            ai.k(bVar.acJ, d.e.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0100a)) {
                C0100a c0100a2 = new C0100a();
                view = LayoutInflater.from(this.mContext).inflate(d.j.select_friend_child_item, (ViewGroup) null);
                c0100a2.aZB = (HeadImageView) view.findViewById(d.h.addresslist_child_item_icon);
                c0100a2.aZC = (TextView) view.findViewById(d.h.addresslist_child_item_name);
                c0100a2.acJ = view.findViewById(d.h.addresslist_child_item_divider);
                view.setTag(c0100a2);
                c0100a = c0100a2;
            } else {
                c0100a = (C0100a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0100a.aZC.setText(item.getUserName());
                c0100a.aZB.c(item.AO(), 12, false);
            }
            ai.c(c0100a.aZC, this.aZD, 1);
            ai.j(c0100a.acJ, d.e.cp_bg_line_b);
            ai.j(view, d.g.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView aZM;
        View acJ;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0100a {
        HeadImageView aZB;
        TextView aZC;
        View acJ;

        private C0100a() {
        }
    }
}
