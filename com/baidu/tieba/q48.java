package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class q48 {
    public static /* synthetic */ Interceptable $ic;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes7.dex */
    public static class a extends kw5<Object> {
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

        @Override // com.baidu.tieba.kw5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] split = SharedPrefHelper.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
                if (split.length != 2) {
                    return null;
                }
                String str = split[0];
                long j = JavaTypesHelper.toLong(split[1], 0L);
                if (j != 0 && !StringUtils.isNull(str)) {
                    SharedPrefHelper.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.a.tid + "," + j);
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    public q48() {
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

    public static void d(long j, int i, List<ThreadInfo> list, List<ym> list2) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), list, list2}) == null) && j == b && !ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            if (i == 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (list2.get(i2) instanceof p48) {
                        list2.remove(i2);
                        return;
                    }
                }
                return;
            }
            int i3 = i + 1;
            if (ListUtils.getCount(list) > i3 && (threadInfo = list.get(i3)) != null && threadInfo.tid.longValue() != 0) {
                b = threadInfo.tid.longValue();
                ow5.b(new a(threadInfo), null);
            }
        }
    }

    public void a(List<ym> list) {
        kn6 kn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || !TbadkCoreApplication.isLogin()) {
            return;
        }
        if (this.a == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            this.a = sharedPrefHelper.getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        if (StringUtils.isNull(this.a)) {
            return;
        }
        String[] split = this.a.split(",");
        if (split.length != 2) {
            return;
        }
        String str = split[0];
        long j = JavaTypesHelper.toLong(split[1], 0L);
        if (j != 0 && !StringUtils.isNull(str) && !ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i) instanceof kn6) && (kn6Var = (kn6) list.get(i)) != null && !StringUtils.isNull(kn6Var.g) && kn6Var.g.equals(str)) {
                    p48 p48Var = new p48();
                    p48Var.a = j;
                    p48Var.b = false;
                    list.add(i, p48Var);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) && d48.a && threadInfo != null && threadInfo != null && (l = threadInfo.tid) != null && l.longValue() != 0) {
            this.a = null;
            b = threadInfo.tid.longValue();
            SharedPrefHelper.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, list) == null) && TbadkCoreApplication.isLogin() && !ListUtils.isEmpty(list) && z && (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) != null && (l = threadInfo.tid) != null && l.longValue() != 0) {
            this.a = null;
            b = threadInfo.tid.longValue();
            SharedPrefHelper.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }
}
