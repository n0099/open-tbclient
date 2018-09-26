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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> but;
    private int buw = e.d.cp_cont_b;
    private int bux = e.d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.but = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.but == null) {
            return 0;
        }
        return this.but.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hb */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.but == null || i < 0 || i >= this.but.size()) {
            return null;
        }
        return this.but.get(i);
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
        if (!TextUtils.isEmpty(item.GL()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.GK())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0186a c0186a;
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
                bVar2.buF = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.GL() != null) {
                bVar.buF.setText(item.GL());
            }
            al.c(bVar.buF, this.bux, 1);
            al.j(bVar.divider, e.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0186a)) {
                C0186a c0186a2 = new C0186a();
                view = LayoutInflater.from(this.mContext).inflate(e.h.select_friend_child_item, (ViewGroup) null);
                c0186a2.buu = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                c0186a2.buv = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                c0186a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                view.setTag(c0186a2);
                c0186a = c0186a2;
            } else {
                c0186a = (C0186a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0186a.buv.setText(item.getUserName());
                c0186a.buu.startLoad(item.GK(), 12, false);
            }
            al.c(c0186a.buv, this.buw, 1);
            al.i(c0186a.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView buF;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0186a {
        HeadImageView buu;
        TextView buv;
        View divider;

        private C0186a() {
        }
    }
}
