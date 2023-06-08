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
public class ip5 {
    public static /* synthetic */ Interceptable $ic;
    public static ip5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<Class<? extends bp5>, cp5> b;
    public final Map<Class<? extends bp5>, LinkedList<jp5>> c;
    public final Handler d;
    public ep5 e;
    public final dp5 f;
    public final wz4 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947861211, "Lcom/baidu/tieba/ip5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947861211, "Lcom/baidu/tieba/ip5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements dp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip5 a;

        public a(ip5 ip5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ip5Var;
        }

        @Override // com.baidu.tieba.dp5
        public void a(bp5 bp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bp5Var) != null) {
                return;
            }
            this.a.d(bp5Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp5 a;
        public final /* synthetic */ ip5 b;

        public b(ip5 ip5Var, bp5 bp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip5Var, bp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ip5Var;
            this.a = bp5Var;
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
    public class c extends wz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip5 a;

        public c(ip5 ip5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ip5Var;
        }

        @Override // com.baidu.tieba.wz4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.o(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public ip5() {
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

    public void l(@NonNull Class<? extends bp5> cls, @NonNull cp5 cp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, cp5Var) == null) {
            if (this.b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.b.put(cls, cp5Var);
        }
    }

    public static ip5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (ip5.class) {
                    if (h == null) {
                        h = new ip5();
                    }
                }
            }
            return h;
        }
        return (ip5) invokeV.objValue;
    }

    public static void i(@NonNull bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bp5Var) == null) {
            f().h(bp5Var);
        }
    }

    public final void d(bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bp5Var) == null) {
            if (vi.E()) {
                c(bp5Var);
            } else {
                this.d.post(new b(this, bp5Var));
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, application) != null) || this.a) {
            return;
        }
        gp5.g();
        k(application);
        fp5 fp5Var = new fp5(application);
        this.e = fp5Var;
        fp5Var.b(this.f);
        this.e.startService();
        this.a = true;
    }

    public final void j(bp5 bp5Var) {
        ep5 ep5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bp5Var) == null) && (ep5Var = this.e) != null) {
            ep5Var.a(bp5Var);
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

    public final void c(bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bp5Var) != null) || bp5Var == null) {
            return;
        }
        Class<?> cls = bp5Var.getClass();
        try {
            cp5 cp5Var = this.b.get(cls);
            if (cp5Var != null) {
                cp5Var.onEvent(bp5Var);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<jp5> linkedList = this.c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (jp5 jp5Var : linkedList) {
                if (jp5Var != null && (!jp5Var.isSelfListener() || (bp5Var.getPid() == myPid && jp5Var.getTag() != null && jp5Var.getTag().getId() == bp5Var.getTag()))) {
                    try {
                        jp5Var.onEvent(bp5Var);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    public final void e(@NonNull Class<? extends bp5> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject f = hp5.f(cls.getSimpleName(), cls);
            if (f instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) f;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void h(@NonNull bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bp5Var) == null) {
            if (!gp5.i()) {
                String c2 = gp5.c();
                gp5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = bp5Var.getPid();
            if (bp5Var.getType() == 2 && myPid == pid) {
                d(bp5Var);
            } else {
                j(bp5Var);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends bp5>, LinkedList<jp5>> entry : this.c.entrySet()) {
            LinkedList<jp5> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<jp5> it = value.iterator();
                while (it.hasNext()) {
                    jp5 next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m(@NonNull Class<? extends bp5> cls, @NonNull jp5 jp5Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, jp5Var, bdUniqueId) == null) {
            LinkedList<jp5> linkedList = this.c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.c.put(cls, linkedList);
            }
            if (linkedList.contains(jp5Var)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            jp5Var.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, jp5Var);
            e(cls, bdUniqueId);
        }
    }

    public void n(@NonNull Class<? extends bp5> cls, @NonNull jp5 jp5Var, k9 k9Var) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cls, jp5Var, k9Var) == null) {
            if (k9Var != null) {
                bdUniqueId = k9Var.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            m(cls, jp5Var, bdUniqueId);
        }
    }
}
