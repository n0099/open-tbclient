package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> feB;
    private int feE = R.color.cp_cont_b;
    private int feF = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.feB = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.feB == null) {
            return 0;
        }
        return this.feB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pU */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.feB == null || i < 0 || i >= this.feB.size()) {
            return null;
        }
        return this.feB.get(i);
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
        if (!TextUtils.isEmpty(item.bgI()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bgH())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0674a c0674a;
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
                bVar2.feN = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.dWz = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bgI() != null) {
                bVar.feN.setText(item.bgI());
            }
            ao.setViewTextColor(bVar.feN, this.feF, 1);
            ao.setBackgroundColor(bVar.dWz, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0674a)) {
                C0674a c0674a2 = new C0674a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0674a2.feC = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0674a2.feD = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0674a2.dWz = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0674a2);
                c0674a = c0674a2;
            } else {
                c0674a = (C0674a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0674a.feD.setText(item.getUserName());
                c0674a.feC.startLoad(item.bgH(), 12, false);
            }
            ao.setViewTextColor(c0674a.feD, this.feE, 1);
            ao.setBackgroundResource(c0674a.dWz, R.color.cp_bg_line_c);
            ao.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes16.dex */
    private class b {
        View dWz;
        TextView feN;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    private class C0674a {
        View dWz;
        HeadImageView feC;
        TextView feD;

        private C0674a() {
        }
    }
}
