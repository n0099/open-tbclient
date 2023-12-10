package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class rbb extends fw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<pi> a;
    public int b;
    public int c;
    public String d;
    public String e;
    public kbb f;

    public static String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? z ? "key_recommand_frs_quiz_freq" : "key_recommand_collect_quiz_freq" : (String) invokeZ.objValue;
    }

    @Override // com.baidu.tieba.fw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    public rbb() {
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
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.e = "";
        this.a = new ArrayList();
    }

    public static boolean f(jbb jbbVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, jbbVar, z)) == null) {
            if (jbbVar != null && jbbVar.b() != null) {
                String str = "key_recommand_collect_cover_freq";
                String str2 = "key_recommand_collect_cover_show_time";
                if (z) {
                    str2 = "key_recommand_collect_cover_show_time_frs";
                    str = "key_recommand_collect_cover_freq_frs";
                }
                String[] split = SharedPrefHelper.getInstance().getString(str, "0-0-0").split("-");
                if (split.length == 3) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    long j = parseInt;
                    if (j == jbbVar.b().c().longValue()) {
                        long j2 = parseInt2;
                        if (j2 == jbbVar.b().a().longValue() && parseInt3 == jbbVar.b().b().longValue()) {
                            int i = SharedPrefHelper.getInstance().getInt(str2, 0);
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (i < parseInt3 && currentTimeMillis >= j && currentTimeMillis <= j2) {
                                SharedPrefHelper.getInstance().putInt(str2, i + 1);
                                return true;
                            }
                        }
                    }
                    SharedPrefHelper.getInstance().putString(str, jbbVar.b().c() + "-" + jbbVar.b().a() + "-" + jbbVar.b().b());
                    SharedPrefHelper.getInstance().putInt(str2, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean g(kbb kbbVar, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, kbbVar, z)) == null) {
            boolean z2 = false;
            if (kbbVar != null && kbbVar.d() != null && kbbVar.c() != null) {
                String valueOf = String.valueOf(kbbVar.d().f());
                if (rd.isEmpty(valueOf)) {
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据校验未通过，quizId为空");
                    return false;
                } else if (!TimeHelper.isInTimeBlock(kbbVar.c().start_time.longValue(), kbbVar.c().end_time.longValue())) {
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据时间不满足，curTime=" + (System.currentTimeMillis() / 1000) + "，startTime=" + kbbVar.c().start_time + "，endTime=" + kbbVar.c().end_time);
                    return false;
                } else {
                    Long l = kbbVar.c().show_times;
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据频次，quizId=" + valueOf + "，maxNumber=" + l);
                    String e = e(z);
                    String string = SharedPrefHelper.getInstance().getString(e, "");
                    if (!rd.isEmpty(string) && string.split(",") != null && string.split(",").length > 0) {
                        String[] split = string.split(",");
                        HashMap hashMap = new HashMap();
                        for (String str : split) {
                            String[] split2 = str.split(":");
                            if (split2.length == 2) {
                                hashMap.put(split2[0], Integer.valueOf(JavaTypesHelper.toInt(split2[1], 0)));
                            }
                        }
                        int i2 = JavaTypesHelper.toInt(String.valueOf(hashMap.get(valueOf)), 0);
                        if (i2 >= l.longValue()) {
                            return false;
                        }
                        hashMap.put(valueOf, Integer.valueOf(i2 + 1));
                        StringBuilder sb = new StringBuilder();
                        for (String str2 : hashMap.keySet()) {
                            if (hashMap.get(str2) != null) {
                                i = ((Integer) hashMap.get(str2)).intValue();
                            } else {
                                i = 0;
                            }
                            sb.append(str2);
                            sb.append(":");
                            sb.append(i);
                            sb.append(",");
                        }
                        SharedPrefHelper.getInstance().putString(e, sb.toString());
                        return true;
                    }
                    if (l.longValue() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        SharedPrefHelper.getInstance().putString(e, valueOf + ":1,");
                    }
                    return z2;
                }
            }
            DefaultLog.getInstance().i("quiz", "竞猜卡数据校验未通过，quizCardData =" + kbbVar);
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean p(lbb lbbVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, lbbVar, z)) == null) {
            if (TbadkCoreApplication.isLogin() && lbbVar != null && (ListUtils.isNotEmpty(lbbVar.e()) || g(lbbVar.d(), z) || f(lbbVar.c(), z))) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public List<pi> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return dn6.A0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void h(lbb lbbVar) {
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, lbbVar) != null) || lbbVar == null) {
            return;
        }
        this.a.clear();
        if (lbbVar.d() != null) {
            kbb d = lbbVar.d();
            this.f = d;
            this.a.add(d);
        }
        if (lbbVar.c() != null && lbbVar.c().c() != null && !TextUtils.isEmpty(lbbVar.c().c().a())) {
            b = lbbVar.c().c().a();
        } else {
            b = lbbVar.b();
        }
        if (StringUtils.isNotNull(b)) {
            ubb ubbVar = new ubb();
            ubbVar.b(b);
            this.a.add(ubbVar);
        }
        if (lbbVar.c() != null) {
            if (lbbVar.c().a() != null) {
                lbbVar.c().a();
            }
            if (lbbVar.c().c() != null) {
                sbb sbbVar = new sbb();
                sbbVar.e(lbbVar.c().c());
                sbbVar.h(this.c);
                sbbVar.f(this.d);
                sbbVar.g(this.e);
                this.a.add(sbbVar);
                if (ListUtils.isNotEmpty(lbbVar.c().c().l())) {
                    tbb tbbVar = new tbb();
                    tbbVar.b(lbbVar.c().c(), this.c, this.d, this.e);
                    this.a.add(tbbVar);
                }
                if (ListUtils.isNotEmpty(lbbVar.c().c().o())) {
                    for (ThreadInfo threadInfo : lbbVar.c().c().o()) {
                        ThreadData threadData = new ThreadData();
                        threadData.setNeedCheckNTitle(false);
                        threadData.parserProtobuf(threadInfo);
                        if (threadData.getTitleText() != null && StringUtils.isNotNull(lbbVar.c().c().b())) {
                            ThreadCardUtils.setUniversalPrefix(threadData.getTitleText(), lbbVar.c().c().b(), R.color.CAM_X0302, R.color.CAM_X0101);
                        }
                        this.a.add(threadData);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (ListUtils.isNotEmpty(lbbVar.e())) {
            for (int i = 0; i < lbbVar.e().size(); i++) {
                ThreadData threadData2 = new ThreadData();
                threadData2.setNeedCheckNTitle(false);
                threadData2.parserProtobuf(lbbVar.e().get(i));
                this.a.add(threadData2);
            }
        }
        lbbVar.a();
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.d = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.e = str;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
        }
    }
}
