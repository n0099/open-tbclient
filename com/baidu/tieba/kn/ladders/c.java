package com.baidu.tieba.kn.ladders;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.CommonWebviewActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f1248a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.f1248a.k;
        activity2 = this.f1248a.k;
        CommonWebviewActivity.a(activity, activity2.getString(R.string.kn_description), String.valueOf(com.baidu.tieba.data.g.b) + "mo/q/webviewintroduce?jump_tieba_native=1", true, "get");
    }
}
