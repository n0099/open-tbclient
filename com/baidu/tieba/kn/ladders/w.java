package com.baidu.tieba.kn.ladders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
class w extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnTabActivity f1202a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(KnTabActivity knTabActivity, android.support.v4.app.t tVar) {
        super(tVar);
        this.f1202a = knTabActivity;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        KnPkHomeFragment knPkHomeFragment;
        KnPkHomeFragment knPkHomeFragment2;
        KnPkHomeFragment knPkHomeFragment3;
        KnLaddersFragment knLaddersFragment;
        KnLaddersFragment knLaddersFragment2;
        switch (i) {
            case 0:
                knLaddersFragment = this.f1202a.b;
                if (knLaddersFragment == null) {
                    this.f1202a.b = new KnLaddersFragment();
                }
                knLaddersFragment2 = this.f1202a.b;
                return knLaddersFragment2;
            case 1:
                knPkHomeFragment = this.f1202a.c;
                if (knPkHomeFragment == null) {
                    this.f1202a.c = new KnPkHomeFragment();
                    knPkHomeFragment3 = this.f1202a.c;
                    knPkHomeFragment3.a(true);
                }
                knPkHomeFragment2 = this.f1202a.c;
                return knPkHomeFragment2;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return 2;
    }
}
