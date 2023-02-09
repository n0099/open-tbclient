package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a extends d.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final HashMap<ComponentName, IBinder> c;
    public final HashMap<ComponentName, b> d;
    public final C0530a<Intent> e;
    public final HashMap<ComponentName, com.bytedance.pangle.service.a> f;
    public final HashSet<ComponentName> g;
    public final HashSet<ComponentName> h;

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0530a<T> extends HashMap<f, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0530a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.containsKey(obj)) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                for (f fVar : keySet()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (fVar.a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            InterceptResult invokeL;
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                T t = (T) super.remove(obj);
                if (t != null) {
                    return t;
                }
                Iterator<f> it = keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        fVar = it.next();
                        try {
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if (fVar.a() == ((f) obj).a()) {
                            break;
                        }
                    } else {
                        fVar = null;
                        break;
                    }
                }
                return (T) super.remove(fVar);
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HashSet<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (super.contains(obj)) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                Iterator<f> it = iterator();
                while (it.hasNext()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (it.next().a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (super.remove(obj)) {
                    return true;
                }
                f fVar = null;
                Iterator<f> it = iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (next.a() == ((f) obj).a()) {
                        fVar = next;
                        break;
                    }
                }
                return super.remove(fVar);
            }
            return invokeL.booleanValue;
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
                return;
            }
        }
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.e = new C0530a<>(this);
        this.f = new HashMap<>();
        this.g = new HashSet<>();
        this.h = new HashSet<>();
        this.a = new Handler(Looper.getMainLooper());
    }

    public static com.bytedance.pangle.service.a d(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, intent, str)) == null) {
            com.bytedance.pangle.service.a e = e(intent, str);
            if (e != null) {
                e.onCreate();
            }
            return e;
        }
        return (com.bytedance.pangle.service.a) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, f fVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, intent, fVar, str)) == null) {
            synchronized (this) {
                ComponentName component = intent.getComponent();
                if (!this.f.containsKey(component)) {
                    com.bytedance.pangle.service.a d = d(intent, str);
                    if (d == null) {
                        return false;
                    }
                    this.f.put(component, d);
                }
                com.bytedance.pangle.service.a aVar = this.f.get(component);
                if (!this.c.containsKey(component)) {
                    this.c.put(component, aVar.onBind(intent));
                }
                IBinder iBinder = this.c.get(component);
                if (iBinder != null) {
                    if (this.d.containsKey(component)) {
                        if (!this.d.get(component).contains(fVar)) {
                            this.d.get(component).add(fVar);
                            this.e.put(fVar, intent);
                            fVar.a(component, iBinder);
                        }
                    } else {
                        b bVar = new b(this);
                        bVar.add(fVar);
                        this.d.put(component, bVar);
                        this.e.put(fVar, intent);
                        fVar.a(component, iBinder);
                    }
                }
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new a();
                    }
                }
            }
            return b;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fVar) == null) {
            synchronized (this) {
                for (ComponentName componentName : this.d.keySet()) {
                    b bVar = this.d.get(componentName);
                    if (bVar.contains(fVar)) {
                        bVar.remove(fVar);
                        Intent remove = this.e.remove(fVar);
                        if (bVar.size() == 0) {
                            this.d.remove(componentName);
                            com.bytedance.pangle.service.a aVar = this.f.get(componentName);
                            if (aVar != null) {
                                aVar.onUnbind(remove);
                            }
                        }
                        b(componentName);
                        return;
                    }
                }
            }
        }
    }

    private boolean b(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, componentName)) == null) {
            if (!this.g.contains(componentName)) {
                if (this.d.get(componentName) == null) {
                    c(componentName);
                    return true;
                }
                return false;
            } else if (this.h.contains(componentName) && !this.d.containsKey(componentName)) {
                c(componentName);
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, intent, str)) == null) {
            synchronized (this) {
                ComponentName component = intent.getComponent();
                if (!this.f.containsKey(component)) {
                    com.bytedance.pangle.service.a d = d(intent, str);
                    if (d == null) {
                        return component;
                    }
                    this.f.put(component, d);
                    this.g.add(component);
                }
                com.bytedance.pangle.service.a aVar = this.f.get(component);
                if (aVar != null) {
                    aVar.onStartCommand(intent, 0, 0);
                }
                return component;
            }
        }
        return (ComponentName) invokeLL.objValue;
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, intent, str)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b().a(intent.getComponent());
                return true;
            }
            this.a.post(new Runnable(this, intent) { // from class: com.bytedance.pangle.service.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Intent a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a.b().a(this.a.getComponent());
                    }
                }
            });
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void c(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, componentName) == null) {
            com.bytedance.pangle.service.a remove = this.f.remove(componentName);
            this.h.remove(componentName);
            this.c.remove(componentName);
            this.g.remove(componentName);
            if (remove != null) {
                remove.onDestroy();
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(fVar);
            } else {
                this.a.post(new Runnable(this, fVar) { // from class: com.bytedance.pangle.service.a.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;
                    public final /* synthetic */ a b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = fVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.b.b(this.a);
                    }
                });
            }
        }
    }

    public static com.bytedance.pangle.service.a e(Intent intent, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, intent, str)) == null) {
            ComponentName component = intent.getComponent();
            Plugin plugin = PluginManager.getInstance().getPlugin(str);
            try {
                z = Zeus.loadPlugin(str);
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
                throw new RuntimeException(e);
            }
        }
        return (com.bytedance.pangle.service.a) invokeLL.objValue;
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, intent, str)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return c(intent, str);
            }
            this.a.post(new Runnable(this, intent, str) { // from class: com.bytedance.pangle.service.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Intent a;
                public final /* synthetic */ String b;
                public final /* synthetic */ a c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = intent;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.c.c(this.a, this.b);
                    }
                }
            });
            return intent.getComponent();
        }
        return (ComponentName) invokeLL.objValue;
    }

    public final synchronized boolean a(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName)) == null) {
            synchronized (this) {
                if (this.f.containsKey(componentName)) {
                    this.h.add(componentName);
                    return b(componentName);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(Intent intent, f fVar, int i, String str) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048579, this, intent, fVar, i, str)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, fVar, str);
            }
            this.a.post(new Runnable(this, intent, fVar, i, str) { // from class: com.bytedance.pangle.service.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Intent a;
                public final /* synthetic */ f b;
                public final /* synthetic */ int c;
                public final /* synthetic */ String d;
                public final /* synthetic */ a e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, fVar, Integer.valueOf(i), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = intent;
                    this.b = fVar;
                    this.c = i;
                    this.d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    try {
                        this.e.a(this.a, this.b, this.d);
                    } catch (RemoteException e) {
                        ZeusLogger.e(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                    }
                }
            });
            return true;
        }
        return invokeLLIL.booleanValue;
    }
}
