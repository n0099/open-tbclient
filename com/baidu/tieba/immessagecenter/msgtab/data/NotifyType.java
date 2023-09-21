package com.baidu.tieba.immessagecenter.msgtab.data;

import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/NotifyType;", "", "title", "", "icon", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIcon", "()I", "getTitle", "()Ljava/lang/String;", "AT_ME", "AGREE_ME", "REPLY_ME", "FANS", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NotifyType {
    public static final /* synthetic */ NotifyType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NotifyType AGREE_ME;
    public static final NotifyType AT_ME;
    public static final NotifyType FANS;
    public static final NotifyType REPLY_ME;
    public transient /* synthetic */ FieldHolder $fh;
    public final int icon;
    public final String title;

    public static final /* synthetic */ NotifyType[] $values() {
        return new NotifyType[]{AT_ME, AGREE_ME, REPLY_ME, FANS};
    }

    public static NotifyType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (NotifyType) Enum.valueOf(NotifyType.class, str) : (NotifyType) invokeL.objValue;
    }

    public static NotifyType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (NotifyType[]) $VALUES.clone() : (NotifyType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(39306633, "Lcom/baidu/tieba/immessagecenter/msgtab/data/NotifyType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(39306633, "Lcom/baidu/tieba/immessagecenter/msgtab/data/NotifyType;");
                return;
            }
        }
        AT_ME = new NotifyType("AT_ME", 0, "@我的", R.drawable.obfuscated_res_0x7f0810ea);
        AGREE_ME = new NotifyType("AGREE_ME", 1, "点赞", R.drawable.obfuscated_res_0x7f0810e9);
        REPLY_ME = new NotifyType("REPLY_ME", 2, "回复", R.drawable.obfuscated_res_0x7f0810ec);
        FANS = new NotifyType("FANS", 3, "粉丝", R.drawable.obfuscated_res_0x7f0810eb);
        $VALUES = $values();
    }

    public NotifyType(String str, @DrawableRes int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.title = str2;
        this.icon = i2;
    }

    public final int getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.icon;
        }
        return invokeV.intValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }
}
