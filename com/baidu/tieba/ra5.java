package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ra5 {
    public static /* synthetic */ Interceptable $ic;
    public static ra5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map b;
    public final Map c;
    public final Handler d;
    public na5 e;
    public final ma5 f;
    public final sp4 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948114915, "Lcom/baidu/tieba/ra5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948114915, "Lcom/baidu/tieba/ra5;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ma5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra5 a;

        public a(ra5 ra5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra5Var;
        }

        @Override // com.baidu.tieba.ma5
        public void a(ka5 ka5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ka5Var) != null) {
                return;
            }
            this.a.d(ka5Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka5 a;
        public final /* synthetic */ ra5 b;

        public b(ra5 ra5Var, ka5 ka5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra5Var, ka5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ra5Var;
            this.a = ka5Var;
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
    public class c extends sp4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra5 a;

        public c(ra5 ra5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra5Var;
        }

        @Override // com.baidu.tieba.sp4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public ra5() {
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

    public void l(Class cls, la5 la5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, la5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, la5Var);
        }
    }

    public static ra5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (ra5.class) {
                    if (h == null) {
                        h = new ra5();
                    }
                }
            }
            return h;
        }
        return (ra5) invokeV.objValue;
    }

    public static void i(ka5 ka5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ka5Var) == null) {
            f().h(ka5Var);
        }
    }

    public final void d(ka5 ka5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ka5Var) == null) {
            if (fj.C()) {
                c(ka5Var);
            } else {
                this.d.post(new b(this, ka5Var));
            }
        }
    }

    public void g(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        pa5.g();
        k(application);
        oa5 oa5Var = new oa5(application);
        this.e = oa5Var;
        oa5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(ka5 ka5Var) {
        na5 na5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ka5Var) == null) && (na5Var = this.e) != null) {
            na5Var.a(ka5Var);
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

    public final void c(ka5 ka5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ka5Var) != null) || ka5Var == null) {
            return;
        }
        Class<?> cls = ka5Var.getClass();
        try {
            la5 la5Var = (la5) this.b.get(cls);
            if (la5Var != null) {
                la5Var.onEvent(ka5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            List<sa5> list = (List) this.c.get(cls);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int myPid = Process.myPid();
            for (sa5 sa5Var : list) {
                if (sa5Var != null && (!sa5Var.isSelfListener() || (ka5Var.getPid() == myPid && sa5Var.getTag() != null && sa5Var.getTag().getId() == ka5Var.getTag()))) {
                    try {
                        sa5Var.onEvent(ka5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(Class cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject c2 = qa5.c(cls.getSimpleName(), cls);
            if (c2 instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) c2;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(ka5 ka5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ka5Var) == null) {
            if (!pa5.i()) {
                String c2 = pa5.c();
                pa5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = ka5Var.getPid();
            if (ka5Var.getType() == 2 && myPid == pid) {
                d(ka5Var);
            } else {
                j(ka5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry entry : this.c.entrySet()) {
            List list = (List) entry.getValue();
            if (!ListUtils.isEmpty(list)) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    sa5 sa5Var = (sa5) it.next();
                    if (sa5Var != null && sa5Var.getTag() != null && sa5Var.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(Class cls, sa5 sa5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, sa5Var, bdUniqueId) == null) {
            LinkedList linkedList = (LinkedList) this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(sa5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            sa5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, sa5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(Class cls, sa5 sa5Var, r9 r9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, sa5Var, r9Var) == null) {
            if (r9Var != null) {
                bdUniqueId = r9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, sa5Var, bdUniqueId);
        }
    }
}
