package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tieba.k25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
/* loaded from: classes4.dex */
public class m35 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface d {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public final class a implements k25.j {
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

        @Override // com.baidu.tieba.k25.j
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = m35.a = false;
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements k25.h {
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

        @Override // com.baidu.tieba.k25.h
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                m35.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements k25.i {
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

        @Override // com.baidu.tieba.k25.i
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                m35.e();
            }
        }
    }

    public static void h(HotEventData hotEventData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, hotEventData) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        gv4.g(Collections.singletonList(new hv4(currentActivity, hotEventData)));
    }

    public static k25 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            WeakReference weakReference = b;
            if (weakReference != null) {
                return (k25) weakReference.get();
            }
            return null;
        }
        return (k25) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_CLICK));
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_SHOW));
        }
    }

    public static k25 g(HotEventData hotEventData, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, hotEventData, dVar)) == null) {
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
                    ra5.i(hotEvent);
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
                    if (System.currentTimeMillis() - ux4.k().m("key_hot_event_tip_show_time", 0L) <= 600000) {
                        if (dVar != null) {
                            dVar.onDismiss();
                        }
                        return null;
                    }
                }
                if (m25.c() && m25.b() != null) {
                    m25.b().t();
                }
                if (TextUtils.isEmpty(hotEventData.getDesc())) {
                    hotEventData.setDesc(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088d));
                }
                if (TextUtils.isEmpty(hotEventData.getBtnText())) {
                    hotEventData.setBtnText(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088c));
                } else {
                    String btnText = hotEventData.getBtnText();
                    if (StringHelper.getChineseAndEnglishLength(btnText) > 8) {
                        hotEventData.setBtnText(StringHelper.cutChineseAndEnglishWithEmoji(btnText, 8, null));
                    }
                }
                k25.g gVar = new k25.g(currentActivity);
                gVar.m(hotEventData.getBtnText());
                gVar.u(hotEventData.getTitle());
                gVar.o(hotEventData.getDesc());
                gVar.q(hotEventData.getIcon());
                gVar.n(R.drawable.obfuscated_res_0x7f0805d9);
                gVar.p(5000);
                gVar.s(new c(hotEventData));
                gVar.r(new b(hotEventData));
                gVar.t(new a(dVar));
                k25 l = gVar.l();
                l.p();
                b = new WeakReference(l);
                f();
                if (hotEventData.getWindowType() == 1) {
                    ux4.k().x("key_hot_event_tip_show_time", System.currentTimeMillis());
                }
                a = true;
                return l;
            }
            if (dVar != null) {
                dVar.onDismiss();
            }
            return null;
        }
        return (k25) invokeLL.objValue;
    }
}
