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
        if (this.f2414a.g != null && this.f2414a.g.f2403a.size() > this.f2414a.f.getCurrentItem()) {
            String str = (String) this.f2414a.g.f2403a.get(this.f2414a.f.getCurrentItem()).getTag();
            if (!TextUtils.isEmpty(str)) {
                UtilHelper.a(this.f2414a.i, str, null, null);
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f2414a.i, "recommend_banner", "click");
                }
            }
        }
    }
}
