package com.baidu.tieba.recommend;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.g {
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
    private String q = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.DAILY_CLASSICLA_CUSTOM_CMD, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.day_classical_activity);
        d();
    }

    private void d() {
        this.b = (RelativeLayout) findViewById(v.parent);
        this.c = (RelativeLayout) findViewById(v.title);
        this.d = (TextView) findViewById(v.title_text);
        this.h = (LinearLayout) findViewById(v.tag_webview_item);
        this.a = (ImageView) findViewById(v.back);
        this.l = (TextView) this.h.findViewById(v.webview_fail);
        this.m = (TextView) this.h.findViewById(v.webview_crash_tip);
        this.g = (ProgressBar) findViewById(v.tag_progress);
        this.e = new b(this);
        this.a.setOnClickListener(this.e);
        if (f()) {
            this.m.setVisibility(8);
            a();
            return;
        }
        this.m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.a(this.b, i);
        bc.d(this.c, i);
        bc.d(this.d, i);
        bc.a(this.a, i);
        if (this.f != null) {
            bc.a(this.f, i);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void a() {
        if (TbadkApplication.m252getInst().getWebviewCrashCount() == 0 && !f()) {
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        if (!this.n) {
            this.n = true;
            this.g.setVisibility(0);
            this.j = false;
            this.k = true;
            g();
            this.i = new c(this, null);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j) {
            if (!this.k) {
                showToast(getResources().getString(y.neterror));
            }
            this.n = false;
            this.g.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.g
    public boolean a(WebView webView, String str) {
        if (!com.baidu.tbadk.c.f.a(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String a = a(str, "pn=");
                    if (a != null && a.length() >= 0) {
                        this.q = a;
                    }
                } else {
                    this.q = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
                }
                a();
            } else {
                com.baidu.tbadk.browser.a.b(this, String.valueOf(str) + "&_client_version=" + TbConfig.getVersion());
            }
        }
        return true;
    }

    private String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }

    private boolean f() {
        boolean z = false;
        if (this.f == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(y.web_view_corrupted));
                } else {
                    this.f = new BaseWebView(this);
                    bc.a(this.f, TbadkApplication.m252getInst().getSkinType());
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
                BdLog.e(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void g() {
        if (this.i != null) {
            this.i.cancel();
        }
    }
}
