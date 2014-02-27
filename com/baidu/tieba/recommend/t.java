package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class t extends PagerAdapter implements bg {
    ArrayList<View> a = new ArrayList<>();
    public int b;
    public int c;
    Activity d;
    Resources e;
    ArrayList<com.baidu.tieba.data.o> f;
    private com.baidu.tieba.util.i g;

    public t(Activity activity, ArrayList<com.baidu.tieba.data.o> arrayList) {
        this.d = activity;
        this.e = activity.getResources();
        this.b = (int) (BdUtilHelper.b(activity) - (2.0f * this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS)));
        this.c = (int) ((this.b * this.e.getDimension(R.dimen.daily_recommend_banner_height)) / this.e.getDimension(R.dimen.daily_recommend_banner_width));
        this.g = new com.baidu.tieba.util.i(activity);
        this.g.a(this.b, this.c);
        this.e = activity.getResources();
        a(arrayList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.a.get(i));
    }

    private void a(ArrayList<com.baidu.tieba.data.o> arrayList) {
        this.f = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.a.add(a(arrayList.get(arrayList.size() - 1)));
            for (int i = 0; i < arrayList.size(); i++) {
                this.a.add(a(arrayList.get(i)));
            }
            this.a.add(a(arrayList.get(0)));
            notifyDataSetChanged();
        }
    }

    private View a(com.baidu.tieba.data.o oVar) {
        LinearLayout linearLayout = new LinearLayout(this.d);
        TbImageView tbImageView = new TbImageView(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, this.c);
        layoutParams.setMargins((int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS));
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setTag(oVar.a());
        this.g.b(oVar.a(), new u(this, tbImageView));
        linearLayout.setTag(oVar.b());
        return linearLayout;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.a.get(i));
        return this.a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // com.baidu.tieba.view.bg
    public final void d() {
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.view.bg
    public final void a(View view, int i, int i2) {
        if (this.g != null && this.f != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f.size()) {
                    this.g.b(this.f.get(i4).a(), new v(this, view));
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
