package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        df dfVar;
        AlertDialog d;
        DialogInterface.OnClickListener onClickListener;
        dfVar = this.a.g;
        com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) dfVar.getItem(i - 1);
        if (amVar != null) {
            this.a.z = amVar;
            d = this.a.d();
            if (d == null) {
                SubPbActivity subPbActivity = this.a;
                String[] strArr = {this.a.getString(R.string.copy)};
                onClickListener = this.a.y;
                subPbActivity.b(strArr, onClickListener);
            }
            this.a.e();
        }
        return true;
    }
}
