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
    private List<com.baidu.tbadk.coreExtra.relationship.a> eBe;
    private int eBh = R.color.cp_cont_b;
    private int eBi = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eBe = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBe == null) {
            return 0;
        }
        return this.eBe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oz */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.eBe == null || i < 0 || i >= this.eBe.size()) {
            return null;
        }
        return this.eBe.get(i);
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
        if (!TextUtils.isEmpty(item.aUO()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aUN())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0599a c0599a;
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
                bVar2.eBq = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.dvw = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.aUO() != null) {
                bVar.eBq.setText(item.aUO());
            }
            am.setViewTextColor(bVar.eBq, this.eBi, 1);
            am.setBackgroundColor(bVar.dvw, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0599a)) {
                C0599a c0599a2 = new C0599a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0599a2.eBf = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0599a2.eBg = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0599a2.dvw = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0599a2);
                c0599a = c0599a2;
            } else {
                c0599a = (C0599a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0599a.eBg.setText(item.getUserName());
                c0599a.eBf.startLoad(item.aUN(), 12, false);
            }
            am.setViewTextColor(c0599a.eBg, this.eBh, 1);
            am.setBackgroundResource(c0599a.dvw, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        View dvw;
        TextView eBq;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0599a {
        View dvw;
        HeadImageView eBf;
        TextView eBg;

        private C0599a() {
        }
    }
}
