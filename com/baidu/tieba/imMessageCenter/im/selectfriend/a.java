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
    private List<com.baidu.tbadk.coreExtra.relationship.a> ePO;
    private int ePR = R.color.cp_cont_b;
    private int ePS = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ePO = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ePO == null) {
            return 0;
        }
        return this.ePO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pi */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.ePO == null || i < 0 || i >= this.ePO.size()) {
            return null;
        }
        return this.ePO.get(i);
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
        if (!TextUtils.isEmpty(item.baZ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.baY())) {
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
                bVar2.eQa = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.dJr = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.baZ() != null) {
                bVar.eQa.setText(item.baZ());
            }
            am.setViewTextColor(bVar.eQa, this.ePS, 1);
            am.setBackgroundColor(bVar.dJr, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0649a)) {
                C0649a c0649a2 = new C0649a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0649a2.ePP = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0649a2.ePQ = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0649a2.dJr = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0649a2);
                c0649a = c0649a2;
            } else {
                c0649a = (C0649a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0649a.ePQ.setText(item.getUserName());
                c0649a.ePP.startLoad(item.baY(), 12, false);
            }
            am.setViewTextColor(c0649a.ePQ, this.ePR, 1);
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
        TextView eQa;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0649a {
        View dJr;
        HeadImageView ePP;
        TextView ePQ;

        private C0649a() {
        }
    }
}
