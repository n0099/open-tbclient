package com.baidu.tieba.media;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f1333a;
    private d b = null;

    public a(Context context) {
        this.f1333a = null;
        if (context == null) {
            throw new InvalidParameterException("MediaPlayerDialog context is null");
        }
        this.f1333a = context;
    }

    public AlertDialog a(DialogInterface.OnClickListener onClickListener) {
        return a(onClickListener, null, 2);
    }

    public AlertDialog a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return a(onClickListener, onClickListener2, 2);
    }

    public AlertDialog b(DialogInterface.OnClickListener onClickListener) {
        return a(onClickListener, null, 3);
    }

    public AlertDialog b(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return a(onClickListener, onClickListener2, 3);
    }

    private AlertDialog a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i) {
        return a(this.f1333a.getString(R.string.media_play), onClickListener, this.f1333a.getString(R.string.cancel), onClickListener2, this.f1333a.getString(R.string.info_flow), String.format(this.f1333a.getString(R.string.media_play_info), Integer.valueOf(i)));
    }

    public AlertDialog c(DialogInterface.OnClickListener onClickListener) {
        return a(onClickListener, 1);
    }

    public AlertDialog d(DialogInterface.OnClickListener onClickListener) {
        return a(onClickListener, 2);
    }

    public AlertDialog e(DialogInterface.OnClickListener onClickListener) {
        return a(onClickListener, 3);
    }

    private AlertDialog a(DialogInterface.OnClickListener onClickListener, int i) {
        String format;
        if (i == 1) {
            format = this.f1333a.getString(R.string.media_download_wifi_info);
        } else {
            format = String.format(this.f1333a.getString(R.string.media_download_info), Integer.valueOf(i));
        }
        return a(this.f1333a.getString(R.string.download_install), onClickListener, this.f1333a.getString(R.string.cancel), null, this.f1333a.getString(R.string.install_media), format);
    }

    private AlertDialog a(String str, DialogInterface.OnClickListener onClickListener, String str2, DialogInterface.OnClickListener onClickListener2, String str3, String str4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1333a);
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

    public void a() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.neterror));
    }

    public void b() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.not_support_media));
    }

    public void c() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.installing));
    }

    public void d() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.installed));
    }

    public void e() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.apk_error));
    }

    public void f() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.error_sd_error));
    }

    public void g() {
        UtilHelper.a((Context) TiebaApplication.g(), this.f1333a.getString(R.string.download_error));
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (this.b == null) {
            this.b = new d(this.f1333a, R.style.common_alert_dialog);
        }
        if (!this.b.isShowing()) {
            this.b.show();
            this.b.setTitle(this.f1333a.getString(R.string.baidu_media));
            this.b.a(this.f1333a.getString(R.string.downloading));
            this.b.b(0);
            this.b.a(0);
            this.b.a(this.f1333a.getString(R.string.pause), onClickListener);
            this.b.b(this.f1333a.getString(R.string.cancel), onClickListener2);
            this.b.setOnCancelListener(new b(this));
            this.b.setOnDismissListener(new c(this));
        }
    }

    public void a(int i, int i2) {
        if (this.b != null && this.b.isShowing()) {
            this.b.b(i);
            this.b.a(i2);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.b != null && this.b.isShowing()) {
            this.b.a(this.f1333a.getString(R.string.download), onClickListener);
            this.b.a(this.f1333a.getString(R.string.pause));
        }
    }

    public void b(View.OnClickListener onClickListener) {
        if (this.b != null && this.b.isShowing()) {
            this.b.a(this.f1333a.getString(R.string.pause), onClickListener);
            this.b.a(this.f1333a.getString(R.string.downloading));
        }
    }

    public void h() {
        this.b.dismiss();
    }
}
