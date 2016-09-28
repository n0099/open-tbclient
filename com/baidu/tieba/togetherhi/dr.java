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
    /* renamed from: ajX */
    public View ez() {
        return new TogetherHiLivingView(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: al */
    public void o(View view) {
        ((TogetherHiLivingView) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: am */
    public View p(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: an */
    public View q(View view) {
        ((TogetherHiLivingView) view).reset();
        return view;
    }
}
