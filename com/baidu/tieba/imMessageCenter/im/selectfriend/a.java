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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> cOC;
    private int cOF = d.C0236d.cp_cont_b;
    private int cOG = d.C0236d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cOC = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cOC == null) {
            return 0;
        }
        return this.cOC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lB */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.cOC == null || i < 0 || i >= this.cOC.size()) {
            return null;
        }
        return this.cOC.get(i);
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
        if (!TextUtils.isEmpty(item.ajQ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.ajP())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0262a c0262a;
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
                bVar2.cOO = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.ajQ() != null) {
                bVar.cOO.setText(item.ajQ());
            }
            al.d(bVar.cOO, this.cOG, 1);
            al.l(bVar.divider, d.C0236d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0262a)) {
                C0262a c0262a2 = new C0262a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0262a2.cOD = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0262a2.cOE = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0262a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0262a2);
                c0262a = c0262a2;
            } else {
                c0262a = (C0262a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0262a.cOE.setText(item.getUserName());
                c0262a.cOD.startLoad(item.ajP(), 12, false);
            }
            al.d(c0262a.cOE, this.cOF, 1);
            al.k(c0262a.divider, d.C0236d.cp_bg_line_b);
            al.k(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView cOO;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0262a {
        HeadImageView cOD;
        TextView cOE;
        View divider;

        private C0262a() {
        }
    }
}
