package com.baidu.tieba.pb.pb.godreply;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.bc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPostList.DataRes;
import tbclient.GetPostList.GetPostListResIdl;
import tbclient.Post;
/* loaded from: classes5.dex */
public class LookMoreHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bc9> list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookMoreHttpResMessage() {
        super(CmdConfigHttp.CMD_PB_GOD_MORE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.list = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        List<Post> list;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetPostListResIdl getPostListResIdl = (GetPostListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPostListResIdl.class);
            if (getPostListResIdl != null && (error = getPostListResIdl.error) != null) {
                setError(error.errorno.intValue());
                setErrorString(getPostListResIdl.error.usermsg);
            }
            if (getError() == 0 && getPostListResIdl != null && (dataRes = getPostListResIdl.data) != null && (list = dataRes.post_list) != null && list.size() > 0) {
                for (Post post : list) {
                    bc9 bc9Var = new bc9();
                    bc9Var.A0(post);
                    bc9Var.O = 102;
                    this.list.add(bc9Var);
                }
            }
        }
    }

    public List<bc9> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.list;
        }
        return (List) invokeV.objValue;
    }
}
