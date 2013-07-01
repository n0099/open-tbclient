package com.baidu.tieba.nearby;

import android.location.Address;
import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewNearbyActivity newNearbyActivity) {
        this.f1146a = newNearbyActivity;
    }

    @Override // com.baidu.tieba.at
    public void a(int i, String str, Address address) {
        ProgressBar progressBar;
        ViewPager viewPager;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ViewPager viewPager2;
        progressBar = this.f1146a.r;
        progressBar.setVisibility(8);
        if (i != 0 || address == null) {
            viewPager = this.f1146a.k;
            if (viewPager.getChildCount() == 0) {
                if (str == null || str.length() <= 0) {
                    str = this.f1146a.getString(R.string.lbs_error);
                }
                textView = this.f1146a.s;
                textView.setText(str + "\n" + this.f1146a.getString(R.string.retry_location));
                textView2 = this.f1146a.s;
                textView2.setVisibility(0);
                return;
            }
            this.f1146a.a(this.f1146a.getString(R.string.lbs_error));
            return;
        }
        this.f1146a.q = address;
        textView3 = this.f1146a.s;
        textView3.setVisibility(8);
        viewPager2 = this.f1146a.k;
        if (viewPager2.getChildCount() == 0) {
            this.f1146a.o();
        } else {
            this.f1146a.s();
        }
    }
}
