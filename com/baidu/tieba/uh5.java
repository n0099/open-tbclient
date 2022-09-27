package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class uh5 {
    public static /* synthetic */ Interceptable $ic;
    public static uh5 g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public int d;
    public String e;
    public Runnable f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh5 a;

        public a(uh5 uh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("from", String.valueOf(this.a.a));
                hashMap.put("field_id", this.a.b);
                hashMap.put("type", Integer.valueOf(this.a.d));
                hashMap.put("type_name", this.a.e);
                if (this.a.a == 2) {
                    hashMap.put("fid", this.a.c);
                }
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put("transparent", Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    gh.a().postDelayed(this.a.f, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "GodInvitePage", hashMap)));
                ox4.k().x("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948211015, "Lcom/baidu/tieba/uh5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948211015, "Lcom/baidu/tieba/uh5;");
        }
    }

    public uh5() {
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
        this.f = new a(this);
    }

    public static synchronized uh5 g() {
        InterceptResult invokeV;
        uh5 uh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (uh5.class) {
                if (g == null) {
                    g = new uh5();
                }
                uh5Var = g;
            }
            return uh5Var;
        }
        return (uh5) invokeV.objValue;
    }

    public final boolean h(int i, NewGodData newGodData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, newGodData)) == null) {
            if (i != 5) {
                return (((((System.currentTimeMillis() - ox4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) > ImagesInvalidService.FILE_VALID_TIME ? 1 : (((System.currentTimeMillis() - ox4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) == ImagesInvalidService.FILE_VALID_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gh.a().removeCallbacks(this.f);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void k(int i, NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, newGodData) == null) {
            l(i, newGodData, true);
        }
    }

    public void l(int i, NewGodData newGodData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), newGodData, Boolean.valueOf(z)}) == null) && h(i, newGodData)) {
            i();
            this.a = i;
            this.b = newGodData.getFieldId();
            this.d = newGodData.getType();
            this.e = newGodData.getTypeName();
            gh.a().postDelayed(this.f, z ? 3000L : 0L);
            if (i == 5 || i == 1) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
            }
        }
    }
}
