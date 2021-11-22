package com.baidu.tieba.personExtra;

import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.f.d.l;
import b.a.q0.s.r.a;
import b.a.r0.o2.b;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PersonBarModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f54008i;
    public static TbHttpMessageTask j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f54009e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54010f;

    /* renamed from: g  reason: collision with root package name */
    public String f54011g;

    /* renamed from: h  reason: collision with root package name */
    public int f54012h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-130990770, "Lcom/baidu/tieba/personExtra/PersonBarModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-130990770, "Lcom/baidu/tieba/personExtra/PersonBarModel;");
                return;
            }
        }
        String str = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
        f54008i = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, str);
        j = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54009e = new b();
        this.f54010f = z;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f54012h == 1 && this.f54010f) {
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (str != null) {
                try {
                    a.f();
                    l<String> g2 = a.g("tb.my_pages");
                    if (g2 != null) {
                        g2.e(id, str, 604800000L);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54012h = i2;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f54011g = str;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54011g : (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }

    public b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54009e : (b) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54010f : invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.sendMessage(new PersonBarByUidLocalMessage());
        }
    }

    public void z(boolean z, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            if (!x()) {
                httpMessage.addParam(TiebaStatic.Params.FRIEND_UID, str);
                httpMessage.addParam("is_guest", String.valueOf(1));
                httpMessage.setExtra(str);
            }
            httpMessage.addParam("page_size", i3);
            httpMessage.addParam("page_no", i2);
            super.sendMessage(httpMessage);
        }
    }
}
