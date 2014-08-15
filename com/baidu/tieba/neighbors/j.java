package com.baidu.tieba.neighbors;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private NeighborsActivity a;
    private LayoutInflater b;
    private List<UserInfos> c;
    private int d;

    public j(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
        this.b = LayoutInflater.from(this.a);
        this.d = this.a.getResources().getDimensionPixelSize(s.ds100);
    }

    public void a(List<UserInfos> list) {
        this.c = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.size() == 0) {
            return 0;
        }
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public UserInfos getItem(int i) {
        if (this.c == null || this.c.size() == 0 || i < 0 || i > this.c.size() - 1) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) != null ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        int i2;
        String format;
        if (getItemViewType(i) != 1) {
            boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
            if (view == null || view.getTag() == null) {
                k kVar2 = new k(this, null);
                view = this.b.inflate(v.neighbor_item, (ViewGroup) null);
                kVar2.e = (TbImageView) view.findViewById(u.gender_icon);
                kVar2.f = view.findViewById(u.ll_description);
                kVar2.c = (TextView) view.findViewById(u.user_description);
                kVar2.b = (TextView) view.findViewById(u.user_distance);
                kVar2.a = (TextView) view.findViewById(u.user_name);
                kVar2.d = (HeadImageView) view.findViewById(u.user_portrait);
                view.setTag(kVar2);
                kVar = kVar2;
            } else {
                kVar = (k) view.getTag();
            }
            UserInfos item = getItem(i);
            int a = com.baidu.adp.lib.e.b.a(item.sex, 0);
            if (z) {
                i2 = a == 2 ? t.icon_pop_qz_girl_1 : t.icon_pop_qz_boy_1;
            } else {
                i2 = a == 2 ? t.icon_pop_qz_girl : t.icon_pop_qz_boy;
            }
            kVar.e.setImageResource(i2);
            if (TextUtils.isEmpty(item.userdetail)) {
                kVar.f.setVisibility(8);
                kVar.c.setVisibility(8);
            } else {
                kVar.c.setText(item.userdetail);
                kVar.f.setVisibility(0);
                kVar.c.setVisibility(0);
            }
            double doubleValue = item.distance.doubleValue();
            if (doubleValue < 100.0d) {
                format = this.a.getString(x.distance_within_100);
            } else if (doubleValue < 1000.0d) {
                format = String.valueOf((int) doubleValue) + this.a.getString(x.distance_within_1000);
            } else {
                format = String.format(this.a.getString(x.format_neighbor_distance), Double.valueOf(doubleValue / 1000.0d));
            }
            kVar.b.setText(format);
            kVar.a.setText(item.user_name);
            kVar.d.a(item.portrait, 12, this.d, this.d, false);
            this.a.getLayoutMode().a(view);
            if (z) {
                view.setBackgroundResource(t.bg_neighbor_item_1);
            } else {
                view.setBackgroundResource(t.bg_neighbor_item);
            }
        }
        return view;
    }
}
