package com.baidu.tieba.util;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bj implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
