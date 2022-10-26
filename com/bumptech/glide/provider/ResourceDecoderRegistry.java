package com.bumptech.glide.provider;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ResourceDecoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List bucketPriorityList;
    public final Map decoders;

    /* loaded from: classes7.dex */
    public class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class dataClass;
        public final ResourceDecoder decoder;
        public final Class resourceClass;

        public Entry(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, resourceDecoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dataClass = cls;
            this.resourceClass = cls2;
            this.decoder = resourceDecoder;
        }

        public boolean handles(Class cls, Class cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
                if (this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.resourceClass)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public ResourceDecoderRegistry() {
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
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    private synchronized List getOrAddEntryList(String str) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            synchronized (this) {
                if (!this.bucketPriorityList.contains(str)) {
                    this.bucketPriorityList.add(str);
                }
                list = (List) this.decoders.get(str);
                if (list == null) {
                    list = new ArrayList();
                    this.decoders.put(str, list);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized void append(String str, ResourceDecoder resourceDecoder, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, resourceDecoder, cls, cls2) == null) {
            synchronized (this) {
                getOrAddEntryList(str).add(new Entry(cls, cls2, resourceDecoder));
            }
        }
    }

    public synchronized void prepend(String str, ResourceDecoder resourceDecoder, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, resourceDecoder, cls, cls2) == null) {
            synchronized (this) {
                getOrAddEntryList(str).add(0, new Entry(cls, cls2, resourceDecoder));
            }
        }
    }

    public synchronized List getDecoders(Class cls, Class cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.bucketPriorityList) {
                    List<Entry> list = (List) this.decoders.get(str);
                    if (list != null) {
                        for (Entry entry : list) {
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

    public synchronized List getResourceClasses(Class cls, Class cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.bucketPriorityList) {
                    List<Entry> list = (List) this.decoders.get(str);
                    if (list != null) {
                        for (Entry entry : list) {
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

    public synchronized void setBucketPriorityList(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            synchronized (this) {
                ArrayList<String> arrayList = new ArrayList(this.bucketPriorityList);
                this.bucketPriorityList.clear();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.bucketPriorityList.add((String) it.next());
                }
                for (String str : arrayList) {
                    if (!list.contains(str)) {
                        this.bucketPriorityList.add(str);
                    }
                }
            }
        }
    }
}
