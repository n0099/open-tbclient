package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void A(String str, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            b(ClogBuilder.Page.WELFARETAIL, ClogBuilder.LogType.FREE_SHOW, str, null, ext1, ext2, null, null, 200, null);
        }
    }

    public static final void B(String str, String type, String coin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, type, coin) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            b(null, ClogBuilder.LogType.REWARD_SHOW_TASK, str, null, type, coin, null, null, 201, null);
        }
    }

    public static final void c(String str, String type, String coin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, type, coin) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            b(null, ClogBuilder.LogType.REWARD_ACTIVATE_TASK, str, null, type, coin, null, null, 201, null);
        }
    }

    public static final void e(String str, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            b(null, ClogBuilder.LogType.CHECK, str, null, ext1, ext2, null, null, 201, null);
        }
    }

    public static final void l(String str, String ext1, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, str, ext1, str2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            ClogBuilder.LogType logType = ClogBuilder.LogType.REWARD_COMPLETE_TASK;
            if (str2 == null) {
                str2 = "";
            }
            b(null, logType, str, null, ext1, str2, null, null, 201, null);
        }
    }

    public static final void p(String str, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            b(null, ClogBuilder.LogType.REWARD_COIN_FAIL, str, null, ext1, ext2, null, null, 201, null);
        }
    }

    public static final void a(ClogBuilder.Page page, ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{page, logType, str, str2, str3, str4, str5, str6}) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str2);
            clogBuilder.u(page);
            clogBuilder.p(str);
            clogBuilder.k(str3);
            clogBuilder.l(str4);
            clogBuilder.m(str5);
            clogBuilder.n(str6);
            w31.e(clogBuilder);
        }
    }

    public static /* synthetic */ void b(ClogBuilder.Page page, ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        ClogBuilder.Page page2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        if ((i & 1) != 0) {
            page2 = ClogBuilder.Page.WELFAREMAXLP;
        } else {
            page2 = page;
        }
        if ((i & 8) != 0) {
            str7 = "";
        } else {
            str7 = str2;
        }
        if ((i & 16) != 0) {
            str8 = "";
        } else {
            str8 = str3;
        }
        if ((i & 32) != 0) {
            str9 = "";
        } else {
            str9 = str4;
        }
        if ((i & 64) != 0) {
            str10 = "";
        } else {
            str10 = str5;
        }
        if ((i & 128) != 0) {
            str11 = "";
        } else {
            str11 = str6;
        }
        a(page2, logType, str, str7, str8, str9, str10, str11);
    }

    public static final void d(String str, String coin, String sessionInfo, String upperLimit, String videoDownloadCoin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, coin, sessionInfo, upperLimit, videoDownloadCoin) == null) {
            Intrinsics.checkNotNullParameter(coin, "coin");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(upperLimit, "upperLimit");
            Intrinsics.checkNotNullParameter(videoDownloadCoin, "videoDownloadCoin");
            b(null, ClogBuilder.LogType.FREE_SHOW, str, "popper", coin, sessionInfo, upperLimit, videoDownloadCoin, 1, null);
        }
    }

    public static final void f(sr0 model) {
        ClogBuilder.Page page;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (model.q()) {
                page = ClogBuilder.Page.WELFAREIMAGELP;
            } else {
                page = ClogBuilder.Page.WELFAREMAXLP;
            }
            b(page, ClogBuilder.LogType.CLICK, model.f.d, "arrow", null, null, null, null, 240, null);
            ni0.b(model.e);
        }
    }

    public static final void m(sr0 sr0Var) {
        String str;
        mr0 mr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, sr0Var) == null) {
            ClogBuilder.Page page = ClogBuilder.Page.WELFAREROTATION;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            String str2 = ClogBuilder.Area.HOTAREA.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.HOTAREA.type");
            List<MonitorUrl> list = null;
            if (sr0Var != null && (mr0Var = sr0Var.f) != null) {
                str = mr0Var.d;
            } else {
                str = null;
            }
            b(page, logType, str, str2, null, null, null, null, 240, null);
            if (sr0Var != null) {
                list = sr0Var.e;
            }
            ni0.b(list);
        }
    }

    public static final void w(sr0 sr0Var) {
        String str;
        mr0 mr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, sr0Var) == null) {
            ClogBuilder.Page page = ClogBuilder.Page.WELFAREROTATION;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            String str2 = ClogBuilder.Area.SHAKE.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.SHAKE.type");
            List<MonitorUrl> list = null;
            if (sr0Var != null && (mr0Var = sr0Var.f) != null) {
                str = mr0Var.d;
            } else {
                str = null;
            }
            b(page, logType, str, str2, null, null, null, null, 240, null);
            if (sr0Var != null) {
                list = sr0Var.e;
            }
            ni0.b(list);
        }
    }

    public static final void y(sr0 model) {
        ClogBuilder.Page page;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (model.q()) {
                page = ClogBuilder.Page.WELFAREIMAGELP;
            } else {
                page = ClogBuilder.Page.WELFAREMAXLP;
            }
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            String str = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.SWIPE_UP.type");
            b(page, logType, model.f.d, str, null, null, null, null, 240, null);
            ni0.b(model.e);
        }
    }

    public static final void g(String str, String type, String coin, String sessionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, str, type, coin, sessionInfo) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            b(null, ClogBuilder.LogType.REWARD_COMPLETE_TASK, str, null, type, coin, sessionInfo, null, Cea708Decoder.COMMAND_DSW, null);
        }
    }

    public static final void i(String str, String type, String str2, String str3) {
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, str, type, str2, str3) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            ClogBuilder.Page page = ClogBuilder.Page.WELFAREPANEL;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_SHOW;
            if (str2 == null) {
                str4 = "";
            } else {
                str4 = str2;
            }
            if (str3 == null) {
                str5 = "";
            } else {
                str5 = str3;
            }
            b(page, logType, str, null, null, type, str4, str5, 24, null);
        }
    }

    public static /* synthetic */ void h(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "";
        }
        g(str, str2, str3, str4);
    }

    public static final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            String str2 = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.DOWN_ARROW.type");
            b(null, logType, str, str2, null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
        }
    }

    public static final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            b(ClogBuilder.Page.WELFAREROTATION, ClogBuilder.LogType.FREE_SHOW, str, null, null, null, null, null, GDiffPatcher.DATA_INT, null);
        }
    }

    public static final void o(sr0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            ClogBuilder.Page page = ClogBuilder.Page.WELFAREMAXLP;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            String str = ClogBuilder.Area.REWARD_FORM.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.REWARD_FORM.type");
            b(page, logType, model.f.d, str, null, null, null, null, 240, null);
        }
    }

    public static final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            String str2 = ClogBuilder.Area.AD_BLANK.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.AD_BLANK.type");
            b(null, logType, str, str2, null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
        }
    }

    public static final void x(sr0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            b(null, ClogBuilder.LogType.CLICK, model.f.d, "sv_button", null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
            ni0.b(model.e);
        }
    }

    public static final void z(sr0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            ClogBuilder.Page page = ClogBuilder.Page.WELFAREIMAGELP;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            String str = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.SWIPE_UP.type");
            b(page, logType, model.f.d, str, null, null, null, null, 240, null);
        }
    }

    public static final void k(String str, String ext1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, ext1) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            b(null, ClogBuilder.LogType.REWARD_COIN_FAIL, str, null, ext1, null, null, null, 233, null);
        }
    }

    public static final void r(String str, String type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, type) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            b(null, ClogBuilder.LogType.REWARD_TOKEN_FAIL, str, null, type, null, null, null, 233, null);
        }
    }

    public static final void s(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            b(null, logType, str, "close", str2, null, null, null, 225, null);
        }
    }

    public static /* synthetic */ void q(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        p(str, str2, str3);
    }

    public static final void u(String daArea, ClogBuilder.LogType logType, String str, String ext, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{daArea, logType, str, ext, ext1, ext2}) == null) {
            Intrinsics.checkNotNullParameter(daArea, "daArea");
            Intrinsics.checkNotNullParameter(logType, "logType");
            Intrinsics.checkNotNullParameter(ext, "ext");
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            b(null, logType, ext, daArea, ext1, ext2, null, null, 193, null);
            if (logType == ClogBuilder.LogType.CLICK && !TextUtils.isEmpty(str)) {
                x31.b(str);
            }
        }
    }

    public static final void v(sr0 model, String sessionInfo) {
        ClogBuilder.Page page;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, model, sessionInfo) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            if (model.q()) {
                page = ClogBuilder.Page.WELFAREIMAGELP;
            } else {
                page = ClogBuilder.Page.WELFAREMAXLP;
            }
            b(page, ClogBuilder.LogType.SHOW, model.f.d, null, null, String.valueOf(model.g().s()), sessionInfo, null, Cea708Decoder.COMMAND_DF0, null);
            ni0.c(model.e);
        }
    }
}
