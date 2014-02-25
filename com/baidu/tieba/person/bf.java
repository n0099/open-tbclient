package com.baidu.tieba.person;

import android.view.View;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.im.groupInfo.EllipsizingTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.a.f;
        ellipsizingTextView.setMaxLines(LocationClientOption.MIN_SCAN_SPAN);
    }
}
