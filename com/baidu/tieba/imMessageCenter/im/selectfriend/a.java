package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> byw;
    private Context mContext;
    private int byz = e.d.cp_cont_b;
    private int byA = e.d.cp_cont_c;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.byw = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byw == null) {
            return 0;
        }
        return this.byw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hj */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.byw == null || i < 0 || i >= this.byw.size()) {
            return null;
        }
        return this.byw.get(i);
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
        if (!TextUtils.isEmpty(item.IM()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.IL())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0220a c0220a;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.byI = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.IM() != null) {
                bVar.byI.setText(item.IM());
            }
            al.c(bVar.byI, this.byA, 1);
            al.j(bVar.divider, e.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0220a)) {
                C0220a c0220a2 = new C0220a();
                view = LayoutInflater.from(this.mContext).inflate(e.h.select_friend_child_item, (ViewGroup) null);
                c0220a2.byx = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                c0220a2.byy = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                c0220a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                view.setTag(c0220a2);
                c0220a = c0220a2;
            } else {
                c0220a = (C0220a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0220a.byy.setText(item.getUserName());
                c0220a.byx.startLoad(item.IL(), 12, false);
            }
            al.c(c0220a.byy, this.byz, 1);
            al.i(c0220a.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView byI;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0220a {
        HeadImageView byx;
        TextView byy;
        View divider;

        private C0220a() {
        }
    }
}
