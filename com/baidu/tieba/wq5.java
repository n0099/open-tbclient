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
/* loaded from: classes8.dex */
public class wq5 {
    public static /* synthetic */ Interceptable $ic;
    public static wq5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends pq5>, qq5> b;
    public final Map<Class<? extends pq5>, LinkedList<xq5>> c;
    public final Handler d;
    public sq5 e;
    public final rq5 f;
    public final j05 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948279246, "Lcom/baidu/tieba/wq5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948279246, "Lcom/baidu/tieba/wq5;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements rq5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq5 a;

        public a(wq5 wq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq5Var;
        }

        @Override // com.baidu.tieba.rq5
        public void a(pq5 pq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pq5Var) != null) {
                return;
            }
            this.a.d(pq5Var);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq5 a;
        public final /* synthetic */ wq5 b;

        public b(wq5 wq5Var, pq5 pq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq5Var, pq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wq5Var;
            this.a = pq5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq5 a;

        public c(wq5 wq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq5Var;
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public wq5() {
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

    public void l(@NonNull Class<? extends pq5> cls, @NonNull qq5 qq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, qq5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, qq5Var);
        }
    }

    public static wq5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (wq5.class) {
                    if (h == null) {
                        h = new wq5();
                    }
                }
            }
            return h;
        }
        return (wq5) invokeV.objValue;
    }

    public static void i(@NonNull pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, pq5Var) == null) {
            f().h(pq5Var);
        }
    }

    public final void d(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pq5Var) == null) {
            if (yi.F()) {
                c(pq5Var);
            } else {
                this.d.post(new b(this, pq5Var));
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        uq5.g();
        k(application);
        tq5 tq5Var = new tq5(application);
        this.e = tq5Var;
        tq5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(pq5 pq5Var) {
        sq5 sq5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pq5Var) == null) && (sq5Var = this.e) != null) {
            sq5Var.a(pq5Var);
        }
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

    public final void c(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pq5Var) != null) || pq5Var == null) {
            return;
        }
        Class<?> cls = pq5Var.getClass();
        try {
            qq5 qq5Var = this.b.get(cls);
            if (qq5Var != null) {
                qq5Var.onEvent(pq5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<xq5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (xq5 xq5Var : linkedList) {
                if (xq5Var != null && (!xq5Var.isSelfListener() || (pq5Var.getPid() == myPid && xq5Var.getTag() != null && xq5Var.getTag().getId() == pq5Var.getTag()))) {
                    try {
                        xq5Var.onEvent(pq5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(@NonNull Class<? extends pq5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject f = vq5.f(cls.getSimpleName(), cls);
            if (f instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) f;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(@NonNull pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pq5Var) == null) {
            if (!uq5.i()) {
                String c2 = uq5.c();
                uq5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = pq5Var.getPid();
            if (pq5Var.getType() == 2 && myPid == pid) {
                d(pq5Var);
            } else {
                j(pq5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends pq5>, LinkedList<xq5>> entry : this.c.entrySet()) {
            LinkedList<xq5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<xq5> it = value.iterator();
                while (it.hasNext()) {
                    xq5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(@NonNull Class<? extends pq5> cls, @NonNull xq5 xq5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, xq5Var, bdUniqueId) == null) {
            LinkedList<xq5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(xq5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            xq5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, xq5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends pq5> cls, @NonNull xq5 xq5Var, l9 l9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, xq5Var, l9Var) == null) {
            if (l9Var != null) {
                bdUniqueId = l9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, xq5Var, bdUniqueId);
        }
    }
}
