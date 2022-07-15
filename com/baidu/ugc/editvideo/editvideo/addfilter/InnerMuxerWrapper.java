package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w89;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes4.dex */
public class InnerMuxerWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InnerMuxerWrapper";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean mAudioStart;
    public int mEncoderCount;
    public volatile boolean mIsStarted;
    public final MediaMuxer mMediaMuxer;
    public boolean mMuxAudio;
    public volatile boolean mVideoStart;

    public InnerMuxerWrapper(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEncoderCount = 2;
        this.mIsStarted = false;
        this.mMuxAudio = true;
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    public static void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        w89.i(str2);
    }

    public synchronized int addTrack(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (!this.mIsStarted) {
                    addTrack = this.mMediaMuxer.addTrack(mediaFormat);
                } else {
                    throw new IllegalStateException("muxer already started");
                }
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized boolean isStarted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                z = this.mIsStarted;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void setAudioStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mAudioStart = true;
        }
    }

    public void setMuxAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mMuxAudio = z;
            if (z) {
                return;
            }
            this.mEncoderCount = 1;
        }
    }

    public void setVideoStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mVideoStart = true;
        }
    }

    public synchronized boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if ((!this.mMuxAudio || this.mAudioStart) && this.mVideoStart) {
                    if (this.mEncoderCount > 0 && ((!this.mMuxAudio || this.mAudioStart) && this.mVideoStart)) {
                        this.mMediaMuxer.start();
                        this.mIsStarted = true;
                        notifyAll();
                    }
                    return this.mIsStarted;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.mEncoderCount > 0) {
                    try {
                        this.mMediaMuxer.stop();
                        this.mMediaMuxer.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mIsStarted = false;
                }
            }
        }
    }

    public synchronized void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.mIsStarted) {
                    this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
                }
            }
        }
    }
}
