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
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a extends e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f55212b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<ComponentName, IBinder> f55213c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<ComponentName, b> f55214d;

    /* renamed from: e  reason: collision with root package name */
    public final C2019a<Intent> f55215e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<ComponentName, com.bytedance.pangle.service.a> f55216f;

    /* renamed from: g  reason: collision with root package name */
    public final HashSet<ComponentName> f55217g;

    /* renamed from: h  reason: collision with root package name */
    public final HashSet<ComponentName> f55218h;

    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2019a<T> extends HashMap<g, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C2019a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (obj instanceof g) {
                    for (g gVar : keySet()) {
                        try {
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (gVar.a() == ((g) obj).a()) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            InterceptResult invokeL;
            g gVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                T t = (T) super.remove(obj);
                if (t != null) {
                    return t;
                }
                Iterator<g> it = keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gVar = null;
                        break;
                    }
                    gVar = it.next();
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    if (gVar.a() == ((g) obj).a()) {
                        break;
                    }
                }
                return (T) super.remove(gVar);
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HashSet<g> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (obj instanceof g) {
                    Iterator<g> it = iterator();
                    while (it.hasNext()) {
                        try {
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (it.next().a() == ((g) obj).a()) {
                            return true;
                        }
                    }
                    return false;
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
                g gVar = null;
                Iterator<g> it = iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    if (next.a() == ((g) obj).a()) {
                        gVar = next;
                        break;
                    }
                }
                return super.remove(gVar);
            }
            return invokeL.booleanValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55213c = new HashMap<>();
        this.f55214d = new HashMap<>();
        this.f55215e = new C2019a<>(this);
        this.f55216f = new HashMap<>();
        this.f55217g = new HashSet<>();
        this.f55218h = new HashSet<>();
        this.a = new Handler(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f55212b == null) {
                synchronized (a.class) {
                    if (f55212b == null) {
                        f55212b = new a();
                    }
                }
            }
            return f55212b;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, intent, str)) == null) {
            synchronized (this) {
                ComponentName component = intent.getComponent();
                if (!this.f55216f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return component;
                    }
                    this.f55216f.put(component, d2);
                    this.f55217g.add(component);
                }
                com.bytedance.pangle.service.a aVar = this.f55216f.get(component);
                if (aVar != null) {
                    aVar.onStartCommand(intent, 0, 0);
                }
                return component;
            }
        }
        return (ComponentName) invokeLL.objValue;
    }

    public static com.bytedance.pangle.service.a d(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, intent, str)) == null) {
            com.bytedance.pangle.service.a e2 = e(intent, str);
            if (e2 != null) {
                e2.onCreate();
            }
            return e2;
        }
        return (com.bytedance.pangle.service.a) invokeLL.objValue;
    }

    public static com.bytedance.pangle.service.a e(Intent intent, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, intent, str)) == null) {
            ComponentName component = intent.getComponent();
            Plugin plugin2 = PluginManager.getInstance().getPlugin(str);
            try {
                z = Zeus.loadPlugin(str);
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin2.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin2);
                return aVar;
            } catch (Exception e3) {
                e = e3;
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
                throw new RuntimeException(e);
            }
        }
        return (com.bytedance.pangle.service.a) invokeLL.objValue;
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // com.bytedance.pangle.e
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

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f55219b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f55220c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55220c = this;
                    this.a = intent;
                    this.f55219b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f55220c.c(this.a, this.f55219b);
                    }
                }
            });
            return intent.getComponent();
        }
        return (ComponentName) invokeLL.objValue;
    }

    @Override // com.bytedance.pangle.e
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

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f55221b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55221b = this;
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

    public final synchronized boolean a(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName)) == null) {
            synchronized (this) {
                if (this.f55216f.containsKey(componentName)) {
                    this.f55218h.add(componentName);
                    return b(componentName);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean b(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, componentName)) == null) {
            if (!this.f55217g.contains(componentName)) {
                if (this.f55214d.get(componentName) == null) {
                    c(componentName);
                    return true;
                }
                return false;
            } else if (!this.f55218h.contains(componentName) || this.f55214d.containsKey(componentName)) {
                return false;
            } else {
                c(componentName);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private void c(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, componentName) == null) {
            com.bytedance.pangle.service.a remove = this.f55216f.remove(componentName);
            this.f55218h.remove(componentName);
            this.f55213c.remove(componentName);
            this.f55217g.remove(componentName);
            if (remove != null) {
                remove.onDestroy();
            }
        }
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(Intent intent, g gVar, int i2, String str) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048579, this, intent, gVar, i2, str)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, gVar, str);
            }
            this.a.post(new Runnable(this, intent, gVar, i2, str) { // from class: com.bytedance.pangle.service.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Intent a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f55222b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f55223c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f55224d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f55225e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, gVar, Integer.valueOf(i2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55225e = this;
                    this.a = intent;
                    this.f55222b = gVar;
                    this.f55223c = i2;
                    this.f55224d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f55225e.a(this.a, this.f55222b, this.f55224d);
                        } catch (RemoteException e2) {
                            ZeusLogger.e(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                        }
                    }
                }
            });
            return true;
        }
        return invokeLLIL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, g gVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, intent, gVar, str)) == null) {
            synchronized (this) {
                ComponentName component = intent.getComponent();
                if (!this.f55216f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return false;
                    }
                    this.f55216f.put(component, d2);
                }
                com.bytedance.pangle.service.a aVar = this.f55216f.get(component);
                if (!this.f55213c.containsKey(component)) {
                    this.f55213c.put(component, aVar.onBind(intent));
                }
                IBinder iBinder = this.f55213c.get(component);
                if (iBinder != null) {
                    if (this.f55214d.containsKey(component)) {
                        if (!this.f55214d.get(component).contains(gVar)) {
                            this.f55214d.get(component).add(gVar);
                            this.f55215e.put(gVar, intent);
                            gVar.a(component, iBinder);
                        }
                    } else {
                        b bVar = new b(this);
                        bVar.add(gVar);
                        this.f55214d.put(component, bVar);
                        this.f55215e.put(gVar, intent);
                        gVar.a(component, iBinder);
                    }
                }
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, gVar) == null) {
            synchronized (this) {
                for (ComponentName componentName : this.f55214d.keySet()) {
                    b bVar = this.f55214d.get(componentName);
                    if (bVar.contains(gVar)) {
                        bVar.remove(gVar);
                        Intent remove = this.f55215e.remove(gVar);
                        if (bVar.size() == 0) {
                            this.f55214d.remove(componentName);
                            com.bytedance.pangle.service.a aVar = this.f55216f.get(componentName);
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

    @Override // com.bytedance.pangle.e
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(gVar);
            } else {
                this.a.post(new Runnable(this, gVar) { // from class: com.bytedance.pangle.service.a.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ g a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f55226b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f55226b = this;
                        this.a = gVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f55226b.b(this.a);
                        }
                    }
                });
            }
        }
    }
}
