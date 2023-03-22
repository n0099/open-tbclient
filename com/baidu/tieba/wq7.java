package com.baidu.tieba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.me;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class wq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ChatSetting> a;

    public abstract ChatSetting a(String str, String str2);

    public abstract me<String> b();

    public abstract void h(ChatSetting chatSetting);

    public abstract void i(ChatSetting chatSetting, zo5<Void> zo5Var);

    /* loaded from: classes6.dex */
    public class a extends wp5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wq7 c;

        public a(wq7 wq7Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq7Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wq7Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.wp5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChatSetting a = this.c.a(this.a, this.b);
                if (a == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(a.isAcceptNotify());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public wq7() {
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
        this.a = new HashMap<>();
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            ChatSetting a2 = a(str, str2);
            if (a2 == null) {
                return false;
            }
            return a2.isAcceptNotify();
        }
        return invokeLL.booleanValue;
    }

    public void d(String str, String str2, zo5<Boolean> zo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, zo5Var) == null) {
            aq5.c(new a(this, str, str2), zo5Var);
        }
    }

    public void f(String str, String str2, boolean z) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048581, this, str, str2, z) != null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        h(a2);
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (str2 != null && str2.length() != 0) {
                String str3 = str2 + "@";
                synchronized (this.a) {
                    me<String> b = b();
                    List<me.b<String>> b2 = ni.b(b);
                    if (b2 != null) {
                        for (me.b<String> bVar : b2) {
                            String str4 = bVar.a;
                            if (str4 != null && str4.startsWith(str3) && (str = b.get(str4)) != null) {
                                this.a.put(str4, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                            }
                        }
                    }
                }
            }
        }
    }

    public void g(String str, String str2, boolean z, zo5<Void> zo5Var) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), zo5Var}) != null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        i(a2, zo5Var);
    }
}
