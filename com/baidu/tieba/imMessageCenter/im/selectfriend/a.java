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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> ggi;
    private int ggl = R.color.CAM_X0105;
    private int ggm = R.color.CAM_X0108;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ggi = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ggi == null) {
            return 0;
        }
        return this.ggi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sY */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.ggi == null || i < 0 || i >= this.ggi.size()) {
            return null;
        }
        return this.ggi.get(i);
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
        if (!TextUtils.isEmpty(item.byH()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0765a c0765a;
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
                bVar2.ggu = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.bPy = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.byH() != null) {
                bVar.ggu.setText(item.byH());
            }
            ao.setViewTextColor(bVar.ggu, this.ggm, 1);
            ao.setBackgroundColor(bVar.bPy, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0765a)) {
                C0765a c0765a2 = new C0765a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0765a2.ggj = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0765a2.ggk = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0765a2.bPy = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0765a2);
                c0765a = c0765a2;
            } else {
                c0765a = (C0765a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0765a.ggk.setText(item.getUserName());
                c0765a.ggj.startLoad(item.getUserPortrait(), 12, false);
            }
            ao.setViewTextColor(c0765a.ggk, this.ggl, 1);
            ao.setBackgroundResource(c0765a.bPy, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        View bPy;
        TextView ggu;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0765a {
        View bPy;
        HeadImageView ggj;
        TextView ggk;

        private C0765a() {
        }
    }
}
