package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes6.dex */
public final class ky8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Vector<String> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final long b;
    public final String c;
    public final Runnable d;

    /* loaded from: classes6.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky8 a;

        public a(ky8 ky8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky8Var;
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
                mo5.k(loadingTimeOutContent, this.a.j());
                ky8.e.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947929535, "Lcom/baidu/tieba/ky8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947929535, "Lcom/baidu/tieba/ky8;");
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
            xab.a().removeCallbacks(this.d);
            xab.a().postDelayed(this.d, this.b);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xab.a().removeCallbacks(this.d);
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
            long r = da5.p().r("key_funny_sprite_loading_animation_show", 0L);
            if (i() || r <= 0) {
                return 0L;
            }
            return this.b - (System.currentTimeMillis() - r);
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

    public ky8() {
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
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1423);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.sprite_time_out_hint)");
        this.a = string;
        this.b = da5.p().q("key_funny_sprite_msg_time_out", 60) * 1000;
        this.c = da5.p().w("key_funny_sprite_msg_time_out_content", this.a);
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
            da5.p().H("key_funny_sprite_loading_animation_show", System.currentTimeMillis());
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            xab.a().removeCallbacks(this.d);
            xab.a().postDelayed(this.d, j);
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

    public final boolean m(SizedSyncTreeSet<xv8> set) {
        InterceptResult invokeL;
        Object obj;
        cw8 cw8Var;
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
                    if (Intrinsics.areEqual(((xv8) obj).b(), f())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            int lastIndexOf = CollectionsKt___CollectionsKt.lastIndexOf((List<? extends xv8>) arrayList, (xv8) obj);
            if (lastIndexOf >= -1 && lastIndexOf < arrayList.size() - 1) {
                int size = arrayList.size();
                for (int i = lastIndexOf + 1; i < size; i++) {
                    Object item = ListUtils.getItem(arrayList, i);
                    if (item instanceof cw8) {
                        cw8Var = (cw8) item;
                    } else {
                        cw8Var = null;
                    }
                    if (cw8Var != null && !cw8Var.e().d() && !xi.isEmpty(cw8Var.g().a())) {
                        l(cw8Var.g().a(), true);
                    }
                }
            }
            return i();
        }
        return invokeL.booleanValue;
    }
}
