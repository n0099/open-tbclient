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
/* loaded from: classes3.dex */
public class a extends d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f53326b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<ComponentName, IBinder> f53327c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<ComponentName, b> f53328d;

    /* renamed from: e  reason: collision with root package name */
    public final C2059a<Intent> f53329e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<ComponentName, com.bytedance.pangle.service.a> f53330f;

    /* renamed from: g  reason: collision with root package name */
    public final HashSet<ComponentName> f53331g;

    /* renamed from: h  reason: collision with root package name */
    public final HashSet<ComponentName> f53332h;

    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C2059a<T> extends HashMap<f, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C2059a(a aVar) {
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
                if (obj instanceof f) {
                    for (f fVar : keySet()) {
                        try {
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (fVar.a() == ((f) obj).a()) {
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
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                T t = (T) super.remove(obj);
                if (t != null) {
                    return t;
                }
                Iterator<f> it = keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        fVar = null;
                        break;
                    }
                    fVar = it.next();
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    if (fVar.a() == ((f) obj).a()) {
                        break;
                    }
                }
                return (T) super.remove(fVar);
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if (obj instanceof f) {
                    Iterator<f> it = iterator();
                    while (it.hasNext()) {
                        try {
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (it.next().a() == ((f) obj).a()) {
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
                f fVar = null;
                Iterator<f> it = iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    try {
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53327c = new HashMap<>();
        this.f53328d = new HashMap<>();
        this.f53329e = new C2059a<>(this);
        this.f53330f = new HashMap<>();
        this.f53331g = new HashSet<>();
        this.f53332h = new HashSet<>();
        this.a = new Handler(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f53326b == null) {
                synchronized (a.class) {
                    if (f53326b == null) {
                        f53326b = new a();
                    }
                }
            }
            return f53326b;
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
                if (!this.f53330f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return component;
                    }
                    this.f53330f.put(component, d2);
                    this.f53331g.add(component);
                }
                com.bytedance.pangle.service.a aVar = this.f53330f.get(component);
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

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
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

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53333b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f53334c;

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
                    this.f53334c = this;
                    this.a = intent;
                    this.f53333b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f53334c.c(this.a, this.f53333b);
                    }
                }
            });
            return intent.getComponent();
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

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f53335b;

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
                    this.f53335b = this;
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
                if (this.f53330f.containsKey(componentName)) {
                    this.f53332h.add(componentName);
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
            if (!this.f53331g.contains(componentName)) {
                if (this.f53328d.get(componentName) == null) {
                    c(componentName);
                    return true;
                }
                return false;
            } else if (!this.f53332h.contains(componentName) || this.f53328d.containsKey(componentName)) {
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
            com.bytedance.pangle.service.a remove = this.f53330f.remove(componentName);
            this.f53332h.remove(componentName);
            this.f53327c.remove(componentName);
            this.f53331g.remove(componentName);
            if (remove != null) {
                remove.onDestroy();
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(Intent intent, f fVar, int i2, String str) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048579, this, intent, fVar, i2, str)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, fVar, str);
            }
            this.a.post(new Runnable(this, intent, fVar, i2, str) { // from class: com.bytedance.pangle.service.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Intent a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f53336b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f53337c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f53338d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f53339e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, intent, fVar, Integer.valueOf(i2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53339e = this;
                    this.a = intent;
                    this.f53336b = fVar;
                    this.f53337c = i2;
                    this.f53338d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f53339e.a(this.a, this.f53336b, this.f53338d);
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
    public synchronized boolean a(Intent intent, f fVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, intent, fVar, str)) == null) {
            synchronized (this) {
                ComponentName component = intent.getComponent();
                if (!this.f53330f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return false;
                    }
                    this.f53330f.put(component, d2);
                }
                com.bytedance.pangle.service.a aVar = this.f53330f.get(component);
                if (!this.f53327c.containsKey(component)) {
                    this.f53327c.put(component, aVar.onBind(intent));
                }
                IBinder iBinder = this.f53327c.get(component);
                if (iBinder != null) {
                    if (this.f53328d.containsKey(component)) {
                        if (!this.f53328d.get(component).contains(fVar)) {
                            this.f53328d.get(component).add(fVar);
                            this.f53329e.put(fVar, intent);
                            fVar.a(component, iBinder);
                        }
                    } else {
                        b bVar = new b(this);
                        bVar.add(fVar);
                        this.f53328d.put(component, bVar);
                        this.f53329e.put(fVar, intent);
                        fVar.a(component, iBinder);
                    }
                }
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fVar) == null) {
            synchronized (this) {
                for (ComponentName componentName : this.f53328d.keySet()) {
                    b bVar = this.f53328d.get(componentName);
                    if (bVar.contains(fVar)) {
                        bVar.remove(fVar);
                        Intent remove = this.f53329e.remove(fVar);
                        if (bVar.size() == 0) {
                            this.f53328d.remove(componentName);
                            com.bytedance.pangle.service.a aVar = this.f53330f.get(componentName);
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

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f53340b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53340b = this;
                        this.a = fVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f53340b.b(this.a);
                        }
                    }
                });
            }
        }
    }
}
