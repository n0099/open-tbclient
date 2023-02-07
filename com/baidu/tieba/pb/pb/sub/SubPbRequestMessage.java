package com.baidu.tieba.pb.pb.sub;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbFloor.DataReq;
import tbclient.PbFloor.PbFloorReqIdl;
/* loaded from: classes5.dex */
public class SubPbRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public int is_comm_reverse;
    public long kz;
    public String oriUgcNid;
    public String oriUgcTid;
    public String oriUgcTopPid;
    public int oriUgcType;
    public String oriUgcVid;
    public long pid;
    public int pn;
    public double scr_dip;
    public int scr_h;
    public int scr_w;
    public long spid;
    public String stType;
    public boolean treatDelPage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbRequestMessage(long j, long j2, long j3, int i, int i2, int i3, double d, String str, int i4) {
        super(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d), str, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.kz = j;
        this.pid = j2;
        this.spid = j3;
        this.pn = i;
        this.scr_w = i2;
        this.scr_h = i3;
        this.scr_dip = d;
        this.stType = str;
        this.is_comm_reverse = i4;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.kz = Long.valueOf(this.kz);
            builder.pid = Long.valueOf(this.pid);
            builder.spid = Long.valueOf(this.spid);
            builder.pn = Integer.valueOf(this.pn);
            builder.scr_w = Integer.valueOf(this.scr_w);
            builder.scr_h = Integer.valueOf(this.scr_h);
            builder.scr_dip = Double.valueOf(this.scr_dip);
            builder.st_type = this.stType;
            builder.is_comm_reverse = Integer.valueOf(this.is_comm_reverse);
            builder.ori_ugc_nid = this.oriUgcNid;
            builder.ori_ugc_tid = this.oriUgcTid;
            builder.ori_ugc_type = Integer.valueOf(this.oriUgcType);
            builder.ori_ugc_vid = this.oriUgcVid;
            builder.top_ugc_pid = this.oriUgcTopPid;
            builder.forum_id = Long.valueOf(this.forumId);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                yo5.a(builder, true);
            }
            PbFloorReqIdl.Builder builder2 = new PbFloorReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public boolean isTreatDelPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.treatDelPage;
        }
        return invokeV.booleanValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setOriUgcNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.oriUgcNid = str;
        }
    }

    public void setOriUgcTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.oriUgcTid = str;
        }
    }

    public void setOriUgcTopPid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.oriUgcTopPid = str;
        }
    }

    public void setOriUgcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.oriUgcType = i;
        }
    }

    public void setOriUgcVid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.oriUgcVid = str;
        }
    }

    public void setTreatDelPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.treatDelPage = z;
        }
    }
}
