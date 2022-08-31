package com.baidu.ugc.editvideo.editvideo.addfilter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ic9;
import com.baidu.tieba.qc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class InnerMediaProcessor extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAddTrack;
    public volatile boolean mCanRetry;
    public long mClipDuration;
    public long mClipPoint;
    public boolean mCurrentEncodeHevcVideo;
    public boolean mEncodeHevcVideo;
    public String mErrMsg;
    public int mFrameRate;
    public OnGenFilterVideoListener mListener;
    public InnerMuxerWrapper mMuxer;
    public int mOutBitRate;
    public int mOutHeight;
    public int mOutWidth;
    public BaseOutputSurface mOutputSurface;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public volatile boolean mUserInterrupted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerMediaProcessor(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAddTrack = false;
    }

    public void checkMuxerStart(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !this.mMuxer.isStarted() && this.mAddTrack) {
            if (z) {
                this.mMuxer.setVideoStart();
            } else {
                this.mMuxer.setAudioStart();
            }
            if (this.mMuxer.start()) {
                return;
            }
            synchronized (this.mMuxer) {
                while (!this.mMuxer.isStarted()) {
                    try {
                        this.mMuxer.wait(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void extractDecodeEditEncodeMux() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public String getMuxerLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "no more log" : (String) invokeV.objValue;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.interrupt();
            this.mUserInterrupted = true;
        }
    }

    public boolean isUnInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Thread.currentThread().isInterrupted() || this.mUserInterrupted) ? false : true : invokeV.booleanValue;
    }

    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            ic9.l(str, str2);
        }
    }

    public void onInterrupt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void onPostExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void onProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                extractDecodeEditEncodeMux();
                if (isUnInterrupted()) {
                    qc9.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InnerMediaProcessor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.onPostExecute();
                            }
                        }
                    });
                }
            } catch (Exception unused) {
                if (this.mListener != null) {
                    qc9.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InnerMediaProcessor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            InnerMediaProcessor innerMediaProcessor;
                            OnGenFilterVideoListener onGenFilterVideoListener;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (onGenFilterVideoListener = (innerMediaProcessor = this.this$0).mListener) == null) {
                                return;
                            }
                            onGenFilterVideoListener.onGenFilterVideoFail((innerMediaProcessor.mCanRetry || this.this$0.mCurrentEncodeHevcVideo) ? -100 : -4, this.this$0.mErrMsg);
                        }
                    });
                }
            }
        }
    }

    public void setClipRange(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mClipPoint = j;
            this.mClipDuration = j2;
        }
    }

    public void setErrMsg(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, str) == null) {
            this.mCanRetry = z;
            this.mErrMsg = str;
        }
    }

    public void setFrameRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mFrameRate = i;
        }
    }

    public void setOutputSurface(BaseOutputSurface baseOutputSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, baseOutputSurface) == null) {
            this.mOutputSurface = baseOutputSurface;
        }
    }

    public void setOutputVideoBitRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mOutBitRate = i;
        }
    }

    public void setOutputVideoSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            this.mOutWidth = i;
            this.mOutHeight = i2;
        }
    }

    public void setPreviewVideoSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mEncodeHevcVideo = z;
        }
    }
}
