package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private int bbC = d.C0080d.cp_cont_b;
    private int bbD = d.C0080d.cp_cont_c;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bbz;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bbz = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbz == null) {
            return 0;
        }
        return this.bbz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: go */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bbz == null || i < 0 || i >= this.bbz.size()) {
            return null;
        }
        return this.bbz.get(i);
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
        if (!TextUtils.isEmpty(item.AG()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.AF())) {
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
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.bbL = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.AG() != null) {
                bVar.bbL.setText(item.AG());
            }
            aj.c(bVar.bbL, this.bbD, 1);
            aj.k(bVar.divider, d.C0080d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0100a)) {
                C0100a c0100a2 = new C0100a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0100a2.bbA = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0100a2.bbB = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0100a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0100a2);
                c0100a = c0100a2;
            } else {
                c0100a = (C0100a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0100a.bbB.setText(item.getUserName());
                c0100a.bbA.startLoad(item.AF(), 12, false);
            }
            aj.c(c0100a.bbB, this.bbC, 1);
            aj.j(c0100a.divider, d.C0080d.cp_bg_line_b);
            aj.j(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView bbL;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0100a {
        HeadImageView bbA;
        TextView bbB;
        View divider;

        private C0100a() {
        }
    }
}
