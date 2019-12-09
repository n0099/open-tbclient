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
    private List<com.baidu.tbadk.coreExtra.relationship.a> diL;
    private int diO = R.color.cp_cont_b;
    private int diP = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.diL = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.diL == null) {
            return 0;
        }
        return this.diL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lF */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.diL == null || i < 0 || i >= this.diL.size()) {
            return null;
        }
        return this.diL.get(i);
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
        if (!TextUtils.isEmpty(item.arZ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.arY())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0442a c0442a;
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
                bVar2.diX = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.cfh = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.arZ() != null) {
                bVar.diX.setText(item.arZ());
            }
            am.setViewTextColor(bVar.diX, this.diP, 1);
            am.setBackgroundColor(bVar.cfh, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0442a)) {
                C0442a c0442a2 = new C0442a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0442a2.diM = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0442a2.diN = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0442a2.cfh = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0442a2);
                c0442a = c0442a2;
            } else {
                c0442a = (C0442a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0442a.diN.setText(item.getUserName());
                c0442a.diM.startLoad(item.arY(), 12, false);
            }
            am.setViewTextColor(c0442a.diN, this.diO, 1);
            am.setBackgroundResource(c0442a.cfh, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private class b {
        View cfh;
        TextView diX;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0442a {
        View cfh;
        HeadImageView diM;
        TextView diN;

        private C0442a() {
        }
    }
}
