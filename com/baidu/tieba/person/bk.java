package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.nearby.NearbyPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view != null && view.getTag() != null && (view.getTag() instanceof String)) {
            context = this.a.a;
            NearbyPbActivity.a(context, (String) view.getTag(), null);
        }
    }
}
