package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ModelLoaderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModelLoaderCache cache;
    public final MultiModelLoaderFactory multiModelLoaderFactory;

    /* loaded from: classes7.dex */
    public class ModelLoaderCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map cachedModelLoaders;

        /* loaded from: classes7.dex */
        public class Entry {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final List loaders;

            public Entry(List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.loaders = list;
            }
        }

        public ModelLoaderCache() {
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
            this.cachedModelLoaders = new HashMap();
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cachedModelLoaders.clear();
            }
        }

        public List get(Class cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
                Entry entry = (Entry) this.cachedModelLoaders.get(cls);
                if (entry == null) {
                    return null;
                }
                return entry.loaders;
            }
            return (List) invokeL.objValue;
        }

        public void put(Class cls, List list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, list) != null) || ((Entry) this.cachedModelLoaders.put(cls, new Entry(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelLoaderRegistry(Pools.Pool pool) {
        this(new MultiModelLoaderFactory(pool));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((MultiModelLoaderFactory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {multiModelLoaderFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = new ModelLoaderCache();
        this.multiModelLoaderFactory = multiModelLoaderFactory;
    }

    public static Class getClass(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            return obj.getClass();
        }
        return (Class) invokeL.objValue;
    }

    private synchronized List getModelLoadersForClass(Class cls) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cls)) == null) {
            synchronized (this) {
                list = this.cache.get(cls);
                if (list == null) {
                    list = Collections.unmodifiableList(this.multiModelLoaderFactory.build(cls));
                    this.cache.put(cls, list);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    private void tearDown(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ModelLoaderFactory) it.next()).teardown();
            }
        }
    }

    public synchronized List getDataClasses(Class cls) {
        InterceptResult invokeL;
        List dataClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            synchronized (this) {
                dataClasses = this.multiModelLoaderFactory.getDataClasses(cls);
            }
            return dataClasses;
        }
        return (List) invokeL.objValue;
    }

    public synchronized void append(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                this.multiModelLoaderFactory.append(cls, cls2, modelLoaderFactory);
                this.cache.clear();
            }
        }
    }

    public synchronized void prepend(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                this.multiModelLoaderFactory.prepend(cls, cls2, modelLoaderFactory);
                this.cache.clear();
            }
        }
    }

    public synchronized void replace(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                tearDown(this.multiModelLoaderFactory.replace(cls, cls2, modelLoaderFactory));
                this.cache.clear();
            }
        }
    }

    public synchronized ModelLoader build(Class cls, Class cls2) {
        InterceptResult invokeLL;
        ModelLoader build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                build = this.multiModelLoaderFactory.build(cls, cls2);
            }
            return build;
        }
        return (ModelLoader) invokeLL.objValue;
    }

    public synchronized void remove(Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, cls, cls2) == null) {
            synchronized (this) {
                tearDown(this.multiModelLoaderFactory.remove(cls, cls2));
                this.cache.clear();
            }
        }
    }

    public List getModelLoaders(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            List modelLoadersForClass = getModelLoadersForClass(getClass(obj));
            if (!modelLoadersForClass.isEmpty()) {
                int size = modelLoadersForClass.size();
                List emptyList = Collections.emptyList();
                boolean z = true;
                for (int i = 0; i < size; i++) {
                    ModelLoader modelLoader = (ModelLoader) modelLoadersForClass.get(i);
                    if (modelLoader.handles(obj)) {
                        if (z) {
                            emptyList = new ArrayList(size - i);
                            z = false;
                        }
                        emptyList.add(modelLoader);
                    }
                }
                if (!emptyList.isEmpty()) {
                    return emptyList;
                }
                throw new Registry.NoModelLoaderAvailableException(obj, modelLoadersForClass);
            }
            throw new Registry.NoModelLoaderAvailableException(obj);
        }
        return (List) invokeL.objValue;
    }
}
