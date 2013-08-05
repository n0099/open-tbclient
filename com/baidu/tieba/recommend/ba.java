package com.baidu.tieba.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ba extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendActivity f1656a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(RecommendActivity recommendActivity, android.support.v4.app.t tVar) {
        super(tVar);
        this.f1656a = recommendActivity;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        as asVar;
        as asVar2;
        switch (i) {
            case 0:
                asVar2 = this.f1656a.f1629a;
                return asVar2.b();
            case 1:
                asVar = this.f1656a.f1629a;
                return asVar.a();
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.ae
    public CharSequence getPageTitle(int i) {
        switch (i) {
            case 0:
                return this.f1656a.getString(R.string.feature);
            case 1:
                return this.f1656a.getString(R.string.explore);
            default:
                return null;
        }
    }
}
