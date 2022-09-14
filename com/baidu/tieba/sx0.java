package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.model.HistoryCache;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.nm0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public class sx0 extends ox0 {
    public static /* synthetic */ Interceptable $ic;
    public static final HistoryCache e;
    public transient /* synthetic */ FieldHolder $fh;
    public ax0 d;

    /* loaded from: classes5.dex */
    public static final class a implements nm0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdVideoSeries a;
        public final /* synthetic */ BdVideoSeries b;

        public a(BdVideoSeries bdVideoSeries, sx0 sx0Var, BdVideoSeries bdVideoSeries2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoSeries, sx0Var, bdVideoSeries2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdVideoSeries;
            this.b = bdVideoSeries2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948166654, "Lcom/baidu/tieba/sx0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948166654, "Lcom/baidu/tieba/sx0;");
                return;
            }
        }
        e = new HistoryCache();
    }

    public sx0() {
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

    public final void A(BdVideoSeries bdVideoSeries) {
        oq0 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) || (i = i()) == null) {
            return;
        }
        dx0 videoTask = i.K();
        Intrinsics.checkNotNullExpressionValue(videoTask, "videoTask");
        p(videoTask, bdVideoSeries);
        if (i.Z() || i.Y() || i.W()) {
            z(i);
        }
    }

    @Override // com.baidu.tieba.ox0, com.baidu.tieba.qx0
    public void g(ht0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.g(event);
            String c = event.c();
            int hashCode = c.hashCode();
            if (hashCode != -1026415353) {
                if (hashCode == 1671611006 && c.equals("plugin_event_load_player_history")) {
                    Object f = event.f(1);
                    w((BdVideoSeries) (f instanceof BdVideoSeries ? f : null));
                }
            } else if (c.equals("plugin_event_save_player_history")) {
                Object f2 = event.f(1);
                BdVideoSeries bdVideoSeries = (BdVideoSeries) (f2 instanceof BdVideoSeries ? f2 : null);
                if (bdVideoSeries != null) {
                    y(bdVideoSeries);
                }
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{4, 5, 7} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ox0, com.baidu.tieba.iu0
    public void h(PlayerStatus status, PlayerStatus old) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, status, old) == null) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(old, "old");
            super.h(status, old);
            int i = rx0.$EnumSwitchMapping$0[status.ordinal()];
            if (i == 1) {
                z(i());
            } else if (i != 2) {
            } else {
                r();
            }
        }
    }

    @Override // com.baidu.tieba.ox0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.m();
            this.d = null;
        }
    }

    public final void p(dx0 dx0Var, BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dx0Var, bdVideoSeries) == null) {
            dx0Var.d = Math.max(0, bdVideoSeries.getPosition());
            dx0Var.f = Math.max(0, bdVideoSeries.getPositionMs());
            int max = Math.max(0, bdVideoSeries.getDuration());
            dx0Var.e = max;
            if (dx0Var.d > max) {
                dx0Var.e = 0;
                dx0Var.d = 0;
                dx0Var.f = 0;
            }
        }
    }

    public final void r() {
        oq0 i;
        BdVideoSeries videoSeries;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i = i()) == null || (videoSeries = i.o1()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(videoSeries, "videoSeries");
        zw0.b(videoSeries, 0, videoSeries.getDurationMs());
        y(videoSeries);
    }

    public final boolean s(BdVideoSeries bdVideoSeries, String str) {
        InterceptResult invokeLL;
        ax0 ax0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries, str)) == null) {
            ax0 findCache = e.findCache(str, bdVideoSeries.getVid());
            int positionMs = bdVideoSeries.getPositionMs();
            if (findCache == null || positionMs != findCache.g()) {
                ax0 ax0Var2 = this.d;
                return Intrinsics.areEqual(ax0Var2 != null ? ax0Var2.e() : null, bdVideoSeries.getVid()) && (ax0Var = this.d) != null && ax0Var.g() == bdVideoSeries.getPositionMs();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ox0
    /* renamed from: t */
    public oq0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            nq0 i = super.i();
            if (!(i instanceof oq0)) {
                i = null;
            }
            return (oq0) i;
        }
        return (oq0) invokeV.objValue;
    }

    public String u(BdVideoSeries videoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, videoSeries)) == null) {
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            String a2 = ax0.a(selectedVideo != null ? selectedVideo.getSourceUrl() : null);
            return a2 != null ? a2 : "";
        }
        return (String) invokeL.objValue;
    }

    public final boolean v(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdVideoSeries)) == null) ? bdVideoSeries.getStartPosition() >= 0 : invokeL.booleanValue;
    }

    public final void w(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdVideoSeries) == null) || i() == null || bdVideoSeries == null) {
            return;
        }
        if (v(bdVideoSeries)) {
            bdVideoSeries.setPosition(bdVideoSeries.getStartPosition());
            bdVideoSeries.setStartPosition(-1);
            A(bdVideoSeries);
            return;
        }
        String u = u(bdVideoSeries);
        ax0 findCache = e.findCache(u, bdVideoSeries.getVid());
        if (findCache != null) {
            x(findCache, bdVideoSeries);
            A(bdVideoSeries);
            return;
        }
        nm0.b.a().a(u, bdVideoSeries.getVid(), new a(bdVideoSeries, this, bdVideoSeries));
    }

    public void x(ax0 info, BdVideoSeries videoSeries) {
        Integer intOrNull;
        Integer intOrNull2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, info, videoSeries) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
            String f = info.f();
            int i = 0;
            int intValue = (f == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(f)) == null) ? 0 : intOrNull2.intValue();
            String h = info.h();
            int intValue2 = (h == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(h)) == null) ? 0 : intOrNull.intValue();
            if (videoSeries.getDuration() <= 0) {
                videoSeries.setDurationMs(intValue2 * 1000);
            }
            if (intValue <= 0 || intValue != intValue2) {
                i = intValue;
            } else {
                info.q("0");
            }
            if (info.g() > 0) {
                videoSeries.setPositionMs(info.g());
            } else {
                videoSeries.setPositionMs(i * 1000);
            }
            BdVideo selectedVideo = videoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                selectedVideo.setCurrentLength(info.f());
            }
            BdVideo selectedVideo2 = videoSeries.getSelectedVideo();
            if (selectedVideo2 != null) {
                selectedVideo2.setTotalLength(String.valueOf(videoSeries.getDuration()));
            }
        }
    }

    public final void y(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdVideoSeries) == null) {
            qy0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + ") begin, save history" + bdVideoSeries + ".[" + this + ']');
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                Intrinsics.checkNotNullExpressionValue(selectedVideo, "videoSeries.selectedVideo ?: return");
                String u = u(bdVideoSeries);
                if (Intrinsics.areEqual(selectedVideo.getCurrentLength(), "0")) {
                    qy0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), del when currentLength is 0,  history" + bdVideoSeries + ".[" + this + ']');
                    n31.b().b(u, bdVideoSeries.getVid());
                    e.removeCache(u, bdVideoSeries.getVid());
                } else if (s(bdVideoSeries, u)) {
                } else {
                    ax0 info = mt0.a(bdVideoSeries, selectedVideo, selectedVideo.getSourceUrl(), u);
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    if (info.i()) {
                        this.d = info;
                        String vid = bdVideoSeries.getVid();
                        Intrinsics.checkNotNullExpressionValue(vid, "videoSeries.vid");
                        if ((!StringsKt__StringsJVMKt.isBlank(vid)) || (!StringsKt__StringsJVMKt.isBlank(u))) {
                            e.add(info);
                        }
                        qy0.a("savePlayProgress(series@" + System.identityHashCode(bdVideoSeries) + "), info is {" + info + "}.[" + this + ']');
                        n31.b().a(mi0.b(), info, false);
                    }
                }
            }
        }
    }

    public final void z(oq0 oq0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, oq0Var) == null) || oq0Var == null) {
            return;
        }
        qy0.a("seekToTarget(player@" + System.identityHashCode(oq0Var) + "),  position is " + oq0Var.K().f + " ms .[" + this + ']');
        if (oq0Var.K().f > 0) {
            oq0Var.p0(oq0Var.K().f);
        }
    }
}
