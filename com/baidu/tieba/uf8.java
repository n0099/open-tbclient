package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uf8 extends pf8 {
    public static /* synthetic */ Interceptable $ic;
    public static uf8 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends wy5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uf8 c;

        public a(uf8 uf8Var, PersonalSettingItemData personalSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf8Var, personalSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uf8Var;
            this.a = personalSettingItemData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.b().g(this.b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209186, "Lcom/baidu/tieba/uf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209186, "Lcom/baidu/tieba/uf8;");
                return;
            }
        }
        b = new uf8();
    }

    public uf8() {
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

    public static uf8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (uf8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf8
    public ye<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o55.e();
            return o55.f("tb.im_personal_chat_setting");
        }
        return (ye) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.e(PersonalSettingItemData.class);
        }
    }

    @Override // com.baidu.tieba.pf8
    public void h(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                ye<String> b2 = b();
                String str = myUid + "@" + toUid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
                synchronized (this.a) {
                    this.a.put(str, personalSettingItemData);
                }
                b2.g(str, jsonStrWithObject);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // com.baidu.tieba.pf8
    public void i(ChatSetting chatSetting, ay5<Void> ay5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, chatSetting, ay5Var) == null) && chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
                String str = myUid + "@" + toUid;
                synchronized (this.a) {
                    this.a.put(str, personalSettingItemData);
                }
                az5.c(new a(this, personalSettingItemData, str), ay5Var);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pf8
    /* renamed from: k */
    public PersonalSettingItemData a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            PersonalSettingItemData personalSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.a) {
                ChatSetting chatSetting = this.a.get(str3);
                if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
                    personalSettingItemData = (PersonalSettingItemData) chatSetting;
                }
            }
            if (personalSettingItemData == null) {
                PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
                personalSettingItemData2.setMyUid(str);
                personalSettingItemData2.setToUid(str2);
                personalSettingItemData2.setAcceptNotify(true);
                return personalSettingItemData2;
            }
            return personalSettingItemData;
        }
        return (PersonalSettingItemData) invokeLL.objValue;
    }

    public void m(String str, String str2, UserData userData) {
        PersonalSettingItemData a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, userData) != null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setToPortrait(userData.getPortrait());
        a2.setToName(userData.getUserName());
        h(a2);
    }
}
