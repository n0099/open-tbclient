package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity.a(this.a, "goto_recommend");
        this.a.g();
    }
}
