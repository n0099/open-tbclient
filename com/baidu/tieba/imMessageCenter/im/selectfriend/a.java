package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> fpU;
    private int fpX = R.color.cp_cont_b;
    private int fpY = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fpU = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fpU == null) {
            return 0;
        }
        return this.fpU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sg */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.fpU == null || i < 0 || i >= this.fpU.size()) {
            return null;
        }
        return this.fpU.get(i);
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
        if (!TextUtils.isEmpty(item.bpt()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bps())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0726a c0726a;
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
                bVar2.fqg = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.efZ = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bpt() != null) {
                bVar.fqg.setText(item.bpt());
            }
            ap.setViewTextColor(bVar.fqg, this.fpY, 1);
            ap.setBackgroundColor(bVar.efZ, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0726a)) {
                C0726a c0726a2 = new C0726a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0726a2.fpV = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0726a2.fpW = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0726a2.efZ = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0726a2);
                c0726a = c0726a2;
            } else {
                c0726a = (C0726a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0726a.fpW.setText(item.getUserName());
                c0726a.fpV.startLoad(item.bps(), 12, false);
            }
            ap.setViewTextColor(c0726a.fpW, this.fpX, 1);
            ap.setBackgroundResource(c0726a.efZ, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes16.dex */
    private class b {
        View efZ;
        TextView fqg;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    private class C0726a {
        View efZ;
        HeadImageView fpV;
        TextView fpW;

        private C0726a() {
        }
    }
}
