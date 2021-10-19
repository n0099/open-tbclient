package com.baidu.wallet.lightapp.business.datamodel;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes8.dex */
public class ContactInfo implements Comparator<ContactInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62171a;

    /* renamed from: b  reason: collision with root package name */
    public String f62172b;

    /* loaded from: classes8.dex */
    public static class Phone implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String number;
        public int type;

        public Phone() {
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

        public String getTypeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.type;
                return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 10 ? i2 != 12 ? "其他" : "主机" : "公司总机" : "家庭传真" : "工作传真" : "工作" : "手机" : "住宅" : "自定义";
            }
            return (String) invokeV.objValue;
        }
    }

    public ContactInfo() {
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
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ContactInfo contactInfo, ContactInfo contactInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, contactInfo, contactInfo2)) == null) {
            if (contactInfo == null && contactInfo2 == null) {
                return 0;
            }
            if (contactInfo == null) {
                return contactInfo2 == null ? 0 : 1;
            } else if (contactInfo2 == null) {
                return contactInfo == null ? 0 : -1;
            } else {
                contactInfo.f62172b = a(contactInfo.f62171a);
                contactInfo2.f62172b = a(contactInfo2.f62171a);
                if (TextUtils.isEmpty(contactInfo.f62172b) && TextUtils.isEmpty(contactInfo2.f62172b)) {
                    return 0;
                }
                if (TextUtils.isEmpty(contactInfo.f62172b)) {
                    return !TextUtils.isEmpty(contactInfo2.f62172b) ? 1 : 0;
                }
                if (TextUtils.isEmpty(contactInfo2.f62172b)) {
                    return TextUtils.isEmpty(contactInfo.f62172b) ? 0 : -1;
                }
                contactInfo.f62172b = contactInfo.f62172b.toUpperCase();
                String upperCase = contactInfo2.f62172b.toUpperCase();
                contactInfo2.f62172b = upperCase;
                if (contactInfo.f62172b.equals(upperCase)) {
                    return 0;
                }
                if (contactInfo.f62172b.equals("#")) {
                    return 1;
                }
                if (contactInfo2.f62172b.equals("#")) {
                    return -1;
                }
                return contactInfo.f62172b.compareTo(contactInfo2.f62172b);
            }
        }
        return invokeLL.intValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (TextUtils.isEmpty(str) || str.length() < 1 || !str.substring(0, 1).toUpperCase().matches("[A-Z]")) ? "#" : str : (String) invokeL.objValue;
    }
}
