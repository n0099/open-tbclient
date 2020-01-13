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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWE;
    private int dWH = R.color.cp_cont_b;
    private int dWI = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWE = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWE == null) {
            return 0;
        }
        return this.dWE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nT */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.dWE == null || i < 0 || i >= this.dWE.size()) {
            return null;
        }
        return this.dWE.get(i);
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
        if (!TextUtils.isEmpty(item.aJS()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aJR())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0533a c0533a;
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
                bVar2.dWQ = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.cRQ = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.aJS() != null) {
                bVar.dWQ.setText(item.aJS());
            }
            am.setViewTextColor(bVar.dWQ, this.dWI, 1);
            am.setBackgroundColor(bVar.cRQ, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0533a)) {
                C0533a c0533a2 = new C0533a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0533a2.dWF = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0533a2.dWG = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0533a2.cRQ = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0533a2);
                c0533a = c0533a2;
            } else {
                c0533a = (C0533a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0533a.dWG.setText(item.getUserName());
                c0533a.dWF.startLoad(item.aJR(), 12, false);
            }
            am.setViewTextColor(c0533a.dWG, this.dWH, 1);
            am.setBackgroundResource(c0533a.cRQ, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        View cRQ;
        TextView dWQ;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0533a {
        View cRQ;
        HeadImageView dWF;
        TextView dWG;

        private C0533a() {
        }
    }
}
