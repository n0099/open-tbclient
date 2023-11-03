package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes8.dex */
public final class so5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final HashMap<BdUniqueId, String> b;
    public static final HashMap<BdUniqueId, Pair<String, String>[]> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.so5$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0475a implements qo5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qza a;

            public C0475a(qza qzaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qzaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qzaVar;
            }

            @Override // com.baidu.tieba.qo5
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    qza qzaVar = this.a;
                    if (qzaVar instanceof Fragment) {
                        pza.b((Fragment) qzaVar, new Pair[0]);
                    } else if (qzaVar instanceof FragmentActivity) {
                        oza.b((FragmentActivity) qzaVar);
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("PageLoadEvent", "start: " + this.a.getClass());
                }
            }

            @Override // com.baidu.tieba.qo5
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    qza qzaVar = this.a;
                    if (qzaVar instanceof Fragment) {
                        pza.c((Fragment) qzaVar, new Pair[0]);
                    } else if (qzaVar instanceof FragmentActivity) {
                        oza.c((FragmentActivity) qzaVar, new Pair[0]);
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("PageLoadEvent", "finish: " + this.a.getClass());
                }
            }

            @Override // com.baidu.tieba.qo5
            public void c(Pair<String, String>... info) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, info) == null) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    qza qzaVar = this.a;
                    if (qzaVar instanceof Fragment) {
                        pza.a((Fragment) qzaVar, (Pair[]) Arrays.copyOf(info, info.length));
                    } else if (qzaVar instanceof FragmentActivity) {
                        oza.a((FragmentActivity) qzaVar, (Pair[]) Arrays.copyOf(info, info.length));
                    }
                    StringBuilder sb = new StringBuilder();
                    for (Pair<String, String> pair : info) {
                        sb.append(pair);
                    }
                    DefaultLog.getInstance().i("PageLoadEvent", "error: " + this.a.getClass() + " info: " + ((Object) sb));
                }
            }
        }

        /* loaded from: classes8.dex */
        public static final class b extends pq6<ro5> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdUniqueId b;
            public final /* synthetic */ qo5 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(BdUniqueId bdUniqueId, qo5 qo5Var, Class<ro5> cls) {
                super(cls);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bdUniqueId, qo5Var, cls};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Class) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bdUniqueId;
                this.c = qo5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.pq6
            public void onEvent(ro5 event) {
                String str;
                String str2;
                String str3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (!Intrinsics.areEqual(event.a(), this.b)) {
                        return;
                    }
                    String c = event.c();
                    int hashCode = c.hashCode();
                    if (hashCode != 3540994) {
                        if (hashCode != 96784904) {
                            if (hashCode == 109757538 && c.equals("start") && (str3 = so5.a.c().get(this.b)) != null) {
                                int hashCode2 = str3.hashCode();
                                if (hashCode2 != 3237136) {
                                    if (hashCode2 != 3540994) {
                                        if (hashCode2 == 96784904 && str3.equals("error")) {
                                            this.c.a();
                                            Pair<String, String>[] pairArr = so5.a.b().get(this.b);
                                            if (pairArr != null) {
                                                this.c.c((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                                            }
                                            so5.a.c().remove(this.b);
                                            so5.a.b().remove(this.b);
                                        }
                                    } else if (str3.equals("stop")) {
                                        this.c.a();
                                        this.c.b();
                                        so5.a.c().remove(this.b);
                                        so5.a.b().remove(this.b);
                                    }
                                } else if (str3.equals("init")) {
                                    this.c.a();
                                    so5.a.c().put(this.b, "start");
                                }
                            }
                        } else if (c.equals("error") && (str2 = so5.a.c().get(this.b)) != null) {
                            int hashCode3 = str2.hashCode();
                            if (hashCode3 != 3237136) {
                                if (hashCode3 == 109757538 && str2.equals("start")) {
                                    qo5 qo5Var = this.c;
                                    Pair<String, String>[] b = event.b();
                                    qo5Var.c((Pair[]) Arrays.copyOf(b, b.length));
                                    so5.a.c().remove(this.b);
                                    so5.a.b().remove(this.b);
                                }
                            } else if (str2.equals("init")) {
                                so5.a.c().put(this.b, "error");
                                so5.a.b().put(this.b, event.b());
                            }
                        }
                    } else if (c.equals("stop") && (str = so5.a.c().get(this.b)) != null) {
                        int hashCode4 = str.hashCode();
                        if (hashCode4 != 3237136) {
                            if (hashCode4 == 109757538 && str.equals("start")) {
                                this.c.b();
                                so5.a.c().remove(this.b);
                                so5.a.b().remove(this.b);
                            }
                        } else if (str.equals("init")) {
                            so5.a.c().put(this.b, "stop");
                        }
                    }
                }
            }
        }

        public a() {
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

        public final HashMap<BdUniqueId, Pair<String, String>[]> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (HashMap) invokeV.objValue;
            }
            return so5.c;
        }

        public final HashMap<BdUniqueId, String> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return (HashMap) invokeV.objValue;
            }
            return so5.b;
        }

        public final void a(BdUniqueId bdUniqueId, Pair<String, String>... info) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, info) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                mq6.b().c(new ro5(bdUniqueId, "error", (Pair[]) Arrays.copyOf(info, info.length)));
            }
        }

        public final void e(BdUniqueId uniqueId, qza traceable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, uniqueId, traceable) == null) {
                Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                Intrinsics.checkNotNullParameter(traceable, "traceable");
                c().put(uniqueId, "init");
                f(uniqueId, d(traceable));
            }
        }

        public final void f(BdUniqueId bdUniqueId, qo5 qo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdUniqueId, qo5Var) == null) {
                mq6.b().b(new lq6(bdUniqueId, Reflection.getOrCreateKotlinClass(ro5.class)), new b(bdUniqueId, qo5Var, ro5.class));
            }
        }

        public final qo5 d(qza qzaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qzaVar)) == null) {
                return new C0475a(qzaVar);
            }
            return (qo5) invokeL.objValue;
        }

        public final void g(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
                mq6.b().c(new ro5(bdUniqueId, "start"));
            }
        }

        public final void h(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
                mq6.b().c(new ro5(bdUniqueId, "stop"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158160, "Lcom/baidu/tieba/so5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158160, "Lcom/baidu/tieba/so5;");
                return;
            }
        }
        a = new a(null);
        b = new HashMap<>();
        c = new HashMap<>();
    }
}
