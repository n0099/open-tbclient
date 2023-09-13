package com.baidu.tieba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.oe;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class ki8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ChatSetting> memoryCachedSettings;

    public abstract ChatSetting getSetting(String str, String str2);

    public abstract oe<String> getSettingCache();

    public abstract void saveSetting(ChatSetting chatSetting);

    public abstract void saveSettingAsync(ChatSetting chatSetting, cx5<Void> cx5Var);

    /* loaded from: classes6.dex */
    public class a extends xx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ki8 c;

        public a(ki8 ki8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki8Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ki8Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.xx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChatSetting setting = this.c.getSetting(this.a, this.b);
                if (setting == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(setting.isAcceptNotify());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public ki8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.memoryCachedSettings = new HashMap<>();
    }

    public boolean isAcceptNotify(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            ChatSetting setting = getSetting(str, str2);
            if (setting == null) {
                return false;
            }
            return setting.isAcceptNotify();
        }
        return invokeLL.booleanValue;
    }

    public void isAcceptNotifyAsync(String str, String str2, cx5<Boolean> cx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, cx5Var) == null) {
            by5.c(new a(this, str, str2), cx5Var);
        }
    }

    public void saveAcceptNotify(String str, String str2, boolean z) {
        ChatSetting setting;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048581, this, str, str2, z) != null) || (setting = getSetting(str, str2)) == null) {
            return;
        }
        setting.setAcceptNotify(z);
        saveSetting(setting);
    }

    public void onAccountChangedInBackground(Class<? extends ChatSetting> cls) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this.memoryCachedSettings) {
                this.memoryCachedSettings.clear();
            }
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str2 != null && str2.length() != 0) {
                String str3 = str2 + "@";
                synchronized (this.memoryCachedSettings) {
                    oe<String> settingCache = getSettingCache();
                    List<oe.b<String>> b = ji.b(settingCache);
                    if (b != null) {
                        for (oe.b<String> bVar : b) {
                            String str4 = bVar.a;
                            if (str4 != null && str4.startsWith(str3) && (str = settingCache.get(str4)) != null) {
                                this.memoryCachedSettings.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                            }
                        }
                    }
                }
            }
        }
    }

    public void saveAcceptNotifyAsync(String str, String str2, boolean z, cx5<Void> cx5Var) {
        ChatSetting setting;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), cx5Var}) != null) || (setting = getSetting(str, str2)) == null) {
            return;
        }
        setting.setAcceptNotify(z);
        saveSettingAsync(setting, cx5Var);
    }
}
