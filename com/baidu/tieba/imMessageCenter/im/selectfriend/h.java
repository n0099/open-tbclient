package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aTu;
    private int aTx = t.d.cp_cont_b;
    private int aTy = t.d.cp_cont_c;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aTu = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aTu == null) {
            return 0;
        }
        return this.aTu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fT */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aTu == null || i < 0 || i >= this.aTu.size()) {
            return null;
        }
        return this.aTu.get(i);
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
        if (!TextUtils.isEmpty(item.Ap()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Ao())) {
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
                view = LayoutInflater.from(this.mContext).inflate(t.h.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b(this, null);
                bVar2.aTG = (TextView) view.findViewById(t.g.addresslist_group_item_key);
                bVar2.Wx = view.findViewById(t.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.Ap() != null) {
                bVar.aTG.setText(item.Ap());
            }
            av.c(bVar.aTG, this.aTy, 1);
            av.l(bVar.Wx, t.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view = LayoutInflater.from(this.mContext).inflate(t.h.select_friend_child_item, (ViewGroup) null);
                aVar2.aTv = (HeadImageView) view.findViewById(t.g.addresslist_child_item_icon);
                aVar2.aTw = (TextView) view.findViewById(t.g.addresslist_child_item_name);
                aVar2.Wx = view.findViewById(t.g.addresslist_child_item_divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (item.getUserName() != null) {
                aVar.aTw.setText(item.getUserName());
                aVar.aTv.c(item.Ao(), 12, false);
            }
            av.c(aVar.aTw, this.aTx, 1);
            av.k(aVar.Wx, t.d.cp_bg_line_b);
            av.k(view, t.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class b {
        View Wx;
        TextView aTG;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        View Wx;
        HeadImageView aTv;
        TextView aTw;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
