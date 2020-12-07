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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private int gbA = R.color.CAM_X0105;
    private int gbB = R.color.CAM_X0108;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gbx;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gbx = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gbx == null) {
            return 0;
        }
        return this.gbx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ut */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.gbx == null || i < 0 || i >= this.gbx.size()) {
            return null;
        }
        return this.gbx.get(i);
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
        if (!TextUtils.isEmpty(item.bAg()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0789a c0789a;
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
                bVar2.gbJ = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.eOv = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bAg() != null) {
                bVar.gbJ.setText(item.bAg());
            }
            ap.setViewTextColor(bVar.gbJ, this.gbB, 1);
            ap.setBackgroundColor(bVar.eOv, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0789a)) {
                C0789a c0789a2 = new C0789a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0789a2.gby = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0789a2.gbz = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0789a2.eOv = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0789a2);
                c0789a = c0789a2;
            } else {
                c0789a = (C0789a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0789a.gbz.setText(item.getUserName());
                c0789a.gby.startLoad(item.getUserPortrait(), 12, false);
            }
            ap.setViewTextColor(c0789a.gbz, this.gbA, 1);
            ap.setBackgroundResource(c0789a.eOv, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes22.dex */
    private class b {
        View eOv;
        TextView gbJ;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0789a {
        View eOv;
        HeadImageView gby;
        TextView gbz;

        private C0789a() {
        }
    }
}
