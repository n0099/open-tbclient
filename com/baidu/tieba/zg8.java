package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
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
/* loaded from: classes8.dex */
public final class zg8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Vector<String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final SpriteMsgProcessor a;
    public final String b;
    public final long c;
    public final String d;
    public final Runnable e;

    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg8 a;

        public a(zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zg8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
                if (!this.a.j()) {
                    SpriteMsgProcessor i = this.a.i();
                    String loadingTimeOutContent = this.a.d;
                    Intrinsics.checkNotNullExpressionValue(loadingTimeOutContent, "loadingTimeOutContent");
                    i.F(loadingTimeOutContent, this.a.k());
                    zg8.f.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948359102, "Lcom/baidu/tieba/zg8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948359102, "Lcom/baidu/tieba/zg8;");
                return;
            }
        }
        f = new Vector<>();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f.isEmpty()) {
                e();
                return;
            }
            yna.a().removeCallbacks(this.e);
            yna.a().postDelayed(this.e, this.c);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yna.a().removeCallbacks(this.e);
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) f);
            Intrinsics.checkNotNullExpressionValue(first, "sendMsgkeyList.first()");
            return (String) first;
        }
        return (String) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long o = o65.m().o("key_funny_sprite_loading_animation_show", 0L);
            if (j() || o <= 0) {
                return 0L;
            }
            return this.c - (System.currentTimeMillis() - o);
        }
        return invokeV.longValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String loadingTimeOutContent = this.d;
            Intrinsics.checkNotNullExpressionValue(loadingTimeOutContent, "loadingTimeOutContent");
            return loadingTimeOutContent;
        }
        return (String) invokeV.objValue;
    }

    public final SpriteMsgProcessor i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (SpriteMsgProcessor) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return f.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String lastElement = f.lastElement();
            Intrinsics.checkNotNullExpressionValue(lastElement, "sendMsgkeyList.lastElement()");
            return lastElement;
        }
        return (String) invokeV.objValue;
    }

    public zg8(SpriteMsgProcessor spriteMsgProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteMsgProcessor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(spriteMsgProcessor, "spriteMsgProcessor");
        this.a = spriteMsgProcessor;
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f139a);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.sprite_time_out_hint)");
        this.b = string;
        this.c = o65.m().n("key_funny_sprite_msg_time_out", 60) * 1000;
        this.d = o65.m().s("key_funny_sprite_msg_time_out_content", this.b);
        this.e = new a(this);
    }

    public final void c(String msgKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msgKey) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            if (!f.contains(msgKey)) {
                f.add(msgKey);
            }
            d();
            o65.m().A("key_funny_sprite_loading_animation_show", System.currentTimeMillis());
        }
    }

    public final void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            yna.a().removeCallbacks(this.e);
            yna.a().postDelayed(this.e, j);
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                f.clear();
            }
            e();
        }
    }

    public final void m(String msgKey, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, msgKey, z) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            if (z) {
                f.remove(msgKey);
            } else if (!j()) {
                CollectionsKt__MutableCollectionsKt.removeFirst(f);
            }
            d();
        }
    }

    public final boolean n(SizedSyncTreeSet<qe8> set) {
        InterceptResult invokeL;
        Object obj;
        ve8 ve8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, set)) == null) {
            Intrinsics.checkNotNullParameter(set, "set");
            if (j()) {
                return true;
            }
            ArrayList arrayList = new ArrayList(set);
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    obj = listIterator.previous();
                    if (Intrinsics.areEqual(((qe8) obj).b(), f())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            int lastIndexOf = CollectionsKt___CollectionsKt.lastIndexOf((List<? extends qe8>) arrayList, (qe8) obj);
            if (lastIndexOf >= -1 && lastIndexOf < arrayList.size() - 1) {
                int size = arrayList.size();
                for (int i = lastIndexOf + 1; i < size; i++) {
                    Object item = ListUtils.getItem(arrayList, i);
                    if (item instanceof ve8) {
                        ve8Var = (ve8) item;
                    } else {
                        ve8Var = null;
                    }
                    if (ve8Var != null && !ve8Var.e().d() && !qi.isEmpty(ve8Var.g().a())) {
                        m(ve8Var.g().a(), true);
                    }
                }
            }
            return j();
        }
        return invokeL.booleanValue;
    }
}
