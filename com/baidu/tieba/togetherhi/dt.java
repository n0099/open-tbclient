package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.f.c;
/* loaded from: classes.dex */
class dt implements c<View> {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(Context context) {
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aev */
    public View dF() {
        return new ds(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ao */
    public void l(View view) {
        ((ds) view).reset();
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
        ((ds) view).reset();
        return view;
    }
}
