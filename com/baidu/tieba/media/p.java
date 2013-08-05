package com.baidu.tieba.media;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tieba.util.NetWorkCore;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1283a;

    private p(MediaPlayerActivity mediaPlayerActivity) {
        this.f1283a = mediaPlayerActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(MediaPlayerActivity mediaPlayerActivity, p pVar) {
        this(mediaPlayerActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList arrayList;
        AlertDialog alertDialog;
        a aVar;
        DialogInterface.OnClickListener l;
        DialogInterface.OnClickListener m;
        a aVar2;
        DialogInterface.OnClickListener l2;
        DialogInterface.OnClickListener m2;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        NetWorkCore.NetworkStateInfo c = NetWorkCore.c(context);
        arrayList = this.f1283a.m;
        if (!arrayList.contains(c)) {
            alertDialog = this.f1283a.e;
            if (alertDialog != null) {
                alertDialog2 = this.f1283a.e;
                if (alertDialog2.isShowing()) {
                    alertDialog3 = this.f1283a.e;
                    alertDialog3.dismiss();
                }
                this.f1283a.e = null;
            }
            if (c == NetWorkCore.NetworkStateInfo.TwoG) {
                this.f1283a.a();
                MediaPlayerActivity mediaPlayerActivity = this.f1283a;
                aVar2 = this.f1283a.f1266a;
                l2 = this.f1283a.l();
                m2 = this.f1283a.m();
                mediaPlayerActivity.e = aVar2.a(l2, m2);
            } else if (c == NetWorkCore.NetworkStateInfo.ThreeG) {
                this.f1283a.a();
                MediaPlayerActivity mediaPlayerActivity2 = this.f1283a;
                aVar = this.f1283a.f1266a;
                l = this.f1283a.l();
                m = this.f1283a.m();
                mediaPlayerActivity2.e = aVar.b(l, m);
            }
        }
    }
}
