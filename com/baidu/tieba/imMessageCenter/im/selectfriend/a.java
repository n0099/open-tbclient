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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> ftk;
    private int ftn = R.color.cp_cont_b;
    private int fto = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ftk = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ftk == null) {
            return 0;
        }
        return this.ftk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sy */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.ftk == null || i < 0 || i >= this.ftk.size()) {
            return null;
        }
        return this.ftk.get(i);
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
        if (!TextUtils.isEmpty(item.bqo()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bqn())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0723a c0723a;
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
                bVar2.fty = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.eis = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bqo() != null) {
                bVar.fty.setText(item.bqo());
            }
            ap.setViewTextColor(bVar.fty, this.fto, 1);
            ap.setBackgroundColor(bVar.eis, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0723a)) {
                C0723a c0723a2 = new C0723a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0723a2.ftl = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0723a2.ftm = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0723a2.eis = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0723a2);
                c0723a = c0723a2;
            } else {
                c0723a = (C0723a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0723a.ftm.setText(item.getUserName());
                c0723a.ftl.startLoad(item.bqn(), 12, false);
            }
            ap.setViewTextColor(c0723a.ftm, this.ftn, 1);
            ap.setBackgroundResource(c0723a.eis, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        View eis;
        TextView fty;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0723a {
        View eis;
        HeadImageView ftl;
        TextView ftm;

        private C0723a() {
        }
    }
}
