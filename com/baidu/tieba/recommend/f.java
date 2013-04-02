package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.c.af;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ GuessActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GuessActivity guessActivity) {
        this.a = guessActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (af.d(str)) {
                FrsActivity.a(this.a, str, (String) null);
            }
        }
    }
}
