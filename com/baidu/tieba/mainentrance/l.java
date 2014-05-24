package com.baidu.tieba.mainentrance;

import android.app.AlertDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.a).setTitle("提醒").setIcon(com.baidu.tieba.u.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new m(this)).setNegativeButton("取消", new n(this)).create().show();
    }
}
