package com.baidu.tieba.person;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.nearby.NearbyPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.a = boVar;
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
