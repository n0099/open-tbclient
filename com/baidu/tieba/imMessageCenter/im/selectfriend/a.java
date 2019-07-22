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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> cYl;
    private int cYo = R.color.cp_cont_b;
    private int cYp = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYl = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cYl == null) {
            return 0;
        }
        return this.cYl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mw */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.cYl == null || i < 0 || i >= this.cYl.size()) {
            return null;
        }
        return this.cYl.get(i);
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
        if (!TextUtils.isEmpty(item.apT()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.apS())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0341a c0341a;
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
                bVar2.cYx = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.divider = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.apT() != null) {
                bVar.cYx.setText(item.apT());
            }
            am.f(bVar.cYx, this.cYp, 1);
            am.l(bVar.divider, R.color.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0341a)) {
                C0341a c0341a2 = new C0341a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0341a2.cYm = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0341a2.cYn = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0341a2.divider = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0341a2);
                c0341a = c0341a2;
            } else {
                c0341a = (C0341a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0341a.cYn.setText(item.getUserName());
                c0341a.cYm.startLoad(item.apS(), 12, false);
            }
            am.f(c0341a.cYn, this.cYo, 1);
            am.k(c0341a.divider, R.color.cp_bg_line_b);
            am.k(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView cYx;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0341a {
        HeadImageView cYm;
        TextView cYn;
        View divider;

        private C0341a() {
        }
    }
}
