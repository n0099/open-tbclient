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
    private List<com.baidu.tbadk.coreExtra.relationship.a> bnV;
    private int bnY = d.C0142d.cp_cont_b;
    private int bnZ = d.C0142d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bnV = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnV == null) {
            return 0;
        }
        return this.bnV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gw */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bnV == null || i < 0 || i >= this.bnV.size()) {
            return null;
        }
        return this.bnV.get(i);
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
        if (!TextUtils.isEmpty(item.Fz()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fy())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0185a c0185a;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.boh = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Fz() != null) {
                bVar.boh.setText(item.Fz());
            }
            am.c(bVar.boh, this.bnZ, 1);
            am.j(bVar.divider, d.C0142d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0185a)) {
                C0185a c0185a2 = new C0185a();
                view = LayoutInflater.from(this.mContext).inflate(d.i.select_friend_child_item, (ViewGroup) null);
                c0185a2.bnW = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0185a2.bnX = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0185a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0185a2);
                c0185a = c0185a2;
            } else {
                c0185a = (C0185a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0185a.bnX.setText(item.getUserName());
                c0185a.bnW.startLoad(item.Fy(), 12, false);
            }
            am.c(c0185a.bnX, this.bnY, 1);
            am.i(c0185a.divider, d.C0142d.cp_bg_line_b);
            am.i(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView boh;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0185a {
        HeadImageView bnW;
        TextView bnX;
        View divider;

        private C0185a() {
        }
    }
}
