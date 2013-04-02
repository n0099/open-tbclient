package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Cdo cdo;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        cdo = this.a.h;
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) cdo.getItem(i - 1);
        if (anVar != null) {
            this.a.w = anVar;
            e = this.a.e();
            if (e == null) {
                SubPbActivity subPbActivity = this.a;
                String[] strArr = {this.a.getString(R.string.copy)};
                onClickListener = this.a.v;
                subPbActivity.b(strArr, onClickListener);
            }
            this.a.f();
        }
        return true;
    }
}
