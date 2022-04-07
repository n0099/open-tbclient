package com.baidu.ugc.editvideo.record.transition;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f99;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class VideoFollowData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUDIO_TYPE_FOLLOW = 0;
    public static final int AUDIO_TYPE_MIX = 2;
    public static final int AUDIO_TYPE_RECORD = 1;
    public static final String FOLLOW_TYPE_BIG_SMALL = "1";
    public static final String FOLLOW_TYPE_LEFT_RIGHT = "0";
    public static final String FOLLOW_TYPE_SAME_STYLE = "2";
    public static final int PREVIEW_SCALE_TYPE_CENTER_CROP = 0;
    public static final int PREVIEW_SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int VIDEO_HORIZONTAL_MODE = 1;
    public static final int VIDEO_VERTICAL_MODE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAudioType;
    public String mFollowMusicId;
    public String mFollowRecordAudioPath;
    public String mFollowRecordVideoPath;
    public String mFollowType;
    public String mFollowVid;
    public boolean mNeedSmallWindowWhiteEdge;
    public int mOritation;
    public int mPreviewScaleType;
    public int mPreviewSmallWindowHeight;
    public int mPreviewSmallWindowWidth;
    public int mPreviewSmallWindowX;
    public int mPreviewSmallWindowY;
    public int mRecordSmallWindowHeight;
    public int mRecordSmallWindowWidth;
    public int mRecordSmallWindowX;
    public int mRecordSmallWindowY;
    public String mRecordVideoPath;

    public VideoFollowData() {
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
        this.mNeedSmallWindowWhiteEdge = true;
    }

    public static boolean isBigSmallFollowType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.equals("1", str) : invokeL.booleanValue;
    }

    public static boolean isFollowType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? isBigSmallFollowType(str) || isLeftRightFollowType(str) || isSameStyleFollowType(str) : invokeL.booleanValue;
    }

    public static boolean isLeftRightFollowType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.equals("0", str) : invokeL.booleanValue;
    }

    public static boolean isSameStyleFollowType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TextUtils.equals("2", str) : invokeL.booleanValue;
    }

    public static VideoFollowData parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (VideoFollowData) new f99().b(str, VideoFollowData.class);
            } catch (Exception unused) {
                return null;
            }
        }
        return (VideoFollowData) invokeL.objValue;
    }

    public static String toJson(VideoFollowData videoFollowData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, videoFollowData)) == null) {
            if (videoFollowData == null) {
                return null;
            }
            try {
                return new f99().a(videoFollowData);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public int getAudioType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAudioType : invokeV.intValue;
    }

    public String getFollowMusicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFollowMusicId : (String) invokeV.objValue;
    }

    public String getFollowRecordAudioPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFollowRecordAudioPath : (String) invokeV.objValue;
    }

    public String getFollowRecordVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFollowRecordVideoPath : (String) invokeV.objValue;
    }

    public String getFollowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFollowType : (String) invokeV.objValue;
    }

    public String getFollowVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFollowVid : (String) invokeV.objValue;
    }

    public int getOritation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOritation : invokeV.intValue;
    }

    public int getPreviewScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPreviewScaleType : invokeV.intValue;
    }

    public String getRecordVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRecordVideoPath : (String) invokeV.objValue;
    }

    public boolean isNeedSmallWindowWhiteEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mNeedSmallWindowWhiteEdge : invokeV.booleanValue;
    }

    public void setAudioType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mAudioType = i;
        }
    }

    public void setFollowMusicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mFollowMusicId = str;
        }
    }

    public void setFollowRecordAudioPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mFollowRecordAudioPath = str;
        }
    }

    public void setFollowRecordVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mFollowRecordVideoPath = str;
        }
    }

    public void setFollowType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mFollowType = str;
        }
    }

    public void setFollowVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mFollowVid = str;
        }
    }

    public void setNeedSmallWindowWhiteEdge(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mNeedSmallWindowWhiteEdge = z;
        }
    }

    public void setOritation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mOritation = i;
        }
    }

    public void setPreviewScaleType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mPreviewScaleType = i;
        }
    }

    public void setRecordVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mRecordVideoPath = str;
        }
    }
}
