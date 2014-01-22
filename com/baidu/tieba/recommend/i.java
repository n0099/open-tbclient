package com.baidu.tieba.recommend;

import android.text.TextUtils;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.view.p {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tieba.view.p
    public void a() {
        if (h.a(this.a) != null && h.a(this.a).a.size() > h.b(this.a).getCurrentItem()) {
            String str = (String) h.a(this.a).a.get(h.b(this.a).getCurrentItem()).getTag();
            if (!TextUtils.isEmpty(str)) {
                UtilHelper.a(h.c(this.a), str, null, null);
                by.a(h.c(this.a), "recommend_banner", "click");
            }
        }
    }
}
