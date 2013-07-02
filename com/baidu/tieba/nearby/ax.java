package com.baidu.tieba.nearby;

import android.location.Address;
import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.at {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // com.baidu.tieba.at
    public void a(int i, String str, Address address) {
        ProgressBar progressBar;
        ViewPager viewPager;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ViewPager viewPager2;
        progressBar = this.a.r;
        progressBar.setVisibility(8);
        if (i != 0 || address == null) {
            viewPager = this.a.k;
            if (viewPager.getChildCount() == 0) {
                if (str == null || str.length() <= 0) {
                    str = this.a.getString(R.string.lbs_error);
                }
                textView = this.a.s;
                textView.setText(str + "\n" + this.a.getString(R.string.retry_location));
                textView2 = this.a.s;
                textView2.setVisibility(0);
                return;
            }
            this.a.a(this.a.getString(R.string.lbs_error));
            return;
        }
        this.a.q = address;
        textView3 = this.a.s;
        textView3.setVisibility(8);
        viewPager2 = this.a.k;
        if (viewPager2.getChildCount() == 0) {
            this.a.o();
        } else {
            this.a.s();
        }
    }
}
