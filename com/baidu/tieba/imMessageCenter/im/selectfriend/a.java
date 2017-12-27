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
    private List<com.baidu.tbadk.coreExtra.relationship.a> bRW;
    private int bRZ = d.C0108d.cp_cont_b;
    private int bSa = d.C0108d.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bRW = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bRW == null) {
            return 0;
        }
        return this.bRW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jx */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.bRW == null || i < 0 || i >= this.bRW.size()) {
            return null;
        }
        return this.bRW.get(i);
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
        if (!TextUtils.isEmpty(item.It()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Is())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0127a c0127a;
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
                bVar2.bSi = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.It() != null) {
                bVar.bSi.setText(item.It());
            }
            aj.e(bVar.bSi, this.bSa, 1);
            aj.t(bVar.divider, d.C0108d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0127a)) {
                C0127a c0127a2 = new C0127a();
                view = LayoutInflater.from(this.mContext).inflate(d.h.select_friend_child_item, (ViewGroup) null);
                c0127a2.bRX = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                c0127a2.bRY = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                c0127a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                view.setTag(c0127a2);
                c0127a = c0127a2;
            } else {
                c0127a = (C0127a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0127a.bRY.setText(item.getUserName());
                c0127a.bRX.startLoad(item.Is(), 12, false);
            }
            aj.e(c0127a.bRY, this.bRZ, 1);
            aj.s(c0127a.divider, d.C0108d.cp_bg_line_b);
            aj.s(view, d.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView bSi;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0127a {
        HeadImageView bRX;
        TextView bRY;
        View divider;

        private C0127a() {
        }
    }
}
