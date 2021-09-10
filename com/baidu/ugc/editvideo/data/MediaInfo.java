package com.baidu.ugc.editvideo.data;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MediaInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int minimumDuration = 3000;
    public transient /* synthetic */ FieldHolder $fh;
    public long duration;
    public String durationText;
    public boolean hasLoaded;
    public long inStepVideoDuration;
    public long lastModified;
    public String mimeType;
    public int rotation;
    public Bitmap thumbnailBitmap;
    public String thumbnailPath;
    public int videoHeight;
    public String videoId;
    public String videoPath;
    public int videoWidth;

    public MediaInfo() {
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
        this.hasLoaded = false;
        this.inStepVideoDuration = 0L;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.duration : invokeV.longValue;
    }

    public String getDurationText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.durationText : (String) invokeV.objValue;
    }

    public long getInStepVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.inStepVideoDuration : invokeV.longValue;
    }

    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lastModified : invokeV.longValue;
    }

    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mimeType : (String) invokeV.objValue;
    }

    public int getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.rotation : invokeV.intValue;
    }

    @Deprecated
    public synchronized Bitmap getThumbnailBitmap() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                bitmap = this.thumbnailBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String getThumbnailPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.thumbnailPath : (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.videoHeight : invokeV.intValue;
    }

    public String getVideoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.videoId : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.videoPath : (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.videoWidth : invokeV.intValue;
    }

    public boolean hasLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.hasLoaded : invokeV.booleanValue;
    }

    public boolean isMore3s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.duration >= 3000 : invokeV.booleanValue;
    }

    public boolean isSelectable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j2 = this.inStepVideoDuration / 1000;
            long j3 = this.duration / 1000;
            boolean isMore3s = isMore3s();
            if (j2 > 0) {
                isMore3s = j3 >= j2 && isMore3s();
            }
            if (t.f31173a) {
                return isMore3s;
            }
            return this.duration <= 15000;
        }
        return invokeV.booleanValue;
    }

    public void setDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.duration = j2;
        }
    }

    public void setDurationText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.durationText = str;
        }
    }

    public void setHasLoaded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.hasLoaded = z;
        }
    }

    public void setInStepVideoDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.inStepVideoDuration = j2;
        }
    }

    public void setLastModified(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.lastModified = j2;
        }
    }

    public void setMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mimeType = str;
        }
    }

    public void setRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.rotation = i2;
        }
    }

    @Deprecated
    public void setThumbnailBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bitmap) == null) {
            this.thumbnailBitmap = bitmap;
        }
    }

    public void setThumbnailPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.thumbnailPath = str;
        }
    }

    public void setVideoHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.videoHeight = i2;
        }
    }

    public void setVideoId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.videoId = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.videoPath = str;
        }
    }

    public void setVideoWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.videoWidth = i2;
        }
    }
}
