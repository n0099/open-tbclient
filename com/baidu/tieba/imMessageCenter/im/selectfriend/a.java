package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> ben;
    private int beq = d.C0126d.cp_cont_b;
    private int ber = d.C0126d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ben = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ben == null) {
            return 0;
        }
        return this.ben.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gu */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.ben == null || i < 0 || i >= this.ben.size()) {
            return null;
        }
        return this.ben.get(i);
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
        if (!TextUtils.isEmpty(item.BG()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.BF())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0167a c0167a;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.beA = (TextView) view2.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view2.findViewById(d.g.addresslist_group_item_divider);
                view2.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view2.getTag();
            }
            if (item.BG() != null) {
                bVar.beA.setText(item.BG());
            }
            ak.c(bVar.beA, this.ber, 1);
            ak.j(bVar.divider, d.C0126d.cp_bg_line_b);
            return view2;
        } else if (getItemViewType(i) == 1) {
            if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof C0167a)) {
                C0167a c0167a2 = new C0167a();
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.select_friend_child_item, (ViewGroup) null);
                c0167a2.beo = (HeadImageView) view2.findViewById(d.g.addresslist_child_item_icon);
                c0167a2.bep = (TextView) view2.findViewById(d.g.addresslist_child_item_name);
                c0167a2.divider = view2.findViewById(d.g.addresslist_child_item_divider);
                view2.setTag(c0167a2);
                c0167a = c0167a2;
            } else {
                c0167a = (C0167a) view2.getTag();
            }
            if (item.getUserName() != null) {
                c0167a.bep.setText(item.getUserName());
                c0167a.beo.startLoad(item.BF(), 12, false);
            }
            ak.c(c0167a.bep, this.beq, 1);
            ak.i(c0167a.divider, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.select_friend_item_bg);
            return view2;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView beA;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0167a {
        HeadImageView beo;
        TextView bep;
        View divider;

        private C0167a() {
        }
    }
}
