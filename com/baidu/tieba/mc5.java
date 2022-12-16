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
public class mc5 {
    public static /* synthetic */ Interceptable $ic;
    public static mc5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends fc5>, gc5> b;
    public final Map<Class<? extends fc5>, LinkedList<nc5>> c;
    public final Handler d;
    public ic5 e;
    public final hc5 f;
    public final mq4 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947967882, "Lcom/baidu/tieba/mc5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947967882, "Lcom/baidu/tieba/mc5;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements hc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;

        public a(mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mc5Var;
        }

        @Override // com.baidu.tieba.hc5
        public void a(fc5 fc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, fc5Var) != null) {
                return;
            }
            this.a.d(fc5Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc5 a;
        public final /* synthetic */ mc5 b;

        public b(mc5 mc5Var, fc5 fc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc5Var, fc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mc5Var;
            this.a = fc5Var;
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
    public class c extends mq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;

        public c(mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mc5Var;
        }

        @Override // com.baidu.tieba.mq4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public mc5() {
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

    public void l(@NonNull Class<? extends fc5> cls, @NonNull gc5 gc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, gc5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, gc5Var);
        }
    }

    public static mc5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (mc5.class) {
                    if (h == null) {
                        h = new mc5();
                    }
                }
            }
            return h;
        }
        return (mc5) invokeV.objValue;
    }

    public static void i(@NonNull fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fc5Var) == null) {
            f().h(fc5Var);
        }
    }

    public final void d(fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fc5Var) == null) {
            if (yi.E()) {
                c(fc5Var);
            } else {
                this.d.post(new b(this, fc5Var));
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        kc5.g();
        k(application);
        jc5 jc5Var = new jc5(application);
        this.e = jc5Var;
        jc5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(fc5 fc5Var) {
        ic5 ic5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, fc5Var) == null) && (ic5Var = this.e) != null) {
            ic5Var.a(fc5Var);
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

    public final void c(fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, fc5Var) != null) || fc5Var == null) {
            return;
        }
        Class<?> cls = fc5Var.getClass();
        try {
            gc5 gc5Var = this.b.get(cls);
            if (gc5Var != null) {
                gc5Var.onEvent(fc5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<nc5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (nc5 nc5Var : linkedList) {
                if (nc5Var != null && (!nc5Var.isSelfListener() || (fc5Var.getPid() == myPid && nc5Var.getTag() != null && nc5Var.getTag().getId() == fc5Var.getTag()))) {
                    try {
                        nc5Var.onEvent(fc5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(@NonNull Class<? extends fc5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject d = lc5.d(cls.getSimpleName(), cls);
            if (d instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) d;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(@NonNull fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fc5Var) == null) {
            if (!kc5.i()) {
                String c2 = kc5.c();
                kc5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = fc5Var.getPid();
            if (fc5Var.getType() == 2 && myPid == pid) {
                d(fc5Var);
            } else {
                j(fc5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends fc5>, LinkedList<nc5>> entry : this.c.entrySet()) {
            LinkedList<nc5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<nc5> it = value.iterator();
                while (it.hasNext()) {
                    nc5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(@NonNull Class<? extends fc5> cls, @NonNull nc5 nc5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, nc5Var, bdUniqueId) == null) {
            LinkedList<nc5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(nc5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            nc5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, nc5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends fc5> cls, @NonNull nc5 nc5Var, r9 r9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, nc5Var, r9Var) == null) {
            if (r9Var != null) {
                bdUniqueId = r9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, nc5Var, bdUniqueId);
        }
    }
}
