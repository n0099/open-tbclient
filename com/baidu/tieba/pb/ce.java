package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        dh dhVar;
        AlertDialog e;
        DialogInterface.OnClickListener onClickListener;
        dhVar = this.a.h;
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) dhVar.getItem(i - 1);
        if (anVar != null) {
            this.a.A = anVar;
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
