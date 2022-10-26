package com.baidu.ugc.editvideo.data;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zh9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.duration;
        }
        return invokeV.longValue;
    }

    public String getDurationText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.durationText;
        }
        return (String) invokeV.objValue;
    }

    public long getInStepVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.inStepVideoDuration;
        }
        return invokeV.longValue;
    }

    public long getLastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.lastModified;
        }
        return invokeV.longValue;
    }

    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mimeType;
        }
        return (String) invokeV.objValue;
    }

    public int getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.rotation;
        }
        return invokeV.intValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.thumbnailPath;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.videoHeight;
        }
        return invokeV.intValue;
    }

    public String getVideoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.videoId;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.videoPath;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.videoWidth;
        }
        return invokeV.intValue;
    }

    public boolean hasLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.hasLoaded;
        }
        return invokeV.booleanValue;
    }

    public boolean isMore3s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.duration >= 3000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSelectable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j = this.inStepVideoDuration / 1000;
            long j2 = this.duration / 1000;
            boolean isMore3s = isMore3s();
            boolean z = true;
            if (j > 0) {
                if (j2 >= j && isMore3s()) {
                    isMore3s = true;
                } else {
                    isMore3s = false;
                }
            }
            if (!zh9.a) {
                if (this.duration > 15000) {
                    z = false;
                }
                return z;
            }
            return isMore3s;
        }
        return invokeV.booleanValue;
    }

    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.duration = j;
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

    public void setInStepVideoDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.inStepVideoDuration = j;
        }
    }

    public void setLastModified(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.lastModified = j;
        }
    }

    public void setMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mimeType = str;
        }
    }

    public void setRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.rotation = i;
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

    public void setVideoHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.videoHeight = i;
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

    public void setVideoWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.videoWidth = i;
        }
    }
}
