package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.i95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class la5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<i95> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface d {
        void onDismiss();
    }

    /* loaded from: classes5.dex */
    public static class a implements i95.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.i95.j
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = la5.a = false;
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements i95.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public b(HotEventData hotEventData) {
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

        @Override // com.baidu.tieba.i95.h
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                la5.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements i95.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public c(HotEventData hotEventData) {
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

        @Override // com.baidu.tieba.i95.i
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                la5.f();
            }
        }
    }

    public static i95 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            WeakReference<i95> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (i95) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_CLICK));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_SHOW));
        }
    }

    public static void c(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hotEventData) == null) {
            Context curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
            if (curGlobalActivity != null && !(curGlobalActivity instanceof TbPageContextSupport)) {
                return;
            }
            if (curGlobalActivity == null) {
                curGlobalActivity = TbadkCoreApplication.getInst();
            }
            if (hotEventData != null && hotEventData.getWindowType() == 3) {
                yc9.a(curGlobalActivity, new String[]{hotEventData.getSchemaUrl()});
            }
        }
    }

    public static i95 h(HotEventData hotEventData, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, hotEventData, dVar)) == null) {
            if (!TextUtils.isEmpty(hotEventData.getBtnSchema()) && !TextUtils.isEmpty(hotEventData.getTitle())) {
                if (hotEventData.getWindowType() != 1 && hotEventData.getWindowType() != 2) {
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (TbadkCoreApplication.getInst().isMainProcess(true) && currentActivity == null) {
                    HotEvent hotEvent = new HotEvent();
                    hotEvent.hotEventData = hotEventData;
                    hotEventData.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                    bj5.i(hotEvent);
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                    TbadkCoreApplication.getInst().setSkinType(hotEventData.getSkinType());
                }
                if (a) {
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                if (hotEventData.getWindowType() == 1) {
                    if (System.currentTimeMillis() - p45.m().o("key_hot_event_tip_show_time", 0L) <= 600000) {
                        if (dVar != null) {
                            dVar.onDismiss();
                        }
                        return null;
                    }
                }
                if (k95.c() && k95.b() != null) {
                    k95.b().t();
                }
                if (TextUtils.isEmpty(hotEventData.getDesc())) {
                    hotEventData.setDesc(TbadkApplication.getInst().getString(R.string.hot_event_desc_text));
                }
                if (TextUtils.isEmpty(hotEventData.getBtnText())) {
                    hotEventData.setBtnText(TbadkApplication.getInst().getString(R.string.hot_event_btn_text));
                } else {
                    String btnText = hotEventData.getBtnText();
                    if (StringHelper.getChineseAndEnglishLength(btnText) > 8) {
                        hotEventData.setBtnText(StringHelper.cutChineseAndEnglishWithEmoji(btnText, 8, null));
                    }
                }
                i95.g gVar = new i95.g(currentActivity);
                gVar.m(hotEventData.getBtnText());
                gVar.u(hotEventData.getTitle());
                gVar.o(hotEventData.getDesc());
                gVar.q(hotEventData.getIcon());
                gVar.n(R.drawable.hot_event_icon);
                gVar.p(5000);
                gVar.s(new c(hotEventData));
                gVar.r(new b(hotEventData));
                gVar.t(new a(dVar));
                i95 l = gVar.l();
                l.p();
                b = new WeakReference<>(l);
                g();
                if (hotEventData.getWindowType() == 1) {
                    p45.m().A("key_hot_event_tip_show_time", System.currentTimeMillis());
                }
                a = true;
                return l;
            }
            if (dVar != null) {
                dVar.onDismiss();
            }
            return null;
        }
        return (i95) invokeLL.objValue;
    }

    public static void i(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hotEventData) == null) {
            c(hotEventData);
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            if (LooperBlockSwitch.getIsOn()) {
                if (hotEventData != null && !TextUtils.isEmpty(hotEventData.getBtnSchema()) && !TextUtils.isEmpty(hotEventData.getTitle())) {
                    z05.o(currentActivity, "sEventDialog", new JSONObject());
                    return;
                }
                return;
            }
            t05.g(Collections.singletonList(new u05(currentActivity, hotEventData)));
        }
    }
}
