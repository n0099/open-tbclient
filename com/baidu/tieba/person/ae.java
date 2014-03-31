package com.baidu.tieba.person;

import android.view.View;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.a.f;
        ellipsizingTextView.setMaxLines(LocationClientOption.MIN_SCAN_SPAN);
    }
}
