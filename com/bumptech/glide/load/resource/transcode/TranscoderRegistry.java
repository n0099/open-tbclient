package com.bumptech.glide.load.resource.transcode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class TranscoderRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List transcoders;

    /* loaded from: classes7.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class fromClass;
        public final Class toClass;
        public final ResourceTranscoder transcoder;

        public Entry(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, resourceTranscoder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fromClass = cls;
            this.toClass = cls2;
            this.transcoder = resourceTranscoder;
        }

        public boolean handles(Class cls, Class cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
                if (this.fromClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.toClass)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public TranscoderRegistry() {
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
        this.transcoders = new ArrayList();
    }

    public synchronized ResourceTranscoder get(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
            synchronized (this) {
                if (cls2.isAssignableFrom(cls)) {
                    return UnitTranscoder.get();
                }
                for (Entry entry : this.transcoders) {
                    if (entry.handles(cls, cls2)) {
                        return entry.transcoder;
                    }
                }
                throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
            }
        }
        return (ResourceTranscoder) invokeLL.objValue;
    }

    public synchronized List getTranscodeClasses(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (cls2.isAssignableFrom(cls)) {
                    arrayList.add(cls2);
                    return arrayList;
                }
                for (Entry entry : this.transcoders) {
                    if (entry.handles(cls, cls2)) {
                        arrayList.add(cls2);
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeLL.objValue;
    }

    public synchronized void register(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, resourceTranscoder) == null) {
            synchronized (this) {
                this.transcoders.add(new Entry(cls, cls2, resourceTranscoder));
            }
        }
    }
}
