package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.b.r rVar;
        AlertDialog d;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.a.am amVar = null;
        rVar = this.a.f;
        if (rVar != null) {
            rVar2 = this.a.f;
            amVar = rVar2.a().a();
            if (amVar == null) {
                return false;
            }
        }
        this.a.z = amVar;
        d = this.a.d();
        if (d == null) {
            SubPbActivity subPbActivity = this.a;
            String[] strArr = {this.a.getString(R.string.copy)};
            onClickListener = this.a.y;
            subPbActivity.b(strArr, onClickListener);
        }
        this.a.e();
        return true;
    }
}
