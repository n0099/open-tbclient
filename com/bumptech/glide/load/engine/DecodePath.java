package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DecodePath";
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<DataType> dataClass;
    public final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    public final String failureMessage;
    public final Pools.Pool<List<Throwable>> listPool;
    public final ResourceTranscoder<ResourceType, Transcode> transcoder;

    /* loaded from: classes9.dex */
    public interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> onResourceDecoded(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, list, resourceTranscoder, pool};
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
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{dataRewinder, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            List<Throwable> list = (List) Preconditions.checkNotNull(this.listPool.acquire());
            try {
                return decodeResourceWithList(dataRewinder, i2, i3, options, list);
            } finally {
                this.listPool.release(list);
            }
        }
        return (Resource) invokeCommon.objValue;
    }

    @NonNull
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options, List<Throwable> list) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{dataRewinder, Integer.valueOf(i2), Integer.valueOf(i3), options, list})) == null) {
            int size = this.decoders.size();
            Resource<ResourceType> resource = null;
            for (int i4 = 0; i4 < size; i4++) {
                ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(i4);
                try {
                    if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                        resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i2, i3, options);
                    }
                } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                    if (Log.isLoggable(TAG, 2)) {
                        String str = "Failed to decode data for " + resourceDecoder;
                    }
                    list.add(e2);
                }
                if (resource != null) {
                    break;
                }
            }
            if (resource != null) {
                return resource;
            }
            throw new GlideException(this.failureMessage, new ArrayList(list));
        }
        return (Resource) invokeCommon.objValue;
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{dataRewinder, Integer.valueOf(i2), Integer.valueOf(i3), options, decodeCallback})) == null) ? this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i2, i3, options)), options) : (Resource) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
