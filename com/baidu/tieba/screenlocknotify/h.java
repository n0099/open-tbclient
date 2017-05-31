package com.baidu.tieba.screenlocknotify;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
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
        textView = this.this$0.flR;
        textView.setText(this.this$0.getResources().getString(w.l.loading));
        textView2 = this.this$0.flR;
        textView2.setEnabled(false);
        this.this$0.MC();
    }
}
