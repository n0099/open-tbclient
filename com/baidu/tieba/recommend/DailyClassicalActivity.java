package com.baidu.tieba.recommend;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends com.baidu.tbadk.a implements com.baidu.tbadk.coreExtra.view.f {
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
    private c i = null;
    private boolean j = false;
    private boolean k = true;
    private TextView l = null;
    private TextView m = null;
    private boolean n = false;
    private String q = "1";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010021, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return TbadkApplication.j().ax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.day_classical_activity);
        this.b = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.c = (RelativeLayout) findViewById(com.baidu.tieba.a.h.title);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.title_text);
        this.h = (LinearLayout) findViewById(com.baidu.tieba.a.h.tag_webview_item);
        this.a = (ImageView) findViewById(com.baidu.tieba.a.h.back);
        this.l = (TextView) this.h.findViewById(com.baidu.tieba.a.h.webview_fail);
        this.m = (TextView) this.h.findViewById(com.baidu.tieba.a.h.webview_crash_tip);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.a.h.tag_progress);
        this.e = new b(this);
        this.a.setOnClickListener(this.e);
        if (!d()) {
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.b, i);
        ba.d(this.c, i);
        ba.d(this.d, i);
        ba.a(this.a, i);
        if (this.f != null) {
            ba.a(this.f, i);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void a() {
        if (com.baidu.tieba.r.c().v() == 0 && !d()) {
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
            this.i = new c(this, (byte) 0);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(DailyClassicalActivity dailyClassicalActivity) {
        if (dailyClassicalActivity.j) {
            if (!dailyClassicalActivity.k) {
                dailyClassicalActivity.showToast(dailyClassicalActivity.getResources().getString(com.baidu.tieba.a.k.neterror));
            }
            dailyClassicalActivity.n = false;
            dailyClassicalActivity.g.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public final boolean a(String str) {
        String str2;
        if (!com.baidu.tbadk.d.d.a(this, str)) {
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
                    this.q = "1";
                }
                a();
            } else {
                com.baidu.tbadk.browser.a.b(this, String.valueOf(str) + "&_client_version=" + com.baidu.tbadk.core.data.n.c());
            }
        }
        return true;
    }

    private boolean d() {
        boolean z = false;
        if (this.f == null) {
            try {
                if (UtilHelper.h(this)) {
                    super.showToast(getString(com.baidu.tieba.a.k.web_view_corrupted));
                } else {
                    this.f = new BaseWebView(this);
                    ba.a(this.f, TbadkApplication.j().l());
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }
}
