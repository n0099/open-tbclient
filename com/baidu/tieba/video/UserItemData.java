package com.baidu.tieba.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class UserItemData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<UserItemData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String agree_num;
    public String auth;
    public String bjhAvatar;
    public String fans_num;
    public String favor_num;
    public String follow_num;
    public String gender;
    public String intro;
    public String is_fans;
    public String is_follow;
    public String name_show;
    public String portrait;
    public String user_id;
    public String user_name;
    public String video_num;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator<UserItemData> {
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
        public UserItemData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new UserItemData(parcel);
            }
            return (UserItemData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public UserItemData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new UserItemData[i];
            }
            return (UserItemData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10279857, "Lcom/baidu/tieba/video/UserItemData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(10279857, "Lcom/baidu/tieba/video/UserItemData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public UserItemData() {
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

    public String getUserShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.name_show)) {
                return this.name_show;
            }
            return this.user_name;
        }
        return (String) invokeV.objValue;
    }

    public UserItemData(Parcel parcel) {
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
        this.user_id = parcel.readString();
        this.user_name = parcel.readString();
        this.name_show = parcel.readString();
        this.portrait = parcel.readString();
        this.gender = parcel.readString();
        this.follow_num = parcel.readString();
        this.fans_num = parcel.readString();
        this.video_num = parcel.readString();
        this.agree_num = parcel.readString();
        this.intro = parcel.readString();
        this.favor_num = parcel.readString();
        this.is_fans = parcel.readString();
        this.is_follow = parcel.readString();
        this.bjhAvatar = parcel.readString();
        this.auth = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.user_id);
            parcel.writeString(this.user_name);
            parcel.writeString(this.name_show);
            parcel.writeString(this.portrait);
            parcel.writeString(this.gender);
            parcel.writeString(this.follow_num);
            parcel.writeString(this.fans_num);
            parcel.writeString(this.video_num);
            parcel.writeString(this.agree_num);
            parcel.writeString(this.intro);
            parcel.writeString(this.favor_num);
            parcel.writeString(this.is_fans);
            parcel.writeString(this.is_follow);
            parcel.writeString(this.bjhAvatar);
            parcel.writeString(this.auth);
        }
    }
}
