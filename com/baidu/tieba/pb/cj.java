package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        dm dmVar;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        dmVar = this.a.h;
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) dmVar.getItem(i - 1);
        if (alVar != null) {
            this.a.A = alVar;
            e = this.a.e();
            if (e == null) {
                SubPbActivity subPbActivity = this.a;
                String[] strArr = {this.a.getString(R.string.copy)};
                onClickListener = this.a.z;
                subPbActivity.b(strArr, onClickListener);
            }
            this.a.f();
        }
        return true;
    }
}
