package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.ai;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DailyRecommendBannerPagerAdapter extends ae implements ai {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<View> f2403a = new ArrayList<>();
    public int b;
    public int c;
    Activity d;
    Resources e;
    ArrayList<com.baidu.tieba.data.n> f;
    private com.baidu.tieba.util.i g;

    public DailyRecommendBannerPagerAdapter(Activity activity, ArrayList<com.baidu.tieba.data.n> arrayList) {
        this.d = activity;
        this.e = activity.getResources();
        this.b = (int) (com.baidu.adp.lib.h.g.b(activity) - (2.0f * this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS)));
        this.c = (int) ((this.b * this.e.getDimension(R.dimen.daily_recommend_banner_height)) / this.e.getDimension(R.dimen.daily_recommend_banner_width));
        this.g = new com.baidu.tieba.util.i(activity);
        this.g.a(this.b, this.c);
        this.e = activity.getResources();
        a(arrayList);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f2403a.get(i));
    }

    private void a(ArrayList<com.baidu.tieba.data.n> arrayList) {
        this.f = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.f2403a.add(a(arrayList.get(arrayList.size() - 1)));
            for (int i = 0; i < arrayList.size(); i++) {
                this.f2403a.add(a(arrayList.get(i)));
            }
            this.f2403a.add(a(arrayList.get(0)));
            notifyDataSetChanged();
        }
    }

    private View a(com.baidu.tieba.data.n nVar) {
        LinearLayout linearLayout = new LinearLayout(this.d);
        TbImageView tbImageView = new TbImageView(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, this.c);
        layoutParams.setMargins((int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_X_DIS), (int) this.e.getDimension(R.dimen.daily_recommend_banner_Y_DIS));
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setTag(nVar.a());
        this.g.a(nVar.a(), new t(this, tbImageView));
        linearLayout.setTag(nVar.b());
        return linearLayout;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f2403a.get(i));
        return this.f2403a.get(i);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f2403a.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // com.baidu.tieba.view.ai
    public void d() {
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.baidu.tieba.view.ai
    public void a(View view, int i, int i2) {
        if (this.g != null && this.f != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f.size()) {
                    this.g.a(this.f.get(i4).a(), new u(this, view));
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
