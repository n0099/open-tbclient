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
public class u6b extends bw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<oi> a;
    public int b;
    public int c;
    public String d;
    public String e;
    public n6b f;

    public static String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? z ? "key_recommand_frs_quiz_freq" : "key_recommand_collect_quiz_freq" : (String) invokeZ.objValue;
    }

    @Override // com.baidu.tieba.bw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bw4
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

    public u6b() {
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

    public static boolean f(m6b m6bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, m6bVar, z)) == null) {
            if (m6bVar != null && m6bVar.b() != null) {
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
                    if (j == m6bVar.b().c().longValue()) {
                        long j2 = parseInt2;
                        if (j2 == m6bVar.b().a().longValue() && parseInt3 == m6bVar.b().b().longValue()) {
                            int i = SharedPrefHelper.getInstance().getInt(str2, 0);
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (i < parseInt3 && currentTimeMillis >= j && currentTimeMillis <= j2) {
                                SharedPrefHelper.getInstance().putInt(str2, i + 1);
                                return true;
                            }
                        }
                    }
                    SharedPrefHelper.getInstance().putString(str, m6bVar.b().c() + "-" + m6bVar.b().a() + "-" + m6bVar.b().b());
                    SharedPrefHelper.getInstance().putInt(str2, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean g(n6b n6bVar, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, n6bVar, z)) == null) {
            boolean z2 = false;
            if (n6bVar != null && n6bVar.d() != null && n6bVar.c() != null) {
                String valueOf = String.valueOf(n6bVar.d().f());
                if (qd.isEmpty(valueOf)) {
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据校验未通过，quizId为空");
                    return false;
                } else if (!TimeHelper.isInTimeBlock(n6bVar.c().start_time.longValue(), n6bVar.c().end_time.longValue())) {
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据时间不满足，curTime=" + (System.currentTimeMillis() / 1000) + "，startTime=" + n6bVar.c().start_time + "，endTime=" + n6bVar.c().end_time);
                    return false;
                } else {
                    Long l = n6bVar.c().show_times;
                    DefaultLog.getInstance().i("quiz", "竞猜卡数据频次，quizId=" + valueOf + "，maxNumber=" + l);
                    String e = e(z);
                    String string = SharedPrefHelper.getInstance().getString(e, "");
                    if (!qd.isEmpty(string) && string.split(",") != null && string.split(",").length > 0) {
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
            DefaultLog.getInstance().i("quiz", "竞猜卡数据校验未通过，quizCardData =" + n6bVar);
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean p(o6b o6bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, o6bVar, z)) == null) {
            if (TbadkCoreApplication.isLogin() && o6bVar != null && (ListUtils.isNotEmpty(o6bVar.e()) || g(o6bVar.d(), z) || f(o6bVar.c(), z))) {
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

    public List<oi> getDataList() {
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.oi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return nm6.A0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void h(o6b o6bVar) {
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, o6bVar) != null) || o6bVar == null) {
            return;
        }
        this.a.clear();
        if (o6bVar.d() != null) {
            n6b d = o6bVar.d();
            this.f = d;
            this.a.add(d);
        }
        if (o6bVar.c() != null && o6bVar.c().c() != null && !TextUtils.isEmpty(o6bVar.c().c().a())) {
            b = o6bVar.c().c().a();
        } else {
            b = o6bVar.b();
        }
        if (StringUtils.isNotNull(b)) {
            x6b x6bVar = new x6b();
            x6bVar.b(b);
            this.a.add(x6bVar);
        }
        if (o6bVar.c() != null) {
            if (o6bVar.c().a() != null) {
                o6bVar.c().a();
            }
            if (o6bVar.c().c() != null) {
                v6b v6bVar = new v6b();
                v6bVar.e(o6bVar.c().c());
                v6bVar.h(this.c);
                v6bVar.f(this.d);
                v6bVar.g(this.e);
                this.a.add(v6bVar);
                if (ListUtils.isNotEmpty(o6bVar.c().c().l())) {
                    w6b w6bVar = new w6b();
                    w6bVar.b(o6bVar.c().c(), this.c, this.d, this.e);
                    this.a.add(w6bVar);
                }
                if (ListUtils.isNotEmpty(o6bVar.c().c().o())) {
                    for (ThreadInfo threadInfo : o6bVar.c().c().o()) {
                        ThreadData threadData = new ThreadData();
                        threadData.setNeedCheckNTitle(false);
                        threadData.parserProtobuf(threadInfo);
                        if (threadData.getTitleText() != null && StringUtils.isNotNull(o6bVar.c().c().b())) {
                            ThreadCardUtils.setUniversalPrefix(threadData.getTitleText(), o6bVar.c().c().b(), R.color.CAM_X0302, R.color.CAM_X0101);
                        }
                        this.a.add(threadData);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (ListUtils.isNotEmpty(o6bVar.e())) {
            for (int i = 0; i < o6bVar.e().size(); i++) {
                ThreadData threadData2 = new ThreadData();
                threadData2.setNeedCheckNTitle(false);
                threadData2.parserProtobuf(o6bVar.e().get(i));
                this.a.add(threadData2);
            }
        }
        o6bVar.a();
    }

    public void i(String str) {
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
