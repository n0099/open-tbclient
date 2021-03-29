package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
/* loaded from: classes5.dex */
public class LangbridgeActivity extends BaseActivity implements d {
    public static final int ID_DLG_BANDOWNLOAD = 1000;
    public static final String IS_SHOW_NATIVE_ERROR_PAGE = "isShowDefaultErrorPage";
    public static final String IS_SHOW_TITLE_BAR = "isShowTitleBar";
    public static final String KEY_DISABLE_SCREENSHOT = "disableScreenshot";
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";
    public static int j;

    /* renamed from: b  reason: collision with root package name */
    public String f25181b;

    /* renamed from: d  reason: collision with root package name */
    public String f25183d;
    public View i;
    public Bundle mParams;

    /* renamed from: a  reason: collision with root package name */
    public Stack<c> f25180a = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f25182c = false;

    /* renamed from: e  reason: collision with root package name */
    public int f25184e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f25185f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25186g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25187h = true;
    public Vector<Application.ActivityLifecycleCallbacks> k = new Vector<>();

    /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeActivity$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25189a;

        static {
            int[] iArr = new int[LifeCycleCbName.values().length];
            f25189a = iArr;
            try {
                iArr[LifeCycleCbName.OnCreated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25189a[LifeCycleCbName.OnStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25189a[LifeCycleCbName.OnResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25189a[LifeCycleCbName.OnPaused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25189a[LifeCycleCbName.OnStopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25189a[LifeCycleCbName.OnSaveInstanceState.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25189a[LifeCycleCbName.OnDestroyed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum LifeCycleCbName {
        OnCreated,
        OnStarted,
        OnResumed,
        OnPaused,
        OnStopped,
        OnSaveInstanceState,
        OnDestroyed
    }

    private Bundle a(Bundle bundle) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Bundle extras = getIntent().getExtras();
        boolean z = false;
        if (extras != null) {
            try {
                this.f25181b = extras.getString("jump_url");
                this.f25182c = extras.getBoolean("shwoshare", false);
                this.f25183d = extras.getString("title");
                this.f25184e = extras.getInt(Constants.BDL_KEY_BIZTYPE, 0);
                this.f25185f = extras.getLong("LANGBRIDGE_HASH", 0L);
                if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                    a(activityLifecycleCallbacks);
                }
            } catch (Exception unused) {
            }
        }
        if (bundle != null) {
            this.f25181b = bundle.getString("jump_url");
            this.f25182c = bundle.getBoolean("shwoshare", false);
            this.f25183d = bundle.getString("title");
            this.f25186g = bundle.getBoolean(IS_SHOW_NATIVE_ERROR_PAGE, true);
            this.f25187h = bundle.getBoolean(IS_SHOW_TITLE_BAR, true);
        }
        if (!TextUtils.isEmpty(this.f25181b)) {
            if (this.f25181b.contains("showShare=1") || this.f25181b.contains("showShare%3d1")) {
                this.f25182c = true;
            }
            if (this.f25181b.contains("hideShare=1") || this.f25181b.contains("hideShare%3d1")) {
                this.f25182c = false;
            }
            if (this.f25181b.contains("hideNativeErrorPage=1") || this.f25181b.contains("hideNativeErrorPage%3d1")) {
                this.f25186g = false;
            }
            if (this.f25181b.contains("hideTitleBar")) {
                this.f25187h = false;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("lang_showshare", this.f25182c);
        bundle2.putBoolean("lang_showtitle", this.f25187h);
        bundle2.putBoolean("lang_showerror", this.f25186g);
        bundle2.putBoolean("lang_longtitle", extras != null && extras.getBoolean(Constants.LONG_TITLE));
        if (extras != null && extras.getBoolean(Constants.ONLY_ICONS)) {
            z = true;
        }
        bundle2.putBoolean("lang_icontitle", z);
        bundle2.putString("lang_customtitle", this.f25183d);
        return bundle2;
    }

    private void b() {
        while (this.f25180a.size() > 0) {
            this.f25180a.pop().i();
        }
        f.a().b(this.f25180a);
    }

    public static Intent getStartIntent(Context context, String str, boolean z, boolean z2) {
        return a(context, str, null, z, z2);
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2) {
        startLangbridge(context, str, str2, z, z2, null);
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void backPressed() {
        onBackPressed();
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void closeTopWebview() {
        DXMSdkSAUtils.onEvent("#closeTopWebview");
        PayStatisticsUtil.onEvent("#closeTopWebview");
        c a2 = a();
        if (a2 != null) {
            DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList("CLS"));
            PayStatisticsUtil.onEventWithValue("#closeTopWebviewRet", "CLS");
            setContentView(a2.a(), false);
            a2.d();
            return;
        }
        DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList("KEEP"));
        PayStatisticsUtil.onEventWithValue("#closeTopWebviewRet", "KEEP");
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void closeWindow() {
        finish();
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean createLangbridgeCell(String str, boolean z, boolean z2) {
        LightappBrowserWebView lightappWebViewFromPool;
        c cellFromPrePool = LangbridgePreloadCellCenter.getInstance(this).getCellFromPrePool(str, getOwnerTag(), z2);
        boolean z3 = false;
        if (cellFromPrePool != null) {
            cellFromPrePool.a(this, this.mParams, getOwnerTag());
            setContentView(cellFromPrePool.a(), true);
            a(cellFromPrePool);
            DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "0"));
            PayStatisticsUtil.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "0"));
            return true;
        }
        if ((z || (h.a().a(this).MW_ON && f.a().a(this))) && (lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool(getActivity(), z)) != null) {
            cellFromPrePool = new LangbridgeCell(this, this.mParams, lightappWebViewFromPool, getOwnerTag());
        }
        if (cellFromPrePool != null) {
            setContentView(cellFromPrePool.a(), true);
            a(cellFromPrePool);
            DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "1"));
            PayStatisticsUtil.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "1"));
            z3 = true;
        } else {
            cellFromPrePool = getCurrentCell();
            DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "2"));
            PayStatisticsUtil.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "2"));
        }
        if (cellFromPrePool != null) {
            cellFromPrePool.a(str, null);
        }
        return z3;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public Activity getControllerActivity() {
        return getActivity();
    }

    public c getCurrentCell() {
        if (this.f25180a.size() > 0) {
            return this.f25180a.peek();
        }
        return null;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public long getLangbridgeHash() {
        return this.f25185f;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public int getLangbridgeStatus() {
        return j;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public String getOwnerTag() {
        return toString().hashCode() + "";
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void historyGo(int i) {
        DXMSdkSAUtils.onEvent("#eventHistoryGo");
        PayStatisticsUtil.onEvent("#eventHistoryGo");
        c a2 = a(i, false);
        if (a2 != null) {
            setContentView(a2.a(), false);
            a2.d();
        }
    }

    public int historyLength() {
        WebBackForwardList copyBackForwardList;
        Stack<c> stack = this.f25180a;
        int i = 0;
        if (stack == null && stack.size() == 0) {
            return 0;
        }
        Iterator<c> it = this.f25180a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.b() != null && (copyBackForwardList = next.b().copyBackForwardList()) != null) {
                i += copyBackForwardList.getCurrentIndex() + 1;
            }
        }
        return i;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean isActiveCell(@NonNull c cVar) {
        c peek;
        return this.f25180a.size() > 0 && (peek = this.f25180a.peek()) != null && peek == cVar;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean isBottomCell(c cVar) {
        return this.f25180a.lastIndexOf(cVar) == 0;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.a(i, i2, intent);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        c a2;
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.f25181b), "" + j));
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.f25181b), "" + j));
        if (!((this.f25180a.size() <= 0 || this.f25180a.peek() == null) ? false : !this.f25180a.peek().c()) || (a2 = a(-1, true)) == null) {
            return;
        }
        setContentView(a2.a(), false);
        a2.d();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = j;
        if (i < 2) {
            j = i + 1;
        }
        if (getIntent() == null) {
            finish();
            return;
        }
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.f25181b), "" + j));
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_ON_CREATE, Arrays.asList(CheckUtils.stripUrlParams(this.f25181b), "" + j));
        if (Build.VERSION.SDK_INT >= 11) {
            requestWindowFeature(10);
        }
        super.onCreate(bundle);
        f.a().a(this.f25180a);
        this.mParams = a(bundle);
        if (TextUtils.isEmpty(this.f25181b)) {
            finish();
            return;
        }
        LangbridgeCacheManager.getInstance().handleCreateLangbirdge(this.f25181b, null);
        a(this.f25181b);
        setIsShowMultiWindowTips(true);
        setIsMultiWindowAvailable(false);
        com.baidu.wallet.lightapp.base.a.a().a(getActivity());
        createLangbridgeCell(this.f25181b, true, true);
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    @Nullable
    public Dialog onCreateDialog(int i) {
        if (1000 == i) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.f25185f);
        com.baidu.wallet.lightapp.monitor.a.a().b();
        if (this.f25184e == 12) {
            LocalRouter.getInstance(getApplicationContext()).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), null);
        }
        a(LifeCycleCbName.OnDestroyed, (Bundle) null);
        b();
        g a2 = g.a();
        a2.a("clear_by_tab", new String[]{getOwnerTag() + "+"});
        LangbridgePreloadCellCenter.getInstance(this).clearPreloadPoolByGroup(getOwnerTag());
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.h();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (1000 == i) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(ResUtils.string(getApplicationContext(), "bd_wallet_download_prompt"));
            promptDialog.setCanceledOnTouchOutside(true);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Activity activity = LangbridgeActivity.this.getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    activity.removeDialog(1000);
                }
            });
            promptDialog.hideNegativeButton();
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.a(i, strArr, iArr);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c currentCell = getCurrentCell();
        if (currentCell != null) {
            currentCell.g();
        }
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.k.removeElement(activityLifecycleCallbacks);
    }

    public void setContentView(View view, boolean z) {
        View view2;
        if (view == null || view == (view2 = this.i)) {
            return;
        }
        boolean z2 = view2 != null;
        if (z2) {
            this.i.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_to_left" : "wallet_langbridge_slide_to_right"));
        }
        this.i = view;
        super.setContentView(view);
        if (z2) {
            view.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_from_right" : "wallet_langbridge_slide_from_left"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void setRnAuthResult(int i, String str) {
        RNAuthCallBack rNAuthBack;
        if (this.f25184e != 12 || (rNAuthBack = BaiduPay.getInstance().getRNAuthBack()) == null) {
            return;
        }
        rNAuthBack.onRNAuthResult(i, str);
        BaiduPay.getInstance().clearRNAuthBack();
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        Intent a2 = a(context, str, str2, z, z2, bundle);
        if (a2 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a2.putExtra("LANGBRIDGE_HASH", currentTimeMillis);
        LangbridgeCacheManager.getInstance().handleStartLangbirdge(currentTimeMillis, str);
        context.startActivity(a2);
        if (context instanceof Activity) {
            if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    public static void startLangbridge(Context context, String str, boolean z) {
        startLangbridge(context, str, null, true, z);
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f25180a.isEmpty()) {
            this.f25180a.peek().e();
        }
        this.f25180a.add(cVar);
        cVar.d();
    }

    private c a() {
        c pop;
        if (this.f25180a.size() > 0 && (pop = this.f25180a.pop()) != null) {
            pop.e();
            pop.j();
            if (this.f25180a.size() != 0 && this.f25180a.peek() != null) {
                return this.f25180a.peek();
            }
            if (this.f25184e == 12 && !pop.b().canGoBack()) {
                setRnAuthResult(2, "实名认证取消");
            }
            super.onBackPressed();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
        r8 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c a(int i, boolean z) {
        if (i != 0 && this.f25180a.size() > 0) {
            c peek = this.f25180a.peek();
            if (i > 0) {
                if (peek.b().canGoBackOrForward(i)) {
                    peek.b().goBackOrForward(i);
                    DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList(com.alipay.security.mobile.module.http.model.c.f2100g));
                    PayStatisticsUtil.onEventWithValue("#historyGoPositiveRet", com.alipay.security.mobile.module.http.model.c.f2100g);
                } else {
                    DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList("FAILED"));
                    PayStatisticsUtil.onEventWithValue("#historyGoPositiveRet", "FAILED");
                }
                DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
                PayStatisticsUtil.onEventWithValue("#historyGoRet", "KEEP");
                return null;
            }
            int abs = Math.abs(i);
            Stack stack = new Stack();
            c cVar = peek;
            boolean z2 = true;
            while (true) {
                if (abs <= 0 || cVar == null) {
                    break;
                }
                int currentIndex = cVar.b().copyBackForwardList().getCurrentIndex() + 1;
                if (currentIndex > abs && cVar.b().canGoBackOrForward(0 - abs)) {
                    cVar.b().goBackOrForward(i);
                    cVar.f();
                    break;
                } else if (currentIndex <= abs) {
                    if (this.f25180a.size() > 1) {
                        stack.push(this.f25180a.pop());
                        abs -= currentIndex;
                        cVar = this.f25180a.peek();
                        z2 = false;
                    } else if (this.f25180a.size() == 1 && abs == currentIndex && z) {
                        if (this.f25184e == 12 && !cVar.b().canGoBack()) {
                            setRnAuthResult(2, "实名认证取消");
                        }
                        super.onBackPressed();
                        cVar = null;
                    } else {
                        z2 = true;
                    }
                }
            }
            while (!stack.isEmpty()) {
                c cVar2 = (c) stack.peek();
                if (!z2) {
                    if (stack.size() == 1) {
                        cVar2.e();
                    }
                    cVar2.j();
                } else if (z2) {
                    this.f25180a.push(cVar2);
                }
                stack.pop();
            }
            if (z2 || cVar == peek) {
                DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
                PayStatisticsUtil.onEventWithValue("#historyGoRet", "KEEP");
                return null;
            }
            if (cVar != null) {
                DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(cVar.b().getUrl()));
                PayStatisticsUtil.onEventWithValue("#historyGoRet", cVar.b().getUrl());
            } else {
                DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("CLS"));
                PayStatisticsUtil.onEventWithValue("#historyGoRet", "CLS");
            }
            return cVar;
        }
        DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
        PayStatisticsUtil.onEventWithValue("#historyGoRet", "KEEP");
        return null;
    }

    private void a(String str) {
        if (TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2) {
        return a(context, str, str2, z, z2, null);
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, LangbridgeActivity.class);
        intent.putExtra("jump_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("with_anim", z);
        intent.putExtra("shwoshare", z2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        return intent;
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Object[] array = this.k.toArray();
        Activity activity = getActivity();
        switch (AnonymousClass2.f25189a[lifeCycleCbName.ordinal()]) {
            case 1:
                for (int length = array.length - 1; length >= 0; length--) {
                    ((Application.ActivityLifecycleCallbacks) array[length]).onActivityCreated(activity, bundle);
                }
                return;
            case 2:
                for (int length2 = array.length - 1; length2 >= 0; length2--) {
                    ((Application.ActivityLifecycleCallbacks) array[length2]).onActivityStarted(activity);
                }
                return;
            case 3:
                for (int length3 = array.length - 1; length3 >= 0; length3--) {
                    ((Application.ActivityLifecycleCallbacks) array[length3]).onActivityResumed(activity);
                }
                return;
            case 4:
                for (int length4 = array.length - 1; length4 >= 0; length4--) {
                    ((Application.ActivityLifecycleCallbacks) array[length4]).onActivityPaused(activity);
                }
                return;
            case 5:
                for (int length5 = array.length - 1; length5 >= 0; length5--) {
                    ((Application.ActivityLifecycleCallbacks) array[length5]).onActivityStopped(activity);
                }
                return;
            case 6:
                for (int length6 = array.length - 1; length6 >= 0; length6--) {
                    ((Application.ActivityLifecycleCallbacks) array[length6]).onActivitySaveInstanceState(activity, bundle);
                }
                return;
            case 7:
                for (int length7 = array.length - 1; length7 >= 0; length7--) {
                    ((Application.ActivityLifecycleCallbacks) array[length7]).onActivityDestroyed(activity);
                }
                return;
            default:
                return;
        }
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks == null || this.k.contains(activityLifecycleCallbacks)) {
            return;
        }
        this.k.addElement(activityLifecycleCallbacks);
    }
}
