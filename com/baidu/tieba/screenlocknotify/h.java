package com.baidu.tieba.screenlocknotify;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        textView = this.this$0.fmy;
        textView.setText(this.this$0.getResources().getString(r.j.loading));
        textView2 = this.this$0.fmy;
        textView2.setEnabled(false);
        this.this$0.JA();
    }
}
