package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.UserPostResIdl;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.User;
/* loaded from: classes9.dex */
public class UserPostPageHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int from;
    public boolean isHost;
    public int page;
    public PersonPostModel personPostModel;
    @Nullable
    public MetaData threadAuthor;
    public User threadUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPostPageHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public PersonPostModel getPersonPostModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.personPostModel : (PersonPostModel) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            super.setOrginalMessage(message);
            if (message.getExtra() instanceof UserPostPageRequestMessage) {
                UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) message.getExtra();
                this.isHost = userPostPageRequestMessage.isHost();
                this.page = userPostPageRequestMessage.getPn();
                this.from = userPostPageRequestMessage.getFrom();
                this.threadUser = userPostPageRequestMessage.getThreadUser();
                this.threadAuthor = userPostPageRequestMessage.getThreadAuthor();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            PersonPostModel personPostModel = new PersonPostModel(null, null, this.isHost, this.from);
            this.personPostModel = personPostModel;
            UserPostResIdl parseProtobuf = personPostModel.parseProtobuf(bArr, this.page, this.threadUser, this.threadAuthor);
            setError(parseProtobuf.error.errorno.intValue());
            setErrorString(parseProtobuf.error.usermsg);
            this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
            this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
        }
    }
}
