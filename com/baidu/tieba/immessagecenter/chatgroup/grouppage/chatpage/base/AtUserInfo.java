package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AtUserInfo extends BaseInfo<IChatRoomEnterListener.AtUserInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String atName;
    public String atPortrait;
    public int atPosition;
    public AtType atType;
    public long atUid;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class AtType {
        public static final /* synthetic */ AtType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AtType ALL;
        public static final AtType USER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036945222, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AtUserInfo$AtType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1036945222, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AtUserInfo$AtType;");
                    return;
                }
            }
            USER = new AtType("USER", 0);
            AtType atType = new AtType("ALL", 1);
            ALL = atType;
            $VALUES = new AtType[]{USER, atType};
        }

        public AtType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AtType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AtType) Enum.valueOf(AtType.class, str);
            }
            return (AtType) invokeL.objValue;
        }

        public static AtType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AtType[]) $VALUES.clone();
            }
            return (AtType[]) invokeV.objValue;
        }
    }

    public AtUserInfo() {
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

    @NonNull
    public static AtUserInfo create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new AtUserInfo();
        }
        return (AtUserInfo) invokeV.objValue;
    }

    public String getAtName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.atName;
        }
        return (String) invokeV.objValue;
    }

    public int getAtPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.atPosition;
        }
        return invokeV.intValue;
    }

    public AtType getAtType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.atType;
        }
        return (AtType) invokeV.objValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.atUid;
        }
        return invokeV.longValue;
    }

    public AtUserInfo(@NonNull AtType atType, long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atType, Long.valueOf(j), str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.atType = atType;
        this.atUid = j;
        this.atName = str;
        this.atPortrait = str2;
        this.atPosition = i;
    }

    @NonNull
    public static AtUserInfo create(@NonNull AtType atType, long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{atType, Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) {
            return new AtUserInfo(atType, j, str, str2, i);
        }
        return (AtUserInfo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    @NonNull
    public IChatRoomEnterListener.AtUserInfo createSdkInfo() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            IChatRoomEnterListener.AtUserInfo atUserInfo = new IChatRoomEnterListener.AtUserInfo();
            if (this.atType == AtType.ALL) {
                str = "all";
            } else {
                str = "user";
            }
            atUserInfo.atType = str;
            atUserInfo.atBdUk = BIMManager.getBdUKFromBdUid(String.valueOf(this.atUid));
            atUserInfo.atName = this.atName;
            atUserInfo.atPortrait = this.atPortrait;
            atUserInfo.atPosition = String.valueOf(this.atPosition);
            return atUserInfo;
        }
        return (IChatRoomEnterListener.AtUserInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    public void fromSdkInfo(@NonNull IChatRoomEnterListener.AtUserInfo atUserInfo) {
        AtType atType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, atUserInfo) == null) {
            if (TextUtils.equals(atUserInfo.atType, "all")) {
                atType = AtType.ALL;
            } else {
                atType = AtType.USER;
            }
            this.atType = atType;
            this.atUid = Long.parseLong(BIMManager.getBdUidFromBdUK(atUserInfo.atBdUk));
            this.atName = atUserInfo.atName;
            this.atPortrait = atUserInfo.atPortrait;
            this.atPosition = Integer.parseInt(atUserInfo.atPosition);
        }
    }
}
