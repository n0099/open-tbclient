package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class na5 {
    public static /* synthetic */ Interceptable $ic;
    public static na5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends ga5>, ha5> b;
    public final Map<Class<? extends ga5>, LinkedList<oa5>> c;
    public final Handler d;
    public ja5 e;
    public final ia5 f;
    public final rp4 g;

    /* loaded from: classes5.dex */
    public class a implements ia5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na5 a;

        public a(na5 na5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na5Var;
        }

        @Override // com.baidu.tieba.ia5
        public void a(ga5 ga5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ga5Var) == null) {
                this.a.d(ga5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga5 a;
        public final /* synthetic */ na5 b;

        public b(na5 na5Var, ga5 ga5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na5Var, ga5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = na5Var;
            this.a = ga5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends rp4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na5 a;

        public c(na5 na5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na5Var;
        }

        @Override // com.baidu.tieba.rp4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947995751, "Lcom/baidu/tieba/na5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947995751, "Lcom/baidu/tieba/na5;");
        }
    }

    public na5() {
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
        this.a = false;
        this.d = new Handler(Looper.getMainLooper());
        this.f = new a(this);
        this.g = new c(this);
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public static na5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (na5.class) {
                    if (h == null) {
                        h = new na5();
                    }
                }
            }
            return h;
        }
        return (na5) invokeV.objValue;
    }

    public static void i(@NonNull ga5 ga5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ga5Var) == null) {
            f().h(ga5Var);
        }
    }

    public final void c(ga5 ga5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ga5Var) == null) || ga5Var == null) {
            return;
        }
        Class<?> cls = ga5Var.getClass();
        try {
            ha5 ha5Var = this.b.get(cls);
            if (ha5Var != null) {
                ha5Var.onEvent(ga5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<oa5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (oa5 oa5Var : linkedList) {
                if (oa5Var != null && (!oa5Var.isSelfListener() || (ga5Var.getPid() == myPid && oa5Var.getTag() != null && oa5Var.getTag().getId() == ga5Var.getTag()))) {
                    try {
                        oa5Var.onEvent(ga5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void d(ga5 ga5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ga5Var) == null) {
            if (ej.C()) {
                c(ga5Var);
            } else {
                this.d.post(new b(this, ga5Var));
            }
        }
    }

    public final void e(@NonNull Class<? extends ga5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject d = ma5.d(cls.getSimpleName(), cls);
            if (d instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) d;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, application) == null) || this.a) {
            return;
        }
        la5.g();
        k(application);
        ka5 ka5Var = new ka5(application);
        this.e = ka5Var;
        ka5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public void h(@NonNull ga5 ga5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ga5Var) == null) {
            if (!la5.i()) {
                String c2 = la5.c();
                la5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = ga5Var.getPid();
            if (ga5Var.getType() == 2 && myPid == pid) {
                d(ga5Var);
            } else {
                j(ga5Var);
            }
        }
    }

    public final void j(ga5 ga5Var) {
        ja5 ja5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ga5Var) == null) || (ja5Var = this.e) == null) {
            return;
        }
        ja5Var.a(ga5Var);
    }

    public final void k(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, application) == null) {
            try {
                application.registerActivityLifecycleCallbacks(this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void l(@NonNull Class<? extends ga5> cls, @NonNull ha5 ha5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, ha5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, ha5Var);
        }
    }

    public void m(@NonNull Class<? extends ga5> cls, @NonNull oa5 oa5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, oa5Var, bdUniqueId) == null) {
            LinkedList<oa5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(oa5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            oa5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, oa5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends ga5> cls, @NonNull oa5 oa5Var, r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, oa5Var, r9Var) == null) {
            m(cls, oa5Var, r9Var != null ? r9Var.getUniqueId() : null);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends ga5>, LinkedList<oa5>> entry : this.c.entrySet()) {
            LinkedList<oa5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<oa5> it = value.iterator();
                while (it.hasNext()) {
                    oa5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
