package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.b.t tVar;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.b.t tVar2;
        com.baidu.tieba.a.an anVar = null;
        tVar = this.a.g;
        if (tVar != null) {
            tVar2 = this.a.g;
            anVar = tVar2.a().a();
            if (anVar == null) {
                return false;
            }
        }
        this.a.A = anVar;
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
