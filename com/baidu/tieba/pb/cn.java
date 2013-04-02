package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.b.w wVar;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.b.w wVar2;
        com.baidu.tieba.a.an anVar = null;
        wVar = this.a.g;
        if (wVar != null) {
            wVar2 = this.a.g;
            anVar = wVar2.a().a();
            if (anVar == null) {
                return false;
            }
        }
        this.a.w = anVar;
        e = this.a.e();
        if (e == null) {
            SubPbActivity subPbActivity = this.a;
            String[] strArr = {this.a.getString(R.string.copy)};
            onClickListener = this.a.v;
            subPbActivity.b(strArr, onClickListener);
        }
        this.a.f();
        return true;
    }
}
