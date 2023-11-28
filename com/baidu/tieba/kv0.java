package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public class kv0 extends dv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv0(String kernelType) {
        super(kernelType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kernelType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(kernelType, "kernelType");
        this.h = "";
    }

    @Override // com.baidu.tieba.dv0, com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void k(ks0 event) {
        BdVideoSeries j1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(LayerEvent.ACTION_CHANGE_CLARITY, event.c())) {
                Object f = event.f(31);
                if (!(f instanceof aw0)) {
                    f = null;
                }
                aw0 aw0Var = (aw0) f;
                rp0 y = y();
                if (y != null && (j1 = y.j1()) != null) {
                    Intrinsics.checkNotNullExpressionValue(j1, "this");
                    J0(j1, aw0Var);
                }
            }
            super.k(event);
        }
    }

    public final HashMap<String, String> A0(String str, ClarityUrlList clarityUrlList) {
        InterceptResult invokeLL;
        HashMap<String, String> hashMap;
        ClarityUrlList.c currentClarityUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, clarityUrlList)) == null) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            if (clarityUrlList != null && (currentClarityUrl = clarityUrlList.getCurrentClarityUrl()) != null) {
                hashMap = currentClarityUrl.j();
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                ClarityUrlList.c currentClarityUrl2 = clarityUrlList.getCurrentClarityUrl();
                Intrinsics.checkNotNullExpressionValue(currentClarityUrl2, "clarityUrlList.currentClarityUrl");
                hashMap2.putAll(currentClarityUrl2.j());
            }
            if (!Intrinsics.areEqual(str, "flv") && !Intrinsics.areEqual(str, "yy")) {
                hashMap2.put(CyberPlayerManager.OPT_IS_LIVE_VIDEO, "false");
            } else {
                hashMap2.put(CyberPlayerManager.OPT_IS_LIVE_VIDEO, YYOption.IsLive.VALUE_TRUE);
            }
            return hashMap2;
        }
        return (HashMap) invokeLL.objValue;
    }

    public final void B0(BdVideoSeries bdVideoSeries, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries, i) == null) {
            if (ArraysKt___ArraysKt.contains(new Integer[]{1, 22, 6}, Integer.valueOf(i))) {
                str = "1";
            } else {
                str = "0";
            }
            m0(CyberPlayerManager.OPT_FEED_VIDEO, str);
            m0(CyberPlayerManager.OPT_ENABLE_SEI_DATA_NOTIFICATION, "1");
            m0(CyberPlayerManager.OPT_VIDEO_BPS, String.valueOf(bdVideoSeries.getVideoBps()));
            m0(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE, String.valueOf(bdVideoSeries.getMoovSize()));
        }
    }

    public void J0(BdVideoSeries series, aw0 aw0Var) {
        int i;
        ClarityUrlList.c currentClarityUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, series, aw0Var) == null) {
            Intrinsics.checkNotNullParameter(series, "series");
            if (aw0Var != null) {
                i = aw0Var.d;
            } else {
                i = -1;
            }
            ClarityUrlList clarityList = series.getClarityList();
            if (clarityList != null && (currentClarityUrl = clarityList.getCurrentClarityUrl()) != null) {
                currentClarityUrl.b();
            }
            String str = (aw0Var == null || (str = aw0Var.a) == null) ? "" : "";
            o0(series.getProxy());
            j0(y0(series.getHttpHeader()));
            G0(series.getSelectedVideo(), i);
            E0(series);
            I0(series);
            B0(series, i);
            D0(i, str);
            F0();
            C0();
            H0(series);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ws0 a = ws0.a();
            Intrinsics.checkNotNullExpressionValue(a, "PlayerExperimentManager.get()");
            float b = a.b();
            ws0 a2 = ws0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "PlayerExperimentManager.get()");
            float c = a2.c();
            float f = 0;
            if (b >= f) {
                m0("device_dynamic_score", String.valueOf(b));
            }
            if (c >= f) {
                m0("device_static_score", String.valueOf(c));
            }
        }
    }

    public final void D0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            jx0.a("pcdn is close");
            m0(CyberPlayerManager.OPT_ENABLE_PCDN, "0");
            m0(CyberPlayerManager.OPT_ENABLE_P2P, "0");
        }
    }

    @Override // com.baidu.tieba.dv0
    public void s0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            super.s0(str, z);
        }
    }

    public final void E0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdVideoSeries) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_STAGE_INFO));
            String from = bdVideoSeries.getFrom();
            Intrinsics.checkNotNullExpressionValue(from, "series.from");
            hashMap.put("video_from", from);
            String page = bdVideoSeries.getPage();
            Intrinsics.checkNotNullExpressionValue(page, "series.page");
            hashMap.put("video_page", page);
            String pd = bdVideoSeries.getPd();
            Intrinsics.checkNotNullExpressionValue(pd, "series.pd");
            hashMap.put("video_source", pd);
            if (Intrinsics.areEqual(bdVideoSeries.getFormat(), "flv")) {
                hashMap.put("bd_live", "1");
            } else if (Intrinsics.areEqual(bdVideoSeries.getFormat(), "yy")) {
                hashMap.put("yy_live", "1");
            }
            i0(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    @Override // com.baidu.tieba.dv0, com.baidu.tieba.wu0, com.baidu.tieba.kt0
    public void d(ks0 event) {
        BdVideoSeries j1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c = event.c();
            int hashCode = c.hashCode();
            if (hashCode != -882902390) {
                if (hashCode == 1370689931 && c.equals(PlayerEvent.ACTION_ON_INFO)) {
                    event.g(1);
                }
            } else if (c.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                Object f = event.f(3);
                if (!(f instanceof aw0)) {
                    f = null;
                }
                aw0 aw0Var = (aw0) f;
                rp0 y = y();
                if (y != null && (j1 = y.j1()) != null) {
                    String vid = j1.getVid();
                    Intrinsics.checkNotNullExpressionValue(vid, "vid");
                    this.h = vid;
                    Intrinsics.checkNotNullExpressionValue(j1, "this");
                    J0(j1, aw0Var);
                }
            }
            super.d(event);
        }
    }

    public final HashMap<String, String> y0(String str) {
        InterceptResult invokeL;
        boolean z;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    Object[] array = new Regex("\r\n").split(str, 0).toArray(new String[0]);
                    if (array != null) {
                        for (String str2 : (String[]) array) {
                            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, ":", 0, false, 6, (Object) null);
                            if (indexOf$default > 0 && indexOf$default < str2.length()) {
                                if (str2 != null) {
                                    String substring = str2.substring(0, indexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    int i = indexOf$default + 1;
                                    if (str2 != null) {
                                        String substring2 = str2.substring(i);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                                        hashMap.put(substring, substring2);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                        return hashMap;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                return null;
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dv0, com.baidu.tieba.wu0
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.F();
            this.e.K(hf0.e());
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            m0(CyberPlayerManager.OPT_SR_OPTION, String.valueOf(hq0.c()));
        }
    }

    @Override // com.baidu.tieba.dv0
    public ht0 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ju0 ju0Var = this.e;
            if (ju0Var instanceof lu0) {
                if (ju0Var != null) {
                    return ((lu0) ju0Var).V();
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.player.kernel.CyberVideoKernel");
            }
            return null;
        }
        return (ht0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wu0, com.baidu.tieba.jv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.baidu.tieba.dv0
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.u0();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wu0
    /* renamed from: x0 */
    public rp0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            qp0 y = super.y();
            if (!(y instanceof rp0)) {
                y = null;
            }
            return (rp0) y;
        }
        return (rp0) invokeV.objValue;
    }

    public final String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final void G0(BdVideo bdVideo, int i) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, bdVideo, i) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, String.valueOf(i));
            String str = "";
            hashMap.put(CyberPlayerManager.STAGE_INFO_SOURCE, (bdVideo == null || (r1 = bdVideo.getSourceUrl()) == null) ? "" : "");
            if (bdVideo != null && (title = bdVideo.getTitle()) != null) {
                str = title;
            }
            hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, str);
            i0(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        }
    }

    public final void H0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries) == null) {
            m0(CyberPlayerManager.OPT_VIDEO_BPS, String.valueOf(bdVideoSeries.getVideoBps()));
            m0(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE, String.valueOf(bdVideoSeries.getMoovSize()));
        }
    }

    public final void I0(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdVideoSeries) == null) {
            ClarityUrlList clarityList = bdVideoSeries.getClarityList();
            String format = bdVideoSeries.getFormat();
            q0(format, A0(format, clarityList));
        }
    }
}
