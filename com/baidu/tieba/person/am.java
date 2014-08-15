package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EllipsizingTextView ellipsizingTextView;
        ellipsizingTextView = this.a.f;
        ellipsizingTextView.setMaxLines(1000);
    }
}
