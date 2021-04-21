package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ufosdk.UfoSDK;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public final class dl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22873a;

    public dl(FeedbackListActivity feedbackListActivity) {
        this.f22873a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        View view2;
        ExecutorService executorService;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        if (!com.baidu.ufosdk.b.d.c(this.f22873a)) {
            com.baidu.ufosdk.f.c.c("Network is not avaiable. Please try again later.");
            return;
        }
        try {
            linearLayout = this.f22873a.f22717b;
            linearLayout.setVisibility(8);
            view2 = this.f22873a.v;
            view2.setVisibility(0);
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new dm(this)).start();
                return;
            }
            this.f22873a.y = Executors.newSingleThreadExecutor();
            executorService = this.f22873a.y;
            executorService.execute(new dn(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
