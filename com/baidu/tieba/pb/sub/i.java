package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ai;
/* loaded from: classes.dex */
public final class i extends b {
    private String j;
    private int k;
    private boolean l;
    private boolean m;

    public i(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        this.j = null;
        this.k = 0;
        this.l = false;
        this.m = false;
    }

    public final void b(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.tieba.pb.sub.b, android.widget.Adapter
    public final int getCount() {
        if (this.a == null) {
            return 0;
        }
        return (this.l ? 1 : 0) + this.a.size();
    }

    @Override // com.baidu.tieba.pb.sub.b, android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    public final void a(String str, int i) {
        this.j = str;
        this.k = i;
    }

    @Override // com.baidu.tieba.pb.sub.b
    public final int a(String str) {
        if (this.a == null) {
            return -1;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).d().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.baidu.tieba.pb.sub.b
    public final void a(ai aiVar, c cVar, boolean z, boolean z2) {
        boolean z3 = TbadkApplication.j().l() == 1;
        if (this.j != null && this.k != 0 && this.j.equals(aiVar.d())) {
            if (z2 && !z) {
                if (this.m) {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_foot_d_1 : com.baidu.tieba.a.g.bg_floor_new_foot_d);
                } else {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_d_1 : com.baidu.tieba.a.g.bg_floor_new_d);
                }
                cVar.a.setPadding(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(this.m ? com.baidu.tieba.a.f.default_gap_10 : com.baidu.tieba.a.f.default_size_22), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_10));
            } else if (z2) {
                if (this.m) {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_middle_d_1 : com.baidu.tieba.a.g.bg_floor_new_middle_d);
                } else {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_top_d_1 : com.baidu.tieba.a.g.bg_floor_new_top_d);
                }
                cVar.a.setPadding(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(this.m ? com.baidu.tieba.a.f.default_gap_10 : com.baidu.tieba.a.f.default_size_22), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_10));
            } else {
                if (z) {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_middle_d_1 : com.baidu.tieba.a.g.bg_floor_new_middle_d);
                } else {
                    cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.bg_floor_new_foot_d_1 : com.baidu.tieba.a.g.bg_floor_new_foot_d);
                }
                cVar.a.setPadding(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_10), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_10));
            }
        } else if (this.m && z2) {
            if (!z) {
                cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.subpb_list_item_foot_bg_1 : com.baidu.tieba.a.g.subpb_list_item_foot_bg);
            } else if (z2) {
                cVar.a.setBackgroundResource(z3 ? com.baidu.tieba.a.g.subpb_list_item_middle_bg_1 : com.baidu.tieba.a.g.subpb_list_item_middle_bg);
            }
            cVar.a.setPadding(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(this.m ? com.baidu.tieba.a.f.default_gap_10 : com.baidu.tieba.a.f.default_size_22), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_8), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_gap_10));
        } else {
            super.a(aiVar, cVar, z, z2);
        }
    }
}
