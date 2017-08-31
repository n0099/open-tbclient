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
    private List<com.baidu.tbadk.coreExtra.relationship.a> aZo;
    private int aZr = d.e.cp_cont_b;
    private int aZs = d.e.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aZo = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZo == null) {
            return 0;
        }
        return this.aZo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fS */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aZo == null || i < 0 || i >= this.aZo.size()) {
            return null;
        }
        return this.aZo.get(i);
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
        if (!TextUtils.isEmpty(item.AT()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.AS())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0103a c0103a;
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
                bVar2.aZA = (TextView) view.findViewById(d.h.addresslist_group_item_key);
                bVar2.abS = view.findViewById(d.h.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.AT() != null) {
                bVar.aZA.setText(item.AT());
            }
            aj.c(bVar.aZA, this.aZs, 1);
            aj.k(bVar.abS, d.e.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0103a)) {
                C0103a c0103a2 = new C0103a();
                view = LayoutInflater.from(this.mContext).inflate(d.j.select_friend_child_item, (ViewGroup) null);
                c0103a2.aZp = (HeadImageView) view.findViewById(d.h.addresslist_child_item_icon);
                c0103a2.aZq = (TextView) view.findViewById(d.h.addresslist_child_item_name);
                c0103a2.abS = view.findViewById(d.h.addresslist_child_item_divider);
                view.setTag(c0103a2);
                c0103a = c0103a2;
            } else {
                c0103a = (C0103a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0103a.aZq.setText(item.getUserName());
                c0103a.aZp.c(item.AS(), 12, false);
            }
            aj.c(c0103a.aZq, this.aZr, 1);
            aj.j(c0103a.abS, d.e.cp_bg_line_b);
            aj.j(view, d.g.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView aZA;
        View abS;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0103a {
        HeadImageView aZp;
        TextView aZq;
        View abS;

        private C0103a() {
        }
    }
}
