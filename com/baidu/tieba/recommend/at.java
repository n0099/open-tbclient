package com.baidu.tieba.recommend;

import com.baidu.tieba.BaseFragment;
/* loaded from: classes.dex */
public class at implements as {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f1646a;
    private BaseFragment b;

    @Override // com.baidu.tieba.recommend.as
    public BaseFragment a() {
        if (this.f1646a == null) {
            this.f1646a = new FindInterestFragment();
        }
        return this.f1646a;
    }

    @Override // com.baidu.tieba.recommend.as
    public BaseFragment b() {
        if (this.b == null) {
            this.b = new DailyRecommendFragment();
        }
        return this.b;
    }

    @Override // com.baidu.tieba.recommend.as
    public BaseFragment c() {
        return this.b;
    }

    @Override // com.baidu.tieba.recommend.as
    public BaseFragment d() {
        return this.f1646a;
    }
}
