package com.baidu.tieba.square.recommend;

import android.location.Address;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidubce.auth.NTLMEngineImpl;
import com.tencent.connect.common.Constants;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes5.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.d {
    public static boolean t = false;
    public static long u;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20747e = null;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f20748f = null;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f20749g = null;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20750h = null;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f20751i = null;
    public BaseWebView j = null;
    public ProgressBar k = null;
    public LinearLayout l = null;
    public c m = null;
    public boolean n = false;
    public boolean o = true;
    public TextView p = null;
    public TextView q = null;
    public boolean r = false;
    public String s = "1";

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<DailyClassicalActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(DailyClassicalActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.back) {
                DailyClassicalActivity.this.finish();
            } else if (id == R.id.tag_webview_item) {
                DailyClassicalActivity.this.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20753a;

        /* renamed from: b  reason: collision with root package name */
        public String f20754b;

        public c() {
            this.f20753a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20753a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            DailyClassicalActivity.this.r = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/tag/gettogether");
            this.f20753a = netWork;
            netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f20753a.addPostData("night_type", "1");
            }
            this.f20753a.addPostData(Config.PACKAGE_NAME, DailyClassicalActivity.this.s);
            this.f20753a.addPostData("_version_more", "1");
            this.f20753a.addPostData(Constants.PARAM_PLATFORM, "android");
            if (DailyClassicalActivity.t) {
                boolean unused = DailyClassicalActivity.t = false;
                this.f20753a.addPostData("msg_click", "1");
                this.f20753a.addPostData("message_id", String.valueOf(DailyClassicalActivity.u));
            }
            Address h2 = d.a.c.e.i.a.l().h(false);
            if (h2 != null && DailyClassicalActivity.this.u()) {
                NetWork netWork2 = this.f20753a;
                netWork2.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
            }
            try {
                this.f20754b = this.f20753a.postNetData();
                if (this.f20753a.isNetSuccess()) {
                    return this.f20754b;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            DailyClassicalActivity.this.m = null;
            DailyClassicalActivity.this.l.setOnClickListener(null);
            NetWork netWork = this.f20753a;
            if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                DailyClassicalActivity.this.o = false;
                DailyClassicalActivity.this.p.setVisibility(0);
                DailyClassicalActivity.this.j.setVisibility(8);
                DailyClassicalActivity.this.l.setOnClickListener(DailyClassicalActivity.this.f20751i);
            } else {
                DailyClassicalActivity.this.j.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
                DailyClassicalActivity.this.p.setVisibility(8);
                DailyClassicalActivity.this.j.setVisibility(0);
            }
            DailyClassicalActivity.this.n = true;
            DailyClassicalActivity.this.x();
        }

        public /* synthetic */ c(DailyClassicalActivity dailyClassicalActivity, a aVar) {
            this();
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902021, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBgColor(this.f20748f, i2);
        SkinManager.setTopBarBgImage(this.f20749g, i2);
        SkinManager.setTopBarTitleColor(this.f20750h, i2);
        SkinManager.setTopBarBackBgImage(this.f20747e, i2);
        BaseWebView baseWebView = this.j;
        if (baseWebView != null) {
            SkinManager.setBgColor(baseWebView, i2);
            y();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        w();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    public final void s() {
        c cVar = this.m;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(getPageContext(), new String[]{str});
        if (dealOneLinkWithOutJumpWebView == 1) {
            finish();
            return true;
        } else if (dealOneLinkWithOutJumpWebView == 0) {
            return true;
        } else {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String v = v(str, "pn=");
                    if (v != null && v.length() >= 0) {
                        this.s = v;
                    }
                } else {
                    this.s = "1";
                }
                y();
                return true;
            }
            d.a.j0.l.a.k(this, str + "&_client_version=" + TbConfig.getVersion());
            return true;
        }
    }

    public final boolean t() {
        if (this.j == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                    return false;
                }
                BaseWebView baseWebView = new BaseWebView(this);
                this.j = baseWebView;
                SkinManager.setBgColor(baseWebView, TbadkCoreApplication.getInst().getSkinType());
                this.j.setOnLoadUrlListener(this);
                this.j.setHorizontalScrollBarEnabled(false);
                this.j.setHorizontalScrollbarOverlay(false);
                this.j.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
                this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.l.addView(this.j);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean u() {
        return true;
    }

    public final String v(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = indexOf + str2.length();
            int i2 = length;
            while (i2 < str.length() && str.charAt(i2) != '&') {
                i2++;
            }
            return URLDecoder.decode(str.substring(length, i2));
        }
        return "";
    }

    public final void w() {
        this.f20748f = (RelativeLayout) findViewById(R.id.parent);
        this.f20749g = (RelativeLayout) findViewById(R.id.title);
        this.f20750h = (TextView) findViewById(R.id.title_text);
        this.l = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.f20747e = (ImageView) findViewById(R.id.back);
        this.p = (TextView) this.l.findViewById(R.id.webview_fail);
        this.q = (TextView) this.l.findViewById(R.id.webview_crash_tip);
        this.k = (ProgressBar) findViewById(R.id.tag_progress);
        b bVar = new b();
        this.f20751i = bVar;
        this.f20747e.setOnClickListener(bVar);
        if (t()) {
            this.q.setVisibility(8);
            y();
            return;
        }
        this.q.setVisibility(0);
    }

    public final void x() {
        if (this.n) {
            if (!this.o) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.r = false;
            this.k.setVisibility(8);
        }
    }

    public void y() {
        if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !t()) {
            this.q.setVisibility(0);
            return;
        }
        this.q.setVisibility(8);
        if (this.r) {
            return;
        }
        this.r = true;
        this.k.setVisibility(0);
        this.n = false;
        this.o = true;
        s();
        c cVar = new c(this, null);
        this.m = cVar;
        cVar.setPriority(3);
        this.m.execute(new Object[0]);
    }
}
