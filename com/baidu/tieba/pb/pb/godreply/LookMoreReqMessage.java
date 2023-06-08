package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.vi;
import com.baidu.tieba.ww5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetPostList.DataReq;
import tbclient.GetPostList.GetPostListReqIdl;
/* loaded from: classes7.dex */
public class LookMoreReqMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int is_comm_reverse;
    public Long kz;
    public List<Long> post_id;
    public int scr_h;
    public int scr_w;
    public int st_type;
    public int with_floor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookMoreReqMessage() {
        super(CmdConfigHttp.CMD_PB_GOD_MORE, 309446);
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
        setNetType(NetMessage.NetType.AUTO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                int l = vi.l(TbadkCoreApplication.getInst());
                int j = vi.j(TbadkCoreApplication.getInst());
                DataReq.Builder builder = new DataReq.Builder();
                builder.kz = this.kz;
                builder.with_floor = Integer.valueOf(this.with_floor);
                builder.post_id = this.post_id;
                builder.scr_w = Integer.valueOf(l);
                builder.scr_h = Integer.valueOf(j);
                builder.st_type = Integer.valueOf(this.st_type);
                builder.is_comm_reverse = Integer.valueOf(this.is_comm_reverse);
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    ww5.a(builder, true);
                }
                GetPostListReqIdl.Builder builder2 = new GetPostListReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setKz(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
            this.kz = l;
        }
    }

    public void setPost_id(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.post_id = list;
        }
    }

    public void setScr_h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.scr_h = i;
        }
    }

    public void setScr_w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.scr_w = i;
        }
    }

    public void setSt_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.st_type = i;
        }
    }

    public void setWith_floor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.with_floor = i;
        }
    }
}
