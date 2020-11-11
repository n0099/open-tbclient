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
    private List<com.baidu.tbadk.coreExtra.relationship.a> fTG;
    private int fTJ = R.color.cp_cont_b;
    private int fTK = R.color.cp_cont_c;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fTG = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fTG == null) {
            return 0;
        }
        return this.fTG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tr */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        if (this.fTG == null || i < 0 || i >= this.fTG.size()) {
            return null;
        }
        return this.fTG.get(i);
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
        if (!TextUtils.isEmpty(item.bxq()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0771a c0771a;
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
                bVar2.fTS = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                bVar2.eIO = view.findViewById(R.id.addresslist_group_item_divider);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (item.bxq() != null) {
                bVar.fTS.setText(item.bxq());
            }
            ap.setViewTextColor(bVar.fTS, this.fTK, 1);
            ap.setBackgroundColor(bVar.eIO, R.color.cp_bg_line_c);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C0771a)) {
                C0771a c0771a2 = new C0771a();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                c0771a2.fTH = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                c0771a2.fTI = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                c0771a2.eIO = view.findViewById(R.id.addresslist_child_item_divider);
                view.setTag(c0771a2);
                c0771a = c0771a2;
            } else {
                c0771a = (C0771a) view.getTag();
            }
            if (item.getUserName() != null) {
                c0771a.fTI.setText(item.getUserName());
                c0771a.fTH.startLoad(item.getUserPortrait(), 12, false);
            }
            ap.setViewTextColor(c0771a.fTI, this.fTJ, 1);
            ap.setBackgroundResource(c0771a.eIO, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.select_friend_item_bg);
            return view;
        } else {
            return null;
        }
    }

    /* loaded from: classes22.dex */
    private class b {
        View eIO;
        TextView fTS;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.selectfriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0771a {
        View eIO;
        HeadImageView fTH;
        TextView fTI;

        private C0771a() {
        }
    }
}
