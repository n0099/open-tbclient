package com.baidu.tieba.screenlocknotify;

import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AbsListView.OnScrollListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        TextView textView;
        TextView textView2;
        int i4;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        textView = this.this$0.eQt;
        if (textView != null) {
            textView2 = this.this$0.eQt;
            if (textView2.getParent() != null) {
                int height = this.this$0.eQp.getHeight();
                i4 = this.this$0.eQs;
                if (height != i4) {
                    textView3 = this.this$0.eQt;
                    textView3.setText(this.this$0.getResources().getString(r.j.screen_notify_load_more));
                    textView4 = this.this$0.eQt;
                    textView4.setEnabled(true);
                } else if (i + i2 == i3) {
                    textView5 = this.this$0.eQt;
                    if (textView5.isEnabled()) {
                        textView6 = this.this$0.eQt;
                        textView6.setText(this.this$0.getResources().getString(r.j.loading));
                        textView7 = this.this$0.eQt;
                        textView7.setEnabled(false);
                    }
                    this.this$0.IV();
                }
            }
        }
    }
}
