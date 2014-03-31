package com.baidu.tieba.im.widget.invite2GroupView;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.im.j;
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
            ((com.baidu.tbadk.a) this.a.a.getContext()).showToast(j.has_recent_join);
        }
    }
}
