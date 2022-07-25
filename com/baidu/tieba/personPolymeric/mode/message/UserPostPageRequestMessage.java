package com.baidu.tieba.personPolymeric.mode.message;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ng;
import com.repackage.ud5;
import com.squareup.wire.Message;
import tbclient.User;
import tbclient.UserPost.DataReq;
import tbclient.UserPost.UserPostReqIdl;
/* loaded from: classes3.dex */
public class UserPostPageRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Long beginThreadId;
    public int from;
    @Nullable
    public Integer fromType;
    public boolean isHost;
    public boolean isReset;
    public boolean isThread;
    public int is_view_card;
    public PersonPostModel.c mCallback;
    public boolean needContent;
    public int pn;
    public String portrait;
    public int q_type;
    public int rn;
    public double scr_dip;
    public int scr_h;
    public int scr_w;
    public int sub_type;
    @Nullable
    public MetaData threadAuthor;
    public User threadUser;
    @Nullable
    public Integer type;
    public String uid;
    @Nullable
    public Integer workTabId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPostPageRequestMessage() {
        super(CmdConfigHttp.USER_POST_HTTP_CMD, 303002);
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
    }

    public PersonPostModel.c getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCallback : (PersonPostModel.c) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.from : invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pn : invokeV.intValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    @Nullable
    public MetaData getThreadAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.threadAuthor : (MetaData) invokeV.objValue;
    }

    public User getThreadUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.threadUser : (User) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isHost : invokeV.booleanValue;
    }

    public boolean isReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isReset : invokeV.booleanValue;
    }

    public boolean isThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isThread : invokeV.booleanValue;
    }

    public void setBeginThreadId(@Nullable Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l) == null) {
            this.beginThreadId = l;
        }
    }

    public void setCallback(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.mCallback = cVar;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.from = i;
        }
    }

    public void setFromType(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            this.fromType = num;
        }
    }

    public void setHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isHost = z;
        }
    }

    public void setNeedContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.needContent = z;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.pn = i;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setReset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isReset = z;
        }
    }

    public void setRn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.rn = i;
        }
    }

    public void setThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.isThread = z;
        }
    }

    public void setThreadAuthor(@Nullable MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, metaData) == null) {
            this.threadAuthor = metaData;
        }
    }

    public void setThreadUser(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, user) == null) {
            this.threadUser = user;
        }
    }

    public void setType(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, num) == null) {
            this.type = num;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.uid = str;
        }
    }

    public void setWorkTabId(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, num) == null) {
            this.workTabId = num;
        }
    }

    public void set_is_view_card(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.is_view_card = i;
        }
    }

    public void set_q_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.q_type = i;
        }
    }

    public void set_scr_dip(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Double.valueOf(d)}) == null) {
            this.scr_dip = d;
        }
    }

    public void set_scr_h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.scr_h = i;
        }
    }

    public void set_scr_w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.scr_w = i;
        }
    }

    public void set_sub_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.sub_type = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = Long.valueOf(ng.g(this.uid, 0L));
            builder.portrait = this.portrait;
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            builder.is_thread = Integer.valueOf(this.isThread ? 1 : 0);
            builder.need_content = Integer.valueOf(this.needContent ? 1 : 0);
            builder.scr_dip = Double.valueOf(this.scr_dip);
            builder.q_type = Integer.valueOf(this.q_type);
            builder.scr_h = Integer.valueOf(this.scr_h);
            builder.scr_w = Integer.valueOf(this.scr_w);
            builder.subtype = Integer.valueOf(this.sub_type);
            builder.is_view_card = Integer.valueOf(this.is_view_card);
            Integer num = this.workTabId;
            if (num != null) {
                builder.work_tab_id = num;
            }
            Integer num2 = this.type;
            if (num2 != null) {
                builder.type = num2;
            }
            Integer num3 = this.fromType;
            if (num3 != null) {
                builder.from_type = num3;
            }
            Long l = this.beginThreadId;
            if (l != null) {
                builder.begin_thread_id = l;
            }
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                ud5.a(builder, true);
            }
            UserPostReqIdl.Builder builder2 = new UserPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return (Message) invokeZ.objValue;
    }
}
