package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private int aNB = t.d.cp_cont_b;
    private int aNC = t.d.cp_cont_c;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aNy;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aNy = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aNy == null) {
            return 0;
        }
        return this.aNy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fG */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aNy == null || i < 0 || i >= this.aNy.size()) {
            return null;
        }
        return this.aNy.get(i);
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
        if (!TextUtils.isEmpty(item.Bc()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
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
        TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(t.h.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b(this, null);
                bVar2.aNK = (TextView) view.findViewById(t.g.addresslist_group_item_key);
                bVar2.Xu = view.findViewById(t.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Bc() != null) {
                bVar.aNK.setText(item.Bc());
            }
            at.b(bVar.aNK, this.aNC, 1);
            at.l(bVar.Xu, t.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view = LayoutInflater.from(this.mContext).inflate(t.h.select_friend_child_item, (ViewGroup) null);
                aVar2.aNz = (HeadImageView) view.findViewById(t.g.addresslist_child_item_icon);
                aVar2.aNA = (TextView) view.findViewById(t.g.addresslist_child_item_name);
                aVar2.Xu = view.findViewById(t.g.addresslist_child_item_divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (item.getUserName() != null) {
                aVar.aNA.setText(item.getUserName());
                aVar.aNz.c(item.getUserPortrait(), 12, false);
            }
            at.b(aVar.aNA, this.aNB, 1);
            at.k(aVar.Xu, t.d.cp_bg_line_b);
            at.k(view, t.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class b {
        View Xu;
        TextView aNK;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        View Xu;
        TextView aNA;
        HeadImageView aNz;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
