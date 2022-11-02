package com.baidu.tieba;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiePlusStatic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class v47 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ThirdStatisticHelper.TiePlusStatisCallback {
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

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && v47.a != null) {
                v47.a.put(str, "3");
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.TiePlusStatisCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && v47.a != null) {
                v47.a.put(str, "2");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190896, "Lcom/baidu/tieba/v47;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190896, "Lcom/baidu/tieba/v47;");
                return;
            }
        }
        a = new ArrayMap<>();
    }

    @Deprecated
    public static void b(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, threadData, str, i) == null) {
            c(threadData, str, i, 1);
        }
    }

    public static void c(ThreadData threadData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, threadData, str, i, i2) != null) || threadData == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadData.tiePlusCostUrl)) {
            ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusCostUrl, threadData.tid, 2, null);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorClickUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorClickUrl);
        }
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_CLICK);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam(TiePlusStatic.Params.CLI_LOCATE, i2);
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            oo4.a(oo4.e, oo4.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str != null && str.startsWith("manual")) {
            oo4.a(oo4.l, oo4.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
    }

    public static void d(ThreadData threadData, BdUniqueId bdUniqueId, int i, int i2) {
        String str;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, bdUniqueId, i, i2) != null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i3 = 20;
        } else {
            str = null;
            z = false;
            i3 = 0;
        }
        StatisticItem c = an8.c(threadData, "a002", "common_click", i2, i, z, str, null, i3);
        if (c == null) {
            return;
        }
        if (threadData.isGoods()) {
            c.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            c.param(TiebaStatic.Params.GUA_TYPE, 2);
            int indexOf = c.getParams().indexOf("obj_locate");
            if (indexOf >= 0) {
                int i4 = indexOf + 1;
                c.getParams().remove(i4);
                c.getParams().add(i4, 16);
            } else {
                c.param("obj_locate", 16);
            }
        } else if (mm5.t(threadData)) {
            c.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            c.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (threadData.isSCard) {
            c.delete("thread_type");
            c.param("thread_type", threadData.getThreadType());
        }
        f(threadData, c);
        c.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
        cn8.g().c(bdUniqueId, c);
        e(threadData, i2);
    }

    public static void e(ThreadData threadData, int i) {
        StatisticItem k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, threadData, i) == null) {
            if (i != 2) {
                if (i != 9) {
                    k = null;
                } else {
                    k = an8.k("c13693", threadData, 1);
                }
            } else {
                k = an8.k("c13692", threadData, 1);
            }
            TiebaStatic.log(k);
        }
    }

    public static void f(ThreadData threadData, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, threadData, statisticItem) == null) {
            if (threadData.getThreadRecommendTagData() != null && !TextUtils.isEmpty(threadData.getThreadRecommendTagData().getText())) {
                statisticItem.addParam(TiebaStatic.Params.IS_SPECIAL_THREAD, 1);
            } else {
                statisticItem.addParam(TiebaStatic.Params.IS_SPECIAL_THREAD, 0);
            }
        }
    }

    public static void g(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, threadData) == null) && threadData != null && !TextUtils.isEmpty(threadData.tiePlusShowUrl)) {
            if (a == null) {
                a = new ArrayMap<>();
            }
            String str = a.get(threadData.tiePlusShowUrl);
            if (!"1".equals(str) && !"2".equals(str)) {
                ThirdStatisticHelper.sendTiePlusReq(threadData.tiePlusShowUrl, threadData.tid, 1, new a());
                a.put(threadData.tiePlusShowUrl, "1");
            }
        }
    }

    public static void h(ThreadData threadData, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65544, null, threadData, str, i) != null) || threadData == null) {
            return;
        }
        g(threadData);
        if (threadData.isTiebaPlusAdThread) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_EXPOSE);
            statisticItem.addParam("obj_locate", 1);
            if (threadData.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (threadData.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", threadData.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, threadData.getFid());
            statisticItem.addParam("order_id", threadData.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            oo4.a(oo4.d, oo4.a, threadData.tiebaPlusOrderId, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (str != null && str.startsWith("manual")) {
            oo4.a(oo4.k, oo4.a, str, threadData.tiebaPlusToken, threadData.tiebaPlusExtraParam, i);
        }
        if (!TextUtils.isEmpty(threadData.tiePlusMonitorShowUrl)) {
            ThirdStatisticHelper.sendReq(threadData.tiePlusMonitorShowUrl);
        }
    }

    public static void i(ThreadData threadData, BdUniqueId bdUniqueId, int i) {
        String str;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65545, null, threadData, bdUniqueId, i) != null) || threadData == null) {
            return;
        }
        if (threadData.isSCard) {
            str = threadData.scardPacketId;
            z = true;
            i2 = 20;
        } else {
            str = null;
            z = false;
            i2 = 0;
        }
        String b = an8.b(threadData.getTid(), str, "", threadData.getBaijiahaoData());
        StatisticItem d = an8.d(threadData, "a002", "common_exp", i, z, str, null, i2);
        if (d == null) {
            return;
        }
        if (threadData.isSCard) {
            d.delete("thread_type");
            d.param("thread_type", threadData.getThreadType());
        }
        if (threadData.isGoods()) {
            d.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (threadData.getItem() != null) {
            d.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else if (mm5.t(threadData)) {
            d.param(TiebaStatic.Params.GUA_TYPE, 4);
        } else {
            d.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        f(threadData, d);
        d.param(TiebaStatic.Params.RECOM_TYPE, threadData.getRecomCardType());
        cn8.g().d(bdUniqueId, b, d);
        if (u27.d()) {
            u27.c(b);
            if (u27.b() >= 10) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921482));
                u27.e(false);
            }
        }
        j(threadData);
    }

    public static void j(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, threadData) == null) && threadData != null && threadData.isXiuXiuThread()) {
            int i = 0;
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(threadData.getForum_name());
            if (itemInfo != null) {
                i = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem(CommonStatisticKey.KEY_XIUXIU_THREAD_SHOW).addParam("obj_locate", 2).addParam("fid", threadData.getFid()).addParam("fname", threadData.getForum_name()).addParam("post_id", threadData.getTid()).addParam("obj_id", i).addParam("obj_name", str).eventStat();
        }
    }
}
