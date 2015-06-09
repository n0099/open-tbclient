package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> azw;
    private Context mContext;
    private int azz = n.cp_cont_b;
    private int azA = n.cp_cont_c;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azw = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azw == null) {
            return 0;
        }
        return this.azw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ey */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.azw == null || i < 0 || i >= this.azw.size()) {
            return null;
        }
        return this.azw.get(i);
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
        if (!TextUtils.isEmpty(item.xx()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar;
        j jVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        TbadkCoreApplication.m411getInst().getSkinType();
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof j)) {
                view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.select_friend_group_item, null);
                j jVar2 = new j(this, null);
                jVar2.azI = (TextView) view.findViewById(q.addresslist_group_item_key);
                jVar2.So = view.findViewById(q.addresslist_group_item_divider);
                view.setTag(jVar2);
                jVar = jVar2;
            } else {
                jVar = (j) view.getTag();
            }
            if (item.xx() != null) {
                jVar.azI.setText(item.xx());
            }
            ay.b(jVar.azI, this.azA, 1);
            ay.j(jVar.So, n.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof i)) {
                i iVar2 = new i(this, null);
                view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.select_friend_child_item, null);
                iVar2.azx = (HeadImageView) view.findViewById(q.addresslist_child_item_icon);
                iVar2.azy = (TextView) view.findViewById(q.addresslist_child_item_name);
                iVar2.So = view.findViewById(q.addresslist_child_item_divider);
                view.setTag(iVar2);
                iVar = iVar2;
            } else {
                iVar = (i) view.getTag();
            }
            if (item.getUserName() != null) {
                iVar.azy.setText(item.getUserName());
                iVar.azx.c(item.getUserPortrait(), 12, false);
            }
            ay.b(iVar.azy, this.azz, 1);
            ay.i(iVar.So, n.cp_bg_line_b);
            ay.i(view, p.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
