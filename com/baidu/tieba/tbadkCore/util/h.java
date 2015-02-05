package com.baidu.tieba.tbadkCore.util;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("anti_vcode_no_longer_tip", true);
        dialogInterface.dismiss();
    }
}
