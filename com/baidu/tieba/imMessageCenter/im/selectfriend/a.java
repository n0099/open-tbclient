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
    private List<com.baidu.tbadk.coreExtra.relationship.a> baY;
    private int bbb = d.e.cp_cont_b;
    private int bbc = d.e.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.baY = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.baY == null) {
            return 0;
        }
        return this.baY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gg */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.baY == null || i < 0 || i >= this.baY.size()) {
            return null;
        }
        return this.baY.get(i);
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
        if (!TextUtils.isEmpty(item.Ar()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Aq())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0102a c0102a;
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
                bVar2.bbk = (TextView) view.findViewById(d.h.addresslist_group_item_key);
                bVar2.abT = view.findViewById(d.h.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Ar() != null) {
                bVar.bbk.setText(item.Ar());
            }
            aj.c(bVar.bbk, this.bbc, 1);
            aj.k(bVar.abT, d.e.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0102a)) {
                C0102a c0102a2 = new C0102a();
                view = LayoutInflater.from(this.mContext).inflate(d.j.select_friend_child_item, (ViewGroup) null);
                c0102a2.baZ = (HeadImageView) view.findViewById(d.h.addresslist_child_item_icon);
                c0102a2.bba = (TextView) view.findViewById(d.h.addresslist_child_item_name);
                c0102a2.abT = view.findViewById(d.h.addresslist_child_item_divider);
                view.setTag(c0102a2);
                c0102a = c0102a2;
            } else {
                c0102a = (C0102a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0102a.bba.setText(item.getUserName());
                c0102a.baZ.c(item.Aq(), 12, false);
            }
            aj.c(c0102a.bba, this.bbb, 1);
            aj.j(c0102a.abT, d.e.cp_bg_line_b);
            aj.j(view, d.g.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        View abT;
        TextView bbk;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0102a {
        View abT;
        HeadImageView baZ;
        TextView bba;

        private C0102a() {
        }
    }
}
