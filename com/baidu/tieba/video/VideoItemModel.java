package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jx8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes6.dex */
public class VideoItemModel implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<VideoItemModel> CREATOR;
    public static final int TYPE_FUNAD = 2;
    public static final int TYPE_LOADING = 99999;
    public static final int TYPE_NAD_AD = 5;
    public static final int TYPE_NOATTENTION = 4;
    public static final int TYPE_NOLOGIN = 3;
    public static final int TYPE_VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int dataType;
    public final int mHashCode;
    public jx8 videoAdData;
    public final VideoItemData videoItemData;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<VideoItemModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoItemModel createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new VideoItemModel(parcel);
            }
            return (VideoItemModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoItemModel[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new VideoItemModel[i];
            }
            return (VideoItemModel[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1519228734, "Lcom/baidu/tieba/video/VideoItemModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1519228734, "Lcom/baidu/tieba/video/VideoItemModel;");
                return;
            }
        }
        CREATOR = new a();
    }

    public int getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dataType;
        }
        return invokeV.intValue;
    }

    public int getHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mHashCode;
        }
        return invokeV.intValue;
    }

    public jx8 getVideoAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.videoAdData;
        }
        return (jx8) invokeV.objValue;
    }

    public VideoItemData getVideoItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.videoItemData;
        }
        return (VideoItemData) invokeV.objValue;
    }

    public boolean isFunAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.dataType == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoadingType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.dataType == 99999) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNADType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.dataType == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoAttentionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.dataType == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.dataType == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public VideoItemModel(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.videoItemData = (VideoItemData) parcel.readParcelable(VideoItemData.class.getClassLoader());
        this.dataType = parcel.readInt();
        this.mHashCode = parcel.readInt();
    }

    public VideoItemModel(VideoItemData videoItemData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoItemData, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.videoItemData = videoItemData;
        this.dataType = i;
        this.mHashCode = hashCode();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VideoItemModel.class != obj.getClass()) {
                return false;
            }
            VideoItemModel videoItemModel = (VideoItemModel) obj;
            if (isNoLoginType() && videoItemModel.isNoLoginType()) {
                if (this.mHashCode == videoItemModel.hashCode()) {
                    return true;
                }
                return false;
            } else if (isNoAttentionType() && videoItemModel.isNoAttentionType()) {
                if (this.mHashCode == videoItemModel.hashCode()) {
                    return true;
                }
                return false;
            } else if (isFunAdType() && videoItemModel.isFunAdType()) {
                if (this.mHashCode == videoItemModel.hashCode()) {
                    return true;
                }
                return false;
            } else if (isNADType() && videoItemModel.isNADType()) {
                if (this.mHashCode == videoItemModel.hashCode()) {
                    return true;
                }
                return false;
            } else if (isFunAdType() == videoItemModel.isFunAdType() && Objects.equals(this.videoItemData, videoItemModel.videoItemData)) {
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setVideoAdData(jx8 jx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jx8Var) == null) {
            this.videoAdData = jx8Var;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, parcel, i) == null) {
            parcel.writeParcelable(this.videoItemData, i);
            parcel.writeInt(this.dataType);
            parcel.writeInt(this.mHashCode);
        }
    }
}
