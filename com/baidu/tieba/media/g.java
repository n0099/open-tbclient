package com.baidu.tieba.media;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1935a;

    private g(MediaPlayerActivity mediaPlayerActivity) {
        this.f1935a = mediaPlayerActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(MediaPlayerActivity mediaPlayerActivity, d dVar) {
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
        UtilHelper.NetworkStateInfo g = UtilHelper.g(context);
        arrayList = this.f1935a.m;
        if (!arrayList.contains(g)) {
            alertDialog = this.f1935a.e;
            if (alertDialog != null) {
                alertDialog2 = this.f1935a.e;
                if (alertDialog2.isShowing()) {
                    alertDialog3 = this.f1935a.e;
                    alertDialog3.dismiss();
                }
                this.f1935a.e = null;
            }
            if (g == UtilHelper.NetworkStateInfo.TwoG) {
                this.f1935a.a();
                MediaPlayerActivity mediaPlayerActivity = this.f1935a;
                aVar2 = this.f1935a.f1927a;
                l2 = this.f1935a.l();
                m2 = this.f1935a.m();
                mediaPlayerActivity.e = aVar2.a(l2, m2);
            } else if (g == UtilHelper.NetworkStateInfo.ThreeG) {
                this.f1935a.a();
                MediaPlayerActivity mediaPlayerActivity2 = this.f1935a;
                aVar = this.f1935a.f1927a;
                l = this.f1935a.l();
                m = this.f1935a.m();
                mediaPlayerActivity2.e = aVar.b(l, m);
            }
        }
    }
}
