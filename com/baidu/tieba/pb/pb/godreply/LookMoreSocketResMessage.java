package com.baidu.tieba.pb.pb.godreply;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zfa;
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
/* loaded from: classes7.dex */
public class LookMoreSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<zfa> list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookMoreSocketResMessage() {
        super(309446);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        List<Post> list;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetPostListResIdl getPostListResIdl = (GetPostListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPostListResIdl.class);
            if (getPostListResIdl != null && (error = getPostListResIdl.error) != null) {
                setError(error.errorno.intValue());
                setErrorString(getPostListResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return getPostListResIdl;
            }
            if (getPostListResIdl != null && (dataRes = getPostListResIdl.data) != null && (list = dataRes.post_list) != null && list.size() > 0) {
                for (Post post : list) {
                    zfa zfaVar = new zfa();
                    zfaVar.H0(post);
                    zfaVar.O = 102;
                    this.list.add(zfaVar);
                }
            }
            return getPostListResIdl;
        }
        return invokeIL.objValue;
    }

    public List<zfa> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.list;
        }
        return (List) invokeV.objValue;
    }
}
