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
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aVG;
    private int aVJ = w.e.cp_cont_b;
    private int aVK = w.e.cp_cont_c;
    private Context mContext;

    public k(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aVG = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVG == null) {
            return 0;
        }
        return this.aVG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fK */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aVG == null || i < 0 || i >= this.aVG.size()) {
            return null;
        }
        return this.aVG.get(i);
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
        if (!TextUtils.isEmpty(item.Ab()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Aa())) {
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
                bVar2.aVS = (TextView) view.findViewById(w.h.addresslist_group_item_key);
                bVar2.aaM = view.findViewById(w.h.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Ab() != null) {
                bVar.aVS.setText(item.Ab());
            }
            aq.c(bVar.aVS, this.aVK, 1);
            aq.k(bVar.aaM, w.e.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view = LayoutInflater.from(this.mContext).inflate(w.j.select_friend_child_item, (ViewGroup) null);
                aVar2.aVH = (HeadImageView) view.findViewById(w.h.addresslist_child_item_icon);
                aVar2.aVI = (TextView) view.findViewById(w.h.addresslist_child_item_name);
                aVar2.aaM = view.findViewById(w.h.addresslist_child_item_divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (item.getUserName() != null) {
                aVar.aVI.setText(item.getUserName());
                aVar.aVH.c(item.Aa(), 12, false);
            }
            aq.c(aVar.aVI, this.aVJ, 1);
            aq.j(aVar.aaM, w.e.cp_bg_line_b);
            aq.j(view, w.g.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        TextView aVS;
        View aaM;

        private b() {
        }

        /* synthetic */ b(k kVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private class a {
        HeadImageView aVH;
        TextView aVI;
        View aaM;

        private a() {
        }

        /* synthetic */ a(k kVar, a aVar) {
            this();
        }
    }
}
