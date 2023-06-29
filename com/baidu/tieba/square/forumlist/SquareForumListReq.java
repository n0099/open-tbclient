package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.gx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetForumsFromForumClass.DataReq;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassReqIdl;
/* loaded from: classes7.dex */
public class SquareForumListReq extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int pageLimit;
    public int pageNum;
    public int pageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareForumListReq(int i, int i2, int i3) {
        super(CmdConfigHttp.CMD_SQUARE_FORUM_LIST, 309097);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageType = i;
        this.pageNum = i2;
        this.pageLimit = i3;
        if (i != 1 && i != 2) {
            this.pageType = 1;
        }
        if (this.pageNum <= 0) {
            this.pageNum = 1;
        }
        if (this.pageLimit < 10) {
            this.pageLimit = 10;
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                gx5.a(builder, true);
            }
            GetForumsFromForumClassReqIdl.Builder builder2 = new GetForumsFromForumClassReqIdl.Builder();
            builder.limit = Integer.valueOf(this.pageLimit);
            builder.pn = Integer.valueOf(this.pageNum);
            builder.type = Integer.valueOf(this.pageType);
            builder.q_type = 0L;
            builder.scr_dip = Double.valueOf(0.0d);
            builder.scr_h = 0;
            builder.scr_w = 0;
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
