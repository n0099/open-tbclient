package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes7.dex */
public final class ofc<T> extends rfc<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public final SubjectSubscriptionManager<T> b;

    /* loaded from: classes7.dex */
    public static class a implements gbc<SubjectSubscriptionManager.c<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubjectSubscriptionManager a;

        public a(SubjectSubscriptionManager subjectSubscriptionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subjectSubscriptionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subjectSubscriptionManager;
        }

        @Override // com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.c) ((SubjectSubscriptionManager.c) obj));
        }

        public void call(SubjectSubscriptionManager.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                cVar.b(this.a.getLatest());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031773, "Lcom/baidu/tieba/ofc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031773, "Lcom/baidu/tieba/ofc;");
                return;
            }
        }
        c = new Object[0];
    }

    public static <T> ofc<T> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return S(null, false);
        }
        return (ofc) invokeV.objValue;
    }

    public T T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object latest = this.b.getLatest();
            if (NotificationLite.h(latest)) {
                return (T) NotificationLite.e(latest);
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ofc(sac.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, subjectSubscriptionManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sac.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = subjectSubscriptionManager;
    }

    public static <T> ofc<T> R(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return S(t, true);
        }
        return (ofc) invokeL.objValue;
    }

    public static <T> ofc<T> S(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, t, z)) == null) {
            SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
            if (z) {
                subjectSubscriptionManager.setLatest(NotificationLite.i(t));
            }
            a aVar = new a(subjectSubscriptionManager);
            subjectSubscriptionManager.onAdded = aVar;
            subjectSubscriptionManager.onTerminated = aVar;
            return new ofc<>(subjectSubscriptionManager, subjectSubscriptionManager);
        }
        return (ofc) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.tac
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object b = NotificationLite.b();
                for (SubjectSubscriptionManager.c<T> cVar : this.b.terminate(b)) {
                    cVar.d(b);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tac
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object c2 = NotificationLite.c(th);
                ArrayList arrayList = null;
                for (SubjectSubscriptionManager.c<T> cVar : this.b.terminate(c2)) {
                    try {
                        cVar.d(c2);
                    } catch (Throwable th2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
                ebc.d(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.tac
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object i = NotificationLite.i(t);
                for (SubjectSubscriptionManager.c<T> cVar : this.b.next(i)) {
                    cVar.d(i);
                }
            }
        }
    }
}
