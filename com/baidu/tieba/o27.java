package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class o27 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes5.dex */
    public static class a extends qh5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadInfo a;

        public a(ThreadInfo threadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadInfo;
        }

        @Override // com.baidu.tieba.qh5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] split = bx4.k().q("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
                if (split.length != 2) {
                    return null;
                }
                String str = split[0];
                long g = dh.g(split[1], 0L);
                if (g != 0 && !StringUtils.isNull(str)) {
                    bx4.k().y("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.a.tid + "," + g);
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    public o27() {
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

    public static void d(long j, int i, List<ThreadInfo> list, List<Cdo> list2) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), list, list2}) == null) || j != b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        if (i == 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list2.get(i2) instanceof n27) {
                    list2.remove(i2);
                    return;
                }
            }
            return;
        }
        int i3 = i + 1;
        if (ListUtils.getCount(list) <= i3 || (threadInfo = list.get(i3)) == null || threadInfo.tid.longValue() == 0) {
            return;
        }
        b = threadInfo.tid.longValue();
        uh5.b(new a(threadInfo), null);
    }

    public void a(List<Cdo> list) {
        c26 c26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && TbadkCoreApplication.isLogin()) {
            if (this.a == null) {
                bx4 k = bx4.k();
                this.a = k.q("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.a)) {
                return;
            }
            String[] split = this.a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long g = dh.g(split[1], 0L);
            if (g == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i) instanceof c26) && (c26Var = (c26) list.get(i)) != null && !StringUtils.isNull(c26Var.g) && c26Var.g.equals(str)) {
                    n27 n27Var = new n27();
                    n27Var.a = g;
                    n27Var.b = false;
                    list.add(i, n27Var);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || !e27.a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.a = null;
        b = threadInfo.tid.longValue();
        bx4.k().y("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, list) == null) || !TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.a = null;
        b = threadInfo.tid.longValue();
        bx4.k().y("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}
