package com.baidu.tieba.sharesdk.bean;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.data.GroupInfoData;
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
    public String festivalTaskTid;
    public String festivalTaskType;
    public String floorAuthorUid;
    public GroupInfoData groupData;
    public Uri imageUri;
    public boolean isFromDuXiaoMan;
    public boolean isVideoThread;
    public String linkUrl;
    public String localFile;
    public Location location;
    public String mTopicId;
    public long readCount;
    public int shareMediaType;
    public int shareTo;
    public int shareType;
    public Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String title;
    public String topic;
    public int typeShareToSmallApp;
    public String videoUrl;

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
    public static class a implements Parcelable.Creator<ShareEntity> {
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
        public ShareEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
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
                shareEntity.setFloorAuthorUid(parcel.readString());
                shareEntity.setTypeShareToSmallApp(parcel.readInt());
                shareEntity.setfName(parcel.readString());
                shareEntity.topic = parcel.readString();
                shareEntity.taskCompleteId = parcel.readString();
                shareEntity.diskPicOperate = parcel.readBundle();
                boolean z3 = false;
                if (parcel.readByte() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                shareEntity.canShareBySmartApp = z;
                shareEntity.setReadCount(parcel.readLong());
                if (parcel.readByte() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                shareEntity.setIsVideoThread(z2);
                shareEntity.setFestivalTaskTid(parcel.readString());
                shareEntity.setFestivalTaskType(parcel.readString());
                shareEntity.extLiveInfo = parcel.readString();
                if (parcel.readByte() == 1) {
                    z3 = true;
                }
                shareEntity.setFromDuXiaoMan(z3);
                shareEntity.mTopicId = parcel.readString();
                shareEntity.groupData = (GroupInfoData) parcel.readParcelable(GroupInfoData.class.getClassLoader());
                shareEntity.shareMediaType = parcel.readInt();
                return shareEntity;
            }
            return (ShareEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareEntity[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new ShareEntity[i];
            }
            return (ShareEntity[]) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.typeShareToSmallApp = 0;
        this.canShareBySmartApp = true;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public String getExtLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.extLiveInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getFestivalTaskTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.festivalTaskTid;
        }
        return (String) invokeV.objValue;
    }

    public String getFestivalTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.festivalTaskType;
        }
        return (String) invokeV.objValue;
    }

    public String getFloorAuthorUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.floorAuthorUid;
        }
        return (String) invokeV.objValue;
    }

    public Uri getImageUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.imageUri;
        }
        return (Uri) invokeV.objValue;
    }

    public String getImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Uri uri = this.imageUri;
            if (uri == null) {
                return "";
            }
            return uri.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsVideoThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isVideoThread;
        }
        return invokeV.booleanValue;
    }

    public String getLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.linkUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getLocalFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.localFile;
        }
        return (String) invokeV.objValue;
    }

    public Location getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.location;
        }
        return (Location) invokeV.objValue;
    }

    public long getReadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.readCount;
        }
        return invokeV.longValue;
    }

    public int getShareTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.shareTo;
        }
        return invokeV.intValue;
    }

    public int getShareType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.shareType;
        }
        return invokeV.intValue;
    }

    public Bundle getStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.stats;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.tid;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTopicId;
        }
        return (String) invokeV.objValue;
    }

    public int getTypeShareToSmallApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.typeShareToSmallApp;
        }
        return invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.videoUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getfName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.fName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isFromDuXiaoMan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.isFromDuXiaoMan;
        }
        return invokeV.booleanValue;
    }

    public boolean needCheckStoragePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.shareType != 0) {
                int i = this.shareTo;
                if (i == 8 || i == 4 || i == 3 || i == 2) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getStatValueInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            Bundle bundle = this.stats;
            if (bundle == null) {
                return "";
            }
            return bundle.getString(str);
        }
        return (String) invokeL.objValue;
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.content = str;
        }
    }

    public void setExtLiveInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.extLiveInfo = str;
        }
    }

    public void setFestivalTaskTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.festivalTaskTid = str;
        }
    }

    public void setFestivalTaskType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.festivalTaskType = str;
        }
    }

    public void setFloorAuthorUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.floorAuthorUid = str;
        }
    }

    public void setFromDuXiaoMan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isFromDuXiaoMan = z;
        }
    }

    public void setImageUri(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, uri) == null) {
            this.imageUri = uri;
        }
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isVideoThread = z;
        }
    }

    public void setLinkUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.linkUrl = str;
        }
    }

    public void setLocalFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.localFile = str;
        }
    }

    public void setLocation(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, location) == null) {
            this.location = location;
        }
    }

    public void setPreferImageToLink(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.shareType = i;
        }
    }

    public void setReadCount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.readCount = j;
        }
    }

    public void setShareTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.shareTo = i;
        }
    }

    public void setStats(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
            this.stats = bundle;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.tid = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.title = str;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mTopicId = str;
        }
    }

    public void setTypeShareToSmallApp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.typeShareToSmallApp = i;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.videoUrl = str;
        }
    }

    public void setfName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.fName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048624, this, parcel, i) == null) {
            parcel.writeString(this.title);
            parcel.writeString(this.content);
            parcel.writeString(this.linkUrl);
            parcel.writeString(this.localFile);
            parcel.writeInt(this.shareTo);
            parcel.writeString(this.videoUrl);
            parcel.writeParcelable(this.imageUri, i);
            parcel.writeParcelable(this.location, i);
            parcel.writeBundle(this.stats);
            parcel.writeInt(this.shareType);
            parcel.writeString(this.tid);
            parcel.writeString(this.floorAuthorUid);
            parcel.writeInt(this.typeShareToSmallApp);
            parcel.writeString(this.fName);
            parcel.writeString(this.topic);
            parcel.writeString(this.taskCompleteId);
            parcel.writeBundle(this.diskPicOperate);
            parcel.writeByte(this.canShareBySmartApp ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.readCount);
            parcel.writeByte(this.isVideoThread ? (byte) 1 : (byte) 0);
            parcel.writeString(this.festivalTaskTid);
            parcel.writeString(this.festivalTaskType);
            parcel.writeString(this.extLiveInfo);
            parcel.writeByte(this.isFromDuXiaoMan ? (byte) 1 : (byte) 0);
            parcel.writeString(this.mTopicId);
            parcel.writeParcelable(this.groupData, i);
            parcel.writeInt(this.shareMediaType);
        }
    }
}
