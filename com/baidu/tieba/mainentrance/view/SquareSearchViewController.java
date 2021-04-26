package com.baidu.tieba.mainentrance.view;

import android.net.http.SslError;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.internal.ETAG;
import d.a.i0.r.q.r0;
import d.a.i0.z0.e0;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n0;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class SquareSearchViewController implements d.a.j0.o1.i.b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f18906a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.o1.i.c f18907b;

    /* renamed from: c  reason: collision with root package name */
    public View f18908c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18909d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f18910e;

    /* renamed from: g  reason: collision with root package name */
    public String f18912g;

    /* renamed from: i  reason: collision with root package name */
    public SearchHistoryViewController f18914i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18911f = true;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f18913h = new Stack<>();
    public CustomMessageListener j = new d(2921444);

    /* loaded from: classes3.dex */
    public class SearchResultJsBridge implements d.a.j0.d3.l0.b {
        public static final String BIND_MOBILE_NUMBER = "bindMobileNumber";
        public static final String GET_SEARCH_AD_COOKIE = "getSearchAdCookie";
        public static final String INTERFACE_NAME = "CommonJSBridge";

        public SearchResultJsBridge() {
        }

        @Override // d.a.j0.d3.l0.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str) && GET_SEARCH_AD_COOKIE.equals(str2)) {
                jsPromptResult.confirm(SquareSearchViewController.this.u());
                return true;
            }
            return false;
        }

        public /* synthetic */ SearchResultJsBridge(SquareSearchViewController squareSearchViewController, d dVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public a(SquareSearchViewController squareSearchViewController) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                d.a.i0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.a.i0.r.z.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
            if (!TbadkCoreApplication.isLogin() && str != null && e0.e(str) && e0.a()) {
                r0 r0Var = new r0(SquareSearchViewController.this.f18906a, "sousuo_dianji");
                r0Var.f(str);
                DialogLoginHelper.checkUpIsLogin(r0Var);
                return true;
            } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(SquareSearchViewController.this.f18906a.getPageContext(), new String[]{str}) != 3) {
                return true;
            } else {
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink(SquareSearchViewController.this.f18906a.getPageContext(), new String[]{str}, true);
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f18916a;

        public c(SquareSearchViewController squareSearchViewController, String str) {
            this.f18916a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.i0.z0.f0
        public Boolean doInBackground() {
            d.a.j0.d3.n0.a.o(this.f18916a);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            SquareSearchViewController.this.f18907b.L(!((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.a.c.e.p.l.x(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity(), view);
            } else {
                SquareSearchViewController.this.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                if (StringUtils.isNull(SquareSearchViewController.this.f18912g)) {
                    d.a.c.e.p.l.x(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity(), textView);
                    SquareSearchViewController.this.A();
                } else {
                    SquareSearchViewController squareSearchViewController = SquareSearchViewController.this;
                    squareSearchViewController.a(squareSearchViewController.f18912g, false, 1);
                    TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", SquareSearchViewController.this.f18912g).param("obj_source", "1").param("obj_type", "1"));
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            if (SquareSearchViewController.this.f18911f) {
                SquareSearchViewController.this.f18912g = editable.toString();
                SquareSearchViewController.this.G();
            }
            SquareSearchViewController.this.f18907b.r(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareSearchViewController.this.f18906a.finish();
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != SquareSearchViewController.this.f18907b.g() || SquareSearchViewController.this.f18907b.g().getText() == null) {
                if (view == SquareSearchViewController.this.f18907b.d()) {
                    d.a.c.e.p.l.x(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity(), SquareSearchViewController.this.f18907b.g());
                    d.a.c.e.m.e.a().postDelayed(new a(), 1000L);
                    return;
                }
                return;
            }
            SquareSearchViewController squareSearchViewController = SquareSearchViewController.this;
            squareSearchViewController.f18912g = squareSearchViewController.f18907b.g().getText().toString();
            if (StringUtils.isNull(SquareSearchViewController.this.f18912g)) {
                SquareSearchViewController.this.F();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ?? adapter = adapterView.getAdapter();
            if (adapter == 0 || i2 >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i2);
            if (item instanceof String) {
                String str = (String) item;
                SquareSearchViewController.this.a(str, true, 3);
                TiebaStatic.eventStat(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", SquareSearchViewController.this.f18912g));
            } else if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", forumInfo.has_concerned.intValue() <= 0 ? "2" : "1").param("fid", forumInfo.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public j() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 2 || i2 == 1) {
                d.a.c.e.p.l.x(SquareSearchViewController.this.f18906a.getPageContext().getPageActivity(), absListView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements BaseWebView.e {
        public k(SquareSearchViewController squareSearchViewController) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            d.a.i0.r.z.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements BaseWebView.h {
        public l(SquareSearchViewController squareSearchViewController) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            d.a.i0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
        }
    }

    public SquareSearchViewController(BaseActivity baseActivity, boolean z) {
        this.f18906a = baseActivity;
        this.f18909d = z;
        t();
    }

    public final void A() {
        HotSearchInfoData hotSearchInfoData = this.f18910e;
        if (hotSearchInfoData == null) {
            BaseActivity baseActivity = this.f18906a;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (hotSearchInfoData.t() != 0 && this.f18910e.t() != 2) {
            if (this.f18910e.t() == 1 && !d.a.i0.p0.b.b(this.f18906a.getPageContext())) {
                this.f18906a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f18906a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f18910e.getId()), this.f18910e.getName(), "4")));
            }
        } else {
            a(this.f18910e.getName(), true, 1);
        }
        TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f18910e.getName()).param("obj_type", this.f18910e.t() == 0 ? 2 : 1));
    }

    public final void B() {
        d.a.j0.o1.i.c cVar = this.f18907b;
        if (cVar == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f18910e;
        if (hotSearchInfoData == null) {
            cVar.B(this.f18906a.getResources().getString(R.string.search_bar));
        } else {
            cVar.B(hotSearchInfoData.s());
        }
    }

    public void C(HotSearchInfoData hotSearchInfoData) {
        this.f18910e = hotSearchInfoData;
        B();
    }

    public void D(List<String> list) {
        this.f18907b.E(list, this.f18912g);
    }

    public void E(List<ForumInfo> list) {
        this.f18907b.F(list, this.f18912g);
    }

    public final void F() {
        this.f18914i.o();
    }

    public final void G() {
        if (!StringUtils.isNull(this.f18912g)) {
            z();
        } else {
            F();
        }
    }

    @Override // d.a.j0.o1.i.b
    public void a(String str, boolean z, int i2) {
        if (!d.a.c.e.p.j.z()) {
            this.f18906a.showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            if (z) {
                this.f18911f = false;
                this.f18907b.C(str);
                this.f18911f = true;
            }
            d.a.c.e.p.l.x(this.f18906a.getPageContext().getPageActivity(), this.f18907b.g());
            this.f18907b.y();
            String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
            try {
                str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f18907b.f().loadUrl(str2);
            this.f18913h.push(str);
            h0.b(new c(this, str), null);
            this.f18914i.i(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    public final void l(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, str2);
    }

    public final void m() {
        this.f18907b.f().h(new UegTbJsBridge(this.f18906a.getPageContext()));
        this.f18907b.f().h(new SearchResultJsBridge(this, null));
    }

    public final void n() {
        k kVar = new k(this);
        l lVar = new l(this);
        a aVar = new a(this);
        b bVar = new b();
        this.f18907b.I(kVar);
        this.f18907b.K(lVar);
        this.f18907b.J(aVar);
        this.f18907b.H(bVar);
    }

    public final void o() {
        i iVar = new i();
        j jVar = new j();
        this.f18907b.t(iVar);
        this.f18907b.u(jVar);
    }

    public void p() {
        e eVar = new e();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        this.f18907b.A(eVar);
        this.f18907b.z(fVar);
        this.f18907b.D(gVar);
        this.f18907b.x(hVar);
    }

    public final void q() {
        if (this.f18907b.n()) {
            return;
        }
        z();
    }

    public View r() {
        return this.f18907b.g();
    }

    public BaseWebView s() {
        return this.f18907b.f();
    }

    public final void t() {
        try {
            View inflate = LayoutInflater.from(this.f18906a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.f18908c = inflate;
            this.f18906a.setContentView(inflate);
        } catch (Exception e2) {
            e2.printStackTrace();
            Map<String, String> a2 = d.a.j0.o1.i.a.a();
            if (a2 != null) {
                int size = a2.size();
                int i2 = 0;
                for (String str : a2.keySet()) {
                    d.a.j0.o1.i.a.b(str);
                    try {
                        View inflate2 = LayoutInflater.from(this.f18906a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.f18908c = inflate2;
                        this.f18906a.setContentView(inflate2);
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        i2++;
                    }
                }
                if (i2 == size) {
                    this.f18906a.finish();
                    return;
                }
            } else {
                this.f18906a.finish();
                return;
            }
        }
        View view = this.f18908c;
        if (view == null) {
            this.f18906a.finish();
            return;
        }
        d.a.j0.o1.i.c cVar = new d.a.j0.o1.i.c(view, this.f18906a.getPageContext().getPageActivity());
        this.f18907b = cVar;
        this.f18914i = new SearchHistoryViewController(this.f18906a, this, cVar);
        p();
        o();
        n();
        m();
        B();
        G();
        n0.g(this.f18907b.f(), this.f18906a.getUniqueId());
        n0.g(this.f18907b.e(), this.f18906a.getUniqueId());
        this.f18906a.registerListener(this.j);
    }

    public final String u() {
        JSONObject jSONObject = new JSONObject();
        try {
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                l(jSONObject, "mercator_lat", e2.t());
                l(jSONObject, "mercator_lon", e2.u());
                l(jSONObject, "mercator_city", String.valueOf(e2.s()));
                l(jSONObject, "mercator_radius", e2.v());
                l(jSONObject, "mercator_time", String.valueOf(e2.w()));
            }
            l(jSONObject, "mod", Build.MODEL);
            l(jSONObject, "ov", Build.VERSION.RELEASE);
            l(jSONObject, "os_type", String.valueOf(2));
            l(jSONObject, "net_type", String.valueOf(d.a.c.e.p.j.I()));
            l(jSONObject, "imei", TbadkCoreApplication.getInst().getImei());
            l(jSONObject, "from", TbConfig.getFrom());
            l(jSONObject, "cfrom", TbConfig.getCurrentFrom());
            l(jSONObject, HttpRequest.CLIENT_VERSION, TbConfig.getVersion());
            l(jSONObject, "CUID", TbadkCoreApplication.getInst().getCuid());
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            l(jSONObject, AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            l(jSONObject, TiebaStatic.Params.CUID_GALAXY2, cuidGalaxy2);
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                l(jSONObject, ETAG.KEY_BAIDU_ID, new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
            }
        } catch (JSONException e3) {
            BdLog.e(e3);
        }
        return jSONObject.toString();
    }

    public void v(int i2) {
        this.f18907b.o(this.f18906a.getPageContext(), i2);
    }

    public void w() {
        d.a.j0.o1.i.c cVar = this.f18907b;
        if (cVar != null) {
            cVar.p();
        }
    }

    public void x() {
        d.a.j0.o1.i.c cVar = this.f18907b;
        if (cVar != null) {
            cVar.q();
        }
    }

    public void y() {
        d.a.j0.o1.i.c cVar;
        if (this.f18913h.size() > 1) {
            this.f18913h.pop();
            String peek = this.f18913h.peek();
            if (TextUtils.isEmpty(peek) || (cVar = this.f18907b) == null) {
                return;
            }
            boolean z = this.f18911f;
            this.f18911f = false;
            cVar.C(peek);
            this.f18911f = z;
            this.f18907b.y();
            return;
        }
        this.f18913h.clear();
    }

    public final void z() {
        if (StringUtils.isNull(this.f18912g)) {
            F();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.f18912g.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.f18909d ? 1 : 0);
        this.f18906a.sendMessage(searchListNetMessage);
    }
}
