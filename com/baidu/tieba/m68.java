package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.utils.BubbleFrequencyData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public final class m68 {
    public static /* synthetic */ Interceptable $ic;
    public static final m68 a;
    public static final CopyOnWriteArrayList<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends nu5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                da<String> n = e05.n("tb.forum_to_pb_count_cache", TbadkCoreApplication.getCurrentAccount());
                String a = n68.a(this.a);
                BubbleFrequencyData.Companion companion = BubbleFrequencyData.b;
                if (n != null) {
                    str = n.get(a);
                } else {
                    str = null;
                }
                BubbleFrequencyData a2 = companion.a(str);
                if (a2 == null) {
                    a2 = new BubbleFrequencyData(0);
                }
                a2.a();
                n.g(a, a2.c());
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.nu5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends nu5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.nu5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = e05.n("tb.forum_to_pb_count_cache", TbadkCoreApplication.getCurrentAccount()).get("key_frs_to_pb_check_list");
                if (rd.isEmpty(str)) {
                    return;
                }
                m68.b.clear();
                CopyOnWriteArrayList copyOnWriteArrayList = m68.b;
                Intrinsics.checkNotNullExpressionValue(str, "str");
                copyOnWriteArrayList.addAll(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends nu5<BubbleFrequencyData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public BubbleFrequencyData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return BubbleFrequencyData.b.a(e05.n("tb.forum_to_pb_count_cache", TbadkCoreApplication.getCurrentAccount()).get(n68.a(this.a)));
            }
            return (BubbleFrequencyData) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends nu5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                da<String> n = e05.n("tb.forum_to_pb_count_cache", TbadkCoreApplication.getCurrentAccount());
                n.g("key_frs_to_pb_check_list", CollectionsKt___CollectionsKt.joinToString$default(m68.b, ",", null, null, 0, null, null, 62, null));
                n.g(n68.a(this.a), new BubbleFrequencyData(0).c());
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.nu5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924730, "Lcom/baidu/tieba/m68;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924730, "Lcom/baidu/tieba/m68;");
                return;
            }
        }
        a = new m68();
        b = new CopyOnWriteArrayList<>();
    }

    public m68() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ru5.b(new b(), null);
        }
    }

    public static final void f(Function1 callback, BubbleFrequencyData bubbleFrequencyData) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, callback, bubbleFrequencyData) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            if (bubbleFrequencyData != null) {
                i = bubbleFrequencyData.b();
            } else {
                i = 0;
            }
            callback.invoke(Integer.valueOf(i));
        }
    }

    public final void e(String fName, final Function1<? super Integer, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, fName, callback) == null) {
            Intrinsics.checkNotNullParameter(fName, "fName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (!b.contains(fName)) {
                return;
            }
            ru5.b(new c(fName), new st5() { // from class: com.baidu.tieba.a68
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.st5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        m68.f(Function1.this, (BubbleFrequencyData) obj);
                    }
                }
            });
        }
    }

    public final void b(String fName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fName) == null) {
            Intrinsics.checkNotNullParameter(fName, "fName");
            if (!b.contains(fName)) {
                return;
            }
            ru5.b(new a(fName), null);
        }
    }

    public final void d(String fName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fName) == null) {
            Intrinsics.checkNotNullParameter(fName, "fName");
            b.remove(fName);
            g(fName);
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || !b.contains(str)) {
            return;
        }
        ru5.b(new d(str), null);
    }

    public final void h(String fName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fName) == null) {
            Intrinsics.checkNotNullParameter(fName, "fName");
            b.add(fName);
            g(fName);
        }
    }
}
