package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private int aJA = n.d.cp_cont_b;
    private int aJB = n.d.cp_cont_c;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aJx;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aJx = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJx == null) {
            return 0;
        }
        return this.aJx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eX */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.aJx == null || i < 0 || i >= this.aJx.size()) {
            return null;
        }
        return this.aJx.get(i);
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
        if (!TextUtils.isEmpty(item.zh()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
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
                view = LayoutInflater.from(this.mContext).inflate(n.h.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b(this, null);
                bVar2.aJJ = (TextView) view.findViewById(n.g.addresslist_group_item_key);
                bVar2.YE = view.findViewById(n.g.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.zh() != null) {
                bVar.aJJ.setText(item.zh());
            }
            as.b(bVar.aJJ, this.aJB, 1);
            as.j(bVar.YE, n.d.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view = LayoutInflater.from(this.mContext).inflate(n.h.select_friend_child_item, (ViewGroup) null);
                aVar2.aJy = (HeadImageView) view.findViewById(n.g.addresslist_child_item_icon);
                aVar2.aJz = (TextView) view.findViewById(n.g.addresslist_child_item_name);
                aVar2.YE = view.findViewById(n.g.addresslist_child_item_divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (item.getUserName() != null) {
                aVar.aJz.setText(item.getUserName());
                aVar.aJy.d(item.getUserPortrait(), 12, false);
            }
            as.b(aVar.aJz, this.aJA, 1);
            as.i(aVar.YE, n.d.cp_bg_line_b);
            as.i(view, n.f.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class b {
        View YE;
        TextView aJJ;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        View YE;
        HeadImageView aJy;
        TextView aJz;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
