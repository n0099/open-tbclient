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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> bmw;
    private Context mContext;
    private int bmz = d.C0141d.cp_cont_b;
    private int bmA = d.C0141d.cp_cont_c;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bmw = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bmw == null) {
            return 0;
        }
        return this.bmw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gv */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bmw == null || i < 0 || i >= this.bmw.size()) {
            return null;
        }
        return this.bmw.get(i);
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
        if (!TextUtils.isEmpty(item.Fh()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fg())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0183a c0183a;
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
                bVar2.bmI = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Fh() != null) {
                bVar.bmI.setText(item.Fh());
            }
            al.c(bVar.bmI, this.bmA, 1);
            al.j(bVar.divider, d.C0141d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0183a)) {
                C0183a c0183a2 = new C0183a();
                view = LayoutInflater.from(this.mContext).inflate(d.i.select_friend_child_item, (ViewGroup) null);
                c0183a2.bmx = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0183a2.bmy = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0183a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0183a2);
                c0183a = c0183a2;
            } else {
                c0183a = (C0183a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0183a.bmy.setText(item.getUserName());
                c0183a.bmx.startLoad(item.Fg(), 12, false);
            }
            al.c(c0183a.bmy, this.bmz, 1);
            al.i(c0183a.divider, d.C0141d.cp_bg_line_b);
            al.i(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView bmI;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0183a {
        HeadImageView bmx;
        TextView bmy;
        View divider;

        private C0183a() {
        }
    }
}
