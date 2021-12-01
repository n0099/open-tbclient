package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class ResourceDecoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> bucketPriorityList;
    public final Map<String, List<Entry<?, ?>>> decoders;

    /* loaded from: classes12.dex */
    public static class Entry<T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<T> dataClass;
        public final ResourceDecoder<T, R> decoder;
        public final Class<R> resourceClass;

        public Entry(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, resourceDecoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataClass = cls;
            this.resourceClass = cls2;
            this.decoder = resourceDecoder;
        }

        public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) ? this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.resourceClass) : invokeLL.booleanValue;
        }
    }

    public ResourceDecoderRegistry() {
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
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    @NonNull
    private synchronized List<Entry<?, ?>> getOrAddEntryList(@NonNull String str) {
        InterceptResult invokeL;
        List<Entry<?, ?>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            synchronized (this) {
                if (!this.bucketPriorityList.contains(str)) {
                    this.bucketPriorityList.add(str);
                }
                list = this.decoders.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.decoders.put(str, list);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <T, R> void append(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, resourceDecoder, cls, cls2) == null) {
            synchronized (this) {
                getOrAddEntryList(str).add(new Entry<>(cls, cls2, resourceDecoder));
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> getDecoders(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.bucketPriorityList) {
                    List<Entry<?, ?>> list = this.decoders.get(str);
                    if (list != null) {
                        for (Entry<?, ?> entry : list) {
                            if (entry.handles(cls, cls2)) {
                                arrayList.add(entry.decoder);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> getResourceClasses(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.bucketPriorityList) {
                    List<Entry<?, ?>> list = this.decoders.get(str);
                    if (list != null) {
                        for (Entry<?, ?> entry : list) {
                            if (entry.handles(cls, cls2) && !arrayList.contains(entry.resourceClass)) {
                                arrayList.add(entry.resourceClass);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public synchronized <T, R> void prepend(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, resourceDecoder, cls, cls2) == null) {
            synchronized (this) {
                getOrAddEntryList(str).add(0, new Entry<>(cls, cls2, resourceDecoder));
            }
        }
    }

    public synchronized void setBucketPriorityList(@NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            synchronized (this) {
                ArrayList<String> arrayList = new ArrayList(this.bucketPriorityList);
                this.bucketPriorityList.clear();
                this.bucketPriorityList.addAll(list);
                for (String str : arrayList) {
                    if (!list.contains(str)) {
                        this.bucketPriorityList.add(str);
                    }
                }
            }
        }
    }
}
