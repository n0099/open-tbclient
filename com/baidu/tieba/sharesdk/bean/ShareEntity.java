package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ShareEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ShareEntity> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canShareBySmartApp;
    public String content;
    public Bundle diskPicOperate;
    public String extLiveInfo;
    public String fName;
    public Uri imageUri;
    public boolean isVideoThread;
    public String linkUrl;
    public String localFile;
    public Location location;
    public long readCount;
    public int shareTo;
    public int shareType;
    public Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String title;
    public String topic;
    public int typeShareToSmallApp;
    public String videoUrl;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ShareEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                if (parcel == null) {
                    return null;
                }
                ShareEntity shareEntity = new ShareEntity();
                shareEntity.setTitle(parcel.readString());
                shareEntity.setContent(parcel.readString());
                shareEntity.setLinkUrl(parcel.readString());
                shareEntity.setLocalFile(parcel.readString());
                shareEntity.setShareTo(parcel.readInt());
                shareEntity.setVideoUrl(parcel.readString());
                shareEntity.setImageUri((Uri) parcel.readParcelable(Uri.class.getClassLoader()));
                shareEntity.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
                shareEntity.setStats(parcel.readBundle());
                shareEntity.setPreferImageToLink(parcel.readInt());
                shareEntity.setTid(parcel.readString());
                shareEntity.setTypeShareToSmallApp(parcel.readInt());
                shareEntity.setfName(parcel.readString());
                shareEntity.topic = parcel.readString();
                shareEntity.taskCompleteId = parcel.readString();
                shareEntity.diskPicOperate = parcel.readBundle();
                shareEntity.canShareBySmartApp = parcel.readByte() == 1;
                shareEntity.setReadCount(parcel.readLong());
                shareEntity.setIsVideoThread(parcel.readByte() == 1);
                shareEntity.extLiveInfo = parcel.readString();
                return shareEntity;
            }
            return (ShareEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareEntity[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new ShareEntity[i2] : (ShareEntity[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1202551602, "Lcom/baidu/tieba/sharesdk/bean/ShareEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1202551602, "Lcom/baidu/tieba/sharesdk/bean/ShareEntity;");
                return;
            }
        }
        CREATOR = new a();
    }

    public ShareEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.typeShareToSmallApp = 0;
        this.canShareBySmartApp = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public String getExtLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extLiveInfo : (String) invokeV.objValue;
    }

    public Uri getImageUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.imageUri : (Uri) invokeV.objValue;
    }

    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Uri uri = this.imageUri;
            return uri == null ? "" : uri.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsVideoThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isVideoThread : invokeV.booleanValue;
    }

    public String getLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.linkUrl : (String) invokeV.objValue;
    }

    public String getLocalFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.localFile : (String) invokeV.objValue;
    }

    public Location getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.location : (Location) invokeV.objValue;
    }

    public long getReadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.readCount : invokeV.longValue;
    }

    public int getShareTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.shareTo : invokeV.intValue;
    }

    public int getShareType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.shareType : invokeV.intValue;
    }

    public int getStatValueInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Bundle bundle = this.stats;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt(str, -1);
        }
        return invokeL.intValue;
    }

    public long getStatValueLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Bundle bundle = this.stats;
            if (bundle == null) {
                return -1L;
            }
            return bundle.getLong(str, -1L);
        }
        return invokeL.longValue;
    }

    public String getStatValueString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Bundle bundle = this.stats;
            return bundle == null ? "" : bundle.getString(str);
        }
        return (String) invokeL.objValue;
    }

    public Bundle getStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.stats : (Bundle) invokeV.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.tid : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public int getTypeShareToSmallApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.typeShareToSmallApp : invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.videoUrl : (String) invokeV.objValue;
    }

    public String getfName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.fName : (String) invokeV.objValue;
    }

    public boolean needCheckStoragePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.shareType != 0) {
                int i2 = this.shareTo;
                return i2 == 8 || i2 == 4 || i2 == 3 || i2 == 2;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.content = str;
        }
    }

    public void setExtLiveInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.extLiveInfo = str;
        }
    }

    public void setImageUri(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, uri) == null) {
            this.imageUri = uri;
        }
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.isVideoThread = z;
        }
    }

    public void setLinkUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.linkUrl = str;
        }
    }

    public void setLocalFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.localFile = str;
        }
    }

    public void setLocation(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, location) == null) {
            this.location = location;
        }
    }

    public void setPreferImageToLink(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.shareType = i2;
        }
    }

    public void setReadCount(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
            this.readCount = j2;
        }
    }

    public void setShareTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.shareTo = i2;
        }
    }

    public void setStats(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            this.stats = bundle;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.tid = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.title = str;
        }
    }

    public void setTypeShareToSmallApp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.typeShareToSmallApp = i2;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.videoUrl = str;
        }
    }

    public void setfName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.fName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, parcel, i2) == null) {
            parcel.writeString(this.title);
            parcel.writeString(this.content);
            parcel.writeString(this.linkUrl);
            parcel.writeString(this.localFile);
            parcel.writeInt(this.shareTo);
            parcel.writeString(this.videoUrl);
            parcel.writeParcelable(this.imageUri, i2);
            parcel.writeParcelable(this.location, i2);
            parcel.writeBundle(this.stats);
            parcel.writeInt(this.shareType);
            parcel.writeString(this.tid);
            parcel.writeInt(this.typeShareToSmallApp);
            parcel.writeString(this.fName);
            parcel.writeString(this.topic);
            parcel.writeString(this.taskCompleteId);
            parcel.writeBundle(this.diskPicOperate);
            parcel.writeByte(this.canShareBySmartApp ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.readCount);
            parcel.writeByte(this.isVideoThread ? (byte) 1 : (byte) 0);
            parcel.writeString(this.extLiveInfo);
        }
    }
}
