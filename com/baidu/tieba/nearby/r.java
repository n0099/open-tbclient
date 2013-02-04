package com.baidu.tieba.nearby;

import android.location.Location;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.u {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // com.baidu.tieba.u
    public void a(int i, String str, Location location) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        ListView listView;
        TextView textView3;
        this.a.j = location;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        if (i == 0 && location != null) {
            textView3 = this.a.c;
            textView3.setVisibility(8);
            this.a.j();
            return;
        }
        if (str == null || str.length() <= 0) {
            str = this.a.getString(R.string.lbs_error);
        }
        textView = this.a.c;
        textView.setText(str + "\n" + this.a.getString(R.string.click_screen_to_refresh));
        textView2 = this.a.c;
        textView2.setVisibility(0);
        listView = this.a.b;
        listView.setVisibility(8);
    }
}
