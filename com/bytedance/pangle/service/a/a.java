package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes11.dex */
public class a extends e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f61492b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f61493a;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<ComponentName, IBinder> f61494c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<ComponentName, b> f61495d;

    /* renamed from: e  reason: collision with root package name */
    public final C1847a<Intent> f61496e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<ComponentName, com.bytedance.pangle.service.a> f61497f;

    /* renamed from: g  reason: collision with root package name */
    public final HashSet<ComponentName> f61498g;

    /* renamed from: h  reason: collision with root package name */
    public final HashSet<ComponentName> f61499h;

    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1847a<T> extends HashMap<g, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61512a;

        public C1847a(a aVar) {
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
            this.f61512a = aVar;
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

    /* loaded from: classes11.dex */
    public class b extends HashSet<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61513a;

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
            this.f61513a = aVar;
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
        this.f61494c = new HashMap<>();
        this.f61495d = new HashMap<>();
        this.f61496e = new C1847a<>(this);
        this.f61497f = new HashMap<>();
        this.f61498g = new HashSet<>();
        this.f61499h = new HashSet<>();
        this.f61493a = new Handler(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f61492b == null) {
                synchronized (a.class) {
                    if (f61492b == null) {
                        f61492b = new a();
                    }
                }
            }
            return f61492b;
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
                if (!this.f61497f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return component;
                    }
                    this.f61497f.put(component, d2);
                    this.f61498g.add(component);
                }
                com.bytedance.pangle.service.a aVar = this.f61497f.get(component);
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
            this.f61493a.post(new Runnable(this, intent, str) { // from class: com.bytedance.pangle.service.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f61500a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f61501b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f61502c;

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
                    this.f61502c = this;
                    this.f61500a = intent;
                    this.f61501b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61502c.c(this.f61500a, this.f61501b);
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
            this.f61493a.post(new Runnable(this, intent) { // from class: com.bytedance.pangle.service.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f61503a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61504b;

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
                    this.f61504b = this;
                    this.f61503a = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a.b().a(this.f61503a.getComponent());
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
                if (this.f61497f.containsKey(componentName)) {
                    this.f61499h.add(componentName);
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
            if (!this.f61498g.contains(componentName)) {
                if (this.f61495d.get(componentName) == null) {
                    c(componentName);
                    return true;
                }
                return false;
            } else if (!this.f61499h.contains(componentName) || this.f61495d.containsKey(componentName)) {
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
            com.bytedance.pangle.service.a remove = this.f61497f.remove(componentName);
            this.f61499h.remove(componentName);
            this.f61494c.remove(componentName);
            this.f61498g.remove(componentName);
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
            this.f61493a.post(new Runnable(this, intent, gVar, i2, str) { // from class: com.bytedance.pangle.service.a.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Intent f61505a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f61506b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61507c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f61508d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f61509e;

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
                    this.f61509e = this;
                    this.f61505a = intent;
                    this.f61506b = gVar;
                    this.f61507c = i2;
                    this.f61508d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f61509e.a(this.f61505a, this.f61506b, this.f61508d);
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
                if (!this.f61497f.containsKey(component)) {
                    com.bytedance.pangle.service.a d2 = d(intent, str);
                    if (d2 == null) {
                        return false;
                    }
                    this.f61497f.put(component, d2);
                }
                com.bytedance.pangle.service.a aVar = this.f61497f.get(component);
                if (!this.f61494c.containsKey(component)) {
                    this.f61494c.put(component, aVar.onBind(intent));
                }
                IBinder iBinder = this.f61494c.get(component);
                if (iBinder != null) {
                    if (this.f61495d.containsKey(component)) {
                        if (!this.f61495d.get(component).contains(gVar)) {
                            this.f61495d.get(component).add(gVar);
                            this.f61496e.put(gVar, intent);
                            gVar.a(component, iBinder);
                        }
                    } else {
                        b bVar = new b(this);
                        bVar.add(gVar);
                        this.f61495d.put(component, bVar);
                        this.f61496e.put(gVar, intent);
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, gVar) == null) {
            synchronized (this) {
                for (ComponentName componentName : this.f61495d.keySet()) {
                    b bVar = this.f61495d.get(componentName);
                    if (bVar.contains(gVar)) {
                        bVar.remove(gVar);
                        Intent remove = this.f61496e.remove(gVar);
                        if (bVar.size() == 0) {
                            this.f61495d.remove(componentName);
                            com.bytedance.pangle.service.a aVar = this.f61497f.get(componentName);
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
                this.f61493a.post(new Runnable(this, gVar) { // from class: com.bytedance.pangle.service.a.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ g f61510a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f61511b;

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
                        this.f61511b = this;
                        this.f61510a = gVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61511b.b(this.f61510a);
                        }
                    }
                });
            }
        }
    }
}
