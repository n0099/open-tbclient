package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.f.c;
/* loaded from: classes.dex */
class dr implements c<View> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aev */
    public View dF() {
        return new TogetherHiLivingView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ao */
    public void l(View view) {
        ((TogetherHiLivingView) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ap */
    public View m(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aq */
    public View n(View view) {
        ((TogetherHiLivingView) view).reset();
        return view;
    }
}
