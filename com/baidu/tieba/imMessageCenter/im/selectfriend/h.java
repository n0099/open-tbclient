package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> axJ;
    private int axM = s.cp_cont_b;
    private int axN = s.cp_cont_c;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axJ = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.axJ == null) {
            return 0;
        }
        return this.axJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: em */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.axJ == null || i < 0 || i >= this.axJ.size()) {
            return null;
        }
        return this.axJ.get(i);
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
        if (!TextUtils.isEmpty(item.wJ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
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
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.select_friend_group_item, null);
                j jVar2 = new j(this, null);
                jVar2.axW = (TextView) view.findViewById(v.addresslist_group_item_key);
                jVar2.axS = view.findViewById(v.addresslist_group_item_divider);
                view.setTag(jVar2);
                jVar = jVar2;
            } else {
                jVar = (j) view.getTag();
            }
            if (item.wJ() != null) {
                jVar.axW.setText(item.wJ());
            }
            ba.b(jVar.axW, this.axN, 1);
            ba.j(jVar.axS, s.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof i)) {
                i iVar2 = new i(this, null);
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.select_friend_child_item, null);
                iVar2.axK = (HeadImageView) view.findViewById(v.addresslist_child_item_icon);
                iVar2.axL = (TextView) view.findViewById(v.addresslist_child_item_name);
                iVar2.axS = view.findViewById(v.addresslist_child_item_divider);
                view.setTag(iVar2);
                iVar = iVar2;
            } else {
                iVar = (i) view.getTag();
            }
            if (item.getUserName() != null) {
                iVar.axL.setText(item.getUserName());
                iVar.axK.c(item.getUserPortrait(), 12, false);
            }
            ba.b(iVar.axL, this.axM, 1);
            ba.i(iVar.axS, s.cp_bg_line_b);
            ba.i(view, u.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }
}
