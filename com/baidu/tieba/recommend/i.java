package com.baidu.tieba.recommend;

import android.text.TextUtils;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.view.l {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tieba.view.l
    public void a() {
        if (this.a.g != null && this.a.g.a.size() > this.a.f.getCurrentItem()) {
            String str = (String) this.a.g.a.get(this.a.f.getCurrentItem()).getTag();
            if (!TextUtils.isEmpty(str)) {
                UtilHelper.a(this.a.i, str, null, null);
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.a.i, "recommend_banner", "click");
                }
            }
        }
    }
}
