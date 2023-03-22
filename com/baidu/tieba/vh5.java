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
/* loaded from: classes6.dex */
public class vh5 {
    public static /* synthetic */ Interceptable $ic;
    public static vh5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends oh5>, ph5> b;
    public final Map<Class<? extends oh5>, LinkedList<wh5>> c;
    public final Handler d;
    public rh5 e;
    public final qh5 f;
    public final yu4 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948240806, "Lcom/baidu/tieba/vh5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948240806, "Lcom/baidu/tieba/vh5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements qh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh5 a;

        public a(vh5 vh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh5Var;
        }

        @Override // com.baidu.tieba.qh5
        public void a(oh5 oh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, oh5Var) != null) {
                return;
            }
            this.a.d(oh5Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh5 a;
        public final /* synthetic */ vh5 b;

        public b(vh5 vh5Var, oh5 oh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh5Var, oh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh5Var;
            this.a = oh5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends yu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh5 a;

        public c(vh5 vh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh5Var;
        }

        @Override // com.baidu.tieba.yu4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public vh5() {
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

    public void l(@NonNull Class<? extends oh5> cls, @NonNull ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, ph5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, ph5Var);
        }
    }

    public static vh5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (vh5.class) {
                    if (h == null) {
                        h = new vh5();
                    }
                }
            }
            return h;
        }
        return (vh5) invokeV.objValue;
    }

    public static void i(@NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, oh5Var) == null) {
            f().h(oh5Var);
        }
    }

    public final void d(oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oh5Var) == null) {
            if (hi.E()) {
                c(oh5Var);
            } else {
                this.d.post(new b(this, oh5Var));
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        th5.g();
        k(application);
        sh5 sh5Var = new sh5(application);
        this.e = sh5Var;
        sh5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(oh5 oh5Var) {
        rh5 rh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, oh5Var) == null) && (rh5Var = this.e) != null) {
            rh5Var.a(oh5Var);
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

    public final void c(oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, oh5Var) != null) || oh5Var == null) {
            return;
        }
        Class<?> cls = oh5Var.getClass();
        try {
            ph5 ph5Var = this.b.get(cls);
            if (ph5Var != null) {
                ph5Var.onEvent(oh5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<wh5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (wh5 wh5Var : linkedList) {
                if (wh5Var != null && (!wh5Var.isSelfListener() || (oh5Var.getPid() == myPid && wh5Var.getTag() != null && wh5Var.getTag().getId() == oh5Var.getTag()))) {
                    try {
                        wh5Var.onEvent(oh5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(@NonNull Class<? extends oh5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject d = uh5.d(cls.getSimpleName(), cls);
            if (d instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) d;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(@NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oh5Var) == null) {
            if (!th5.i()) {
                String c2 = th5.c();
                th5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = oh5Var.getPid();
            if (oh5Var.getType() == 2 && myPid == pid) {
                d(oh5Var);
            } else {
                j(oh5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends oh5>, LinkedList<wh5>> entry : this.c.entrySet()) {
            LinkedList<wh5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<wh5> it = value.iterator();
                while (it.hasNext()) {
                    wh5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(@NonNull Class<? extends oh5> cls, @NonNull wh5 wh5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, wh5Var, bdUniqueId) == null) {
            LinkedList<wh5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(wh5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            wh5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, wh5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends oh5> cls, @NonNull wh5 wh5Var, a9 a9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, wh5Var, a9Var) == null) {
            if (a9Var != null) {
                bdUniqueId = a9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, wh5Var, bdUniqueId);
        }
    }
}
