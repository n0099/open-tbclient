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
    private List<com.baidu.tbadk.coreExtra.relationship.a> cOB;
    private int cOE = d.C0277d.cp_cont_b;
    private int cOF = d.C0277d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cOB = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cOB == null) {
            return 0;
        }
        return this.cOB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lA */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.cOB == null || i < 0 || i >= this.cOB.size()) {
            return null;
        }
        return this.cOB.get(i);
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
        if (!TextUtils.isEmpty(item.ajM()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.ajL())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0325a c0325a;
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
                bVar2.cON = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.ajM() != null) {
                bVar.cON.setText(item.ajM());
            }
            al.d(bVar.cON, this.cOF, 1);
            al.l(bVar.divider, d.C0277d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0325a)) {
                C0325a c0325a2 = new C0325a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0325a2.cOC = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0325a2.cOD = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0325a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0325a2);
                c0325a = c0325a2;
            } else {
                c0325a = (C0325a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0325a.cOD.setText(item.getUserName());
                c0325a.cOC.startLoad(item.ajL(), 12, false);
            }
            al.d(c0325a.cOD, this.cOE, 1);
            al.k(c0325a.divider, d.C0277d.cp_bg_line_b);
            al.k(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView cON;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0325a {
        HeadImageView cOC;
        TextView cOD;
        View divider;

        private C0325a() {
        }
    }
}
