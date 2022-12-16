package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.an9;
import com.baidu.tieba.gn9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.rm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.VideoKeyFrameModel;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import java.io.Closeable;
import java.util.List;
/* loaded from: classes7.dex */
public class BdMediaMetadataRetriever extends MediaMetadataRetriever implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMirror;
    public boolean isUseMediacodec;
    public int mAngle;
    public String mPath;
    public VideoKeyFrameModel mVideoKeyFrameModel;

    /* loaded from: classes7.dex */
    public interface OnGetFrameAtExactTimeListener {
        void onFinish(Bitmap bitmap);
    }

    public BdMediaMetadataRetriever() {
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
        this.mPath = null;
        this.isUseMediacodec = an9.a();
    }

    @NonNull
    private VideoKeyFrameModel getVideoKeyFrameModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            VideoKeyFrameModel videoKeyFrameModel = new VideoKeyFrameModel();
            this.mVideoKeyFrameModel = videoKeyFrameModel;
            videoKeyFrameModel.setAngle(this.mAngle);
            this.mVideoKeyFrameModel.setMirror(this.isMirror);
            return this.mVideoKeyFrameModel;
        }
        return (VideoKeyFrameModel) invokeV.objValue;
    }

    private boolean isUseMediacodec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.isUseMediacodec && !gn9.a(this.mPath) : invokeV.booleanValue;
    }

    @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            release();
        }
    }

    public void forceUseMediaCodec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.isUseMediacodec = true;
        }
    }

    public Bitmap getFrameAtExactTime(long j, int i) {
        InterceptResult invokeCommon;
        Bitmap frameAtTime;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? (!isUseMediacodec() || Build.VERSION.SDK_INT < 21 || (frameAtTime = getVideoKeyFrameModel().getFrameAtTime(this.mPath, (long) ((int) j), true)) == null) ? super.getFrameAtTime(j, i) : frameAtTime : (Bitmap) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r8 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getFrameAtExactTime(long j, int i, VideoEffectData videoEffectData, OnGetFrameAtExactTimeListener onGetFrameAtExactTimeListener) {
        Bitmap frameAtTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), videoEffectData, onGetFrameAtExactTimeListener}) == null) {
            if (isUseMediacodec() && Build.VERSION.SDK_INT >= 21) {
                VideoKeyFrameModel videoKeyFrameModel = getVideoKeyFrameModel();
                videoKeyFrameModel.setVideoEffectData(videoEffectData);
                frameAtTime = videoKeyFrameModel.getFrameAtTime(this.mPath, (int) j, true);
            }
            frameAtTime = super.getFrameAtTime(j, i);
            if (onGetFrameAtExactTimeListener != null) {
                onGetFrameAtExactTimeListener.onFinish(frameAtTime);
            }
        }
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getFrameAtTime(0L) : (Bitmap) invokeV.objValue;
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? getFrameAtTime(j, 2) : (Bitmap) invokeJ.objValue;
    }

    @Override // android.media.MediaMetadataRetriever
    @Deprecated
    public Bitmap getFrameAtTime(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? getFrameAtTime(j, i, 0, 0) : (Bitmap) invokeCommon.objValue;
    }

    public Bitmap getFrameAtTime(long j, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Bitmap frameAtTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                if (!isUseMediacodec() || Build.VERSION.SDK_INT < 21) {
                    frameAtTime = super.getFrameAtTime(j, i);
                    if (frameAtTime == null) {
                        return null;
                    }
                    if (i2 != 0 && i3 != 0) {
                        frameAtTime = ThumbnailUtils.extractThumbnail(frameAtTime, i2, i3, 2);
                    }
                } else {
                    frameAtTime = getVideoKeyFrameModel().getFrameAtTime(this.mPath, (int) j, false, i2, i3);
                }
                return frameAtTime;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public void getFrameAtTimeList(List<Long> list, int i, int i2, VideoKeyFrameModel.OnDecodeFrameAvailableListener onDecodeFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), onDecodeFrameAvailableListener}) == null) || rm9.e(list) || onDecodeFrameAvailableListener == null) {
            return;
        }
        if (isUseMediacodec()) {
            getVideoKeyFrameModel().getFrameAtTimeList(this.mPath, list, i, i2, onDecodeFrameAvailableListener);
        } else if (!TextUtils.isEmpty(this.mPath)) {
            for (Long l : list) {
                onDecodeFrameAvailableListener.onFrameAvailable(l.longValue(), getFrameAtTime(l.longValue(), 2, i, i2));
            }
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
            if (videoKeyFrameModel != null) {
                videoKeyFrameModel.setOnDecodeFrameAvailableListener(null);
                this.mVideoKeyFrameModel.release();
                this.mVideoKeyFrameModel = null;
            }
        }
    }

    public void setAngle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mAngle = i;
            VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
            if (videoKeyFrameModel != null) {
                videoKeyFrameModel.setAngle(i);
            }
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            try {
                super.setDataSource(str);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.mPath = str;
                }
            } catch (Exception e) {
                mm9.g(e);
            }
        }
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isMirror = z;
            VideoKeyFrameModel videoKeyFrameModel = this.mVideoKeyFrameModel;
            if (videoKeyFrameModel != null) {
                videoKeyFrameModel.setMirror(z);
            }
        }
    }
}
