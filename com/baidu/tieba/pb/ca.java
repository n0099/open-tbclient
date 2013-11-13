package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ca extends by {
    private String j;
    private int k;
    private boolean l;
    private boolean m;

    public ca(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.j = null;
        this.k = 0;
        this.l = false;
        this.m = false;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public boolean c() {
        return this.m;
    }

    @Override // com.baidu.tieba.pb.by, android.widget.Adapter
    public int getCount() {
        if (this.f2106a == null) {
            return 0;
        }
        return (this.l ? 1 : 0) + this.f2106a.size();
    }

    @Override // com.baidu.tieba.pb.by, android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2106a == null || i < 0 || i >= this.f2106a.size()) {
            return null;
        }
        return this.f2106a.get(i);
    }

    public void a(String str, int i) {
        this.j = str;
        this.k = i;
    }

    @Override // com.baidu.tieba.pb.by
    public int a(String str) {
        if (this.f2106a == null) {
            return -1;
        }
        int size = this.f2106a.size();
        for (int i = 0; i < size; i++) {
            if (this.f2106a.get(i).d().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.pb.by
    public void a(com.baidu.tieba.data.as asVar, bz bzVar, boolean z, boolean z2) {
        int i = R.drawable.bg_floor_new_foot_d;
        int i2 = R.dimen.default_size_22;
        boolean z3 = TiebaApplication.g().ap() == 1;
        if (this.j != null && this.k != 0 && this.j.equals(asVar.d())) {
            if (z2 && !z) {
                if (c()) {
                    bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.bg_floor_new_foot_d_1 : R.drawable.bg_floor_new_foot_d);
                } else {
                    bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.bg_floor_new_d_1 : R.drawable.bg_floor_new_d);
                }
                bzVar.f2107a.setPadding(this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(c() ? R.dimen.default_gap_10 : R.dimen.default_size_22), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10));
            } else if (z2) {
                if (c()) {
                    bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.bg_floor_new_middle_d_1 : R.drawable.bg_floor_new_middle_d);
                } else {
                    bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.bg_floor_new_top_d_1 : R.drawable.bg_floor_new_top_d);
                }
                Resources resources = this.b.getResources();
                if (c()) {
                    i2 = R.dimen.default_gap_10;
                }
                bzVar.f2107a.setPadding(this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), resources.getDimensionPixelSize(i2), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10));
            } else if (z) {
                bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.bg_floor_new_middle_d_1 : R.drawable.bg_floor_new_middle_d);
            } else {
                View view = bzVar.f2107a;
                if (z3) {
                    i = R.drawable.bg_floor_new_foot_d_1;
                }
                view.setBackgroundResource(i);
            }
            bzVar.f2107a.setPadding(this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10));
        } else if (c() && z2) {
            if (!z) {
                bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.subpb_list_item_foot_bg_1 : R.drawable.subpb_list_item_foot_bg);
            } else if (z2) {
                bzVar.f2107a.setBackgroundResource(z3 ? R.drawable.subpb_list_item_middle_bg_1 : R.drawable.subpb_list_item_middle_bg);
            }
            Resources resources2 = this.b.getResources();
            if (c()) {
                i2 = R.dimen.default_gap_10;
            }
            bzVar.f2107a.setPadding(this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), resources2.getDimensionPixelSize(i2), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_8), this.b.getResources().getDimensionPixelSize(R.dimen.default_gap_10));
        } else {
            super.a(asVar, bzVar, z, z2);
        }
    }
}
