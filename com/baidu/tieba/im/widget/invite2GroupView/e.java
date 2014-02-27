package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.f;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.a.getContext() instanceof Activity) {
            ((f) this.a.a.getContext()).showToast(R.string.has_recent_join);
        }
    }
}
