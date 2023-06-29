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
/* loaded from: classes7.dex */
public class sp5 {
    public static /* synthetic */ Interceptable $ic;
    public static sp5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends lp5>, mp5> b;
    public final Map<Class<? extends lp5>, LinkedList<tp5>> c;
    public final Handler d;
    public op5 e;
    public final np5 f;
    public final a05 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948159121, "Lcom/baidu/tieba/sp5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948159121, "Lcom/baidu/tieba/sp5;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements np5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp5 a;

        public a(sp5 sp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp5Var;
        }

        @Override // com.baidu.tieba.np5
        public void a(lp5 lp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, lp5Var) != null) {
                return;
            }
            this.a.d(lp5Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp5 a;
        public final /* synthetic */ sp5 b;

        public b(sp5 sp5Var, lp5 lp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp5Var, lp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sp5Var;
            this.a = lp5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends a05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp5 a;

        public c(sp5 sp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp5Var;
        }

        @Override // com.baidu.tieba.a05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public sp5() {
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

    public void l(@NonNull Class<? extends lp5> cls, @NonNull mp5 mp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, mp5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, mp5Var);
        }
    }

    public static sp5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (sp5.class) {
                    if (h == null) {
                        h = new sp5();
                    }
                }
            }
            return h;
        }
        return (sp5) invokeV.objValue;
    }

    public static void i(@NonNull lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, lp5Var) == null) {
            f().h(lp5Var);
        }
    }

    public final void d(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp5Var) == null) {
            if (xi.E()) {
                c(lp5Var);
            } else {
                this.d.post(new b(this, lp5Var));
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        qp5.g();
        k(application);
        pp5 pp5Var = new pp5(application);
        this.e = pp5Var;
        pp5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(lp5 lp5Var) {
        op5 op5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, lp5Var) == null) && (op5Var = this.e) != null) {
            op5Var.a(lp5Var);
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

    public final void c(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, lp5Var) != null) || lp5Var == null) {
            return;
        }
        Class<?> cls = lp5Var.getClass();
        try {
            mp5 mp5Var = this.b.get(cls);
            if (mp5Var != null) {
                mp5Var.onEvent(lp5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<tp5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (tp5 tp5Var : linkedList) {
                if (tp5Var != null && (!tp5Var.isSelfListener() || (lp5Var.getPid() == myPid && tp5Var.getTag() != null && tp5Var.getTag().getId() == lp5Var.getTag()))) {
                    try {
                        tp5Var.onEvent(lp5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(@NonNull Class<? extends lp5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject f = rp5.f(cls.getSimpleName(), cls);
            if (f instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) f;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(@NonNull lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lp5Var) == null) {
            if (!qp5.i()) {
                String c2 = qp5.c();
                qp5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = lp5Var.getPid();
            if (lp5Var.getType() == 2 && myPid == pid) {
                d(lp5Var);
            } else {
                j(lp5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends lp5>, LinkedList<tp5>> entry : this.c.entrySet()) {
            LinkedList<tp5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<tp5> it = value.iterator();
                while (it.hasNext()) {
                    tp5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(@NonNull Class<? extends lp5> cls, @NonNull tp5 tp5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, tp5Var, bdUniqueId) == null) {
            LinkedList<tp5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(tp5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            tp5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, tp5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends lp5> cls, @NonNull tp5 tp5Var, l9 l9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, tp5Var, l9Var) == null) {
            if (l9Var != null) {
                bdUniqueId = l9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, tp5Var, bdUniqueId);
        }
    }
}
