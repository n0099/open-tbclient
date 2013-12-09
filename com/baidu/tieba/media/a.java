package com.baidu.tieba.media;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.slidingmenu.lib.R;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f1929a;
    private b b = null;

    public a(Context context) {
        this.f1929a = null;
        if (context == null) {
            throw new InvalidParameterException("MediaPlayerDialog context is null");
        }
        this.f1929a = context;
    }

    public AlertDialog a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return a(onClickListener, onClickListener2, 2);
    }

    public AlertDialog b(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return a(onClickListener, onClickListener2, 3);
    }

    private AlertDialog a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i) {
        return a(this.f1929a.getString(R.string.media_play), onClickListener, this.f1929a.getString(R.string.cancel), onClickListener2, this.f1929a.getString(R.string.info_flow), String.format(this.f1929a.getString(R.string.media_play_info), Integer.valueOf(i)));
    }

    private AlertDialog a(String str, DialogInterface.OnClickListener onClickListener, String str2, DialogInterface.OnClickListener onClickListener2, String str3, String str4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1929a);
        builder.setPositiveButton(str, onClickListener);
        if (str2 != null) {
            builder.setNegativeButton(str2, onClickListener2);
        }
        builder.setTitle(str3);
        builder.setIcon((Drawable) null);
        builder.setMessage(str4);
        AlertDialog create = builder.create();
        create.setCancelable(true);
        create.setCanceledOnTouchOutside(true);
        create.show();
        return create;
    }
}
