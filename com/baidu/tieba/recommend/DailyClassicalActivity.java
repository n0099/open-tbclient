package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends com.baidu.tieba.f implements com.baidu.tieba.view.e {
    private static boolean o = false;
    private static long p = 0;
    private ImageView a = null;
    private RelativeLayout b = null;
    private RelativeLayout c = null;
    private TextView d = null;
    private View.OnClickListener e = null;
    private BaseWebView f = null;
    private ProgressBar g = null;
    private LinearLayout h = null;
    private b i = null;
    private boolean j = false;
    private boolean k = true;
    private TextView l = null;
    private TextView m = null;
    private boolean n = false;
    private String q = SocialConstants.TRUE;

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return TiebaApplication.g().p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        this.b = (RelativeLayout) findViewById(R.id.parent);
        this.c = (RelativeLayout) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.title_text);
        this.h = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.a = (ImageView) findViewById(R.id.back);
        this.l = (TextView) this.h.findViewById(R.id.webview_fail);
        this.m = (TextView) this.h.findViewById(R.id.webview_crash_tip);
        this.g = (ProgressBar) findViewById(R.id.tag_progress);
        this.e = new a(this);
        this.a.setOnClickListener(this.e);
        if (!d()) {
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        a();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, DailyClassicalActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bq.a(this.b, i);
        bq.d(this.c, i);
        bq.e(this.d, i);
        bq.a(this.a, i);
        if (this.f != null) {
            bq.a(this.f, i);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void a() {
        if (TiebaApplication.g().af() == 0 && !d()) {
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        if (!this.n) {
            this.n = true;
            this.g.setVisibility(0);
            this.j = false;
            this.k = true;
            if (this.i != null) {
                this.i.cancel();
            }
            this.i = new b(this, (byte) 0);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(DailyClassicalActivity dailyClassicalActivity) {
        if (dailyClassicalActivity.j) {
            if (!dailyClassicalActivity.k) {
                dailyClassicalActivity.showToast(dailyClassicalActivity.getResources().getString(R.string.neterror));
            }
            dailyClassicalActivity.n = false;
            dailyClassicalActivity.g.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.e
    public final boolean a(String str) {
        String str2;
        if (!WebviewHelper.commonJumpHelper(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    int indexOf = str.indexOf("pn=");
                    if (indexOf != -1) {
                        int length = indexOf + "pn=".length();
                        int i = length;
                        while (i < str.length() && str.charAt(i) != '&') {
                            i++;
                        }
                        str2 = URLDecoder.decode(str.substring(length, i));
                    } else {
                        str2 = "";
                    }
                    if (str2 != null && str2.length() >= 0) {
                        this.q = str2;
                    }
                } else {
                    this.q = SocialConstants.TRUE;
                }
                a();
            } else {
                UtilHelper.d(this, String.valueOf(str) + "&_client_version=" + com.baidu.tieba.data.i.u());
            }
        }
        return true;
    }

    private boolean d() {
        boolean z = false;
        if (this.f == null) {
            try {
                if (UtilHelper.e(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.f = new BaseWebView(this);
                    bq.a(this.f, TiebaApplication.g().ae());
                    this.f.setOnLoadUrlListener(this);
                    this.f.setHorizontalScrollBarEnabled(false);
                    this.f.setHorizontalScrollbarOverlay(false);
                    this.f.setScrollBarStyle(33554432);
                    this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.h.addView(this.f);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }
}
