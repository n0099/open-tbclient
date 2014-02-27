package com.baidu.tieba.mainentrance;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new AlertDialog.Builder(this.a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new o(this)).setNegativeButton("取消", new p(this)).create().show();
    }
}
