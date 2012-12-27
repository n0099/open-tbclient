package com.baidu.tieba.nearby;

import android.location.Location;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.u {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // com.baidu.tieba.u
    public void a(int i, String str, Location location) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        if (i == 0 && location != null) {
            this.a.a(location);
            return;
        }
        progressBar = this.a.F;
        progressBar.setVisibility(8);
        if (str == null || str.length() <= 0) {
            str = this.a.getString(R.string.lbs_error);
        }
        textView = this.a.f;
        textView.setVisibility(0);
        textView2 = this.a.f;
        textView2.setText(str);
        this.a.s();
        this.a.p();
    }
}
