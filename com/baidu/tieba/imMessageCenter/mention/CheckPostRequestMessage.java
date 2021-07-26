package com.baidu.tieba.imMessageCenter.mention;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.w;
import tbclient.CheckPost.CheckPostReqIdl;
import tbclient.CheckPost.ReqData;
/* loaded from: classes4.dex */
public class CheckPostRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumName;
    public String ori_ugc_nid;
    public String ori_ugc_tid;
    public int ori_ugc_type;
    public String ori_ugc_vid;
    public long pid;
    public int postType;
    public long tid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckPostRequestMessage() {
        super(CmdConfigHttp.CMD_CHECK_POST, 303010);
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
        this.ori_ugc_type = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            ReqData.Builder builder = new ReqData.Builder();
            builder.pid = Long.valueOf(getPid());
            builder.postType = Integer.valueOf(getPostType());
            builder.forumName = getForumName();
            builder.tid = Long.valueOf(this.tid);
            builder.ori_ugc_type = Integer.valueOf(this.ori_ugc_type);
            builder.ori_ugc_tid = this.ori_ugc_tid;
            builder.ori_ugc_nid = this.ori_ugc_nid;
            builder.ori_ugc_vid = this.ori_ugc_vid;
            if (z) {
                w.a(builder, true);
            }
            CheckPostReqIdl.Builder builder2 = new CheckPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public long getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pid : invokeV.longValue;
    }

    public int getPostType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.postType : invokeV.intValue;
    }

    public long getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tid : invokeV.longValue;
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setPid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.pid = j;
        }
    }

    public void setPostType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.postType = i2;
        }
    }

    public void setTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.tid = j;
        }
    }
}
