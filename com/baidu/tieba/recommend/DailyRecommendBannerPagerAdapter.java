package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.view.ADImageViewDrawer;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DailyRecommendBannerPagerAdapter extends android.support.v4.view.ae implements com.baidu.tieba.view.z {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1623a = new ArrayList();
    public int b;
    public int c;
    Activity d;
    Resources e;
    ArrayList f;
    private com.baidu.tieba.util.a g;

    public DailyRecommendBannerPagerAdapter(Activity activity, ArrayList arrayList) {
        this.d = activity;
        this.e = activity.getResources();
        this.b = (int) (com.baidu.tieba.util.am.a((Context) activity) - (2.0f * this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS)));
        this.c = (int) ((this.b * this.e.getDimension(R.dimen.daily_recommend_banner_height)) / this.e.getDimension(R.dimen.daily_recommend_banner_width));
        this.g = new com.baidu.tieba.util.a(activity);
        this.g.a(this.b, this.c);
        this.e = activity.getResources();
        a(arrayList);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.f1623a.get(i));
    }

    private void a(ArrayList arrayList) {
        this.f = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.f1623a.add(a((com.baidu.tieba.data.m) arrayList.get(arrayList.size() - 1)));
            for (int i = 0; i < arrayList.size(); i++) {
                this.f1623a.add(a((com.baidu.tieba.data.m) arrayList.get(i)));
            }
            this.f1623a.add(a((com.baidu.tieba.data.m) arrayList.get(0)));
            notifyDataSetChanged();
        }
    }

    private View a(com.baidu.tieba.data.m mVar) {
        LinearLayout linearLayout = new LinearLayout(this.d);
        ADImageViewDrawer aDImageViewDrawer = new ADImageViewDrawer(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, this.c);
        layoutParams.setMargins((int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS));
        aDImageViewDrawer.setLayoutParams(layoutParams);
        linearLayout.addView(aDImageViewDrawer);
        aDImageViewDrawer.setTag(mVar.a());
        this.g.a(mVar.a(), new p(this, aDImageViewDrawer));
        linearLayout.setTag(mVar.b());
        return linearLayout;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.f1623a.get(i));
        return this.f1623a.get(i);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f1623a.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // com.baidu.tieba.view.z
    public void c() {
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        if (this.g != null && this.f != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f.size()) {
                    this.g.a(((com.baidu.tieba.data.m) this.f.get(i4)).a(), new q(this, view));
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
