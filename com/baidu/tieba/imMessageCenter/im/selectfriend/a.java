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
    private List<com.baidu.tbadk.coreExtra.relationship.a> bzh;
    private int bzk = e.d.cp_cont_b;
    private int bzl = e.d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bzh = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bzh == null) {
            return 0;
        }
        return this.bzh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hw */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bzh == null || i < 0 || i >= this.bzh.size()) {
            return null;
        }
        return this.bzh.get(i);
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
        if (!TextUtils.isEmpty(item.IY()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.IX())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0246a c0246a;
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
                bVar2.bzt = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.IY() != null) {
                bVar.bzt.setText(item.IY());
            }
            al.c(bVar.bzt, this.bzl, 1);
            al.j(bVar.divider, e.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0246a)) {
                C0246a c0246a2 = new C0246a();
                view = LayoutInflater.from(this.mContext).inflate(e.h.select_friend_child_item, (ViewGroup) null);
                c0246a2.bzi = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                c0246a2.bzj = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                c0246a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                view.setTag(c0246a2);
                c0246a = c0246a2;
            } else {
                c0246a = (C0246a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0246a.bzj.setText(item.getUserName());
                c0246a.bzi.startLoad(item.IX(), 12, false);
            }
            al.c(c0246a.bzj, this.bzk, 1);
            al.i(c0246a.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView bzt;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0246a {
        HeadImageView bzi;
        TextView bzj;
        View divider;

        private C0246a() {
        }
    }
}
