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
    private List<com.baidu.tbadk.coreExtra.relationship.a> beL;
    private int beO = d.C0096d.cp_cont_b;
    private int beP = d.C0096d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.beL = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.beL == null) {
            return 0;
        }
        return this.beL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gz */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.beL == null || i < 0 || i >= this.beL.size()) {
            return null;
        }
        return this.beL.get(i);
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
        if (!TextUtils.isEmpty(item.AR()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.AQ())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0116a c0116a;
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
                bVar2.beX = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.AR() != null) {
                bVar.beX.setText(item.AR());
            }
            aj.c(bVar.beX, this.beP, 1);
            aj.k(bVar.divider, d.C0096d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0116a)) {
                C0116a c0116a2 = new C0116a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0116a2.beM = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0116a2.beN = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0116a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0116a2);
                c0116a = c0116a2;
            } else {
                c0116a = (C0116a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0116a.beN.setText(item.getUserName());
                c0116a.beM.startLoad(item.AQ(), 12, false);
            }
            aj.c(c0116a.beN, this.beO, 1);
            aj.j(c0116a.divider, d.C0096d.cp_bg_line_b);
            aj.j(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView beX;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0116a {
        HeadImageView beM;
        TextView beN;
        View divider;

        private C0116a() {
        }
    }
}
