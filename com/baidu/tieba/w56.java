package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* loaded from: classes8.dex */
public final class w56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountDownLatch a;
    public int b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948221617, "Lcom/baidu/tieba/w56;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948221617, "Lcom/baidu/tieba/w56;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a extends BdAsyncTask<String, Integer, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w56 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ StatisticItem d;

        public a(w56 w56Var, int i, Function0<Unit> function0, StatisticItem statisticItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w56Var, Integer.valueOf(i), function0, statisticItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w56Var;
            this.b = i;
            this.c = function0;
            this.d = statisticItem;
        }

        public void b(String... params) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, params) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                this.a.h(RangesKt___RangesKt.coerceAtLeast(o56.a.a(), 0));
                this.a.g(RangesKt___RangesKt.coerceAtLeast(n56.a.a(), 0));
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数adTimeoutTask, 类型(1是小熊，2是原生)：" + this.b + "，showTimeoutTime is: " + this.a.d() + ", closeTimeoutTime is: " + this.a.c());
                if (this.a.d() == 0 && this.a.c() == 0) {
                    return;
                }
                if (this.a.d() > 0) {
                    Thread.sleep(this.a.d());
                    if (this.a.a.getCount() == 2) {
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数adTimeoutTask， 类型(1是小熊，2是原生)：" + this.b + ", <<<<<<<<OpenScreenAdShowTimeout");
                        this.c.invoke();
                        this.d.addParam("obj_source", "tb_kpgg").addParam(TiebaStatic.Params.OBJ_PARAM2, this.b).addParam("obj_param1", "class_OpenScreenAdTimeoutTaskUtils").addParam("obj_type", "OpenScreenAdShowTimeout");
                        TiebaStatic.log(this.d);
                        return;
                    }
                }
                long count = this.a.a.getCount();
                TbLog defaultLog3 = DefaultLog.getInstance();
                defaultLog3.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数adTimeoutTask， 类型(1是小熊，2是原生)：" + this.b + "， 等待关闭超时时的latchCount：" + count);
                if (this.a.c() - this.a.d() > 0) {
                    Thread.sleep(this.a.c() - this.a.d());
                    if (this.a.a.getCount() == count) {
                        TbLog defaultLog4 = DefaultLog.getInstance();
                        defaultLog4.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数adTimeoutTask，类型(1是小熊，2是原生)：" + this.b + "， OpenScreenAdCloseTimeout>>>>>>>>");
                        this.c.invoke();
                        this.d.addParam("obj_source", "tb_kpgg").addParam(TiebaStatic.Params.OBJ_PARAM2, this.b).addParam("obj_param1", "class_OpenScreenAdTimeoutTaskUtils").addParam("obj_type", "OpenScreenAdCloseTimeout");
                        TiebaStatic.log(this.d);
                    }
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* bridge */ /* synthetic */ Unit doInBackground(String[] strArr) {
            b(strArr);
            return Unit.INSTANCE;
        }
    }

    public w56() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new CountDownLatch(2);
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.c = i;
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
        }
    }

    public final void b(Function0<Unit> timeoutCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, timeoutCallback, i) == null) {
            Intrinsics.checkNotNullParameter(timeoutCallback, "timeoutCallback");
            a aVar = new a(this, i, timeoutCallback, new StatisticItem(CommonStatisticKey.KEY_RD_USE));
            aVar.setPriority(3);
            aVar.execute(new String[0]);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数onAdFinish，广告类型(1是小熊，2是原生)：" + i + ", latch.getCount() is: " + this.a.getCount());
            this.a.countDown();
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("OpenScreenAdTimeoutTaskUtils", "开屏广告：OpenScreenAdTimeoutTaskUtils，函数onAdShow，广告类型(1是小熊，2是原生)：" + i + ", latch.getCount() is: " + this.a.getCount() + ", showTimeoutTime is: " + this.b);
            if (this.b > 0) {
                this.a.countDown();
            }
        }
    }
}
