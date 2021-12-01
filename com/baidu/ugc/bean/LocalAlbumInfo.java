package com.baidu.ugc.bean;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class LocalAlbumInfo extends LocalEntity implements Cloneable, Comparable<LocalAlbumInfo> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FACE_SCORE_BASE = 20;
    public static final int IMAGE = 0;
    public static final String LOCAL_ALBUM_KEY = "localalbuminfo";
    public static final int LOCAL_VIDEO_DURATION_NORMAL = 0;
    public static final int LOCAL_VIDEO_DURATION_SO_LONG = 2;
    public static final int LOCAL_VIDEO_DURATION_SO_SHORT = 1;
    public static final float MAX_SPEED = 8.0f;
    public static final float MIN_SPEED = 0.01f;
    public static final int NORMAL_SCORE_MAX = 10;
    public static final int SUPPORT_MAX_WIDTH_HEIGHT = 3000;
    public static final int VIDEO = 1;
    public static final int VIDEO_SCORE_BASE = 10;
    public static final long serialVersionUID = -7570868377253183814L;
    public transient /* synthetic */ FieldHolder $fh;
    public float angle;
    public long date;
    public long duration;
    public int durationType;
    public long endTime;
    public int faceNum;
    public int height;
    public int imageId;
    public boolean isOverSupportSize;
    public boolean isSelected;
    public float mGlobalSpeed;
    public boolean mIsShowSpeedChanger;
    public float mSelfSpeed;
    public int mediaType;
    public int orientation;
    public String path;
    public int score;
    public int selectCount;
    public long size;
    public long startTime;
    public String uri;
    public String uuid;
    public int width;

    public LocalAlbumInfo() {
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
        this.mediaType = 0;
        this.isSelected = false;
        this.faceNum = 0;
        this.selectCount = 0;
        this.durationType = 0;
        this.mGlobalSpeed = 1.0f;
        this.mSelfSpeed = 1.0f;
        this.isOverSupportSize = false;
    }

    public static boolean checkOverSupportSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) ? Math.max(i2, i3) > 3000 : invokeII.booleanValue;
    }

    public static String toJSONList(List<LocalAlbumInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null) {
                return null;
            }
            try {
                return new b().a(list);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String toJsonString(LocalAlbumInfo localAlbumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, localAlbumInfo)) == null) {
            if (localAlbumInfo == null) {
                return null;
            }
            try {
                return new b().a(localAlbumInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof LocalAlbumInfo) {
                LocalAlbumInfo localAlbumInfo = (LocalAlbumInfo) obj;
                String str = localAlbumInfo.uri;
                if (str == null) {
                    str = "";
                }
                localAlbumInfo.uri = str;
                String str2 = this.uri;
                String str3 = str2 != null ? str2 : "";
                this.uri = str3;
                return str3.equals(localAlbumInfo.uri) && this.mediaType == localAlbumInfo.mediaType;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public float getCurrentSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = this.mSelfSpeed;
            float f3 = this.mGlobalSpeed;
            if (f2 * f3 <= 0.0f) {
                return 1.0f;
            }
            if (f2 * f3 > 8.0f) {
                return 8.0f;
            }
            if (f2 * f3 < 0.01f) {
                return 0.01f;
            }
            return f2 * f3;
        }
        return invokeV.floatValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.duration : invokeV.longValue;
    }

    public long getDurationWithSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((float) (this.endTime - this.startTime)) / getCurrentSpeed() : invokeV.longValue;
    }

    public long getEndTimeMSWithSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((float) this.endTime) / getCurrentSpeed() : invokeV.longValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.path : (String) invokeV.objValue;
    }

    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.size : invokeV.longValue;
    }

    public long getStartTimeMSWithSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((float) this.startTime) / getCurrentSpeed() : invokeV.longValue;
    }

    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.uri : (String) invokeV.objValue;
    }

    public boolean isOverSupportSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isOverSupportSize : invokeV.booleanValue;
    }

    public boolean isShowSpeedChanger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIsShowSpeedChanger : invokeV.booleanValue;
    }

    public void setDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.duration = j2;
        }
    }

    public void setOverSupportSize(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isOverSupportSize = z;
        }
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.path = str;
        }
    }

    public void setShowSpeedChanger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mIsShowSpeedChanger = z;
        }
    }

    public void setSize(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.size = j2;
        }
    }

    public void setUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.uri = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LocalAlbumInfo m89clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LocalAlbumInfo localAlbumInfo = new LocalAlbumInfo();
            localAlbumInfo.path = this.path;
            localAlbumInfo.uri = this.uri;
            localAlbumInfo.date = this.date;
            localAlbumInfo.size = this.size;
            localAlbumInfo.width = this.width;
            localAlbumInfo.height = this.height;
            localAlbumInfo.imageId = this.imageId;
            localAlbumInfo.isSelected = this.isSelected;
            localAlbumInfo.mediaType = this.mediaType;
            localAlbumInfo.duration = this.duration;
            localAlbumInfo.startTime = this.startTime;
            localAlbumInfo.endTime = this.endTime;
            localAlbumInfo.durationType = this.durationType;
            localAlbumInfo.score = this.score;
            localAlbumInfo.uuid = this.uuid;
            localAlbumInfo.orientation = this.orientation;
            localAlbumInfo.mGlobalSpeed = this.mGlobalSpeed;
            localAlbumInfo.mSelfSpeed = this.mSelfSpeed;
            localAlbumInfo.setShowSpeedChanger(this.mIsShowSpeedChanger);
            return localAlbumInfo;
        }
        return (LocalAlbumInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull LocalAlbumInfo localAlbumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, localAlbumInfo)) == null) {
            if (localAlbumInfo == null) {
                return -1;
            }
            long j2 = this.date;
            long j3 = localAlbumInfo.date;
            if (j2 > j3) {
                return -1;
            }
            return j2 < j3 ? 1 : 0;
        }
        return invokeL.intValue;
    }
}
