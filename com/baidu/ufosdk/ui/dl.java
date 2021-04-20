package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ufosdk.UfoSDK;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public final class dl implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22865a;

    public dl(FeedbackListActivity feedbackListActivity) {
        this.f22865a = feedbackListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        View view2;
        ExecutorService executorService;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        if (!com.baidu.ufosdk.b.d.c(this.f22865a)) {
            com.baidu.ufosdk.f.c.c("Network is not avaiable. Please try again later.");
            return;
        }
        try {
            linearLayout = this.f22865a.f22709b;
            linearLayout.setVisibility(8);
            view2 = this.f22865a.v;
            view2.setVisibility(0);
            if (UfoSDK.clientid.length() == 0) {
                new Thread(new dm(this)).start();
                return;
            }
            this.f22865a.y = Executors.newSingleThreadExecutor();
            executorService = this.f22865a.y;
            executorService.execute(new dn(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
