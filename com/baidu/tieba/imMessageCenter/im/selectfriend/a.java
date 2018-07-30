package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> boB;
    private int boE = d.C0140d.cp_cont_b;
    private int boF = d.C0140d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boB = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.boB == null) {
            return 0;
        }
        return this.boB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gC */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.boB == null || i < 0 || i >= this.boB.size()) {
            return null;
        }
        return this.boB.get(i);
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
        if (!TextUtils.isEmpty(item.Fv()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fu())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0184a c0184a;
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
                bVar2.boN = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Fv() != null) {
                bVar.boN.setText(item.Fv());
            }
            am.c(bVar.boN, this.boF, 1);
            am.j(bVar.divider, d.C0140d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0184a)) {
                C0184a c0184a2 = new C0184a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0184a2.boC = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0184a2.boD = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0184a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0184a2);
                c0184a = c0184a2;
            } else {
                c0184a = (C0184a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0184a.boD.setText(item.getUserName());
                c0184a.boC.startLoad(item.Fu(), 12, false);
            }
            am.c(c0184a.boD, this.boE, 1);
            am.i(c0184a.divider, d.C0140d.cp_bg_line_b);
            am.i(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView boN;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0184a {
        HeadImageView boC;
        TextView boD;
        View divider;

        private C0184a() {
        }
    }
}
