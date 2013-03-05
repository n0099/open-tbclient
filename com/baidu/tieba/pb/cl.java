package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.b.v vVar;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.b.v vVar2;
        com.baidu.tieba.a.al alVar = null;
        vVar = this.a.g;
        if (vVar != null) {
            vVar2 = this.a.g;
            alVar = vVar2.a().a();
            if (alVar == null) {
                return false;
            }
        }
        this.a.A = alVar;
        e = this.a.e();
        if (e == null) {
            SubPbActivity subPbActivity = this.a;
            String[] strArr = {this.a.getString(R.string.copy)};
            onClickListener = this.a.z;
            subPbActivity.b(strArr, onClickListener);
        }
        this.a.f();
        return true;
    }
}
