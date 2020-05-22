package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> ePD;
    private int ePG = R.color.cp_cont_b;
    private int ePH = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ePD = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ePD == null) {
            return 0;
        }
        return this.ePD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pg */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.ePD == null || i < 0 || i >= this.ePD.size()) {
            return null;
        }
        return this.ePD.get(i);
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
        if (!TextUtils.isEmpty(item.baY()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.baX())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0649a c0649a;
        b bVar;
        if (getItemViewType(i) == 2) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (getItemViewType(i) == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.ePP = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.dJr = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.baY() != null) {
                bVar.ePP.setText(item.baY());
            }
            am.setViewTextColor(bVar.ePP, this.ePH, 1);
            am.setBackgroundColor(bVar.dJr, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0649a)) {
                C0649a c0649a2 = new C0649a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0649a2.ePE = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0649a2.ePF = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0649a2.dJr = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0649a2);
                c0649a = c0649a2;
            } else {
                c0649a = (C0649a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0649a.ePF.setText(item.getUserName());
                c0649a.ePE.startLoad(item.baX(), 12, false);
            }
            am.setViewTextColor(c0649a.ePF, this.ePG, 1);
            am.setBackgroundResource(c0649a.dJr, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        View dJr;
        TextView ePP;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0649a {
        View dJr;
        HeadImageView ePE;
        TextView ePF;

        private C0649a() {
        }
    }
}
