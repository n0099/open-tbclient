package com.baidu.ugc.editvideo.editvideo.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class MusicInfo implements Parcelable, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<MusicInfo> CREATOR;
    public static final long serialVersionUID = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String author_name;
    public int downloadRetryTimes;
    public int duration;
    public String image;
    public boolean isChoosedBySticker;
    public boolean isLoading;
    public boolean isPlaying;
    public String localPath;
    public long mClipStartTime;
    public int mIsCollect;
    public String mMusicId;
    public int mMusicType;
    public int mUsedTime;
    public String name;
    public long realDuration;
    public String resource;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1215385285, "Lcom/baidu/ugc/editvideo/editvideo/data/MusicInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1215385285, "Lcom/baidu/ugc/editvideo/editvideo/data/MusicInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MusicInfo>() { // from class: com.baidu.ugc.editvideo.editvideo.data.MusicInfo.1
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
            public MusicInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new MusicInfo(parcel) : (MusicInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MusicInfo[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new MusicInfo[i] : (MusicInfo[]) invokeI.objValue;
            }
        };
    }

    public MusicInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isLoading = false;
        this.isPlaying = false;
    }

    public MusicInfo(Parcel parcel) {
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
        this.isLoading = false;
        this.isPlaying = false;
        this.mMusicId = parcel.readString();
        this.name = parcel.readString();
        this.image = parcel.readString();
        this.resource = parcel.readString();
        this.localPath = parcel.readString();
        this.author_name = parcel.readString();
        this.duration = parcel.readInt();
        this.realDuration = parcel.readLong();
        this.mIsCollect = parcel.readInt();
        this.mMusicType = parcel.readInt();
        this.mUsedTime = parcel.readInt();
        this.isLoading = parcel.readByte() != 0;
        this.isPlaying = parcel.readByte() != 0;
        this.downloadRetryTimes = parcel.readInt();
        this.mClipStartTime = parcel.readLong();
        this.isChoosedBySticker = parcel.readByte() != 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public MusicInfo m72clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.mMusicId = this.mMusicId;
            musicInfo.name = this.name;
            musicInfo.image = this.image;
            musicInfo.resource = this.resource;
            musicInfo.localPath = this.localPath;
            musicInfo.author_name = this.author_name;
            musicInfo.duration = this.duration;
            musicInfo.mIsCollect = this.mIsCollect;
            musicInfo.mUsedTime = this.mUsedTime;
            musicInfo.mClipStartTime = this.mClipStartTime;
            musicInfo.isLoading = this.isLoading;
            musicInfo.isPlaying = this.isPlaying;
            musicInfo.isChoosedBySticker = this.isChoosedBySticker;
            return musicInfo;
        }
        return (MusicInfo) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MusicInfo.class != obj.getClass()) {
                return false;
            }
            MusicInfo musicInfo = (MusicInfo) obj;
            if (this.duration != musicInfo.duration) {
                return false;
            }
            String str = this.mMusicId;
            if (str == null ? musicInfo.mMusicId == null : str.equals(musicInfo.mMusicId)) {
                String str2 = this.name;
                if (str2 == null ? musicInfo.name == null : str2.equals(musicInfo.name)) {
                    String str3 = this.image;
                    if (str3 == null ? musicInfo.image == null : str3.equals(musicInfo.image)) {
                        String str4 = this.resource;
                        if (str4 == null ? musicInfo.resource == null : str4.equals(musicInfo.resource)) {
                            return this.mClipStartTime == musicInfo.mClipStartTime;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.resource;
            int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.duration) * 31;
            String str4 = this.mMusicId;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public boolean isBaiduMusic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMusicType == 3 : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeString(this.mMusicId);
            parcel.writeString(this.name);
            parcel.writeString(this.image);
            parcel.writeString(this.resource);
            parcel.writeString(this.localPath);
            parcel.writeString(this.author_name);
            parcel.writeInt(this.duration);
            parcel.writeLong(this.realDuration);
            parcel.writeInt(this.mIsCollect);
            parcel.writeInt(this.mMusicType);
            parcel.writeInt(this.mUsedTime);
            parcel.writeByte(this.isLoading ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.isPlaying ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.downloadRetryTimes);
            parcel.writeLong(this.mClipStartTime);
            parcel.writeByte(this.isChoosedBySticker ? (byte) 1 : (byte) 0);
        }
    }
}
