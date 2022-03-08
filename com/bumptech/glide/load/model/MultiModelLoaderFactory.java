package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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
    public static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Entry<?, ?>> alreadyUsedEntries;
    public final List<Entry<?, ?>> entries;
    public final Factory factory;
    public final Pools.Pool<List<Throwable>> throwableListPool;

    /* loaded from: classes7.dex */
    public static class EmptyModelLoader implements ModelLoader<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EmptyModelLoader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object obj, int i2, int i3, @NonNull Options options) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
                return null;
            }
            return (ModelLoader.LoadData) invokeCommon.objValue;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Entry<Model, Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<Data> dataClass;
        public final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        public final Class<Model> modelClass;

        public Entry(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, modelLoaderFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.modelClass = cls;
            this.dataClass = cls2;
            this.factory = modelLoaderFactory;
        }

        public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) ? handles(cls) && this.dataClass.isAssignableFrom(cls2) : invokeLL.booleanValue;
        }

        public boolean handles(@NonNull Class<?> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.modelClass.isAssignableFrom(cls) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public <Model, Data> MultiModelLoader<Model, Data> build(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, pool)) == null) ? new MultiModelLoader<>(list, pool) : (MultiModelLoader) invokeLL.objValue;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, DEFAULT_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Pools.Pool) objArr2[0], (Factory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private <Model, Data> void add(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{cls, cls2, modelLoaderFactory, Boolean.valueOf(z)}) == null) {
            Entry<?, ?> entry = new Entry<>(cls, cls2, modelLoaderFactory);
            List<Entry<?, ?>> list = this.entries;
            list.add(z ? list.size() : 0, entry);
        }
    }

    @NonNull
    public static <Model, Data> ModelLoader<Model, Data> emptyModelLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (ModelLoader<Model, Data>) EMPTY_MODEL_LOADER : (ModelLoader) invokeV.objValue;
    }

    @NonNull
    private <Model, Data> ModelLoaderFactory<Model, Data> getFactory(@NonNull Entry<?, ?> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, entry)) == null) ? (ModelLoaderFactory<Model, Data>) entry.factory : (ModelLoaderFactory) invokeL.objValue;
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                add(cls, cls2, modelLoaderFactory, true);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> build(@NonNull Class<Model> cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            synchronized (this) {
                try {
                    arrayList = new ArrayList();
                    for (Entry<?, ?> entry : this.entries) {
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

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (Entry<?, ?> entry : this.entries) {
                    if (!arrayList.contains(entry.dataClass) && entry.handles(cls)) {
                        arrayList.add(entry.dataClass);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cls, cls2, modelLoaderFactory) == null) {
            synchronized (this) {
                add(cls, cls2, modelLoaderFactory, false);
            }
        }
    }

    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                Iterator<Entry<?, ?>> it = this.entries.iterator();
                while (it.hasNext()) {
                    Entry<?, ?> next = it.next();
                    if (next.handles(cls, cls2)) {
                        it.remove();
                        arrayList.add(getFactory(next));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        InterceptResult invokeLLL;
        List<ModelLoaderFactory<? extends Model, ? extends Data>> remove;
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

    @VisibleForTesting
    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pool, factory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                try {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (Entry<?, ?> entry : this.entries) {
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

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> build(@NonNull Entry<?, ?> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, entry)) == null) ? (ModelLoader) Preconditions.checkNotNull(entry.factory.build(this)) : (ModelLoader) invokeL.objValue;
    }
}
