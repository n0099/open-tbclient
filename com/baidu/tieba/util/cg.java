package com.baidu.tieba.util;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class cg implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
