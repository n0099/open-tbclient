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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> bDu;
    private int bDx = e.d.cp_cont_b;
    private int bDy = e.d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bDu = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDu == null) {
            return 0;
        }
        return this.bDu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hL */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bDu == null || i < 0 || i >= this.bDu.size()) {
            return null;
        }
        return this.bDu.get(i);
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
        if (!TextUtils.isEmpty(item.Ks()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Kr())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0257a c0257a;
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
                bVar2.bDG = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Ks() != null) {
                bVar.bDG.setText(item.Ks());
            }
            al.c(bVar.bDG, this.bDy, 1);
            al.j(bVar.divider, e.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0257a)) {
                C0257a c0257a2 = new C0257a();
                view = LayoutInflater.from(this.mContext).inflate(e.h.select_friend_child_item, (ViewGroup) null);
                c0257a2.bDv = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                c0257a2.bDw = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                c0257a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                view.setTag(c0257a2);
                c0257a = c0257a2;
            } else {
                c0257a = (C0257a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0257a.bDw.setText(item.getUserName());
                c0257a.bDv.startLoad(item.Kr(), 12, false);
            }
            al.c(c0257a.bDw, this.bDx, 1);
            al.i(c0257a.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView bDG;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0257a {
        HeadImageView bDv;
        TextView bDw;
        View divider;

        private C0257a() {
        }
    }
}
