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
    private List<com.baidu.tbadk.coreExtra.relationship.a> bSd;
    private int bSg = d.C0107d.cp_cont_b;
    private int bSh = d.C0107d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bSd = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bSd == null) {
            return 0;
        }
        return this.bSd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jt */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bSd == null || i < 0 || i >= this.bSd.size()) {
            return null;
        }
        return this.bSd.get(i);
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
        if (!TextUtils.isEmpty(item.Im()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Il())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0126a c0126a;
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
                bVar2.bSp = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Im() != null) {
                bVar.bSp.setText(item.Im());
            }
            aj.e(bVar.bSp, this.bSh, 1);
            aj.t(bVar.divider, d.C0107d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0126a)) {
                C0126a c0126a2 = new C0126a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0126a2.bSe = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0126a2.bSf = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0126a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0126a2);
                c0126a = c0126a2;
            } else {
                c0126a = (C0126a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0126a.bSf.setText(item.getUserName());
                c0126a.bSe.startLoad(item.Il(), 12, false);
            }
            aj.e(c0126a.bSf, this.bSg, 1);
            aj.s(c0126a.divider, d.C0107d.cp_bg_line_b);
            aj.s(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView bSp;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0126a {
        HeadImageView bSe;
        TextView bSf;
        View divider;

        private C0126a() {
        }
    }
}
