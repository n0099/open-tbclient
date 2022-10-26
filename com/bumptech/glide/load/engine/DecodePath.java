package com.bumptech.glide.load.engine;

import android.util.Log;
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
/* loaded from: classes7.dex */
public class DecodePath {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DecodePath";
    public transient /* synthetic */ FieldHolder $fh;
    public final Class dataClass;
    public final List decoders;
    public final String failureMessage;
    public final Pools.Pool listPool;
    public final ResourceTranscoder transcoder;

    /* loaded from: classes7.dex */
    public interface DecodeCallback {
        Resource onResourceDecoded(Resource resource);
    }

    public DecodePath(Class cls, Class cls2, Class cls3, List list, ResourceTranscoder resourceTranscoder, Pools.Pool pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, list, resourceTranscoder, pool};
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
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource decodeResource(DataRewinder dataRewinder, int i, int i2, Options options) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{dataRewinder, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
            try {
                return decodeResourceWithList(dataRewinder, i, i2, options, list);
            } finally {
                this.listPool.release(list);
            }
        }
        return (Resource) invokeCommon.objValue;
    }

    private Resource decodeResourceWithList(DataRewinder dataRewinder, int i, int i2, Options options, List list) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{dataRewinder, Integer.valueOf(i), Integer.valueOf(i2), options, list})) == null) {
            int size = this.decoders.size();
            Resource resource = null;
            for (int i3 = 0; i3 < size; i3++) {
                ResourceDecoder resourceDecoder = (ResourceDecoder) this.decoders.get(i3);
                try {
                    if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                        resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                    }
                } catch (IOException | OutOfMemoryError | RuntimeException e) {
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Failed to decode data for " + resourceDecoder, e);
                    }
                    list.add(e);
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

    public Resource decode(DataRewinder dataRewinder, int i, int i2, Options options, DecodeCallback decodeCallback) throws GlideException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{dataRewinder, Integer.valueOf(i), Integer.valueOf(i2), options, decodeCallback})) == null) {
            return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
        }
        return (Resource) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
        }
        return (String) invokeV.objValue;
    }
}
