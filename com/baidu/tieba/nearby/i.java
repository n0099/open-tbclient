package com.baidu.tieba.nearby;

import android.location.Location;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.x {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // com.baidu.tieba.x
    public void a(int i, String str, Location location) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        if (i != 0 || location == null) {
            progressBar = this.a.G;
            progressBar.setVisibility(8);
            if (str == null || str.length() <= 0) {
                str = this.a.getString(R.string.lbs_error);
            }
            textView = this.a.g;
            textView.setVisibility(0);
            textView2 = this.a.g;
            textView2.setText(str);
            this.a.u();
            this.a.r();
            return;
        }
        this.a.a(location);
    }
}
