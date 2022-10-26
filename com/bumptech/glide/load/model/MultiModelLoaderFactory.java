package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class MultiModelLoaderFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final Factory DEFAULT_FACTORY;
    public static final ModelLoader EMPTY_MODEL_LOADER;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set alreadyUsedEntries;
    public final List entries;
    public final Factory factory;
    public final Pools.Pool throwableListPool;

    /* loaded from: classes7.dex */
    public class EmptyModelLoader implements ModelLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
                return null;
            }
            return (ModelLoader.LoadData) invokeCommon.objValue;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public EmptyModelLoader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class dataClass;
        public final ModelLoaderFactory factory;
        public final Class modelClass;

        public Entry(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, modelLoaderFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.modelClass = cls;
            this.dataClass = cls2;
            this.factory = modelLoaderFactory;
        }

        public boolean handles(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                return this.modelClass.isAssignableFrom(cls);
            }
            return invokeL.booleanValue;
        }

        public boolean handles(Class cls, Class cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
                if (handles(cls) && this.dataClass.isAssignableFrom(cls2)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public MultiModelLoader build(List list, Pools.Pool pool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, pool)) == null) {
                return new MultiModelLoader(list, pool);
            }
            return (MultiModelLoader) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-262307472, "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-262307472, "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;");
                return;
            }
        }
        DEFAULT_FACTORY = new Factory();
        EMPTY_MODEL_LOADER = new EmptyModelLoader();
    }

    public static ModelLoader emptyModelLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return EMPTY_MODEL_LOADER;
        }
        return (ModelLoader) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiModelLoaderFactory(Pools.Pool pool) {
        this(pool, DEFAULT_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Pools.Pool) objArr2[0], (Factory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public synchronized List getDataClasses(Class cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (Entry entry : this.entries) {
                    if (!arrayList.contains(entry.dataClass) && entry.handles(cls)) {
                        arrayList.add(entry.dataClass);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public MultiModelLoaderFactory(Pools.Pool pool, Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool, factory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.entries = new ArrayList();
        this.alreadyUsedEntries = new HashSet();
        this.throwableListPool = pool;
        this.factory = factory;
    }

    public synchronized List remove(Class cls, Class cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                Iterator it = this.entries.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.handles(cls, cls2)) {
                        it.remove();
                        arrayList.add(getFactory(entry));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void add(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{cls, cls2, modelLoaderFactory, Boolean.valueOf(z)}) == null) {
            Entry entry = new Entry(cls, cls2, modelLoaderFactory);
            List list = this.entries;
            if (z) {
                i = list.size();
            } else {
                i = 0;
            }
            list.add(i, entry);
        }
    }

    private ModelLoader build(Entry entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, entry)) == null) {
            return (ModelLoader) Preconditions.checkNotNull(entry.factory.build(this));
        }
        return (ModelLoader) invokeL.objValue;
    }

    private ModelLoaderFactory getFactory(Entry entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, entry)) == null) {
            return entry.factory;
        }
        return (ModelLoaderFactory) invokeL.objValue;
    }

    public synchronized void append(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                add(cls, cls2, modelLoaderFactory, true);
            }
        }
    }

    public synchronized void prepend(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                add(cls, cls2, modelLoaderFactory, false);
            }
        }
    }

    public synchronized List replace(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        InterceptResult invokeLLL;
        List remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, cls, cls2, modelLoaderFactory)) == null) {
            synchronized (this) {
                remove = remove(cls, cls2);
                append(cls, cls2, modelLoaderFactory);
            }
            return remove;
        }
        return (List) invokeLLL.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public synchronized ModelLoader build(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                try {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (Entry entry : this.entries) {
                        if (this.alreadyUsedEntries.contains(entry)) {
                            z = true;
                        } else if (entry.handles(cls, cls2)) {
                            this.alreadyUsedEntries.add(entry);
                            arrayList.add(build(entry));
                            this.alreadyUsedEntries.remove(entry);
                        }
                    }
                    if (arrayList.size() > 1) {
                        return this.factory.build(arrayList, this.throwableListPool);
                    }
                    if (arrayList.size() == 1) {
                        return (ModelLoader) arrayList.get(0);
                    }
                    if (z) {
                        return emptyModelLoader();
                    }
                    throw new Registry.NoModelLoaderAvailableException(cls, cls2);
                } catch (Throwable th) {
                    this.alreadyUsedEntries.clear();
                    throw th;
                }
            }
        }
        return (ModelLoader) invokeLL.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public synchronized List build(Class cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            synchronized (this) {
                try {
                    arrayList = new ArrayList();
                    for (Entry entry : this.entries) {
                        if (!this.alreadyUsedEntries.contains(entry) && entry.handles(cls)) {
                            this.alreadyUsedEntries.add(entry);
                            arrayList.add(build(entry));
                            this.alreadyUsedEntries.remove(entry);
                        }
                    }
                } catch (Throwable th) {
                    this.alreadyUsedEntries.clear();
                    throw th;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
