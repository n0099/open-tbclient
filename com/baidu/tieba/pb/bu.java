package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(NewPbActivity newPbActivity, String str) {
        this.a = newPbActivity;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.a(this.b);
        BdUtilHelper.a(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
    }
}
