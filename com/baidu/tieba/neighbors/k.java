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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private NeighborsActivity btW;
    private List<UserInfos> btX;
    private int btY;
    private View.OnClickListener aJJ = null;
    private ArrayList<ProgressBar> btZ = new ArrayList<>();

    public void Sy() {
        if (this.btZ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.btZ.size()) {
                    try {
                        this.btZ.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.btZ.clear();
                    return;
                }
            }
        }
    }

    public k(NeighborsActivity neighborsActivity) {
        this.btW = neighborsActivity;
        this.btY = this.btW.getResources().getDimensionPixelSize(r.ds100);
    }

    public void setData(List<UserInfos> list) {
        this.btX = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.btX == null || this.btX.size() == 0) {
            return 0;
        }
        int size = this.btX.size();
        if (this.btW != null && this.btW.getHasMore()) {
            return size + 1;
        }
        return size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gI */
    public UserInfos getItem(int i) {
        if (this.btX == null || this.btX.size() == 0 || i < 0 || i > this.btX.size() - 1) {
            return null;
        }
        return this.btX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.btX == null || i >= this.btX.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void p(View.OnClickListener onClickListener) {
        this.aJJ = onClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        l lVar;
        if (view == null || view.getTag() == null) {
            l lVar2 = new l(this, null);
            if (getItemViewType(i) == 0) {
                View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.btW, u.neighbor_item, null);
                lVar2.bue = (TbImageView) inflate.findViewById(t.gender_icon);
                lVar2.buf = inflate.findViewById(t.ll_description);
                lVar2.buc = (TextView) inflate.findViewById(t.user_description);
                lVar2.bub = (TextView) inflate.findViewById(t.user_distance);
                lVar2.bua = (TextView) inflate.findViewById(t.user_name);
                lVar2.bud = (HeadImageView) inflate.findViewById(t.user_portrait);
                view2 = inflate;
            } else {
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.btW, u.new_pb_list_more, null);
                lVar2.bua = (TextView) inflate2.findViewById(t.pb_more_text);
                inflate2.setOnClickListener(this.aJJ);
                lVar2.mProgress = (ProgressBar) inflate2.findViewById(t.progress);
                this.btZ.add(lVar2.mProgress);
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
                lVar.bue.setVisibility(4);
            } else {
                lVar.bue.setVisibility(0);
                if (f == 2) {
                    aw.c(lVar.bue, s.icon_pop_qz_girl);
                } else {
                    aw.c(lVar.bue, s.icon_pop_qz_boy);
                }
                if (f == 2) {
                    aw.c(lVar.bue, s.icon_pop_qz_girl);
                }
            }
            if (TextUtils.isEmpty(item.userdetail)) {
                lVar.buf.setVisibility(8);
                lVar.buc.setVisibility(8);
            } else {
                lVar.buc.setText(item.userdetail);
                lVar.buf.setVisibility(0);
                lVar.buc.setVisibility(0);
            }
            if (item.location != null) {
                if (!StringUtils.isNull(item.location.distance) && item.location.time.longValue() > 0) {
                    lVar.bub.setVisibility(0);
                    lVar.bub.setText(String.valueOf(item.location.distance) + "  " + ay.i(item.location.time.longValue()));
                } else {
                    lVar.bub.setVisibility(8);
                }
            } else {
                lVar.bub.setVisibility(8);
            }
            lVar.bua.setText(item.user_name);
            lVar.bud.a(item.portrait, 12, this.btY, this.btY, false);
        } else {
            lVar.bua.setText(this.btW.getString(v.loading));
            lVar.mProgress.setVisibility(0);
        }
        this.btW.getLayoutMode().h(view);
        aw.h(view, s.bg_neighbor_item);
        return view;
    }
}
