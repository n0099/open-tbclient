package com.baidu.tieba.kn.ladders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public BaseWebView f1230a;
    public TextView b;
    public TextView c;
    public ProgressBar d;
    public LinearLayout e;

    public u(View view) {
        this.e = (LinearLayout) view.findViewById(R.id.home_webview_item);
        this.f1230a = (BaseWebView) view.findViewById(R.id.web);
        this.c = (TextView) view.findViewById(R.id.webview_fail);
        this.b = (TextView) view.findViewById(R.id.webview_crash_tip);
        this.d = (ProgressBar) view.findViewById(R.id.progress);
    }
}
