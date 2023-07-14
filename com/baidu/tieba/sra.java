package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class sra extends t15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yn> a;
    public int b;
    public int c;
    public String d;
    public String e;

    @Override // com.baidu.tieba.t15
    public s35 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (s35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public sra() {
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

    public static boolean c(ora oraVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, oraVar, z)) == null) {
            if (oraVar != null && oraVar.b() != null) {
                String str = "key_recommand_collect_cover_freq";
                String str2 = "key_recommand_collect_cover_show_time";
                if (z) {
                    str2 = "key_recommand_collect_cover_show_time_frs";
                    str = "key_recommand_collect_cover_freq_frs";
                }
                String[] split = da5.p().w(str, "0-0-0").split("-");
                if (split.length == 3) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    long j = parseInt;
                    if (j == oraVar.b().c().longValue()) {
                        long j2 = parseInt2;
                        if (j2 == oraVar.b().a().longValue() && parseInt3 == oraVar.b().b().longValue()) {
                            int q = da5.p().q(str2, 0);
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (q < parseInt3 && currentTimeMillis >= j && currentTimeMillis <= j2) {
                                da5.p().F(str2, q + 1);
                                return true;
                            }
                        }
                    }
                    da5.p().J(str, oraVar.b().c() + "-" + oraVar.b().a() + "-" + oraVar.b().b());
                    da5.p().F(str2, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean i(pra praVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, praVar, z)) == null) {
            if (TbadkCoreApplication.isLogin() && praVar != null && (ListUtils.isNotEmpty(praVar.d()) || c(praVar.c(), z))) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void d(pra praVar) {
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, praVar) != null) || praVar == null) {
            return;
        }
        this.a.clear();
        if (praVar.c() != null && praVar.c().c() != null && !TextUtils.isEmpty(praVar.c().c().a())) {
            b = praVar.c().c().a();
        } else {
            b = praVar.b();
        }
        if (StringUtils.isNotNull(b)) {
            vra vraVar = new vra();
            vraVar.b(b);
            this.a.add(vraVar);
        }
        if (praVar.c() != null) {
            if (praVar.c().a() != null) {
                praVar.c().a();
            }
            if (praVar.c().c() != null) {
                tra traVar = new tra();
                traVar.e(praVar.c().c());
                traVar.h(this.c);
                traVar.f(this.d);
                traVar.g(this.e);
                this.a.add(traVar);
                if (ListUtils.isNotEmpty(praVar.c().c().l())) {
                    ura uraVar = new ura();
                    uraVar.b(praVar.c().c(), this.c, this.d, this.e);
                    this.a.add(uraVar);
                }
                if (ListUtils.isNotEmpty(praVar.c().c().o())) {
                    for (ThreadInfo threadInfo : praVar.c().c().o()) {
                        ThreadData threadData = new ThreadData();
                        threadData.setNeedCheckNTitle(false);
                        threadData.parserProtobuf(threadInfo);
                        if (threadData.getTitleText() != null && StringUtils.isNotNull(praVar.c().c().b())) {
                            ThreadCardUtils.setUniversalPrefix(threadData.getTitleText(), praVar.c().c().b(), R.color.CAM_X0302, R.color.CAM_X0101);
                        }
                        this.a.add(threadData);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (ListUtils.isNotEmpty(praVar.d())) {
            for (int i = 0; i < praVar.d().size(); i++) {
                ThreadData threadData2 = new ThreadData();
                threadData2.setNeedCheckNTitle(false);
                threadData2.parserProtobuf(praVar.d().get(i));
                this.a.add(threadData2);
            }
        }
        praVar.a();
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.e = str;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
        }
    }

    public List<yn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return kq6.A0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
