package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ufosdk.UfoSDK;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class dl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f5533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(FeedbackListActivity feedbackListActivity) {
        this.f5533a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        View view2;
        ExecutorService executorService;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        if (!com.baidu.ufosdk.b.d.c(this.f5533a)) {
            com.baidu.ufosdk.f.c.c("Network is not avaiable. Please try again later.");
            return;
        }
        try {
            linearLayout = this.f5533a.f5419b;
            linearLayout.setVisibility(8);
            view2 = this.f5533a.v;
            view2.setVisibility(0);
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new dm(this)).start();
            } else {
                this.f5533a.y = Executors.newSingleThreadExecutor();
                executorService = this.f5533a.y;
                executorService.execute(new dn(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
