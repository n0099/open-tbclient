package com.baidu.tieba.nearby;

import android.location.Address;
import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.y {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // com.baidu.tieba.y
    public void a(int i, String str, Address address) {
        ProgressBar progressBar;
        ViewPager viewPager;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ViewPager viewPager2;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (i != 0 || address == null) {
            viewPager = this.a.j;
            if (viewPager.getChildCount() == 0) {
                if (str == null || str.length() <= 0) {
                    str = this.a.getString(R.string.lbs_error);
                }
                textView = this.a.o;
                textView.setText(str + "\n" + this.a.getString(R.string.retry_location));
                textView2 = this.a.o;
                textView2.setVisibility(0);
                return;
            }
            this.a.b(this.a.getString(R.string.lbs_error));
            return;
        }
        this.a.m = address;
        textView3 = this.a.o;
        textView3.setVisibility(8);
        viewPager2 = this.a.j;
        if (viewPager2.getChildCount() == 0) {
            this.a.n();
        } else {
            this.a.r();
        }
    }
}
