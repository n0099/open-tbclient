package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class v extends PagerAdapter implements com.baidu.tieba.view.s {
    ArrayList<View> a = new ArrayList<>();
    public int b;
    public int c;
    Activity d;
    Resources e;
    ArrayList<com.baidu.tieba.data.j> f;
    private com.baidu.tbadk.editortool.aa g;

    public v(Activity activity, ArrayList<com.baidu.tieba.data.j> arrayList) {
        this.d = activity;
        this.e = activity.getResources();
        this.b = (int) (com.baidu.adp.lib.util.i.b(activity) - (2.0f * this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_X_DIS)));
        this.c = (int) ((this.b * this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_height)) / this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_width));
        this.g = new com.baidu.tbadk.editortool.aa(activity);
        this.g.a(this.b, this.c);
        this.e = activity.getResources();
        a(arrayList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.a.get(i));
    }

    private void a(ArrayList<com.baidu.tieba.data.j> arrayList) {
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

    private View a(com.baidu.tieba.data.j jVar) {
        LinearLayout linearLayout = new LinearLayout(this.d);
        TbImageView tbImageView = new TbImageView(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.b, this.c);
        layoutParams.setMargins((int) this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_X_DIS), (int) this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_Y_DIS), (int) this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_X_DIS), (int) this.e.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_Y_DIS));
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setTag(jVar.a());
        this.g.b(jVar.a(), new w(this, tbImageView));
        linearLayout.setTag(jVar.b());
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

    @Override // com.baidu.tieba.view.s
    public final void d() {
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.view.s
    public final void a(View view, int i, int i2) {
        if (this.g != null && this.f != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.f.size()) {
                    this.g.b(this.f.get(i4).a(), new x(this, view));
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
