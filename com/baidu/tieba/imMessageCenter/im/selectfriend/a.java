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
    private List<com.baidu.tbadk.coreExtra.relationship.a> giM;
    private int giP = R.color.CAM_X0105;
    private int giQ = R.color.CAM_X0108;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.giM = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.giM == null) {
            return 0;
        }
        return this.giM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: td */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.giM == null || i < 0 || i >= this.giM.size()) {
            return null;
        }
        return this.giM.get(i);
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
        C0768a c0768a;
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
                bVar2.giY = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.bTo = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.byZ() != null) {
                bVar.giY.setText(item.byZ());
            }
            ap.setViewTextColor(bVar.giY, this.giQ, 1);
            ap.setBackgroundColor(bVar.bTo, R.color.CAM_X0204);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0768a)) {
                C0768a c0768a2 = new C0768a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0768a2.giN = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0768a2.giO = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0768a2.bTo = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0768a2);
                c0768a = c0768a2;
            } else {
                c0768a = (C0768a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0768a.giO.setText(item.getUserName());
                c0768a.giN.startLoad(item.getUserPortrait(), 12, false);
            }
            ap.setViewTextColor(c0768a.giO, this.giP, 1);
            ap.setBackgroundResource(c0768a.bTo, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class b {
        View bTo;
        TextView giY;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0768a {
        View bTo;
        HeadImageView giN;
        TextView giO;

        private C0768a() {
        }
    }
}
