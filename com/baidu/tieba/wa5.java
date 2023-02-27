package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* loaded from: classes6.dex */
public final class wa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashSet<String> a;
    public a b;
    public int c;
    public final yg<on> d;
    public final Runnable e;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static final class b extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wa5 a;

        public b(wa5 wa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wa5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                if (onVar != null && !TextUtils.isEmpty(str)) {
                    TypeIntrinsics.asMutableCollection(this.a.a).remove(str);
                }
                this.a.f();
            }
        }
    }

    public wa5() {
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
        this.a = new HashSet<>();
        this.c = 10;
        this.d = new b(this);
        this.e = new Runnable() { // from class: com.baidu.tieba.ta5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    wa5.e(wa5.this);
                }
            }
        };
    }

    public static final void e(wa5 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            HashSet<String> hashSet = new HashSet<>();
            hashSet.addAll(this$0.a);
            this$0.d(hashSet);
        }
    }

    @JvmOverloads
    public final void c(List<String> list, a aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048576, this, list, aVar, i) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        Intrinsics.checkNotNull(list);
        hashSet.addAll(list);
        this.b = aVar;
        this.c = i;
        d(hashSet);
    }

    public final void d(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashSet) != null) || hashSet.isEmpty()) {
            return;
        }
        this.a.clear();
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!dj.isEmpty(next) && ((on) zg.h().n(next, this.c, new Object[0])) == null) {
                this.a.add(next);
                zg.h().k(next, this.c, this.d, 0, 0, null, new Object[0]);
            }
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.isEmpty()) {
            gh.a().removeCallbacks(this.e);
            a aVar = this.b;
            if (aVar != null) {
                Intrinsics.checkNotNull(aVar);
                aVar.a();
            }
        }
    }
}
