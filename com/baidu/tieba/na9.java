package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class na9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Vector<String> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final long b;
    public final String c;
    public final Runnable d;

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na9 a;

        public a(na9 na9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
                if (this.a.i()) {
                    return;
                }
                String loadingTimeOutContent = this.a.c;
                Intrinsics.checkNotNullExpressionValue(loadingTimeOutContent, "loadingTimeOutContent");
                ck5.k(loadingTimeOutContent, this.a.j());
                na9.e.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947995875, "Lcom/baidu/tieba/na9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947995875, "Lcom/baidu/tieba/na9;");
                return;
            }
        }
        e = new Vector<>();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (e.isEmpty()) {
                e();
                return;
            }
            psb.a().removeCallbacks(this.d);
            psb.a().postDelayed(this.d, this.b);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            psb.a().removeCallbacks(this.d);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) e);
            Intrinsics.checkNotNullExpressionValue(first, "sendMsgkeyList.first()");
            return (String) first;
        }
        return (String) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = SharedPrefHelper.getInstance().getLong("key_funny_sprite_loading_animation_show", 0L);
            if (i() || j <= 0) {
                return 0L;
            }
            return this.b - (System.currentTimeMillis() - j);
        }
        return invokeV.longValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String loadingTimeOutContent = this.c;
            Intrinsics.checkNotNullExpressionValue(loadingTimeOutContent, "loadingTimeOutContent");
            return loadingTimeOutContent;
        }
        return (String) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return e.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String lastElement = e.lastElement();
            Intrinsics.checkNotNullExpressionValue(lastElement, "sendMsgkeyList.lastElement()");
            return lastElement;
        }
        return (String) invokeV.objValue;
    }

    public na9() {
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
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1478);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.sprite_time_out_hint)");
        this.a = string;
        this.b = SharedPrefHelper.getInstance().getInt("key_funny_sprite_msg_time_out", 60) * 1000;
        this.c = SharedPrefHelper.getInstance().getString("key_funny_sprite_msg_time_out_content", this.a);
        this.d = new a(this);
    }

    public final void c(String msgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msgKey) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            if (!e.contains(msgKey)) {
                e.add(msgKey);
            }
            d();
            SharedPrefHelper.getInstance().putLong("key_funny_sprite_loading_animation_show", System.currentTimeMillis());
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            psb.a().removeCallbacks(this.d);
            psb.a().postDelayed(this.d, j);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                e.clear();
            }
            e();
        }
    }

    public final void l(String msgKey, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, msgKey, z) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            if (z) {
                e.remove(msgKey);
            } else if (!i()) {
                CollectionsKt__MutableCollectionsKt.removeFirst(e);
            }
            d();
        }
    }

    public final boolean m(SizedSyncTreeSet<a89> set) {
        InterceptResult invokeL;
        Object obj;
        f89 f89Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, set)) == null) {
            Intrinsics.checkNotNullParameter(set, "set");
            if (i()) {
                return true;
            }
            ArrayList arrayList = new ArrayList(set);
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    obj = listIterator.previous();
                    if (Intrinsics.areEqual(((a89) obj).b(), f())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            int lastIndexOf = CollectionsKt___CollectionsKt.lastIndexOf((List<? extends a89>) arrayList, (a89) obj);
            if (lastIndexOf >= -1 && lastIndexOf < arrayList.size() - 1) {
                int size = arrayList.size();
                for (int i = lastIndexOf + 1; i < size; i++) {
                    Object item = ListUtils.getItem(arrayList, i);
                    if (item instanceof f89) {
                        f89Var = (f89) item;
                    } else {
                        f89Var = null;
                    }
                    if (f89Var != null && !f89Var.e().e() && !qd.isEmpty(f89Var.g().a())) {
                        l(f89Var.g().a(), true);
                    }
                }
            }
            return i();
        }
        return invokeL.booleanValue;
    }
}
