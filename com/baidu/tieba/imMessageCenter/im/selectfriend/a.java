package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> eZZ;
    private int fac = R.color.cp_cont_b;
    private int fad = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eZZ = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eZZ == null) {
            return 0;
        }
        return this.eZZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pH */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.eZZ == null || i < 0 || i >= this.eZZ.size()) {
            return null;
        }
        return this.eZZ.get(i);
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
        if (!TextUtils.isEmpty(item.bdb()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bda())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0662a c0662a;
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
                bVar2.fal = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.dQh = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bdb() != null) {
                bVar.fal.setText(item.bdb());
            }
            an.setViewTextColor(bVar.fal, this.fad, 1);
            an.setBackgroundColor(bVar.dQh, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0662a)) {
                C0662a c0662a2 = new C0662a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0662a2.faa = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0662a2.fab = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0662a2.dQh = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0662a2);
                c0662a = c0662a2;
            } else {
                c0662a = (C0662a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0662a.fab.setText(item.getUserName());
                c0662a.faa.startLoad(item.bda(), 12, false);
            }
            an.setViewTextColor(c0662a.fab, this.fac, 1);
            an.setBackgroundResource(c0662a.dQh, R.color.cp_bg_line_c);
            an.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        View dQh;
        TextView fal;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0662a {
        View dQh;
        HeadImageView faa;
        TextView fab;

        private C0662a() {
        }
    }
}
