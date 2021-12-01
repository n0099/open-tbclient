package com.baidu.tieba.personPolymeric.mode.message;

import c.a.d.f.p.l;
import c.a.q0.d1.z;
import c.a.q0.s.k;
import c.a.r0.s2.b;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personal.DataReq;
import tbclient.Personal.PersonalReqIdl;
/* loaded from: classes11.dex */
public class PersonPolymericReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int pn;
    public long uid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericReqMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC, 309408);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = Long.valueOf(this.uid);
            builder.pn = Integer.valueOf(this.pn);
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp()));
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp()));
            builder.q_type = Integer.valueOf(k.c().e());
            builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst().getApp()));
            if (z) {
                z.a(builder, true);
            }
            PersonalReqIdl.Builder builder2 = new PersonalReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public b getPersonCenterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (b) invokeV.objValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pn : invokeV.intValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.uid : invokeV.longValue;
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.pn = i2;
        }
    }

    public void setUid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.uid = j2;
        }
    }
}
