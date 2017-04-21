package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aXI;
    private int aXL = w.e.cp_cont_b;
    private int aXM = w.e.cp_cont_c;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aXI = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aXI == null) {
            return 0;
        }
        return this.aXI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fN */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aXI == null || i < 0 || i >= this.aXI.size()) {
            return null;
        }
        return this.aXI.get(i);
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
        if (!TextUtils.isEmpty(item.AX()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.AW())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        TbadkCoreApplication.m9getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(w.j.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b(this, null);
                bVar2.aXU = (TextView) view.findViewById(w.h.addresslist_group_item_key);
                bVar2.abt = view.findViewById(w.h.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.AX() != null) {
                bVar.aXU.setText(item.AX());
            }
            aq.c(bVar.aXU, this.aXM, 1);
            aq.k(bVar.abt, w.e.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view = LayoutInflater.from(this.mContext).inflate(w.j.select_friend_child_item, (ViewGroup) null);
                aVar2.aXJ = (HeadImageView) view.findViewById(w.h.addresslist_child_item_icon);
                aVar2.aXK = (TextView) view.findViewById(w.h.addresslist_child_item_name);
                aVar2.abt = view.findViewById(w.h.addresslist_child_item_divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (item.getUserName() != null) {
                aVar.aXK.setText(item.getUserName());
                aVar.aXJ.c(item.AW(), 12, false);
            }
            aq.c(aVar.aXK, this.aXL, 1);
            aq.j(aVar.abt, w.e.cp_bg_line_b);
            aq.j(view, w.g.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class b {
        TextView aXU;
        View abt;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView aXJ;
        TextView aXK;
        View abt;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
