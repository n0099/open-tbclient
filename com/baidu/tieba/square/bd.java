package com.baidu.tieba.square;

import android.app.AlertDialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SquareSearchActivity squareSearchActivity) {
        this.f2398a = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AlertDialog.Builder(this.f2398a).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new bf(this)).setNegativeButton("取消", new be(this)).create().show();
    }
}
