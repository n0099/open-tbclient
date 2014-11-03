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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.f {
    private static boolean bId = false;
    private static long bwX = 0;
    private ImageView xL = null;
    private RelativeLayout mParent = null;
    private RelativeLayout bqv = null;
    private TextView atJ = null;
    private View.OnClickListener bHW = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout bHX = null;
    private c bHY = null;
    private boolean bHZ = false;
    private boolean bIa = true;
    private TextView bIb = null;
    private TextView bIc = null;
    private boolean aRz = false;
    private String bIe = "1";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010021, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.day_classical_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(v.parent);
        this.bqv = (RelativeLayout) findViewById(v.title);
        this.atJ = (TextView) findViewById(v.title_text);
        this.bHX = (LinearLayout) findViewById(v.tag_webview_item);
        this.xL = (ImageView) findViewById(v.back);
        this.bIb = (TextView) this.bHX.findViewById(v.webview_fail);
        this.bIc = (TextView) this.bHX.findViewById(v.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(v.tag_progress);
        this.bHW = new b(this);
        this.xL.setOnClickListener(this.bHW);
        if (createWebView()) {
            this.bIc.setVisibility(8);
            refresh();
            return;
        }
        this.bIc.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.d(this.mParent, i);
        aw.g(this.bqv, i);
        aw.d(this.atJ, i);
        aw.a(this.xL, i);
        if (this.mWebView != null) {
            aw.d(this.mWebView, i);
            refresh();
        }
    }

    public void refresh() {
        if (TbadkApplication.m251getInst().getWebviewCrashCount() == 0 && !createWebView()) {
            this.bIc.setVisibility(0);
            return;
        }
        this.bIc.setVisibility(8);
        if (!this.aRz) {
            this.aRz = true;
            this.mProgressBar.setVisibility(0);
            this.bHZ = false;
            this.bIa = true;
            bT();
            this.bHY = new c(this, null);
            this.bHY.setPriority(3);
            this.bHY.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abJ() {
        if (this.bHZ) {
            if (!this.bIa) {
                showToast(getResources().getString(y.neterror));
            }
            this.aRz = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!com.baidu.tbadk.util.i.r(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String Z = Z(str, "pn=");
                    if (Z != null && Z.length() >= 0) {
                        this.bIe = Z;
                    }
                } else {
                    this.bIe = "1";
                }
                refresh();
            } else {
                com.baidu.tbadk.browser.a.j(this, String.valueOf(str) + "&_client_version=" + TbConfig.getVersion());
            }
        }
        return true;
    }

    private String Z(String str, String str2) {
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

    private boolean createWebView() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(y.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.bHX.addView(this.mWebView);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void bT() {
        if (this.bHY != null) {
            this.bHY.cancel();
        }
    }
}
