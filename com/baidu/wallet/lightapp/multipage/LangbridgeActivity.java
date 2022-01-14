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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.business.LangbridgeBarParams;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
/* loaded from: classes13.dex */
public class LangbridgeActivity extends BaseActivity implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_DLG_BANDOWNLOAD = 1000;
    public static final String IS_SHOW_NATIVE_ERROR_PAGE = "isShowDefaultErrorPage";
    public static final String IS_SHOW_TITLE_BAR = "isShowTitleBar";
    public static final String KEY_DISABLE_SCREENSHOT = "disableScreenshot";
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";

    /* renamed from: j  reason: collision with root package name */
    public static int f51648j;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack<c> a;

    /* renamed from: b  reason: collision with root package name */
    public String f51649b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51650c;

    /* renamed from: d  reason: collision with root package name */
    public String f51651d;

    /* renamed from: e  reason: collision with root package name */
    public int f51652e;

    /* renamed from: f  reason: collision with root package name */
    public long f51653f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51654g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51655h;

    /* renamed from: i  reason: collision with root package name */
    public View f51656i;
    public String k;
    public Vector<Application.ActivityLifecycleCallbacks> l;
    public Bundle mParams;

    /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeActivity$2  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(231497892, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(231497892, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity$2;");
                    return;
                }
            }
            int[] iArr = new int[LifeCycleCbName.values().length];
            a = iArr;
            try {
                iArr[LifeCycleCbName.OnCreated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LifeCycleCbName.OnStarted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LifeCycleCbName.OnResumed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LifeCycleCbName.OnPaused.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LifeCycleCbName.OnStopped.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LifeCycleCbName.OnSaveInstanceState.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[LifeCycleCbName.OnDestroyed.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class LifeCycleCbName {
        public static final /* synthetic */ LifeCycleCbName[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LifeCycleCbName OnCreated;
        public static final LifeCycleCbName OnDestroyed;
        public static final LifeCycleCbName OnPaused;
        public static final LifeCycleCbName OnResumed;
        public static final LifeCycleCbName OnSaveInstanceState;
        public static final LifeCycleCbName OnStarted;
        public static final LifeCycleCbName OnStopped;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-534095230, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity$LifeCycleCbName;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-534095230, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity$LifeCycleCbName;");
                    return;
                }
            }
            OnCreated = new LifeCycleCbName("OnCreated", 0);
            OnStarted = new LifeCycleCbName("OnStarted", 1);
            OnResumed = new LifeCycleCbName("OnResumed", 2);
            OnPaused = new LifeCycleCbName("OnPaused", 3);
            OnStopped = new LifeCycleCbName("OnStopped", 4);
            OnSaveInstanceState = new LifeCycleCbName("OnSaveInstanceState", 5);
            LifeCycleCbName lifeCycleCbName = new LifeCycleCbName("OnDestroyed", 6);
            OnDestroyed = lifeCycleCbName;
            $VALUES = new LifeCycleCbName[]{OnCreated, OnStarted, OnResumed, OnPaused, OnStopped, OnSaveInstanceState, lifeCycleCbName};
        }

        public LifeCycleCbName(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LifeCycleCbName valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LifeCycleCbName) Enum.valueOf(LifeCycleCbName.class, str) : (LifeCycleCbName) invokeL.objValue;
        }

        public static LifeCycleCbName[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LifeCycleCbName[]) $VALUES.clone() : (LifeCycleCbName[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1975175886, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1975175886, "Lcom/baidu/wallet/lightapp/multipage/LangbridgeActivity;");
        }
    }

    public LangbridgeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Stack<>();
        this.f51650c = false;
        this.f51652e = 0;
        this.f51653f = 0L;
        this.f51654g = true;
        this.f51655h = true;
        this.k = "";
        this.l = new Vector<>();
    }

    private Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                try {
                    this.f51649b = extras.getString("jump_url");
                    this.f51650c = extras.getBoolean("shwoshare", false);
                    this.f51651d = extras.getString("title");
                    this.f51652e = extras.getInt("baidu.wallet.lightapp.biztype", 0);
                    this.f51653f = extras.getLong("LANGBRIDGE_HASH", 0L);
                    if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                        a(activityLifecycleCallbacks);
                    }
                } catch (Exception unused) {
                }
            }
            a(j.a());
            if (bundle != null) {
                this.f51649b = bundle.getString("jump_url");
                this.f51650c = bundle.getBoolean("shwoshare", false);
                this.f51651d = bundle.getString("title");
                this.f51654g = bundle.getBoolean(IS_SHOW_NATIVE_ERROR_PAGE, true);
                this.f51655h = bundle.getBoolean(IS_SHOW_TITLE_BAR, true);
            }
            if (!TextUtils.isEmpty(this.f51649b)) {
                if (this.f51649b.contains("showShare=1") || this.f51649b.contains("showShare%3d1")) {
                    this.f51650c = true;
                }
                if (this.f51649b.contains("hideShare=1") || this.f51649b.contains("hideShare%3d1")) {
                    this.f51650c = false;
                }
                if (this.f51649b.contains("hideNativeErrorPage=1") || this.f51649b.contains("hideNativeErrorPage%3d1")) {
                    this.f51654g = false;
                }
                if (this.f51649b.contains("hideTitleBar")) {
                    this.f51655h = false;
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("lang_showshare", this.f51650c);
            bundle2.putBoolean("lang_showtitle", this.f51655h);
            bundle2.putBoolean("lang_showerror", this.f51654g);
            if (extras != null) {
                bundle2.putBoolean("lang_longtitle", extras.getBoolean("long_title", true));
                bundle2.putBoolean("lang_icontitle", extras.getBoolean("only_icons"));
            }
            bundle2.putString("lang_customtitle", this.f51651d);
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            while (this.a.size() > 0) {
                this.a.pop().i();
            }
            g.a().b(this.a);
        }
    }

    public static Intent getStartIntent(Context context, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(context, str, null, z, z2) : (Intent) invokeCommon.objValue;
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            startLangbridge(context, str, str2, z, z2, null);
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void backPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void closeTopWebview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            DXMSdkSAUtils.onEvent("#closeTopWebview");
            c a = a();
            if (a != null) {
                DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList("CLS"));
                setContentView(a.a(), false);
                a.d();
                return;
            }
            DXMSdkSAUtils.onEventWithValues("#closeTopWebviewRet", Arrays.asList("KEEP"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean createLangbridgeCell(String str, boolean z, boolean z2, String str2) {
        InterceptResult invokeCommon;
        LightappBrowserWebView lightappWebViewFromPool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2})) == null) {
            c currentCell = getCurrentCell();
            if (currentCell != null) {
                LangbridgeBarParams l = currentCell.l();
                Bundle bundle = this.mParams;
                if (bundle != null) {
                    bundle.putSerializable("lang_prebarparams", l);
                }
            }
            c cellFromPrePool = LangbridgePreloadCellCenter.getInstance(this).getCellFromPrePool(str, getOwnerTag(), z2);
            boolean z3 = true;
            if (cellFromPrePool != null) {
                cellFromPrePool.a(this, this.mParams, getOwnerTag());
                setContentView(cellFromPrePool.a(), true);
                a(cellFromPrePool);
                DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "0"));
            } else {
                if ((z || (i.a().a(this).MW_ON && g.a().a(this))) && (lightappWebViewFromPool = LightappWebViewCenter.getInstance().getLightappWebViewFromPool(getActivity(), z)) != null) {
                    cellFromPrePool = new LangbridgeCell(this, this.mParams, lightappWebViewFromPool, getOwnerTag());
                }
                if (cellFromPrePool != null) {
                    setContentView(cellFromPrePool.a(), true);
                    a(cellFromPrePool);
                    DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "1"));
                } else {
                    cellFromPrePool = getCurrentCell();
                    DXMSdkSAUtils.onEventWithValues("#MW_LANG_CreateRet", Arrays.asList("" + z, "2"));
                    z3 = false;
                }
                if (cellFromPrePool != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        cellFromPrePool.a(str2, (b) null, false);
                    } else {
                        cellFromPrePool.a(str, (b) null, false);
                    }
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public Activity getControllerActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    public c getCurrentCell() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a.size() > 0) {
                return this.a.peek();
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public long getLangbridgeHash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51653f : invokeV.longValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public String getLangbridgeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public int getLangbridgeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f51648j : invokeV.intValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public String getOwnerTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return toString().hashCode() + "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void historyGo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            DXMSdkSAUtils.onEvent("#eventHistoryGo");
            c a = a(i2, false);
            if (a != null) {
                setContentView(a.a(), false);
                a.d();
            }
        }
    }

    public int historyLength() {
        InterceptResult invokeV;
        WebBackForwardList copyBackForwardList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Stack<c> stack = this.a;
            int i2 = 0;
            if (stack == null && stack.size() == 0) {
                return 0;
            }
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && next.b() != null && (copyBackForwardList = next.b().copyBackForwardList()) != null) {
                    i2 += copyBackForwardList.getCurrentIndex() + 1;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean isActiveCell(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cVar)) == null) {
            if (this.a.size() > 0) {
                c cVar2 = null;
                try {
                    cVar2 = this.a.peek();
                } catch (EmptyStackException e2) {
                    e2.printStackTrace();
                }
                return cVar2 != null && cVar2 == cVar;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public boolean isBottomCell(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cVar)) == null) ? this.a.lastIndexOf(cVar) == 0 : invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            c currentCell = getCurrentCell();
            if (currentCell != null) {
                currentCell.a(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(CheckUtils.stripUrlParams(this.f51649b), "" + f51648j));
            if (!((this.a.size() <= 0 || this.a.peek() == null) ? false : !this.a.peek().c()) || (a = a(-1, true)) == null) {
                return;
            }
            setContentView(a.a(), false);
            a.d();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            int i2 = f51648j;
            if (i2 < 2) {
                f51648j = i2 + 1;
            }
            if (getIntent() == null) {
                finish();
                return;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                requestWindowFeature(10);
            }
            super.onCreate(bundle);
            g.a().a(this.a);
            this.mParams = a(bundle);
            if (TextUtils.isEmpty(this.f51649b)) {
                finish();
                return;
            }
            LangbridgeCacheManager.getInstance().handleCreateLangbirdge(this.f51649b, null);
            a(this.f51649b);
            setIsShowMultiWindowTips(true);
            setIsMultiWindowAvailable(false);
            com.baidu.wallet.lightapp.base.a.a().a(getActivity());
            StringBuilder sb = new StringBuilder();
            sb.append((toString() + System.currentTimeMillis()).hashCode());
            sb.append("");
            this.k = sb.toString();
            createLangbridgeCell(this.f51649b, true, true, "");
            LogUtil.i("LangbridgeActivity", "oncreate, mLangbridgeHashStamp = " + this.k);
            a(LifeCycleCbName.OnCreated, (Bundle) null);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    @Nullable
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (1000 == i2) {
                return new PromptDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.f51653f);
            WhiteScreenMonitor.a().b();
            if (this.f51652e == 12) {
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), null);
            }
            a(LifeCycleCbName.OnDestroyed, (Bundle) null);
            b();
            h a = h.a();
            a.a("clear_by_tab", new String[]{getOwnerTag() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
            LangbridgePreloadCellCenter.getInstance(this).clearPreloadPoolByGroup(getOwnerTag());
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            c currentCell = getCurrentCell();
            WhiteScreenMonitor.a().b();
            if (currentCell != null) {
                currentCell.h();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, dialog) == null) {
            if (1000 == i2) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(ResUtils.string(DxmApplicationContextImpl.getApplicationContext(this), "bd_wallet_download_prompt"));
                promptDialog.setCanceledOnTouchOutside(true);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.lightapp.multipage.LangbridgeActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LangbridgeActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Activity activity;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (activity = this.a.getActivity()) == null || activity.isFinishing()) {
                            return;
                        }
                        activity.removeDialog(1000);
                    }
                });
                promptDialog.hideNegativeButton();
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048598, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            c currentCell = getCurrentCell();
            if (currentCell != null) {
                currentCell.a(i2, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            c currentCell = getCurrentCell();
            if (currentCell != null) {
                currentCell.g();
            }
        }
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, activityLifecycleCallbacks) == null) {
            this.l.removeElement(activityLifecycleCallbacks);
        }
    }

    public void setContentView(View view, boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, view, z) == null) || view == null || view == (view2 = this.f51656i)) {
            return;
        }
        boolean z2 = view2 != null;
        if (z2) {
            this.f51656i.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_to_left" : "wallet_langbridge_slide_to_right"));
        }
        this.f51656i = view;
        super.setContentView(view);
        if (z2) {
            view.startAnimation(ResUtils.getAnimation(this, z ? "wallet_langbridge_slide_from_right" : "wallet_langbridge_slide_from_left"));
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void setLangbridgeStamp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.k = str;
        }
    }

    @Override // com.baidu.wallet.lightapp.multipage.d
    public void setRnAuthResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048603, this, i2, str) == null) && this.f51652e == 12) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2)).data("desc", str), null);
        }
    }

    public static void startLangbridge(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        Intent a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), bundle}) == null) || (a = a(context, str, str2, z, z2, bundle)) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a.putExtra("LANGBRIDGE_HASH", currentTimeMillis);
        LangbridgeCacheManager.getInstance().handleStartLangbirdge(currentTimeMillis, str);
        context.startActivity(a);
        if (context instanceof Activity) {
            if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    public static void startLangbridge(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65551, null, context, str, z) == null) {
            startLangbridge(context, str, null, true, z);
        }
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, cVar) == null) || cVar == null) {
            return;
        }
        if (!this.a.isEmpty()) {
            this.a.peek().e();
        }
        this.a.add(cVar);
        cVar.d();
    }

    private c a() {
        InterceptResult invokeV;
        c pop;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.a.size() > 0 && (pop = this.a.pop()) != null) {
                pop.e();
                pop.j();
                if (this.a.size() != 0 && this.a.peek() != null) {
                    return this.a.peek();
                }
                if (this.f51652e == 12 && !pop.b().canGoBack()) {
                    setRnAuthResult(2, "实名认证取消");
                }
                super.onBackPressed();
            }
            return null;
        }
        return (c) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
        r8 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 != 0 && this.a.size() > 0) {
                c peek = this.a.peek();
                if (i2 > 0) {
                    if (peek.b().canGoBackOrForward(i2)) {
                        peek.b().goBackOrForward(i2);
                        DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList(com.alipay.security.mobile.module.http.model.c.p));
                    } else {
                        DXMSdkSAUtils.onEventWithValues("#historyGoPositiveRet", Arrays.asList("FAILED"));
                    }
                    DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
                    return null;
                }
                int abs = Math.abs(i2);
                Stack stack = new Stack();
                c cVar = peek;
                boolean z2 = true;
                while (true) {
                    if (abs <= 0 || cVar == null) {
                        break;
                    }
                    int currentIndex = cVar.b().copyBackForwardList().getCurrentIndex() + 1;
                    if (currentIndex > abs && cVar.b().canGoBackOrForward(0 - abs)) {
                        cVar.b().goBackOrForward(i2);
                        cVar.f();
                        break;
                    } else if (currentIndex <= abs) {
                        if (this.a.size() > 1) {
                            stack.push(this.a.pop());
                            abs -= currentIndex;
                            cVar = this.a.peek();
                            z2 = false;
                        } else if (this.a.size() == 1 && abs == currentIndex && z) {
                            if (this.f51652e == 12 && !cVar.b().canGoBack()) {
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
                        this.a.push(cVar2);
                    }
                    stack.pop();
                }
                if (z2 || cVar == peek) {
                    DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
                    return null;
                }
                if (cVar != null) {
                    DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList(cVar.b().getUrl()));
                } else {
                    DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("CLS"));
                }
                return cVar;
            }
            DXMSdkSAUtils.onEventWithValues("#historyGoRet", Arrays.asList("KEEP"));
            return null;
        }
        return (c) invokeCommon.objValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, str) == null) && TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(context, str, str2, z, z2, null) : (Intent) invokeCommon.objValue;
    }

    public static Intent a(Context context, String str, String str2, boolean z, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), bundle})) == null) {
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
        return (Intent) invokeCommon.objValue;
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, lifeCycleCbName, bundle) == null) {
            Object[] array = this.l.toArray();
            Activity activity = getActivity();
            switch (AnonymousClass2.a[lifeCycleCbName.ordinal()]) {
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
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, activityLifecycleCallbacks) == null) || activityLifecycleCallbacks == null || this.l.contains(activityLifecycleCallbacks)) {
            return;
        }
        this.l.addElement(activityLifecycleCallbacks);
    }
}
