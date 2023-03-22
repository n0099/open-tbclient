package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.hi;
import com.baidu.tieba.kp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Lego.DataReq;
import tbclient.Lego.LegoReqIdl;
/* loaded from: classes5.dex */
public class LegoPageRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String itemId;
    public String lastRank;
    public int pageType;
    public String params;
    public int pn;
    public int rn;
    public long tagCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoPageRequest() {
        super(CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rn = 30;
        this.tagCode = 0L;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                kp5.a(builder, true);
            }
            builder.page_type = Integer.valueOf(this.pageType);
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            builder.scr_w = Integer.valueOf(hi.l(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(hi.j(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(hi.i(TbadkCoreApplication.getInst()));
            if (!TextUtils.isEmpty(this.params)) {
                builder.params = this.params;
            }
            builder.flip_id = this.lastRank;
            if (!TextUtils.isEmpty(this.itemId)) {
                builder.item_id = this.itemId;
            }
            long j = this.tagCode;
            if (j != 0) {
                builder.page_id = Long.valueOf(j);
            }
            LegoReqIdl.Builder builder2 = new LegoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public String getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.itemId;
        }
        return (String) invokeV.objValue;
    }

    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pageType;
        }
        return invokeV.intValue;
    }

    public String getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.params;
        }
        return (String) invokeV.objValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.pn;
        }
        return invokeV.intValue;
    }

    public long getTagCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.tagCode;
        }
        return invokeV.longValue;
    }

    public void setItemId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.itemId = str;
        }
    }

    public void setLastRank(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.lastRank = str;
        }
    }

    public void setPageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.pageType = i;
        }
    }

    public void setParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.params = str;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.pn = i;
        }
    }

    public void setRn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.rn = i;
        }
    }

    public void setTagCode(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.tagCode = j;
        }
    }
}
