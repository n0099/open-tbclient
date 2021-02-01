package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> onResourceDecoded(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls2.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls3.getSimpleName() + "}";
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
    }

    @NonNull
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i, i2, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    @NonNull
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, List<Throwable> list) throws GlideException {
        Resource<ResourceType> resource = null;
        int size = this.decoders.size();
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.decoders.get(i3);
            try {
                resource = resourceDecoder.handles(dataRewinder.rewindAndGet(), options) ? resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options) : resource;
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
        if (resource == null) {
            throw new GlideException(this.failureMessage, new ArrayList(list));
        }
        return resource;
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}
