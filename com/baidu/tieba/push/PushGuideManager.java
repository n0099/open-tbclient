package com.baidu.tieba.push;

import androidx.annotation.MainThread;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.b05;
import com.baidu.tieba.da;
import com.baidu.tieba.ju5;
import com.baidu.tieba.nu5;
import com.baidu.tieba.of1;
import com.baidu.tieba.ot5;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.qf1;
import com.baidu.tieba.rd;
import com.baidu.tieba.u45;
import com.baidu.tieba.ufa;
import com.baidu.tieba.vfa;
import com.baidu.tieba.yfa;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/baidu/tieba/push/PushGuideManager;", "", "()V", "H5_DIALOG_URL", "", "KEY_SCENE_GROUP_CACHE", "KEY_SCENE_SHOWN_PREFIX", "KEY_SP_PUSH_STRATEGY_NEW", "config", "Lcom/baidu/tieba/push/PushSceneConfig;", "groupRecordCache", "Lcom/baidu/tieba/push/PushSceneGroupRecord;", "pushGuideMap", "Ljava/util/HashMap;", "Lcom/baidu/tieba/push/guide/BasePushGuide;", "Lkotlin/collections/HashMap;", "areNotificationsEnabled", "", "checkShouldShow", "scene", "checkSingleSceneShouldShow", "findGroupByScene", "Lcom/baidu/tieba/push/PushSceneGroup;", "findGroupCacheByGroupId", "Lcom/baidu/tieba/push/PushSceneGroupSingleRecord;", "groupNo", "", "getH5DialogUrlByScene", "getPushGuide", "getPushSceneLastShownTime", "", "getSceneConf", "Lcom/baidu/tieba/push/PushSceneItem;", "markSceneShown", "", "raisePushSceneGroupCount", "refreshPushSceneGroupCountFromDB", "resetPushSceneGroupCount", "savePushSceneGroupCountToDB", "savePushSceneLastShownTime", "updateConfig", "json", "Lorg/json/JSONObject;", "PushGuideComponent", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PushGuideManager {
    public static /* synthetic */ Interceptable $ic;
    public static final PushGuideManager a;
    public static final String b;
    public static PushSceneConfig c;
    public static final HashMap<String, yfa> d;
    public static ufa e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Inject(force = false)
        public final qf1<yfa> a;

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                of1 b = of1.b();
                this.a = b;
                b.a(new zfa());
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            b();
        }

        public final qf1<yfa> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (qf1) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends ju5<ufa> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ju5
        /* renamed from: a */
        public ufa doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                da<String> l = b05.l("tb.push_scene_group_cache");
                if (l != null) {
                    str = l.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return ufa.c.b(str);
            }
            return (ufa) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends ju5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            da<String> l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l = b05.l("tb.push_scene_group_cache")) != null) {
                l.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ju5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends ju5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = PushGuideManager.e.g();
                da<String> l = b05.l("tb.push_scene_group_cache");
                if (l != null) {
                    l.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ju5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    static {
        InterceptResult invokeClinit;
        List<yfa> list;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1248819255, "Lcom/baidu/tieba/push/PushGuideManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1248819255, "Lcom/baidu/tieba/push/PushGuideManager;");
                return;
            }
        }
        a = new PushGuideManager();
        b = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-service/pushGuidePopup?customfullscreen=1&nonavigationbar=1";
        d = new HashMap<>();
        String dateStringDay = rd.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        e = new ufa(dateStringDay, new ArrayList());
        u45.d("key_sp_push_strategy_new", null, AnonymousClass1.INSTANCE);
        qf1<yfa> a2 = new a().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (yfa it : list) {
                HashMap<String, yfa> hashMap = d;
                String h = it.h();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put(h, it);
            }
        }
    }

    public PushGuideManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return NotificationManagerCompat.from(TbadkApplication.getInst()).areNotificationsEnabled();
        }
        return invokeV.booleanValue;
    }

    public static final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            nu5.b(new b(), new ot5() { // from class: com.baidu.tieba.qfa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ot5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        PushGuideManager.q((ufa) obj);
                    }
                }
            });
        }
    }

    public static final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            e.e();
            nu5.b(new c(), null);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ofa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PushGuideManager.p();
                    }
                }
            });
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.pfa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PushGuideManager.s();
                    }
                }
            });
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nu5.b(new d(), null);
        }
    }

    @JvmStatic
    public static final yfa j(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            return d.get(scene);
        }
        return (yfa) invokeL.objValue;
    }

    @JvmStatic
    @MainThread
    public static final void m(String scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, scene) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            a.u(scene);
            if (c != null) {
                a.n(scene);
            }
        }
    }

    public final vfa h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (vfa vfaVar : e.b()) {
                if (vfaVar.a() == i) {
                    return vfaVar;
                }
            }
            return null;
        }
        return (vfa) invokeI.objValue;
    }

    public final long k(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            return sharedPrefHelper.getLong("key_scene_shown_prefix_" + scene, 0L);
        }
        return invokeL.longValue;
    }

    public final void n(String str) {
        PushSceneGroup g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (g = g(str)) != null) {
            e.d(g.getGroupNo());
            a.t();
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putLong("key_scene_shown_prefix_" + str, System.currentTimeMillis());
        }
    }

    public final void v(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            String configJson = json.optString("push_strategy_new");
            u45.g("key_sp_push_strategy_new", configJson);
            Intrinsics.checkNotNullExpressionValue(configJson, "configJson");
            c = (PushSceneConfig) DataExt.toEntityNullable(configJson, PushSceneConfig.class);
            o();
        }
    }

    @JvmStatic
    @MainThread
    public static final boolean e(String scene) {
        InterceptResult invokeL;
        vfa h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!e.c()) {
                a.r();
            }
            if (!a.f(scene)) {
                return false;
            }
            PushSceneGroup g = a.g(scene);
            if (g != null && (h = a.h(g.getGroupNo())) != null && h.b() >= g.getLimit()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final void q(ufa ufaVar) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, ufaVar) == null) {
            if (ufaVar != null && !ufaVar.c()) {
                a.r();
                return;
            }
            ufa ufaVar2 = e;
            if (ufaVar == null || (dateStringDay = ufaVar.a()) == null) {
                dateStringDay = rd.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            ufaVar2.f(dateStringDay);
            ufaVar2.b().clear();
            if (ufaVar != null) {
                ufaVar2.b().addAll(ufaVar.b());
            }
        }
    }

    @JvmStatic
    public static final PushSceneItem l(String scene) {
        InterceptResult invokeL;
        List<PushSceneItem> scenes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            PushSceneConfig pushSceneConfig = c;
            if (pushSceneConfig != null && (scenes = pushSceneConfig.getScenes()) != null) {
                for (PushSceneItem pushSceneItem : scenes) {
                    if (Intrinsics.areEqual(pushSceneItem.getSceneName(), scene)) {
                        return pushSceneItem;
                    }
                }
                return null;
            }
            return null;
        }
        return (PushSceneItem) invokeL.objValue;
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PushSceneItem l = l(str);
            if (l == null) {
                return false;
            }
            long k = k(str);
            if (k > 0 && System.currentTimeMillis() - k < TimeUnit.HOURS.toMillis(l.getPeriod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final PushSceneGroup g(String str) {
        InterceptResult invokeL;
        List<PushSceneGroup> groups;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PushSceneConfig pushSceneConfig = c;
            if (pushSceneConfig != null && (groups = pushSceneConfig.getGroups()) != null) {
                for (PushSceneGroup pushSceneGroup : groups) {
                    if (pushSceneGroup.getGroupList().contains(str)) {
                        return pushSceneGroup;
                    }
                }
                return null;
            }
            return null;
        }
        return (PushSceneGroup) invokeL.objValue;
    }

    public final String i(String scene) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            PushSceneItem l = l(scene);
            if (l == null || !l.isHitNewStyle()) {
                return null;
            }
            String h5DialogUrl = l.getH5DialogUrl();
            if (h5DialogUrl == null) {
                PushSceneConfig pushSceneConfig = c;
                if (pushSceneConfig != null) {
                    h5DialogUrl = pushSceneConfig.getH5DialogUrl();
                } else {
                    h5DialogUrl = null;
                }
            }
            if (h5DialogUrl != null && h5DialogUrl.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                h5DialogUrl = b;
            }
            if (!StringsKt__StringsKt.contains$default((CharSequence) h5DialogUrl, (CharSequence) BaseWebViewActivity.CUSTOM_FULL_SCREEN_EQUAL, false, 2, (Object) null)) {
                h5DialogUrl = UrlUtils.appendParam(h5DialogUrl, BaseWebViewActivity.CUSTOM_FULL_SCREEN, "1");
            }
            Intrinsics.checkNotNull(h5DialogUrl);
            if (!StringsKt__StringsKt.contains$default((CharSequence) h5DialogUrl, (CharSequence) "nonavigationbar=", false, 2, (Object) null)) {
                return UrlUtils.appendParam(h5DialogUrl, BaseWebViewActivity.KEY_NO_NAVIGATIONBAR, "1");
            }
            return h5DialogUrl;
        }
        return (String) invokeL.objValue;
    }
}
