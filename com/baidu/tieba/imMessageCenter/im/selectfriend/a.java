package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> cWO;
    private int cWR = R.color.cp_cont_b;
    private int cWS = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cWO = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWO == null) {
            return 0;
        }
        return this.cWO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mp */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.cWO == null || i < 0 || i >= this.cWO.size()) {
            return null;
        }
        return this.cWO.get(i);
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
        if (!TextUtils.isEmpty(item.aoN()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aoM())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0342a c0342a;
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
                bVar2.cXa = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.divider = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.aoN() != null) {
                bVar.cXa.setText(item.aoN());
            }
            al.f(bVar.cXa, this.cWS, 1);
            al.l(bVar.divider, R.color.cp_bg_line_b);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0342a)) {
                C0342a c0342a2 = new C0342a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0342a2.cWP = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0342a2.cWQ = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0342a2.divider = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0342a2);
                c0342a = c0342a2;
            } else {
                c0342a = (C0342a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0342a.cWQ.setText(item.getUserName());
                c0342a.cWP.startLoad(item.aoM(), 12, false);
            }
            al.f(c0342a.cWQ, this.cWR, 1);
            al.k(c0342a.divider, R.color.cp_bg_line_b);
            al.k(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        TextView cXa;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0342a {
        HeadImageView cWP;
        TextView cWQ;
        View divider;

        private C0342a() {
        }
    }
}
