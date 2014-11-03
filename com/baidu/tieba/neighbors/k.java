package com.baidu.tieba.neighbors;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private NeighborsActivity buk;
    private List<UserInfos> bul;
    private int bum;
    private View.OnClickListener aJW = null;
    private ArrayList<ProgressBar> bun = new ArrayList<>();

    public void SB() {
        if (this.bun != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bun.size()) {
                    try {
                        this.bun.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.bun.clear();
                    return;
                }
            }
        }
    }

    public k(NeighborsActivity neighborsActivity) {
        this.buk = neighborsActivity;
        this.bum = this.buk.getResources().getDimensionPixelSize(r.ds100);
    }

    public void setData(List<UserInfos> list) {
        this.bul = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bul == null || this.bul.size() == 0) {
            return 0;
        }
        int size = this.bul.size();
        if (this.buk != null && this.buk.getHasMore()) {
            return size + 1;
        }
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gI */
    public UserInfos getItem(int i) {
        if (this.bul == null || this.bul.size() == 0 || i < 0 || i > this.bul.size() - 1) {
            return null;
        }
        return this.bul.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.bul == null || i >= this.bul.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aJW = onClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        l lVar;
        if (view == null || view.getTag() == null) {
            l lVar2 = new l(this, null);
            if (getItemViewType(i) == 0) {
                View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.buk, u.neighbor_item, null);
                lVar2.bus = (TbImageView) inflate.findViewById(t.gender_icon);
                lVar2.but = inflate.findViewById(t.ll_description);
                lVar2.buq = (TextView) inflate.findViewById(t.user_description);
                lVar2.bup = (TextView) inflate.findViewById(t.user_distance);
                lVar2.buo = (TextView) inflate.findViewById(t.user_name);
                lVar2.bur = (HeadImageView) inflate.findViewById(t.user_portrait);
                view2 = inflate;
            } else {
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.buk, u.new_pb_list_more, null);
                lVar2.buo = (TextView) inflate2.findViewById(t.pb_more_text);
                inflate2.setOnClickListener(this.aJW);
                lVar2.mProgress = (ProgressBar) inflate2.findViewById(t.progress);
                this.bun.add(lVar2.mProgress);
                view2 = inflate2;
            }
            view2.setTag(lVar2);
            view = view2;
            lVar = lVar2;
        } else {
            lVar = (l) view.getTag();
        }
        if (getItemViewType(i) == 0) {
            UserInfos item = getItem(i);
            int f = com.baidu.adp.lib.g.c.f(item.sex, 0);
            if (f == 0) {
                lVar.bus.setVisibility(4);
            } else {
                lVar.bus.setVisibility(0);
                if (f == 2) {
                    aw.c(lVar.bus, s.icon_pop_qz_girl);
                } else {
                    aw.c(lVar.bus, s.icon_pop_qz_boy);
                }
                if (f == 2) {
                    aw.c(lVar.bus, s.icon_pop_qz_girl);
                }
            }
            if (TextUtils.isEmpty(item.userdetail)) {
                lVar.but.setVisibility(8);
                lVar.buq.setVisibility(8);
            } else {
                lVar.buq.setText(item.userdetail);
                lVar.but.setVisibility(0);
                lVar.buq.setVisibility(0);
            }
            if (item.location != null) {
                if (!StringUtils.isNull(item.location.distance) && item.location.time.longValue() > 0) {
                    lVar.bup.setVisibility(0);
                    lVar.bup.setText(String.valueOf(item.location.distance) + "  " + az.i(item.location.time.longValue()));
                } else {
                    lVar.bup.setVisibility(8);
                }
            } else {
                lVar.bup.setVisibility(8);
            }
            lVar.buo.setText(item.user_name);
            lVar.bur.a(item.portrait, 12, this.bum, this.bum, false);
        } else {
            lVar.buo.setText(this.buk.getString(v.loading));
            lVar.mProgress.setVisibility(0);
        }
        this.buk.getLayoutMode().h(view);
        aw.h(view, s.bg_neighbor_item);
        return view;
    }
}
