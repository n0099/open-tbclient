package com.baidu.tieba.im.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class b {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.delete).setMessage(R.string.group_activity_delete_tip).setPositiveButton(R.string.confirm, onClickListener).setNegativeButton(R.string.cancel, new c()).create();
        create.show();
        return create;
    }
}
