package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bo implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.jumpToBigImage();
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tbadk.core.util.az.b(this.a.getActivity());
        }
    }
}
