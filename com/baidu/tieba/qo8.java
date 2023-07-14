package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qo8 extends po8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948098671, "Lcom/baidu/tieba/qo8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948098671, "Lcom/baidu/tieba/qo8;");
                return;
            }
        }
        f = BdUniqueId.gen().getId();
    }

    @Override // com.baidu.tieba.po8, com.baidu.tieba.lp8
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return f;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo8(BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO) {
        super(itemsDTO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {itemsDTO};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BotsDTO.BotListDTO.SkillDTO.ItemsDTO) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = this.c;
            if (optsDTO == null || optsDTO.getExt() == null) {
                return false;
            }
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = this.c.getExt();
            if (StringUtils.isNull(ext.getPicPath()) || StringUtils.isNull(ext.getPicSize())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e = z;
        }
    }

    public void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.c != null) {
            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = new BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext();
            ext.setPicPath(str);
            ext.setPicSize(str2);
            this.c.setExt(ext);
        }
    }
}
