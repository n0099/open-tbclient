package com.baidu.tieba.recommend;

import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.view.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2414a = hVar;
    }

    @Override // com.baidu.tieba.view.g
    public void a() {
        if (h.a(this.f2414a) != null && h.a(this.f2414a).f2403a.size() > h.b(this.f2414a).getCurrentItem()) {
            String str = (String) h.a(this.f2414a).f2403a.get(h.b(this.f2414a).getCurrentItem()).getTag();
            if (!TextUtils.isEmpty(str)) {
                UtilHelper.a(h.c(this.f2414a), str, null, null);
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(h.c(this.f2414a), "recommend_banner", "click");
                }
            }
        }
    }
}
