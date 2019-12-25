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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWv;
    private int dWy = R.color.cp_cont_b;
    private int dWz = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWv = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWv == null) {
            return 0;
        }
        return this.dWv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nT */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.dWv == null || i < 0 || i >= this.dWv.size()) {
            return null;
        }
        return this.dWv.get(i);
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
        if (!TextUtils.isEmpty(item.aJy()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aJx())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0528a c0528a;
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
                bVar2.dWH = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.cRG = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.aJy() != null) {
                bVar.dWH.setText(item.aJy());
            }
            am.setViewTextColor(bVar.dWH, this.dWz, 1);
            am.setBackgroundColor(bVar.cRG, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0528a)) {
                C0528a c0528a2 = new C0528a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0528a2.dWw = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0528a2.dWx = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0528a2.cRG = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0528a2);
                c0528a = c0528a2;
            } else {
                c0528a = (C0528a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0528a.dWx.setText(item.getUserName());
                c0528a.dWw.startLoad(item.aJx(), 12, false);
            }
            am.setViewTextColor(c0528a.dWx, this.dWy, 1);
            am.setBackgroundResource(c0528a.cRG, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        View cRG;
        TextView dWH;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0528a {
        View cRG;
        HeadImageView dWw;
        TextView dWx;

        private C0528a() {
        }
    }
}
