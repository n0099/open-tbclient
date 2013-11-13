package com.baidu.tieba.recommend;

import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.view.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2312a = hVar;
    }

    @Override // com.baidu.tieba.view.f
    public void a() {
        if (h.a(this.f2312a) != null && h.a(this.f2312a).f2300a.size() > h.b(this.f2312a).getCurrentItem()) {
            String str = (String) h.a(this.f2312a).f2300a.get(h.b(this.f2312a).getCurrentItem()).getTag();
            if (!TextUtils.isEmpty(str)) {
                UtilHelper.a(h.c(this.f2312a), str, null, null);
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(h.c(this.f2312a), "recommend_banner", "click");
                }
            }
        }
    }
}
