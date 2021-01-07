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
    private List<com.baidu.tbadk.coreExtra.relationship.a> gkQ;
    private int gkT = R.color.CAM_X0105;
    private int gkU = R.color.CAM_X0108;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkQ = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkQ == null) {
            return 0;
        }
        return this.gkQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uE */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.gkQ == null || i < 0 || i >= this.gkQ.size()) {
            return null;
        }
        return this.gkQ.get(i);
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
        if (!TextUtils.isEmpty(item.bCB()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0782a c0782a;
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
                bVar2.glc = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.bUk = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bCB() != null) {
                bVar.glc.setText(item.bCB());
            }
            ao.setViewTextColor(bVar.glc, this.gkU, 1);
            ao.setBackgroundColor(bVar.bUk, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0782a)) {
                C0782a c0782a2 = new C0782a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0782a2.gkR = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0782a2.gkS = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0782a2.bUk = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0782a2);
                c0782a = c0782a2;
            } else {
                c0782a = (C0782a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0782a.gkS.setText(item.getUserName());
                c0782a.gkR.startLoad(item.getUserPortrait(), 12, false);
            }
            ao.setViewTextColor(c0782a.gkS, this.gkT, 1);
            ao.setBackgroundResource(c0782a.bUk, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        View bUk;
        TextView glc;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0782a {
        View bUk;
        HeadImageView gkR;
        TextView gkS;

        private C0782a() {
        }
    }
}
