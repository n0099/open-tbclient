package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.DataReq;
import UserPost.UserPostReqIdl;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.q0.d1.x;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import tbclient.User;
/* loaded from: classes7.dex */
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

    @Nullable
    public MetaData getThreadAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.threadAuthor : (MetaData) invokeV.objValue;
    }

    public User getThreadUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.threadUser : (User) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isHost : invokeV.booleanValue;
    }

    public boolean isReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isReset : invokeV.booleanValue;
    }

    public boolean isThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isThread : invokeV.booleanValue;
    }

    public void setBeginThreadId(@Nullable Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l) == null) {
            this.beginThreadId = l;
        }
    }

    public void setCallback(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.mCallback = cVar;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.from = i2;
        }
    }

    public void setFromType(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.fromType = num;
        }
    }

    public void setHost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.isHost = z;
        }
    }

    public void setNeedContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.needContent = z;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.pn = i2;
        }
    }

    public void setReset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.isReset = z;
        }
    }

    public void setRn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.rn = i2;
        }
    }

    public void setThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isThread = z;
        }
    }

    public void setThreadAuthor(@Nullable MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, metaData) == null) {
            this.threadAuthor = metaData;
        }
    }

    public void setThreadUser(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, user) == null) {
            this.threadUser = user;
        }
    }

    public void setType(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, num) == null) {
            this.type = num;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.uid = str;
        }
    }

    public void setWorkTabId(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, num) == null) {
            this.workTabId = num;
        }
    }

    public void set_is_view_card(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.is_view_card = i2;
        }
    }

    public void set_q_type(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.q_type = i2;
        }
    }

    public void set_scr_dip(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.scr_dip = d2;
        }
    }

    public void set_scr_h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.scr_h = i2;
        }
    }

    public void set_scr_w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.scr_w = i2;
        }
    }

    public void set_sub_type(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.sub_type = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.uid = Long.valueOf(b.g(this.uid, 0L));
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
            if (z) {
                x.a(builder, true);
            }
            UserPostReqIdl.Builder builder2 = new UserPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return (Message) invokeZ.objValue;
    }
}
