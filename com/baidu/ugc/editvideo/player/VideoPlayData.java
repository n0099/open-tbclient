package com.baidu.ugc.editvideo.player;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class VideoPlayData implements Parcelable, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<VideoPlayData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int end;
    public int height;
    public int insertIndex;
    public boolean isOriginal;
    public String mMaterialId;
    public VideoPlayData next;
    public int offset;
    public int rotation;
    public int start;
    public String videoPath;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(685901606, "Lcom/baidu/ugc/editvideo/player/VideoPlayData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(685901606, "Lcom/baidu/ugc/editvideo/player/VideoPlayData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<VideoPlayData>() { // from class: com.baidu.ugc.editvideo.player.VideoPlayData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoPlayData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new VideoPlayData(parcel);
                }
                return (VideoPlayData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoPlayData[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new VideoPlayData[i];
                }
                return (VideoPlayData[]) invokeI.objValue;
            }
        };
    }

    public VideoPlayData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public VideoPlayData(Parcel parcel) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.videoPath = parcel.readString();
        this.offset = parcel.readInt();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
        this.next = (VideoPlayData) parcel.readParcelable(VideoPlayData.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isOriginal = z;
        this.insertIndex = parcel.readInt();
        this.rotation = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mMaterialId = parcel.readString();
    }

    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.videoPath = jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                this.offset = jSONObject.optInt("offset");
                this.start = jSONObject.optInt("start");
                this.end = jSONObject.optInt("end");
                String optString = jSONObject.optString(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                if (!TextUtils.isEmpty(optString)) {
                    VideoPlayData videoPlayData = new VideoPlayData();
                    videoPlayData.parse(optString);
                    this.next = videoPlayData;
                }
                this.isOriginal = jSONObject.optBoolean("isOriginal");
                this.insertIndex = jSONObject.optInt("insertIndex");
                this.rotation = jSONObject.optInt("rotation");
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
                this.mMaterialId = jSONObject.optString("mMaterialId");
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public VideoPlayData(String str, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.videoPath = str;
        this.start = i;
        this.end = i2;
        this.isOriginal = z;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null || !(obj instanceof VideoPlayData)) {
                return false;
            }
            VideoPlayData videoPlayData = (VideoPlayData) obj;
            if (TextUtils.isEmpty(this.videoPath)) {
                if (!TextUtils.isEmpty(videoPlayData.videoPath)) {
                    return false;
                }
            } else if (!this.videoPath.equals(videoPlayData.videoPath)) {
                return false;
            }
            if (this.start != videoPlayData.start || this.end != videoPlayData.end) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setInsertIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.insertIndex = i;
        }
    }

    public void setMaterialId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mMaterialId = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.videoPath);
                jSONObject.put("offset", this.offset);
                jSONObject.put("start", this.start);
                jSONObject.put("end", this.end);
                jSONObject.put(UnitedSchemeConstants.UNITED_SCHEME_NEXT, this.next.toJson().toString());
                jSONObject.put("isOriginal", this.isOriginal);
                jSONObject.put("insertIndex", this.insertIndex);
                jSONObject.put("rotation", this.rotation);
                jSONObject.put("width", this.width);
                jSONObject.put("height", this.height);
                jSONObject.put("mMaterialId", this.mMaterialId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeString(this.videoPath);
            parcel.writeInt(this.offset);
            parcel.writeInt(this.start);
            parcel.writeInt(this.end);
            parcel.writeParcelable(this.next, i);
            parcel.writeByte(this.isOriginal ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.insertIndex);
            parcel.writeInt(this.rotation);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeString(this.mMaterialId);
        }
    }
}
