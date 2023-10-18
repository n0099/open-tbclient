package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tg8 extends rg8 {
    public static /* synthetic */ Interceptable $ic;
    public static tg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends gs5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupSettingItemData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tg8 c;

        public a(tg8 tg8Var, GroupSettingItemData groupSettingItemData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg8Var, groupSettingItemData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tg8Var;
            this.a = groupSettingItemData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.getSettingCache().g(this.b, OrmObject.jsonStrWithObject(this.a));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948180356, "Lcom/baidu/tieba/tg8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948180356, "Lcom/baidu/tieba/tg8;");
                return;
            }
        }
        a = new tg8();
    }

    public tg8() {
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

    public static tg8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (tg8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg8
    public m9<String> getSettingCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            gz4.k();
            return gz4.l("tb.im_group_setting");
        }
        return (m9) invokeV.objValue;
    }

    public void onAccountChangedInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAccountChangedInBackground(GroupSettingItemData.class);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rg8
    /* renamed from: b */
    public GroupSettingItemData getSetting(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            GroupSettingItemData groupSettingItemData = null;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = str + "@" + str2;
            synchronized (this.memoryCachedSettings) {
                ChatSetting chatSetting = this.memoryCachedSettings.get(str3);
                if (chatSetting instanceof GroupSettingItemData) {
                    groupSettingItemData = (GroupSettingItemData) chatSetting;
                }
            }
            if (groupSettingItemData == null) {
                GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
                groupSettingItemData2.setUid(str);
                groupSettingItemData2.setGid(str2);
                groupSettingItemData2.setAcceptNotify(true);
                groupSettingItemData2.setInGroup(true);
                return groupSettingItemData2;
            }
            return groupSettingItemData;
        }
        return (GroupSettingItemData) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.rg8
    public void saveSetting(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, chatSetting) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                m9<String> settingCache = getSettingCache();
                String str = uid + "@" + gid;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, groupSettingItemData);
                }
                settingCache.g(str, jsonStrWithObject);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }

    @Override // com.baidu.tieba.rg8
    public void saveSettingAsync(ChatSetting chatSetting, lr5<Void> lr5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, chatSetting, lr5Var) == null) && chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
                String str = uid + "@" + gid;
                synchronized (this.memoryCachedSettings) {
                    this.memoryCachedSettings.put(str, groupSettingItemData);
                }
                ks5.c(new a(this, groupSettingItemData, str), lr5Var);
            } else if (!TbConfig.getDebugSwitch()) {
            } else {
                throw new RuntimeException("key param is null");
            }
        }
    }
}
