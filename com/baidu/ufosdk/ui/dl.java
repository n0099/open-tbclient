package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ufosdk.UfoSDK;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class dl implements View.OnClickListener {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        View view2;
        ExecutorService executorService;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        if (!com.baidu.ufosdk.b.d.c(this.a)) {
            com.baidu.ufosdk.f.c.c("Network is not avaiable. Please try again later.");
            return;
        }
        try {
            linearLayout = this.a.b;
            linearLayout.setVisibility(8);
            view2 = this.a.v;
            view2.setVisibility(0);
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new dm(this)).start();
            } else {
                this.a.y = Executors.newSingleThreadExecutor();
                executorService = this.a.y;
                executorService.execute(new dn(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
