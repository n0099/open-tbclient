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
public class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaPlayerActivity f1348a;

    private p(MediaPlayerActivity mediaPlayerActivity) {
        this.f1348a = mediaPlayerActivity;
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
        UtilHelper.NetworkStateInfo i = UtilHelper.i(context);
        arrayList = this.f1348a.m;
        if (!arrayList.contains(i)) {
            alertDialog = this.f1348a.e;
            if (alertDialog != null) {
                alertDialog2 = this.f1348a.e;
                if (alertDialog2.isShowing()) {
                    alertDialog3 = this.f1348a.e;
                    alertDialog3.dismiss();
                }
                this.f1348a.e = null;
            }
            if (i == UtilHelper.NetworkStateInfo.TwoG) {
                this.f1348a.a();
                MediaPlayerActivity mediaPlayerActivity = this.f1348a;
                aVar2 = this.f1348a.f1331a;
                l2 = this.f1348a.l();
                m2 = this.f1348a.m();
                mediaPlayerActivity.e = aVar2.a(l2, m2);
            } else if (i == UtilHelper.NetworkStateInfo.ThreeG) {
                this.f1348a.a();
                MediaPlayerActivity mediaPlayerActivity2 = this.f1348a;
                aVar = this.f1348a.f1331a;
                l = this.f1348a.l();
                m = this.f1348a.m();
                mediaPlayerActivity2.e = aVar.b(l, m);
            }
        }
    }
}
