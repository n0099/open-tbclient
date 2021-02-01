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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private int giB = R.color.CAM_X0105;
    private int giC = R.color.CAM_X0108;
    private List<com.baidu.tbadk.coreExtra.relationship.a> giy;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.giy = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.giy == null) {
            return 0;
        }
        return this.giy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: td */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.giy == null || i < 0 || i >= this.giy.size()) {
            return null;
        }
        return this.giy.get(i);
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
        if (!TextUtils.isEmpty(item.byZ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0767a c0767a;
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
                bVar2.giK = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.bTo = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.byZ() != null) {
                bVar.giK.setText(item.byZ());
            }
            ap.setViewTextColor(bVar.giK, this.giC, 1);
            ap.setBackgroundColor(bVar.bTo, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0767a)) {
                C0767a c0767a2 = new C0767a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0767a2.giz = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0767a2.giA = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0767a2.bTo = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0767a2);
                c0767a = c0767a2;
            } else {
                c0767a = (C0767a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0767a.giA.setText(item.getUserName());
                c0767a.giz.startLoad(item.getUserPortrait(), 12, false);
            }
            ap.setViewTextColor(c0767a.giA, this.giB, 1);
            ap.setBackgroundResource(c0767a.bTo, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        View bTo;
        TextView giK;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0767a {
        View bTo;
        TextView giA;
        HeadImageView giz;

        private C0767a() {
        }
    }
}
