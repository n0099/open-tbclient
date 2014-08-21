package com.baidu.tieba.neighbors;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private NeighborsActivity a;
    private List<UserInfos> b;
    private int c;
    private View.OnClickListener e = null;
    private ArrayList<ProgressBar> d = new ArrayList<>();

    public void a() {
        if (this.d != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.d.size()) {
                    try {
                        this.d.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.d.clear();
                    return;
                }
            }
        }
    }

    public l(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
        this.c = this.a.getResources().getDimensionPixelSize(s.ds100);
    }

    public void a(List<UserInfos> list) {
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.size() == 0) {
            return 0;
        }
        int size = this.b.size();
        if (this.a != null && this.a.b()) {
            return size + 1;
        }
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public UserInfos getItem(int i) {
        if (this.b == null || this.b.size() == 0 || i < 0 || i > this.b.size() - 1) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.b == null || i >= this.b.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        m mVar;
        int i2;
        String format;
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null) {
            m mVar2 = new m(this, null);
            if (getItemViewType(i) == 0) {
                View a = com.baidu.adp.lib.e.b.a().a(this.a, v.neighbor_item, null);
                mVar2.e = (TbImageView) a.findViewById(u.gender_icon);
                mVar2.f = a.findViewById(u.ll_description);
                mVar2.c = (TextView) a.findViewById(u.user_description);
                mVar2.b = (TextView) a.findViewById(u.user_distance);
                mVar2.a = (TextView) a.findViewById(u.user_name);
                mVar2.d = (HeadImageView) a.findViewById(u.user_portrait);
                view2 = a;
            } else {
                View a2 = com.baidu.adp.lib.e.b.a().a(this.a, v.new_pb_list_more, null);
                mVar2.a = (TextView) a2.findViewById(u.pb_more_text);
                a2.setOnClickListener(this.e);
                mVar2.g = (ProgressBar) a2.findViewById(u.progress);
                this.d.add(mVar2.g);
                view2 = a2;
            }
            view2.setTag(mVar2);
            view = view2;
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        if (getItemViewType(i) == 0) {
            UserInfos item = getItem(i);
            int a3 = com.baidu.adp.lib.e.c.a(item.sex, 0);
            if (a3 == 0) {
                mVar.e.setVisibility(4);
            } else {
                mVar.e.setVisibility(0);
                if (z) {
                    i2 = a3 == 2 ? t.icon_pop_qz_girl_1 : t.icon_pop_qz_boy_1;
                } else {
                    i2 = a3 == 2 ? t.icon_pop_qz_girl : t.icon_pop_qz_boy;
                }
                mVar.e.setImageResource(i2);
            }
            if (TextUtils.isEmpty(item.userdetail)) {
                mVar.f.setVisibility(8);
                mVar.c.setVisibility(8);
            } else {
                mVar.c.setText(item.userdetail);
                mVar.f.setVisibility(0);
                mVar.c.setVisibility(0);
            }
            double doubleValue = item.distance.doubleValue();
            if (doubleValue < 100.0d) {
                format = this.a.getString(x.distance_within_100);
            } else if (doubleValue < 1000.0d) {
                format = String.valueOf((int) doubleValue) + this.a.getString(x.distance_within_1000);
            } else {
                format = String.format(this.a.getString(x.format_neighbor_distance), Double.valueOf(doubleValue / 1000.0d));
            }
            mVar.b.setText(format);
            mVar.a.setText(item.user_name);
            mVar.d.a(item.portrait, 12, this.c, this.c, false);
        } else {
            mVar.a.setText(this.a.getString(x.loading));
            mVar.g.setVisibility(0);
        }
        this.a.getLayoutMode().a(view);
        if (z) {
            view.setBackgroundResource(t.bg_neighbor_item_1);
        } else {
            view.setBackgroundResource(t.bg_neighbor_item);
        }
        return view;
    }
}
