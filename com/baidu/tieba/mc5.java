package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tieba.an6;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.jb5;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes6.dex */
public class mc5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<jb5> b;
    public static WeakReference<SpriteAnimationTipManager> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String b = bj5.b("", 0);
                yk8 defaultLog = DefaultLog.getInstance();
                defaultLog.b("HotEventTip", "精灵动画提示控件：精灵点击跳转，scheme" + b);
                if (b.startsWith("tiebaapp://router/portal")) {
                    mc5.d(b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an6.e a;

        public b(an6.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean unused = mc5.a = false;
                DefaultLog.getInstance().b("HotEventTip", "精灵动画提示控件：动画执行完成，触发弹窗管理器监听");
                this.a.onDismiss();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;
        public final /* synthetic */ SpriteAnimationTipManager b;

        public c(HotEventData hotEventData, SpriteAnimationTipManager spriteAnimationTipManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotEventData, spriteAnimationTipManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotEventData;
            this.b = spriteAnimationTipManager;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpriteAnimationTipManager spriteAnimationTipManager = this.b;
                if (spriteAnimationTipManager != null) {
                    spriteAnimationTipManager.i();
                }
                mc5.n();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                mc5.d(this.a.getBtnSchema());
                mc5.n();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                mc5.d(this.a.getBtnSchema());
                mc5.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements jb5.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an6.e a;

        public d(an6.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.jb5.j
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = mc5.a = false;
                an6.e eVar = this.a;
                if (eVar != null) {
                    eVar.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements jb5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public e(HotEventData hotEventData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotEventData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotEventData;
        }

        @Override // com.baidu.tieba.jb5.h
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mc5.d(this.a.getBtnSchema());
                mc5.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements jb5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public f(HotEventData hotEventData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotEventData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotEventData;
        }

        @Override // com.baidu.tieba.jb5.i
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mc5.d(this.a.getBtnSchema());
                mc5.n();
            }
        }
    }

    public static void q(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, hotEventData) == null) && hotEventData != null && hotEventData.getWindowType() == 1) {
            o65.m().A("key_hot_event_tip_show_time", System.currentTimeMillis());
        }
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            a = z;
        }
    }

    public static void u(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, hotEventData) == null) {
            g(hotEventData);
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            u25.g(Collections.singletonList(new v25(currentActivity, hotEventData)));
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            a = false;
            SpriteAnimationTipManager k = k();
            if (k != null) {
                k.i();
            }
            c = null;
        }
    }

    public static jb5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            WeakReference<jb5> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (jb5) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static SpriteAnimationTipManager k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            WeakReference<SpriteAnimationTipManager> weakReference = c;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (SpriteAnimationTipManager) invokeV.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a = false;
            SpriteAnimationTipManager k = k();
            if (k != null) {
                k.p();
            }
            c = null;
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_CLICK));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_SHOW));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            yk8 defaultLog = DefaultLog.getInstance();
            defaultLog.b("HotEventTip", "精灵动画提示控件：气泡点击跳转，scheme" + str);
            UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{str});
        }
    }

    public static void r(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, hotEventData) == null) {
            if (TextUtils.isEmpty(hotEventData.getDesc())) {
                hotEventData.setDesc(TbadkApplication.getInst().getString(R.string.hot_event_desc_text));
            }
            if (TextUtils.isEmpty(hotEventData.getBtnText())) {
                hotEventData.setBtnText(TbadkApplication.getInst().getString(R.string.hot_event_btn_text));
                return;
            }
            String btnText = hotEventData.getBtnText();
            if (StringHelper.getChineseAndEnglishLength(btnText) > 8) {
                hotEventData.setBtnText(StringHelper.cutChineseAndEnglishWithEmoji(btnText, 8, null));
            }
        }
    }

    @NonNull
    public static FrameLayout.LayoutParams e(Activity activity) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            if (zk6.b(activity, "com.baidu.tieba.frs.FrsActivity")) {
                i = R.dimen.tbds95;
            } else {
                i = R.dimen.tbds141;
            }
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(i);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    public static void g(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, hotEventData) == null) {
            Context curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
            if (curGlobalActivity != null && !(curGlobalActivity instanceof TbPageContextSupport)) {
                return;
            }
            if (curGlobalActivity == null) {
                curGlobalActivity = TbadkCoreApplication.getInst();
            }
            if (hotEventData != null && hotEventData.getWindowType() == 3) {
                hi9.a(curGlobalActivity, new String[]{hotEventData.getSchemaUrl()});
            }
        }
    }

    public static SpriteBottomTipView f(HotEventData hotEventData, Activity activity, SpriteAnimationTipManager spriteAnimationTipManager) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, hotEventData, activity, spriteAnimationTipManager)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.c(hotEventData.getBtnText());
            aVar.i(hotEventData.getTitle());
            aVar.d(hotEventData.getDesc());
            aVar.f(hotEventData.getIcon());
            aVar.h(hotEventData.isShowCloseBtn());
            aVar.e(R.drawable.hot_event_icon);
            if (hotEventData.isUseRightBg()) {
                i = R.drawable.funny_sprite_tip_bg_right;
            } else {
                i = R.drawable.funny_sprite_tip_bg_left;
            }
            aVar.b(Integer.valueOf(i));
            aVar.g(new c(hotEventData, spriteAnimationTipManager));
            return aVar.a();
        }
        return (SpriteBottomTipView) invokeLLL.objValue;
    }

    public static boolean m(HotEventData hotEventData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, hotEventData)) == null) {
            if (!TextUtils.isEmpty(hotEventData.getBtnSchema()) && !TextUtils.isEmpty(hotEventData.getTitle())) {
                if (hotEventData.getWindowType() != 1 && hotEventData.getWindowType() != 2) {
                    yk8 defaultLog = DefaultLog.getInstance();
                    defaultLog.b("HotEventTip", "S级事件弹窗无法展示，WindowType不对" + hotEventData.getWindowType());
                    return false;
                }
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (TbadkCoreApplication.getInst().isMainProcess(true) && currentActivity == null) {
                    HotEvent hotEvent = new HotEvent();
                    hotEvent.hotEventData = hotEventData;
                    hotEventData.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                    el5.i(hotEvent);
                    DefaultLog.getInstance().b("HotEventTip", "S级事件弹窗无法展示，Activity为空");
                    return false;
                }
                if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                    TbadkCoreApplication.getInst().setSkinType(hotEventData.getSkinType());
                }
                if (a) {
                    DefaultLog.getInstance().b("HotEventTip", "S级事件弹窗无法展示，正在展示");
                    return false;
                }
                if (hotEventData.getWindowType() == 1) {
                    if (System.currentTimeMillis() - o65.m().o("key_hot_event_tip_show_time", 0L) <= 600000) {
                        DefaultLog.getInstance().b("HotEventTip", "S级事件弹窗无法展示，十分钟内只弹一次");
                        return false;
                    }
                }
                return true;
            }
            yk8 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.b("HotEventTip", "S级事件弹窗无法展示，数据不合法 schema:" + hotEventData.getBtnSchema() + " title:" + hotEventData.getTitle());
            return false;
        }
        return invokeL.booleanValue;
    }

    public static jb5 p(HotEventData hotEventData, an6.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, hotEventData, eVar)) == null) {
            if (!m(hotEventData)) {
                eVar.onDismiss();
                return null;
            }
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                eVar.onDismiss();
                return null;
            }
            if (lb5.c() && lb5.b() != null) {
                lb5.b().t();
            }
            r(hotEventData);
            jb5.g gVar = new jb5.g(currentActivity);
            gVar.m(hotEventData.getBtnText());
            gVar.u(hotEventData.getTitle());
            gVar.o(hotEventData.getDesc());
            gVar.q(hotEventData.getIcon());
            gVar.n(R.drawable.hot_event_icon);
            gVar.p(5000);
            gVar.s(new f(hotEventData));
            gVar.r(new e(hotEventData));
            gVar.t(new d(eVar));
            jb5 l = gVar.l();
            l.p();
            b = new WeakReference<>(l);
            o();
            q(hotEventData);
            a = true;
            return l;
        }
        return (jb5) invokeLL.objValue;
    }

    public static SpriteAnimationTipManager t(HotEventData hotEventData, an6.e eVar) {
        InterceptResult invokeLL;
        boolean z;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, hotEventData, eVar)) == null) {
            if (!m(hotEventData)) {
                if (eVar != null) {
                    eVar.onDismiss();
                }
                return null;
            }
            if (lb5.c() && lb5.b() != null) {
                lb5.b().t();
            }
            r(hotEventData);
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                if (currentActivity instanceof hv9) {
                    DefaultLog.getInstance().b("HotEventTip", "精灵动画提示控件：通知首页展示S级事件");
                    in6.b().b(new hp9(new ip9(hotEventData, eVar), 1));
                    return null;
                }
                if (zk6.b(currentActivity, "com.baidu.tieba.frs.FrsActivity")) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921769));
                }
                SpriteAnimationTipManager spriteAnimationTipManager = new SpriteAnimationTipManager(currentActivity);
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = "funny_sprite_appear_day";
                } else {
                    str = "funny_sprite_appear_dark";
                }
                qn6 a2 = bj5.a(FunnySpriteResDownloadUtil.i(str, "rush_res", true), false, 2);
                if (z) {
                    str2 = "funny_sprite_show_day";
                } else {
                    str2 = "funny_sprite_show_dark";
                }
                qn6 a3 = bj5.a(FunnySpriteResDownloadUtil.i(str2, "rush_res", true), true, 2);
                if (z) {
                    str3 = "funny_sprite_exit_day";
                } else {
                    str3 = "funny_sprite_exit_dark";
                }
                spriteAnimationTipManager.u(a2, a3, bj5.a(FunnySpriteResDownloadUtil.i(str3, "rush_res", true), false, 2));
                spriteAnimationTipManager.x(f(hotEventData, currentActivity, spriteAnimationTipManager));
                spriteAnimationTipManager.y(5000L);
                spriteAnimationTipManager.w(0, UtilHelper.getDimenPixelSize(R.dimen.tbds16), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds16));
                spriteAnimationTipManager.s(UtilHelper.getDimenPixelSize(R.dimen.tbds146), UtilHelper.getDimenPixelSize(R.dimen.tbds187));
                spriteAnimationTipManager.t(e(currentActivity));
                spriteAnimationTipManager.v(new a());
                spriteAnimationTipManager.r(new b(eVar));
                spriteAnimationTipManager.z();
                c = new WeakReference<>(spriteAnimationTipManager);
                a = true;
                o();
                q(hotEventData);
                return spriteAnimationTipManager;
            }
            DefaultLog.getInstance().b("HotEventTip", "精灵动画提示控件：当前页面Activity为空或者正在关闭");
            if (eVar != null) {
                eVar.onDismiss();
            }
            return null;
        }
        return (SpriteAnimationTipManager) invokeLL.objValue;
    }
}
