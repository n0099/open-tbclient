package com.baidu.tieba.mainentrance.view;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import d.b.b.e.p.j;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import d.b.h0.z0.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SearchHistoryViewController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18843a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.n1.i.b f18844b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.n1.i.c f18845c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f18846d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f18847e;

    /* loaded from: classes3.dex */
    public class SearchJsBridge implements d.b.i0.c3.l0.b {
        public static final String INTERFACE_NAME = "CommonJSBridge";
        public static final String METHOD_DELETE_ALL_SEARCH_HISTORY = "deleteAllSearchHistory";
        public static final String METHOD_DELETE_SEARCH_HISTORY = "deleteSearchHistory";
        public static final String METHOD_GET_SEARCH_HISTORY = "getSearchHistory";
        public static final String METHOD_OPEN_SEACH_PAGE = "openSearchPage";
        public static final String METHOD_SET_SEARCH_HISTORY = "setSearchHistory";
        public static final String SUCCESS_CODE = "1";

        /* loaded from: classes3.dex */
        public class a extends f0<String> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18848a;

            public a(SearchJsBridge searchJsBridge, String str) {
                this.f18848a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public String doInBackground() {
                d.b.i0.c3.n0.a.h(this.f18848a);
                return this.f18848a;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements n<String> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                SearchHistoryViewController.this.f18846d.remove(str);
            }
        }

        /* loaded from: classes3.dex */
        public class c extends f0 {
            public c(SearchJsBridge searchJsBridge) {
            }

            @Override // d.b.h0.z0.f0
            public Object doInBackground() {
                d.b.i0.c3.n0.a.b();
                return null;
            }
        }

        /* loaded from: classes3.dex */
        public class d implements n {
            public d() {
            }

            @Override // d.b.h0.z0.n
            public void onReturnDataInUI(Object obj) {
                SearchHistoryViewController.this.f18846d.clear();
            }
        }

        public SearchJsBridge() {
        }

        private void deleteAllSearchHistory() {
            h0.b(new c(this), new d());
        }

        private void deleteSearchHistory(String str) {
            try {
                h0.b(new a(this, new JSONObject(str).optString("query")), new b());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private void openSearchPage(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("sub_type");
                if (SearchHistoryViewController.this.f18844b != null) {
                    SearchHistoryViewController.this.f18844b.a(optString, true, optInt);
                    TiebaStatic.log(new StatisticItem("c12034"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.b.i0.c3.l0.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if (METHOD_GET_SEARCH_HISTORY.equals(str2)) {
                    jsPromptResult.confirm(SearchHistoryViewController.this.k());
                    SearchHistoryViewController.this.f18847e = true;
                    return true;
                } else if (METHOD_DELETE_SEARCH_HISTORY.equals(str2)) {
                    deleteSearchHistory(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if (METHOD_DELETE_ALL_SEARCH_HISTORY.equals(str2)) {
                    deleteAllSearchHistory();
                    jsPromptResult.confirm("1");
                    return true;
                } else if (METHOD_OPEN_SEACH_PAGE.equals(str2)) {
                    openSearchPage(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.e {
        public a(SearchHistoryViewController searchHistoryViewController) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.h {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (webView == SearchHistoryViewController.this.f18845c.e()) {
                SearchHistoryViewController.this.n(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BaseWebView.d {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return SearchHistoryViewController.this.m(str);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends f0<List<String>> {
        public d(SearchHistoryViewController searchHistoryViewController) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public List<String> doInBackground() {
            return d.b.i0.c3.n0.a.k();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements n<List<String>> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            SearchHistoryViewController.this.f18846d = list;
        }
    }

    public SearchHistoryViewController(BaseActivity baseActivity, d.b.i0.n1.i.b bVar, d.b.i0.n1.i.c cVar) {
        this.f18843a = baseActivity.getPageContext();
        this.f18844b = bVar;
        this.f18845c = cVar;
        l();
        j();
    }

    public void i(String str) {
        List<String> list;
        if (StringUtils.isNull(str) || (list = this.f18846d) == null) {
            return;
        }
        list.remove(str);
        this.f18846d.add(0, str);
    }

    public final void j() {
        h0.b(new d(this), new e());
    }

    public final String k() {
        int count = ListUtils.getCount(this.f18846d);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jSONArray.put(this.f18846d.get(i));
        }
        return jSONArray.toString();
    }

    public final void l() {
        a aVar = new a(this);
        b bVar = new b();
        c cVar = new c();
        QuickWebView e2 = this.f18845c.e();
        if (e2 != null) {
            e2.h(new SearchJsBridge());
            e2.setOnPageFinishedListener(aVar);
            e2.setOnReceivedErrorListener(bVar);
            e2.setOnLoadUrlListener(cVar);
        }
    }

    public final boolean m(String str) {
        if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
                if (!d.b.h0.p0.b.b(this.f18843a)) {
                    new HotRanklistActivityConfig(this.f18843a.getPageActivity()).createNormalConfig("hotforum", "all").start();
                }
                return true;
            }
            return false;
        }
        String c2 = n0.c(str, "topic_id=");
        String c3 = n0.c(str, "topic_name=");
        if (!d.b.h0.p0.b.b(this.f18843a) && !StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
            this.f18843a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f18843a.getPageActivity()).createNormalConfig(c2, c3, "4")));
        }
        TiebaStatic.log(new StatisticItem("c10363").param("obj_name", c3));
        return true;
    }

    public final void n(boolean z) {
        NoDataViewFactory.e a2;
        if (!z) {
            this.f18845c.w();
            if (j.z()) {
                a2 = NoDataViewFactory.e.a(R.string.text_no_search_record);
            } else {
                a2 = NoDataViewFactory.e.a(R.string.neterror);
            }
            this.f18845c.v(a2);
            return;
        }
        this.f18845c.s();
    }

    public void o() {
        this.f18845c.s();
        if (this.f18847e) {
            String k = k();
            if (StringUtils.isNull(k)) {
                return;
            }
            QuickWebView e2 = this.f18845c.e();
            e2.loadUrl("javascript:setSearchHistory('" + k + "')");
            return;
        }
        QuickWebView e3 = this.f18845c.e();
        e3.loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
    }
}
